package com.emad.finalexamworkshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emad.finalexamworkshop.Database.Delivery;
import com.emad.finalexamworkshop.databinding.ItemDeliveryBinding;

import java.util.ArrayList;
import java.util.List;

public class CategoryDeliveryAdapter extends RecyclerView.Adapter<CategoryDeliveryAdapter.OrdersViewHolder> {

    List<Delivery> deliveries;
    Listener listener;


    public CategoryDeliveryAdapter(List<Delivery> deliveries, Listener listener) {
        this.deliveries = deliveries;
        this.listener = listener;
    }

    @NonNull
    @Override
    public OrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OrdersViewHolder(ItemDeliveryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrdersViewHolder holder, int position) {

        Delivery delivery = deliveries.get(position);

        holder.customerNameTv.setText(delivery.getCustomerName());
        holder.addressTv.setText(delivery.getAddress());
        holder.notesTv.setText(delivery.getNote());
        holder.statusTv.setText(delivery.getStatus());

        holder.itemView.setOnClickListener(view -> {
            listener.onClick(delivery);
        });

    }

    @Override
    public int getItemCount() {
        return deliveries.size();
    }

    public static class OrdersViewHolder extends RecyclerView.ViewHolder {

        TextView customerNameTv, addressTv, notesTv, statusTv;

        public OrdersViewHolder(ItemDeliveryBinding binding) {
            super(binding.getRoot());

            customerNameTv = binding.customerNameTv;
            addressTv = binding.addressTv;
            notesTv = binding.notesTv;
            statusTv = binding.statusTv;


        }
    }

    interface Listener {
        void onClick(Delivery delivery);
    }

}
