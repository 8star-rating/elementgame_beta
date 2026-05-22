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

public class PolyGame extends AppCompatActivity {

    private PolyLogic mechanism4;
    private TextView Qdisplay4;
    private EditText Pinput4;
    private Button Bsubmit4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_poly_game);

        Qdisplay4  = findViewById(R.id.random_ion);
        Pinput4 = findViewById(R.id.input4);
        Bsubmit4 = findViewById(R.id.submit4);

        mechanism4 = new PolyLogic(this);

        loadNextTurn();

        Bsubmit4.setOnClickListener(v -> {
            String userInput = Pinput4.getText().toString();

            if (userInput.trim().isEmpty()) {
                Toast.makeText(PolyGame.this, "Please type an answer first!", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean isCorrect = mechanism4.checkAnswer(userInput);

            if (isCorrect) {
                Toast.makeText(PolyGame.this, "Correct!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(PolyGame.this, "Wrong! Correct answer: " + mechanism4.getCorrectAnswer(), Toast.LENGTH_SHORT).show();
            }

            Pinput4.setText("");

            if (mechanism4.MoreQuestions()) {
                loadNextTurn();
            }
            else {
                Toast toast = Toast.makeText(this, "GAME OVER!\nFinal Score: " + mechanism4.getScore() + " / " + mechanism4.getMaxQuestions() , Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 50);
                toast.show();
                Qdisplay4.setVisibility(View.GONE);
                Pinput4.setVisibility(View.GONE);
                Bsubmit4.setEnabled(true);
                Bsubmit4.setText("FINISHED");
                Bsubmit4.setOnClickListener( back -> {
                    Intent intent = new Intent(PolyGame.this, GameMode.class);
                    startActivity(intent);}
                );
            }
        });
    }

    private void loadNextTurn(){
        String nextIon = mechanism4.getNextIon();
        Qdisplay4.setText(nextIon);
    }
}