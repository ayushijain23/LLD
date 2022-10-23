package CricketScorer.service;

import CricketScorer.model.*;

public interface StatsPublisher {
    public void subscribe(StatsObserver obs);
    public void unsubscribe(StatsObserver obs);
    public void notifyObservers();
    public void addRecord(PlayerRecord playerRecord);
    public PlayerRecord getRecords();
}
