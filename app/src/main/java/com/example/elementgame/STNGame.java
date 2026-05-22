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


public class STNGame extends AppCompatActivity {
    private STNLogic mechanism1;

    private TextView Qdisplay;
    private EditText Pinput;
    private Button Bsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stngame);

        Qdisplay = findViewById(R.id.random_symb);
        Pinput = findViewById(R.id.input1);
        Bsubmit = findViewById(R.id.submit1);

        mechanism1 = new STNLogic(this);

        loadNextTurn();

        Bsubmit.setOnClickListener(v -> {
            String userInput = Pinput.getText().toString();

            if (userInput.trim().isEmpty()) {
                Toast.makeText(STNGame.this, "Please type an answer first!", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean isCorrect = mechanism1.checkAnswer(userInput);

            if (isCorrect) {
                Toast.makeText(STNGame.this, "Correct!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(STNGame.this, "Wrong! Correct answer: " + mechanism1.getCorrectAnswer(), Toast.LENGTH_SHORT).show();
            }

            Pinput.setText("");

            if (mechanism1.MoreQuestions()) {
                loadNextTurn();
            }
            else {
                Toast toast = Toast.makeText(this, "GAME OVER!\nFinal Score: " + mechanism1.getScore() + " / " + mechanism1.getMaxQuestions() , Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 50);
                toast.show();
                Qdisplay.setVisibility(View.GONE);
                Pinput.setVisibility(View.GONE);
                Bsubmit.setEnabled(true);
                Bsubmit.setText("FINISHED");
                Bsubmit.setOnClickListener( back -> {
                    Intent intent = new Intent(STNGame.this, GameMode.class);
                    startActivity(intent);}
                );
            }
        });
    }
    private void loadNextTurn(){
        String nextSymb = mechanism1.getNextElement();
        Qdisplay.setText(nextSymb);
    }
}