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
    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
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
                    
                    break;

                case 2:
                    
                    break;

                case 3:
                    
                    break;

                case 4:
                    
                    break;

                case 5:
                    
                    break;

                case 6:
                    
                    break;

                case 7:
                
                    break;
            }
        }
    }
}

