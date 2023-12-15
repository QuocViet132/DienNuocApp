package com.example.vietbills.model.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vietbills.adapter.WaterAdapter;
import com.example.vietbills.database.AppDatabase;
import com.example.vietbills.database.WaterBills;
import com.example.vietbills.databinding.FragmentHistoryWaterBinding;

import java.util.ArrayList;
import java.util.List;

public class HistoryWaterFragment extends Fragment {
    private List<WaterBills> listWaterBills;
    private WaterAdapter waterAdapter;
    private FragmentHistoryWaterBinding fragmentHistoryWaterBinding;
    public HistoryWaterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentHistoryWaterBinding = FragmentHistoryWaterBinding.inflate(getLayoutInflater());
        initialUi();
        return fragmentHistoryWaterBinding.getRoot();
    }

    private void initialUi() {
        listWaterBills = new ArrayList<>();
        waterAdapter = new WaterAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        fragmentHistoryWaterBinding.rcvWaterHistory.setLayoutManager(linearLayoutManager);
        fragmentHistoryWaterBinding.rcvWaterHistory.setAdapter(waterAdapter);

        loadData();
    }

    private void loadData() {
        listWaterBills = AppDatabase.getInstance(this.getContext()).waterBillsDao().getWaterBillsAll();
        waterAdapter.setDataWater(listWaterBills);
    }
}