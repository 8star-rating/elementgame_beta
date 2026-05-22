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


public class EGame extends AppCompatActivity {

    private EGameLogic mechanism3;

    private TextView Qdisplay3;
    private EditText Pinput3;
    private Button Bsubmit3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egame);

        Qdisplay3 = findViewById(R.id.random_symb3);
        Pinput3 = findViewById(R.id.input3);
        Bsubmit3 = findViewById(R.id.submit3);

        mechanism3 = new EGameLogic(this);

        loadNextTurn();

        Bsubmit3.setOnClickListener(v -> {
            String userInput = Pinput3.getText().toString();

            if (userInput.trim().isEmpty()) {
                Toast.makeText(EGame.this, "Please type an answer first!", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean isCorrect = mechanism3.checkAnswer(userInput);

            if (isCorrect) {
                Toast.makeText(EGame.this, "Correct!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(EGame.this, "Wrong! Correct answer: " + mechanism3.getCorrectAnswer(), Toast.LENGTH_SHORT).show();
            }

            Pinput3.setText("");

            if (mechanism3.MoreQuestions()) {
                loadNextTurn();
            }
            else {
                // Handle the Game Over structural screen state change
                Toast toast = Toast.makeText(this, "GAME OVER!\nFinal Score: " + mechanism3.getScore() + " / " + mechanism3.getMaxQuestions() , Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                Qdisplay3.setVisibility(View.GONE);
                Pinput3.setVisibility(View.GONE);
                Bsubmit3.setEnabled(true);
                Bsubmit3.setText("FINISHED");
                Bsubmit3.setOnClickListener( back -> {
                    Intent intent = new Intent(EGame.this, GameMode.class);
                    startActivity(intent);}
                );
            }
        });
    }
    private void loadNextTurn(){
        String nextSymb = mechanism3.getNextElement();
        Qdisplay3.setText(nextSymb);
    }
}