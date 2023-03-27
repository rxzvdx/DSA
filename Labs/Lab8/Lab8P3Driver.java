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
        int pos = -1;

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
            int input = Integer.parseInt(stdin.readLine());
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
                    System.out.print("Enter item: ");
                    String item = stdin.readLine();
                    int found = list.search(item);
                    System.out.println(item);
                    if(found != -1)
                    {
                      list.add(item);
                      System.out.println(item + " inserted into the list.");
                    }
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
                    System.out.print("Enter position to remove item from: ");
                    pos = Integer.parseInt(stdin.readLine());
                    System.out.println(pos);
                    String removed = list.get(pos);
                    list.remove(pos);
                    System.out.println(removed + " removed from the list.");
                }

                catch(ListIndexOutOfBoundsException e)
                {
                    System.out.println("ListIndexOutOfBoundsException on 'remove'. Position out of bounds!");
                }
                break;

            case 3:
                System.out.print("You are now searching for an item. \n Enter the item position to search for: ");
                pos = Integer.parseInt(stdin.readLine());
                String searchedItem = list.get(pos);
                list.search(searchedItem);
                System.out.println("Item " + list.get(pos) + " found in position " + pos);
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
}
