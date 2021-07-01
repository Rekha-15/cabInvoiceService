package com.InvoiceService;

public class Ride {
    private final int time;
    private double distance ;

    public Ride(double distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public double getDistance() {
        return distance;
    }
}