package com.example.diennuoc.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ElectricBills {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String startDate;
    private String endDate;
    private String amountElectric;
    private int paymentElectric;

    public ElectricBills(String startDate, String endDate, String amountElectric, int paymentElectric) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.amountElectric = amountElectric;
        this.paymentElectric = paymentElectric;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAmountElectric() {
        return amountElectric;
    }

    public void setAmountElectric(String amountElectric) {
        this.amountElectric = amountElectric;
    }

    public int getPaymentElectric() {
        return paymentElectric;
    }

    public void setPaymentElectric(int paymentElectric) {
        this.paymentElectric = paymentElectric;
    }
}