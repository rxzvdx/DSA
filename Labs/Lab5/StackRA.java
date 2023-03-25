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

public class StackRA<T> implements StackInterface<T>
{
    private T[] items; // items in stack
    private int top; // pointer to top of stack

    /**
     * Constructor for objects of class StackRA
     *
     */
    @SuppressWarnings("unchecked")
    public StackRA()
    {
        items = (T[])new Object[3]; // initialize Array with generic casting
        top = -1;
    }

    /**
     * @override
     * Check if Stack is empty
     * @return top == -1;
     */
    public boolean isEmpty()
    {
        return top == -1;
    }

    /**
     * @override
     * Removes or 'pops' item from the top of the stack
     * @throws StackException   thrown if stack is empty
     * @return result
     */
    public T pop() throws StackException
    {
        T result = null;
        if(top != -1) // if stack is not empty, proceed to pop
        {
            result = items[top]; // result = item at top
            items[top--] = null; // items at top -> down = null
        }
        return result;
    }

    /**
     * @override
     * Removes all items on the stack
     */
    @SuppressWarnings("unchecked")
    public void popAll()
    {
        items = (T[])new Object[3];
        top = -1;
    }

    /**
     * @override
     * Adds or 'pushes' an item to top of the stack
     * @param T newItem        new item to be pushed onto stack
     * @throws StackException   thrown if stack is empty
     */
    public void push(T newItem) throws StackException
    {
        if(top == items.length -1)
        {
            resize();
        }
        items[++top] = newItem;
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
        if(top != -1)
        {
            result = items[top]; // retrieve item at top
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
        String result = "";
        for(int index = 0; index <= top; index++)
        {
            result += items[index] + " ";
        }
        return result;
    }

    /**
     * resizes the array according to number of items
     */
    @SuppressWarnings("unchecked")
    public void resize()
    {
        T[] temp = (T[])new Object[(int)(items.length * 1.5)];
        for(int index = 0; index < items.length; index++)
        {
            temp[index] = items[index];
        }
        items = temp;
    }
}
