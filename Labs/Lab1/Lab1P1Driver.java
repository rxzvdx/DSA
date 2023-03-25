/*

 * Purpose: Data Structure and Algorithms Lab 1 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 1/21/23
 * Submitted:  1/22/23
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: Antonio Rosado
 * @version: 2023.01.21

 */

import java.io.*;

class Lab1P1Driver
{
    static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in)); // input for user
    public static void main(String args[]) throws IOException
    {
        // Problem 1
        // parse int then
        // for loop for output stream
        // build string while reading in

        System.out.print("\nEnter number of people: ");
        int n = Integer.parseInt(stdin.readLine()); // parse num given by user
        System.out.println(n);
        String[] names = new String[n]; // array of String[] based on number

        for (int index = 0; index < n; index++)
        {
            System.out.print("Enter name number " + (index + 1) + ": "); // index + 1 because index starts at 0
            names[index] = stdin.readLine(); // name at desired index is input
            System.out.println(names[index]);
        }
        // formatting for different possible outcomes
        if(names.length == 1)
        {
            System.out.print(names[0] + " shouts Hello Class!!");
        }

        else if(names.length == 2)
        {
            System.out.print(names[0] + " and " + names[1] + " shouts Hello Class!!");
        }

        else {
            for(int l = 0; l < (names.length - 2); l++)
            {
                System.out.print(names[l] + ", ");
            }
            System.out.print(names[n-2] + "," + " and " + names[n-1] + " shouts " + "Hello Class!!");
        }
    }
}
