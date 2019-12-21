package com.example.laundry_manage;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuitemRVAdapter extends RecyclerView.Adapter<MenuItemViewHolder> {


    ArrayList<LaundryItem> itemList;

    Context context;

    public MenuitemRVAdapter(ArrayList<LaundryItem> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public MenuItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.laundryitemlayout,parent,false);

        MenuItemViewHolder viewHolder= new MenuItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MenuItemViewHolder holder, final int position) {
        int [] qtyary=itemList.get(position).getquantity();
        int bill=itemList.get(position).returnbill();



        holder.q_pant.setText(String.valueOf(qtyary[0]));
        holder.q_shirt.setText(String.valueOf(qtyary[1]));
        holder.total_bill.setText(String.valueOf(bill));

        if(itemList.get(position).getstatuscode()==1)
        {
            holder.status.setText("recieved");
           holder.status.setBackgroundColor(Color.parseColor("#85D530"));
            holder.recieve.setVisibility(View.GONE);
        }

        holder.recieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               itemList.get(position).setstatuscode(1);
                holder.status.setText("recieved");
                holder.status.setBackgroundColor(Color.parseColor("#85D530"));
                holder.recieve.setVisibility(View.GONE);
            }
        });




    }

    @Override
    public int getItemCount() {



        return itemList.size();
    }
}