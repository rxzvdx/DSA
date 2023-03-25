import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Lab3P2Driver
{
    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws IOException
    {
        MyListReferenceBased myList = new MyListReferenceBased();
        Lab3P2Driver driver = new Lab3P2Driver();
        boolean exit = false;
        int pos = -1;
        while (!exit) {
            System.out.println("Select from the following menu: \n"
                               + "\t 0. Exit the program \n"
                               + "\t 1. Insert item into the list \n"
                               + "\t 2. Remove item from the list \n"
                               + "\t 3. Get item from the list \n"
                               + "\t 4. Clear the list \n"
                               + "\t 5. Display size and content of the list \n"
                               + "\t 6. Delete the smallest and largest item in the list \n"
                               + "\t 7. Reverse the list \n");

            System.out.print("Make your menu selection now: " );
            int input = Integer.parseInt(stdin.readLine());
            System.out.println(input);
            // possible cases for initial input
            switch (input) {
            case 0:
                System.out.println("Exiting program... good bye");
                exit = true;
                break;

            case 1:
                System.out.println("You are now inserting an item into the list.");
                System.out.print("\t Enter item: ");
                Object item = stdin.readLine();
                System.out.println(item);

                System.out.print("\t Enter the position to insert item in: ");
                pos = Integer.parseInt(stdin.readLine());
                System.out.println(pos);
                if (pos <= myList.size())
                {
                    myList.add(pos, item);
                    System.out.println("Item " + item + " inserted in position " + pos + " in the list.");
                }

                else
                {
                    System.out.println("Position specified is out of range!");
                }
                break;

            case 2:
                System.out.println("You are now removing an item from the list.");

                System.out.print("\t Enter position to remove item from: ");
                pos = Integer.parseInt(stdin.readLine());
                System.out.println(pos);
                if(pos > myList.size() - 1)
                {
                    System.out.println("Position specified is out of range!");
                }

                else
                {
                    System.out.println("Item " + myList.get(pos) + " removed from position " + pos + " in the list.");
                    myList.remove(pos);
                }
                break;

            case 3:
                System.out.print("\t Enter position to retrieve item from: ");
                pos = Integer.parseInt(stdin.readLine());
                System.out.println(pos);
                if(pos > myList.size())
                {
                    System.out.println("Position specified is out of range!");
                }

                else
                {
                    System.out.println("Item " + myList.get(pos) + " retrieved from position " + pos + " in the list.");
                }
                break;

            case 4:
                if(myList.isEmpty())
                {
                    System.out.println("List is empty, nothing to clear!");
                }

                else
                {
                    System.out.println("Clearing list...");
                    myList.removeAll();
                    System.out.println("List cleared.");
                }
                break;

            case 5:
                if(myList.isEmpty())
                {
                    System.out.println("List is empty.");
                }

                else
                {
                    System.out.println("\t List of size " + myList.size() + " has the following items: " + myList.toString());
                }
                break;

            case 6:
                if(myList.isEmpty())
                {
                    System.out.println("List is empty, nothing to delete!");
                }

                else if(myList.size() == 1)
                {
                    System.out.println(myList.toString() + "is deleted.");
                }

                else
                {
                    driver.displayAndDeleteLargeAndSmall(myList);
                }
                break;

            case 7:
                driver.reverse(myList);
                break;

            }
        }
    }

    /**
     * Find largest and smallest items from Node collection lexicographically
     * @param MyListReferenceBased tempList     list to be iterated
     * @param int[] numbers                     Array of largest and smallest values
     */
    public void findIndexLargeAndSmall(MyListReferenceBased myList, int[] numbers)
    {
        int size = myList.size();
        int smallIndex = 0;
        int largeIndex = 0;
        String curr = "";
        String smallestValue = myList.get(0).toString();
        String largestValue = myList.get(0).toString();
        for (int index = 0; index < size; index++)
        {
            curr = myList.get(index).toString();
            if(curr.compareTo(smallestValue) <= 0)
            {
                smallIndex = index;
                smallestValue = myList.get(smallIndex).toString();
            }

            else if(curr.compareTo(largestValue) >= 0)
            {
                largeIndex = index;
                largestValue = myList.get(largeIndex).toString();
            }
        }
        numbers[0] = smallIndex;
        numbers[1] = largeIndex;
    }

    /**
    * Display and delete largest and smallest items from Node collection lexicographically
    * @param MyListReferenceBased myList     list to be iterated
    */
    public void displayAndDeleteLargeAndSmall(MyListReferenceBased myList)
    {

        int numbers[] = new int[2];
        findIndexLargeAndSmall(myList, numbers);
        System.out.println("Smallest item " + myList.get(numbers[0]) + " deleted.");
        System.out.println("Largest item " + myList.get(numbers[1]) + " deleted.");
        try
        {
            myList.remove(numbers[0]);
            myList.remove(numbers[1]);
        }
        catch(ListIndexOutOfBoundsException e)
        {
            System.out.println("Index out of bounds.");
        }
    }

    /**
    * Display Node objects in reverse
    * @param MyListReferenceBased myList     list to be reversed
    */
    public MyListReferenceBased reverse(MyListReferenceBased myList)
    {
        MyListReferenceBased reversed = new MyListReferenceBased();
        if(!(myList.isEmpty()))
        {
            int size = myList.size();
            for(int index = 0; index < size; index++)
            {
                reversed.add(index, myList.get(size - index - 1));
            }
            System.out.println("\t Here is the content: " + reversed.toString());
        }

        else
        {
            System.out.println("List is empty... nothing to reverse!");
        }
        return reversed;
    }
}



