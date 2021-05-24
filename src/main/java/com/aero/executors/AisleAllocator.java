package com.aero.executors;

import com.aero.models.SeatType;

public class AisleAllocator extends Allocator {
    public AisleAllocator(){
        this.seatType = SeatType.AISLE;
    }
}
