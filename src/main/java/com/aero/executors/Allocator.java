package com.aero.executors;

import com.aero.helper.SeatsHelper;
import com.aero.models.Aeroplane;
import com.aero.models.Seat;
import com.aero.models.SeatType;

public class Allocator {
    Allocator next;
    SeatType seatType;

    public Allocator(){
        this.seatType = SeatType.CENTER;
    }

    public void setNext(Allocator allocator){
        this.next = allocator;
    }

    public void allocate(Aeroplane aeroplane, int numberOfSeats){
        if (numberOfSeats==0)
            return;

        Seat seat = SeatsHelper.findNextAvailable(aeroplane,seatType,0,0);

        while(seat!=null && numberOfSeats!=0){
            seat.setPassengerNumber(aeroplane.incrementFilled());
            numberOfSeats--;
            seat = SeatsHelper.findNextAvailable(aeroplane,seatType, seat.getRowNumber(),seat.getColumnNumber());
        }
        if(numberOfSeats!=0 && next!=null )
            next.allocate(aeroplane,numberOfSeats);
    }
}
