package com.shablcu.shalu.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
 ListView mainlist;
    private String[] texts={"lorem","ipsum","dollar","set","amit","gold","silver",
            "bass","lorem","ipsum","dollar","set","amit","gold","silver","bass"
    ,"lorem","ipsum","dollar","set","amit","gold","silver","bass","lorem","ipsum",
            "dollar","set","amit","gold","silver","bass","lorem","ipsum","dollar","set","amit","gold","silver",
            "bass","lorem","ipsum","dollar","set","amit","gold","silver","bass"
            ,"lorem","ipsum","dollar","set","amit","gold","silver","bass","lorem","ipsum",
            "dollar","set","amit","gold","silver","bass"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // requestWindowFeature(Window.FEATURE_PROGRESS);
          // it enables the progress of added listitem
        supportRequestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainlist=(ListView)findViewById(R.id.listView);
        mainlist.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>()));
        new MyTask().execute();
    }




    class MyTask extends AsyncTask<Void,String,Void>{
        ArrayAdapter<String> adapter;
        int count=0;

        @Override
        protected void onPreExecute() {
            adapter= (ArrayAdapter<String>) mainlist.getAdapter();
            setProgressBarIndeterminate(false);
            setProgressBarVisibility(true);
        }

        @Override
        protected Void doInBackground(Void... params) {
            for (String item : texts)
            {
                publishProgress(item);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add(values[0]);
            count++;
            setProgress((int)(((double)count/ texts.length)*10000));
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            setProgressBarVisibility(false);
            Toast.makeText(getApplicationContext(),"All items are added succesfully",Toast.LENGTH_SHORT).show();
        }
    }





        }




