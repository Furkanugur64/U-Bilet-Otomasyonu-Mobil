package com.furkan_64.f_bilet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterAdmin extends AppCompatActivity {
    Database DB;
    EditText TxtAd,TxtSoyad,TxtSifre,TxtTc;
    AppCompatButton BtnKayitOl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_admin);
        TxtTc = (EditText) findViewById(R.id.TxtTc);
        TxtAd = (EditText) findViewById(R.id.TxtAd);
        TxtSoyad = (EditText) findViewById(R.id.TxtSoyad);
        TxtSifre = (EditText) findViewById(R.id.TxtSifre);
        BtnKayitOl = (AppCompatButton) findViewById(R.id.BtnKayitOl);
        DB = new Database(this);

        BtnKayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tc = TxtTc.getText().toString();
                String ad = TxtAd.getText().toString();
                String soyad = TxtSoyad.getText().toString();
                String sifre = TxtSifre.getText().toString();

                if (tc.equals("") ||ad.equals("") ||soyad.equals("")||sifre.equals(""))
                    Toast.makeText(RegisterAdmin.this, "Tüm Alanları Doldurun !!", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuser = DB.checkadminusername(tc);
                    if (checkuser==false){
                        Boolean insert = DB.insertadmin(tc,ad,soyad,sifre);
                        if (insert==true){
                            Toast.makeText(RegisterAdmin.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), AdminLoginPage.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(RegisterAdmin.this, "Kayıt Hatası", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(RegisterAdmin.this, "Admin Zaten Kayıtlı Lütfen Giriş Yapın !", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), AdminLoginPage.class);
                        startActivity(intent);
                    }
                }
            }
        });

    }
}