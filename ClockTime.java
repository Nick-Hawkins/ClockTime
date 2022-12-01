/*Clock Class(24 Hour format)*/
public class ClockTime {
    
    /*Instance Variables*/
    private int hour; //Holds hours value
    private int minute; //Holds minutes value
    private int second; //Holds seconds value 

    /*Default Constructor*/
    public ClockTime() {
        hour = 0;
        minute = 0;
        second = 0;
    }

    /*Constructor with parameters*/
    public ClockTime(int h, int m, int s) {
        /*Sets hours, minutes, and seconds to values passed*/
        hour = h;
        minute = m;
        second = s;

        /*Checking Errors*/
        if (second > 59) { 
            /*When seconds is greater than 59*/
            minute += second / 60; //Finds how may minutes are in seconds value
            second = second % 60; //Finds the ramaining seconds
        }
        if (minute > 59) {
            /*When minutes is greater than 59*/
            hour += minute / 60; //Finds how many hours are in minutes value
            minute = minute % 60; //Finds the remaining minutes
        }
        if (hour > 23) {
            /*When hours is greater than 23*/
            hour =  hour % 24; //Finds the raming hours(start of new day)
        }
        if (hour < 0) hour = 0; //If hours is less than, set it to 0
    }

    /* Getters to get values for hours, minutes and seconds
     * Each getter method returns an integer value and takes
     * no parameters */
    public int getHour() {
        return hour; //Returns hours
    }
    public int getMinute() {
        return minute; //Returns minutes
    }
    public int getSecond() {
        return second; //Returns seconds
    }

    /* Setter methods to set the values of hours, minutes, 
     * and seconds to the value passed in the parameter.
     * These methods are void therefor returning nothing */
    public void setHour(int x) {
        hour = x; //Sets hour to value passed
        /*Checking Errors*/
        if (hour > 23) {
            hour =  hour % 24;
        }
        if (hour < 0) hour = 0;
    }

    public void setMinute(int x) {
        minute = x; //Sets minutes to value passed
        /*Checking Errors*/
        if (minute > 59) {
            hour += minute / 60;
            minute = minute % 60;
        }
    }

    public void setSecond(int x) {
        second = x; //Sets seconds to value passed
        /*Checking Errors*/
        if (second > 59) {
            minute += second / 60;
            second = second % 60;
        }
    }

    /* toString Method to print the clocks time(24 Hour Format) 
     * Takes no parameters and returns a string*/
    public String toString() {
        String time = ""; //Creates a string to return information on clock
        if (hour < 10) time = time + "0" + hour; //Adds hour value with a 0 in front if it is a single digit to time string
        else time = time + hour; //Else adds hour value to time string
        
        if (minute < 10) time = time + ":0" + minute; //Adds minute value with a 0 in front if it is a single digit to time string
        else time = time + ":" + minute; //Else adds minute value to time string

        if (second < 10) time = time + ":0" + second; //Adds second value with a 0 in front if it is a single digit to time string
        else time = time + ":" + second; //Else adds seconds value to time string

        return time; //Returns time string
    }

    /* toSring12 Method to print the clocks time(12 Hour Foramt) 
     * Takes no paramters and returns a string*/
    public String toString12() {
        String time = ""; //Creates a string to return information on clock(with am or pm)
        
        if (hour > 12 || (hour == 12 && minute > 0 || hour == 12 && second > 0)) { //Logic Branch for when time is PM
            if (hour > 12) { //When it is not within the noon hour(PM)
                if (hour % 12 < 10) time = time + "0" + hour % 12 + ":"; //Adds a 0 and hour value converted to 12 hour time (single digit)
                else time = time + hour % 12 + ":"; //Else adds hour value converted to 12 hour time

                if (minute < 10) time = time + "0" + minute + ":"; //Adds a 0 and minute value when minute is single digit
                else time = time + minute + ":"; //Else adds minute value 

                if (second < 10) time = time + "0" + second + " P.M"; //Adds 0 and second value when second second is single digit
                else time = time + second + " P.M"; //Else adds second value
            }
            else { //When it is noon
                time = hour + ":"; //Adds hour
                if (minute < 10) time = time + "0" + minute + ":"; //Adds a 0 and minute value when minute is single digit
                else time = time + minute + ":"; //Else adds minute value 

                if (second < 10) time = time + "0" + second + " P.M"; //Adds 0 and second value when second second is single digit
                else time = time + second + " P.M"; //Else adds second value
            }
        }
        else { //Logic Branch for when time is AM
            if (hour == 0) { //For when it is the first hour of the day
                time = "12:"; //Adds hour
                if (minute < 10) time = time + "0" + minute + ":"; //Adds a 0 and minute value when minute is single digit
                else time = time + minute + ":"; //Else adds minute value

                if (second < 10) time = time + "0" + second + " A.M"; //Adds 0 and second value when second second is single digit
                else time = time + second + " A.M"; //Else adds second value
            }
            else { //All other hours in morning
                if (hour < 10) time = time + "0" + hour + ":"; //Adds a 0 and hour value when hour is single digit
                else time = time + hour + ":"; //Else adds hour value

                if (minute < 10) time = time + "0" + minute + ":"; //Adds a 0 and minute value when minute is single digit
                else time = time + minute + ":"; //Else adds minute value

                if (second < 10) time = time + "0" + second + " A.M"; //Adds 0 and second value when second second is single digit
                else time = time + second + " A.M"; //Else adds second value
            }
        }
        return time; //Returns time string
    }

    
    /*advance Method to add a value in seconds to the clock
     * This value is the int parameter, and the method returns nothing*/
    public void advance(int x) {
        while (x > 3599) { //When adding seconds greater than a hour
            hour += x / 3600; //Adds hours held in seconds value
            x = x - (x / 3600) * 3600; //Subtracts hour value in seconds from x
        }
        while (x > 59) { //When adding seconds greater than a minute
            minute += x / 60; //Adds minutes held in seconds value
            x = x - (x / 60) * 60; //Subtracts minute value in seconds from x
            if (minute > 59) { //Checks minutes
                /*When minutes is greater than 59*/
                hour = minute / 60; //Finds how many hours are in minutes value
                minute = minute % 60; //Finds the remaining minutes
            }
        }
        while (x > 0) { //When adding seconds
            second += x; //Adds seconds to second
            x = x - x; //Makes x 0
            if (second > 59) {  //Checks seconds
                /*When seconds is greater than 59*/
                minute = second / 60; //Finds how may minutes are in seconds value
                second = second % 60; //Finds the ramaining seconds
            }
        }
        if (hour > 23) { //Start of new day
            hour = 0;
            minute = 0;
            second = 0;
        }
    }

    /* equals Method to compare if two clocks read the same time
     * This method takes in a ClcokTime object as a parameter and
     * returns a boolean value*/
    public boolean equals(ClockTime c) {
        /*Compares hours, minutes, and seconds and returns true if all equal*/
        if (hour == c.getHour() && minute == c.getMinute() && second == c.getSecond()) return true; 
        else return false; //Returns false if the clocks do not read the same time
    }
}
