package com.furkan_64.f_bilet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class AdminInfo extends AppCompatActivity {

    EditText TxtTc,TxtAd,TxtSoyad,TxtSifre;
    AppCompatButton BtnGeri,BtnGuncelle;
    Database DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_info);

        TxtTc = (EditText) findViewById(R.id.TxtAdminTc);
        TxtAd = (EditText) findViewById(R.id.TxtAdminAd);
        TxtSoyad = (EditText) findViewById(R.id.TxtAdminSoyad);
        TxtSifre = (EditText) findViewById(R.id.TxtAdminSifre);
        BtnGeri = (AppCompatButton) findViewById(R.id.BtnGeri);
        BtnGuncelle = (AppCompatButton) findViewById(R.id.BtnGuncelle);
        DB=new Database(this);
        Bundle bnd=getIntent().getExtras();
        String admintc=bnd.getString("tc");
        String adminsifre=bnd.getString("sifre");

        Intent intent=getIntent();
        String tc = intent.getStringExtra("tc");
        TxtTc.setText(admintc);
        TxtSifre.setText(adminsifre);
         HashMap<String,String> map = DB.AdminDetay(tc);
        TxtAd.setText(map.get("ad"));
        TxtSoyad.setText(map.get("soyad"));


        BtnGeri.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent= new Intent(getApplicationContext(), AdminPage.class);
            intent.putExtra("tc",TxtTc.getText().toString());
            intent.putExtra("sifre",TxtSifre.getText().toString());
            startActivity(intent);
        }
        });

        BtnGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tc = TxtTc.getText().toString();
                String ad = TxtAd.getText().toString();
                String soyad = TxtSoyad.getText().toString();
                String sifre = TxtSifre.getText().toString();

                if (tc.equals("") || ad.equals("") || soyad.equals("") || sifre.equals(""))
                {
                    Toast.makeText(AdminInfo.this, "Tüm Alanları Doldurunuz !!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean checktc= DB.checkadmintc(tc);
                    if (checktc==true){
                        Boolean update = DB.updateAdmin(tc,ad,soyad,sifre);
                        if (update==true){
                            Toast.makeText(AdminInfo.this, "Admin Başarıyla Güncellendi", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), AdminPage.class);
                            intent.putExtra("tc",TxtTc.getText().toString());
                            intent.putExtra("sifre",TxtSifre.getText().toString());
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(AdminInfo.this, "Güncellemede Hata Oluştu", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(AdminInfo.this, "TC Bulunamadı", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }
}