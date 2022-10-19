package NFT_Exchange.model;

import java.util.List;

public class Artist extends Person{
    List<String> artworks;

    public Artist(String id, String name, int walletAmount) {
        super(id, name, walletAmount);
    }
}
