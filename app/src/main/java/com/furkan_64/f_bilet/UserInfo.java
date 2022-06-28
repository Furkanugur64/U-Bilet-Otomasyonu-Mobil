package com.furkan_64.f_bilet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class UserInfo extends AppCompatActivity {

    EditText TxtTc,TxtAd,TxtSoyad,TxtCinsiyet,TxtDogumTarihi,TxtMail,TxtTelefon,TxtSifre;
    AppCompatButton BtnGuncelle,BtnGeri;
    Database DB;
    String tc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        TxtTc = (EditText) findViewById(R.id.TxtUserTC);
        TxtAd = (EditText) findViewById(R.id.TxtUserAd);
        TxtSoyad = (EditText) findViewById(R.id.TxtUserSoyad);
        TxtCinsiyet = (EditText) findViewById(R.id.TxtUserCinsiyet);
        TxtDogumTarihi = (EditText) findViewById(R.id.TxtUserDogumTarihi);
        TxtMail = (EditText) findViewById(R.id.TxtUserMail);
        TxtTelefon = (EditText) findViewById(R.id.TxtUserTelefon);
        TxtSifre = (EditText) findViewById(R.id.TxtUserSifre);
        BtnGeri = (AppCompatButton) findViewById(R.id.BtnGeri);
        BtnGuncelle = (AppCompatButton) findViewById(R.id.BtnGuncelle);
        DB=new Database(this);

        Bundle bnd=getIntent().getExtras();
        tc=bnd.getString("tc1");

        HashMap<String,String> map = DB.UserDetay(tc);
        TxtTc.setText(map.get("tc"));
        TxtAd.setText(map.get("ad"));
        TxtSoyad.setText(map.get("soyad"));
        TxtCinsiyet.setText(map.get("cinsiyet"));
        TxtDogumTarihi.setText(map.get("dogumtarihi"));
        TxtMail.setText(map.get("mail"));
        TxtTelefon.setText(map.get("telefon"));
        TxtSifre.setText(map.get("sifre"));


        BtnGuncelle.setOnClickListener(new View.OnClickListener() {
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

                if (tc.equals("") || ad.equals("") || soyad.equals("") || cinsiyet.equals("") ||dogumtarihi.equals("") || mail.equals("") || telefon.equals("") || sifre.equals(""))
                {
                    Toast.makeText(UserInfo.this, "Tüm Alanları Doldurunuz !!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean checktc= DB.checkusertc(tc);
                    if (checktc==true){
                        Boolean update = DB.updateUser(tc,ad,soyad,cinsiyet,dogumtarihi,mail,telefon,sifre);
                        if (update==true){
                            Toast.makeText(UserInfo.this, "Kullanıcı Başarıyla Güncellendi", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), UsersPage.class);
                            intent.putExtra("tc",tc);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(UserInfo.this, "Güncellemede Hata Oluştu", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(UserInfo.this, "TC Bulunamadı", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        BtnGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), UsersPage.class);
                intent.putExtra("tc",TxtTc.getText().toString());
                startActivity(intent);
            }
        });
    }
}