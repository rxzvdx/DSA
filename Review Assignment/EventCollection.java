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

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class EventCollection extends Event {
    static HashMap<String, String> eventMap = new HashMap<>();

    /**
     *
     * Creates an event with specified info
     * @param int day               day of event
     * @param int month             month of event
     * @param int year              year of event
     * @param String date           date of event
     * @param String eventName      name of event
     */
    public EventCollection(int day, String month, int year, String date, String eventName) {

        super(day, month, year, date, eventName);

    }

    /**
     * Add event to eventList
     * @param String eventname       String eventName
     */
    public static void addEvent(String eventName)
    {
        if(eventMap != null && (!eventMap.containsKey(eventName)))
        {
            eventMap.put(eventName, date);
        }
    }

    /**
     * Remove event by specified event name
     *
     * @param String eventName eventName String
     */
    public static void removeEvent(String eventName)
    {
        if(eventMap.containsKey(eventName))
        {
            eventMap.remove(eventName);
        }
    }

    /**
     * Remove all events on specifed day
     * @param String date       date string
     */
    public static void removeEventsOnDay(String dateCheck)
    {
        if(!(eventMap.isEmpty()) && (eventMap.containsValue(dateCheck)))
        {
            eventMap.values().removeAll(Collections.singleton(dateCheck));
        }
    }
}
