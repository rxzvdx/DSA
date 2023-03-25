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

public class Lab6P1Driver
{

    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    @SuppressWarnings("unchecked")
    public static void main (String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        ExtendedQueueInterface<Object> queue;
        queue = (ExtendedQueueInterface<Object>) Class.forName(args[0]).newInstance();
        boolean exit = false;
        String item = "";
        Object removed;
        Object front;
        Object last;
        while (!exit)
        {
            System.out.println("Select from the following menu: \n"
                               + "\t 0. Exit Program. \n"
                               + "\t 1. Insert item at back. \n"
                               + "\t 2. Insert item at front. \n"
                               + "\t 3. Remove item from front. \n"
                               + "\t 4. Remove item from back. \n"
                               + "\t 5. Display front item. \n"
                               + "\t 6. Display last item. \n"
                               + "\t 7. Clear collection. \n"
                               + "\t 8. Display number of items and content of collection. \n");

            System.out.print("Make your menu selection now: ");
            int input = Integer.parseInt(stdin.readLine().trim());
            System.out.println(input);
            // possible cases for initial input
            switch (input)
            {
            case 0:
                System.out.println("Exiting program... good bye");
                exit = true;
                break;

            case 1:
            try
            {
                System.out.println("You are now inserting an item at the back.");
                System.out.print("Enter Item: ");
                item = stdin.readLine().trim();
                System.out.println(item);
                queue.enqueue(item);
                System.out.println("Item enqueued at back.\n");
            }

            catch(ExtendedQueueException e)
            {
                System.out.println(e.getMessage());
            }
            break;

            case 2:
            try
            {
                System.out.println("You are now inserting an item at the front.");
                System.out.print("Enter Item: ");
                item = stdin.readLine().trim();
                System.out.println(item);
                queue.enqueueFront(item);
                System.out.println("Item " + item + " enqueued at front.\n");
            }

            catch(ExtendedQueueException e)
            {
                System.out.println(e.getMessage());
            }
            break;

            case 3:
            try
            {
                removed = queue.dequeue();
                System.out.println("You are now removing an item from the front.\n");
                System.out.println("Item " + item + " dequeued.\n");
            }

            catch(ExtendedQueueException e)
            {
                System.out.println(e.getMessage());
            }
            break;

            case 4:
            try
            {
                removed = queue.dequeueBack();
                System.out.println("You are now removing an item from the back.\n");
                System.out.println("Item " + removed + " dequeued.\n");
            }
            catch(ExtendedQueueException e)
            {
                System.out.println(e.getMessage());
            }
            break;

            case 5:
            try
            {
                front = queue.peek();
                System.out.println("The front item of the queue is "  + front + "\n");
            }
            catch(ExtendedQueueException e)
            {
                System.out.println(e.getMessage());
            }
            break;

            case 6:
            try
            {
                last = queue.peekBack();
                System.out.println("The last item of the queue is "  + last + "\n");
            }

            catch(ExtendedQueueException e)
            {
                System.out.println(e.getMessage());
            }
            break;

            case 7:
            if(queue.isEmpty())
            {
                System.out.println("The list already is empty.\n");
            }

            else
            {
                queue.dequeueAll();
                System.out.println("Queue completely cleared.\n");
            }
            break;

            case 8:
            System.out.println("Number of items: " + queue.toString().split(",").length);
            System.out.println("Content of the FIFO collection: " + queue.toString());
            break;

            default:
            System.out.println("Invalid input, try again");
            break;
            }
        }
    }
}
