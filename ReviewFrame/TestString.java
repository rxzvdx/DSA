//@author Dr. Hristescu
//IOOP material

import java.io.*;

public class TestString
{

    public static void main (String[] args)
    {
        String s1= "blah";
        String s2;
        s2= "blah";
        String s3 = "I guess... blah";
        String s4 = "I guess... " + "blah";
        String s5 = "I guess... ";
        s5 += "blah";
        String s6 = new String("blah");
        String s7 = new String("blah");
        String s8 = "Blah";

        System.out.println(s1 == s2);
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s6 == s7);
        System.out.println(s1 == s6);
        System.out.println(s1.equals(s6));
        System.out.println(s1.compareTo(s6)==0);
        System.out.println(s1 == s8);
    }
}