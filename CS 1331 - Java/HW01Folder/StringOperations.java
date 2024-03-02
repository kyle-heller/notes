/*
 All of the instructions in this section should be carried out in the class StringOperations, in the main method.

    Create a new String object and assign it your name. Print it out.
    Pick the first letter in your name, and replace it with ‘A’. Then, replace the last letter in your name with ‘Z’. 
    Print out the result. Recall that, in Java, strings are immutable, meaning you cannot change a String in-place. Do 
    NOT just hard-code a new String with the first and last letters changed.
    Lastly, let’s work with some URLs.  Declare a new String and give it the value of some web address, in the form 
    www.name.tld, such as www.gatech.edu or www.stackoverflow.com. Print out this address.
    This last operation could be a little tricky. Create a substring of the variable that’s just the “name” section, 
    and concatenate the integer “1331” to the end. For example, www.gatech.edu would become gatech1331. Print out this 
    final result. Note: the String class has a .length() method which you’ll likely find useful here but is not necessary.
 */

public class StringOperations {
  public static void main(String[] args) {
    String stringValue = "Kyle";
    System.out.println(stringValue);
    String newStringValue = stringValue.replace('K','A');
    newStringValue = newStringValue.replace('e','Z');
    System.out.println(newStringValue);

    String omscs = "https://omscs.gatech.edu/";
    System.out.println(omscs);
    String substring = omscs.(7,12);
    substring = substring + 1331;
    System.out.println(substring);
  }
}