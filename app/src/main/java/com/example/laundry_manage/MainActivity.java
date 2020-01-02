package com.example.laundry_manage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MenuitemRVAdapter adapter;
    Button add,clrhistory;


    ArrayList<LaundryItem> itemlist= new ArrayList<>();
    ArrayList<LaundryItem> t_itemlist= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t_itemlist=getItems(getApplicationContext());
        if(t_itemlist==null)
        {;}
        else{
            itemlist=getItems(getApplicationContext());
        }




        add=findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent out = new Intent(getApplicationContext(), user_input.class);
                startActivityForResult(out,1);
            }
        });

        initRecyclerView();

        clrhistory=findViewById(R.id.clr_his);
        clrhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=itemlist.size()-1;i>=0;i--)
                {
                    if((itemlist.get(i).getstatuscode())==1)
                    {
                        itemlist.remove(i);
                    }
                }
                saveItems(getApplicationContext(),itemlist);
                initRecyclerView();
            }
        });






    }
    public void initRecyclerView() {

        recyclerView = findViewById(R.id.laundryrv);
        adapter = new MenuitemRVAdapter(itemlist, getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode,  resultCode,  data);

        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                LaundryItem Input=(LaundryItem) data.getSerializableExtra("result");
                int[] quantity=Input.getquantity();

                final  SharedPreferences sd = getApplicationContext().getSharedPreferences("MYPREF",MODE_PRIVATE);
                SharedPreferences.Editor ed = sd.edit();

               // sd.getString("Dates","N/A");
                //Toast.makeText(this, sd.getString("Dates","N/A"), Toast.LENGTH_SHORT).show();

                itemlist.add(0,new LaundryItem(quantity,sd.getString("Dates","N/A")));
                saveItems(getApplicationContext(),itemlist);
                initRecyclerView();
            }

        }
    }//onActivityResult

    public void saveItems(Context context,ArrayList<LaundryItem> itmlist){
        SharedPreferences pref;
        pref=context.getSharedPreferences("MyPrefs",MODE_PRIVATE);
         SharedPreferences.Editor ed=pref.edit();
         Gson gson=new Gson();
         String savestring=gson.toJson(itmlist);
         ed.putString("MyPrefs",savestring);
         ed.apply();
    }

    public ArrayList<LaundryItem> getItems(Context context){
        SharedPreferences sharedpref;
       sharedpref = context.getSharedPreferences("MyPrefs",
                MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedpref.getString("MyPrefs", null);
        Type type = new TypeToken<ArrayList<LaundryItem>>() {}.getType();
        ArrayList<LaundryItem> arlist= gson.fromJson(json, type);
        if(arlist==null)
        {return null;}
        else return arlist;

    }
}

