/*
 * Purpose: Data Structure and Algorithms Lab 8 EXTRA CREDIT I
 * Status: Complete and thoroughly tested
 * Last update: 03/27/23
 * Submitted:  03/27/23
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: Antonio Rosado
 * @version: 2023.03.27
 */
public class AscendinglyOrderedList<T extends KeyedItem<KT>, KT extends Comparable<? super KT>> implements AscendinglyOrderedListInterface<T, KT> {

    private T[] items;
    private int numItems;
    private static final int MAX_LIST = 10;
    private boolean assocboolean;
    private int assocint;

    @SuppressWarnings("unchecked")
    public AscendinglyOrderedList() 
    {
        items = (T[]) new KeyedItem[MAX_LIST];
        numItems = 0;
        assocboolean = false;
        assocint = 0;
    }

    @SuppressWarnings("unchecked")
    private void resize() 
    {
        T[] temp = (T[]) new KeyedItem[items.length * 2];
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

    public void setAssocboolean(boolean assocboolean)
    {
        this.assocboolean = assocboolean;
    }

    public boolean getAssocboolean()
    {
        return assocboolean;
    }

    public void setAssocint(int assocint)
    {
        this.assocint = assocint;
    }

    public int getAssocint(int assocint)
    {
        return assocint;
    }

    public void add(T item) throws ListIndexOutOfBoundsException 
    {
        KT key = item.getKey();
        int pos = search(key);
        if (pos >= 0 && pos < numItems && items[pos].getKey().compareTo(key) == 0) 
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
        }
    }

    public T get(int index) throws ListIndexOutOfBoundsException 
    {
        if (index < 0 || index >= numItems) 
        {
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

    public int search(KT key) 
    {
        int low = 0;
        int high = numItems - 1;
        int position = -1;
        boolean success = false;
        while (low <= high) 
        {
            int midIndex = (low + high) / 2;
            KT midKey = items[midIndex].getKey();
            if (key.compareTo(midKey) > 0) 
            {
                // key > midKey, search upper half of list
                low = midIndex + 1;
            } 
            else if (key.compareTo(midKey) < 0) 
            {
                // key < midKey, search lower half of list
                high = midIndex - 1;
            } 
            else 
            {
                // key == midKey, item found
                position = midIndex;
                success = true;
                break;
            }
        }
        if (success) 
        {
            return position;
        } 
        else 
        {
            return -1;
        }
    }

    @SuppressWarnings("unchecked")
    public void clear() 
    {
        items = (T[]) new KeyedItem[MAX_LIST];
        numItems = 0;
    }
}
