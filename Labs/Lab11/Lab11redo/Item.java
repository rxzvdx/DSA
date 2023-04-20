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
public class Item <KT extends Comparable<? super KT>> extends KeyedItem<KT>
{

    private boolean assocboolean;
    private String assocstring;
    public Item(KT key, boolean assocboolean, String assocstring) 
    {
        super(key);
        this.assocboolean = assocboolean;
        this.assocstring = assocstring;
    }

    public boolean isAssocboolean() 
    {
        return assocboolean;
    }

    public void setAssocboolean(boolean assocboolean) 
    {
        this.assocboolean = assocboolean;
    }

    public String getAssocstring() 
    {
        return assocstring;
    }

    public void setAssocstring(String assocstring) 
    {
        this.assocstring = assocstring;
    }

    @Override
    public String toString() 
    {
        return "{" + getKey() + "/" + assocboolean + "/" + assocstring + "}";
    }
    
}