package com.example.flowerstore;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forgetpass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpass);
        ConnectDB();
        getEvent();
    }
    String email="";
    String name="";
    String code="";
    void getEvent() {
        Button button = (Button) findViewById(R.id.BT_sendcode);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText)findViewById(R.id.ET_email);
                email = editText.getText().toString();
                String sql = "select * from Account where Email ='"+email+"'";
                Cursor cursor = db.rawQuery(sql, null);
                try{
                    cursor.moveToNext();
                    name = cursor.getString(2);
                }
                catch(Exception e){
                    Toast.makeText(forgetpass.this, "Tài khoản này không tồn tại", Toast.LENGTH_LONG).show();
                    return;
                }

                for(int i=0;i<5;i++){
                    Random generator;
                    generator = new Random();
                    int so = Math.abs(generator.nextInt()%10);
                    code+=so;
                }
            }
        });
        button = (Button) findViewById(R.id.BT_getpass);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(code.equals("")){
                    Toast.makeText(forgetpass.this, "Vui lòng lấy mã xác nhận trước", Toast.LENGTH_LONG);
                    return;
                }
                EditText editText = (EditText) findViewById(R.id.ET_code);
                String inputcode = editText.getText().toString();
                if(code.equals(inputcode)){
                    setContentView(R.layout.activity_forgetpass);
                    Button button = (Button) findViewById(R.id.BT_changepassword);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            EditText editText = (EditText) findViewById(R.id.ET_newpassword);
                            String newpass=editText.getText().toString();
                            editText = (EditText) findViewById(R.id.ET_renewpassword);
                            String renewpass=editText.getText().toString();
                            if(newpass.equals(renewpass)){
                                String sql = "alter table Account set Password = '"+newpass+"' where Email = '"+email+"'";
                                db.execSQL(sql);
                                Toast.makeText(forgetpass.this, "Đổi mật khẩu thành công", Toast.LENGTH_LONG);
                            }
                        }
                    });
                }

            }
        });
    }
    SQLiteDatabase db;
    void ConnectDB(){
        db=openOrCreateDatabase("FlowerStore.db", MODE_PRIVATE, null);
        //tạo table nếu chưa có
        String sql = "create table if not exists Account(Email char(50) primary key, Password char(50), Name char(50))";
        db.execSQL(sql);
    }
}