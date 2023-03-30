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
    private static final int MAX_LIST = 5; // Maximum capacity of the list
    private String[] items; // Array to store items
    private int numItems; // Number of items in the list

    /**
     * Default constructor for AscendinglyOrderedStringList.
     * Creates a new AscendinglyOrderedStringList object with an empty array of MAX_LIST size.
     */
    public AscendinglyOrderedStringList()
    {
        super();
        items = new String[MAX_LIST];
        numItems = 0;
    } // end default constructor

    /**
     * Adds an item to the list in ascending order.
     * 
     * @param item the item to be added to the list
     * @throws ListIndexOutOfBoundsException if the index is out of range
     */
    public void add(String item) throws ListIndexOutOfBoundsException
    {
        // Binary Search II
        int pos = search(item);
        // Check if item already exists in list
        if (pos >= 0 && pos < numItems && items[pos].compareTo(item) == 0)
        {
            // Item already exists, don't insert duplicate
            System.out.println(item + " already exists in the list. Try again.");
            return;
        }

        // Resize array if it is full
        if (numItems == items.length)
        {
            resize();
        }
        // Calculate index where item should be inserted
        pos = -(pos + 1);

        // Shift items to make room for new item
        for (int index = numItems - 1; index >= pos; index--)
        {
            items[index + 1] = items[index];
        }
        items[pos] = item;
        numItems++;
        // Call add method of ListArrayBasedPlus to add item to list
        super.add(pos, item);
    } // end add

    /**
     * Returns the item at the specified index in the list.
     * 
     * @param index the index of the item to be returned
     * @return the item at the specified index in the list
     * @throws ListIndexOutOfBoundsException if the index is out of range
     */
    public String get(int index) throws ListIndexOutOfBoundsException
    {
        if (index < 0 || index >= numItems)
        {
            throw new ListIndexOutOfBoundsException("Index out of range!");
        }
        return items[index];
    } // end get

    /**
     * Removes the item at the specified index from the list.
     * 
     * @param index the index of the item to be removed from the list
     * @throws ListIndexOutOfBoundsException if the index is out of range
     */
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
        items[numItems -1] = null;
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
     * CHANGES MADE TO SEARCH METHOD
     * Binary Search II
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
        while (low <= high)
        {
            int midIndex = (low + high) / 2;
            int compare = key.compareTo(items[midIndex]);
            if (compare == 0)
            {
                // key found
                return midIndex;
            }

            else if (compare < 0)
            {
                // key smaller, search left half
                high = midIndex - 1;
            }

            else
            {
                // key larger, search right half
                low = midIndex + 1;
            }
        }
        // return index where key should be inserted
        return -(low + 1);
    }
}
