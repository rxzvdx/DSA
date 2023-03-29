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
public class Lab8P2Driver extends ListArrayBasedPlus
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
                  System.out.println("You are now inserting an item into the list.");
                  System.out.print("Enter item: ");
                  String key = stdin.readLine();
                  System.out.print(key);
                  // Modified Sequential Search III
                  int position = search(key, list_plus);
                  if(position < 0)
                  {
                    position = (position + 1)* -1;
                  }

                  else if(position > list_plus.length())
                  {
                    System.out.println("Position is out of bounds!");
                  }

                  else
                  {
                    list_plus.add(position, key);
                    System.out.println("Item " + key + " inserted in position " + position);
                  }
                  break;

              case 2:
                  System.out.println("You are now removing an item from the list.");    
                  System.out.print("Enter position to remove item from: ");
                  int pos2 = Integer.parseInt(stdin.readLine());
                  System.out.println(pos2);
                    if(pos2 > list_plus.size() - 1)
                    {
                      System.out.println("Position specified is out of range!");
                    }
              
                    else
                    {
                      System.out.println("Item " + list_plus.get(pos2) + " removed from position " + pos2 + " in the list.");
                      list_plus.remove(pos2);
                    }
                  break;

              case 3:
                  System.out.print("Enter position to retrieve item from: ");
                  int pos3 = Integer.parseInt(stdin.readLine());
                  System.out.println(pos3);
                  if(pos3 < 0 || pos3 >= list_plus.size())
                  {
                    System.out.println("Position specified is out of range!");
                  }

                  else
                  {
                    System.out.println("Item " + list_plus.get(pos3) + " retrieved from position " + pos3 + " in the list.");
                  }
                  break;

              case 4:
                System.out.print("You are now searching for an item. \n Enter the item to search for: ");
                String key2 = stdin.readLine();
                System.out.println(key2);                
                System.out.println("Searching for item...");
                int position2 = search(key2, list_plus);
                if (position2 <= -1)
                {
                  System.out.println(position2 + " no item with that name exists, try again.");
                }

                else
                {
                  System.out.println(key2 + " found at position" + position2);
                }
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
     * CHANGES MADE TO SEARCH METHOD
     * Searches for an item in the list using compareTo
     * @param key     the item to search for
     * @param list    the list to search in
     * @return        the index of the item if found
     * 
     *  EAGERLY ADVANCING
     * if (curr == key)
     *    stop(succ, pos)
     * else
     *    advance
     * stop(unsucc)
     */
    public static int search(String key, ListArrayBasedPlus list)
    {
      int position = 0;
      if(list.size() == 0)
      {
        return 0;
      }

      while(key.compareTo((String) list.get(position)) > 0)
      {
        position++;
      }

      if(key.equals(list.get(position)))
      {
        return position; 
      }

      else
      {
        return (position + 1) * (-1);
      }
    }
}
