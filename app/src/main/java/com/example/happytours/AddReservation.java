package com.example.happytours;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class AddReservation extends AppCompatActivity {

    private EditText name,nic,quentity,days,date;
    vehicle vehicleobj;
    DatabaseReference databaseReference;
    Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reservation);

        name = findViewById(R.id.name);
        nic = findViewById(R.id.nic);
        quentity = findViewById(R.id.quentity);
        days = findViewById(R.id.noOfDays);
        date = findViewById(R.id.editTextDate);
        add = (Button)findViewById(R.id.add);


        vehicleobj = new vehicle();


        add.setOnClickListener(v -> {


            databaseReference = FirebaseDatabase.getInstance().getReference().child("vehicle");


            if (TextUtils.isEmpty(name.getText().toString())) {
                Toast.makeText(getApplicationContext(), "please enter Name", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(nic.getText().toString())) {
                Toast.makeText(getApplicationContext(), "please enter Nic", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(quentity.getText().toString())) {
                Toast.makeText(getApplicationContext(), "please enter Quentity", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(days.getText().toString())) {
                Toast.makeText(getApplicationContext(), "please enter Days", Toast.LENGTH_SHORT).show();
            } else {
                vehicleobj.setName(name.getText().toString().trim());
                vehicleobj.setNic(nic.getText().toString().trim());
                vehicleobj.setQuentity(Integer.parseInt(quentity.getText().toString().trim()));
                vehicleobj.setDays(Integer.parseInt(days.getText().toString().trim()));
                databaseReference.push().setValue(vehicleobj);

                Toast.makeText(AddReservation.this, "Reservation Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddReservation.this, ViewReservation.class);
                startActivity(intent);

            }

        });
        }


    }
















