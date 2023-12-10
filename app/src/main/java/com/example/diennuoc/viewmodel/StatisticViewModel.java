package com.example.diennuoc.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.diennuoc.BR;

public class StatisticViewModel extends BaseObservable {
    private boolean isClickCvTotal = false;

    public void setClickCvTotal(boolean clickCvTotal) {
        isClickCvTotal = clickCvTotal;
        notifyPropertyChanged(BR.clickCvTotal);
    }

    public void setClickCvAverage(boolean clickCvAverage) {
        isClickCvAverage = clickCvAverage;
        notifyPropertyChanged(BR.clickCvAverage);
    }

    private boolean isClickCvAverage = false;

    @Bindable
    public boolean isClickCvTotal() {
        return isClickCvTotal;
    }

    @Bindable
    public boolean isClickCvAverage() {
        return isClickCvAverage;
    }

    public boolean onClickCvTotal() {
        setClickCvTotal(true);
        setClickCvAverage(false);
        return true;
    }

    public boolean onClickCvAverage() {
        setClickCvTotal(false);
        setClickCvAverage(true);
        return true;
    }

}
