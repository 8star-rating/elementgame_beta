package com.example.elementgame;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;

public class ElementTypeLaunch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_name_launch);

        Button proceed3 = findViewById(R.id.proceedbtn3);
        Button back3 = findViewById(R.id.backbtn3);

        proceed3.setOnClickListener(v -> {
            Intent intent = new Intent(ElementTypeLaunch.this, EGame.class);
            startActivity(intent);
        });

        back3.setOnClickListener(v -> {
            Intent intent = new Intent(ElementTypeLaunch.this, GameMode.class);
            startActivity(intent);
        });

    }
}