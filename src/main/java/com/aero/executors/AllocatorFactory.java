package com.aero.executors;

public class AllocatorFactory {
    public static Allocator getAllocator(String allocatorString){
        Allocator allocator = null;
        if (allocatorString == null){
            return allocator;
        }else if (allocatorString.equalsIgnoreCase("aisle")){
            return new AisleAllocator();
        }else if (allocatorString.equalsIgnoreCase("window")){
            return new WindowAllocator();
        }else {
            return new Allocator();
        }

    }
}