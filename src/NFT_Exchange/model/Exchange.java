package NFT_Exchange.model;

import java.util.List;

public class Exchange {
    String exchangeId;
    int walletMoney;
    List<NFT> allNFTs;

    public Exchange(String exchangeId, int walletMoney) {
        this.exchangeId = exchangeId;
        this.walletMoney = walletMoney;
    }

    public String getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    public int getWalletMoney() {
        return walletMoney;
    }

    public void setWalletMoney(int walletMoney) {
        this.walletMoney = walletMoney;
    }

    public List<NFT> getAllNFTs() {
        return allNFTs;
    }

    public void setAllNFTs(List<NFT> allNFTs) {
        this.allNFTs = allNFTs;
    }
}
