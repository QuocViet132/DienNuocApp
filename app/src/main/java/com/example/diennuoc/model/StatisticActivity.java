package com.example.diennuoc.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.diennuoc.R;
import com.example.diennuoc.database.AppDatabase;
import com.example.diennuoc.databinding.ActivityStatisticBinding;
import com.example.diennuoc.model.fragment.StatisticAverageFragment;
import com.example.diennuoc.model.fragment.StatisticTotalFragment;
import com.example.diennuoc.viewmodel.StatisticViewModel;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class StatisticActivity extends AppCompatActivity {
    private ActivityStatisticBinding activityStatisticBinding;
    private StatisticViewModel statisticViewModel;
    private int totalPriceElectric=0, totalPriceWater=0;
    private int averagePriceElectric=0, averagePriceWater=0, amountBillsElectric=1, amountBillsWater=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityStatisticBinding = ActivityStatisticBinding.inflate(getLayoutInflater());
        setContentView(activityStatisticBinding.getRoot());
        statisticViewModel = new StatisticViewModel();
        activityStatisticBinding.setStatisticViewModel(statisticViewModel);

        initial();
        clickButton();
        statisticTotal();
        statisticAverage();
        displayPieChart();

    }

    private void initial() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.layout_statistic_details, new StatisticTotalFragment()).commit();
    }

    private void clickButton() {
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

    private void statisticTotal() {
        List<Integer> listPriceElectric = new ArrayList<>();
        List<Integer> listPriceWater = new ArrayList<>();
        listPriceElectric = AppDatabase.getInstance(this).electricBillsDao().getAllPaymentElectric();
        listPriceWater = AppDatabase.getInstance(this).waterBillsDao().getAllPaymentWater();

        if (listPriceElectric != null) {
            totalPriceElectric = calculateSum(listPriceElectric);
            amountBillsElectric = listPriceElectric.size();
        }

        if (listPriceWater != null) {
            totalPriceWater = calculateSum(listPriceWater);
            amountBillsWater = listPriceWater.size();
        }

        Log.e("Total Price Electric",String.valueOf(totalPriceElectric));
        Log.e("Amount Bills Electric",String.valueOf(amountBillsElectric));
        Log.e("Total Price Water",String.valueOf(totalPriceWater));
        Log.e("Amount Bills Water",String.valueOf(amountBillsWater));
    }

    private void statisticAverage() {
        if (amountBillsElectric != 0) {
            averagePriceElectric = totalPriceElectric/amountBillsElectric;
        }
        if(amountBillsWater != 0) {
            averagePriceWater = totalPriceWater/amountBillsWater;
        }
    }

    private int calculateSum(List<Integer> list) {
        int sum = 0;
        for (int i=0; i<list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    private void displayPieChart() {
        PieChart pieChartTotal = activityStatisticBinding.pieChartTotal;
        PieChart pieChartAverage = activityStatisticBinding.pieChartAverage;

        // Create list entries for Donut Chart
        ArrayList<PieEntry> entriesTotal = new ArrayList<>();
        entriesTotal.add(new PieEntry(totalPriceElectric,"Điện"));
        entriesTotal.add(new PieEntry(totalPriceWater,"Nước"));

        ArrayList<PieEntry> entriesAverage = new ArrayList<>();
        entriesAverage.add(new PieEntry(averagePriceElectric,"Điện"));
        entriesAverage.add(new PieEntry(averagePriceWater,"Nước"));

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