package com.shablcu.shalu.demoasync;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText number1, number2;
    Button btnadd;
    String strurl = "http://www.telusko.com/addition.htm?t1=5&t2=6";
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        number1 = (EditText) findViewById(R.id.num1text);
        number2 = (EditText) findViewById(R.id.num2text);
        btnadd = (Button) findViewById(R.id.addbutton);


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(number1.getText().toString());
                int num2 = Integer.parseInt(number2.getText().toString());
                strurl = "http://www.telusko.com/addition.htm?t1=" + num1 + "&t2=" + num2;
                MultiplyTask multiply = new MultiplyTask();
                multiply.execute();
            }
        });

    }

    public class MultiplyTask extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
            Toast.makeText(MainActivity.this, "Output is " +s, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(String... params) {

            try {
                URL url = new URL(strurl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();

                BufferedReader buff = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String value = buff.readLine();
                System.out.println("Value is " + value);
                result = value;
            } catch (Exception e) {
                System.out.println(e);
            }


            return result;
        }


    }


}
