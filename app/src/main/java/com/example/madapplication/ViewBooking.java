package com.example.madapplication;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.madapplication.DatabaseReference;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class ViewBooking<FirebaseDatabase> extends AppCompatActivity {

    EditText firstname,lastname,mobile,email,nic,checkindate,checkintime,checkoutdate,
            checkouttime,noofadults,noofchildren,noofrooms;
    DatabaseReference databaseReference;
    FirebaseDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_booking);

        firstname=findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        mobile = findViewById(R.id.mobile);
        email = findViewById(R.id. email);
        nic=findViewById(R.id.nic);
        checkindate = findViewById(R.id.checkindate);
        checkintime = findViewById(R.id.checkintime);
        checkoutdate= findViewById(R.id.checkoutdate);
        checkouttime=findViewById(R.id. checkouttime);
        noofadults = findViewById(R.id.noofadults);
        noofchildren = findViewById(R.id.noofchildren);
        noofrooms = findViewById(R.id. noofrooms);


        mDatabase = FirebaseDatabase.getInstance();
        databaseReference=mDatabase.getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren())
                {
                    booking bookings= ds.getValue(booking.class);
                    String firstName = bookings.getFirstName();
                    String lastName = bookings.getLastName();
                    String mobile= bookings.getMobile();
                    String email  = bookings.getEmail();
                    String nic = bookings.getNic();
                    String checkindate = bookings.getCheckInDate();
                    String checkintime= bookings.getCheckInTime();
                    String checkoutdate  = bookings.getCheckOutDate();
                    String checkouttime = bookings.getCheckOutTime();
                    Integer noofadults = bookings.getNoOfAdults();
                    Integer noofchildren= bookings.getNoOfChildren();
                    Integer noofrooms  = bookings.getNoOfRooms();

                    firstname.setText((CharSequence) firstname);
                    lastname.setText((CharSequence) lastname);
                    mobile.substring((CharSequence) mobile);
                    email.substring((CharSequence) email);
                    nic.substring(nic);
                    checkindate.substring(checkindate);
                    checkintime.substring(checkintime);
                    checkoutdate.substring(checkoutdate);
                    checkouttime.substring(checkouttime);
                    noofadults.intValue(noofadults);
                    noofchildren.intValue(noofchildren);
                    noofrooms.intValue(noofrooms);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
