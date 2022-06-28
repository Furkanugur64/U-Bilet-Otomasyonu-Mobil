package com.furkan_64.f_bilet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Viewliststates1 extends AppCompatActivity {
    Database DB;
    AppCompatButton BtnGeri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewliststates1);

        DB=new Database(this);
        ListView listView=(ListView) findViewById(R.id.listView);
        BtnGeri=(AppCompatButton) findViewById(R.id.BtnGeri4) ;
        Bundle bnd=getIntent().getExtras();
        String usertc=bnd.getString("tc");


        ArrayList<String> theList = new ArrayList<>();
        Cursor data = DB.viewStates();

        if(data.getCount() == 0)
        {
            Toast.makeText(this, "Hiç il Yok",Toast.LENGTH_LONG).show();
        }
        else
        {
            while(data.moveToNext())
            {

                theList.add("ilID:"+"   "+data.getString(0)+"\n"
                        +"plaka:"+"  "+data.getString(1) +"\n"
                        +"il:"+"  "+data.getString(2));
                theList.add("");

                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);

            }
        }

        BtnGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecisyap=new Intent(Viewliststates1.this,UsersPage.class);
                gecisyap.putExtra("tc",usertc);
                startActivity(gecisyap);
            }
        });
    }
}