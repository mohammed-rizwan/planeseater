package com.aero.executors;

import com.aero.exceptions.SeatFilledException;
import com.aero.helper.SeatsHelper;
import com.aero.models.Aeroplane;

public class SeatPlanner {
    private Allocator allocator;
    private Aeroplane aeroplane;

    public SeatPlanner(Aeroplane aeroplane) {
        this.aeroplane = aeroplane;
    }

    public void arrangeSeats(int[][] seatPattern) throws Exception {
        SeatsHelper.arrangeSeats(this.aeroplane,seatPattern);
    }

    public void assignStrategyOrder(String[] seatFillingOrder){
        Allocator current = allocator;
        if (seatFillingOrder.length!=0){
            for(String string: seatFillingOrder){
                if (seatFillingOrder != null){
                    Allocator currentAllocator = AllocatorFactory.getAllocator(string);
                    if(currentAllocator != null){
                        if (current == null) {
                            current = currentAllocator;
                            allocator = current;
                        } else {
                            current.setNext(currentAllocator);
                        }
                        current = currentAllocator;
                    }
                }
            }
        }
    }

    public void assignPassengers(int numberOfseats) throws Exception {
        if(allocator == null)
            throw new Exception("Allocator Strategy Unassigned!");
        if(numberOfseats > this.aeroplane.getMaxseat()- this.aeroplane.getFilled())
            throw new SeatFilledException();

        allocator.allocate(this.aeroplane, numberOfseats);
    }

    public void resetAllocator(){
        allocator = null;
    }
}
