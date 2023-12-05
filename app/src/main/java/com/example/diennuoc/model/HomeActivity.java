package com.example.diennuoc.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.diennuoc.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding mActivityHomeBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(mActivityHomeBinding.getRoot());

        clickItems();
    }

    private void clickItems() {
        mActivityHomeBinding.icUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(HomeActivity.this,"Users",Toast.LENGTH_SHORT).show();
            }
        });

        mActivityHomeBinding.icSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(HomeActivity.this,"Settings",Toast.LENGTH_SHORT).show();
            }
        });

        mActivityHomeBinding.cvElectricity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentElectricity = new Intent(HomeActivity.this, ElectricityBillActivity.class);
                startActivity(intentElectricity);
            }
        });

        mActivityHomeBinding.cvWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentWater = new Intent(HomeActivity.this, WaterBillActivity.class);
                startActivity(intentWater);
            }
        });

        mActivityHomeBinding.cvHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHistory = new Intent(HomeActivity.this, HistoryActivity.class);
                startActivity(intentHistory);
            }
        });

        mActivityHomeBinding.cvStatistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStatistic = new Intent(HomeActivity.this, StatisticActivity.class);
                startActivity(intentStatistic);
            }
        });
    }

}