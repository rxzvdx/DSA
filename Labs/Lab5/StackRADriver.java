/**
 * Purpose: Data Structure and Algorithms Lab 5
 * Status: Complete and thoroughly tested
 * Last update: 02/20/23
 * Submitted: 02/20/23
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: Antonio Rosado
 * @version: 2023.02.20
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StackRADriver
{

    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws IOException
    {
        StackRA<Object> stackRA = new StackRA<Object>();
        boolean exit = false;
        while (!exit) {
            System.out.println("Select from the following menu: \n"
                               + "\t 0. Exit. \n"
                               + "\t 1. Push item onto the stack. \n"
                               + "\t 2. Pop item from the stack. \n"
                               + "\t 3. Display the top item of the stack. \n"
                               + "\t 4. Display items in the stack. \n"
                               + "\t 5. Clear the stack. \n");

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
                System.out.println("You are now pushing an item onto the stack.");
                System.out.print("\t Enter item: ");
                Object item = stdin.readLine().trim();
                System.out.println(item);
                stackRA.push(item);
                System.out.println("Item " + item + " was successfully pushed onto the stack. \n");
                break;

            case 2:
                if(!(stackRA.isEmpty()))
                {
                    System.out.println("You are now popping an item from the stack...");
                    System.out.print("Item " + stackRA.peek() + " was successfully popped off the stack. \n");
                    stackRA.pop();
                }

                else
                {
                    System.out.println("Stack is empty! \n");
                }

                break;

            case 3:
                if(!(stackRA.isEmpty()))
                {
                    System.out.println("The stack contains: " + stackRA.toString());
                    System.out.print("Item " + stackRA.peek() + " is on the top of the stack. \n");
                }

                else
                {
                    System.out.println("Stack is empty! \n");
                }
                break;

            case 4:
                if(!(stackRA.isEmpty()))
                {
                    System.out.println("The stack contains: " + stackRA.toString());
                }

                else
                {
                    System.out.println("Stack is empty! \n");
                }
                break;

            case 5:
                if(!(stackRA.isEmpty()))
                {
                    System.out.println("Emptying stack... ");
                    System.out.println("Items " + stackRA.toString() + " have been removed from the stack. \n");
                    stackRA.popAll();
                }

                else
                {
                    System.out.println("Stack is already empty! \n");
                }
                break;
            }
        }
    }
}
