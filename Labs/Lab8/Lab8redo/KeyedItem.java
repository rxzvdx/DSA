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
public abstract class KeyedItem<KT extends Comparable<? super KT>> 
{
  private KT searchKey;

  public KeyedItem(KT key) {
     searchKey = key;
  }  // end constructor

  public KT getKey() {
    return searchKey;
  } // end getKey
} // end KeyedItem