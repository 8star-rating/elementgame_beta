package com.example.elementgame;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NTNLogic {
    private final List<String[]> elements = new ArrayList<>();
    private final Random random = new Random();
    private int score = 0;
    private int Qcount = 0;
    private final int maxQ = 15;
    private String currentNumber;
    private String currentAnswer;

    public NTNLogic(Context context){
        readCSV(context);
    }

    private void readCSV(Context context){
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(context.getAssets().open("periodictable.csv")));
            br.readLine();
            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(",");
                if (parts.length >= 3){
                    elements.add(parts);
                }
            }
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean MoreQuestions(){
        return Qcount < maxQ;
    }

    public String getNextElement(){
        int index = random.nextInt(elements.size());
        String [] entry = elements.get(index);
        currentNumber = entry[0];
        currentAnswer = entry[1].trim();
        Qcount++;
        return currentNumber;
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

