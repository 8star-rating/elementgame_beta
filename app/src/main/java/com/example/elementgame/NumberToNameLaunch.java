package com.example.elementgame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NumberToNameLaunch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_to_name_launch);

        Button proceed2 = findViewById(R.id.proceedbtn2);
        Button back2 = findViewById(R.id.backbtn2);

        proceed2.setOnClickListener(v -> {
            Intent intent = new Intent(NumberToNameLaunch.this, NTNGame.class);
            startActivity(intent);
        });

        back2.setOnClickListener(v -> {
            Intent intent = new Intent(NumberToNameLaunch.this, GameMode.class);
            startActivity(intent);
        });
    }
}