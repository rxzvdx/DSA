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
public abstract class BinaryTreeBasis<T> {
    protected TreeNode<T> root;
  
    public BinaryTreeBasis() {
      root = null;
    }  // end default constructor
  
    public BinaryTreeBasis(T rootItem) {
      root = new TreeNode<T>(rootItem, null, null);
    }  // end constructor
  
    public boolean isEmpty() {
    // Returns true if the tree is empty, else returns false.
      return root == null;
    }  // end isEmpty
  
    public void makeEmpty() {
    // Removes all nodes from the tree.
      root = null;
    }  // end makeEmpty
  
    public T getRootItem() throws TreeException {
    // Returns the item in the tree's root.
      if (root == null) {
        throw new TreeException("TreeException: Empty tree");
      }
      else {
        return root.getItem();
      }  // end if
    }  // end getRootItem
  
    public abstract void setRootItem(T newItem);
      // Throws UnsupportedOperationException if operation
      // is not supported.
  
  }  // end BinaryTreeBasis