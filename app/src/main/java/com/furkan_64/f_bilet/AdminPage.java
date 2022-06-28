package com.furkan_64.f_bilet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminPage extends AppCompatActivity {
    Database DB;
    AppCompatButton BtnBilgiGuncelle,BtnYeniSehir,BtnAnasayfa,BtnYeniSefer,BtnSeferGuncelle,BtnSehirSil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);


        BtnBilgiGuncelle = (AppCompatButton) findViewById(R.id.btnbilgiguncelle);
        BtnYeniSefer = (AppCompatButton) findViewById(R.id.BtnYeniSefer);
        BtnYeniSehir = (AppCompatButton) findViewById(R.id.BtnYeniSehir);
        BtnAnasayfa = (AppCompatButton) findViewById(R.id.BtnAnasayfa);
        BtnSeferGuncelle = (AppCompatButton) findViewById(R.id.Btnsefergüncelle);
        BtnSehirSil = (AppCompatButton) findViewById(R.id.BtnSehirSil);
        DB = new Database(this);
        Bundle bnd=getIntent().getExtras();
        String admintc=bnd.getString("tc");
        String adminsifre=bnd.getString("sifre");


        BtnBilgiGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecisyap=new Intent(AdminPage.this,AdminInfo.class);
                gecisyap.putExtra("tc",admintc);
                gecisyap.putExtra("sifre",adminsifre);
                startActivity(gecisyap);
            }
        });

        BtnYeniSehir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecisyap=new Intent(AdminPage.this,AdminNewState.class);
                gecisyap.putExtra("tc",admintc);
                gecisyap.putExtra("sifre",adminsifre);

                startActivity(gecisyap);
            }
        });
        BtnAnasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecisyap=new Intent(AdminPage.this,MainMenu.class);
                startActivity(gecisyap);
            }
        });

        BtnYeniSefer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecisyap=new Intent(AdminPage.this,NewJourney.class);
                gecisyap.putExtra("tc",admintc);
                gecisyap.putExtra("sifre",adminsifre);
                startActivity(gecisyap);
            }
        });

        BtnSeferGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecisyap=new Intent(AdminPage.this,ViewListJourneyAdmin.class);
                gecisyap.putExtra("tc",admintc);
                gecisyap.putExtra("sifre",adminsifre);
                startActivity(gecisyap);
            }
        });

        BtnSehirSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecisyap=new Intent(AdminPage.this,ViewListStates.class);
                gecisyap.putExtra("tc",admintc);
                gecisyap.putExtra("sifre",adminsifre);
                startActivity(gecisyap);
            }
        });

    }
}