package com.example.laundry_manage;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
        holder.q_jeans.setText(String.valueOf(qtyary[2]));
        holder.q_shorts.setText(String.valueOf(qtyary[3]));
        holder.q_innerwear.setText(String.valueOf(qtyary[4]));
        holder.q_socks.setText(String.valueOf(qtyary[5]));
        holder.q_labcoat.setText(String.valueOf(qtyary[6]));
        holder.q_bedsheet.setText(String.valueOf(qtyary[7]));
        holder.q_pillowcover.setText(String.valueOf(qtyary[8]));
        holder.q_napkin.setText(String.valueOf(qtyary[9]));
        holder.q_towel.setText(String.valueOf(qtyary[10]));
        holder.q_blanket.setText(String.valueOf(qtyary[11]));
        holder.q_suit.setText(String.valueOf(qtyary[12]));
        holder.q_sweatshirt.setText(String.valueOf(qtyary[13]));
        holder.q_jacket.setText(String.valueOf(qtyary[14]));
        holder.q_salwar.setText(String.valueOf(qtyary[15]));
        holder.q_kameez.setText(String.valueOf(qtyary[16]));






        holder.textView1.setText(String.valueOf(bill));
        String dt=itemList.get(position).returndate();
        holder.textView3.setText((dt.substring(0,12)));
        holder.textView2.setText(dt.substring(dt.length()-5));









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
                MainActivity mainact= new MainActivity();
               itemList.get(position).setstatuscode(1);
               mainact.saveItems(context,itemList);
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