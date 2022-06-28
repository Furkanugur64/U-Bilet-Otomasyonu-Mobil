package com.furkan_64.f_bilet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewListJourneyAdmin extends AppCompatActivity {
    Database DB;
    AppCompatButton BtnGeri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list_journey_admin);


        DB=new Database(this);
        ListView listView=(ListView) findViewById(R.id.listView);
        BtnGeri=(AppCompatButton) findViewById(R.id.BtnGeri2) ;
        Bundle bnd=getIntent().getExtras();
        String admintc=bnd.getString("tc");
        String sifre1=bnd.getString("sifre");

        ArrayList<String> theList1 = new ArrayList<>();
        Cursor data1 = DB.viewJourney();

        if(data1.getCount() == 0)
        {
            Toast.makeText(this, "Hiç Seyehat Yok",Toast.LENGTH_LONG).show();
        }
        else
        {
            while(data1.moveToNext())
            {

                theList1.add("SeferID:"+"   "+data1.getString(0)+"\n"
                        +"Nereden:"+"  "+data1.getString(1) +"\n"
                        +"Nereye:"+"  "+data1.getString(2)+"\n"
                        +"Tarih:"+"  " +data1.getString(3)+"\n"
                        +"Saat:"+"  " +data1.getString(4)+"\n"
                        +"Fiyat:"+"  "+data1.getString(5));

                theList1.add("");

                ListAdapter listAdapter1 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList1);
                listView.setAdapter(listAdapter1);


            }
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent intent = new Intent(view.getContext(), JourneyDetail.class);
                    intent.putExtra("a","1");
                    intent.putExtra("tc",admintc);
                    intent.putExtra("sifre",sifre1);
                    startActivity(intent);
                }
                if (position == 2){
                    Intent intent = new Intent(view.getContext(), JourneyDetail.class);
                    intent.putExtra("a","2");
                    intent.putExtra("tc",admintc);
                    intent.putExtra("sifre",sifre1);
                    startActivity(intent);
                }
                if (position == 4){
                    Intent intent = new Intent(view.getContext(), JourneyDetail.class);
                    intent.putExtra("a","3");
                    intent.putExtra("tc",admintc);
                    intent.putExtra("sifre",sifre1);
                    startActivity(intent);
                }
                if (position == 6){
                    Intent intent = new Intent(view.getContext(), JourneyDetail.class);
                    intent.putExtra("a","4");
                    intent.putExtra("tc",admintc);
                    intent.putExtra("sifre",sifre1);
                    startActivity(intent);
                }
                if (position == 8){
                    Intent intent = new Intent(view.getContext(), JourneyDetail.class);
                    intent.putExtra("a","5");
                    intent.putExtra("tc",admintc);
                    intent.putExtra("sifre",sifre1);
                    startActivity(intent);
                }
                if (position == 10){
                    Intent intent = new Intent(view.getContext(), JourneyDetail.class);
                    intent.putExtra("a","6");
                    intent.putExtra("tc",admintc);
                    intent.putExtra("sifre",sifre1);
                    startActivity(intent);
                }
                if (position == 12){
                    Intent intent = new Intent(view.getContext(), JourneyDetail.class);
                    intent.putExtra("a","7");
                    intent.putExtra("tc",admintc);
                    intent.putExtra("sifre",sifre1);
                    startActivity(intent);
                }
                if (position == 14){
                    Intent intent = new Intent(view.getContext(), JourneyDetail.class);
                    intent.putExtra("a","8");
                    intent.putExtra("tc",admintc);
                    intent.putExtra("sifre",sifre1);
                    startActivity(intent);
                }
                if (position == 16){
                    Intent intent = new Intent(view.getContext(), JourneyDetail.class);
                    intent.putExtra("a","9");
                    intent.putExtra("tc",admintc);
                    intent.putExtra("sifre",sifre1);
                    startActivity(intent);
                }
                if (position == 18){
                    Intent intent = new Intent(view.getContext(), JourneyDetail.class);
                    intent.putExtra("a","10");
                    intent.putExtra("tc",admintc);
                    intent.putExtra("sifre",sifre1);
                    startActivity(intent);
                }
                if (position == 20){
                    Intent intent = new Intent(view.getContext(), JourneyDetail.class);
                    intent.putExtra("a","11");
                    intent.putExtra("tc",admintc);
                    intent.putExtra("sifre",sifre1);
                    startActivity(intent);
                }
            }
        });

        BtnGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewListJourneyAdmin.this, AdminPage.class);
                intent.putExtra("tc",admintc);
                intent.putExtra("sifre",sifre1);
                startActivity(intent);
            }
        });
    }
}