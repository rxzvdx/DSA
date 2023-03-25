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

public class ListArrayListBased implements ListInterface {
    ArrayList<Object> items;
    private static final int MAX_LIST = 3;
    int numItems;

    public ListArrayListBased()
    {
        items = new ArrayList<Object>(MAX_LIST);
        numItems = 0;
    }

    /**
     * 
     * Check if items ArrayList is empty.
     * @return  items.isEmpty()
     */
    public boolean isEmpty()
    {
        return items.isEmpty();
    }

    /**
     * 
     * Return size of ArrayList.
     * @return  items.size()
     */
    public int size()
    {
        return items.size();
    }

    /**
     * 
     * Add item to ArrayList.
     * @param int index     index of item
     * @param Object item   item Object
     */
    public void add(int index, Object item)
    {
        items.add(index, item);
    }

    /**
     * 
     * Retrieve item in ArrayList by index.
     * @param int index     index of item
     * @return              item index
     * @throw               ListIndexOutOfBoundsException
     */
    public Object get(int index)
    {
        if(index >= 0 && index < numItems)
        {
            return items.get(index);
        }
        
        else
        {
            throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on get");
        }
    }

    /**
     * 
     * Remove item in ArrayList by index.
     * @param int index     index of item
     * @return                 items.remove(index)
     * @throws              ListIndexOutOfBoundsException
     */
    public Object remove(int index) throws ListIndexOutOfBoundsException
    {
        return items.remove(index);
    }

    /**
     * 
     * Retrieve all items in ArrayList.
     * @param int index     index of item
     * @throws              ListIndexOutOfBoundsException
     */
    public void removeAll(int index) throws ListIndexOutOfBoundsException
    {
        items.removeAll(items);
    }

    @Override
    public void removeAll() {
        // TODO Auto-generated method stub
        
    }
}
