# Java Language Fundamentals
Java programs consist of multiple classes made up of various components. There are several ways to test a program including:
- Unit tests: testing individual components
- End-to-End: testing the entire program in its intended environment

A desktop application usually consists of one object, often called the __controller__ object, which acts as the starting point for the program and interacts with other objects. For example, in an order management system you might have a main order entry object which in turn connects to a shipping object, a billing object and so on. Each object is an instance of its own blueprint class.

## Printing
Java provides quite a few ways to output data to the screen in the `System.out` package. Below are some of the most common:
- `print()` will "print" the characters passed two it on a single line
    <br>`System.out.print("Hello");`


```Java
System.out.print(1);
System.out.print(2);
System.out.print(3);
System.out.print("text");
```

    123text




    null



- `println()` will print the characters passed to it and then jump to a new line
    <br>`System.out.println(Hello World!);`


```Java
System.out.println(1);
System.out.println(2);
System.out.println(3);
System.out.println("text");
```

    1
    2
    3
    text





    null



- `printf()` allows you to tell Java how to format the info you pass to it
    <br>`System.out.printf("Some text with a %s inside", var="variable");`


```Java
String var = "variable";
System.out.printf("Some text with a %s inserted", var); // %s acts as a place holder for a String value
```

    Some text with a variable inserted




    null



### Format specifiers
Below is a short reference of format speciers you can use.

Specifier|Meaning
:--|:--
`%a`|float value excluding `BigDecimal`
`%b`|boolean value
`%c`|char value
`%d`|int value
`%e`|float in scientific notation
`%f`|standard float
`%g`|float which will auto convert to scientific notation depending on precision & value
`%h`|hash code
`%o`|Octal number (integer incl. byte, short, int, long, bigint)
`%s`|String value
`%t`|Date/Time value
`%x`|Hex string


```Java
// %b = boolean
boolean myBool = true;
System.out.printf("The boolean is %b!!\n", myBool);

// %f = float
float myFloat = 2.5f;
System.out.printf("I'm going to eat %f pizzas!\n", myFloat);

// %s = string
String myString = "bar";
System.out.printf("Everything has gone fu%s\n", myString);
```

    The boolean is true!!
    I'm going to eat 2.500000 pizzas!
    Everything has gone fubar





    null



## Classes
Classes are composed of the Java code needed to instantiate objects. A Java class file can be divided into four separate sections:
- the class declaration
- field declarations
- methods (optional)
- comments (optional)

Class attributes are called __fields__.

## Variables
Variables are holders of value, containers of data, and the value/data can change during the course of the application. *Fields* are one type of variable. You can also have __local__ variables. Variables can also be initialized at declaration time.

## Class structure & content
The code for a class is contained within a text file and needs to adhere to a certain structure.


```Java
public class Car {
    
    public int carID = 0; // default id
    public String description = 
            "-description required-"; // default
    // available colors are G=green, R=red, B=blue
    public char colorCode = 'G';
    public double price = 0.0;
    // this method displays the values for an item
    public void displayInfo() {
        System.out.println("Car ID: " + carID);
        System.out.println("Car Desc: " + description);
        System.out.println("Car Colour: " + colorCode);
        System.out.println("Car Price: " + price);
    } // end of method
} // end of class


```




    com.twosigma.beaker.javash.bkr27a68f43.Car



The following symbols can be used when defining a Java source:

Symbol|Description|Use
:--|:--|:--
`{}`|braces|Signify a code block e.g. a method or a class
`()`|parentheses|Used to indicate arguments (i.e. inputs) that can be passed to a method
`;`|semicolons|Signify the end of a statement
`,`|commas|Used to separate multiple arguments/values
`'`|single quotes|Used to define single characters
`"`|double quotes|Used to define strings (multiple chars)
`//`|double forward slash|Indicate a single-line comment

## Class declaration
When defining a class you must write a class declaration. Class declarations are made up of three components:
- modifiers (optional)
    - a modifiers variable determines the accessibility that other classes have to this class. This is optional and can be public, abstract, or final.
- `class` keyword
    - a reserved keyword that denotes the start of a class definition
- class identifier i.e. name
    - class name should be a noun
    - use title-case (first letter of every word capitalised) e.g. `MyClass`
    - use whole words rather than abbreviations
    
For example the `Car` class above has `public` as its modifier, `class` keyword, `Car` as its name.

You can develop classes such that each class has its own file. Java requires that source code file names must match the `public` class name in the file and have a `.java` extension. For example, sticking with the `Car` class above we would save that in a file as:
<br>`Car.java`

### Class field declarations
The field declarations & assignments should immediately follow the opening curly brace. Normally you would set-up all the attribute vars for the class here and use a semicolon at the end of each line of code. You should also put clear comments to make it clear what the code is doing.
<br>`[modifer] type name = value;`


```Java
public class MyClass {
    public char myLetter = 'A';
}
```




    com.twosigma.beaker.javash.bkr27a68f43.MyClass



### Class method declarations
Method declarations should follow the field declarations. The syntax for declaring methods is as follows:
<br>`[modifier] return_type identifier(arguments) {method code block}`

The return type indicates the type of value returned by the method, if any. Returned values can be used by *calling* the method. Any method can return __at most__ one value. If the method returns nothing the `void` keyword should be used.


```Java
public class NewClass {
    public String myString="this is my string";
    // this method prints the string
    public void printString() {
        System.out.println("My string is: " + myString);
    } // end of printString method
} // end of class
```




    com.twosigma.beaker.javash.bkr27a68f43.NewClass



## Comments
There are three types of comments in Java:
- single line comments which use `//`
- traditional comments which start `/*` and end `*/`
- documentation comments which use `/**` and end `*/` (note the double asterisk on the opening)


```Java
// this is a single line comment

/* this is a traditional 
comment which can
run across many lines */

/**
Docmentation string which can be used by the Javadoc tool to create documentation
*/
```




    null



## Keywords
Keywords are special, reserved words in Java that give instructions to the compiler. Keywords must not be used as identifiers for classes, methods, variables etc.

The words `true`, `false`, and `null` are not keywords but literals and also cannot be used as identifiers.

Reserved keywords|
:--|
`abstract`, `assert`, `boolean`, `break`, `byte`, `case`, `catch`, `char`, `class`, `continue`, `default`
`do`, `double`, `else`, `enum`, `extends`, `false`, `final`, `finally`, `float`, `for`, `if`, `implements`
`imports`, `instanceof`, `int`, `interface`, `long`, `native`, `new`, `package`, `private`, `protected`
`public`, `return`, `short`, `static`, `strictfp`, `super`, `switch`, `synchronized`, `this`, `throw`
`throws`, `transient`, `true`, `try`, `void`, `volatile`, `while`

## Useful escape sequences
An escape sequence is a combination of a backslash (`\`) and a character. The backslash tells Java not to treat the following character as it normally would and instead use a different meaning for it. Here's a table of some of those:

Sequence|Meaning
:--|:--
`\b`|backspace
`\t`|tab
`\n`|line feed (new line)
`\f`|form feed
`\r`|carriage return
`\"`|double quote
`\'`|single quote
`\\`|backslash


```Java
System.out.println("This\nwill\ncreate\nnew\nlines");
```

    This
    will
    create
    new
    lines





    null



## Packages
In Java, Classes are grouped in packages based on their functionality. For example, the "core" Java classes (e.g. `String`, `int` etc) are in the `java.lang` package. Classes in this package are immediately available and can be referred to just using their name (`String`, `Math` etc), meaning you don't need to import them first or __fully qualify__ them (refer to them by their full address e.g. `java.lang.<class>`).

Any classes in another packages need to be "fully qualified" on each use or imported at the top of your program. An commonly used __fully qualified__ class is `System.out.println()` used to print to the screen.

### Importing
Importing can be done for a specific class:
<br>`import java.util.ArrayList;`

Or for all classes within a package:
<br>`import java.util.*;`


```Java

```
