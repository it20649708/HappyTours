package com.example.happytours;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewReservation extends AppCompatActivity {

    EditText tv_name,tv_nic,tv_quentity,tv_noOfDays;
    DatabaseReference databaseReference;
    FirebaseDatabase mDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reservation);

        tv_name=findViewById(R.id.tv_name);
        tv_nic = findViewById(R.id.tv_nic);
        tv_quentity = findViewById(R.id.tv_quentity);
        tv_noOfDays = findViewById(R.id.tv_noOfDays);


        mDatabase = FirebaseDatabase.getInstance();
        databaseReference=mDatabase.getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren())
                {
                    vehicle vehicles= ds.getValue(vehicle.class);
                    assert vehicles != null;
                    String name;
                    name = vehicles.getName();
                    String nic =  vehicles.getNic();
                   Integer quentity= vehicles.getQuentity();
                   Integer noOfDays  = vehicles.getDays();

                   tv_name.setText(name);
                   tv_nic.setText(nic);
                   tv_quentity.setText(quentity);
                   tv_noOfDays.setText(noOfDays);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}