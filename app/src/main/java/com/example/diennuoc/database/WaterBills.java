package com.example.diennuoc.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class WaterBills {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String startDate;
    private String endDate;
    private int amountWater;
    private String paymentWater;

    public WaterBills(String startDate, String endDate, int amountWater, String paymentWater) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.amountWater = amountWater;
        this.paymentWater = paymentWater;
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

    public int getAmountWater() {
        return amountWater;
    }

    public void setAmountWater(int amountWater) {
        this.amountWater = amountWater;
    }

    public String getPaymentWater() {
        return paymentWater;
    }

    public void setPaymentWater(String paymentWater) {
        this.paymentWater = paymentWater;
    }
}
