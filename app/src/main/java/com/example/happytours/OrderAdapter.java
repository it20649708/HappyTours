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

public class OrderAdapter extends ArrayAdapter {

    private Activity mContext;
    List<Order> orderlist;

    public OrderAdapter(Activity context, List<Order> orderlist){
        super(context,R.layout.orderitem,orderlist);
        this.mContext=context;
        this.orderlist=orderlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater in=mContext.getLayoutInflater();
        View listitems=in.inflate(R.layout.orderitem,null,true);

        TextView name=listitems.findViewById(R.id.tvorderfoodname);
        TextView qty=listitems.findViewById(R.id.orderitemqty);
        TextView tot=listitems.findViewById(R.id.totalamount);

        Order o=orderlist.get(position);

        name.setText(o.getItemname());
        qty.setText(o.getOrderqty());
        tot.setText(o.getPrice());

        return listitems;

    }
}
