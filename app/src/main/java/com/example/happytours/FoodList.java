package com.example.happytours;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FoodList extends AppCompatActivity {

    ListView list;
    List<Food> foodList;

    DatabaseReference fooddbref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        Button bview = (Button) findViewById(R.id.orderviewbutton);
        bview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launch=new Intent(FoodList.this,ViewOrders.class);
                startActivity(launch);
            }
        });

        list=findViewById(R.id.foodlistview);
        foodList=new ArrayList<>();

        fooddbref= FirebaseDatabase.getInstance("https://foodorder-d103c-default-rtdb.firebaseio.com").getReference("Foods");

        fooddbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                foodList.clear();

                for(DataSnapshot foodsnap: dataSnapshot.getChildren()){
                    Food f= foodsnap.getValue(Food.class);
                    foodList.add(f);
                }
                ListAdapter ad=new com.example.happytours.ListAdapter(FoodList.this,foodList);
                list.setAdapter(ad);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}