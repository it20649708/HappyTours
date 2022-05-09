package com.example.happytours;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity<button> extends AppCompatActivity {
    private button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        @Override
        public void onClick(View v){
            openactivity_main2();

        }

    }

    private void openactivity_main2() {
        Intent intent = new Intent (this,activity_main2.class);
        startActivity(intent);
    }
}

public class AddBooking<booking> extends AppCompatActivity {

    private EditText firstname,lastname,mobile,email,nic,checkindate,checkintime,checkoutdate,checkouttime,
            noofadults,noofchildren,noofrooms;
    booking bookingobj;
    DatabaseReference databaseReference;
    Button confirm;
    private Calendar FirebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        mobile = findViewById(R.id.mobile);
        email = findViewById(R.id.email);
        nic = findViewById(R.id.NICno);
        checkindate = findViewById(R.id.CheckInDate);
        checkintime = findViewById(R.id.CheckInTime);
        checkoutdate = findViewById(R.id.CheckOutDate);
        checkouttime = findViewById(R.id.checkOutTime);
        noofadults = findViewById(R.id.NoOfAdults);
        noofchildren = findViewById(R.id.NoOfChildren);
        noofrooms = findViewById(R.id.NoOfRooms);

        bookingobj = new booking();

    }
    public void add(View view){
        databaseReference = FirebaseDatabase.getInstance().get().child("booking");

        try {
            if (TextUtils.isEmpty(firstname.getText().toString())) {
                Toast.makeText(getApplicationContext(), "please enter name", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(lastname.getText().toString())) {
                Toast.makeText(getApplicationContext(), "please enter name", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(mobile.getText().toString())) {
                Toast.makeText(getApplicationContext(), "please enter name", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(email.getText().toString())) {
                Toast.makeText(getApplicationContext(), "please enter name", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(nic.getText().toString())) {
                Toast.makeText(getApplicationContext(), "please enter name", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(checkindate.getText().toString())) {
                Toast.makeText(getApplicationContext(), "please enter name", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(checkintime.getText().toString())) {
                Toast.makeText(getApplicationContext(), "please enter name", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(checkoutdate.getText().toString())) {
                Toast.makeText(getApplicationContext(), "please enter name", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(checkouttime.getText().toString())) {
                Toast.makeText(getApplicationContext(), "please enter name", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(noofadults.getText().toString())) {
                Toast.makeText(getApplicationContext(), "please enter name", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(noofchildren.getText().toString())) {
                Toast.makeText(getApplicationContext(), "please enter name", Toast.LENGTH_SHORT).show();
            }else (TextUtils.isEmpty(noofrooms.getText().toString())) {
                Toast.makeText(getApplicationContext(), "please enter name", Toast.LENGTH_SHORT).show();
            }

            bookingobj.setFirstName(firstname.getText().toString().trim());
            bookingobj.setLastName(lastname.getText().toString().trim());
            bookingobj.setMobile(mobile.getText().toString().trim()));
            bookingobj.setEmail(email.getText().toString().trim()));
            bookingobj.setNic(nic.getText().toString().trim());
            bookingobj.setCheckInDate(checkindate.getText().toString().trim());
            bookingobj.setCheckInTime(checkintime.getText().toString().trim()));
            bookingobj.setCheckOutDate(checkoutdate.getText().toString().trim()));
            bookingobj.setCheckOutTime(checkouttime.getText().toString().trim());
            bookingobj.setNoOfAdults(Integer.parseInt(noofadults.getText().toString().trim());
            bookingobj.setNoOfChildren(Integer.parseInt(noofchildren.getText().toString().trim()));
            bookingobj.setNoOfRooms(Integer.parseInt(noofrooms.getText().toString().trim()));




                databaseReference.push().setValue(bookingobj);

                Toast.makeText(getApplicationContext(),"Reservation Successfully",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AddBooking.this, ViewBooking.class);
                startActivity(intent);



            }
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(),"Invalid Number Format", Toast.LENGTH_SHORT).show();
        }
    }


}