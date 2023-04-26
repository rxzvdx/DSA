/*
 * Purpose: Data Structure and Algorithms Review Programming Assignment
 * Status: Complete and thoroughly tested
 * Last update: 1/27/23
 * Submitted:  1/27/23
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: Antonio Rosado
 * @version: 2023.01.27
 */


/**
 * Creates an event depending on user input
 *
 * @author (Antonio Rosado)
 * @version (1/24/2023)
 */
public class Event {
    protected static int day; // day int
    protected static String month; // month int
    protected static int year; // year int
    protected static String date = ""; // date string
    protected static String eventName = "";

    /**
     *
     * Creates an event with specified info
     * @param int day               day of event
     * @param int month             month of event
     * @param int year              year of event
     * @param String date           date of event
     * @param String eventName      name of eveng
     */
    public Event(int day, String month, int year, String date, String eventName)
    {
        Event.day = day;
        Event.month = month;
        Event.year = year;
        Event.date = date;
        Event.eventName = eventName;
    }

    /**
     * Return day of event
     *
     * @return    day int
     */
    public static int getDay ()
    {
        return day;
    }

    /**
     * Return month of event
     *
     * @return    month int
     */
    public static String getMonth ()
    {
        return month;
    }

    /**
    * Return year of event
    *
    * @return    year int
    */
    public static int getYear ()
    {
        return year;
    }

    /**
    * Return year of event
    *
    * @return    year int
    */
    public static int findEvent ()
    {
        return year;
    }

    /**
     * Return date of event
     * @param int day               day of event
     * @param int month             month of event
     * @param int year              year of event
     * @return                      month + date + year
     */
    public static String getDate (String month, int day, int year)
    {
        String date = (month + " " + day + ", " + year + ".");
        return date;
    }

    /**
     * Return name of event
     *
     * @return    day int
     */
    public static String getEventName ()
    {
        return eventName;
    }

    /**
     * Return month of event
     *
     * @return    month int
     */
    public static void addEvent(String event) {
    }

    public static void addDay(int day) {
    }

    public static void addMonth(String month) {
    }

    public static void addYear(int year) {
    }

    public static void addEventName(String eventName)
    {

    }
}
