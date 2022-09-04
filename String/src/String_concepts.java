import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class String_concepts {
    public static void main(String[] args) {

        // All the Strings are made stored in string pool as default in heap memory
        String name1 = "kunal";
        String name2 = "kunal";

        // output - True b/c == method check for both value and object these reference variable are pointing
        System.out.println(name1 == name2);

        // using this , we can create a new object outside of String Pool
        String a = new String("hello");
        String b = new String("hello");

        // Output - false b/c even though value is same , object to which these reference variable are pointing is not same
        System.out.println(a == b);

        // Output - True b/c .equals() only check value , not the object these reference variable are pointing
        System.out.println(a.equals(b));

        // .charAt() Method

        // output - h
        System.out.println(a.charAt(0));

        // output - e
        System.out.println(a.charAt(1));

        /* //////////////
           Pretty Printing
        ///////////////// */

        // printing float
        float f = 433.127f;
        System.out.printf("Formatted number is %.2f", f);
        System.out.println(); // creating extra line

        // printing PI
        System.out.printf("PI till 3 decimal points: %.3f",Math.PI);
        System.out.println(); // creating extra line

        // For Strings
        System.out.printf("Hello! My name is %s and I am %s", "kunal" , "student");
        System.out.println(); // creating extra line

        // for Characters
        System.out.printf("Hello! My name starts with %c" , 'k');
        System.out.println(); // creating extra line

        /* /////////////////////
           Operator Overloading
          ////////////////////// */

        // Adding two characters
        System.out.println('a' + 'b'); // Output - 195 ( Adding ASCII values of both )

        // Adding two Strings
        System.out.println("a" + "b"); // Output - ab ( Concatenate two Strings )

        // Adding Character and Number
        System.out.println('a' + 3); // Output - 100 ( coverting char to it's ASCII value and then adding 3 )

        // Adding Character and Number - Also converting it to char
        System.out.println((char)('a' + 3)); // Output - d

        // Adding string and number
        System.out.println("a" + 1); // output - a1

        // Adding string and a arraylist
        System.out.println("Kunal" + new ArrayList<>()); // output - Kunal[]

        // Adding Integer ( wrapper class ) and arrayList
//        System.out.println(new Integer(43) + new ArrayList<>()); // output - ERROR

        // Adding  Integer ( wrapper class ), Empty String and arrayList
        System.out.println(43 + "" + new ArrayList<>()); // output - 43[]

        // Adding string and a Character
        System.out.println("a" + 'a'); // Output - aa

        /* ////////////////////
             String Builder
           ///////////////////*/


        String series = "";
        for (int i = 0; i < 26 ; i++) {
            series += (char) ('a' + i);
        }
        System.out.println(series);
        // There is a HUGE PERFORMANCE PROBLEM in above code. b/c it is creating new Object everytime and
        // leaving the old without any reference variable

        // SOLUTION - STRINGBUILDER
        // StringBuilder will allow us to modify it's value and it's reference in heap memory also not changed
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append((char) 'a' + i);
        }
        System.out.println(sb);


        // Method StringBuilder Provide us -

        // Converting String to StringBuilder
        String s2 = "kunal";
        StringBuilder sb1 = new StringBuilder();
        sb1.append(s2);

        // converting StringBuilder to string
        String s1 = sb1.toString();
        System.out.println(series);

        // insert() Method
        StringBuilder sb3 = new StringBuilder("Kunal");
        sb3.insert(1,"Hello");
        System.out.println(sb3); // Output - "KHellounal"

        // replace() Method
        StringBuilder sb4 = new StringBuilder("Kunal");
        sb4.replace(1,4,"Hello"); // end is not inclusive
        System.out.println(sb4); // Output - "KHellol"

        // delete() Method
        StringBuilder sb5 = new StringBuilder("Kunal");
        sb5.delete(1,4);
        System.out.println(sb5); // Output - "Kl"

        // deleteCharAt() Method
        StringBuilder sb6 = new StringBuilder("Kunal");
        sb6.deleteCharAt(0);
        System.out.println(sb6); // "unal"

        // reverse() Method
        StringBuilder sb7 = new StringBuilder("Kunal");
        sb7.reverse();
        System.out.println(sb7);

        
    }
}
