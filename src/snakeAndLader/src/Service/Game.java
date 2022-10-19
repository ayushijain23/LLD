package snakeAndLader.src.Service;

import snakeAndLader.src.model.*;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    Board board;
    Deque<Player>players;
    Dice dice;
    Player winner;

    public Game(int boardSize, int diceCount){
        initialiseGame(boardSize, diceCount );
    }

    public void initialiseGame(int boardSize, int diceCount){
        winner = null;
        dice = new Dice(diceCount);
        board = new Board(boardSize);
        players = new LinkedList<>();
      //  prepareGame();
    }

    public void prepareGame(){
        Scanner kb = new Scanner(System.in);
        int snakeCount = kb.nextInt();
        kb.nextLine();
        while(snakeCount-- > 0){
            String snake = kb.nextLine();
            String str[] = snake.split("\\s");
            int start = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);
            addSnakeOrLadder(start, end);
        }

        int ladderCount = kb.nextInt();
        kb.nextLine();
        while(ladderCount-- > 0){
            String ladder = kb.nextLine();
            String str[] = ladder.split("\\s");
            int start = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);
            addSnakeOrLadder(start, end);
        }

        int players = kb.nextInt();
        while(players-- > 0){
            String player = kb.next();
            addPlayer(player);
        }
    }

    public void addSnakeOrLadder(int start, int end){
        Jump jump = new Jump(start, end);
        Cell cell = board.getCell(start);
        cell.setJump(jump);
    }

    public void addPlayer(String name){
        Player pp = new Player(name, 0);
        players.add(pp);
    }

    public Player start(){
          while(winner == null){
              Player player = players.removeFirst();
             // System.out.println(player.getName() +" is at:"+ player.getCurrentPosition());
              int diceNumber = dice.rollDice();
              int currentPosition = player.getCurrentPosition();
              int newPosition = currentPosition + diceNumber;
              newPosition = checkJump(newPosition);
              player.setCurrentPosition(newPosition);

              if(newPosition >= board.getSize() * board.getSize()){
                  winner = player;
              }
            //  <player_name> rolled a <dice_value> and moved from <initial_position> to <final_position>
              System.out.println(player.getName()+" rolled a "+diceNumber+" and moved from "+currentPosition+" to "+newPosition);
              players.addLast(player);
          }

          return winner;
    }

    private int checkJump(int position){
        if(position >= board.getSize() * board.getSize()){
            return position;
        }

        Cell newCell = board.getCell(position);
        if(newCell != null){
            if(newCell.getJump() != null && newCell.getJump().getStart() == position){
                return newCell.getJump().getEnd();
            }
        }
        return position;
    }
}
