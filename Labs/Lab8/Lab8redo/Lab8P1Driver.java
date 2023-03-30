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
public class Lab8P1Driver 
{
    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws IOException 
    {
      ListArrayBasedPlus list_plus = new ListArrayBasedPlus();
      boolean exit = false;
      
	  while (!exit) 
    {
            System.out.println("Select from the following menu: \n"
                             + "0. Exit the program \n"
                             + "1. Insert item into ordered list \n"
                             + "2. Remove item from the list \n"
                             + "3. Get item from the list \n"
                             + "4. Search for a specific item in the list \n" 
                             + "5. Clear the list \n"
                             + "6. Print size and content of the list \n");

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
                // NEW CHANGES MADE
                System.out.println("You are now inserting an item into the list. ");
                add(list_plus);
                break;

              case 2:
                System.out.println("You are now removing an item from the list. ");   
                remove(list_plus); 
                break;

              case 3:
                System.out.print("You are now retrieving an item. ");
                retrieve(list_plus);
                break;

              case 4:
                System.out.print("You are now searching for an item. \n Enter the item to search for: ");
                search2(list_plus);
                break;

              case 5:
                System.out.println("Clearing list...");
                list_plus.removeAll();
                System.out.println("List cleared.");
                break;

              case 6:
                if(list_plus.isEmpty())
                {
                  System.out.println("List is empty.");
                }
                
                else
                {
                  System.out.println("List of size " + list_plus.size() + " has the following items: " + list_plus.toString());
                }
                break;
            }
        }
    }
    public static void add(ListArrayBasedPlus list_plus) throws IOException
    {
      System.out.print("Enter item: ");
      String item = stdin.readLine().trim();
      System.out.println(item);
      System.out.print("Enter the position to enter the item in: ");
      int position = Integer.parseInt(stdin.readLine());
      System.out.println(position);
      int size = list_plus.size();
      if(position <= size)
      {
        list_plus.add(position, item);
        System.out.println("Item " + item + " inserted in position " + position);
      }
    }

    public static void remove(ListArrayBasedPlus list_plus) throws IOException
    {
      System.out.print("Enter position to remove item from: ");
      int position = Integer.parseInt(stdin.readLine().trim());
      System.out.println(position);
      int size = list_plus.size();
      if(position >= size)
      {
        System.out.println("Position specified is out of range!");
      }

      else
      {
        System.out.println("Item " + list_plus.get(position) + " removed from position " + position + " in the list.");
        list_plus.remove(position);
      }
    }

    public static void retrieve(ListArrayBasedPlus list_plus) throws IOException
    {
      System.out.print("Enter position to retrieve item from: ");
      int position = Integer.parseInt(stdin.readLine().trim());
      System.out.println(position);
      int size = list_plus.size();
      if(position < 0 || position >= size)
      {
        System.out.println("Position specified is out of range!");
      }

      else
      {
        System.out.println("Item " + list_plus.get(position) + " retrieved from position " + position + " in the list.");
      }
    }

    public static void search2(ListArrayBasedPlus list_plus) throws IOException
    {
      String key2 = stdin.readLine().trim();
      System.out.println(key2);                
      System.out.println("Searching for item...");
      int position = search(key2, list_plus);
      if (position <= -1)
      {
        System.out.println(" -1 no item with that name exists, try again.");
      }

      else
      {
        System.out.println(key2 + " found at position " + position);
      }
    }
    /**
     *  CHANGES MADE TO SEARCH METHOD
     * Searches for an item in the list using compareTo
     * @param key     the item to search for
     * @param list    the list to search in
     * @return        the index of the item if found
     * 
     * if (curr == key)
     *    stop(succ, pos)
     * else
     *    advance
     * stop(unsucc)
     */
    public static int search(String key, ListArrayBasedPlus list)
    {
      int position = -1;
      for(int index = 0; index < list.size(); index++)
      {
        if(key.equals(list.get(index)))
        {
          position = index;
        }
      }
      return position;
    }
}
