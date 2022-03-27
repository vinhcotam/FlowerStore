package com.example.flowerstore;

import androidx.appcompat.app.AppCompatActivity;
import java.lang.Math;
import java.util.Random;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class forgetpass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpass);
        getEvent();
    }
    void getEvent(){
        Button button = (Button) findViewById(R.id.BT_sendcode);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code="";
                for(int i=0;i<5;i++){
                    Random generator;
                    generator = new Random();
                    int so = Math.abs(generator.nextInt()%10);
                    code+=so;
                }
                Toast.makeText(forgetpass.this, code, Toast.LENGTH_LONG).show();
            }
        });
    }
}