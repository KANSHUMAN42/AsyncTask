package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="ASYNC";
 Button btn ;
 Button btn1;
 Button btn2;
 TextView tv1;
 ConstraintLayout clbackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        clbackground = findViewById(R.id.clbackground);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        tv1=findViewById(R.id.tv1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countTask ctask=new countTask();
                ctask.execute(5);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r=new Random();
                tv1.setText(String.valueOf(r.nextInt(100)));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Handler h = new Handler();
                Runnable r = new Runnable() {

                    @Override
                    public void run() {
                        Log.d(TAG, "run: it is running wait");
                        clbackground.setBackgroundColor(Color.MAGENTA);
                        h.postDelayed(this, 1000);
                    }
                };
                h.postDelayed(r, 1000);

            }
        }
        );


    }
        class countTask extends AsyncTask<Integer, Integer, Void> {


            @Override
            protected Void doInBackground(Integer... integers) {
                 Log.d(TAG, "do in background started");
                int n=integers[0];
                waitnsec(n);
                 Log.d(TAG, " it has ended");
                return null;
            }
        }

        void wait1sec (){
            long startTime=System.currentTimeMillis();
            while(System.currentTimeMillis()<startTime+1000);
        }
        void waitnsec (int n){
        for(int i=0;i<n;i++){
            wait1sec();
                 }
        }


}
