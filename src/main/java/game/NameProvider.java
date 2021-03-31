package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class NameProvider {

    private ArrayList<String> words = new ArrayList<>();
    private int nextWordIndex;
    public static String fileName = "words.txt";

    public NameProvider() {
        loadWordsFromFile();
        nextWordIndex = 0;
    }

    private void loadWordsFromFile(){
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

    public String nextName(){
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
