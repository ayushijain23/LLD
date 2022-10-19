package TicTacToe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private PlayingPiece[][] board ;

    public Board(int n){
        size = n;
        board = new PlayingPiece[size][size];
    }

    public boolean addInBoard(int row, int col, PlayingPiece playingPiece) {
        if(board[row][col] != null){
            return false;
        }
        board[row][col] = playingPiece;
        return true;
    }

    public List<PlayingPiece> getFreeSpace(){
        List<PlayingPiece> list = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == null){
                    list.add(board[i][j]);
                }
            }
        }
        return list;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public PlayingPiece[][] getBoard() {
        return board;
    }

    public void setBoard(PlayingPiece[][] board) {
        this.board = board;
    }

}
