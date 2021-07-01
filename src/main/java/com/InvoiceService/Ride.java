package com.InvoiceService;

public class Ride {
	
	private final int time;
    private double distance ;
    public String rideType;

    public Ride(double distance, int time, String rideType) {
        this.distance = distance;
        this.time = time;
        this.rideType = rideType;
    }

    public int getTime() {
        return time;
    }

    public double getDistance() {
        return distance;
    }
}