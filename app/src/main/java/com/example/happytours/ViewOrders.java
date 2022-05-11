package com.example.happytours;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewOrders extends AppCompatActivity {

    ListView myview;
    List<Order> orderslist;

    DatabaseReference orderdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_orders);

        myview=findViewById(R.id.orderviewlist);
        orderslist=new ArrayList<>();

        orderdb= FirebaseDatabase.getInstance("https://foodorder-d103c-default-rtdb.firebaseio.com").getReference("Orders");

        orderdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                orderslist.clear();
                for(DataSnapshot ordersnap: dataSnapshot.getChildren()){
                    Order or=ordersnap.getValue(Order.class);
                    orderslist.add(or);
                }
                OrderAdapter oa=new OrderAdapter(ViewOrders.this,orderslist);
                myview.setAdapter(oa);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}