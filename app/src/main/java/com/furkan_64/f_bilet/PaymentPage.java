package com.furkan_64.f_bilet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.braintreepayments.cardform.view.CardForm;

public class PaymentPage extends AppCompatActivity {
    CardForm cardForm;
    Button BtnGeri,Btnsatınal;
    AlertDialog.Builder alertBuilder;
    String seferid,tc,koltukno;
    Database DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);


        Bundle bnd=getIntent().getExtras();
        seferid=bnd.getString("seferid");
        tc=bnd.getString("tc");
        koltukno=bnd.getString("koltukno");
        DB=new Database(this);



        BtnGeri = findViewById(R.id.BtnodemeGeri);
        Btnsatınal = findViewById(R.id.btnSatınal);

        cardForm = findViewById(R.id.card_form);

        cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .postalCodeRequired(true)
                .mobileNumberRequired(true)
                .mobileNumberExplanation("Telefon Numarası Gereklidir")
                .setup(PaymentPage.this);
        cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        Btnsatınal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cardForm.isValid()) {
                    alertBuilder = new AlertDialog.Builder(PaymentPage.this);
                    alertBuilder.setTitle("Satın Almadan Onaylayın");
                    alertBuilder.setMessage("Kart Numarası: " + cardForm.getCardNumber() + "\n" +
                            "Son Kullanma Tarihi: " + cardForm.getExpirationDateEditText().getText().toString() + "\n" +
                            "Kart CVV: " + cardForm.getCvv() + "\n" +
                            "Posta Kodu: " + cardForm.getPostalCode() + "\n" +
                            "Telefon Numarası: " + cardForm.getMobileNumber());
                    alertBuilder.setPositiveButton("Onayla", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Boolean update = DB.updateJourney(seferid,tc,koltukno);
                            if (update==true){
                                Toast.makeText(PaymentPage.this, "Ödeme Alındı ! Bizi Tercih Ettiğiniz İçin Teşekkür Ederiz", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), UsersPage.class);
                                intent.putExtra("tc",tc);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(PaymentPage.this, "Güncellemede Hata Oluştu", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    alertBuilder.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog alertDialog = alertBuilder.create();
                    alertDialog.show();

                } else {
                    Toast.makeText(PaymentPage.this, "Tüm Formu Doldurun", Toast.LENGTH_LONG).show();
                }
            }
        });

        BtnGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ViewListJourney.class);
                intent.putExtra("tc",tc);
                startActivity(intent);
            }
        });

    }
}