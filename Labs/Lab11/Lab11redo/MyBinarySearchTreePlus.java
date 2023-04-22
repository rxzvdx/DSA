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
public class MyBinarySearchTreePlus 
<T extends KeyedItem<KT>,
KT extends Comparable<? super KT>> 
extends MyBinarySearchTree<T,KT> 
implements BSTPInterface<T,KT>
{

    /**
     * Returns a String representation of the elements in the tree traversed in-order.
     * @return a String representation of the tree elements in-order
     */
    @Override
    public String toStringInorder() 
    {
        return inOrderHelper(root);
    }

    /**
     * Returns a String representation of the elements in the tree traversed pre-order.
     * @return a String representation of the tree elements pre-order
     */
    @Override
    public String toStringPreorder() 
    {
        return preOrderHelper(root);    
    }

    /**
     * Returns a String representation of the elements in the tree traversed post-order.
     * @return a String representation of the tree elements post-order
     */
    @Override
    public String toStringPostorder() 
    {
        return postOrderHelper(root);
    }

    /**
     * Checks if the tree has the "odd-even" characteristic, which is defined as follows:
     * At every level of the tree, the nodes must either have both children or no children.
     * Additionally, if the level is even, the number of nodes in that level must be even,
     * and if the level is odd, the number of nodes in that level must be odd.
     * @return true if the tree has the "odd-even" characteristic, false otherwise
     */
    @Override
    public boolean hasCharacteristic() 
    {
        return hasCharacteristicHelper(root, 0);
    }

    /**
     * Private helper method to traverse the tree in-order and return a String representation of its elements.
     * @param node the root of the tree or subtree to traverse
     * @return a String representation of the tree or subtree in-order
     */
    private String inOrderHelper(TreeNode<T> node)
    {
        if(node == null)
        {
            return "";
        }
        String left = inOrderHelper(node.getLeftChild());
        String right = inOrderHelper(node.getRightChild());
        return left + node.getItem().toString() + " " + right; 
    }

    /**
     * Private helper method to traverse the tree pre-order and return a String representation of its elements.
     * @param node the root of the tree or subtree to traverse
     * @return a String representation of the tree or subtree pre-order
     */
    private String preOrderHelper(TreeNode<T> node)
    {
        if (node == null)
        {
            return "";
        }
        String left = preOrderHelper(node.getLeftChild());
        String right = preOrderHelper(node.getRightChild());
        return node.getItem().toString() + " " + left + right;
    }

    /**
    * Private helper method to traverse the tree post-order and return a String representation of its elements.
    * @param node the root of the tree or subtree to traverse
    * @return a String representation of the tree or subtree post-order
    */
    private String postOrderHelper(TreeNode<T> node)
    {
        if (node == null)
        {
            return "";
        }
        String left = postOrderHelper(node.getLeftChild());
        String right = postOrderHelper(node.getRightChild());
        return left + right + node.getItem().toString() + " ";
    }

    /**
     * Checks if the tree has the "odd-even" characteristic, which is defined as follows:
     * At every level of the tree, the nodes must either have both children or no children.
     * Additionally, if the level is even, the number of nodes in that level must be even,
     * and if the level is odd, the number of nodes in that level must be odd.
     * @return true if the tree has the "odd-even" characteristic, false otherwise
     */
    private boolean hasCharacteristicHelper(TreeNode<T> node, int level)
    {
        if (node == null) 
        {
            return true;
        }
        if (level % 2 == 0) 
        {
            if (node.getLeftChild() == null && node.getRightChild() == null 
            || node.getLeftChild() != null && node.getRightChild() == null 
            || node.getLeftChild() == null && node.getRightChild() != null) 
            {
                return hasCharacteristicHelper(node.getLeftChild(), level + 1) && hasCharacteristicHelper(node.getRightChild(), level + 1);
            }
            return false;
        } 
        else 
        {
            if (node.getLeftChild() != null && node.getRightChild() != null || node.getLeftChild() == null && node.getRightChild() == null) 
            {
                return hasCharacteristicHelper(node.getLeftChild(), level + 1) && hasCharacteristicHelper(node.getRightChild(), level + 1);
            }
            return false;
        }
    }
}
