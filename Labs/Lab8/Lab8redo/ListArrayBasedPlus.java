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

public class ListArrayBasedPlus extends ListArrayBased
{
    /**
     * Constructor.
     */
    public ListArrayBasedPlus() {
        super();
    }

    /**
     * Adds items to Array
     */
    public void add(int index, Object item)
    {
        if(items.length == numItems)
        {
            resize(); // if items reaches max size/num of items, resize array
        }
        super.add(index, item); // call superclass
    }

    /**
     * Reverses Array.
     */
    public void reverse()
    {
        for (int index = 0; index < numItems / 2; index++)
        {
            Object temps = items[index];
            items[index] = items[numItems - index - 1];
            items[numItems - index - 1] = temps;
        }
    }

    /**
     * Resizes array if size cap is reached.
     */
    public void resize()
    {
        int resize = items.length;
        Object[] new_list = new Object[items.length * 2]; // new Array == oldArray * 2
        for(int index = 0; index < numItems; index++)
        {
            new_list[index] = items[index];
        }
        items = new_list;
    }

    /**
     * Returns a string value of item(s) in Array
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < numItems; ++index) // pre-increment
        {
            sb.append(items[index] + " ");
        }
        return sb.toString();
    }

    //  /**
    //   * Returns length of Array
    //   * @return       int length
    //   */
    //  public int length()
    //  {
    //      return items.length;
    //  }
}