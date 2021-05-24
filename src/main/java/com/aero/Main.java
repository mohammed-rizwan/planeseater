package com.aero;

import com.aero.executors.SeatPlanner;
import com.aero.helper.SeatsHelper;
import com.aero.models.Aeroplane;

public class Main {
    public static void main(String[] args) throws Exception{
        try {
            Aeroplane aeroplane = new Aeroplane();
            SeatPlanner seatPlanner = new SeatPlanner(aeroplane);
            seatPlanner.arrangeSeats(new int[][]{{6, 2}, {4, 3}, {3, 2}, {5, 2}});
            seatPlanner.assignStrategy(new String[]{"window", "center", "aisle",});
            seatPlanner.assignPassengers(30);
            aeroplane.printSeatsLayout();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}