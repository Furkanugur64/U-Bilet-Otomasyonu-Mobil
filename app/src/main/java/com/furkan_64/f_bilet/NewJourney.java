package com.furkan_64.f_bilet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class NewJourney extends AppCompatActivity {

    EditText TxtNereden,TxtNereye,TxtSure,TxtSaat,TxtFiyat;
    AppCompatButton BtnKaydet,BtnGeri;
    Database DB;
    Spinner sp,sp2;
    private List<String> il_liste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_journey);


        TxtSure = (EditText) findViewById(R.id.TxtSure);
        TxtSaat = (EditText) findViewById(R.id.TxtSaat);
        TxtFiyat = (EditText) findViewById(R.id.TxtFiyat);
        sp = (Spinner) findViewById(R.id.spinner1);
        sp2 = (Spinner) findViewById(R.id.spinner2);
        DB=new Database(this);
        BtnKaydet = (AppCompatButton) findViewById(R.id.BtnKaydet);
        BtnGeri = (AppCompatButton) findViewById(R.id.BtnGeri);
        Bundle bnd=getIntent().getExtras();
        String admintc=bnd.getString("tc");
        String sifre1=bnd.getString("sifre");
         Getir();

        BtnGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecisyap=new Intent(NewJourney.this,AdminPage.class);
                gecisyap.putExtra("tc",admintc);
                gecisyap.putExtra("sifre",sifre1);
                startActivity(gecisyap);
            }
        });

        BtnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nereden = sp.getSelectedItem().toString();
                String nereye = sp2.getSelectedItem().toString();
                String süre = TxtSure.getText().toString();
                String saat = TxtSaat.getText().toString();
                String fiyat = TxtFiyat.getText().toString();
                String koltuk1=" ",koltuk2=" ",koltuk3=" ",koltuk4=" ",koltuk5=" ",koltuk6=" ",koltuk7=" ",koltuk8=" ",koltuk9=" ",koltuk10=" ";


                if (nereden.equals("") ||nereye.equals("")||süre.equals("")||saat.equals("")||fiyat.equals(""))
                    Toast.makeText(NewJourney.this, "Tüm Alanları Doldurun !!", Toast.LENGTH_SHORT).show();
                else {


                        Boolean insert = DB.insertJourney(nereden,nereye,süre,saat,fiyat,koltuk1,koltuk2,koltuk3,koltuk4,koltuk5,koltuk6,koltuk7,koltuk8,koltuk9,koltuk10);
                        if (insert==true){
                            Toast.makeText(NewJourney.this, "Sefer Başarıyla Eklendi", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), AdminPage.class);
                            intent.putExtra("tc",admintc);
                            intent.putExtra("sifre",sifre1);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(NewJourney.this, "Kayıt Hatası !!", Toast.LENGTH_SHORT).show();
                        }


                }
            }
        });


    }
    private void Getir()
    {
        il_liste = DB.getAllStates();

        ArrayAdapter<String> spinner_adapter = new ArrayAdapter<String>(NewJourney.this,R.layout.spinner_item_layout, il_liste);

        spinner_adapter.setDropDownViewResource(R.layout.spinner_item_layout);


        sp.setAdapter(spinner_adapter);
        sp2.setAdapter(spinner_adapter);
    }
}