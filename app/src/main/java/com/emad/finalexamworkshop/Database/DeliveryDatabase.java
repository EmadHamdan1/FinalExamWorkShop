package com.emad.finalexamworkshop.Database;

import android.content.Context;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Delivery.class}, version = 1, exportSchema = false)
public abstract class DeliveryDatabase extends RoomDatabase {

    public abstract DeliveryDao deliveryDao();

    private static volatile DeliveryDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static DeliveryDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DeliveryDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    DeliveryDatabase.class, "delivery_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(roomCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {

                DeliveryDao deliveryDao = INSTANCE.deliveryDao();

                deliveryDao.insertDelivery(new Delivery("Emad Hamdan", "Gaza - Al-Nusirat",
                        "Pending", "Deliver noon"));

                deliveryDao.insertDelivery(new Delivery("Ali Ali", "Gaza - Al-Remal",
                        "In Progress", "Deliver noon"));

                deliveryDao.insertDelivery(new Delivery("Hamood Hamdan", "Gaza - Der-Al Balah",
                        "Completed", "Delivered yesterday"));

                deliveryDao.insertDelivery(new Delivery("Osama Osama", "Gaza - Al-Nusirat",
                        "Pending", "Deliver noon"));

                deliveryDao.insertDelivery(new Delivery("Osman Ali", "Gaza - Al-Remal",
                        "In Progress", "Deliver noon"));

                deliveryDao.insertDelivery(new Delivery("Jehad Hamdan", "Gaza - Der-Al Balah",
                        "Completed", "Delivered yesterday"));

            });

        }
    };

}
