package com.furkan_64.f_bilet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminNewState extends AppCompatActivity {

    EditText TxtSehir,TxtPlaka;
    AppCompatButton BtnSehirEkle,BtnGeri;
    Database DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_new_state);

        TxtSehir = (EditText) findViewById(R.id.Txtil);
        TxtPlaka = (EditText) findViewById(R.id.TxtPlaka);
        BtnSehirEkle = (AppCompatButton) findViewById(R.id.BtnSehirEkle);
        BtnGeri = (AppCompatButton) findViewById(R.id.BtnSehirGeri);
        DB=new Database(this);
        Intent intent=getIntent();
        String tc = intent.getStringExtra("tc");
        String sifre1 = intent.getStringExtra("sifre");


        BtnSehirEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String plaka = TxtPlaka.getText().toString();
                String sehir = TxtSehir.getText().toString();

                if (plaka.equals("") ||sehir.equals(""))
                    Toast.makeText(AdminNewState.this, "Tüm Alanları Doldurun !!", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkState = DB.checkState(plaka);
                    if (checkState==false){
                        Boolean insert = DB.insertState(plaka,sehir);
                        if (insert==true){
                            Toast.makeText(AdminNewState.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), AdminPage.class);
                            intent.putExtra("tc",tc);
                            intent.putExtra("sifre",sifre1);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(AdminNewState.this, "Kayıt Hatası", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(AdminNewState.this, "Bu plakada il kayıtlı !", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

        BtnGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), AdminPage.class);
                intent.putExtra("tc",tc);
                intent.putExtra("sifre",sifre1);
                startActivity(intent);
            }
        });


    }
}