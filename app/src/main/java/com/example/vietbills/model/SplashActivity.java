package com.example.vietbills.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.vietbills.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        displayLogo();
    }

    private void displayLogo() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intentMoveToHome = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intentMoveToHome);
                finish();
            }
        },3000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}