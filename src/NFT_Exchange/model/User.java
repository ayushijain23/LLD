package NFT_Exchange.model;

import java.util.List;

public class User extends Person{
    List<Order> buysOrder;
    List<Order> sellOrder;

    public User(String id, String name, int walletAmount) {
        super(id, name, walletAmount);
    }

}
