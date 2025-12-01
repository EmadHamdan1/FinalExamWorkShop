package com.emad.finalexamworkshop;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.emad.finalexamworkshop.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolBar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                binding.drawerLayout, binding.toolBar, R.string.open_drawer, R.string.close_drawer);

        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(binding.fragmentsContainerFl.getId(),
                new DashboardFragment()).commit();

        binding.navigationView.setCheckedItem(R.id.dashboardItem);

        binding.navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.dashboardItem) {
            getSupportFragmentManager().beginTransaction().replace(binding.fragmentsContainerFl.getId(),
                    new DashboardFragment()).commit();
            binding.navigationView.setCheckedItem(R.id.dashboardItem);
            binding.drawerLayout.closeDrawer(GravityCompat.START);

        } else if (item.getItemId() == R.id.deliveryItem) {
            getSupportFragmentManager().beginTransaction().replace(binding.fragmentsContainerFl.getId(),
                    new DeliveriesFragment()).commit();
            binding.navigationView.setCheckedItem(R.id.deliveryItem);
            binding.drawerLayout.closeDrawer(GravityCompat.START);

        } else if (item.getItemId() == R.id.profileItem) {
            getSupportFragmentManager().beginTransaction().replace(binding.fragmentsContainerFl.getId(),
                    new ProfileFragment()).commit();
            binding.navigationView.setCheckedItem(R.id.profileItem);
            binding.drawerLayout.closeDrawer(GravityCompat.START);

        }else if (item.getItemId() == R.id.settingsItem) {
            getSupportFragmentManager().beginTransaction().replace(binding.fragmentsContainerFl.getId(),
                    new SettingsFragment()).commit();
            binding.navigationView.setCheckedItem(R.id.settingsItem);
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        }
        return true;
    }

}