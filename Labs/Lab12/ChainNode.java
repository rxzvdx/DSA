/*
 * Purpose: Data Structure and Algorithms Lab 12
 * Status: Complete and thoroughly tested
 * Last update: 4/21/23
 * Submitted:  4/21/23
 * Comment: Test suite and run sample attached.
 * Comment: I declare that this is entirely my own work
 * @author: Antonio Rosado
 * @version: 2023.04.21
 */
package Lab12;
class ChainNode<K extends Comparable<? super K>, V> {
    private K key;
    private V value;
    private ChainNode<K, V> next;
  
    public ChainNode(K newKey, V newValue,
                     ChainNode<K, V> nextNode) {
      key = newKey;
      value = newValue;
      next = nextNode;
    }  // end constructor
  
    public V getValue() {
      return value;
    }  // end getValue
    
    public void setValue(V value) {
      this.value = value;
    }  // end setValue
  
  
    public K getKey() {
      return key;
    }  // end getKey
  
   public ChainNode<K, V> getNext()
    {
      return next;
    }  // end getNext
  
   public void setNext(ChainNode<K, V> next)
    {
      this.next=next;
    }  // end setNext
  
   public String toString()  //use (key,value) format
    {
        String str =  "{" + getKey() + ", " + getValue() + "}";
        return str;
    }
} // end ChainNode