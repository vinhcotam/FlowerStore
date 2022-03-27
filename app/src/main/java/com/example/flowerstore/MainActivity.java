package com.example.flowerstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower_detail);
        ConnectDB();

    }
    SQLiteDatabase db = null;

        void ConnectDB(){
        db=openOrCreateDatabase("FlowerStore.db", MODE_PRIVATE, null);
        //tạo table nếu chưa có
        String sql = "create table if not exists Flower(idflower char(50) primary key, nameflower char(50), category char(50),price int,color char(50))";
        db.execSQL(sql);
        String sql1 ="create table if not exists Img(idimg char(50),imgflower char(100),idflower char(50),FOREIGN KEY(idflower) REFERENCES Flower(idflower))";
        db.execSQL(sql1);
        }
        void InsertData(){
            String sql="Insert into Flower values('flower1_date','Firt Date','Date',300000,'yellow and white')"
                    + ",('flower2_date','Carla','Date',550000,'pink')"
                    +",('flower3_date','La Vie En Rose','Date',500000,'pink and violet')"
                    +",('flower4_date','Violet Lover','Date',700000,'pink and violet')";
            db.execSQL(sql);
            String sql1="Insert into Img values('img_flower1_date,'C:\\Users\\FX505DD\\OneDrive\\Desktop\\FlowerStore\\app\\src\\main\\res\\drawable.hoa1_date.jpeg','flower1_date')";
            db.execSQL(sql1);
        }

}