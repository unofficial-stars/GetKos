package com.djinggoo.getkos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LandingActivity extends AppCompatActivity {

    private Long splashTime = 300L;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        handler = new Handler();
        handler.postDelayed(() -> gotoPredictionView(), splashTime);
    }

    private void gotoPredictionView(){
        Intent activityPredictionIntent = new Intent(LandingActivity.this, PredictionActivity.class);
        startActivity(activityPredictionIntent);
        finish();
    }

}