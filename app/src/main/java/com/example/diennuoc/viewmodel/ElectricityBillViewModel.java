package com.example.diennuoc.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.diennuoc.BR;

public class ElectricityBillViewModel extends BaseObservable {
    private String startDate, endDate, priceBeforeTax, priceTax, priceTotal;
    private String firstNumber, secondNumber, totalAmountElectricity;

    @Bindable
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
        notifyPropertyChanged(BR.startDate);
    }

    @Bindable
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
        notifyPropertyChanged(BR.endDate);
    }

    @Bindable
    public String getPriceBeforeTax() {
        return priceBeforeTax;
    }

    public void setPriceBeforeTax(String priceBeforeTax) {
        this.priceBeforeTax = priceBeforeTax;
        notifyPropertyChanged(BR.priceBeforeTax);
    }

    @Bindable
    public String getPriceTax() {
        return priceTax;
    }

    public void setPriceTax(String priceTax) {
        this.priceTax = priceTax;
        notifyPropertyChanged(BR.priceTax);
    }

    @Bindable
    public String getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(String priceTotal) {
        this.priceTotal = priceTotal;
        notifyPropertyChanged(BR.priceTotal);
    }

    @Bindable
    public String getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(String firstNumber) {
        this.firstNumber = firstNumber;
        notifyPropertyChanged(BR.firstNumber);
    }

    @Bindable
    public String getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
        notifyPropertyChanged(BR.secondNumber);
    }

    @Bindable
    public String getTotalAmountElectricity() {
        return totalAmountElectricity;
    }

    public void setTotalAmountElectricity(String totalAmountElectricity) {
        this.totalAmountElectricity = totalAmountElectricity;
        notifyPropertyChanged(BR.totalAmountElectricity);
    }

    public void clickSave() {

    }

    public void clickCalculate() {
    }


}
