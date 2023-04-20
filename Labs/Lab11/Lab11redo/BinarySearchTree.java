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
public class BinarySearchTree<T extends KeyedItem<KT>,
    KT extends Comparable<? super KT>>
    extends BinaryTreeBasis<T> {
    // inherits isEmpty(), makeEmpty(), getRootItem(), and
    // the use of the constructors from BinaryTreeBasis

    public BinarySearchTree() {
    }  // end default constructor

    public BinarySearchTree(T rootItem) {
        super(rootItem);
    }  // end constructor

    public void setRootItem(T newItem)
    throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }  // end setRootItem

    public void insert(T newItem) {
        root = insertItem(root, newItem);
    }  // end insert

    public T retrieve(KT searchKey) {
        return retrieveItem(root, searchKey);
    }  // end retrieve

    public void delete(KT searchKey) throws TreeException {
        root = deleteItem(root, searchKey);
    }  // end delete

    public void delete(T item) throws TreeException {
        root = deleteItem(root, item.getKey());
    }  // end delete

    protected TreeNode<T> insertItem(TreeNode<T> tNode,
                                     T newItem) {
        TreeNode<T> result;
        TreeNode<T> newSubtree;
        if (tNode == null) {
            // position of insertion found; insert after leaf
            // create a new node
            tNode = new TreeNode<T>(newItem, null, null);
            result = tNode;
        }  // end if
        else
        {   T nodeItem = tNode.getItem();

            // search for the insertion position

            if (newItem.getKey().compareTo(nodeItem.getKey()) < 0) {
                // search the left subtree
                newSubtree = insertItem(tNode.getLeftChild(), newItem);
                tNode.setLeftChild(newSubtree);
                result = tNode;
            }
            else { // search the right subtree
                newSubtree = insertItem(tNode.getRightChild(), newItem);
                tNode.setRightChild(newSubtree);
                result = tNode;
            }  // end if
        }
        return result;
    }  // end insertItem

    protected T retrieveItem(TreeNode<T> tNode,
                             KT searchKey) {
        T result;
        if (tNode == null) {
            result = null;
        }
        else {
            T nodeItem = tNode.getItem();
            if (searchKey.compareTo(nodeItem.getKey()) == 0) {
                // item is in the root of some subtree
                result = tNode.getItem();
            }
            else if (searchKey.compareTo(nodeItem.getKey()) < 0) {
                // search the left subtree
                result = retrieveItem(tNode.getLeftChild(), searchKey);
            }
            else { // search the right subtree
                result = retrieveItem(tNode.getRightChild(), searchKey);
            }  // end if
        }  // end if
        return result;
    }  // end retrieveItem

    protected TreeNode<T> deleteItem(TreeNode<T> tNode,
                                     KT searchKey) {
        // Calls: deleteNode.

        TreeNode<T> newSubtree;
        if (tNode == null) {
            throw new TreeException("TreeException: Item not found");
        }
        else {
            T nodeItem = tNode.getItem();
            if (searchKey.compareTo(nodeItem.getKey()) == 0) {
                // item is in the root of some subtree
                tNode = deleteNode(tNode);  // delete the item
            }
            // else search for the item
            else if (searchKey.compareTo(nodeItem.getKey()) < 0) {
                // search the left subtree
                newSubtree = deleteItem(tNode.getLeftChild(), searchKey);
                tNode.setLeftChild(newSubtree);
            }
            else { // search the right subtree
                newSubtree = deleteItem(tNode.getRightChild(), searchKey);
                tNode.setRightChild(newSubtree);
            }  // end if
        }  // end if
        return tNode;
    }  // end deleteItem

    protected TreeNode<T> deleteNode(TreeNode<T> tNode) {
        // Algorithm note: There are four cases to consider:
        //   1. The tNode is a leaf.
        //   2. The tNode has no left child.
        //   3. The tNode has no right child.
        //   4. The tNode has two children.
        // Calls: findLeftmost and deleteLeftmost
        T replacementItem;
        TreeNode<T> result;
        // test for a leaf
        if ( (tNode.getLeftChild() == null) &&
                (tNode.getRightChild() == null) ) {
            result = null;
        }  // end if leaf
        else if (tNode.getLeftChild() == null) { // test for no left child
            result = tNode.getRightChild();
        }  // end if no left child
        else if (tNode.getRightChild() == null) { // test for no right child
            result = tNode.getLeftChild();
        }  // end if no right child

        // there are two children:
        // retrieve and delete the inorder successor
        else {
            replacementItem = findLeftmost(tNode.getRightChild());
            tNode.setItem(replacementItem);
            tNode.setRightChild(deleteLeftmost(tNode.getRightChild()));
            result = tNode;
        }  // end if
        return result;
    }  // end deleteNode

    protected T findLeftmost(TreeNode<T> tNode)  {
        T result;
        if (tNode.getLeftChild() == null) {
            result = tNode.getItem();
        }
        else {
            result = findLeftmost(tNode.getLeftChild());
        }  // end if
        return result;
    }  // end findLeftmost

    protected TreeNode<T> deleteLeftmost(TreeNode<T> tNode) {
        TreeNode<T> result;
        if (tNode.getLeftChild() == null) {
            result = tNode.getRightChild();
        }
        else {
            tNode.setLeftChild(deleteLeftmost(tNode.getLeftChild()));
            result = tNode;
        }  // end if
        return result;
    }  // end deleteLeftmost

}  // end BinarySearchTree