package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NameProvider {

    private static ArrayList<String> words = new ArrayList<>();
    private static int nextWordIndex = 0;
    public static String fileName = "words.txt";


    public static void loadWordsFromFile(){
        String[] wordsArray = {"did","not","read","file","error"};
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            wordsArray = reader.readLine().split(" ");
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < wordsArray.length; i++) {
            words.add(wordsArray[i]);
        }
    }

    public static String nextName(){
        String nextName = words.get(nextWordIndex);
        nextWordIndex = nextWordIndex + 1;

        if(nextWordIndex >= words.size()){
            nextWordIndex = 0;
        }

        nextName = nextName.trim()
                .toUpperCase()
                .replaceAll("[^A-Z\\-']",""); //vymaze vsetko okrem velkych A-Z pismen a pomlcky(-) a apostrofu(') z kazdeho slova

        return nextName;
    }
}
