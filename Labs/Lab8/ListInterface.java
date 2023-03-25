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
// ********************************************************
// Interface ListInterface for the ADT list.
// *********************************************************
public interface ListInterface
{
    boolean isEmpty();
    int size();
    void add(int index, Object item) throws ListIndexOutOfBoundsException;
    Object get(int index) throws ListIndexOutOfBoundsException;
    Object remove(int index) throws ListIndexOutOfBoundsException;
    void removeAll();
    String toString();
}  // end ListInterface

/** Source code for ArrayList
 *
 *
 *
 public boolean isEmpty()
 {
  return size == 0;
 }

public int size()
{
  return size;
}

public void add(int index, E e)
 {
    checkBoundInclusive(index);
    modCount++;
    if (size == data.length)
      ensureCapacity(size + 1);
    if (index != size)
      System.arraycopy(data, index, data, index + 1, size - index);
    data[index] = e;
    size++;
 }

public E get(int index)
{
  checkBoundExclusive(index);
  return data[index];
}


public E remove(int index)
{
  checkBoundExclusive(index);
  E r = data[index];
  modCount++;
  if (index != --size)
    System.arraycopy(data, index + 1, data, index, size - index);
  // Aid for garbage collection by releasing this pointer.
  data[size] = null;
  return r;
}
 *
 *
 */

