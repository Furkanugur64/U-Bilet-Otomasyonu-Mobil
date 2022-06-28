package com.furkan_64.f_bilet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    public static final String DBNAME = "Project.db";


    public Database(Context context) {
        super(context, "Project.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table admin(tc TEXT primary key , ad TEXT, soyad TEXT, sifre TEXT)");
        MyDB.execSQL("create Table kullanici(tc TEXT primary key , ad TEXT, soyad TEXT, cinsiyet TEXT, dogumtarihi TEXT, mail TEXT, telefon TEXT, sifre TEXT)");
        MyDB.execSQL("create Table iller(ilID INTEGER primary key AUTOINCREMENT, plaka TEXT, il TEXT)");
        MyDB.execSQL("create Table sefer(seferID INTEGER primary key AUTOINCREMENT ,nereden TEXT,nereye TEXT,zaman TEXT,saat TEXT,fiyat TEXT,koltuk1 TEXT,koltuk2 TEXT,koltuk3 TEXT,koltuk4 TEXT,koltuk5 TEXT,koltuk6 TEXT,koltuk7 TEXT,koltuk8 TEXT,koltuk9 TEXT,koltuk10 TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists admin");
        MyDB.execSQL("drop Table if exists kullanici");
        MyDB.execSQL("drop table if exists sefer");
        MyDB.execSQL("drop table if exists iller");

    }

    public Boolean insertadmin(String tc,String ad, String soyad, String sifre)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tc", tc);
        contentValues.put("ad", ad);
        contentValues.put("soyad", soyad);
        contentValues.put("sifre", sifre);

        long result = MyDB.insert("admin",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    public boolean checkadminusername(String tc1){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from admin where tc = ?", new String[] {tc1});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean insertusers(String tc,String ad,String soyad,String cinsiyet,String dogumtarihi,String mail,String telefon,String sifre)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tc", tc);
        contentValues.put("ad", ad);
        contentValues.put("soyad", soyad);
        contentValues.put("cinsiyet", cinsiyet);
        contentValues.put("dogumtarihi", dogumtarihi);
        contentValues.put("mail", mail);
        contentValues.put("telefon", telefon);
        contentValues.put("sifre", sifre);


        long result = MyDB.insert("kullanici",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    public boolean checktc(String tc){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from kullanici where  tc= ?", new String[] {tc});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public boolean checkadminusernamepassword(String tc, String sifre){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from admin where tc = ? and sifre = ?", new String[] {tc,sifre});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }


    public HashMap<String,String> AdminDetay(String tc1){

        HashMap<String,String> adminbilgi = new HashMap<String,String>();
        String selectQuery = "SELECT * FROM admin WHERE tc="+tc1;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            adminbilgi.put("tc", cursor.getString(0));
            adminbilgi.put("ad", cursor.getString(1));
            adminbilgi.put("soyad", cursor.getString(2));
            adminbilgi.put("sifre", cursor.getString(3));
        }
        cursor.close();
        db.close();
        return adminbilgi;
    }

    public Boolean updateAdmin(String tc, String ad, String soyad, String sifre)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ad", ad);
        contentValues.put("soyad", soyad);
        contentValues.put("sifre", sifre);

        Cursor cursor = MyDB.rawQuery("Select * from admin where tc = ?", new String[] {tc});
        if (cursor.getCount()>0){
            long result = MyDB.update("admin", contentValues,"tc=?", new String[] {tc});
            if(result==-1) return false;
            else
                return true;
        }
        else
        {
            return false;
        }
    }

    public boolean checkadmintc(String tc){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from admin where tc = ?", new String[] {tc});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public boolean checkusertc(String tc){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from kullanici where tc = ?", new String[] {tc});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean updateUser(String tc, String ad, String soyad, String cinsiyet,String dogumTarihi,String mail,String telefon,String sifre)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ad", ad);
        contentValues.put("soyad", soyad);
        contentValues.put("cinsiyet", cinsiyet);
        contentValues.put("dogumtarihi", dogumTarihi);
        contentValues.put("mail", mail);
        contentValues.put("telefon", telefon);
        contentValues.put("sifre", sifre);


        Cursor cursor = MyDB.rawQuery("Select * from kullanici where tc = ?", new String[] {tc});
        if (cursor.getCount()>0){
            long result = MyDB.update("kullanici", contentValues,"tc=?", new String[] {tc});

            if(result==-1) return false;
            else
                return true;
        }
        else
        {
            return false;
        }
    }

    public HashMap<String,String> UserDetay(String tc1){

        HashMap<String,String> kullanicibilgi = new HashMap<String,String>();
        String selectQuery = "SELECT * FROM kullanici WHERE tc="+tc1;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            kullanicibilgi.put("tc", cursor.getString(0));
            kullanicibilgi.put("ad", cursor.getString(1));
            kullanicibilgi.put("soyad", cursor.getString(2));
            kullanicibilgi.put("cinsiyet", cursor.getString(3));
            kullanicibilgi.put("dogumtarihi", cursor.getString(4));
            kullanicibilgi.put("mail", cursor.getString(5));
            kullanicibilgi.put("telefon", cursor.getString(6));
            kullanicibilgi.put("sifre", cursor.getString(7));
        }
        cursor.close();
        db.close();
        return kullanicibilgi;
    }

    public boolean checkusertcpassword(String tc, String sifre){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from kullanici where tc = ? and sifre = ?", new String[] {tc,sifre});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public boolean checkState (String plaka1){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from iller where plaka = ? ", new String[] {plaka1});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean insertState(String plaka,String il)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("plaka", plaka);
        contentValues.put("il", il);
        long result = MyDB.insert("iller",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    public Boolean insertJourney(String nereden,String nereye,String sure,String saat,String fiyat,String koltuk1,String koltuk2,String koltuk3,String koltuk4,String koltuk5,String koltuk6,String koltuk7,String koltuk8,String koltuk9,String koltuk10)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nereden", nereden);
        contentValues.put("nereye", nereye);
        contentValues.put("zaman", sure);
        contentValues.put("saat", saat);
        contentValues.put("fiyat", fiyat);
        contentValues.put("koltuk1", koltuk1);
        contentValues.put("koltuk2", koltuk2);
        contentValues.put("koltuk3", koltuk3);
        contentValues.put("koltuk4", koltuk4);
        contentValues.put("koltuk5", koltuk5);
        contentValues.put("koltuk6", koltuk6);
        contentValues.put("koltuk7", koltuk7);
        contentValues.put("koltuk8", koltuk8);
        contentValues.put("koltuk9", koltuk9);
        contentValues.put("koltuk10", koltuk10);

        long result = MyDB.insert("sefer",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    public Cursor viewJourney()
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from sefer", null);
        return cursor;
    }

    public Cursor viewStates()
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from iller", null);
        return cursor;
    }

    public HashMap<String,String> journeyDetay(int id1){

        HashMap<String,String> seferbilgi = new HashMap<String,String>();
        String selectQuery = "SELECT * FROM sefer WHERE seferID="+id1;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            seferbilgi.put("koltuk1", cursor.getString(6));
            seferbilgi.put("koltuk2", cursor.getString(7));
            seferbilgi.put("koltuk3", cursor.getString(8));
            seferbilgi.put("koltuk4", cursor.getString(9));
            seferbilgi.put("koltuk5", cursor.getString(10));
            seferbilgi.put("koltuk6", cursor.getString(11));
            seferbilgi.put("koltuk7", cursor.getString(12));
            seferbilgi.put("koltuk8", cursor.getString(13));
            seferbilgi.put("koltuk9", cursor.getString(14));
            seferbilgi.put("koltuk10", cursor.getString(15));

        }
        cursor.close();
        db.close();
        return seferbilgi;
    }

    public Boolean updateJourney(String seferid,String tc,String koltukno )
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( koltukno, tc);

        int sefid=Integer.parseInt(seferid);
        String selectQuery = "SELECT * FROM sefer WHERE seferID="+sefid;
        Cursor cursor = MyDB.rawQuery(selectQuery, null);


        if (cursor.getCount()>0){
            long result = MyDB.update("sefer", contentValues,"seferID=?",new String[] {seferid});

            if(result==-1)
                return false;
            else
                return true;
        }
        else
        {
            return false;
        }
    }

    public HashMap<String,String> journeyDetay1(int id1){

        HashMap<String,String> seferbilgi = new HashMap<String,String>();
        String selectQuery = "SELECT * FROM sefer WHERE seferID="+id1;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            seferbilgi.put("seferID", cursor.getString(0));
            seferbilgi.put("nereden", cursor.getString(1));
            seferbilgi.put("nereye", cursor.getString(2));
            seferbilgi.put("zaman", cursor.getString(3));
            seferbilgi.put("saat", cursor.getString(4));
            seferbilgi.put("fiyat", cursor.getString(5));
        }
        cursor.close();
        db.close();
        return seferbilgi;
    }

    public Boolean updateJourney1(String seferid,String nereden,String nereye,String zaman,String saat,String fiyat )
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( "nereden", nereden);
        contentValues.put( "nereye", nereye);
        contentValues.put( "zaman", zaman);
        contentValues.put( "saat", saat);
        contentValues.put( "fiyat", fiyat);

        int sefid=Integer.parseInt(seferid);
        String selectQuery = "SELECT * FROM sefer WHERE seferID="+sefid;
        Cursor cursor = MyDB.rawQuery(selectQuery, null);


        if (cursor.getCount()>0){
            long result = MyDB.update("sefer", contentValues,"seferID=?",new String[] {seferid});
            if(result==-1)
                return false;
            else
                return true;
        }
        else
        {
            return false;
        }
    }


    public Boolean DeleteState(String id)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();

        String selectQuery = "SELECT * FROM iller WHERE ilID="+id;
        Cursor cursor = MyDB.rawQuery(selectQuery, null);


        if (cursor.getCount()>0){
            long result = MyDB.delete("iller", "ilID=?",new String[] {id});
            if(result==-1)
                return false;
            else
                return true;
        }
        else
        {
            return false;
        }
    }

    public List<String> getAllStates()
    {

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM iller";
        Cursor cursor = db.rawQuery(selectQuery, null);
        List<String> il = new ArrayList<String>();

        if (cursor.moveToFirst()) {
            do {
                il.add(cursor.getString(2));
            }
            while
            (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return il;
    }
}
