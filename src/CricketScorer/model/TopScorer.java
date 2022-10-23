package CricketScorer.model;

import java.util.List;

public class TopScorer {
    private int score;
    private List<String> playerNames;

    public TopScorer(int score, List<String> playerNames) {
        this.score = score;
        this.playerNames = playerNames;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public void setPlayerNames(List<String> playerNames) {
        this.playerNames = playerNames;
    }
}
