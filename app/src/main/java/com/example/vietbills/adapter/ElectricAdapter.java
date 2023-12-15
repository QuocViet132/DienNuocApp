package com.example.vietbills.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vietbills.R;
import com.example.vietbills.database.ElectricBills;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ElectricAdapter extends RecyclerView.Adapter<ElectricAdapter.ElectricViewHolder> {
    private List<ElectricBills> listElectricBills;

    public void setDataElectric(List<ElectricBills> listElectricBills) {
        this.listElectricBills = listElectricBills;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ElectricViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history,parent,false);
        return new ElectricViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ElectricViewHolder holder, int position) {
        ElectricBills electricBills = listElectricBills.get(position);
        Locale vn = Locale.forLanguageTag("vi-VN");
        NumberFormat numberFormat = NumberFormat.getInstance(vn);

        if (electricBills == null) {
            return;
        }
        holder.tvStartDate.setText(electricBills.getStartDate());
        holder.tvEndDate.setText(electricBills.getEndDate());
        holder.tvAmount.setText(electricBills.getAmountElectric());
        holder.tvPayment.setText(numberFormat.format(electricBills.getPaymentElectric()));
    }

    @Override
    public int getItemCount() {
        if (listElectricBills != null) {
            return listElectricBills.size();
        }
        return 0;
    }

    public class ElectricViewHolder extends RecyclerView.ViewHolder {
        private TextView tvStartDate, tvEndDate, tvAmount, tvPayment;
        public ElectricViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStartDate = itemView.findViewById(R.id.tv_start_date);
            tvEndDate = itemView.findViewById(R.id.tv_end_date);
            tvAmount = itemView.findViewById(R.id.tv_result_amount);
            tvPayment = itemView.findViewById(R.id.tv_result_payment);
        }
    }
}
