package com.example.elementgame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PolyIonLaunch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poly_ion_launch);

        Button proceed4 = findViewById(R.id.proceedbtn4);
        Button back4 = findViewById(R.id.backbtn4);

        proceed4.setOnClickListener(v -> {
            Intent intent = new Intent(PolyIonLaunch.this, PolyGame.class);
            startActivity(intent);
        });

        back4.setOnClickListener(v -> {
            Intent intent = new Intent(PolyIonLaunch.this, GameMode.class);
            startActivity(intent);
        });
    }
}