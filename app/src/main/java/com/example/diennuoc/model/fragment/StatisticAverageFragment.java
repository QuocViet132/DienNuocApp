package com.example.diennuoc.model.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diennuoc.R;
import com.example.diennuoc.databinding.FragmentStatisticAverageBinding;
import com.example.diennuoc.viewmodel.StatisticViewModel;

public class StatisticAverageFragment extends Fragment {
    private FragmentStatisticAverageBinding fragmentStatisticAverageBinding;
    private StatisticViewModel statisticViewModel;
    public StatisticAverageFragment() {
        // Required empty public constructor
    }

    public StatisticAverageFragment(StatisticViewModel statisticViewModel) {
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
        fragmentStatisticAverageBinding = FragmentStatisticAverageBinding.inflate(getLayoutInflater());
        fragmentStatisticAverageBinding.setStatisticViewModel(statisticViewModel);
        return fragmentStatisticAverageBinding.getRoot();
    }
}