package DSA.ArrayList;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        // Creating a new ArrayList of Strings
        ArrayList<String> stringList = new ArrayList<>();

        // Adding elements to the ArrayList
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Orange");

        
        // Printing the elements in the ArrayList
        System.out.println("Elements in the ArrayList:");
        for (String element : stringList) {
            System.out.println(element);

            System.out.println(stringList.size());
            System.out.println(stringList.length);
        }

    }
}
