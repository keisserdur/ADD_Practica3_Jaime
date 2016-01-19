package com.example.admin.add_practica3_jaime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv= (TextView) findViewById(R.id.textView);


        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(500);
                    //tv.setText("Practica 3");
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(Splash.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }
}
