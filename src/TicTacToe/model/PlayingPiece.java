package TicTacToe.model;

public class PlayingPiece {
    PieceType type;
    PlayingPiece(PieceType pieceType){
        type = pieceType;
    }

    public PieceType getType() {
        return type;
    }

    public void setType(PieceType type) {
        this.type = type;
    }
}
