package com.aero.models;

import com.aero.models.Seat;
import com.aero.models.SeatType;

import java.util.*;

public class Aeroplane {

    private int maxseat = 0;
    private int filled = 0;
    private ArrayList<ArrayList<Seat>> seats = new ArrayList<>();

    public int getMaxseat() {
        return maxseat;
    }

    public void setMaxseat(int maxseat) {
        this.maxseat = maxseat;
    }

    public int getFilled() {
        return filled;
    }

    public int incrementFilled(){
        return ++filled;
    }

    public void setFilled(int filled) {
        this.filled = filled;
    }

    public ArrayList<ArrayList<Seat>> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<ArrayList<Seat>> seats) {
        this.seats = seats;
    }

    public void printSeatsLayout(){
        System.out.println("Total seats in the plane: "+ this.maxseat);
        System.out.println("Total seats filled      : "+ this.filled);
        System.out.println("Total seats remaining   : "+ (this.maxseat - this.filled));
        System.out.println("=================================");

        System.out.println("\nSeat number pattern: XXX-Y, where XXX is passenger number and Y is seat type (A - Aisle, W - Window, C - Center) \n");

        for(ArrayList<Seat> seatRow: this.seats){
            String rowString="";
            for(Seat seat: seatRow){
                if (seat.getType().equals(SeatType.BLOCKED))
                    rowString += "      ";
                else
                    rowString = rowString + String.format("%03d", seat.getPassengerNumber()) + "-" + seat.getType().label+ "|";
            }
            System.out.println(rowString);
        }
    }
}
