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
public class QueueCSLS<T> implements QueueInterface<T> 
{
    private CNode<T> back; // back of queue ref
    private int numItems; // number of items in queue

    /**
     * Check if queue is empty
     */
    public boolean isEmpty() 
    {
        return back == null;
    }

    /**
     * @param newItem
     * @throws QueueException
     */
    public void enqueue(T newItem) throws QueueException 
    {
        CNode<T> newNode = new CNode<T>(newItem);
        try
        {
            if (isEmpty()) 
            {
                newNode.setNext(newNode); // new node = back if empty
            } 
            
            else 
            {
                CNode<T> next = back.getNext();
                newNode.setNext(newNode); // add new node
                back.setNext(next);
            }
            back = newNode; // update back ref
            numItems++;
        }

        catch(QueueException e)
        {
            throw new QueueException("Queue Exception on 'enqueue'.");
        }
    }

    /**
     * @return front    
     * @throws QueueException
     */
    public T dequeue() throws QueueException
    {
        T result = back.getNext().getItem();
        if(!(isEmpty()))
        {
            if (back == back.getNext()) 
            {
                back = null;
            } 
            else if(back.getNext() != back)
            {
                CNode<T> curr = back.getNext();
                back.setNext(curr.getNext());
            }
            numItems--;
            return result;
        }

        else
        {
            throw new QueueException("Queue Exception on 'dequeue'.");
        }
    }

    /**
     * Empty dequeue
     */
    public void dequeueAll() 
    {
        back = null;
        numItems = 0;
    }

    /**
     * Grab item at top of queue
     * @return back.getItem()
     */
    public T peek() throws QueueException 
    {
        if (isEmpty()) 
        {
            throw new QueueException("Queue Exception on peek: queue empty");
        } 

        else 
        {
            return back.getNext().getItem();
        }
    }

    /**
     * Returns string representation of queue
     * @return sb.toString()
     */
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        if (isEmpty()) 
        {
            sb.append("Queue is empty.");
        } 

        else 
        {
            CNode<T> curr = back.getNext();
            while (curr != back) 
            {
                sb.append(curr.getItem()).append(", ");
                curr = curr.getNext();
            }
            sb.append(back.getItem());
        }
        return sb.toString();
    }
}
