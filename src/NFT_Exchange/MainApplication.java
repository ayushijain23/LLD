package NFT_Exchange;


import NFT_Exchange.model.*;
import NFT_Exchange.service.*;

public class MainApplication {
    public static void main(String[] args) {
        System.out.println("Create Echange first");

        Exchange exchange = new Exchange("Ex1", 0);
        ExchangeService.registerExchange(exchange);

        System.out.println("Create Artist Now");
        Artist artist = new Artist("A", "Ajay", 1000);
        UserService.registerArtist(artist);

        System.out.println("create user Now");
        User user = new User("B", "Rahul", 2000);
        UserService.registerUser(user);

        System.out.println("Create NFT");
        Person artistforNFT = UserService.getPersonById("A");
        NFT nft = new NFT("1", "paitingArt", 5, artistforNFT);
        NFTService.persistNFT(nft);

        System.out.println("Placing sell order for NFT");
        String sellerId = "A";
        int sellingPrice = 1000;
        String nftId = "1";

        ExchangeService.registerNFT(nftId, sellerId, sellingPrice);

        System.out.println("Now buying NFT");
        String buyerId = "B";
        int buyingPrice = 1000;
        nftId = "1";

        String resultOfbuy = ExchangeService.buyNFT(buyerId, buyingPrice, nftId);
        System.out.println(resultOfbuy);

        System.out.println("List all NFTs");
        NFTService.listofAllNFTs();

        System.out.println("List all users");
        ExchangeService.getAllExchanges();
        UserService.getAllUsers();

        System.out.println("Place second Order");
         sellerId = "B";
         sellingPrice = 2000;
         nftId = "1";
        ExchangeService.registerNFT(nftId, sellerId, sellingPrice);
        ExchangeService.allexchangeNFTs();
    }
}
