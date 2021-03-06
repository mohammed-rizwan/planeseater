package com.aero.helper;

import com.aero.models.Aeroplane;
import com.aero.models.Seat;
import com.aero.models.SeatType;

import java.util.ArrayList;

public class SeatsHelper {

    public static void arrangeSeats(Aeroplane aeroplane, int[][] seatOrder) throws Exception {
        if (aeroplane == null)
            throw new Exception("Plane cannot be null");

        if (validateSeatOrderInput(seatOrder)) {
            int startColumnCount = 0;
            for (int i = 0; i < seatOrder.length; i++) {
                int windowSeat = 0;
                if (i == 0) windowSeat = -1;
                if (i == seatOrder.length - 1) windowSeat = 1;
                createSeats(aeroplane, seatOrder[i][0], seatOrder[i][1], windowSeat, startColumnCount);
                startColumnCount += seatOrder[i][1] + 1;
                aeroplane.setMaxseat(aeroplane.getMaxseat()+ seatOrder[i][0] * seatOrder[i][1]);
            }
        } else{
            throw new Exception("Invalid Seating Argument Exception");
        }
    }

    private static boolean validateSeatOrderInput(int[][] seatOrder){
        if(seatOrder == null || seatOrder.length == 0){
            return false;
        }
        for(int[] seats:seatOrder){
            for(int i:seats){
                if (i==0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void createSeats(Aeroplane aeroplane,int row, int column, int window, int startColumn){
        for (int i=0;i<row;i++){
            ArrayList<Seat> seatRow;
            int currentColumn=0;
            if(aeroplane.getSeats().size()<=i){
                seatRow = new ArrayList<Seat>();
                aeroplane.getSeats().add(seatRow);
            }else {
                seatRow= aeroplane.getSeats().get(i);
                currentColumn = seatRow.size()-1;
            }
            while(seatRow.size()!=startColumn){
                seatRow.add(new Seat(i,currentColumn++));
            }

            for(int j=0;j<column;j++){
                Seat currentSeat = null;
                if(j==0) {
                    if(window==-1)
                        currentSeat = new Seat(i,++currentColumn,SeatType.WINDOW);
                    else
                        currentSeat = new Seat(i,++currentColumn,SeatType.AISLE);
                }
                if(j==column-1) {
                    if(window==1)
                        currentSeat = new Seat(i,++currentColumn,SeatType.WINDOW);
                    else
                        currentSeat = new Seat(i,++currentColumn,SeatType.AISLE);
                }
                if(currentSeat == null)
                    currentSeat = new Seat(i,++currentColumn,SeatType.CENTER);

                seatRow.add(currentSeat);
            }
        }
    }

    public static Seat findNextAvailable(Aeroplane aeroplane, SeatType seatType, int fromRowNumber, int fromColumnNumber){
        Seat availableSeat = null;
        boolean found = false;
        ArrayList<ArrayList<Seat>> seats = aeroplane.getSeats();
        for(int i=fromRowNumber;i<seats.size();i++) {
            ArrayList<Seat> seatRow = seats.get(i);
            for(int j=fromColumnNumber;j<seatRow.size();j++) {
                Seat seat = seatRow.get(j);
                if (seat.getType().equals(seatType) && seat.getPassengerNumber() == 0) {
                    availableSeat = seat;
                    found = true;
                    break;
                }
            }
            if (found)
                break;
        }
        return availableSeat;
    }

    public static void resetPassengerArrangement(Aeroplane aeroplane){
        if (aeroplane != null) {
            for (ArrayList<Seat> seatRow : aeroplane.getSeats()) {
                for (Seat seat : seatRow) {
                    seat.setPassengerNumber(0);
                }
            }
        }
    }

    public static void resetSeating(Aeroplane aeroplane){
        if (aeroplane != null){
            aeroplane.setSeats(new ArrayList<>());
        }
    }
}
