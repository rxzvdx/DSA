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
public interface ExtendedQueueInterface<T> extends QueueInterface<T>{
    public void enqueueFront(T newItem) throws ExtendedQueueException;
    public T dequeueBack() throws ExtendedQueueException;
    public T peekBack() throws ExtendedQueueException;
  }  // end ExtendedQueueInterface
  