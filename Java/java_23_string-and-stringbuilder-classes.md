# Java's String and StringBuilder classes

## The `String` class
Java's `String` class is used to access useful `String` methods and to instantiate `String` objects. There are 2 main ways to create Strings in Java:
1. `String myString = "this is my String";` in this case you are creating a variable of type `String` and assigning it as a pointer to the String object "this is my String". We have only created one String object (the literal "this is my String") which is stored in the *String pool*.
2. `String myString = new String("this is my String");` here we instantiate a new String object using standard object instantiation. This is not considered best practice as we have created 2 objects, the string literal "this is my String" in the *String pool* and also a String object in *heap* memory which contains the same value.

Method 1 is preferred as it is more memory efficient. When creating Strings using this method, Java will compare the string literal you pass in with the strings currently stored in the *pool*  and if the literal is already present, it will simply point your variable to that existing memory address.

### Concatenating strings
Strings can be concatenated using the addition symbol (`+`) or by calling the `.concat()` method on one string, passing the string to be concatenated as an argumentl (e.g. `myStringOne.concat(myStringTwo);`). When you concatenate and assign a variable pointer to the result, you are actually creating a new String object in memory. So the original string(s) and the new concatenated version will both exist in the *pool* (however, if you re-assigned the pointer for the original String to point to the new concatenated version the original likely no longer has any variables pointing to it and will eventually be automatically garbage collected).


### `.length()` method
The `.length()` method can be used to determine how many characters/digits are in a string.


```Java
String myString = "Hello world!";
System.out.println(myString.length());
```

    12





    null



### `.trim()` method
The `.trim()` method will strip leading and trailing whitespace from a string.


```Java
String whiteSpaceString = "            hello            ".trim();
System.out.println(whiteSpaceString);
```

    hello





    null



### `.toLowerCase()` method
The `.toLowerCase()` method converts all the characters in a string to their lowercase version.

**NOTE**: the result must be stored in a variable as it doesn't mutate the original string.


```Java
String originalUpperString = "HELLO WORLD";
originalUpperString.toLowerCase();
System.out.println("The value of originalUpperString is: " + originalUpperString); // outputs the original version as the string hasn't been changed

String newLowerString = originalUpperString.toLowerCase();
System.out.println("The value of newLowerString is: " + newLowerString);
```

    The value of originalUpperString is: HELLO WORLD
    The value of newLowerString is: hello world





    null



### `.indexOf()` method
The `.indexOf()` method returns the index of whatever character is passed to it (or `-1` if it can't find the character).


```Java
String anXInside = "helloxworld";
int xIndex = anXInside.indexOf("x");
System.out.println(xIndex);
System.out.println(anXInside.indexOf("z")); // -1 since there's no "z"
```

    5
    -1





    null



### `.lastIndexOf()` method
Extracts the farthest occurence of the given letter.


```Java
String s = "You spin me right round baby right round";
System.out.println(s.lastIndexOf("round"));
```

    35





    null



# Java's `StringBuilder` Class
Java has a class called `StringBuilder` which provides a *mutable* alternative to `String`. Unlike `String`, `StringBuilder` objects need to be instantiated using the `new` keyword like any other object.
<br>`StringBuilder myString = new StringBuilder("Hello");`


```Java
StringBuilder foo = new StringBuilder("bar");
System.out.println(foo);
```

    bar





    null



## The benefits of `StringBuilder`
Some of the benefits of `StringBuilder` are:
- many useful methods for manipulating value (e.g. append, delete, insert, replace)
- better performance due to mutability (i.e. it doesn't create a new object in memory every time the string is changed)
- can be created with an initial capacity

However, using `StringBuilder` instead of `String` isn't always appropriate and some of the benefits of using `String` include:
- possibly "safer" due to immutability
- some APIs may require `String`
- has many more methods than `StringBuilder`


```Java
StringBuilder myChangeableString = new StringBuilder("Hello");
System.out.println(myChangeableString);

myChangeableString.append("World?"); // append to the end of original string
System.out.println(myChangeableString);

myChangeableString.setCharAt(10, '!'); // change the ? char to !
System.out.println(myChangeableString);

myChangeableString.delete(10,11); // delete the character between indices 10 and 11
System.out.println(myChangeableString);

myChangeableString.insert(5, " "); // insert a space at index 5
System.out.println(myChangeableString);

StringBuilder myReversedString = myChangeableString.reverse(); // reverse the string
System.out.println(myReversedString);
```

    Hello
    HelloWorld?
    HelloWorld!
    HelloWorld
    Hello World
    dlroW olleH





    null



### Capacity
StringBuilder objects have an initial capacity of 16 but this grows and shrinks as needed. At any one time the capacity is the number of characters used + 16.

You can check the capacity of your StringBuilder object using it's `.capacity()` method.


```Java
StringBuilder sb1 = new StringBuilder();
System.out.println(sb1.capacity());

StringBuilder sb2 = new StringBuilder("Hello");
System.out.println(sb2.capacity());

StringBuilder sb3 = new StringBuilder("Hello there world!!");
System.out.println(sb3.capacity());
```

    16
    21
    35





    null



## Comparing Strings
Since Strings are objects, using the equality operator (`==`) is not very reliable. For example, if you have `String s1 = "hello"` and `String s2 = new String("hello")` the equality operator will return false because you're trying to compare two different objects (even though they contain the same literal). Java provides some String comparison methods to avoid this.

### `.equals()` method
This method is called on a String and has another string passed to it as an argument.


```Java
String s1 = "hello";
String s2 = "hello";
String s3 = "world";
System.out.println(s1.equals(s2)); // true
System.out.println(s2.equals(s3)); // false
```

    true
    false





    null



### `.equalsIgnoreCase()` method
The same as `.equals()` but ignores whether the letters are different cases.


```Java
String s4 = "HELlo";
String s5 = "hello";
String s6 = "World";
System.out.println(s4.equalsIgnoreCase(s5));
System.out.println(s5.equalsIgnoreCase(s6));
```

    true
    false





    null



### `.compare()` method
Will compare the lexicographical value of each character in the Strings and return an integer expressing the difference (or lack thereof) between the String it was called on and the string it was passed.


```Java
String s7 = "Hello";
String s8 = "Hello";
String s9 = "hello";
String s10 = "Helicopter";
System.out.println(s7.compareTo(s8)); // 0 = no difference, the strings are the same value
System.out.println(s7.compareTo(s9)); // -32 = s7 has a lexicographical value 32 less than s9 
// (uppercase chars are "less" than lowercase as their unicode codepoint is smaller)
System.out.println(s7.compareTo(s10)); // 3 = s7 has a lexicographical value 3 more than s10 ("l" > "i")
// remember it's comparing the codepoint value of each character not the total length of the String
```

    0
    -32
    3





    null



### `.intern()` method
The `.intern()` method returns a "canonical representation" of the String object. We know that when creating String objects Java checks if the String being created already exists in the *String pool* and if so it doesn't create a new String in the pool (even if a new object containing that String is created in heap memory).


```Java
String myString = "hello";
String myString2 = new String("hello");
System.out.println(myString.intern() == myString2.intern());
```

    true





    null



## Extracting characters from Strings
There are a number of methods for extracting, working with the characters within a String.

### `.charAt()` method
This method allows you to extract the character at a specific index within the String.


```Java
String longStr = "Hello everybody, welcome to the world of Java";
System.out.println(longStr.charAt(4)); // "o" the char at index 4
System.out.println(longStr.charAt(longStr.length()-1)); // "a" the last char
char sPart1 = longStr.charAt(0);
char sPart2 = longStr.charAt(1);
char sPart3 = longStr.charAt(2);
char sPart4 = longStr.charAt(3);
char sPart5 = longStr.charAt(4);
System.out.printf("%s%s%s%s%s", sPart1, sPart2, sPart3, sPart4, sPart5);
```

    o
    a
    Hello




    null



### `.getChars()` method
This method will extract the characters between two passed in indices and inserts them into a charArray at a given index.
`.getChars(startIndex, numOfCharsToExtract, charArrayToAddTo, charArrayIndex)`


```Java
String longStr = "Hello everybody, welcome to the world of Java";
char [] extractedChars = new char [11];
int start = 0;
int end = 5;
longStr.getChars(start, end, extractedChars, 0);
extractedChars[5] = ' ';
start = 32;
end = 37;
longStr.getChars(start, end, extractedChars, 6);
System.out.println(extractedChars);
```

    Hello world





    null



## Extracting and modifying Strings from/within Strings
The previous methods were specifically for extracting *characters* from Strings and while you can then ouput the chars as if they were Strings, it's not very efficient. To work with Strings within Strings Java provides the below methods.

### `.substring()` method
Can take X arguments. If you pass a single index, it will extract the remainder of the String starting at that index up to the end of the String. If you pass two indices, it will extract the String between them (exclusive).

`String.substring(startIndex, [optional] endIndex);`


```Java
String longStr = "Hello everybody, welcome to the world of Java";
System.out.println(longStr.substring(0, 5) + " " + longStr.substring(32, 37));
```

    Hello world





    null



## `StringTokenizer` class **LEGACY**
`StringTokenizer` is a class which allows you to divide a given String into "tokens", smaller pieces of information such as key value pairs. This class is now *legacy* and it is not recommended for use in modern Java development.

To use this class you must first import it from the `java.util` package. You then instantiate a `StringTokenizer` object and pass a String to it's constructor:
`StringTokenizer st = new StringTokenizer("Hello world");`

You can also pass delimiters to control what parts of the String are separated into "tokens":
`StringTokenizer st = new StringTokenizer(string, delimiters);`


```Java
import java.util.StringTokenizer;

String s = "Name=Bob,Occupation=Teacher,Country Of Residence=Mexico";
StringTokenizer st = new StringTokenizer(s, "=,");// create tokenizer object
while (st.hasMoreTokens()) { // iterate through object
    String key = st.nextToken();
    String value = st.nextToken();
    System.out.println(key + ": " + value);
}
```

    Name: Bob
    Occupation: Teacher
    Country Of Residence: Mexico





    null


