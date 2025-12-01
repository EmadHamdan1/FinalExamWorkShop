package com.emad.finalexamworkshop.Database;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "table_deliveries")
public class Delivery implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String customerName;
    private String address;
    private String status;
    private String note;

    @Ignore
    public Delivery(int id, String customerName, String address, String status, String note) {
        this.id = id;
        this.customerName = customerName;
        this.address = address;
        this.status = status;
        this.note = note;
    }

    public Delivery(String customerName, String address, String status, String note) {
        this.customerName = customerName;
        this.address = address;
        this.status = status;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
