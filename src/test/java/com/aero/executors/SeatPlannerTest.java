package com.aero.executors;

import com.aero.helper.SeatsHelper;
import com.aero.models.Aeroplane;
import com.aero.models.Seat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeatPlannerTest {

    Aeroplane aeroplane;
    SeatPlanner seatPlanner;

    @BeforeEach
    void createModel(){
        aeroplane = new Aeroplane();
        seatPlanner = new SeatPlanner(aeroplane);
    }

    @AfterEach
    void tearDown() {
        seatPlanner = null;
        aeroplane = null;
    }

    @Test
    void assigningIncorrectInput() {
        boolean exceptionthrown = false;
        try {
            seatPlanner.arrangeSeats(new int[][]{{}});
        }catch(Exception e){
            exceptionthrown = true;
        }
        assertTrue(exceptionthrown);
    }

    @Test
    void assigningSeatsExceedingLimits() {
        boolean exceptionthrown = false;
        try {
            seatPlanner.arrangeSeats(new int[][]{{2, 2},{2, 2}});
            seatPlanner.assignStrategyOrder(new String[]{"aisle", "window", "center",});
            seatPlanner.assignPassengers(30);
        }catch(Exception e){
            exceptionthrown = true;
        }
        assertTrue(exceptionthrown);
    }

    @Test
    void assigningSeatsWithoutStrategy() {
        boolean flag = false;
        try {
            seatPlanner.arrangeSeats(new int[][]{{2, 3},{2, 2}});
            seatPlanner.assignPassengers(9);
            List<Seat> rowOne = aeroplane.getSeats().get(0);
            if(rowOne.get(0).getPassengerNumber()==5 && rowOne.get(1).getPassengerNumber()==9 && rowOne.get(2).getPassengerNumber()==1)
                flag = true;

        }catch(Exception e){
            flag = false;
        }
        assertTrue(flag);
    }

    @Test
    void assigningSeatsWithWindowAisleCenterOrder() {
        boolean flag = false;
        try {
            seatPlanner.arrangeSeats(new int[][]{{2, 3},{2, 2}});
            seatPlanner.assignStrategyOrder(new String[]{"window", "aisle", "center"});
            seatPlanner.assignPassengers(9);
            List<Seat> rowOne = aeroplane.getSeats().get(0);
            if(rowOne.get(0).getPassengerNumber()==1 && rowOne.get(1).getPassengerNumber()==9 && rowOne.get(2).getPassengerNumber()==5)
                flag = true;

        }catch(Exception e){
            flag = false;
        }
        assertTrue(flag);
    }

    @Test
    void assigningSeatsToNullPlane() {
        boolean exceptionthrown = false;
        try {
            new SeatPlanner(null).arrangeSeats(new int[][]{{2, 3},{2, 2}});
        }catch(Exception e){
            exceptionthrown = true;
        }
        assertTrue(exceptionthrown);
    }
}