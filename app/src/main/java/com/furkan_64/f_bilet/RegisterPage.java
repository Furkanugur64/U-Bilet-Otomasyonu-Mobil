package com.furkan_64.f_bilet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.net.MailTo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity {

    Database DB;
    TextView LblGiris;
    EditText TxtAd,TxtSoyad,TxtTc,TxtDogumTarihi,TxtMail,TxtTelefon, TxtSifre, TxtCinsiyet;
    AppCompatButton BtnKayitOl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        TxtAd = (EditText) findViewById(R.id.TxtAd);
        TxtSoyad = (EditText) findViewById(R.id.TxtSoyad);
        TxtTc = (EditText) findViewById(R.id.TxtTc);
        TxtDogumTarihi = (EditText) findViewById(R.id.TxtDogumTarihi);
        TxtMail = (EditText) findViewById(R.id.TxtMail);
        TxtTelefon = (EditText) findViewById(R.id.TxtTelefon);
        TxtSifre = (EditText) findViewById(R.id.TxtSifre);
        TxtCinsiyet=(EditText) findViewById(R.id.TxtCinsiyet);
        BtnKayitOl = (AppCompatButton) findViewById(R.id.BtnKayitOl);
        LblGiris=(TextView) findViewById(R.id.LblGiris);

        DB = new Database(this);

        BtnKayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tc = TxtTc.getText().toString();
                String ad = TxtAd.getText().toString();
                String soyad = TxtSoyad.getText().toString();
                String cinsiyet = TxtCinsiyet.getText().toString();
                String dogumtarihi = TxtDogumTarihi.getText().toString();
                String mail = TxtMail.getText().toString();
                String telefon = TxtTelefon.getText().toString();
                String sifre = TxtSifre.getText().toString();


                if (ad.equals("") ||soyad.equals("")||tc.equals("")||dogumtarihi.equals("")||mail.equals("")||telefon.equals("")||sifre.equals(""))
                    Toast.makeText(RegisterPage.this, "Tüm Alanları Doldurun !!", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuser = DB.checktc(tc);
                    if (checkuser==false){
                        Boolean insert = DB.insertusers(tc,ad,soyad,cinsiyet,dogumtarihi,mail,telefon,sifre);
                        if (insert==true){
                            Toast.makeText(RegisterPage.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(RegisterPage.this, "Kayıt Hatası !!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(RegisterPage.this, "Kullanıcı Zaten Kayıtlı Lütfen Giriş Yapın !", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                        startActivity(intent);
                    }
                }

            }
        });

        LblGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterPage.this,LoginPage.class));
            }
        });
    }


}