//please note that this code is different from the textbook code, because the data is encapsulated!

public class Node
{
    private Object item;
    private Node next;

    public Node(Object newItem)
    {
        item = newItem;
        next = null;
    } // end constructor

    public Node(Object newItem, Node nextNode)
    {
        item = newItem;
        next = nextNode;
    } // end constructor

    public void setItem(Object newItem)
    {
        item = newItem;
    } // end setItem

    public Object getItem()
    {
        return item;
    } // end getItem

    public void setNext(Node nextNode)
    {
        next = nextNode;
    } // end setNext

    public Node getNext()
    {
        return next;
    } // end getNext

    public String toString()
    {
        return item+" ";
    } //end toString
} // end class Node