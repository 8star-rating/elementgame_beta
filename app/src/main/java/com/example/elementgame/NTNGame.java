package com.example.elementgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class NTNGame extends AppCompatActivity {

    private NTNLogic mechanism2;
    private TextView Qdisplay2;
    private EditText Pinput2;
    private Button Bsubmit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ntngame);

        Qdisplay2 = findViewById(R.id.random_numb);
        Pinput2 = findViewById(R.id.input2);
        Bsubmit2 = findViewById(R.id.submit2);

        mechanism2 = new NTNLogic(this);

        loadNextTurn();

        Bsubmit2.setOnClickListener(v -> {
            String userInput = Pinput2.getText().toString();

            if (userInput.trim().isEmpty()) {
                Toast.makeText(NTNGame.this, "Please type an answer first!", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean isCorrect = mechanism2.checkAnswer(userInput);

            if (isCorrect) {
                Toast.makeText(NTNGame.this, "Correct!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(NTNGame.this, "Wrong! Correct answer: " + mechanism2.getCorrectAnswer(), Toast.LENGTH_SHORT).show();
            }

            Pinput2.setText("");

            if (mechanism2.MoreQuestions()) {
                loadNextTurn();
            }
            else {
                Toast toast = Toast.makeText(this, "GAME OVER!\nFinal Score: " + mechanism2.getScore() + " / " + mechanism2.getMaxQuestions() , Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 50);
                toast.show();
                Qdisplay2.setVisibility(View.GONE);
                Pinput2.setVisibility(View.GONE);
                Bsubmit2.setEnabled(true);
                Bsubmit2.setText("FINISHED");
                Bsubmit2.setOnClickListener( back -> {
                    Intent intent = new Intent(NTNGame.this, GameMode.class);
                    startActivity(intent);}
                );
            }
        });
    }

    private void loadNextTurn(){
        String nextNumb = mechanism2.getNextElement();
        Qdisplay2.setText(nextNumb);
    }

}