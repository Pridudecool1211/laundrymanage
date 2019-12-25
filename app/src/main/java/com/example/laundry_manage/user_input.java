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
EditText q_shirt,q_pant,q_jeans,q_shorts,q_innerwear,q_socks,q_labcoat,q_bedsheet,q_pillowcover,q_napkin,q_towel,q_blanket,q_suit,q_sweatshirt,q_jacket,q_salwar,q_kameez;


    public user_input(){}



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);


        q_shirt=findViewById(R.id.shirtq);
        q_pant=findViewById(R.id.pantq);
        q_jeans=findViewById(R.id.jeansq);
        q_shorts=findViewById(R.id.shortsq);
        q_innerwear=findViewById(R.id.innerwearq);
        q_socks=findViewById(R.id.socksq);
        q_labcoat=findViewById(R.id.labcoatq);
        q_bedsheet=findViewById(R.id.bedsheetq);
        q_pillowcover=findViewById(R.id.pillowcoverq);
        q_napkin=findViewById(R.id.napkinq);
        q_towel=findViewById(R.id.towelq);
        q_blanket=findViewById(R.id.blanketq);
        q_suit=findViewById(R.id.suitq);
        q_sweatshirt=findViewById(R.id.sweatshirtq);
        q_jacket=findViewById(R.id.jacketq);
        q_salwar=findViewById(R.id.salwarq);
        q_kameez=findViewById(R.id.kameezq);





        save=findViewById(R.id.save);




        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

int[] qarr={Integer.parseInt(q_pant.getText().toString()),Integer.parseInt(q_shirt.getText().toString()),Integer.parseInt(q_jeans.getText().toString()),Integer.parseInt(q_shorts.getText().toString()),Integer.parseInt(q_innerwear.getText().toString()),Integer.parseInt(q_socks.getText().toString()),Integer.parseInt(q_labcoat.getText().toString()),Integer.parseInt(q_bedsheet.getText().toString()),Integer.parseInt(q_pillowcover.getText().toString()),Integer.parseInt(q_napkin.getText().toString()),Integer.parseInt(q_towel.getText().toString()),Integer.parseInt(q_blanket.getText().toString()),Integer.parseInt(q_suit.getText().toString()),Integer.parseInt(q_sweatshirt.getText().toString()),Integer.parseInt(q_jacket.getText().toString()),Integer.parseInt(q_salwar.getText().toString()),Integer.parseInt(q_kameez.getText().toString())};

                LaundryItem input = new LaundryItem(qarr);

                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",input);
                setResult(RESULT_OK,returnIntent);
                finish();


            }
        });



    }


}
