import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Lab4P1Driver
{
    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws IOException
    {
        ListCDLSBased myList = new ListCDLSBased();
        boolean exit = false;
        int pos = -1;
        while (!exit) {
            System.out.println("Select from the following menu: \n"
                               + "\t 0. Exit the program \n"
                               + "\t 1. Insert item into the list \n"
                               + "\t 2. Remove item from the list \n"
                               + "\t 3. Get item from the list \n"
                               + "\t 4. Clear the list \n"
                               + "\t 5. Display size and content of the list in order and in reversed order \n"
                               + "\t 6. Delete the smallest and largest item in the list \n"
                               + "\t 7. Reverse the list \n");

            System.out.print("Make your menu selection now: ");
            int input = Integer.parseInt(stdin.readLine().trim());
            System.out.println(input);
            // possible cases for initial input
            switch (input) {
            case 0:
                System.out.println("Exiting program... good bye");
                exit = true;
                break;

            case 1:
                try
                {
                    System.out.println("You are now inserting an item into the list.");
                    System.out.print("\t Enter item: ");
                    String item = stdin.readLine().trim();
                    System.out.println(item);

                    System.out.print("\t Enter the position to insert item in: ");
                    pos = Integer.parseInt(stdin.readLine().trim());
                    System.out.println(pos);
                    if (pos <= myList.size())
                    {
                        myList.add(pos, item);
                        System.out.println("Item " + item + " inserted in position " + pos + " in the list.");
                    }
                }

                catch(ListIndexOutOfBoundsException e)
                {
                    System.out.println("Position specified is out of range!");
                }
                break;

            case 2:
                try
                {
                    System.out.println("You are now removing an item from the list.");
                    System.out.print("\t Enter position to remove item from: ");
                    pos = Integer.parseInt(stdin.readLine().trim());
                    System.out.println(pos);
                    System.out.println("Item " + myList.get(pos) + " removed from position " + pos + " in the list.");
                    myList.remove(pos);
                }
                catch(ListIndexOutOfBoundsException e)
                {
                    System.out.println("Position specified is out of range!");
                }
                break;

            case 3:
                try
                {
                    System.out.print("\t Enter position to retrieve item from: ");
                    pos = Integer.parseInt(stdin.readLine().trim());
                    System.out.println(pos);
                    System.out.println("Item " + myList.get(pos) + " retrieved from position " + pos + " in the list.");
                }

                catch(ListIndexOutOfBoundsException e)
                {
                    System.out.println("Position specified is out of range!");
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
                if(!(myList.size() == 0))
                {
                    System.out.println("In order: List of size " + myList.size() + " has the following items: " + myList.toString());
                    System.out.println("In reverse order: List of size " + myList.size() + " has the following items: " + myList.toStringR());
                }

                else
                {
                    System.out.println("List is empty.");
                }
                break;

            case 6:
                displayAndDeleteLargeAndSmall(myList);
                break;

            case 7:
                if(!(myList.isEmpty()))
                {
                    System.out.println("List has been reversed.");
                    myList = reverse(myList);
                    System.out.println("\t Here is the content: " + myList.toString());
                }

                else
                {
                    System.out.println("List is empty... nothing to reverse!");
                }
                break;
            }
        }
    }

    /**
     * Find largest and smallest items from DNode collection lexicographically
     * @param ListCDLSBased myList              list to be iterated
     * @param int[] numbers                 Array of largest and smallest values
     */
    static void findIndexLargeAndSmall(ListCDLSBased myList, int[] numbers)
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
    * Display and delete largest and smallest items from DNode collection lexicographically
    * @param ListCDLSBased myList        list to be iterated
    */
    static ListCDLSBased displayAndDeleteLargeAndSmall(ListCDLSBased myList) throws ListIndexOutOfBoundsException
    {
        ListCDLSBased temp = new ListCDLSBased();
        if(myList.size() == 0)
        {
            System.out.println("List is empty, nothing to delete!");
        }
        else if(myList.size() == 1)
        {
            System.out.println(myList.toString() + " is deleted.");
            myList.remove(0);
        }

        else
        {
            int numbers[] = new int[2];
            findIndexLargeAndSmall(myList, numbers);
            System.out.println("Smallest item " + myList.get(numbers[0]) + " deleted.");
            System.out.println("Largest item " + myList.get(numbers[1]) + " deleted.");
            if(numbers[0] > numbers[1])
            {
                myList.remove(numbers[0]);
                myList.remove(numbers[1]);
            }

            else
            {
                myList.remove(numbers[0]);
                myList.remove(numbers[1] - 1);
            }
        }
        myList = temp;
        return temp;
    }

    /**
    * Reverse collection and return it reversed
    * @param ListCDLSBased myList        list to be iterated
    * @return temp                       reversed list
    */
    static ListCDLSBased reverse(ListCDLSBased myList)
    {
        ListCDLSBased temp = new ListCDLSBased();
        int size = myList.size();
        for (int index = 0; index < size; index++)
        {
            temp.add(index, myList.get(size - 1 - index));
        }
        myList = temp;
        return myList;
    }
}




