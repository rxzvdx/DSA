/*
 * Purpose: Data Structure and Algorithms Lab 10 
 * Status: Complete and thoroughly tested
 * Last update: 4/10/23
 * Submitted:  4/10/23
 * Comment: Test suite and run sample attached.
 * Comment: I declare that this is entirely my own work
 * @author: Antonio Rosado
 * @version: 2023.04.10
 */
import java.util.*;

// Fully implement the 4 given method frames using the specifications with the given signatures and without without adding any additional methods
public class MergeSort
{
    private static int[][] data;  //first dimension should be 2, second dimension should be the first command line argument
    private static int comps = 0;
    
    public static void main(String[] args)
    {
        setup(args);
        System.out.println("Initially: " + getContent(0));
        iterativeMergeSort();
        System.out.println("Sorted:    " + getContent(0)); // assume sorted array is in data[0], otherwise update to 1
        System.out.println("Performed " + comps + " item comparisons.\n\n");
    } //end main

    // uses the first 3 command line arguments as follows: 
    // first argument = num (number of items to be sorted
    // second argument = low (the beginning(low end) of the range)
    // third argument = high (the upper(high) end of the range)
    // allocates the needed amount of memory for data, data[0] and data[1]
    // initializes the array data[0] with num randomly generated integers in the range [low,high]
    public static void setup( String[] args) 
    {   
        int num = Integer.parseInt(args[0]);
        int low = Integer.parseInt(args[1]);
        int high = Integer.parseInt(args[2]);
        System.out.println("For " + num + " numbers in range [" + low + "," + high + "]:");
        data = new int[2][num];
        Random rand = new Random();
        for (int index = 0; index < num; index++) 
        {
            data[0][index] = rand.nextInt(high - low + 1) + low;
        }
    } //end setup

    // iteratively merge sorts the input in array data as described in class -> by repeatedly calling method merge 
    // and using data[0] and data[1] as merge source and merge destination respectively by passing the correct integer 0 or 1 as "sindex" parameter
    public static void iterativeMergeSort() 
    { 
        int start = 0;
        int len = 1;
        int sindex = 0;
        while (len < data[0].length) 
        {
            while (start < data[0].length) 
            {
                merge(sindex, start, len);
                start += len * 2;
            }
            len *= 2;
            start = 0;
            sindex = sindex == 0 ? 1 : 0;
        }
    } //end iterativeMergeSort
    // merges the subarrays from the array index in "data" designated as source by "sindex" into the other array in "data" (destination)
    // first subarray in source array starts at index "start" and is of size "len", the second subarray starts exactly after the first subarray and is of size "len" *unless that length would exceed the length of the array*
    // merges the 2 subarrays from source array into a subarray in array destination starting at index "start"  
    public static void merge(int sindex, int start, int len) 
    {
        int[] source = data[sindex];
        int[] destination = data[sindex == 0 ? 1 : 0];

        int i = start;
        int j = start + len;
        int dest = start;

        while (i < start + len && j < (start + len * 2 > source.length ? source.length : start + len * 2)) 
        {
            comps++;
            destination[dest++] = source[i] < source[j] ? source[i++] : source[j++];
        }

        while (i < start + len) 
        {
            if (dest < destination.length) 
            {
                destination[dest++] = source[i++];
            } 

            else 
            {
                break;
            }
        }

        while (j < (start + len * 2 > source.length ? source.length : start + len * 2)) 
        {
            if (dest < destination.length) 
            {
                destination[dest++] = source[j++];
            } 

            else 
            {
                break;
            }
        }

        for (int k = start; k < start + len * 2 && k < source.length; k++) 
        {
            source[k] = destination[k];
        }
    }
    
    // parameter sindex is array index in data where information is located
    // returns a StringBuilder representation of the collection in the data[sindex] array (collects first to last)
    // you cannot use any String variables, only StringBuilder
    public static StringBuilder getContent(int sindex) 
    {
        StringBuilder sb = new StringBuilder();
        int[] arr = data[sindex];
        for (int index = 0; index < arr.length; index++) 
        {
            sb.append(arr[index]);
            if (index < arr.length - 1) 
            {
                sb.append(" ");
            }
        }
        return sb;
    }
} //end MergeSort
