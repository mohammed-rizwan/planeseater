## Prerequisite
Java (JDK 1.8), Gradle
## Execution
1. Clone this project
1. Change the inputs in `src/main/java/com/aero/Main.java` as per the below notes.
   1. `arrangeSeats` method's has to be an 2 dimensinal array referring to the seat pattern in the aeroplane. 
   1. `assignStrategy` method is used to set the order in which the seats has to be filled in.
   1. `assignPassengers` is used to allocate the given number of passengers. 
1. Run `gradle build`
1. Run `gradle run`
## Testing
1. Run `gradle test`
1. HTML Reports will be generated in `build/reports/test/*` folder