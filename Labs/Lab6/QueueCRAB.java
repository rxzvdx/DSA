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
public class QueueCRAB<T> implements QueueInterface<T> 
{
    protected T[] items;
    protected int front;
    protected int back;
    protected int numItems;
    
    /**
     * Constructor
     */
    @SuppressWarnings("unchecked")
    public QueueCRAB()
    {
        items = (T[]) new Object[1];
        front = 0; 
        back = 0;
        numItems = 0;
    }

    /**
     * Check if collection is empty
     * @return numItems == 0
     */
    public boolean isEmpty()
    {
        return (numItems == 0);
    }

    /**
     * Increase queue
     * @throws QueueException
     */
    public void enqueue(T newItem) throws QueueException {
        if (numItems == items.length) {
            throw new QueueException("Queue is full");
        } else {
            items[back] = newItem;
            back = (back + 1) % items.length;
            numItems++;
        }
    }

    /**
     * Decrease queue
     * @throws QueueException
     */
    public T dequeue() throws QueueException 
    {
        T queueFront = items[front];
        if (isEmpty()){
            throw new QueueException("QueueException on dequeue: queue empty");
        } 

        else 
        {
            items[front] = null;
            front = (front + 1) % items.length;
            numItems--;
            if(numItems > 0 && numItems == items.length / 4)
            {
                resize(items.length / 2);
            }
            return queueFront;
        }
    }

    /**
     * Empties queue
     */
    @SuppressWarnings("unchecked")
    public void dequeueAll() 
    {
        items = (T[]) new Object[1];
        front = 0;
        back = 0;
        numItems = 0;
    }

    /**
     * Retrieve item at top of queue
     * @throws QueueException
     */
    public T peek() throws QueueException 
    {
        if (isEmpty()) 
        {
            throw new QueueException("QueueException on peek: queue empty");
        } 
        
        else 
        {
            return items[front];
        }
    }

    /**
     * Resize queue if full
     * @param newSize
     */
    @SuppressWarnings("unchecked")
    protected void resize(int newSize) 
    {
        T[] temp = (T[]) new Object[newSize];
        for (int index = 0; index < numItems; index++) 
        {
            int i = (front + index) % items.length;
            temp[i] = items[i];
        }
        items = temp;
        front = 0;
        back = numItems;
    }

    /**
     * Returns string representation of queue
     */
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int index = 0; index < numItems; index++) 
        {
            int i = (front + index) % items.length;
            sb.append(items[i]);
            if (index < numItems - 1) 
            {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
