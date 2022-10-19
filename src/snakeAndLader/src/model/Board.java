package snakeAndLader.src.model;

public class Board {
    private int size;
    private Cell box[][];

    public Board(int size){
        this.size = size;
        setBoard();
    }

    public void setBoard(){
        box = new Cell[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                Cell cell = new Cell();
                box[i][j] = cell;
            }
        }
    }

    public Cell getCell(int position){
        int row = position / size;
        int col = position % size;
        return box[row][col];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Cell[][] getBox() {
        return box;
    }

    public void setBox(Cell[][] box) {
        this.box = box;
    }


}
