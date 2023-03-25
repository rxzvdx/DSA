import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Lab2P1Driver extends ListArrayBasedPlus {
    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws IOException {
        ListArrayBasedPlus list_plus = new ListArrayBasedPlus();
        boolean exit = false;
            System.out.print("Make your menu selection now: \n"
                             + "0. Exit the program \n"
                             + "1. Insert item into the list \n"
                             + "2. Remove item from the list \n"
                             + "3. Get item from the list \n"
                             + "4. Clear the list \n"
                             + "5. Print size and content of the list \n"
                             + "6. Reverse the list \n ");

            while (!exit) {
            System.out.print("You chose: ");
            int input = Integer.parseInt(stdin.readLine());

            // possible cases for initial input
            switch (input) {
                case 0:
                System.out.println("Exiting program... good bye");
                exit = true;
                break;

                case 1:
                System.out.println("You are now inserting an item into the list.");
                Object item = stdin.readLine();
                list_plus.add(0, item);
                break;
                
                case 2:
                System.out.println("Enter posiiton to move item from: ");
                Object item2 = stdin.readLine();
                for(int index = 0; index < list_plus.numItems; index++)
                {
                    if(list_plus.items[index] == item2)
                    {
                        list_plus.remove(index);
                        System.out.println("Item " + item2 + " removed from position " + index + " in the list.");
                    }

                    else
                    {
                        System.out.println("Item " + item2 + " not found in list.");
                    }
                }
                break;
                
                case 3:
                System.out.println("Enter position to retrieve item from: ");
                Object item3 = stdin.readLine();
                for (int index = 0; index < list_plus.numItems; index++)
                {
                    if(list_plus.items[index] == item3)
                    {
                        list_plus.get(index);
                    }
                    
                    else
                    {
                        System.out.println("Position specified is out of range!");
                    }
                }
                break;
                
                case 4:
                System.out.println("Clearing list...");
                list_plus.removeAll();
                System.out.println("List cleared.");
                break;
                
                case 5:
                System.out.println("List of size " + list_plus.size() + " has the following items: ");
                for (int index = 0; index < list_plus.numItems; index++)
                {
                    System.out.println(list_plus.get(index) + "\n");
                }
                break;
                
                case 6:
                System.out.println("Reversing list...");
                list_plus.reverse();
                System.out.println("Reversed list: ");
                for (int index = 0; index < list_plus.numItems; index++)
                {
                    System.out.println(list_plus.get(index) + "\n");
                }
                break;
            }
        }
    }
}
