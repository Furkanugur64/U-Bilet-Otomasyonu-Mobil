package com.furkan_64.f_bilet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.HashMap;

public class Bus extends AppCompatActivity {
    Database DB;
    ImageView koltuk1,koltuk2,koltuk3,koltuk4,koltuk5,koltuk6,koltuk7,koltuk8,koltuk9,koltuk10;
    AppCompatButton BtnGeri,Btnanasayfa;
    String seferid,tc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
        DB=new Database(this);
        koltuk1=(ImageView) findViewById(R.id.koltuk1);
        koltuk2=(ImageView) findViewById(R.id.koltuk2);
        koltuk3=(ImageView) findViewById(R.id.koltuk3);
        koltuk4=(ImageView) findViewById(R.id.koltuk4);
        koltuk5=(ImageView) findViewById(R.id.koltuk5);
        koltuk6=(ImageView) findViewById(R.id.koltuk6);
        koltuk7=(ImageView) findViewById(R.id.koltuk7);
        koltuk8=(ImageView) findViewById(R.id.koltuk8);
        koltuk9=(ImageView) findViewById(R.id.koltuk9);
        koltuk10=(ImageView) findViewById(R.id.koltuk10);
        Btnanasayfa=(AppCompatButton) findViewById(R.id.BtnAnasayfam);
        BtnGeri=(AppCompatButton) findViewById(R.id.BtnGeribus);

        Bundle bnd=getIntent().getExtras();
        tc=bnd.getString("tc");
        seferid=bnd.getString("a");

        int c=Integer.parseInt(seferid.toString());

        HashMap<String,String> map = DB.journeyDetay(c);



        koltuk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PaymentPage.class);
                intent.putExtra("koltukno","koltuk1");
                intent.putExtra("seferid",seferid);
                intent.putExtra("tc",tc);
                startActivity(intent);
            }
        });
        koltuk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PaymentPage.class);
                intent.putExtra("koltukno","koltuk2");
                intent.putExtra("seferid",seferid);
                intent.putExtra("tc",tc);
                startActivity(intent);
            }
        });
        koltuk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PaymentPage.class);
                intent.putExtra("koltukno","koltuk3");
                intent.putExtra("seferid",seferid);
                intent.putExtra("tc",tc);
                startActivity(intent);
            }
        });
        koltuk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PaymentPage.class);
                intent.putExtra("koltukno","koltuk4");
                intent.putExtra("seferid",seferid);
                intent.putExtra("tc",tc);
                startActivity(intent);
            }
        });
        koltuk5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PaymentPage.class);
                intent.putExtra("koltukno","koltuk5");
                intent.putExtra("seferid",seferid);
                intent.putExtra("tc",tc);
                startActivity(intent);
            }
        });
        koltuk6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PaymentPage.class);
                intent.putExtra("koltukno","koltuk6");
                intent.putExtra("seferid",seferid);
                intent.putExtra("tc",tc);
                startActivity(intent);
            }
        });
        koltuk7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PaymentPage.class);
                intent.putExtra("koltukno","koltuk7");
                intent.putExtra("seferid",seferid);
                intent.putExtra("tc",tc);
                startActivity(intent);
            }
        });
        koltuk8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PaymentPage.class);
                intent.putExtra("koltukno","koltuk8");
                intent.putExtra("seferid",seferid);
                intent.putExtra("tc",tc);
                startActivity(intent);
            }
        });
        koltuk9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PaymentPage.class);
                intent.putExtra("koltukno","koltuk9");
                intent.putExtra("seferid",seferid);
                intent.putExtra("tc",tc);
                startActivity(intent);
            }
        });
        koltuk10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PaymentPage.class);
                intent.putExtra("koltukno","koltuk10");
                intent.putExtra("seferid",seferid);
                intent.putExtra("tc",tc);
                startActivity(intent);
            }
        });

        if(map.get("koltuk1").equals(" "))
        {
            koltuk1.setImageResource(R.drawable.seat);
        }
        else
        {
            koltuk1.setImageResource(R.drawable.fullseat);
            koltuk1.setEnabled(false);
        }
        if(map.get("koltuk2").equals(" "))
        {
            koltuk2.setImageResource(R.drawable.seat);
        }
        else
        {
            koltuk2.setImageResource(R.drawable.fullseat);
            koltuk2.setEnabled(false);
        }
        if(map.get("koltuk3").equals(" "))
        {
            koltuk3.setImageResource(R.drawable.seat);
        }
        else
        {
            koltuk3.setImageResource(R.drawable.fullseat);
            koltuk3.setEnabled(false);
        }
        if(map.get("koltuk4").equals(" "))
        {
            koltuk4.setImageResource(R.drawable.seat);
        }
        else
        {
            koltuk4.setImageResource(R.drawable.fullseat);
            koltuk4.setEnabled(false);
        }
        if(map.get("koltuk5").equals(" "))
        {
            koltuk5.setImageResource(R.drawable.seat);
        }
        else
        {
            koltuk5.setImageResource(R.drawable.fullseat);
            koltuk5.setEnabled(false);
        }
        if(map.get("koltuk6").equals(" "))
        {
            koltuk6.setImageResource(R.drawable.seat);
        }
        else
        {
            koltuk6.setImageResource(R.drawable.fullseat);
            koltuk6.setEnabled(false);
        }
        if(map.get("koltuk7").equals(" "))
        {
            koltuk7.setImageResource(R.drawable.seat);
        }
        else
        {
            koltuk7.setImageResource(R.drawable.fullseat);
            koltuk7.setEnabled(false);
        }
        if(map.get("koltuk8").equals(" "))
        {
            koltuk8.setImageResource(R.drawable.seat);
        }
        else
        {
            koltuk8.setImageResource(R.drawable.fullseat);
            koltuk8.setEnabled(false);
        }
        if(map.get("koltuk9").equals(" "))
        {
            koltuk9.setImageResource(R.drawable.seat);
        }
        else
        {
            koltuk9.setImageResource(R.drawable.fullseat);
            koltuk9.setEnabled(false);
        }
        if(map.get("koltuk10").equals(" "))
        {
            koltuk10.setImageResource(R.drawable.seat);
        }
        else
        {
            koltuk10.setImageResource(R.drawable.fullseat);
            koltuk10.setEnabled(false);
        }

        BtnGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bus.this, ViewListJourney.class);
                intent.putExtra("tc",tc);
                startActivity(intent);
            }
        });

        Btnanasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bus.this, UsersPage.class);
                intent.putExtra("tc",tc);
                startActivity(intent);
            }
        });


    }
}