package com.emad.finalexamworkshop;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emad.finalexamworkshop.Database.Delivery;
import com.emad.finalexamworkshop.Database.MyViewModel;
import com.emad.finalexamworkshop.databinding.FragmentCategoryBinding;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment implements CategoryDeliveryAdapter.Listener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_STATUS = "status";

    // TODO: Rename and change types of parameters
    private String status;

    public CategoryFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CategoryFragment newInstance(String status) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_STATUS, status);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            status = getArguments().getString(ARG_STATUS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentCategoryBinding binding = FragmentCategoryBinding.inflate(inflater, container, false);
        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        if (status.equals("Pending")) {

            viewModel.getDeliveriesByStatus(status).observe(requireActivity(), deliveries -> {
                CategoryDeliveryAdapter adapter = new CategoryDeliveryAdapter(deliveries, this);
                binding.categoryRv.setAdapter(adapter);
                binding.categoryRv.setLayoutManager(new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false));
            });

        } else if (status.equals("In Progress")) {
            viewModel.getDeliveriesByStatus(status).observe(requireActivity(), deliveries -> {
                CategoryDeliveryAdapter adapter = new CategoryDeliveryAdapter(deliveries, this);
                binding.categoryRv.setAdapter(adapter);
                binding.categoryRv.setLayoutManager(new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false));
            });
        } else if (status.equals("Completed")) {
            viewModel.getDeliveriesByStatus(status).observe(requireActivity(), deliveries -> {
                CategoryDeliveryAdapter adapter = new CategoryDeliveryAdapter(deliveries, this);
                binding.categoryRv.setAdapter(adapter);
                binding.categoryRv.setLayoutManager(new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false));
            });
        }

        return binding.getRoot();
    }

    @Override
    public void onClick(Delivery delivery) {

        startActivity(new Intent(requireActivity(), DeatilesActivity.class).putExtra("delivery", delivery));

    }
}