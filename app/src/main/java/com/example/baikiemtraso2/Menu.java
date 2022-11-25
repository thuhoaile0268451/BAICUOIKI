package com.example.baikiemtraso2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnprofile = findViewById(R.id.btnProfile);
        Button btnlistview = findViewById(R.id.btnLv);

        btnlistview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, ShowRecycle.class);
                startActivity(intent);
            }
        });

        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Profile.class);
                startActivity(intent);
            }
        });
    }
}