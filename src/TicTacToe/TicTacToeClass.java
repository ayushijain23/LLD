package TicTacToe;

import TicTacToe.model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeClass {
    static Deque<Player>players;
    static Board gameBoard;

    TicTacToeClass(int n){
        initialiseGame(n);
    }

    public static void initialiseGame(int n){
        players = new LinkedList<>();
        PlayingPiece playingPieceFirst = new PlayingPieceX();
        PlayingPiece playingPieceSecond = new PlayingPieceO();
        Player playerOne = new Player("First", playingPieceFirst);
        Player playerTwo = new Player("Second", playingPieceSecond);
        players.add(playerOne);
        players.add(playerTwo);

        gameBoard = new Board(n);
    }

    public static String startGame(){
       boolean winner = true;
       Scanner kb = new Scanner(System.in);
       while(winner){
           Player currentPlayer = players.removeFirst();
           System.out.println(currentPlayer.getName() +" play your turn");
           String input = kb.nextLine();
           String rowsCols[] = input.split(",");
           int row = Integer.parseInt(rowsCols[0]);
           int col = Integer.parseInt(rowsCols[1]);

           boolean isAdded = gameBoard.addInBoard(row, col, currentPlayer.getPlayingPiece());
           if(!isAdded){
               System.out.println("Invalid input, try again");
               players.addFirst(currentPlayer);
               continue;
           }
           else{
               boolean checkWinner = isWinnerFound(row, col, currentPlayer.getPieceType());
               if(checkWinner){
                   System.out.println("Winner is :"+ currentPlayer.getName());
                   return currentPlayer.getName();
               }
               players.addLast(currentPlayer);
               List<PlayingPiece> list = gameBoard.getFreeSpace();
               if(list.isEmpty()){
                   System.out.println("Baord is Full now");
                   winner = false;
                   continue;
               }
           }
       }
       return "Tie";
    }

    private static boolean isWinnerFound(int row, int col, PieceType pieceType){
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for(int i = 0; i < gameBoard.getSize(); i++){
             if(gameBoard.getBoard()[i][col] == null || gameBoard.getBoard()[i][col].getType() != pieceType){
                 rowMatch =  false;
             }
         }

        for(int j = 0; j < gameBoard.getSize(); j++){
            if(gameBoard.getBoard()[row][j] == null  || gameBoard.getBoard()[row][j].getType() != pieceType){
                columnMatch = false;
            }
        }
        for(int i =0, j = 0; i < gameBoard.getSize() && j < gameBoard.getSize(); i++, j++){
            if(gameBoard.getBoard()[i][j] == null || gameBoard.getBoard()[i][j].getType() != pieceType){
                diagonalMatch = false;
            }
        }

        for(int i = gameBoard.getSize() - 1, j = 0; i >= 0 && j < gameBoard.getSize(); i--, j++){
            if(gameBoard.getBoard()[i][j] == null || gameBoard.getBoard()[i][j].getType() != pieceType){
                antiDiagonalMatch =  false;
            }
        }
        return rowMatch || columnMatch|| diagonalMatch || antiDiagonalMatch;
    }


}
