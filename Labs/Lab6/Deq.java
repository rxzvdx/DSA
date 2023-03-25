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
public class Deq<T> extends QueueCRAB<T> implements ExtendedQueueInterface<T>
{
    public Deq()
    {
        super();
    }

    /**
     * Enqueue item to front
     */
    public void enqueueFront(T newItem) throws ExtendedQueueException {
        if (numItems == items.length) {
            resize(2 * items.length);
        } else if (numItems > 0 && front == 0) {
            throw new ExtendedQueueException("Queue is full");
        }
        front = (front - 1 + items.length) % items.length;
        items[front] = newItem;
        numItems++;
    }


    /**
     * Dequeue item from back
     */
    public T dequeueBack() throws ExtendedQueueException
    {
        T temp = null;
        if(isEmpty())
        {	
        	throw new ExtendedQueueException("ExtendedQueueException on dequeueBack.");
        }

        else
        {
            temp = items[back];
        	back = (back + items.length - 1) % items.length;
        	items[back] = null;
        	numItems--;
            if (numItems > 0 && numItems == items.length / 4) 
            {
                resize(items.length / 2);
            }
        }
        return temp;
    }

    /**
     * Retrieve item from back
     */
    public T peekBack() throws ExtendedQueueException
    {
    	if(numItems == 0)
    	{
    		throw new ExtendedQueueException("No items");
    	}
    	return items[(back + items.length - 1) % items.length];
    }
}
