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
public interface AscendinglyOrderedListInterface<T,KT>
{ 
    boolean isEmpty();
    int size();
    void add(T item) throws ListIndexOutOfBoundsException;
    T get(int index) throws ListIndexOutOfBoundsException;
    void remove(int index) throws ListIndexOutOfBoundsException;
    int search(KT key);
    void clear();
} 