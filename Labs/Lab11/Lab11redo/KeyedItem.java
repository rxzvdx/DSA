/*
 * Purpose: Data Structure and Algorithms Lab 11
 * Status: Complete and thoroughly tested
 * Last update: 4/17/23
 * Submitted:  4/17/23
 * Comment: Test suite and run sample attached.
 * Comment: I declare that this is entirely my own work
 * @author: Antonio Rosado
 * @version: 2023.04.17
 */
package Lab11.Lab11redo;
public abstract class KeyedItem<KT extends
                                     Comparable<? super KT>> {
  private KT searchKey;

  public KeyedItem(KT key) {
     searchKey = key;
  }  // end constructor

  public KT getKey() {
    return searchKey;
  } // end getKey
} // end KeyedItem