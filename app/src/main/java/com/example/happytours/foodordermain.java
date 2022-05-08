package com.example.happytours;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class foodordermain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodordermain);

        Button bview = (Button) findViewById(R.id.btn_order);
        bview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launch=new Intent(foodordermain.this,foodAdd.class);
                startActivity(launch);
            }
        });
    }
}