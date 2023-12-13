package com.example.diennuoc.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ElectricBillsDao {
    @Query("SELECT * FROM electricbills")
    List<ElectricBills> getElectricBillsAll();

    @Query("DELETE FROM electricbills")
    void deleteAllElectricBills();

    @Insert
    void insertElectricBills(ElectricBills electricBills);

}
