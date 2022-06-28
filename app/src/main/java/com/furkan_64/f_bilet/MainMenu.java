package com.furkan_64.f_bilet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    AppCompatButton BtnKullaniciGiris,BtnAdminGiris,BtnCikis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        BtnKullaniciGiris = (AppCompatButton) findViewById(R.id.BtnKullaniciGiris);
        BtnAdminGiris = (AppCompatButton) findViewById(R.id.BtnAdminGiris);
        BtnCikis = (AppCompatButton) findViewById(R.id.BtnCikis);


        BtnAdminGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainMenu.this,AdminLoginPage.class));
            }
        });

        BtnKullaniciGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainMenu.this,LoginPage.class));
            }
        });

        BtnCikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder uyarıpenceresi= new AlertDialog.Builder(MainMenu.this);
                uyarıpenceresi.setTitle("ÇIKIŞ");
                uyarıpenceresi.setMessage("ÇIKIŞ YAPILSIN MI");
                uyarıpenceresi.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finishAffinity();;
                        System.exit(0);
                    }
                });
                uyarıpenceresi.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                uyarıpenceresi.show();
            }
        });
    }
}