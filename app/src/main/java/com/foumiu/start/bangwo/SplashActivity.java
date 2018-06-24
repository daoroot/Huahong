package com.foumiu.start.bangwo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by dabo on 2018/6/24.
 */

public class SplashActivity extends Activity {

    private ProgressBar mBar;
    private TextView mProgressText;

    private int percent;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            percent+=10;
            if (percent >= 100) {
                mProgressText.setText(BWApplicaition.getString(SplashActivity.this, R.string.init_percent_complete));
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            } else {
                if (mBar != null) {
                    mBar.setProgress(percent);
                    mProgressText.setText(String.format(BWApplicaition.getString(SplashActivity.this, R.string.init_percent_disc), percent));
                }
                sendEmptyMessageDelayed(0, 50);
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mBar = findViewById(R.id.progressBar);
        mProgressText = findViewById(R.id.progress_text);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.sendEmptyMessage(0);
    }
}
