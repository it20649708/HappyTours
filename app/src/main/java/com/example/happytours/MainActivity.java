package com.example.happytours;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
List1AdapterClass list1AdapterClass;
ArrayList<modelClass> mData;
RecyclerView recyclerView;
    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.v_list);
        getData();
        setDataAdapter();

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensales();
            }
        });
    }

    private void opensales() {

        Intent intent = new Intent(this,sales.class);
        startActivity(intent);
    }

    private void setDataAdapter() {
        list1AdapterClass = new List1AdapterClass(MainActivity.this,this.mData);
        recyclerView.setAdapter(list1AdapterClass);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void getData() {
        mData = new ArrayList<>();
        mData.add(new modelClass(R.drawable.image1,"Nawala","+9471546582","Malindu Rentals"));
        mData.add(new modelClass(R.drawable.img_2,"Moratuwa","+94745698962","Isuru Rentals"));
        mData.add(new modelClass(R.drawable.img_3,"Matara","+9471548962","Lanka Rentals"));
        mData.add(new modelClass(R.drawable.img_8,"Digana","+9471548962","Digana Rentals"));
        mData.add(new modelClass(R.drawable.img_7,"Kaluthara","+9471548962","Susil Rentals"));
        mData.add(new modelClass(R.drawable.img_6,"Koswatta","+9471548962","K.B.C Rentals"));
        mData.add(new modelClass(R.drawable.img_7,"Elpitiya","+9471548962","Shaan Rentals"));
        mData.add(new modelClass(R.drawable.img_8,"Panadura","+9471548962","Autoshop Rentals"));
        mData.add(new modelClass(R.drawable.img_2,"Panadura","+9471548962","Jagath Rentals"));
    }
}

