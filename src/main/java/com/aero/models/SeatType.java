package com.aero.models;

public enum SeatType{
    AISLE("A"),
    CENTER("C"),
    WINDOW("W"),
    BLOCKED("X"),
    WAY(" ");

    public final String label;

    private SeatType(String label){
        this.label=label;
    }
}
