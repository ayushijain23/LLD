package snakeAndLader.src;

import snakeAndLader.src.Service.Game;
import snakeAndLader.src.model.*;
import java.io.*;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        Game game = new Game(10, 1);
        File file = new File("/Users/ayushi/Desktop/Preparation/MachineCoding/Snake&Ladder/src/input.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = "";
            try {
                while((str = br.readLine()) != null){
                    String ss[] = str.split(" ");
                    if(ss.length == 2){
                            int start = Integer.parseInt(ss[0]);
                            int end = Integer.parseInt(ss[1]);
                            game.addSnakeOrLadder(start, end);
                        }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        int snakeCount = kb.nextInt();
//        kb.nextLine();
//        while(snakeCount-- > 0){
//            String snake = kb.nextLine();
//            String str[] = snake.split("\\s");
//            int start = Integer.parseInt(str[0]);
//            int end = Integer.parseInt(str[1]);
//            game.addSnakeOrLadder(start, end);
//        }
//
//        int ladderCount = kb.nextInt();
//        kb.nextLine();
//        while(ladderCount-- > 0){
//            String ladder = kb.nextLine();
//            String str[] = ladder.split("\\s");
//            int start = Integer.parseInt(str[0]);
//            int end = Integer.parseInt(str[1]);
//            game.addSnakeOrLadder(start, end);
//        }
//
        Scanner kb = new Scanner(System.in);
        int players = kb.nextInt();
        while(players-- > 0){
            String player = kb.next();
            game.addPlayer(player);
        }
        Player winner = game.start();
        System.out.println("And The Winner is --"+ winner.getName());
    }
}
