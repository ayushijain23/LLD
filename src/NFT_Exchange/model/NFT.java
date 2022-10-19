package NFT_Exchange.model;


public class NFT {
    String nftId;
    String artWork;
    int buyingPrice;
    int sellingPrice;
    int royalty;

    Person buyer;
    Person seller;
    Person artistOfNFT;

    public NFT(String nftId, String artWork, int royalty, Person artistOfNFT) {
        this.nftId = nftId;
        this.artWork = artWork;
        this.royalty = royalty;
        this.artistOfNFT = artistOfNFT;
    }

    public String getNftId() {
        return nftId;
    }

    public void setNftId(String nftId) {
        this.nftId = nftId;
    }

    public String getArtWork() {
        return artWork;
    }

    public void setArtWork(String artWork) {
        this.artWork = artWork;
    }

    public int getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(int buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getRoyalty() {
        return royalty;
    }

    public void setRoyalty(int royalty) {
        this.royalty = royalty;
    }

    public Person getBuyer() {
        return buyer;
    }

    public void setBuyer(Person buyer) {
        this.buyer = buyer;
    }

    public Person getSeller() {
        return seller;
    }

    public void setSeller(Person seller) {
        this.seller = seller;
    }

    public Person getArtistOfNFT() {
        return artistOfNFT;
    }

    public void setArtistOfNFT(Artist artistOfNFT) {
        this.artistOfNFT = artistOfNFT;
    }
}
