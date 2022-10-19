package snakeAndLader.src.model;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    private int count;

    public Dice(int count){
        this.count = count;
    }


    public int rollDice(){
        int dices = count;
        int total = 0;
        while(dices-- > 0){
//            int min = 1;
//            int max = count * 6;
//            total+= ThreadLocalRandom.current().nextInt(min, max + 1);
            total+= ThreadLocalRandom.current().nextInt(1, 7);
        }
        return total;

    }
}
