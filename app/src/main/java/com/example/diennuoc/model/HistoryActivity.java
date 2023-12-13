package com.example.diennuoc.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.example.diennuoc.adapter.ElectricAdapter;
import com.example.diennuoc.adapter.ViewPageHistoryAdapter;
import com.example.diennuoc.database.AppDatabase;
import com.example.diennuoc.databinding.ActivityHistoryBinding;
import com.example.diennuoc.model.fragment.HistoryElectricFragment;
import com.example.diennuoc.model.fragment.HistoryWaterFragment;
import com.example.diennuoc.viewmodel.HistoryViewModel;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    private ElectricAdapter electricAdapter;
    private ActivityHistoryBinding activityHistoryBinding;
    private HistoryViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHistoryBinding = ActivityHistoryBinding.inflate(getLayoutInflater());
        setContentView(activityHistoryBinding.getRoot());

        viewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
        activityHistoryBinding.setHistoryViewModel(viewModel);
        activityHistoryBinding.setLifecycleOwner(this);

        initialUI();
        handlerClick();
    }

    private void initialUI() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HistoryElectricFragment());
        fragmentList.add(new HistoryWaterFragment());

        ViewPageHistoryAdapter viewPageHistoryAdapter = new ViewPageHistoryAdapter(this, fragmentList);
        activityHistoryBinding.viewpageHistory.setAdapter(viewPageHistoryAdapter);

        new TabLayoutMediator(activityHistoryBinding.tabLayout, activityHistoryBinding.viewpageHistory,(tab, position) -> {
            String[] tabTitles = {"Điện","Nước"};
            tab.setText(tabTitles[position]);
        }).attach();
    }

    private void handlerClick() {
        activityHistoryBinding.ivBack.setOnClickListener(v -> finish());
        activityHistoryBinding.ivDelete.setOnClickListener(v -> viewModel.onClickDelete());
        observes();
    }

    private void observes() {
        viewModel.getClickedDelete().observe(this, clickedDelete -> {
            if (clickedDelete) {
                new AlertDialog.Builder(this)
                        .setTitle("Xoá toàn bộ lịch sử")
                                .setMessage("Thao tác này sẽ xoá toàn bộ dữ liệu?")
                                        .setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                AppDatabase.getInstance(HistoryActivity.this).electricBillsDao().deleteAllElectricBills();
                                                initialUI();
                                                Toast.makeText(HistoryActivity.this,"Xoá thành công",Toast.LENGTH_SHORT).show();
                                            }
                                        })
                        .setNegativeButton("Không", null)
                        .show();
                viewModel.getClickedDelete().setValue(false);
            }
        });
    }
}