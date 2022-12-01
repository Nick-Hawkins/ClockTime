/**
 * TestClockTime
 * This class tests the methods of the ClockTime class
 * 
 * @author 
 * @version 
 */
public class TestClockTime
{
    public static void main (String [] args)
    {
        // make a clock with midnight
        System.out.println("Setting a clock with midnight");
        // test default constructor
        ClockTime clock1 = new ClockTime();
        System.out.println("clock1 has time: " + clock1.toString());        
        System.out.println();
        
        // change clock1 to later in the day, one part at a time
        clock1.setHour(9);
        clock1.setMinute(15);
        clock1.setSecond(33);
        
        // retrieve clock1 values, one at a time
        System.out.println("clock1 values reset to 9:15:33");
        System.out.println("new hour: " + clock1.getHour());
        System.out.println("new minute: " + clock1.getMinute());
        System.out.println("new second: " + clock1.getSecond());
        System.out.println("clock1 time using 12-hour clock: "
                    + clock1.toString12());        
        System.out.println();
        
        // make a new clock, with different time values
        ClockTime clock2 = new ClockTime(14,48,53);
        System.out.println("clock2 has time: " + clock2.toString());
        System.out.println("clock2 time using 12-hour clock: "
                    + clock2.toString12());
        System.out.println();
        
        // see if clock1 and clock2 are holding the same time
        printEquals(clock1,clock2);
            
        // add time to clock1
        System.out.println("Adding 20000 seconds to clock1");
        clock1.advance(20000);
        System.out.println("Now clock1 reads: " + clock1);
        
        // see if clock1 and clock2 are holding the same time
        printEquals(clock1,clock2);
    }
    
    // print appropriate message depending on whether the clocks hold
    // the same time values
    public static void printEquals(ClockTime clockA, ClockTime clockB)
    {
        if (clockA.equals(clockB))
            System.out.println("The two clocks read the same.");
        else
            System.out.println("The two clocks hold different times.");
        System.out.println();
    }
    
}