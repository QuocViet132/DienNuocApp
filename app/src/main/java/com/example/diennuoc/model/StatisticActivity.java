package com.example.diennuoc.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.diennuoc.R;
import com.example.diennuoc.databinding.ActivityStatisticBinding;
import com.example.diennuoc.model.fragment.StatisticAverageFragment;
import com.example.diennuoc.model.fragment.StatisticTotalFragment;
import com.example.diennuoc.viewmodel.StatisticViewModel;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class StatisticActivity extends AppCompatActivity {
    private ActivityStatisticBinding activityStatisticBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityStatisticBinding = ActivityStatisticBinding.inflate(getLayoutInflater());
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        StatisticViewModel statisticViewModel = new StatisticViewModel();

        initial();
        clickButton(statisticViewModel);
        DisplayPieChart();

        activityStatisticBinding.setStatisticViewModel(statisticViewModel);
        setContentView(activityStatisticBinding.getRoot());
    }

    private void initial() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.layout_statistic_details, new StatisticTotalFragment()).commit();
    }

    private void clickButton(StatisticViewModel statisticViewModel) {
        activityStatisticBinding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        activityStatisticBinding.cvStatisticTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statisticViewModel.onClickCvTotal();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.layout_statistic_details, new StatisticTotalFragment()).commit();
            }
        });

        activityStatisticBinding.cvStatisticAverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statisticViewModel.onClickCvAverage();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.layout_statistic_details, new StatisticAverageFragment()).commit();
            }
        });
    }

    private void DisplayPieChart() {
        PieChart pieChartTotal = activityStatisticBinding.pieChartTotal;
        PieChart pieChartAverage = activityStatisticBinding.pieChartAverage;

        // Create list entries for Donut Chart
        ArrayList<PieEntry> entriesTotal = new ArrayList<>();
        entriesTotal.add(new PieEntry(700,"Điện"));
        entriesTotal.add(new PieEntry(300,"Nước"));

        ArrayList<PieEntry> entriesAverage = new ArrayList<>();
        entriesAverage.add(new PieEntry(50,"Điện"));
        entriesAverage.add(new PieEntry(50,"Nước"));

        // Create DataSet
        PieDataSet dataSetTotal = new PieDataSet(entriesTotal, "");
        dataSetTotal.setColors(getColor(R.color.custom_orange), getColor(R.color.custom_blue));
        dataSetTotal.setValueTextColor(getColor(R.color.black));
        dataSetTotal.setValueTextSize(14);
        dataSetTotal.setSliceSpace(3f);

        PieDataSet dataSetAverage = new PieDataSet(entriesAverage, "");
        dataSetAverage.setColors(getColor(R.color.custom_orange), getColor(R.color.custom_blue));
        dataSetAverage.setValueTextColor(getColor(R.color.black));
        dataSetAverage.setValueTextSize(14);
        dataSetAverage.setSliceSpace(3f);

        // Create PieData object and import in PieChart
        PieData pieDataTotal = new PieData(dataSetTotal);
        pieChartTotal.setData(pieDataTotal);
        pieChartTotal.getDescription().setEnabled(false); // Tắt description
        pieChartTotal.setTouchEnabled(false);
        pieChartTotal.setCenterText("Tổng");
        pieChartTotal.setCenterTextSize(15);
        pieChartTotal.setCenterTextColor(getColor(R.color.black));
        pieChartTotal.setUsePercentValues(true);
        pieChartTotal.setDrawEntryLabels(false);

        PieData pieDataAverage = new PieData(dataSetAverage);
        pieChartAverage.setData(pieDataAverage);
        pieChartAverage.getDescription().setEnabled(false); // Tắt description
        pieChartAverage.setTouchEnabled(false);
        pieChartAverage.setCenterText("Trung Bình");
        pieChartAverage.setCenterTextSize(14);
        pieChartAverage.setCenterTextColor(getColor(R.color.black));
        pieChartAverage.setUsePercentValues(true);
        pieChartAverage.setDrawEntryLabels(false);
        pieChartAverage.setCenterTextRadiusPercent(50);

        // Display Chart
        pieChartTotal.invalidate();
        pieChartAverage.invalidate();
    }
}