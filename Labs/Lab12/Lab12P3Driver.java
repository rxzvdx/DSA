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
package Lab12;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Lab12P3Driver
{
    private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws IOException
    {
        HashTable table = new HashTable();;
        boolean exit = false;
        while (!exit)
        {
            System.out.println("Select from the following menu: \n"
                               + "0. Exit the program \n"
                               + "1. Insert a [key, associated value] pair in the table. \n"
                               + "2. Delete a pair from the table. \n"
                               + "3. Retrieve and display the value associated with a key in the table. \n"
                               + "4. Display the hashCode of a key. \n"
                               + "5. Display the content of the table. \n");

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
                    insert(table);
                    break;

                case 2:
                    delete(table);
                    break;

                case 3:
                    search(table);
                    break;

                case 4:
                    hashCode(table);                   
                    break;

                case 5:
                    System.out.println(table.toString());
                    break;

                default:
                    System.out.println("Invalid option, please try again.\n");
                    break;
            }
        }
    }

    private static void search(HashTable table) throws IOException
    {
        System.out.print("Enter the key of the item to search for: ");
        String key = stdin.readLine();
        System.out.println(key);
        Object item = table.tableRetrieve(key);
        if (item == null) 
        {
            System.out.println("Item with key '" + key + "' not found in HashTable.");
        } 
        else 
        {
            System.out.println("Item with key '" + key + "' found in HashTable:\n" + item.toString());
        }
    }

    private static void insert(HashTable table) throws IOException
    {
        System.out.print("Enter the key of the item to insert: ");
        String key = stdin.readLine();
        System.out.println(key);

        System.out.print("Enter the value: ");
        String assocstring = stdin.readLine();
        System.out.println(assocstring);

        Object existingItem = table.tableRetrieve(key);
        if (existingItem != null) 
        {
            System.out.println("Item with key '" + key + "' already exists in HashTable and cannot be inserted again.");
        } 
        else 
        {
            table.tableInsert(key, assocstring);
            System.out.println("Item " + assocstring + " inserted into HashTable with key " + key);
        }
    }

    private static void delete(HashTable table)throws IOException 
    {
        System.out.print("Enter the key of the item to delete: ");
        String key = stdin.readLine();
        System.out.println(key);

        Object existingItem = table.tableRetrieve(key);
        if(existingItem != null)
        {
            System.out.println("Item " + "'" + key + "'" + " deleted.");
            table.tableDelete(key);
        }
        else
        {
            System.out.println("Item does not exist, cannot delete a non-existent item!");
        }
    }

    private static void hashCode(HashTable table) throws IOException
    {
        System.out.print("Enter the key you would like the hashCode for: ");
        String key = stdin.readLine();
        System.out.println(key);
        System.out.println("Hashcode : " + table.hashCode(key));
    }
}


