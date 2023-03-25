/**
 * Purpose: Data Structure and Algorithms Lab 3
 * Status: Complete and thoroughly tested
 * Last update: 02/06/23
 * Submitted:  02/06/23
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: Antonio Rosado
 * @version: 2023.02.06
 */

public class MyListReferenceBased implements ListInterface
{
    private Node head;

    public MyListReferenceBased()
    {
        head = null;
    }

    /**
     * Get item from Node
     * @param int index     index of item
     * @return Object item  item from specified index
     */
    private Node find(int index) throws ListIndexOutOfBoundsException
    {
        Node curr = head;
        for(int i = 0; i < index; i++)
        {
            curr = curr.getNext();
        }
        return curr;
    }
    /**
     * Add item to Node
     * @param int index     index of item
     * @param Object item   item Object
     */
    public void add(int index, Object item) throws ListIndexOutOfBoundsException
    {
        if(index >= 0 && index < size() + 1)
        {
            if(index == 0)
            {
                head = new Node(item, head);
            }

            else
            {
                Node prev = find(index - 1);
                Node temp = new Node(item, prev.getNext());
                prev.setNext(temp);
            }
        }

        else
        {
            throw new ListIndexOutOfBoundsException("List index out of bounds on add.");
        }
    }

    /**
     * Get item from Node
     * @param int index     index of item
     * @return Object item  item from specified index
     */
    public Object get(int index) throws ListIndexOutOfBoundsException
    {
        {
            if (index >= 0 && index < size())
            {
                // get reference to node, then data in node
                Node curr = find(index);
                Object dataItem = curr.getItem();
                return dataItem;
            }
            else
            {
                throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on get");
            } // end if
        } // end get
    }

    /**
    * Check if Node is empty
    * @return head == null
    */
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
     * Remove item from Node
     * @param int index         index of item
     * @return Object result    item removed
     */
    public Object remove(int index)
    throws ListIndexOutOfBoundsException
    {   Object result;
        if (index >= 0 && index < size())
        {
            if (index == 0)
            {
                // delete the first node from the list
                result = head.getItem();
                head = head.getNext();
            }
            else
            {
                Node prev = find(index-1);
                // delete the node after the node that prev
                // references, save reference to node
                Node curr = prev.getNext();
                result = curr.getItem();
                prev.setNext(curr.getNext());
            } // end if
        } // end if
        else
        {
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds exception on remove");
        } // end if
        return result;
    }   // end remove

    /**
     * Remove all items from Node
     */
    public void removeAll()
    {

        head = null;
    }

    /**
     * Return size of Node
     * @return size of Node
     */
    public int size()
    {
        int size = 0;
        Node curr = head;
        while (curr != null)
        {
            size++;
            curr = curr.getNext();

        }
        return size;
    }  // end size

    /**
     * Returns a string value of Node items
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while(curr != null)
        {
            sb.append(curr.getItem().toString() + " ");
            curr = curr.getNext();
        }
        return sb.toString();
    }

}