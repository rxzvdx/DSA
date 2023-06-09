/*
 * Purpose: Data Structure and Algorithms Lab 8
 * Status: Complete and thoroughly tested
 * Last update: 03/27/23
 * Submitted:  03/27/23
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: Antonio Rosado
 * @version: 2023.03.27
 */
public class AscendinglyOrderedStringList extends ListArrayBasedPlus implements AscendinglyOrderedStringListInterface
{
    private static final int MAX_LIST = 10;
    private String[] items;
    private int numItems;

    public AscendinglyOrderedStringList()
    {
        super();
        items = new String[MAX_LIST];
        numItems = 0;
    } // end default constructor

    public void add(String item) throws ListIndexOutOfBoundsException
    {
        int pos = search(item);
        if (pos >= 0 && pos < numItems && items[pos].compareTo(item) == 0)
        {
            // Item already exists, don't insert duplicate
            System.out.println(item + " already exists in the list. Try again.");
            return;
        }

        else
        {
            if (numItems == items.length)
            {
                resize();
            }
            // Shift items to make room for new item
            for (int index = numItems - 1; index >= pos; index--)
            {
                items[index + 1] = items[index];
            }
            items[pos] = item;
            numItems++;
            super.add(pos, item);
        }
    } // end add

    public String get(int index) throws ListIndexOutOfBoundsException
    {
        if (index < 0 || index >= numItems)
        {
            throw new ListIndexOutOfBoundsException("Index out of range!");
        }
        return items[index];
    } // end get

    public void remove(int index) throws ListIndexOutOfBoundsException
    {
        if (index < 0 || index >= numItems)
        {
            throw new ListIndexOutOfBoundsException("Index out of range!");
        }
        // Shift items to remove item at specified index
        for (int j = index; j < numItems - 1; j++)
        {
            items[j] = items[j + 1];
        }
        numItems--;
    } // end remove

    public void display()
    {
        if(numItems != 0)
        {
            for (int i = 0; i < numItems; i++)
            {
                System.out.print(items[i] + " "  + "\n");
            }
            System.out.println();
        }
    }
    /**
     * Searches for an item in the list using compareTo
     * @param key     the item to search for
     * @return        the index of the item if found
     * while(low <= high)
     * {
     *    midIndex = (low + high) / 2
     *    if (key > midKey)
     *       low = midIndex + 1
     *    else
     *       high = midIndex
     * }
     * if(key == currKey)
     *    stop(succ, pos)
     * else
     *    stop(unsucc, pos)
     */
    public int search(String key)
    {
        int low = 0;
        int high = numItems - 1;
        int position = -1;
        while (low <= high)
        {
            int midIndex = (low + high) / 2;
            String midKey = items[midIndex];
            if (key.compareTo(midKey) > 0)
            {
                // key > midKey, search upper half of list
                low = midIndex + 1;
            }

            else if(key.compareTo(midKey) < 0)
            {
                // key <= midKey, search lower half of list
                high = midIndex - 1;
            }

            else
            {
                // key found
                return position = midIndex;
            }
        // key was not found, return position where it should be placed
        } 
        return low;
    }
}
