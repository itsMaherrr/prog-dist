package com.example.restcicd.data;

import java.util.ArrayList;
import java.util.List;

public class Car {

    String plateNumber;
    int price;
    boolean rented;

    List<Dates> dates = new ArrayList<Dates>();

    public Car(String plateNumber, int price) {
        this.plateNumber = plateNumber;
        this.price = price;
    }

    public Car() {
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public List<Dates> getDates() {
        return dates;
    }

    public void setDates(List<Dates> dates) {
        this.dates = dates;
    }
}
