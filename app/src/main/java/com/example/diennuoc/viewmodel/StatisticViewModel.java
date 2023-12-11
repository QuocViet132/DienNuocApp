package com.example.diennuoc.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.diennuoc.BR;

public class StatisticViewModel extends BaseObservable {
    private boolean isClickCvTotal = false;
    private boolean isClickCvAverage = false;

    public void setClickCvTotal(boolean clickCvTotal) {
        isClickCvTotal = clickCvTotal;
        notifyPropertyChanged(BR.clickCvTotal);
    }

    public void setClickCvAverage(boolean clickCvAverage) {
        isClickCvAverage = clickCvAverage;
        notifyPropertyChanged(BR.clickCvAverage);
    }

    @Bindable
    public boolean isClickCvTotal() {
        return isClickCvTotal;
    }

    @Bindable
    public boolean isClickCvAverage() {
        return isClickCvAverage;
    }

    public void onClickCvTotal() {
        setClickCvTotal(true);
        setClickCvAverage(false);
    }

    public void onClickCvAverage() {
        setClickCvTotal(false);
        setClickCvAverage(true);
    }

}
