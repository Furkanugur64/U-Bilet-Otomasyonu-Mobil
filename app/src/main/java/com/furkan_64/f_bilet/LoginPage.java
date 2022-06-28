package com.furkan_64.f_bilet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    TextView LblKayit;
    EditText TxtTc,TxtSifre;
    AppCompatButton BtnGirisYap;
    Database DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        LblKayit=(TextView) findViewById(R.id.LblKayit);
        TxtTc=(EditText) findViewById(R.id.TxtUserTcLogin);
        TxtSifre=(EditText) findViewById(R.id.TxtUserSifreLogin);
        BtnGirisYap=(AppCompatButton) findViewById(R.id.BtnGirisUser);
        DB=new Database(this);

        BtnGirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tc=TxtTc.getText().toString();
                String sifresi=TxtSifre.getText().toString();
                if (tc.equals("") || sifresi.equals(""))
                    Toast.makeText(LoginPage.this, "Lütfen Tüm Alanları Doldurun !", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkusertcpass = DB.checkusertcpassword(tc, sifresi);
                    if (checkusertcpass==true){
                        Toast.makeText(LoginPage.this, "Giriş Başarılı", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(getApplicationContext(), UsersPage.class);
                        intent.putExtra("tc",TxtTc.getText().toString());
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(LoginPage.this, "TC ve/veya Şifre Yanlış !!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });




        LblKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginPage.this,RegisterPage.class));
            }
        });
    }
}