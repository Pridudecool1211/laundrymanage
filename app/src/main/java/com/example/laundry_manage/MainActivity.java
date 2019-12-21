package com.example.laundry_manage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MenuitemRVAdapter adapter;
    Button add;

    ArrayList<LaundryItem> itemlist= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent out = new Intent(getApplicationContext(), user_input.class);
                startActivityForResult(out,1);
            }
        });

        initRecyclerView();




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
                itemlist.add(0,new LaundryItem(quantity));
                initRecyclerView();
            }

        }
    }//onActivityResult
}
