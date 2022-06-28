package com.furkan_64.f_bilet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class UsersPage extends AppCompatActivity {

    Database DB;
    AppCompatButton BtnBilgiGuncelle,BtnSeferler,BtnAnasayfa,BtnIl,BtnHakkında;
    String usertc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_page);

        BtnBilgiGuncelle = (AppCompatButton) findViewById(R.id.btnbilgiguncelle);
        BtnSeferler = (AppCompatButton) findViewById(R.id.BtnSeferler);
        BtnAnasayfa = (AppCompatButton) findViewById(R.id.BtnAnasayfa1);
        BtnHakkında = (AppCompatButton) findViewById(R.id.Btnhakkinda);
        BtnIl = (AppCompatButton) findViewById(R.id.BtnIl);
        DB = new Database(this);
        Bundle bnd=getIntent().getExtras();
        usertc=bnd.getString("tc");



        BtnBilgiGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecisyap=new Intent(UsersPage.this,UserInfo.class);
                gecisyap.putExtra("tc1",usertc);
                startActivity(gecisyap);
            }
        });

        BtnSeferler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecisyap=new Intent(UsersPage.this,ViewListJourney.class);
                gecisyap.putExtra("tc",usertc);
                startActivity(gecisyap);
            }
        });

        BtnAnasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecisyap=new Intent(UsersPage.this,MainMenu.class);
                startActivity(gecisyap);
            }
        });

        BtnIl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecisyap=new Intent(UsersPage.this,Viewliststates1.class);
                gecisyap.putExtra("tc",usertc);
                startActivity(gecisyap);
            }
        });

        BtnHakkında.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(UsersPage.this);
                builder.setTitle("U-Bilet Otomasyonu");
                builder.setMessage("Bu Proje 15.06.2022 Tarihinde Mobil Programlama Dersi Final Projesi İçin Furkan UĞUR Tarafından Yapılmıştır.");
                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });
    }
}