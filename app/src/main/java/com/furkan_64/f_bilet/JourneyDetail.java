package com.furkan_64.f_bilet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class JourneyDetail extends AppCompatActivity {
    EditText Txtseferid,TxtNereden,TxtNereye,TxtZaman,TxtSaat,TxtFiyat;
    AppCompatButton BtnGeri,BtnGuncelle;
    Database DB;
    String seferid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journey_detail);

        Txtseferid = (EditText) findViewById(R.id.Txtseferid1);
        TxtNereden = (EditText) findViewById(R.id.TxtNereden1);
        TxtNereye = (EditText) findViewById(R.id.TxtNereye1);
        TxtZaman = (EditText) findViewById(R.id.TxtZaman1);
        TxtSaat = (EditText) findViewById(R.id.TxtSaat1);
        TxtFiyat = (EditText) findViewById(R.id.TxtFiyat1);
        BtnGeri = (AppCompatButton) findViewById(R.id.BtnGeri1);
        BtnGuncelle = (AppCompatButton) findViewById(R.id.BtnGuncelle1);
        DB=new Database(this);

        Bundle bnd=getIntent().getExtras();
        seferid=bnd.getString("a");
        String admintc=bnd.getString("tc");
        String sifre1=bnd.getString("sifre");
        int x=Integer.parseInt(seferid);

        HashMap<String,String> map = DB.journeyDetay1(x);

        Txtseferid.setText(map.get("seferID"));
        TxtNereden.setText(map.get("nereden"));
        TxtNereye.setText(map.get("nereye"));
        TxtZaman.setText(map.get("zaman"));
        TxtSaat.setText(map.get("saat"));
        TxtFiyat.setText(map.get("fiyat"));


        BtnGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String seferid = Txtseferid.getText().toString();
                String nereden = TxtNereden.getText().toString();
                String nereye = TxtNereye.getText().toString();
                String zaman = TxtZaman.getText().toString();
                String saat = TxtSaat.getText().toString();
                String fiyat = TxtFiyat.getText().toString();


                if (seferid.equals("") || nereden.equals("") || nereye.equals("") || zaman.equals("") ||saat.equals("") || fiyat.equals(""))
                {
                    Toast.makeText(JourneyDetail.this, "Tüm Alanları Doldurunuz !!", Toast.LENGTH_SHORT).show();
                }
                else
                {


                        Boolean update = DB.updateJourney1(seferid,nereden,nereye,zaman,saat,fiyat);
                        if (update==true){
                            Toast.makeText(JourneyDetail.this, "Sefer Başarıyla Güncellendi", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), ViewListJourneyAdmin.class);
                            intent.putExtra("tc",admintc);
                            intent.putExtra("sifre",sifre1);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(JourneyDetail.this, "Güncellemede Hata Oluştu", Toast.LENGTH_SHORT).show();
                        }

            }
            }
        });

        BtnGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecisyap=new Intent(JourneyDetail.this,ViewListJourneyAdmin.class);
                gecisyap.putExtra("tc",admintc);
                gecisyap.putExtra("sifre",sifre1);
                startActivity(gecisyap);
            }
        });

    }
}