/**
 * Purpose: Data Structure and Algorithms Lab 6
 * Status: Complete and thoroughly tested
 * Last update: 02/27/23
 * Submitted: 02/27/23
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: Antonio Rosado
 * @version: 2023.02.27
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Lab6P0Driver
{
    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        QueueInterface<Object> queue;
        queue = (QueueInterface <Object>) Class.forName(args[0]).newInstance();

        int input = -1;
        while (input != 0)
        {
            System.out.println("Choose an option:");
            System.out.println("0. Exit Program");
            System.out.println("1. Insert item at back of FIFO collection");
            System.out.println("2. Remove item from front of FIFO collection");
            System.out.println("3. Display front item of FIFO collection");
            System.out.println("4. Clear FIFO collection");
            System.out.println("5. Display number of items and content of FIFO collection");

            System.out.println("Choose your selection from the menu now: ");
            input = Integer.parseInt(stdin.readLine().trim());
            System.out.println(input);

            switch (input)
            {
            case 0:
                System.out.println("Exiting program... goodbye");
                break;
            case 1:
                try
                {
                  System.out.println("Enter item to insert: ");
                  Object item = stdin.readLine();
                  System.out.println(item + "\n");
                  System.out.println(item + " has been added to the queue. \n");
                  queue.enqueue(item);
                }
                catch(QueueException e) 
                {
                  System.out.println(e.getMessage());
                }
                break;
            case 2:
                try
                {
                    Object removed = queue.dequeue();
                    System.out.println("Removed item: " + removed);
                }

                catch(QueueException e)
                {
                    System.out.println(e.getMessage());
                }
                break;

            case 3:
                try
                {
                    Object front = queue.peek();
                    System.out.println("Front item: " + front);
                }
                
                catch(QueueException e)
                {
                    System.out.println(e.getMessage());
                }
                break;

            case 4:
                queue.dequeueAll();
                System.out.println("Content of the FIFO collection has been cleared!");
                break;
            case 5:
                System.out.println("Number of items: " + queue.toString().split(",").length);
                System.out.println("Content of the FIFO collection: " + queue.toString());
                break;
            }
        }
    }
}
