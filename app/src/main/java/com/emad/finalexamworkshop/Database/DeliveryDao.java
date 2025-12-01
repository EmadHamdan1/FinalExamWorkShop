package com.emad.finalexamworkshop.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DeliveryDao {
    @Insert
    void insertDelivery(Delivery delivery);

    @Update
    void updateDelivery(Delivery delivery);

    @Delete
    void deleteDelivery(Delivery delivery);

    @Query("SELECT * FROM table_deliveries")
    LiveData<List<Delivery>> getAllDeliveries();

    @Query("SELECT * FROM table_deliveries WHERE status = :status")
    LiveData<List<Delivery>> getDeliveriesByStatus(String status);

}
