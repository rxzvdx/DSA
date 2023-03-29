/*
 * Purpose: Data Structure and Algorithms Lab 8 EXTRA CREDIT II
 * Status: Complete and thoroughly tested
 * Last update: 03/27/23
 * Submitted:  03/27/23
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: Antonio Rosado
 * @version: 2023.03.27
 */
public class AscendinglyOrderedStringListD
{

    private String[] items;
    private int numItems;
    private static final int MAX_LIST = 10;

    public AscendinglyOrderedStringListD()
    {
        items = new String[MAX_LIST];
        numItems = 0;
    }

    public void resize()
    {
        String[] temp = new String[items.length * 2];
        for (int i = 0; i < numItems; i++)
        {
            temp[i] = items[i];
        }
        items = temp;
    }

    public boolean isEmpty()
    {
        return numItems == 0;
    }

    public int size()
    {
        return numItems;
    }

    public void add(String item) throws ListIndexOutOfBoundsException
    {
        int pos = search(item);
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
    }

    public String get(int index) throws ListIndexOutOfBoundsException
    {
        if (index < 0 || index >= numItems) {
            throw new ListIndexOutOfBoundsException("Index out of range!");
        }
        return items[index];
    }

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
        items[numItems] = null;
    }

    public int search(String item)
    {
        int low = 0;
        int high = numItems - 1;
        int position = -1;
        while (low <= high)
        {
            int midIndex = (low + high) / 2;
            String midItem = items[midIndex];
            if (item.compareTo(midItem) > 0)
            {
                // item > midItem, search upper half of list
                low = midIndex + 1;
            }
            else
            {
                // item <= midItem, search lower half of list
                high = midIndex - 1;
                if (item.equals(midItem))
                {
                    position = midIndex;
                }
            }
        }
        if (position == -1)
        {
            // Item not found, return position where it should be inserted
            return low;
        }
        else
        {
            // Item found, return position of first occurrence
            while (position > 0 && item.equals(items[position - 1]))
            {
                position--;
            }
            return position;
        }
    }

    public void clear() {
        items = new String[MAX_LIST];
        numItems = 0;
    }
}
