package com.shablcu.shalu.asynctask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {
    MyThread myThread;
 Button sendmessagebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendmessagebutton= (Button)findViewById(R.id.sendmessage);
        myThread=new MyThread();
        myThread.start();
    }

        public void sendmessage(View view){

            myThread.handler.post(new Runnable() {
                @Override
                public void run() {
                    Log.d("thread", "thread running");
                }
            });
    }


    class  MyThread extends Thread{
        Handler handler;
        public void MyThread(){

        }

        public void run(){
            Looper.prepare();
            handler = new Handler();
            Looper.loop();

        }
    }

        }




