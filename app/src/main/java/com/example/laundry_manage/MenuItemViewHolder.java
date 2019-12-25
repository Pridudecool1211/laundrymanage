package com.example.laundry_manage;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuItemViewHolder extends RecyclerView.ViewHolder {


    TextView q_shirt,q_pant,q_jeans,q_shorts,q_innerwear,q_socks,q_labcoat,q_bedsheet,q_pillowcover,q_napkin,q_towel,q_blanket,q_suit,q_sweatshirt,q_jacket,q_salwar,q_kameez,total_bill,status;
    Button recieve;




    public MenuItemViewHolder(@NonNull final View itemView) {
        super(itemView);


        q_pant= itemView.findViewById(R.id.qpant);
        q_shirt = itemView.findViewById(R.id.qshirt);
        q_jeans= itemView.findViewById(R.id.qjeans);
        q_shorts= itemView.findViewById(R.id.qshorts);
        q_innerwear= itemView.findViewById(R.id.qinnerwear);
        q_socks= itemView.findViewById(R.id.qsocks);
        q_labcoat= itemView.findViewById(R.id.qlabcoat);
        q_bedsheet= itemView.findViewById(R.id.qbedsheet);
        q_pillowcover= itemView.findViewById(R.id.qpillowcover);
        q_napkin= itemView.findViewById(R.id.qnapkin);
        q_towel= itemView.findViewById(R.id.qtowel);
        q_blanket= itemView.findViewById(R.id.qblanket);
        q_suit= itemView.findViewById(R.id.qsuit);
        q_sweatshirt= itemView.findViewById(R.id.qsweatshirt);
        q_jacket= itemView.findViewById(R.id.qjacket);
        q_salwar= itemView.findViewById(R.id.qsalwar);
        q_kameez= itemView.findViewById(R.id.qkameez);

        total_bill=itemView.findViewById(R.id.total_bill);
        status=itemView.findViewById(R.id.status);


        recieve = itemView.findViewById(R.id.recieve);




    }

}