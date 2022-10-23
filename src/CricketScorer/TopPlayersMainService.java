package CricketScorer;


import CricketScorer.model.Player;
import CricketScorer.model.PlayerRecord;
import CricketScorer.model.TopScorer;
import CricketScorer.service.ScorePublisher;
import CricketScorer.service.StatsPublisher;
import CricketScorer.service.TopScorerService;

import java.io.*;
import java.util.List;


public class TopPlayersMainService {

    public static void main(String[] args) {
        StatsPublisher publisher = new ScorePublisher();
        TopScorerService topScorerService = new TopScorerService(5, publisher);
        publisher.subscribe(topScorerService);

        File inputFile = new File("/Users/ayushi/Desktop/Preparation/LowLevelDesign/src/CricketScorer/input.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String str = "";
            try {
                while((str = br.readLine()) != null){
                    String input[] = str.split(" ");
                    if(input.length == 6){
                        String id = input[0];
                        String playerName  = input[1];
                        int age = Integer.parseInt(input[2]);
                        String gender = input[3];
                        String country = input[4];
                        int score = Integer.parseInt(input[5]);
                        Player player = new Player(id, playerName, age, gender, country);
                        PlayerRecord playerRecord = new PlayerRecord(player, score);
                        publisher.addRecord(playerRecord);
                    }

                }
            } catch (IOException e) {
                e.getMessage();
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        }

        List<TopScorer> list = topScorerService.getTopPlayers();
        if(list.size() == 0){
            System.out.println("No records found");
        }
        for(TopScorer scorers : list){
            int score = scorers.getScore();
            System.out.print(score+"-> ");
            for(String playerName : scorers.getPlayerNames()){
                System.out.print(playerName+" ");
            }
            System.out.println();
        }
    }
}
