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
package Lab11;
public interface BSTPInterface <T extends KeyedItem<KT>,KT extends Comparable<? super KT>>  
{
   
    public String toStringInorder();
    // returns String representation of Tree with items in Inorder
    //(recursive implementation)
    
    public String toStringPreorder();
    // returns String representation of Tree with items in Preorder
    //(recursive implementation)
    
    public String toStringPostorder();
    // returns String representation of Tree with items in Postorder
    // (recursive implementation)
    
    //-hasCharacteristic  returns true if the node has the characteristic that all even levels have nodes with either 0 or 1 children and all odd levels have either 0 or 2 children; false otherwise (root is on level 0(=even), root's children are on level 1, and so on)
    public boolean hasCharacteristic();
     
      
}// end BSTPInterface
