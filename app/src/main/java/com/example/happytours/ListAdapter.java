package com.example.happytours;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class ListAdapter extends ArrayAdapter {

    private Activity Mcontext;
    List<Food> foodlist;

    public ListAdapter(Activity mcontext,List<Food> foodlist) {
        super(mcontext,R.layout.list_item,foodlist);
        this.Mcontext=mcontext;
        this.foodlist=foodlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inf= Mcontext.getLayoutInflater();
        View listview=inf.inflate(R.layout.list_item,null,true);

        TextView name=listview.findViewById(R.id.tvorderfoodname);
        TextView price=listview.findViewById(R.id.orderitemqty);
        TextView portion=listview.findViewById(R.id.totalamount);
        TextView shop=listview.findViewById(R.id.tvshop);
        Button ord=listview.findViewById(R.id.buttonord);
        EditText qty=listview.findViewById(R.id.etqty);

        Food f= foodlist.get(position);
        name.setText(f.getFoodname());
        price.setText(f.getPrice());
        portion.setText(f.getPortion());
        shop.setText(f.getShop());

        Button btn = ord;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Order o=new Order();
                String p=price.getText().toString();
                int price=Integer.valueOf(p);
                String q=qty.getText().toString();
                int quantity=Integer.valueOf(q);

                int tot=price*quantity;
                String totp=String.valueOf(tot);
                DatabaseReference dbRef= FirebaseDatabase.getInstance("https://foodorder-d103c-default-rtdb.firebaseio.com").getReference().child("Orders");

                try {

                    if (TextUtils.isEmpty(qty.getText().toString())) {
                        Toast.makeText(Mcontext.getApplicationContext(), "please Enter Quantity", Toast.LENGTH_SHORT).show();
                    }else{
                        o.setPrice(totp);
                        o.setOrderqty(q);
                        o.setItemname(name.getText().toString().trim());

                        dbRef.push().setValue(o);

                        Toast.makeText(Mcontext.getApplicationContext(),"Added To Cart",Toast.LENGTH_SHORT).show();
                    }
                }catch(NumberFormatException e){
                    Toast.makeText(Mcontext.getApplicationContext(),"Something Wrong",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return listview;
    }

}
