package CricketScorer.service;

import CricketScorer.model.PlayerRecord;
import java.util.ArrayList;
import java.util.List;


public class ScorePublisher implements StatsPublisher{
    private List<StatsObserver> observersList;
    private PlayerRecord playerRecord;

    public ScorePublisher() {
        observersList = new ArrayList<>();
    }

    @Override
    public void subscribe(StatsObserver obs) {
        observersList.add(obs);
    }

    @Override
    public void unsubscribe(StatsObserver obs) {
        observersList.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for(StatsObserver observer : observersList){
            observer.update();
        }
    }

    public void addRecord(PlayerRecord playerRecord) {
       this.playerRecord = playerRecord;
       notifyObservers();
    }

    @Override
    public PlayerRecord getRecords() {
       return playerRecord;
    }

    public List<StatsObserver> getObserversList() {
        return observersList;
    }

    public PlayerRecord getPlayerRecord() {
        return playerRecord;
    }
}
