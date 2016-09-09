package com.cloudtp.learnrxjava.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.cloudtp.learnrxjava.R;


/**
 * Created by JYD on 2016/8/29.
 */
public abstract class BaseActivity extends Activity {
    private TextView tvApi,tvResult,tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        tvApi= (TextView) findViewById(R.id.demo_api);
        tvResult= (TextView) findViewById(R.id.result);
        tvDesc=(TextView)findViewById(R.id.desc);
        registerAction();
    }

    protected abstract void registerAction();

    interface ApiRegistery {
        void addApiText();
    }
    //
    protected void showApiText(final String text){
        //ensure log on ui thread
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvApi.setText(tvApi.getText().toString() + "\r\n" + text);
            }
        });
    }
    protected void showApiDesc(final String tipLine) {
        //ensure log on ui thread
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvDesc.setText(tvDesc.getText().toString() + "\r\n" + tipLine);
            }
        });
    }
    protected void log(final String tipLine) {
        //ensure log on ui thread
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvResult.setText(tvResult.getText().toString() + "\r\n" + tipLine);
            }
        });
    }
}
