package com.example.diennuoc.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WaterBillsDao {
    @Query("SELECT * FROM waterbills")
    List<WaterBills> getWaterBillsAll();

    @Query("SELECT paymentWater FROM waterbills")
    List<Integer> getAllPaymentWater();

    @Query("DELETE FROM waterbills")
    void deleteAllWaterBills();

    @Insert
    void insertWaterBills(WaterBills waterBills);
}
