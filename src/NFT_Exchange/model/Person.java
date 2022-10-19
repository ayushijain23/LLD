package NFT_Exchange.model;

public class Person {
    private String id;
    private String name;
    private int walletMoney;

    public Person(){

    }

    public Person(String id, String name, int walletMoney) {
        this.id = id;
        this.name = name;
        this.walletMoney = walletMoney;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWalletMoney() {
        return walletMoney;
    }

    public void setWalletMoney(int walletMoney) {
        this.walletMoney = walletMoney;
    }
}
