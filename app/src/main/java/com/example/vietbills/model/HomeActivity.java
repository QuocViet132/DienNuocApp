package com.example.vietbills.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.vietbills.databinding.ActivityHomeBinding;
import com.example.vietbills.viewmodel.HomeViewModel;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding mActivityHomeBinding;
    private HomeViewModel homeViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(mActivityHomeBinding.getRoot());

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        mActivityHomeBinding.setHomeViewModel(homeViewModel);
        mActivityHomeBinding.setLifecycleOwner(this);

        clickItems();
    }

    private void clickItems() {
        mActivityHomeBinding.icUsers.setOnClickListener(v -> homeViewModel.onClickUser());
        mActivityHomeBinding.icSettings.setOnClickListener(v -> homeViewModel.onClickSettings());
        mActivityHomeBinding.cvElectricity.setOnClickListener(v -> homeViewModel.onClickElectric());
        mActivityHomeBinding.cvWater.setOnClickListener(v -> homeViewModel.onClickWater());
        mActivityHomeBinding.cvHistory.setOnClickListener(v -> homeViewModel.onClickHistory());
        mActivityHomeBinding.cvStatistic.setOnClickListener(v -> homeViewModel.onClickStatistic());

        observeClickEvents();
    }

    private void observeClickEvents() {
        homeViewModel.getClickedUser().observe(this, clickedUser -> {
            if (clickedUser) {
                Toast.makeText(HomeActivity.this, "Tính năng sẽ được cập nhập ở phiên bản tiếp theo", Toast.LENGTH_SHORT).show();
                homeViewModel.getClickedUser().setValue(false);
            }
        });

        homeViewModel.getClickedSettings().observe(this, clickedSettings -> {
            if (clickedSettings) {
                // Handler event click this
                Toast.makeText(HomeActivity.this,"Tính năng sẽ được cập nhập ở phiên bản tiếp theo",Toast.LENGTH_SHORT).show();
                homeViewModel.getClickedSettings().setValue(false);
            }
        });

        homeViewModel.getClickedElectric().observe(this, clickedElectric -> {
            if (clickedElectric) {
                Intent intentElectricity = new Intent(HomeActivity.this, ElectricityBillActivity.class);
                startActivity(intentElectricity);
                homeViewModel.getClickedElectric().setValue(false);
            }
        });

        homeViewModel.getClickedWater().observe(this, clickedWater -> {
            if (clickedWater) {
                Intent intentWater = new Intent(HomeActivity.this, WaterBillActivity.class);
                startActivity(intentWater);
                homeViewModel.getClickedWater().setValue(false);
            }
        });

        homeViewModel.getClickedHistory().observe(this, clickedHistory -> {
            if (clickedHistory) {
                Intent intentHistory = new Intent(HomeActivity.this, HistoryActivity.class);
                startActivity(intentHistory);
                homeViewModel.getClickedHistory().setValue(false);
            }
        });

        homeViewModel.getClickedStatistic().observe(this, clickedStatistic -> {
            if (clickedStatistic) {
                Intent intentStatistic = new Intent(HomeActivity.this, StatisticActivity.class);
                startActivity(intentStatistic);
                homeViewModel.getClickedStatistic().setValue(false);
            }
        });
    }
}