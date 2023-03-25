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
public class Lab8P3Driver extends ListArrayBasedPlus
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
                  System.out.println("You are now inserting an item into the list.");
                  System.out.print("Enter item: ");
                  String key = stdin.readLine();
                  System.out.println(key);
                  
                  // Search for the correct position to insert the item
                  // Using Modified Sequential Search III
                  int low = 0;
                  int high = list_plus.size() - 1;
                  int midIndex = 0;
                  boolean found = false;
                  while(low <= high && !found)
                  {
                    midIndex = (low + high) / 2; 
                    if(key.compareTo((String) list_plus.get(midIndex)) == 0)
                    {
                      System.out.println("Item " + key + " already exists in the list, try again.");
                      found = true;
                    }

                    else if(key.compareTo((String) list_plus.get(midIndex)) < 0)
                    {
                      high = midIndex - 1;
                    }

                    else
                    {
                      low = midIndex + 1;
                    }
                  }

                  // Insert item into the correct position
                  if(!found)
                  {
                    list_plus.add(midIndex, key);
                    System.out.println("Item " + key + " inserted in position " + midIndex + " in the list.");
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
                      list_plus.remove(pos);
                      System.out.println("Item " + list_plus.items[pos] + " removed from position " + pos + " in the list.");
                    }
                  break;

              case 3:
                  System.out.print("Enter position to retrieve item from: ");
                  pos = Integer.parseInt(stdin.readLine());
                  System.out.println(pos);
                  if(pos < 0 || pos >= list_plus.size())
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
                String key2 = stdin.readLine();
                int searchPos = search(key2, list_plus);
                if(searchPos != 202)
                {
                  System.out.println("Item " + "'" + key2 + "'" + " found in position " + searchPos + " in the list.");
                }

                else 
                {
                  System.out.println("Item " + "'" + key2 + "'" + " not found in the list.");
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
      int position = 202;
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
