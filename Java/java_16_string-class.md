# Java's String class
One of the many classes provided by the Java class library and one you'll use frequently is the String class. This class provides the ability to store sequences of characters. In Java, as in many languages, Strings:
- are immutable (i.e. cannot be changed, you can't insert at index or delete characters from the string etc)
- can be concatenated using the plus (`+`) symbol

## Creating a String literal vs a String object
Unlike most classes in Java you will more often create a string without ever using the `new` keyword.

String literals exist in Java memory in a pool (the String Constant Pool) and if you try to create another variable which contains the same string, Java will look in the pool and see that it already has that string so it will make the new variable point to that same literal.

On the other hand, when explicitly creating objects using the `new` keyword, Java doesn't care if there's already an object which looks like the one you're trying to create, it will still create a new one in memory.
- `String myString = "Hello World!";` is a string <u>literal</u> ("*Hello World!*") which is created in the pool and it's reference/name is assigned to the string-type variable "*myString*"
<br><br>
- `String myStringObj = new String();"` is a String <u>object</u> instantiated using the String class' constructor. Since the pool is only for Strings a new piece of memory needs to be used to hold this new object.

Assigning strings as literals is more memory efficient than instantiating String objects.

## Concatenating strings
Since strings are immutable, when you concatenate two strings you're actually creating a new string in memory. So, if you assign the concatenated string to the same variable name that was used previously, the variable now points to this new string and the previous string is unassigned and inaccessible. That unassigned literal will be "garbage collected" (i.e. Java will delete it from memory at some point).


```Java
String myStr1 = "Hello ";
String myStr2 = "World!";
myStr1 = myStr1+myStr2; // creates a new literal "Hello World!" and assigns it to myStr1
System.out.println(myStr1); // "Hello" is now floating in Java's memory unassigned and will be automatically deleted
```

    Hello World!





    null



## String methods
As with most classes, String comes with many methods. Most of these methods will return a single value which can be a primitive or a reference to an object. In order to use the returned value from the method you will often need to assign it to a variable. However, you can also use a method as part of an expression.

__NOTE__: the methods of the String class are `final` and thus cannot be overridden.


```Java
String foo = "bar";
int fooLength = foo.length();
System.out.println(foo + ": " + fooLength);

String ho = " HeLLO"; // space before hello
String wd = "WORLd "; // space after world
String en = " ! "; // space before and after !
String trimmedConcat = (ho.trim() + " " + wd.trim() + en.trim()).toLowerCase(); // a single expression which concatenantes the 3 strings and lowers the case
System.out.println(trimmedConcat);
```

    bar: 3
    hello world!





    null



### Methods with arguments
Some string methods require you to pass an argument when calling them.


```Java
String fullString = "Hello World!";
String partString = fullString.substring(4); // subString takes an index at which to start the substring
System.out.println(partString);
System.out.println(fullString.endsWith("ld!")); // ends with takes a string or string-reference to check for
System.out.println(fullString.equals(partString));  // equals takes a string or string-reference
```

    o World!
    true
    false





    null



## Useful methods
Below are some useful/common String methods.

### `charAt()`
Returns the character located at the index passed to it.


```Java
char wall = "All in all it's just another brick in the wall".charAt(0);
System.out.println(wall);
```

    A





    null



### `concat()`
Appends the string passed to it, to the string it's called on.


```Java
String s1 = "Hello ";
String s2 = "World!";
System.out.println(s1.concat(s2));
```

    Hello World!





    null



### `equals()` and `equalsIgnoreCase()`
Both return a boolean value depending on whether the string passed to it is the same as the string it's called on. `equalsIgnoreCase` will ignore whether the letters are different cases.


```Java
String foo1 = "FOO";
String foo2 = "foo";
System.out.println(foo1.equals(foo2));
System.out.println(foo1.equalsIgnoreCase(foo2));
```

    false
    true





    null



### `length()`
Returns an int representing the length of the string it's called on.


```Java
String bar = "foo";
System.out.println("The string is " + bar.length() + " characters long.");
```

    The string is 3 characters long.





    null



### `replace()`
Takes two arguments, all occurrences of the first argument will be replaced with the second argument in a new version of the string that this method is called on.


```Java
String mustRemember = "A kiss is just a kiss";
System.out.println(mustRemember);
mustRemember = mustRemember.replace("kiss","sneeze"); // must be assigned explicitly since strings are immutable (the orig can't be changed)
System.out.println(mustRemember);
```

    A kiss is just a kiss
    A sneeze is just a sneeze





    null



### `toLowerCase()`
Returns a new String with lowercase letters.


```Java
String mcb = "IS THIS A DAGGER I SEE BEFORE ME?";
mcb = mcb.toLowerCase();
System.out.println(mcb);
```

    is this a dagger i see before me?





    null



### `toUpperCase()`
Returns a new String with uppercase letters.


```Java
String nobler = "suffer the slings and arrows";
nobler = nobler.toUpperCase();
System.out.println(nobler);
```

    SUFFER THE SLINGS AND ARROWS





    null



### `trim()`
Removes leading and trailing whitespace characters.


```Java
String wspace = "                    poor Yorrick                           ";
wspace = wspace.trim();
System.out.println(wspace);
```

    poor Yorrick





    null



### `substring()`
Returns a new string which is a substring of the string it was called on. You can pass either a single argument (start index, the index to start the substring) or two arguments (start index and end index).


```Java
String richie = "My kingdom for a horse";
String rsub = richie.substring(15);
String mrEd = rsub + " is " + rsub + " of course of course.";
System.out.println(mrEd);
```

    a horse is a horse of course of course.





    null



### `toString()`
Returns a string representation of an object. This method is actually inherited from Java's Object class and is commonly overridden when creating objects. Its default value isn't the most useful so you will generally want to override with a more useful version


```Java
package test.beaker;

public class EHorizon {
    public String dest = "Where we're going you won't need eyes";
    public boolean crewDead = true;
}
```




    test.beaker.EHorizon




```Java
package test.beaker;

EHorizon evnt = new EHorizon();

System.out.println(evnt.toString()); // rather uninformative default output
```

    test.beaker.EHorizon@11f82ddf





    null



### `compareTo()` and `compareToIgnoreCase()`
`compareTo` and `compareToIgnoreCase` will compare the string passed to and the string they're called on "lexicographically" using their unicode values.


```Java
String a1 = "a";
String a2 = "A";
System.out.println(a1.compareTo(a2)); // returns 32 because "a" has a unicode value 97 of whereas "A"'s is 65. so "a" is 32 more than "A".
System.out.println(a2.compareTo(a1)); // reversing the order will return -32
System.out.println(97-65);
System.out.println(a1.compareToIgnoreCase(a2)); // ignoreCase version 
```

    32
    -32
    32
    0





    null



If comparing multiple characters, the value will be tested character-by-character from left to right. This means that even if one string is significantly longer (and thus should technically have a higher value) Java will stop as soon as one string has a greater value.


```Java
String longString = "aBcdEFGhijkLMNOpqrsTUVWxyz";
String shortString = "ab";
System.out.println(longString.compareTo(shortString)); // reports that longString is 32 less than shortString because "B" is 32 less than "b"
```

    -32





    null



### `getChars()`
Copies chars from a string to an array.


```Java
char [] charArray = new char[4]; // create and instantiate a char array with a length of 4
String myString = "Hello"; // create a string to copy the chars from
myString.getChars(0,4,charArray, 0); // call getChars method passing start-index, end-index, destination-array, index of destination-array to place the chars
System.out.println(charArray);
```

    Hell





    null



### `indexOf()`
Returns the index of the first occurence of the passed substring or `-1` if no match is found.


```Java
String whoIsIt = "it's-a mee Mario!";
int whereIsHe = whoIsIt.indexOf("Mario");
int whereIsLuigi = whoIsIt.indexOf("Luigi");
System.out.println(whereIsHe);
System.out.println(whereIsLuigi);
```

    11
    -1





    null



### `lastIndexOf()`
Returns the index of the last occurence (i.e. searches in reverse).


```Java
String oldPoem = "up the airy mountains down the rushy glen";
int findThe = oldPoem.lastIndexOf("the");
System.out.println(findThe);
```

    27





    null



### `printf()`
While not strictly a String method, it's worth discussing `printf()` given how it functions and how frequently you'll use it with strings. This method allows you to use a formatted string where you specify the places in a string in which you want to insert variables and then pass the variables in the order they should be inserted.
<br>
<br>`System.out.printf("String in which to insert variables", variable1, variable2);`

#### Format specifiers
Format specifiers are placeholders that tell Java __A.)__ where you want to insert a variable and __B.)__ what sort of variable to expect.
- `%s`: string placeholder
- `%c`: char placeholder
- `%f`: float/double placeholder (place `.<number>` between `%` and `f` to specify how many decimal places)
- `%d`: digit/int placeholder
- `%b`: boolean placeholder
- `%n`: new-line character (same function as `\n`)


```Java
String svar1 = "variable";
String svar2 = "sentence";
String svar3 = "This";
int svar4 = 4;
System.out.printf("%s %s contains %d %ss.", svar3, svar2, svar4, svar1); // NOTE: the variables must be passed in the order they are to be inserted
```

    This sentence contains 4 variables.




    null




```Java
String s1 = "dinghyrubber";
String s2 = "dinghy";
System.out.println(s2);
s2.concat(s1);
System.out.println(s2);
```

    dinghy
    dinghy





    null




```Java

```
