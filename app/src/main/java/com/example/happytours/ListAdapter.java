package com.example.happytours;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter {

    private Activity Mcontext;
    List<com.example.happytours.Food> foodlist;

    public ListAdapter(Activity mcontext,List<com.example.happytours.Food> foodlist) {
        super(mcontext,R.layout.list_item,foodlist);
        this.Mcontext=mcontext;
        this.foodlist=foodlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inf= Mcontext.getLayoutInflater();
        View listview=inf.inflate(R.layout.list_item,null,true);

        TextView name=listview.findViewById(R.id.tvname);
        TextView price=listview.findViewById(R.id.tvprice);
        TextView portion=listview.findViewById(R.id.tvportion);
        TextView shop=listview.findViewById(R.id.tvshop);

        com.example.happytours.Food f= foodlist.get(position);
        name.setText(f.getFoodname());
        price.setText(f.getPrice());
        portion.setText(f.getPortion());
        shop.setText(f.getShop());

        return listview;
    }
}
