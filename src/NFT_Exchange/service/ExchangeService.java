package NFT_Exchange.service;


import NFT_Exchange.model.*;

import java.util.ArrayList;
import java.util.List;

public class ExchangeService {
    static List<Exchange> exchangeList = new ArrayList<>();

    public static  void registerExchange(Exchange exchange){
        exchangeList.add(exchange);
    }

    public static void registerNFT(String nftId, String sellerId, int sellingPrice){

       NFT nftcreated = NFTService.findNFTById(nftId);
       Person seller = UserService.getPersonById(sellerId);
       nftcreated.setSellingPrice(sellingPrice);
       nftcreated.setSeller(seller);
       Exchange exchange = exchangeList.get(0);
       List<NFT> nftcretaedList = exchange.getAllNFTs();

       if(nftcretaedList == null){
           List<NFT> list = new ArrayList<>();
           list.add(nftcreated);
           exchange.setAllNFTs(list);
       }
       else{
           List<NFT>list1 = exchange.getAllNFTs();
           if(list1.contains(nftcreated)){
               for(NFT nftnew : list1){
                   if(nftnew.getNftId() == nftcreated.getNftId()){
                       nftnew.setSeller(seller);
                       nftnew.setSellingPrice(sellingPrice);
                   }
               }
           }
           else{
               exchange.setAllNFTs(list1);
           }

       }

    }

    public static String buyNFT(String buyerId, int buyingPrice, String nftId){
        NFT nftToBuy = NFTService.findNFTById(nftId);
        Person buyer = UserService.getPersonById(buyerId);
        int sp = nftToBuy.getSellingPrice();
        int exchangeCommision = (int)(sp * 0.1);
        Exchange exchange = exchangeList.get(0);


        if(buyingPrice >= sp && buyer.getWalletMoney() >= buyingPrice + exchangeCommision){
            buyer.setWalletMoney(buyer.getWalletMoney() - sp - exchangeCommision);
            exchange.setWalletMoney(exchange.getWalletMoney() + 2 * exchangeCommision);
            if(nftToBuy.getRoyalty() != 0){
                Person artist = UserService.getPersonById(nftToBuy.getArtistOfNFT().getId());
                artist.setWalletMoney(artist.getWalletMoney() + (nftToBuy.getRoyalty() * sp) / 100);
                buyer.setWalletMoney(buyer.getWalletMoney() - (nftToBuy.getRoyalty() * sp)/100);
            }
            Person seller = nftToBuy.getSeller();
            seller.setWalletMoney(seller.getWalletMoney() + sp - exchangeCommision);

            return "NFT buy done";
        }

        return "this buy not possible";
    }

    public static void getAllExchanges(){
        for(Exchange ex : exchangeList){
            System.out.println("Exchange Id is-"+ex.getExchangeId()+" And wallet Amount is :"+ ex.getWalletMoney());
        }
    }

    public static void allexchangeNFTs(){
        for(Exchange ex : exchangeList){
            List<NFT>nftList = ex.getAllNFTs();
            for(NFT nft : nftList){
                System.out.println("NFT id:"+nft.getNftId()+" & Artist:"+nft.getArtistOfNFT().getName()+" & ArtWork:"+nft.getArtWork()
                        +" & Selling Price:"+nft.getSellingPrice());
            }
        }
    }

}
