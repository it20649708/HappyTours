package com.example.happytours;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategeoryAdapterClass extends RecyclerView.Adapter<CategeoryAdapterClass.CategeoryViewHolder> {

    Context context;
    List<shops> sData;

    public CategeoryAdapterClass(Context context, List<shops> sData) {
        this.context = context;
        this.sData = sData;

    }

    @NonNull
    @Override
    public CategeoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View layout;
       layout= LayoutInflater.from(context).inflate(R.layout.vehicle_layout,parent,false);
        return new CategeoryViewHolder(layout,context,sData);
    }

    @Override
    public void onBindViewHolder(@NonNull CategeoryViewHolder holder, int position) {
           String vname = sData.get(position).getvName();
           int vimage  = sData.get(position).getVimage();

           holder.sname.setText(vname);
           holder.sphoto.setImageResource(vimage);

    }

    @Override
    public int getItemCount() {
        return sData.size();
    }

    public static class  CategeoryViewHolder extends RecyclerView.ViewHolder {

        TextView sname;
        ImageView sphoto;

        public CategeoryViewHolder(@NonNull View itemView,Context context,List<shops> sData) {
            super(itemView);
            sname = itemView.findViewById(R.id.text1);
            sphoto= itemView.findViewById(R.id.img_1);
        }

    }
}
