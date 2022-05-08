package com.example.happytours;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.List;

class List1AdapterClass extends Adapter<List1AdapterClass.ListViewHolder> {

    Context context;
    List<modelClass> mData;
    private ListViewHolder.RecycleViewClickListener clickListener;

    public List1AdapterClass(Context context, List<modelClass> mData) {
        this.context = context;
        this.mData = mData;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(context).inflate(R.layout.list_layout,parent,false);
        
        return new ListViewHolder(layout,context,mData,clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        String city = mData.get(position).getCity().toString();
        String phone = mData.get(position).getPhone().toString();
        String name =mData.get(position).getName().toString();
        int photo =mData.get(position).getPhoto();


        holder.tv_city.setText(city);
        holder.tv_phone.setText(phone);
        holder.tv_name.setText(name);
        holder.img_photo.setImageResource(photo);
    }

    @Override
    public int getItemCount() {

        return mData.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv_name,tv_city,tv_phone;
        ImageView img_photo;

        public ListViewHolder(@NonNull View itemView,Context context,List<modelClass> mData,RecycleViewClickListener clickListener) {
            super(itemView);
            tv_name=itemView.findViewById(R.id.textView);
            tv_city=itemView.findViewById(R.id.st_01);
            tv_phone=itemView.findViewById(R.id.st_2);
            img_photo=itemView.findViewById(R.id.img_1);
        }

        @Override
        public void onClick(View view) {

        }
        public interface RecycleViewClickListener{

        }
    }
}
