package com.example.happytours;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class sales extends AppCompatActivity {

    CategeoryAdapterClass categeoryAdapterClass;
    ArrayList<shops> sData;
    RecyclerView recyclerView;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);
        recyclerView = findViewById(R.id.v_cat);
        getData();
        setDataAdapter();

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVehicleItem();
            }
        });
    }

    private void openVehicleItem() {

        Intent intent = new Intent(this,VehicleItem.class);
        startActivity(intent);
    }

    private void setDataAdapter() {
        categeoryAdapterClass = new CategeoryAdapterClass(sales.this,this.sData);
        recyclerView.setAdapter(categeoryAdapterClass);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getData() {
        sData = new ArrayList<>();
        sData.add(new shops(R.drawable.safari,"Safari"));
        sData.add(new shops(R.drawable.cars,"Cars"));
        sData.add(new shops(R.drawable.buses,"Bus"));
        sData.add(new shops(R.drawable.bikes,"Bikes"));
        sData.add(new shops(R.drawable.vans,"Vans"));

    }
}