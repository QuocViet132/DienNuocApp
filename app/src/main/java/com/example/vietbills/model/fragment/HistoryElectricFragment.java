package com.example.vietbills.model.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vietbills.adapter.ElectricAdapter;
import com.example.vietbills.database.AppDatabase;
import com.example.vietbills.database.ElectricBills;
import com.example.vietbills.databinding.FragmentHistoryElectricBinding;

import java.util.ArrayList;
import java.util.List;

public class HistoryElectricFragment extends Fragment {
    private FragmentHistoryElectricBinding fragmentHistoryElectricBinding;
    private ElectricAdapter electricAdapter;
    private List<ElectricBills> listElectricBills;
    public HistoryElectricFragment() {
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
        fragmentHistoryElectricBinding = FragmentHistoryElectricBinding.inflate(getLayoutInflater());
        initialUi();
        return fragmentHistoryElectricBinding.getRoot();
    }

    private void initialUi() {
        electricAdapter = new ElectricAdapter();
        listElectricBills = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        fragmentHistoryElectricBinding.rcvElectricHistory.setLayoutManager(linearLayoutManager);
        fragmentHistoryElectricBinding.rcvElectricHistory.setAdapter(electricAdapter);

        loadData();
    }

    private void loadData() {
        listElectricBills = AppDatabase.getInstance(this.getContext()).electricBillsDao().getElectricBillsAll();
        electricAdapter.setDataElectric(listElectricBills);
    }
}