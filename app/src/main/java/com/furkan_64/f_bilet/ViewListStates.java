package com.furkan_64.f_bilet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewListStates extends AppCompatActivity {
    Database DB;
    AppCompatButton BtnGeri;
    AlertDialog.Builder alertBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list_states);

        DB=new Database(this);
        ListView listView=(ListView) findViewById(R.id.listView);
        BtnGeri=(AppCompatButton) findViewById(R.id.BtnGeri4) ;
        Bundle bnd=getIntent().getExtras();
        String admintc=bnd.getString("tc");
        String sifre1=bnd.getString("sifre");

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = DB.viewStates();

        if(data.getCount() == 0)
        {
            Toast.makeText(this, "Hiç il Yok",Toast.LENGTH_LONG).show();
        }
        else
        {
            while(data.moveToNext())
            {

                theList.add("ilID:"+"   "+data.getString(0)+"\n"
                        +"plaka:"+"  "+data.getString(1) +"\n"
                        +"il:"+"  "+data.getString(2));
                theList.add("");

                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);


            }
        }

        BtnGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecisyap=new Intent(ViewListStates.this,AdminPage.class);
                gecisyap.putExtra("tc",admintc);
                gecisyap.putExtra("sifre",sifre1);
                startActivity(gecisyap);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    alertBuilder = new AlertDialog.Builder(ViewListStates.this);
                    alertBuilder.setTitle("Emin Misiniz ?");
                    alertBuilder.setMessage("Şehri Gerçekten Silmek İstiyormusunuz ?");
                    alertBuilder.setPositiveButton("Onayla", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Boolean delete = DB.DeleteState("2");
                            if (delete==true){
                                Toast.makeText(ViewListStates.this, "İl Başarıyla silindi", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), AdminPage.class);
                                intent.putExtra("tc",admintc);
                                intent.putExtra("sifre",sifre1);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(ViewListStates.this, "Silinirken Hata Oluştu", Toast.LENGTH_SHORT).show();
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
                }
                if (position == 2){
                    alertBuilder = new AlertDialog.Builder(ViewListStates.this);
                    alertBuilder.setTitle("Emin Misiniz ?");
                    alertBuilder.setMessage("Şehri Gerçekten Silmek İstiyormusunuz ?");
                    alertBuilder.setPositiveButton("Onayla", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Boolean delete = DB.DeleteState("3");
                            if (delete==true){
                                Toast.makeText(ViewListStates.this, "İl Başarıyla silindi", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), AdminPage.class);
                                intent.putExtra("tc",admintc);
                                intent.putExtra("sifre",sifre1);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(ViewListStates.this, "Silinirken Hata Oluştu", Toast.LENGTH_SHORT).show();
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
                }
                if (position == 4){
                    alertBuilder = new AlertDialog.Builder(ViewListStates.this);
                    alertBuilder.setTitle("Emin Misiniz ?");
                    alertBuilder.setMessage("Şehri Gerçekten Silmek İstiyormusunuz ?");
                    alertBuilder.setPositiveButton("Onayla", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Boolean delete = DB.DeleteState("4");
                            if (delete==true){
                                Toast.makeText(ViewListStates.this, "İl Başarıyla silindi", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), AdminPage.class);
                                intent.putExtra("tc",admintc);
                                intent.putExtra("sifre",sifre1);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(ViewListStates.this, "Silinirken Hata Oluştu", Toast.LENGTH_SHORT).show();
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
                }
                if (position == 6){
                    alertBuilder = new AlertDialog.Builder(ViewListStates.this);
                    alertBuilder.setTitle("Emin Misiniz ?");
                    alertBuilder.setMessage("Şehri Gerçekten Silmek İstiyormusunuz ?");
                    alertBuilder.setPositiveButton("Onayla", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Boolean delete = DB.DeleteState("5");
                            if (delete==true){
                                Toast.makeText(ViewListStates.this, "İl Başarıyla silindi", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), AdminPage.class);
                                intent.putExtra("tc",admintc);
                                intent.putExtra("sifre",sifre1);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(ViewListStates.this, "Silinirken Hata Oluştu", Toast.LENGTH_SHORT).show();
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
                }
                if (position == 8){
                    alertBuilder = new AlertDialog.Builder(ViewListStates.this);
                    alertBuilder.setTitle("Emin Misiniz ?");
                    alertBuilder.setMessage("Şehri Gerçekten Silmek İstiyormusunuz ?");
                    alertBuilder.setPositiveButton("Onayla", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Boolean delete = DB.DeleteState("6");
                            if (delete==true){
                                Toast.makeText(ViewListStates.this, "İl Başarıyla silindi", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), AdminPage.class);
                                intent.putExtra("tc",admintc);
                                intent.putExtra("sifre",sifre1);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(ViewListStates.this, "Silinirken Hata Oluştu", Toast.LENGTH_SHORT).show();
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
                }
                if (position == 10){
                    alertBuilder = new AlertDialog.Builder(ViewListStates.this);
                    alertBuilder.setTitle("Emin Misiniz ?");
                    alertBuilder.setMessage("Şehri Gerçekten Silmek İstiyormusunuz ?");
                    alertBuilder.setPositiveButton("Onayla", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Boolean delete = DB.DeleteState("7");
                            if (delete==true){
                                Toast.makeText(ViewListStates.this, "İl Başarıyla silindi", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), AdminPage.class);
                                intent.putExtra("tc",admintc);
                                intent.putExtra("sifre",sifre1);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(ViewListStates.this, "Silinirken Hata Oluştu", Toast.LENGTH_SHORT).show();
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
                }
                if (position == 12){
                    alertBuilder = new AlertDialog.Builder(ViewListStates.this);
                    alertBuilder.setTitle("Emin Misiniz ?");
                    alertBuilder.setMessage("Şehri Gerçekten Silmek İstiyormusunuz ?");
                    alertBuilder.setPositiveButton("Onayla", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Boolean delete = DB.DeleteState("8");
                            if (delete==true){
                                Toast.makeText(ViewListStates.this, "İl Başarıyla silindi", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), AdminPage.class);
                                intent.putExtra("tc",admintc);
                                intent.putExtra("sifre",sifre1);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(ViewListStates.this, "Silinirken Hata Oluştu", Toast.LENGTH_SHORT).show();
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
                }
                if (position == 14){
                    alertBuilder = new AlertDialog.Builder(ViewListStates.this);
                    alertBuilder.setTitle("Emin Misiniz ?");
                    alertBuilder.setMessage("Şehri Gerçekten Silmek İstiyormusunuz ?");
                    alertBuilder.setPositiveButton("Onayla", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Boolean delete = DB.DeleteState("9");
                            if (delete==true){
                                Toast.makeText(ViewListStates.this, "İl Başarıyla silindi", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), AdminPage.class);
                                intent.putExtra("tc",admintc);
                                intent.putExtra("sifre",sifre1);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(ViewListStates.this, "Silinirken Hata Oluştu", Toast.LENGTH_SHORT).show();
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
                }
                if (position == 16){
                    alertBuilder = new AlertDialog.Builder(ViewListStates.this);
                    alertBuilder.setTitle("Emin Misiniz ?");
                    alertBuilder.setMessage("Şehri Gerçekten Silmek İstiyormusunuz ?");
                    alertBuilder.setPositiveButton("Onayla", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Boolean delete = DB.DeleteState("10");
                            if (delete==true){
                                Toast.makeText(ViewListStates.this, "İl Başarıyla silindi", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), AdminPage.class);
                                intent.putExtra("tc",admintc);
                                intent.putExtra("sifre",sifre1);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(ViewListStates.this, "Silinirken Hata Oluştu", Toast.LENGTH_SHORT).show();
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
                }
                if (position == 18){
                    alertBuilder = new AlertDialog.Builder(ViewListStates.this);
                    alertBuilder.setTitle("Emin Misiniz ?");
                    alertBuilder.setMessage("Şehri Gerçekten Silmek İstiyormusunuz ?");
                    alertBuilder.setPositiveButton("Onayla", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Boolean delete = DB.DeleteState("11");
                            if (delete==true){
                                Toast.makeText(ViewListStates.this, "İl Başarıyla silindi", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), AdminPage.class);
                                intent.putExtra("tc",admintc);
                                intent.putExtra("sifre",sifre1);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(ViewListStates.this, "Silinirken Hata Oluştu", Toast.LENGTH_SHORT).show();
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
                }
                if (position == 20){
                    alertBuilder = new AlertDialog.Builder(ViewListStates.this);
                    alertBuilder.setTitle("Emin Misiniz ?");
                    alertBuilder.setMessage("Şehri Gerçekten Silmek İstiyormusunuz ?");
                    alertBuilder.setPositiveButton("Onayla", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Boolean delete = DB.DeleteState("12");
                            if (delete==true){
                                Toast.makeText(ViewListStates.this, "İl Başarıyla silindi", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), AdminPage.class);
                                intent.putExtra("tc",admintc);
                                intent.putExtra("sifre",sifre1);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(ViewListStates.this, "Silinirken Hata Oluştu", Toast.LENGTH_SHORT).show();
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
                }
            }
        });

    }
}