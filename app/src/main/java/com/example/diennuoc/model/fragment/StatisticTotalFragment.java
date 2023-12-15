package com.example.diennuoc.model.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diennuoc.R;
import com.example.diennuoc.databinding.FragmentStatisticTotalBinding;
import com.example.diennuoc.model.StatisticActivity;
import com.example.diennuoc.viewmodel.StatisticViewModel;

public class StatisticTotalFragment extends Fragment {
    private FragmentStatisticTotalBinding fragmentStatisticTotalBinding;
    private StatisticViewModel statisticViewModel;

    public StatisticTotalFragment() {
        // Required empty public constructor
    }

    public StatisticTotalFragment(StatisticViewModel statisticViewModel) {
        this.statisticViewModel = statisticViewModel;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentStatisticTotalBinding = FragmentStatisticTotalBinding.inflate(getLayoutInflater());
        fragmentStatisticTotalBinding.setStatisticViewModel(statisticViewModel);
        return fragmentStatisticTotalBinding.getRoot();
    }
}