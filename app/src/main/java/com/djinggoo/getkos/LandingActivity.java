package com.djinggoo.getkos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LandingActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        ImageView logo = findViewById(R.id.getkos_logo);

        logo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.getkos_logo :
                Intent activityPredictionIntent = new Intent(LandingActivity.this, PredictionActivity.class);
                startActivity(activityPredictionIntent);
                break;
        }
    }
}