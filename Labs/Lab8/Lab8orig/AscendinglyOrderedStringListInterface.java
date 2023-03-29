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
public interface AscendinglyOrderedStringListInterface 
{ public boolean isEmpty();
  public int size();
  public void add(String item) throws ListIndexOutOfBoundsException;
  public String get(int index) throws ListIndexOutOfBoundsException;
  public void remove(int index) throws ListIndexOutOfBoundsException;
  public int search(String key);
  public void removeAll();
} 