package com.example.vietbills.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.vietbills.R;
import com.example.vietbills.database.AppDatabase;
import com.example.vietbills.database.ElectricBills;
import com.example.vietbills.databinding.ActivityElectricityBillBinding;
import com.example.vietbills.model.fragment.ElectricPriceFragment;
import com.example.vietbills.viewmodel.ElectricityBillViewModel;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class ElectricityBillActivity extends AppCompatActivity {
    private static final int LEVEL1 = 1806;
    private static final int LEVEL2 = 1886;
    private static final int LEVEL3 = 2167;
    private static final int LEVEL4 = 2729;
    private static final int LEVEL5 = 3050;
    private static final int LEVEL6 = 3151;

    private double priceBeforeTax, priceTax, priceTotal;
    private int firstNum, secondNum, totalAmountElectricity;
    private ActivityElectricityBillBinding mActivityElectricityBillBinding;
    private ElectricityBillViewModel electricityBillViewModel = new ElectricityBillViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityElectricityBillBinding = ActivityElectricityBillBinding.inflate(getLayoutInflater());
        setContentView(mActivityElectricityBillBinding.getRoot());
        mActivityElectricityBillBinding.setElectricityBillViewModel(electricityBillViewModel);

        clickButton();
    }

    private void clickButton() {
        mActivityElectricityBillBinding.ivInfor.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.layout_electric_bill, new ElectricPriceFragment()).addToBackStack(null).commit();
        });

        mActivityElectricityBillBinding.ivBack.setOnClickListener(v -> finish());

        mActivityElectricityBillBinding.btnSave.setOnClickListener(v -> saveData());

        mActivityElectricityBillBinding.btnCalculate.setOnClickListener(v -> calculatePriceElectricity());
    }

    private void saveData() {
        boolean isValidValue = checkValueBeforeSave();
        if (isValidValue) {
            String startDate, endDate, amountTotal;
            int priceTotal;

            startDate = electricityBillViewModel.getStartDate();
            endDate = electricityBillViewModel.getEndDate();
            amountTotal = electricityBillViewModel.getTotalAmountElectricity();
            priceTotal = (int) Math.round(this.priceTotal);

            if (TextUtils.isEmpty(startDate) || TextUtils.isEmpty(endDate)) {
                LocalDate currentDate = LocalDate.now();
                int day = currentDate.getDayOfMonth();
                int month = currentDate.getMonthValue();
                int year = currentDate.getYear();

                startDate = " ";
                endDate = String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year);
            }

            ElectricBills electricBills = new ElectricBills(startDate, endDate, amountTotal, priceTotal);
            AppDatabase.getInstance(this).electricBillsDao().insertElectricBills(electricBills);
            Toast.makeText(this,"Lưu dữ liệu thành công",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Lưu dữ liệu thất bại",Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkValueBeforeSave() {
        if (TextUtils.isEmpty(mActivityElectricityBillBinding.tvPriceTotalElectric.getText().toString())
                || mActivityElectricityBillBinding.tvPriceTotalElectric.getText().toString().equals("0")) {
            Toast.makeText(this,"Hãy thực hiện tính toán trước khi lưu",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void calculatePriceElectricity() {
        priceBeforeTax = calculateElectricityBeforeTax(calculateTotalAmountElectricity());
        priceTotal = calculatePriceTotal(priceBeforeTax);

        Locale vn = Locale.forLanguageTag("vi-VN");
        NumberFormat numberFormat = NumberFormat.getInstance(vn);

        electricityBillViewModel.setPriceBeforeTax(numberFormat.format((int) Math.round(priceBeforeTax)));
        electricityBillViewModel.setPriceTax(numberFormat.format((int) Math.round(priceTax)));
        electricityBillViewModel.setPriceTotal(numberFormat.format((int) Math.round(priceTotal)));
    }

    private int calculateTotalAmountElectricity() {
        String strFirstNum = electricityBillViewModel.getFirstNumber();
        String strSecondNum = electricityBillViewModel.getSecondNumber();
        String strTotalAmountElectricity = electricityBillViewModel.getTotalAmountElectricity();

        if (strFirstNum != null && !strFirstNum.isEmpty() && strSecondNum != null && !strSecondNum.isEmpty()) {
            firstNum = Integer.parseInt(electricityBillViewModel.getFirstNumber());
            secondNum = Integer.parseInt(electricityBillViewModel.getSecondNumber());
            if (firstNum <= secondNum) {
                totalAmountElectricity = secondNum - firstNum;
                electricityBillViewModel.setTotalAmountElectricity(String.valueOf(totalAmountElectricity));
                return totalAmountElectricity;
            }
        } else if (strTotalAmountElectricity != null && !strTotalAmountElectricity.isEmpty()) {
            totalAmountElectricity = Integer.parseInt(electricityBillViewModel.getTotalAmountElectricity());
            if (totalAmountElectricity >= 0) {
                return totalAmountElectricity;
            }
        } else {
            Toast.makeText(ElectricityBillActivity.this,"Dữ liệu nhập vào không chính xác",Toast.LENGTH_SHORT).show();
        }
        return 0;
    }

    private int calculateElectricityBeforeTax(int totalAmountElectricity) {
        int result = 0;
        switch (checkLevel(totalAmountElectricity)) {
            case 1:
                result = LEVEL1*totalAmountElectricity;
                break;
            case 2:
                result = LEVEL1*50 + LEVEL2*(totalAmountElectricity-50);
                break;
            case 3:
                result = LEVEL1*50 + LEVEL2*50 + LEVEL3*(totalAmountElectricity-100);
                break;
            case 4:
                result = LEVEL1*50 + LEVEL2*50 + LEVEL3*100 + LEVEL4*(totalAmountElectricity-200);
                break;
            case 5:
                result = LEVEL1*50 + LEVEL2*50 + LEVEL3*100 + LEVEL4*100 + LEVEL5*(totalAmountElectricity-300);
                break;
            case 6:
                result = LEVEL1*50 + LEVEL2*50 + LEVEL3*100 + LEVEL4*100 + LEVEL5*100 + LEVEL6*(totalAmountElectricity-400);
                break;
        }
        return result;
    }

    private int checkLevel(int totalAmountElectricity) {
        int level = 0;
        int count = 0;
        for(int i=0; i<6; i++) {
            if (count<2 && totalAmountElectricity>0) {
                totalAmountElectricity -= 50;
                level++;
                count++;
            }else if(count<6 && totalAmountElectricity>0) {
                totalAmountElectricity -= 100;
                level++;
                count++;
            }else {
                break;
            }
        }
        return level;
    }

    private double calculatePriceTotal(double priceBeforeTax) {
        priceTax = priceBeforeTax * 0.08;
        priceTotal = priceBeforeTax + priceTax;
        return priceTotal;
    }
}