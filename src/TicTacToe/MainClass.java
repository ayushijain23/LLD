package TicTacToe;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        TicTacToeClass obj = new TicTacToeClass(n);
        String res = obj.startGame();
        System.out.println(res);
    }
}
