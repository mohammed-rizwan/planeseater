## Prerequisite
Java (JDK 1.8), Gradle
## Execution
1. Clone this project
1. Change the inputs in `src/main/java/com/aero/Main.java` as per the below notes.
   1. `arrangeSeats` method's has to be an 2 dimensinal array referring to the seat pattern in the aeroplane. 
   1. `assignStrategyOrder` method is used to set the order in which the seats has to be filled in (Aisle -> Window -> Center).
   1. `assignPassengers` is used to allocate the given number of passengers. 
1. Run `gradle build`
1. Run `gradle run`

###Sample Output:
```
Total seats in the plane: 46
Total seats filled      : 40
Total seats remaining   : 6
=================================

Seat number pattern: XXX-Y, where XXX is passenger number and Y is seat type (A - Aisle, W - Window, C - Center) 

028-W|001-A|      002-A|039-C|003-A|      004-A|040-C|005-A|      006-A|029-W|
030-W|007-A|      008-A|000-C|009-A|      010-A|000-C|011-A|      012-A|031-W|
032-W|013-A|      014-A|000-C|015-A|      016-A|000-C|017-A|      018-A|033-W|
034-W|019-A|      020-A|000-C|021-A|      022-A|000-C|023-A|      024-A|035-W|
036-W|025-A|                                                      026-A|037-W|
038-W|027-A|

```

## Testing
1. Run `gradle test`
1. HTML Reports will be generated in `build/reports/test/*` folder