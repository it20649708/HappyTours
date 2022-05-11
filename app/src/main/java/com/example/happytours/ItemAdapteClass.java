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

public class ItemAdapteClass extends RecyclerView.Adapter<ItemAdapteClass.ItemViewHolder> {

    Context context;
    List<ItemClass> iData;


    public ItemAdapteClass(Context context, List<ItemClass> iData) {
        this.context = context;
        this.iData = iData;

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layout;
        layout= LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new ItemAdapteClass.ItemViewHolder(layout,context,iData);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        String colour = iData.get(position).getColour();
        String ID =iData.get(position).getID();
        String status = iData.get(position).getStatus();
        String model = iData.get(position).getModel();
        int Iimage = iData.get(position).getIimage();

        holder.icolour.setText(colour);
        holder.iID.setText(ID);
        holder.istatus.setText(status);
        holder.imodel.setText(model);
        holder.iIimage.setImageResource(Iimage);

    }

    @Override
    public int getItemCount() {

        return iData.size();
    }



    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        TextView icolour,iID,istatus,imodel;
        ImageView iIimage;

        public ItemViewHolder(@NonNull View itemView, Context context, List<ItemClass> iData) {
            super(itemView);
            icolour =itemView.findViewById(R.id.itm2);
            iID =itemView.findViewById(R.id.itm3);
            istatus =itemView.findViewById(R.id.itm4);
            imodel =itemView.findViewById(R.id.itm8);
            iIimage =itemView.findViewById(R.id.item1);



    }


}
}
