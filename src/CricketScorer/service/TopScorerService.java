package CricketScorer.service;

import CricketScorer.model.PlayerRecord;
import CricketScorer.model.TopScorer;

import java.util.*;

public class TopScorerService implements StatsObserver{
    private int count;
    private StatsPublisher publisher;
    private HashMap<Integer, List<String>> map = new HashMap<>();
    private PriorityQueue<Integer> topScorers = new PriorityQueue<>();

    public TopScorerService() {
    }

    public TopScorerService(int count, StatsPublisher publisher) {
        this.count = count;
        this.publisher = publisher;
    }

    @Override
    public void update(){
        updateTopScorers();
    }

    public void updateTopScorers() {
        PlayerRecord record = publisher.getRecords();
        int score = record.getScore();
        String player = record.getPlayer().getName();

        if(map.containsKey(score)){
            List<String> playerList = map.get(score);
            if(!playerList.contains(player)){
                playerList.add(player);
            }
            map.put(score, playerList);
        }
        else{
            List<String> list = new ArrayList<>();
            list.add(player);
            map.put(score, list);
        }
        if(topScorers.size() < count){
             if(!topScorers.contains(score)){
                 topScorers.add(score);
             }
        }
        else{
             if(score >= topScorers.peek() && (!topScorers.contains(score))){
                 topScorers.poll();
                 topScorers.add(score);
             }
        }
    }

    public List<TopScorer> getTopPlayers(){
        List<TopScorer> list = new ArrayList<>();
        Iterator itr = topScorers.iterator();
        while(itr.hasNext()){
            int score = (Integer)itr.next();
            List<String> players = map.get(score);
            TopScorer obj = new TopScorer(score, players);
            list.add(obj);
        }
        Collections.sort(list, (TopScorer first, TopScorer second) -> first.getScore() - second.getScore());
        return list;
    }

    public HashMap<Integer, List<String>> getMap() {
        return map;
    }

    public PriorityQueue<Integer> getTopScorers() {
        return topScorers;
    }

}
