package com.example.happytours;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class VehicleItem extends AppCompatActivity {

    ItemAdapteClass itemAdapteClass ;
    ArrayList<ItemClass> iData;
    RecyclerView recyclerView;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_item);
        recyclerView = findViewById(R.id.i_list);
        getData();
        setAdapterData();

        button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openAddReservation();
            }
        });
    }
    public void openAddReservation(){
        Intent intent = new Intent(this,AddReservation.class);
        startActivity(intent);
    }

    private void setAdapterData() {

        itemAdapteClass = new ItemAdapteClass(VehicleItem.this,this.iData);
        recyclerView.setAdapter(itemAdapteClass);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    private void getData() {
        iData = new ArrayList<>();
        iData.add(new ItemClass("Black","SPGQ1243","AC/","dolpin",R.drawable.safari));
        iData.add(new ItemClass("Black","SPGQ1243","AC/","dolpin",R.drawable.safari));
        iData.add(new ItemClass("Black","SPGQ1243","AC/","dolpin",R.drawable.safari));
        iData.add(new ItemClass("Black","SPGQ1243","AC/","dolpin",R.drawable.safari));
        iData.add(new ItemClass("Black","SPGQ1243","AC/","dolpin",R.drawable.safari));
        iData.add(new ItemClass("Black","SPGQ1243","AC/","dolpin",R.drawable.safari));
        iData.add(new ItemClass("Black","SPGQ1243","AC/","dolpin",R.drawable.safari));
        iData.add(new ItemClass("Black","SPGQ1243","AC/","dolpin",R.drawable.safari));
    }

}
