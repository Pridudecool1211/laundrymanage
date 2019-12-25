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
import android.widget.Toast;

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

                if(q_pant.getText()==null||q_pant.getText().toString().equals("")){
                    q_pant.setText("0");
                }
                if(q_shirt.getText()==null||q_shirt.getText().toString().equals("")){
                    q_shirt.setText("0");
                }
                if(q_jeans.getText()==null||q_jeans.getText().toString().equals("")){
                    q_jeans.setText("0");
                }
                if(q_shorts.getText()==null||q_shorts.getText().toString().equals("")){
                    q_shorts.setText("0");
                }
                if(q_innerwear.getText()==null||q_innerwear.getText().toString().equals("")){
                    q_innerwear.setText("0");
                }
                if(q_socks.getText()==null||q_socks.getText().toString().equals("")){
                    q_socks.setText("0");
                }
                if(q_labcoat.getText()==null||q_labcoat.getText().toString().equals("")){
                    q_labcoat.setText("0");
                }
                if(q_bedsheet.getText()==null||q_bedsheet.getText().toString().equals("")){
                    q_bedsheet.setText("0");
                }
                if(q_pillowcover.getText()==null||q_pillowcover.getText().toString().equals("")){
                    q_pillowcover.setText("0");
                }
                if(q_napkin.getText()==null||q_napkin.getText().toString().equals("")){
                    q_napkin.setText("0");
                }
                if(q_towel.getText()==null||q_towel.getText().toString().equals("")){
                    q_towel.setText("0");
                }
                if(q_blanket.getText()==null||q_blanket.getText().toString().equals("")){
                    q_blanket.setText("0");
                }
                if(q_suit.getText()==null||q_suit.getText().toString().equals("")){
                    q_suit.setText("0");
                }if(q_sweatshirt.getText()==null||q_sweatshirt.getText().toString().equals("")){
                    q_sweatshirt.setText("0");
                }
                if(q_jacket.getText()==null||q_jacket.getText().toString().equals("")){
                    q_jacket.setText("0");
                }
                if(q_salwar.getText()==null||q_salwar.getText().toString().equals("")){
                    q_salwar.setText("0");
                }
                if(q_kameez.getText()==null||q_kameez.getText().toString().equals("")){
                    q_kameez.setText("0");
                }





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
