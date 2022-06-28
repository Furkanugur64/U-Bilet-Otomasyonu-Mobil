package com.furkan_64.f_bilet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminLoginPage extends AppCompatActivity {

    EditText TxtTc,TxtSifre;
    AppCompatButton BtnGiris;
    TextView LblKayit;
    Database DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login_page);

        LblKayit=(TextView) findViewById(R.id.LblKayit);
        TxtTc=(EditText) findViewById(R.id.TxtAdminLoginTc);
        TxtSifre=(EditText) findViewById(R.id.TxtAdminLoginSifre);
        BtnGiris=(AppCompatButton) findViewById(R.id.BtnGirisLoginAdmin);
        DB=new Database(this);


        BtnGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tc=TxtTc.getText().toString();
                String sifresi=TxtSifre.getText().toString();
                if (tc.equals("") || sifresi.equals(""))
                    Toast.makeText(AdminLoginPage.this, "Lütfen Tüm Alanları Doldurun !", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkadminuserpass = DB.checkadminusernamepassword(tc, sifresi);
                    if (checkadminuserpass==true){
                        Toast.makeText(AdminLoginPage.this, "Giriş Başarılı", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(getApplicationContext(), AdminPage.class);
                        intent.putExtra("tc",TxtTc.getText().toString());
                        intent.putExtra("sifre",TxtSifre.getText().toString());
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(AdminLoginPage.this, "TC ve/veya Şifre Yanlış !!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        LblKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminLoginPage.this,RegisterAdmin.class));
            }
        });
    }
}