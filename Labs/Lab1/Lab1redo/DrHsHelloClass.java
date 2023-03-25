/*
 * Purpose: Data Structure and Algorithms Lab 1 Problem 0
 * Status:  Complete and thoroughly tested 
 * Last update: 01/18/23
 * Submitted:  01/19/23
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: Dr. Gabriela Hristescu
 * @version: 2023.01.18
 */

import java.io.*;

public class DrHsHelloClass
{
    static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException
    {
        System.out.print("Enter name:");
        String name = stdin.readLine();
        System.out.println(name);
        System.out.print(name + " shouts " );
        System.out.println("Hello Class!!!");
    }
}
