package snakeAndLader.src;

import java.io.*;

public class InputEx {
    public static void main(String[] args) {
        File file = new File("/Users/ayushi/Desktop/Preparation/MachineCoding/Snake&Ladder/src/input.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = "";
            try {
                while((str = br.readLine()) != null){
                    String ss[] = str.split(" ");
                    for(String in : ss){
                        System.out.println(in);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
