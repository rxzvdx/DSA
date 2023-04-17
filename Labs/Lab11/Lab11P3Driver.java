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
package Lab11;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Lab11P3Driver
{
    private static MyBinarySearchTreePlus<Item, String> tree = new MyBinarySearchTreePlus<Item, String>();
    private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws IOException
    {
        boolean exit = false;
        while (!exit)
        {
            System.out.println("Select from the following menu: \n"
                               + "0. Exit the program \n"
                               + "1. Search for item in BST \n"
                               + "2. Insert item in BST \n"
                               + "3. Delete item from BST \n"
                               + "4. Display content of BST in-order \n"
                               + "5. Display content of BST in post-order \n"
                               + "6. Display content of BST in pre-order \n"
                               + "7. Check if BST has required characteristic \n");

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
                    searchItem();
                    break;

                case 2:
                    insertItem();
                    break;

                case 3:
                    deleteItem();
                    break;

                case 4:
                    System.out.println("\nContent of the BST in-order:\n" + tree.toStringInorder());
                    break;

                case 5:
                    System.out.println("\nContent of the BST post-order:\n" + tree.toStringPostorder());
                    break;

                case 6:
                    System.out.println("\nContent of the BST pre-order:\n" + tree.toStringPreorder());
                    break;

                case 7:
                    characteristic();
                    break;

                default:
                    System.out.println("\nInvalid option, please try again.\n");
                    break;
            }
        }
    }
    private static void searchItem() 
    {
        System.out.print("\nEnter the key of the item to search for: ");
        String key = stdin.readLine();
        Item item = tree.retrieve(new Item(key, false, null));
        if (item == null) 
        {
            System.out.println("\nItem with key '" + key + "' not found in BST.");
        } 
        else 
        {
            System.out.println("\nItem with key '" + key + "' found in BST:\n" + item.toString());
        }
    }
    
    private static void insertItem() 
    {
        System.out.print("\nEnter the key of the item to insert: ");
        String key = stdin.readLine();
        Item existingItem = tree.retrieve(new Item(key, false, null));
        if (existingItem != null) 
        {
            System.out.println("\nItem with key '" + key + "' already exists in BST and cannot be inserted again.");
        } 
        else 
        {
            System.out.print("Enter the value of the item to insert: ");
            String value = stdin.readLine();
            tree.insert(new Item(key, false, value));
            System.out.println("\nItem with key '" + key + "' and value '" + value + "' has been inserted into the BST.");
        }
    }

    private static void deleteItem()
    {
        System.out.print("\nEnter the key of the item to delete: ");
        String key = stdin.readLine();
        System.out.println("Item " + "'" + key + "'" + " deleted.");
        tree.delete(key);
    }

    private static void characteristic()
    {
        System.out.println("\nChecking if BST has required characteristic...");
        boolean hasCharacteristic = tree.hasCharacteristic();
        if (hasCharacteristic) 
        {
            System.out.println("\nThe BST has the required characteristic.");
        } 
        else 
        {
            System.out.println("\nThe BST does NOT have the required characteristic!");
        }
    }
}

