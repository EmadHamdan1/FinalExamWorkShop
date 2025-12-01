package com.emad.finalexamworkshop;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.emad.finalexamworkshop.Database.Delivery;
import com.emad.finalexamworkshop.Database.MyViewModel;
import com.emad.finalexamworkshop.databinding.ActivityDeatilesBinding;

public class DeatilesActivity extends AppCompatActivity {

    ActivityDeatilesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityDeatilesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        Delivery delivery = (Delivery) getIntent().getSerializableExtra("delivery");

        binding.nameEt.setText(delivery.getCustomerName());
        binding.addressEt.setText(delivery.getAddress());
        binding.statusEt.setText(delivery.getStatus());
        binding.notesEt.setText(delivery.getNote());

        binding.updateOrderBt.setOnClickListener(view -> {

            String status = binding.statusEt.getText().toString();
            String nots = binding.notesEt.getText().toString();

            viewModel.updateDelivery(new Delivery(delivery.getId(),binding.nameEt.getText().toString(), binding.addressEt.getText().toString(),
                    status, nots));

            Toast.makeText(this, "Update Successfully", Toast.LENGTH_SHORT).show();
            finish();

        });

    }
}