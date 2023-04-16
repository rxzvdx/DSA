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
public class MyBinarySearchTreePlus 
<T extends KeyedItem<KT>,
KT extends Comparable<? super KT>> 
extends MyBinarySearchTree<T,KT> 
implements BSTPInterface<T,KT>
{

    @Override
    public String toStringInorder() 
    {
        return inOrderHelper(root);
    }

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

    @Override
    public String toStringPreorder() 
    {
        return preOrderHelper(root);    
    }

    @Override
    public String toStringPostorder() 
    {
        return postOrderHelper(root);
    }

    @Override
    public boolean hasCharacteristic() 
    {
        return hasCharacteristicHelper(root, 0);
    }

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
