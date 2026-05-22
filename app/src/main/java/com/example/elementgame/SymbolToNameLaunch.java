package com.example.elementgame;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;

public class SymbolToNameLaunch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symbol_to_name);

        Button proceed = findViewById(R.id.proceedbtn);
        Button back = findViewById(R.id.backbtn);

        proceed.setOnClickListener(v -> {
            Intent intent = new Intent(SymbolToNameLaunch.this, STNGame.class);
            startActivity(intent);
        });

        back.setOnClickListener(v -> {
            Intent intent = new Intent(SymbolToNameLaunch.this, GameMode.class);
            startActivity(intent);
        });

    }
}