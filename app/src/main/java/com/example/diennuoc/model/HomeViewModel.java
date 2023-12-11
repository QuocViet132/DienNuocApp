package com.example.diennuoc.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    private final MutableLiveData<Boolean> clickedUser = new MutableLiveData<>();
    private final MutableLiveData<Boolean> clickedSettings = new MutableLiveData<>();
    private final MutableLiveData<Boolean> clickedElectric = new MutableLiveData<>();
    private final MutableLiveData<Boolean> clickedWater = new MutableLiveData<>();
    private final MutableLiveData<Boolean> clickedHistory = new MutableLiveData<>();
    private final MutableLiveData<Boolean> clickedStatistic = new MutableLiveData<>();

    public void onClickUser() {
        clickedUser.setValue(true);
    }
    public void onClickSettings() {
        clickedSettings.setValue(true);
    }
    public void onClickElectric() {
        clickedElectric.setValue(true);
    }
    public void onClickWater() {
        clickedWater.setValue(true);
    }
    public void onClickHistory() {
        clickedHistory.setValue(true);
    }
    public void onClickStatistic() {
        clickedStatistic.setValue(true);
    }

    public MutableLiveData<Boolean> getClickedUser() {
        return clickedUser;
    }

    public MutableLiveData<Boolean> getClickedSettings() {
        return clickedSettings;
    }

    public MutableLiveData<Boolean> getClickedElectric() {
        return clickedElectric;
    }

    public MutableLiveData<Boolean> getClickedWater() {
        return clickedWater;
    }

    public MutableLiveData<Boolean> getClickedHistory() {
        return clickedHistory;
    }

    public MutableLiveData<Boolean> getClickedStatistic() {
        return clickedStatistic;
    }
}
