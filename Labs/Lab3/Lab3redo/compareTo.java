import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * String class' compareTo method returns:
 * The value 0 if the argument string is equal to this string;
 * a value less than 0 if this string is lexicographically less
 * than the string argument; and a value greater than 0 if this
 * string is lexicographically greater than the string argument.
**/

public class compareTo
{
    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException
    {
        System.out.println("Some examples of compared strings are: ");
        String s1 = "a";
        String s2 = "A";
        String s3 = "t";
        String s4 = "T";
        String s5 = "z";
        String s6 = "l";
        String s7 = "1";
        String s8 = "9";
        String s9 = "18";
        String s10 = "21";
        String s11 = "81";
        String s12 = "to";
        String s13 = "top";
        String s14 = "%";
        String s15 = "0";

        /**
         * compareTo() compares strings lexicographically, with the returned value representing
         * each ASCII value's distance from each other.
         * A returned value is either positive or negative depending on whether the first string's
         * ASCII value comes before or after the second string's value.
         * 'a' has an ASCII value of 97, whereas 'A' has a value of 65. 97 - 65 = 32, hence the returned value of 32.
         * 'a' has an ASCII value of 97, whereas 'z' has a value of 122, 97 - 122 = -25, hence the returned value of -25.
         * 'a' compared to 'a' will return 0 because they have the same values and are not distance from one another. 
         **/
        System.out.println("'a' compared to 'A' is : " + s1.compareTo(s2));
        System.out.println("'t' compared to 'T' is : " + s3.compareTo(s4));
        System.out.println("'a' compared to 'z' is : " + s1.compareTo(s5));
        System.out.println("'a' compared to 'l' is : " + s1.compareTo(s6));
        System.out.println("'l' compared to 'A' is : " + s6.compareTo(s2));
        System.out.println("'1' compared to '9' is : " + s7.compareTo(s8));
        System.out.println("'1' compared to '18' is : " + s7.compareTo(s9));
        System.out.println("'21' compared to '81' is : " + s10.compareTo(s11));
        System.out.println("'to' compared to 'top' is : " + s12.compareTo(s13));
        System.out.println("'%' compared to '0' is : " + s14.compareTo(s15));

        //'a' compared to 'A' is : 32      'a'  is greater than 'A'.
        //'t' compared to 'T' is : 32      't'  is greater than 'T'.
        //'a' compared to 'z' is : -25     'a'  is smaller than 'z'.
        //'a' compared to 'l' is : -11     'a'  is smaller than 'l'.
        //'l' compared to 'A' is : 43      'A'  is greater than 'l'.
        //'1' compared to '9' is : -8      '9'  is smaller than '1'.
        //'1' compared to '18' is : -1     '18' is smaller than '1'.
        //'21' compared to '81' is : -6    '81' is smaller than '21'.
        //'to' compared to 'top' is : -1   'to' is smaller than 'top'.
        //'%' compared to '0' is : -11     '%'  is smaller than '-11'.

        boolean exit = false;
        String input = "";
        while (!exit)
        {
            System.out.println("Select from the following menu: \n"
                               + "\t 0. Exit the program \n"
                               + "\t 1. Compare two strings");

            input = stdin.readLine();
            System.out.println(input);
            switch (input) {
            case "0":
                System.out.println("Exiting program... good bye");
                exit = true;
                break;

            case "1":
                System.out.println("You are now comparing two strings...");
                System.out.print("\t Enter string 1: ");
                String string1 = stdin.readLine();
                System.out.println(string1);

                System.out.print("\t Enter string 2: ");
                String string2 = stdin.readLine();
                System.out.println(string2);

                System.out.println("'" + string1 + "'" + " compared to " + "'" + string2 + "' " + "is: "  + string1.compareTo(string2));
                break;
            }

        }
    }

}