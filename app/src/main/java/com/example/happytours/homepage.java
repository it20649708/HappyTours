package com.example.happytours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Button bview = (Button) findViewById(R.id.buttonfood);
        bview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launch=new Intent(homepage.this,foodordermain.class);
                startActivity(launch);
            }
        });
    }
}