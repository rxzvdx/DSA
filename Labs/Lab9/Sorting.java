/*
 * Purpose: Data Structure and Algorithms Lab 9
 * Status: Complete and thoroughly tested
 * Last update: 04/06/23
 * Submitted:  04/06/23
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: Antonio Rosado
 * @version: 2023.04.06
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Sorting
{
    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws IOException
    {
        boolean exit = false;
        int[] array;
        while (!exit)
        {
            System.out.println("Select from the following menu: \n"
                               + "0. Exit the program \n"
                               + "1. Bubblesort an array \n"
                               + "2. Improved Bubblesort an array \n"
                               + "3. Selection sort an array \n"
                               + "4. Improved selection sort an array \n"
                               + "5. Insertion sort an array \n"
                               + "6. Improved Insertion Sort an array");

            System.out.print("Make your menu selection now: " );
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
                Bubblesort(insert());
                break;

            case 2:
                ImprovedBubblesort(insert());
                break;

            case 3:
                SelectionSort(insert());
                break;

            case 4:
                ImprovedSelectionSort(insert());
                break;

            case 5:
                InsertionSort(insert());
                break;
            
            case 6:
                ImprovedInsertionSort(insert());

            default:
                System.out.println("Invalid choice.");
                break;
            }
        }
    }

    /**
     * Insert items into the array to be sorted
     * @return array            Array of values
     * @throws IOException
     */
    private static int[] insert() throws IOException
    {
        System.out.println("How many items would you like to insert in the array? ");
        int amount = Integer.parseInt(stdin.readLine().trim());
        int[] array = new int[amount]; // array size = amount given
        for(int index = 0; index < amount; index++)
        {
            // populate array
            System.out.println("Enter integer " + index + " : ");
            array[index] = Integer.parseInt(stdin.readLine().trim());
            System.out.println(array[index]);
        }
        return array;
    }

    /**
     * Implements the bubble sort algorithm to sort an integer array in ascending order.
     * 
     * @param array     Array of values
     * @return array
     */
    private static void Bubblesort(int[] array) 
    {
        int comps = 0; // # of comparisons 
        int swaps = 0; // # of swaps
        int length = array.length;
        for(int index = 0; index < length; index++)
        {
            for(int j = 1; j < length - index; j++)
            {
                for (int k = 1; k < length - index; k++)
                {
                    comps++; 
                    // If the current element is greater than the next element...
                    // swap them and increment the swap counter.
                    if(array[j - 1] > array[j])
                    {
                        int temp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = temp;
                        swaps++;
                    }
                }
            }
        }
        toString(array, comps, swaps);
    }
    
    /**
     * Implements an improved bubble sort algorithm to sort an integer array in ascending order.
     * 
     * @param array     Array of values
     * @return array
     */
    private static void ImprovedBubblesort(int[] array) 
    {
        int comps = 0; // # of comparisons 
        int swaps = 0; // # of swaps
        int temp = 0; 
        int length = array.length;
        boolean swapped;
        for(int index = 0; index < length - 1; index++)
        {
            swapped = false;
           for(int j = 0; j < length - 1 - index; j++)
           {
                comps++;
                if(array[j] > array[j + 1])
                {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
           }
           
           if(!swapped)
           {
               break;
           }
        }
        toString(array, comps, swaps);
    }

    /**
     * Implements the selection sort algorithm to sort an integer array in ascending order.
     * 
     * @param array     Array of values
     * @return array
     */
    private static void SelectionSort(int[] array) 
    {
        int comps = 0; // # of comparisons 
        int swaps = 0; // # of swaps
        int length = array.length;
        for(int index = 0; index < length - 1; index++)
        {
            int midIndex = index;
            for(int j = index + 1; j < length; j++)
            {   comps++;
                if(array[j] < array[midIndex])
                {
                    midIndex = j;
                }
            }
            
            if(midIndex != index)
            {
                int temp = array[index];
                array[index] = array[midIndex];
                array[midIndex] = temp;
                swaps++;
            }
        }
        toString(array, comps, swaps);
    }

    /**
     * Implements an improved selection sort algorithm to sort an integer array in ascending order.
     * 
     * @param array     Array of values
     * @return array
     */
    private static void ImprovedSelectionSort(int[] array)
    {
        int comps = 0;
        int swaps = 0;
        int length = array.length;
        for (int index = 0; index < length / 2; index++) 
        {
            int minIndex = index, maxIndex = index;
            for (int j = index + 1; j < length - index; j++) 
            {
                // compare both elements
                comps += 2; 
                if (array[j] < array[minIndex]) 
                {
                    minIndex = j;
                }

                if (array[j] > array[maxIndex]) 
                {
                    maxIndex = j;
                }
            }

            if (minIndex != index) 
            {
                int temp = array[index];
                array[index] = array[minIndex];
                array[minIndex] = temp;
                swaps++;
            }
            
            /*
            * If max val is in the first unsorted position...
            * it's already swapped with the min val, so update the maxindex
            * to the index of the second highest value
            */
            if (maxIndex == index) 
            {
                maxIndex = minIndex;
            }

            if (maxIndex != length - index - 1) 
            {
                int temp = array[length - index - 1];
                array[length - index - 1] = array[maxIndex];
                array[maxIndex] = temp;
                swaps++;
            }
        }
        toString(array, comps, swaps);
    }

/**
 * Implements an insertion selection sort algorithm to sort an integer array in ascending order.
 * 
 * @param array     Array of values
 */
private static void InsertionSort(int[] array)
    {
        int comps = 0;
        int swaps = 0;
        int length = array.length;
        for(int index = 1; index < length; index ++)
        {
            int key = array[index]; // bgein @ 1
            int pos = (index - 1); // begin @ 0
            for( ; pos >= 0 && array[pos] > key; pos--)
            {
                comps++;
                swaps++;
                array[pos + 1] = array[pos];
            }
            array[pos + 1] = key;
            swaps++;
        }
        toString(array, comps, swaps);
    }

    /**
     * EXTRA CREDIT W/ BINARY SEARCH
     * Implements an improved insertion sort algorithm to sort an integer array in ascending order.
     * 
     * @param array     Array of values
     */
    private static void ImprovedInsertionSort(int[] array) 
    { 
        int comps = 0;
        int swaps = 0;
        int length = array.length;
        for (int index = 1; index < length; index++) 
        {
            int key = array[index]; // begins at 1
            int pos = binarySearch(index, key, array);
            for(int j = (index- 1); j >= pos; j--) 
            {
                swaps++;
                array[j + 1] = array[j];
            }
            array[pos] = key;
            swaps++; // swaps++
        }
        toString(array, comps, swaps);
    }

     /**
     * Binary Search II
     * Searches for an item in the array
     * 
     * @param key     the item to search for
     * @return        the index of the item if found OR -1 for duplicates/nonexisting items
     */
    private static int binarySearch(int index, int key, int[] array) 
    {
        {
            int low = 0;
            int length = array.length;
            int high = length - 1;
            while (low <= high)
            {
                int midIndex = (low + high) / 2;
                if (key == midIndex)
                {
                    // key found
                    return midIndex;
                }
    
                else if (key < midIndex)
                {
                    // key smaller, search left half
                    high = midIndex - 1;
                }
    
                else
                {
                    // key larger, search right half
                    low = midIndex + 1;
                }
            }
            // return index where key should be inserted
            return -(low + 1);
        }
    }

    /**
     * Returns string representation of array
     * 
     * @param array     Array of values
     */
    private static void toString(int[] array, int comps, int swaps)
    {
        int length = array.length;
        System.out.println("Sorted data: ");
        for(int index = 0; index < length; index++)
        {
            System.out.print(array[index] + " ");
        }
        System.out.println();
        System.out.println("\n Comparisons: " + comps + "\n Swaps: " + swaps + "\n");
    }
}
