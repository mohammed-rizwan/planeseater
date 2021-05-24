package com.aero.models;

public class Seat {
    private SeatType type;
    private int passengerNumber;
    private int rowNumber;
    private int columnNumber;

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

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public Seat(int rowNumber, int columnNumber){
        this(rowNumber, columnNumber, SeatType.BLOCKED);
    }

    public Seat(int rowNumber, int columnNumber, SeatType type) {
        this.type = type;
        this.passengerNumber = 0;
    }

}

