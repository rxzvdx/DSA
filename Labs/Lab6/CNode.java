/**
 * Purpose: Data Structure and Algorithms Lab 6
 * Status: Complete and thoroughly tested
 * Last update: 02/27/23
 * Submitted: 02/27/23
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: Antonio Rosado
 * @version: 2023.02.27
 */
public class CNode<T>
{        
    private T item;
    private CNode<T> next;
    
    /**
     * @param newItem
     * @param newNext
     */
    public CNode(T newItem) 
    {
        this.item = newItem;
        next = null;
    }
    
    /**
     * @param newItem
     */
    public void setItem(T newItem) 
    {
        this.item = newItem;
    }
    
    /**
     * @return
     */
    public T getItem() 
    {
        return item;
    }
    
    /**
     * @param newNext
     */
    public void setNext(CNode<T> newNext) 
    {
        this.next = newNext;
    }
    
    /**
     * @return next
     */
    public CNode<T> getNext() 
    {
        return next;
    }
}    

