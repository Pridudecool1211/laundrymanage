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


    TextView q_shirt,q_pant,total_bill,status;
    Button recieve;




    public MenuItemViewHolder(@NonNull final View itemView) {
        super(itemView);


        q_pant= itemView.findViewById(R.id.qpant);
        q_shirt = itemView.findViewById(R.id.qshirt);
        total_bill=itemView.findViewById(R.id.total_bill);
        status=itemView.findViewById(R.id.status);


        recieve = itemView.findViewById(R.id.recieve);




    }

}