# Declaring Primitive Variables
## What are "Primitive" variables?
Primitive variables are non-object variables that are held in a specific amount of memory dedicated to your program.;

## Types of variables in Java
The main types of variables in Java are:

Name|Description
:--|:--
`String`|A sequence of characters encased in double quotes
`char`|A single character encased in single quotes
`float`|A decimal (32 bits, `1.4e^-45` to `3.4e^38`) must include `f` or `F` at the end of the number
`double`|A large decimal (64 bits, `5e^324` to `1.8e^308`)
`int`|An integer (32 bits, `-2,147,483,648` to `2,147,483,647`)
`boolean`|true or false
`byte`|Very small integer (8 bits, `-128` to `127`)
`short`|Relatively small integer (16 bits, `-32,768` to `32,767`)
`long`|Very large numbers (64 bits, `-2^63` to `2^63-1`) must includ an `L` or `l` at the end of the number



```Java
String myName = "Dracula";
int myKills = 2146333123;
float myHeight = 5.11f; // must end with F or f
boolean amAlive = true;
char myInitial = 'V';
byte myFangs = 2;
short myAge = 32600;
long bloodDrunk = 2147483648L; // must end with L or l
double cloakLength = 42.45;


System.out.println("My name is "+myName);
System.out.println("I am "+myAge+" years old.");
System.out.println("I am "+myHeight+" ft");
System.out.println("I have drunk "+bloodDrunk+" litres of blood");
System.out.println("My cloak is "+cloakLength+" inches long");
```

    My name is Dracula
    I am 32600 years old.
    I am 5.11 ft
    I have drunk 2147483648 litres of blood
    My cloak is 42.45 inches long





    null



## Declaring a constant
If you have a variable which should keep the same value throughout the life of a program you can make it a constant using the keyword `final`.

__NOTE__: convention is to declare constants in BLOCKCAPS.


```Java
final String FORBIDDEN_KNOWLEDGE = "lament configuration";
```




    null



## Increment and Decrement
As in many languages Java has a shorthand for incrementing and decrementing by `1`:
- `++` increments (increases) the value by 1
- `--` decrements (decreases) the value by 1

The placement of the increment/decrement is important as Java includes the concept of *pre*-decrement/increment and *post*-decrement/increment. If you're performing multiple operations at the same time and you place the `++`/`--` *before* the variable to be incremented/decremented then Java will perform the increment/decrement before any other operations. 

Example:


```Java
int myInt = 7; // initialise myInt with value of 7
System.out.println(myInt++); // print and THEN increment by 1
System.out.println(myInt); // just print (so we can see that it was in fact incremented)
```

    7
    8





    null



## Strings are object references NOT primitives
In Java strings are object references and as such comparing them has some intricacies. For example if I have two strings declared like this:
<br>`public String name1 = "Sideshow Bob";`
<br>`public String name2 = "Sideshow Bob";`

Both of those variables are pointing to a single object in memory.

If you want to force Java to create two separate string objects with the same value you can do so as follows:
<br>`public String name1 = new String("Sideshow Bob");`
<br>`public String name2 = new String("Sideshow Bob");`

However, this means that if you compare the strings using `==`, Java will tell you they're not the same even though they have identical content. Since when comparing strings we rarely intend to compare the space in memory and actually want to compare the content of the string you can use some string methods provided by Java.


```Java
String sideshow1 = new String("Bob");
String sideshow2 = new String("Bob");

System.out.println(sideshow1 == sideshow2);
```

    false





    null



### String.equals()
The first method we can use to compare strings is the equals method. The syntax is:
<br>`string1.equals(string2);`


```Java
String sideshow1 = new String("Bob");
String sideshow2 = new String("Bob");

System.out.println(sideshow1.equals(sideshow2));
System.out.println("Luke Perry".equals("Bob"));
```

    true
    false





    null



### String.equalsIgnoreCase()
The second method is `.equalsIgnoreCase()` and the syntax is:
<br>`string1.equalsIgnoreCase(string2);`


```Java
String sideshow1 = new String("Bob");
String sideshow2 = new String("bob");

System.out.println(sideshow1.equals(sideshow2));
System.out.println(sideshow1.equalsIgnoreCase(sideshow2));
```

    false
    true





    null




```Java

```
