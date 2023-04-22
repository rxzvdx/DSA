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
package Lab11.Lab11redo;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Lab11P3Driver
{
    private static MyBinarySearchTreePlus tree = new MyBinarySearchTreePlus();
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
                    inOrderDisplay();                   
                    break;

                case 5:
                    postOrderDisplay();
                    break;

                case 6:
                    preOrderDisplay();
                    break;

                case 7:
                    characteristic();
                    break;

                default:
                    System.out.println("Invalid option, please try again.\n");
                    break;
            }
        }
    }
    private static void searchItem() throws IOException
    {
        System.out.print("Enter the key of the item to search for: ");
        String key = stdin.readLine();
        System.out.println(key + "\n");
        KeyedItem item = tree.retrieve(key);
        if(!(tree.isEmpty()))
        {
            if (item == null) 
            {
                System.out.println("Item with key '" + key + "' not found in BST.");
            } 
            else 
            {
                System.out.println("Item with key '" + key + "' found in BST:\n" + item.toString());
            }
        }

        else
        {
            System.out.println("The BST is empty.");
        }
    }
    
    private static void insertItem() throws IOException
    {
        System.out.print("Enter the key of the item to insert: ");
        String key = stdin.readLine();
        System.out.println(key);

        System.out.print("Enter associated boolean: ");
        String bool = stdin.readLine();
        System.out.println(bool);
        boolean assocboolean;
        if(bool.equalsIgnoreCase("true"))
        {
            assocboolean = true;
        }
        else
        {
            assocboolean = false;
        }
        System.out.print("Enter associated string: ");
        String assocstring = stdin.readLine();
        System.out.println(assocstring);
        KeyedItem existingItem = tree.retrieve(key);
        if (existingItem != null) 
        {
            System.out.println("Item with key '" + key + "' already exists in BST and cannot be inserted again.");
        } 
        else 
        {
            tree.insert(new Item(key, assocboolean, assocstring));
            System.out.println("Item {" + key + "/" + assocboolean + "/" + assocstring + "} inserted into BST with key: " + key);
        }
    }

    private static void deleteItem() throws IOException
    {
        System.out.print("Enter the key of the item to delete: ");
        String key = stdin.readLine();
        System.out.println(key);
        KeyedItem existingItem = tree.retrieve(key);
        if(existingItem != null)
        {
            System.out.println("Item " + "'" + key + "'" + " deleted.");
            tree.delete(existingItem);
        }
        else
        {
            System.out.println("Item does not exist, cannot delete a non-existent item!");
        }
    }

    private static void characteristic()
    {
        System.out.println("Checking if BST has required characteristic...");
        if(!(tree.isEmpty()))
        {
            boolean hasCharacteristic = tree.hasCharacteristic();
            if (hasCharacteristic) 
            {
                System.out.println("The BST has the required characteristic.");
            } 
            else 
            {
                System.out.println("The BST does NOT have the required characteristic!");
            }
        }

        else
        {
            System.out.println("The BST is empty.");
        }
    }

    private static void inOrderDisplay()
    {
        if(tree.isEmpty())
        {
            System.out.println("Empty BST - nothing to display.");
        }

        else
        {
            System.out.println("Content of the BST in-order:\n" + tree.toStringInorder());

        } 
    }

    private static void postOrderDisplay()
    {
        if(tree.isEmpty())
        {
            System.out.println("Empty BST - nothing to display.");
        }

        else
        {
            System.out.println("Content of the BST post-order:\n" + tree.toStringPostorder());
        } 
    }

    private static void preOrderDisplay()
    {
        if(tree.isEmpty())
        {
            System.out.println("Empty BST - nothing to display.");
        }

        else
        {
            System.out.println("Content of the BST pre-order:\n" + tree.toStringPreorder());
        }
    }
}

