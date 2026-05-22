package com.example.elementgame;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class EGameLogic {
    private final List<String[]> elements = new ArrayList<>();
    private final Random random = new Random();
    private int score = 0;
    private int Qcount = 0;
    private final int maxQ = 15;
    private String currentSymbol;
    private String currentAnswer;

    public EGameLogic(Context context){
        readCSV(context);
    }

    private void readCSV(Context context){
        try {
            // Reads 'periodictable.csv' right out of your src\main\assets folder
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(context.getAssets().open("periodictable.csv")));
            br.readLine(); // Skips header line
            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(",");
                if (parts.length >= 3){ // Keeps your exact index requirement rule
                    elements.add(parts);
                }
            }
            br.close();
        } catch (IOException e){
            // Prints the tracking error to the Android Studio logcat instead of console
            e.printStackTrace();
        }
    }

    public boolean MoreQuestions(){
        return Qcount < maxQ;
    }

    public String getNextElement(){
        int index = random.nextInt(elements.size());
        String [] entry = elements.get(index);
        currentSymbol = entry[2];        // Index 2 is your question text symbol
        currentAnswer = entry[3].trim();  // Index 1 is your text answer name string
        Qcount++;
        return currentSymbol;
    }

    public boolean checkAnswer(String userInput) {
        boolean correct = userInput.trim().equalsIgnoreCase(currentAnswer);
        if (correct) score++;
        return correct;
    }

    public int getScore(){return score;}
    public String getCorrectAnswer(){return currentAnswer;}
    public int getMaxQuestions(){return maxQ;}
}
