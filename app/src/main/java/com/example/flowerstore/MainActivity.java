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
        setContentView(R.layout.login);
        ConnectDB();
        setEvent();
    }
    Button button;
    TextView textview;
    EditText edittext;
    String email="";
    String password="";
    SQLiteDatabase db = null;
    void setEvent(){
        //Login
        button = (Button) findViewById(R.id.BT_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getemail();
                getpassword();
                String sql = "select * from account where Email='"+email+"' and Password='"+password+"'";
                if(email.equals("admin") && password.equals("admin")){
                    setContentView(R.layout.control_panel);
                }
                Cursor cursor = db.rawQuery(sql, null);
                try{
                    cursor.moveToNext();
                    cursor.getString(0);
                }
                catch(Exception e){
                    Toast.makeText(MainActivity.this, "Tài khoản hoặc mật khẩu không khớp", Toast.LENGTH_LONG).show();
                    return;
                }
                Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();

            }
        });
        button = (Button) findViewById(R.id.BT_signup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getemail();
                Intent intent = new Intent(MainActivity.this, signup.class);
                    Bundle bundle = new Bundle();
                    bundle.getString("email", email);
                    intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.BT_quenMK);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getemail();
                Intent intent = new Intent(MainActivity.this, forgetpass.class);
                Bundle bundle = new Bundle();
                bundle.getString("email", email);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
    void ConnectDB(){
        db=openOrCreateDatabase("FlowerStore.db", MODE_PRIVATE, null);
        //tạo table nếu chưa có
        String sql = "create table if not exists Account(Email char(50) primary key, Password char(50), Name char(50))";
        db.execSQL(sql);
    }
    void getemail(){
        edittext = (EditText) findViewById(R.id.ET_email);
        email = edittext.getText().toString();
    }
    void getpassword(){
        edittext = (EditText) findViewById(R.id.ET_password);
        password = edittext.getText().toString();
    }

}