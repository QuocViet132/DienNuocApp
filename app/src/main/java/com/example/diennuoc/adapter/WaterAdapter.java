package com.example.diennuoc.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diennuoc.R;
import com.example.diennuoc.database.WaterBills;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WaterAdapter extends RecyclerView.Adapter<WaterAdapter.WaterViewHolder> {
    List<WaterBills> listWaterBills = new ArrayList<>();

    public void setDataWater(List<WaterBills> listWaterBills) {
        this.listWaterBills = listWaterBills;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WaterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new WaterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WaterViewHolder holder, int position) {
        WaterBills waterBills = listWaterBills.get(position);
        if (waterBills == null) {
            return;
        }

        Locale vn = Locale.forLanguageTag("vi-VN");
        NumberFormat numberFormat = NumberFormat.getInstance(vn);

        holder.tvStartDate.setText(waterBills.getStartDate());
        holder.tvEndDate.setText(waterBills.getEndDate());
        holder.tvAmount.setText("Số khối nước tiêu thụ (m3)");
        holder.tvResultAmount.setText(waterBills.getAmountWater());
        holder.tvPayment.setText(numberFormat.format(waterBills.getPaymentWater()));
    }

    @Override
    public int getItemCount() {
        if (listWaterBills != null) {
            return listWaterBills.size();
        }
        return 0;
    }

    public class WaterViewHolder extends RecyclerView.ViewHolder {
        private TextView tvStartDate, tvEndDate, tvAmount, tvResultAmount, tvPayment;
        public WaterViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStartDate = itemView.findViewById(R.id.tv_start_date);
            tvEndDate = itemView.findViewById(R.id.tv_end_date);
            tvAmount = itemView.findViewById(R.id.tv_amount);
            tvResultAmount = itemView.findViewById(R.id.tv_result_amount);
            tvPayment = itemView.findViewById(R.id.tv_result_payment);
        }
    }
}
