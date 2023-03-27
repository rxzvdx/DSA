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
public class Lab8P1Driver extends ListArrayBasedPlus
{
    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws IOException 
    {
      ListArrayBasedPlus list_plus = new ListArrayBasedPlus();
      boolean exit = false;
      int pos = -1;
        
	  while (!exit) 
    {
            System.out.println("Select from the following menu: \n"
                             + "0. Exit the program \n"
                             + "1. Insert item into the list \n"
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
                  System.out.println("You are now inserting an item into the list.");
                  System.out.print("Enter item: ");
                  Object item = stdin.readLine();
                  System.out.println(item);
                  
                  System.out.print("Enter the position to enter the item in: ");
                  pos = Integer.parseInt(stdin.readLine());
                  System.out.println(pos);
                  if (pos <= list_plus.size())
                  {
                    list_plus.add(pos, item);
                    System.out.println("Item " + item + " inserted in position " + pos + " in the list.");
                  }
                  
                  else
                  {
                    System.out.println("Position specified is out of range!");
                  }
                  break;

              case 2:
                  System.out.println("You are now removing an item from the list.");    
                  System.out.print("Enter position to remove item from: ");
                  pos = Integer.parseInt(stdin.readLine());
                  System.out.println(pos);
                    if(pos > list_plus.size() - 1)
                    {
                      System.out.println("Position specified is out of range!");
                    }
              
                    else
                    {
                      System.out.println("Item " + list_plus.items[pos] + " removed from position " + pos + " in the list.");
                      list_plus.remove(pos);
                    }
                  break;

              case 3:
                  System.out.print("Enter position to retrieve item from: ");
                  pos = Integer.parseInt(stdin.readLine());
                  System.out.println(pos);
                  if(pos > list_plus.length())
                  {
                    System.out.println("Position specified is out of range!");
                  }

                  else
                  {
                    System.out.println("Item " + list_plus.get(pos) + " retrieved from position " + pos + " in the list.");
                  }
                  break;

              case 4:
                System.out.print("You are now searching for an item. \n Enter the item to search for: ");
                String key = stdin.readLine();
                System.out.println(key);
                search(key, list_plus);
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
    /**
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
      System.out.println("Searching for item...");
      int position = -1;
      boolean found = false;
      for(int index = 0; index < list.size(); index++)
      {
        if((key.compareTo((String) list.get(index)) == 0))
        {
          position = index;
          found = true; 
          break; // end search
        }
      }
      if(found)
      {
        stop(true, position); // stop(succ, pos)
      }

      else
      {
        stop(false, -1); // stop(unsucc, pos)
      }
      return position;
    }

  /**
   * Indicates when search should stop or not
   * @param success     boolean, if key was found
   * @param position    posiition key was found (-10 if !found)
   */
  protected static void stop(boolean success, int position)
  {
    if(success)
    {
      System.out.println("Item found at position " + position);
    }

    else
    {
      System.out.println("Item not found.");
    }
  }
}
