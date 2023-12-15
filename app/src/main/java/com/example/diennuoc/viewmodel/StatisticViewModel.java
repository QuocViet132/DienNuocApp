package com.example.diennuoc.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.diennuoc.BR;

public class StatisticViewModel extends BaseObservable {
    private boolean isClickCvTotal = true;
    private boolean isClickCvAverage = false;
    private String totalElectricPrice, totalWaterPrice, totalPrice;
    private String averageElectricPrice, averageWaterPrice, averagePrice;

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

    @Bindable
    public String getTotalElectricPrice() {
        return totalElectricPrice;
    }

    public void setTotalElectricPrice(String totalElectricPrice) {
        this.totalElectricPrice = totalElectricPrice;
        notifyPropertyChanged(BR.totalElectricPrice);
    }

    @Bindable
    public String getTotalWaterPrice() {
        return totalWaterPrice;
    }

    public void setTotalWaterPrice(String totalWaterPrice) {
        this.totalWaterPrice = totalWaterPrice;
        notifyPropertyChanged(BR.totalWaterPrice);
    }

    @Bindable
    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
        notifyPropertyChanged(BR.totalPrice);
    }

    @Bindable
    public String getAverageElectricPrice() {
        return averageElectricPrice;
    }

    public void setAverageElectricPrice(String averageElectricPrice) {
        this.averageElectricPrice = averageElectricPrice;
        notifyPropertyChanged(BR.averageElectricPrice);
    }

    @Bindable
    public String getAverageWaterPrice() {
        return averageWaterPrice;
    }

    public void setAverageWaterPrice(String averageWaterPrice) {
        this.averageWaterPrice = averageWaterPrice;
        notifyPropertyChanged(BR.averageWaterPrice);
    }

    @Bindable
    public String getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice;
        notifyPropertyChanged(BR.averagePrice);
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
