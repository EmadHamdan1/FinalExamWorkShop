package com.emad.finalexamworkshop.Database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    MyRepository repository;

    public MyViewModel(@NonNull Application application) {
        super(application);
        repository = new MyRepository(application);
    }

    public void insertDelivery(Delivery delivery) {
        repository.insertDelivery(delivery);
    }

    public void updateDelivery(Delivery delivery) {
        repository.updateDelivery(delivery);
    }

    public void deleteDelivery(Delivery delivery) {
        repository.deleteDelivery(delivery);
    }

    public LiveData<List<Delivery>> getAllDeliveries() {
        return repository.getAllDeliveries();
    }

    public LiveData<List<Delivery>> getDeliveriesByStatus(String status) {
        return repository.getDeliveriesByStatus(status);
    }

}
