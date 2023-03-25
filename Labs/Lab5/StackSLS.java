/**
 * Purpose: Data Structure and Algorithms Lab 5
 * Status: Complete and thoroughly tested
 * Last update: 02/20/23
 * Submitted: 02/20/23
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: Antonio Rosado
 * @version: 2023.02.20
 */

public class StackSLS<T> implements StackInterface<T>
{
    private Node<T> top; // pointer to top of stack

    /**
     * Constructor for objects of class Stack
     */
    public StackSLS()
    {
        top = null;
    }

    /**
     * @override
     * Check if Stack is empty
     * @return top == -1;
     */
    public boolean isEmpty()
    {
        return top == null;
    }

    /**
     * @override
     * Removes or 'pops' item from the top of the stack
     * @throws StackException   thrown if stack is empty
     * @return result           result after pop
     */
    public T pop() throws StackException
    {
        T result = null;
        if(top != null) // if stack is not empty, proceed to pop
        {
            result = top.getItem(); // result = item at top
            top = (Node<T>) top.getNext(); // items at top -> down = null
        }
        return result;
    }

    /**
     * @override
     * Removes all items on the stack
     */
    public void popAll()
    {
        top = null;
    }

    /**
     * @override
     * Adds or 'pushes' an item to top of the stack
     * @param T newItem        new item to be pushed onto stack
     * @throws StackException   thrown if stack is empty
     */
    public void push(T newItem) throws StackException
    {
        top = new Node<T>(newItem, top);
    }

    /**
     * @override
     * Retrieves item from the top of the stack
     * @throws StackException   thrown if stack is empty
     * @return result           item at top of stack
     */
    public T peek() throws StackException
    {
        T result = null;
        if(top != null)
        {
            result = top.getItem(); // retrieve item at top
        }
        return result;
    }

    /**
     * @override
     * Returns a string representation of stack
     * @return result       string representation of stack
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Node<T> curr = top;
        while(curr != null)
        {
            sb.append(curr.getItem().toString() + " ");
            curr = curr.getNext();
        }
        return sb.toString();
    }
}
