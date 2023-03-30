/*
 * Purpose: Data Structure and Algorithms Lab 8
 * Status: Complete and thoroughly tested
 * Last update: 03/27/23
 * Submitted:  03/27/23
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: Antonio Rosado
 * @version: 2023.03.27
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Lab8P3Driver
{
    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws IOException
    {
        AscendinglyOrderedStringList list = new AscendinglyOrderedStringList();
        boolean exit = false;
        while (!exit)
        {
            System.out.println("Select from the following menu: \n"
                               + "0. Exit the program \n"
                               + "1. Insert specified item into the list \n"
                               + "2. Remove item in specified position in the list \n"
                               + "3. Search list for a specific item \n"
                               + "4. Clear the list \n"
                               + "5. Display the content of the list \n");

            System.out.print("Make your menu selection now: " );
            int input = Integer.parseInt(stdin.readLine().trim());
            System.out.println(input);
            // possible cases for initial input
            switch (input)
            {
            case 0:
                System.out.println("Exiting program... good bye");
                exit = true;
                break;

            case 1:
                try
                {
                    System.out.println("You are now inserting an item into the list.");
                    add(list);
                }

                catch(ListIndexOutOfBoundsException e)
                {
                    System.out.println("ListIndexOutOfBoundsException on 'add'. List is full!");
                }
                break;

            case 2:
                try
                {
                    System.out.println("You are now removing an item from the list.");
                    remove(list);
                }

                catch(ListIndexOutOfBoundsException e)
                {
                    System.out.println("ListIndexOutOfBoundsException on 'remove'. Position out of bounds!");
                }
                break;

            case 3:
                System.out.println("You are now searching for an item.");
                search(list);
                break;

            case 4:
                list.removeAll();
                System.out.println("List cleared");
                break;

            case 5:
                if (list.isEmpty())
                {
                    System.out.println("List is empty.");
                }
                else
                {
                    System.out.print("List of size " + list.size() + " has the following items : \n");
                    list.display();
                }
                break;

            default:
                System.out.println("Invalid choice.");
                break;
            }
        }
    }
    public static void add(AscendinglyOrderedStringList list) throws IOException
    {
        System.out.print("Enter item: ");
        String item = stdin.readLine().trim();
        System.out.println(item);
        try 
        {
            if (list.search(item) >= 0) 
            {
                System.out.println("Item " + item + " is already in the list. Please enter a different item.");
            } 
            else 
            {
                list.add(item);
                System.out.println("Item " + item + " has been added to the list.");
            }
        } 
        catch (ListIndexOutOfBoundsException e) 
        {
            System.out.println("List is full.");
        }
    }

    public static void remove(AscendinglyOrderedStringList list) throws IOException
    {
        System.out.print("Enter position to remove item from: ");
        int pos = Integer.parseInt(stdin.readLine().trim());
        System.out.println(pos);
        try 
        {
            String removed = list.get(pos);
            System.out.println("Item " + removed + " is removed from the list.");
        } 

        catch (ListIndexOutOfBoundsException e) 
        {
        System.out.println("Position specified is out of bounds.");
        }
    }

    public static void search(AscendinglyOrderedStringList list) throws IOException
    {
        System.out.print("Enter the item to search for: ");
        String key = stdin.readLine().trim();
        System.out.println(key);
        int pos = list.search(key);
        if(pos >= 0)
        {
            System.out.println("Item found in position " + pos);
        }

        else
        {
            System.out.println("Item does not exist, should be inserted in index " + -(pos + 1) );
        }
    }
}
