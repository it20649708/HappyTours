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

public class ListAdapterClass extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<modelClass> mData;
    private ListViewHolder.RecycleViewClickListener clickListener;

    public ListAdapterClass(Context context, List<modelClass> mData) {
        this.context = context;
        this.mData = mData;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layout;
        layout = LayoutInflater.from(context).inflate(R.layout.list_layout, parent);
        return new ListViewHolder(layout,context);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            String city = mData.get(position).getCity().toString();
            String phone = mData.get(position).getPhone().toString();
            String name =mData.get(position).getName().toString();
            int photo =mData.get(position).getPhoto();



    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv_name,tv_city,tv_phone;
        ImageView img_photo;

        public ListViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            tv_name=itemView.findViewById(R.id.st_01);
            tv_city=itemView.findViewById(R.id.st_2);
            tv_phone=itemView.findViewById(R.id.st_3);
            img_photo=itemView.findViewById(R.id.img_1);


        }

        @Override
        public void onClick(View view) {

        }
        public  interface RecycleViewClickListener{

        }
    }

}
