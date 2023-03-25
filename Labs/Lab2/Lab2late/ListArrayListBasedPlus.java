/*
 * Purpose: Data Structure and Algorithms Lab 2
 * Status: Complete and thoroughly tested
 * Last update: 02/02/23
 * Submitted:  02/02/23
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: Antonio Rosado
 * @version: 2023.02.02
 */

import java.util.ArrayList;

public class ListArrayListBasedPlus extends ListArrayListBased {

    /**
     * Resizes ArrayList.
     */
    public void resize()
    {
        if(numItems == items.size())
        {
            ArrayList<Object> new_items = new ArrayList<Object> (numItems * 2);
            for(int index = 0; index < items.size(); index++)
            {
                new_items.add(items.get(index));
            }
            items = new_items;
        }
    }

    /**
    * Adds items to ArrayList
    */
    public void add()
    {
        if(items.size() == numItems)
        {
            resize();
        }
        super.add(numItems, items);
    }

    /**
     * Reverses ArrayList if size cap is reached.
     */
    public void reverse()
    {
        ArrayList<Object> temp = new ArrayList<Object> (numItems);
        for(int index = 0; index < items.size() / 2; index++)
        {
            temp.add(items.size() - 1);
        }
        items = temp;
    }

    /*
     * Returns a string value of item(s) in ArrayList
     */
    public String toString()
    {
        return items.toString();
    }
}
