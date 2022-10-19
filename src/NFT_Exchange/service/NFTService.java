package NFT_Exchange.service;



import NFT_Exchange.model.NFT;

import java.util.ArrayList;
import java.util.List;

public class NFTService {
    static List<NFT> nftList = new ArrayList<>();

    public static void persistNFT(NFT nft){
        nftList.add(nft);
        int walletmoney = nft.getArtistOfNFT().getWalletMoney();
        nft.getArtistOfNFT().setWalletMoney(walletmoney - 100);
        int exchangeWallet = ExchangeService.exchangeList.get(0).getWalletMoney();
        ExchangeService.exchangeList.get(0).setWalletMoney(exchangeWallet + 100);
    }

    public static NFT findNFTById(String id){
        for(NFT nft : nftList){
            if(nft.getNftId().equals(id)){
                return nft;
            }
        }
        return null;
    }

    public static void listofAllNFTs(){
        for(NFT nft : nftList){
            System.out.println(nft.getNftId()+" "+nft.getArtistOfNFT().getName()+" "+ nft.getSellingPrice());
        }
    }
}
