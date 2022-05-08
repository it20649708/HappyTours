package com.example.happytours;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class foodAdd extends AppCompatActivity {

    EditText FoodName, FoodPrice, RestaurantName, City;
    Spinner Category, Portion;
    Button add, view;

    com.example.happytours.Food food;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.dropCategory);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Dessert");
        arrayList.add("Backery food");
        arrayList.add("Koththu");
        arrayList.add("Drinks");
        arrayList.add("Fruit & Vegetables");
        arrayList.add("Rice varieties");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        Spinner dropportion = findViewById(R.id.dropPortion);
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("Small");
        arrayList2.add("Medium");
        arrayList2.add("Large");
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList2);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropportion.setAdapter(arrayAdapter2);

        FoodName = findViewById(R.id.editTextTextFoodName);
        FoodPrice = findViewById(R.id.editTextTextFoodPrice);
        RestaurantName = findViewById(R.id.editTextTextRestaurantName);
        City = findViewById(R.id.editTextTextCity);
        Category = findViewById(R.id.dropCategory);
        Portion = findViewById(R.id.dropPortion);
        add = findViewById(R.id.btnAdd);
        view = findViewById(R.id.viewbtn);

        food = new com.example.happytours.Food();
        Button btn = (Button) findViewById(R.id.btnAdd);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddData();
            }
        });
        Button bview = (Button) findViewById(R.id.viewbtn);
        bview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launch=new Intent(foodAdd.this, com.example.happytours.FoodList.class);
                startActivity(launch);
            }
        });
    }

    public void clearcontrols(){
        FoodName.setText("");
        FoodPrice.setText("");
        RestaurantName.setText("");
        City.setText("");
    }

    public void AddData(){
        dbRef=FirebaseDatabase.getInstance("https://foodorder-d103c-default-rtdb.firebaseio.com").getReference().child("Foods");

        try {

            if (TextUtils.isEmpty(FoodName.getText().toString())) {
                Toast.makeText(getApplicationContext(), "please Enter Food Name", Toast.LENGTH_SHORT).show();
            }else if (TextUtils.isEmpty(FoodPrice.getText().toString())){
                Toast.makeText(getApplicationContext(), "please Enter Food Price", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(RestaurantName.getText().toString())) {
                Toast.makeText(getApplicationContext(), "please Enter Restaurant Name", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(City.getText().toString())) {
                Toast.makeText(getApplicationContext(), "please Enter City", Toast.LENGTH_SHORT).show();
            }else{
                food.setFoodname(FoodName.getText().toString().trim());
                food.setCategory(Category.getSelectedItem().toString());
                food.setPrice(FoodPrice.getText().toString().trim());
                food.setPortion(Portion.getSelectedItem().toString());
                food.setShop(RestaurantName.getText().toString().trim());
                food.setCity(City.getText().toString().trim());

                dbRef.push().setValue(food);

                Toast.makeText(getApplicationContext(),"Data Added Successfully",Toast.LENGTH_SHORT).show();
                clearcontrols();}
        }catch(NumberFormatException e){
            Toast.makeText(getApplicationContext(),"Something Wrong",Toast.LENGTH_SHORT).show();
        }
    }
}