package com.emad.finalexamworkshop.Database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MyRepository {
    private final DeliveryDao deliveryDao;

    public MyRepository(Application application) {
        DeliveryDatabase db = DeliveryDatabase.getDatabase(application);
        deliveryDao = db.deliveryDao();
    }


    public void insertDelivery(Delivery delivery) {
        DeliveryDatabase.databaseWriteExecutor.execute(() -> {
            deliveryDao.insertDelivery(delivery);
        });
    }

    public void updateDelivery(Delivery delivery) {
        DeliveryDatabase.databaseWriteExecutor.execute(() -> {
            deliveryDao.updateDelivery(delivery);
        });
    }

    public void deleteDelivery(Delivery delivery) {
        DeliveryDatabase.databaseWriteExecutor.execute(() -> {
            deliveryDao.deleteDelivery(delivery);
        });
    }

    public LiveData<List<Delivery>> getAllDeliveries() {
        return deliveryDao.getAllDeliveries();
    }

    public LiveData<List<Delivery>> getDeliveriesByStatus(String status) {
        return deliveryDao.getDeliveriesByStatus(status);
    }


}
