package com.dingdangmao.circleview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class Main extends AppCompatActivity {

    Handler hld=new Handler();
    CircleView ins;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ins=(CircleView) findViewById(R.id.cv);

        new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=0;i<100;i++) {
                    final int j=i;
                    try {
                        Thread.sleep(1000);
                        hld.post(new Runnable() {
                            @Override
                            public void run() {
                                ins.setmTitle(String.valueOf(j)+"%");
                                ins.invalidate();
                            }
                        });
                    }catch(Exception e){
                        Log.i("CircleView",e.toString());
                    }
                }
            }
        }).start();

    }
}
