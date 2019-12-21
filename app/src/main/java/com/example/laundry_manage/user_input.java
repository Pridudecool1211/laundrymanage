package com.example.laundry_manage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class user_input extends AppCompatActivity  {


    Button save;
EditText q_shirt,q_pant;


    public user_input(){}



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);

        q_shirt=findViewById(R.id.shirtq);
        q_pant=findViewById(R.id.pantq);


        save=findViewById(R.id.save);




        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

int[] qarr={Integer.parseInt(q_pant.getText().toString()),Integer.parseInt(q_shirt.getText().toString())};

                LaundryItem input = new LaundryItem(qarr);

                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",input);
                setResult(RESULT_OK,returnIntent);
                finish();


            }
        });



    }


}
