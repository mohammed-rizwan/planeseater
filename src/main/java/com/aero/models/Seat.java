package com.aero.models;

public class Seat {
    private SeatType type;
    private int passengerNumber;

    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public Seat(){
        this(SeatType.BLOCKED);
    }

    public Seat(SeatType type) {
        this.type = type;
        this.passengerNumber = 0;
    }
}

