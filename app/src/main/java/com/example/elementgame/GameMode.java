package com.example.elementgame;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;

public class GameMode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);

        Button ston = findViewById(R.id.symbton);
        Button numton = findViewById(R.id.numbton);
        Button element = findViewById(R.id.elmnt);
        Button polyatomic = findViewById(R.id.plytmc);
        Button back = findViewById(R.id.back);

        ston.setOnClickListener(v -> {
            Intent intent = new Intent(GameMode.this, SymbolToNameLaunch.class);
            startActivity(intent);
        });

        numton.setOnClickListener(v -> {
            Intent intent = new Intent(GameMode.this, NumberToNameLaunch.class);
            startActivity(intent);
        });

        element.setOnClickListener(v -> {
            Intent intent = new Intent(GameMode.this, ElementTypeLaunch.class);
            startActivity(intent);
        });

        polyatomic.setOnClickListener(v -> {
            Intent intent = new Intent(GameMode.this, PolyIonLaunch.class);
            startActivity(intent);
        });

        back.setOnClickListener(v -> {
            Intent intent = new Intent(GameMode.this, MainActivity.class);
            startActivity(intent);
        });

    }
}