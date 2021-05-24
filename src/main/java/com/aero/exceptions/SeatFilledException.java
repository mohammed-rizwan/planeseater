package com.aero.exceptions;

public class SeatFilledException extends Exception{
    public SeatFilledException() {
        super("Available seats is less than the requested seats!");
    }
}
