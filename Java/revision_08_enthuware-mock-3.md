# Revision notes from Enthuware Mock Test 3

## The default format when printing a `LocalDate` is `YYYY-MM-DD`


```Java
import java.time.*;
import java.time.format.*;

LocalDate date1 = LocalDate.of(2022, 12, 24);
LocalDate date2 = LocalDate.parse("24/12/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
System.out.println(date1);
System.out.println(date2);
```

    2022-12-24
    2022-12-24





    null



## When creating a multi-dimensional array, the expression is evaluated from left to right in sequence...
.. which means that if you define the length of the array using a variable, the value of that variable can potentially change between each dimension resulting in differing array lengths.

For example, imagine we create a variable `arrayLength` and set it to value `2`, then we create a multi-dimensional array and set the first dimension to a length of `arrayLength`, then within the second array-length bracket we change the value of `arrayLength` to `11`. Now we have an array of length `2` where each of the inner arrays have a length of `11`.


```Java
int arrayLength = 2;

int intArray [][] = new int[arrayLength][arrayLength=11];
System.out.println("Outer Array Length: " + intArray.length);
System.out.println("Inner Array Length: " + intArray[0].length);
System.out.println("So we have an array containing " + intArray.length + " arrays which each can contain " + intArray[0].length + " ints.");
```

    Outer Array Length: 2
    Inner Array Length: 11
    So we have an array containing 2 arrays which each can contain 11 ints.





    null



## If a Java program runs out of memory the error that will be thrown is `java.lang.OutOfMemoryError` which is a subclass of `java.lang.Error`
Additionally, an error will only print a stack trace if:
a.) The error was not caught
b.) The *catch* block explicitly prints the trace, for example using the `printStackTrace()` method

## The `String` class does not contain an `append()` method
`append()` is not one of the methods that both `String` and `StringBuilder` have (unlike, `replace()` for example).


```Java
String s = "World";
s = s.replace("World", "Hello");
System.out.println(s);

StringBuilder sb = new StringBuilder("Hello");
sb.replace(0, sb.length(),"World");
System.out.println(sb);
```

    Hello
    World





    null




```Java
String s = "Hello";
s = s.append(" World");
```


    cannot find symbol

      symbol:   method append(java.lang.String)

      location: variable s of type java.lang.String

     s = s.append(" World")

         ^       ^           


## You cannot auto-box an `int` primitive into a `Double` object
Auto-boxing only occurs between a primitive and it's matching wrapper-class.

## Java allows you to use a class name as a variable name
It's not best practice but you won't receive an error. If there's a conflict between the variable name and class name, Java will use *scope* to determine which is used (i.e. whichever has the closest scope will be used).


```Java
String String = "String";
Double Double = 4.0;
System.out.println(String);
System.out.println(Double);
```

    String
    4.0





    null



## Access modifiers (`public`/`private`/`protected`) are only valid inside the scope of a class, NOT of a method
You can use these modifiers to control the access of a class but not for methods or fields/variables.

## `main` is not a keyword
Although `main` is the name of a commonly used method, it is NOT reserved/a keyword. So you can use `main` as a variable name and also as a method (however, it won't function as *the* main method which gives JVM a start point to execute the program).


```Java
int main = 4;
System.out.println(main);
```

    4





    null




```Java
class Foo {
    public String main() {
        return "Foo";
    }
}
```




    com.twosigma.beaker.javash.bkr29df5702.Foo



## `.charAt()` can take a *char* as an argument
Though `.charAt()` expects an *int*, you can pass it a *char* without issue because the *char* will be implicitly promoted to an *int*.

## A `static` method cannot be overridden by a non-static method *and vice versa*
Overriding methods is when you declare a method in a subclass using the same name as a method in the it's parent class. However, there are rules and one of them is that you can't override a *static* method with a *non-static* AND you can't override a *non-static* method with a *static* one.


```Java
class Foo {
    public void bar() {}
}

class Foobar extends Foo {
    static String bar() {}
}


```


    ERROR: java.lang.IllegalStateException: bar() in com.twosigma.beaker.javash.bkr29df5702.Foobar cannot override bar() in com.twosigma.beaker.javash.bkr29df5702.Foo

      overriding method is static

     static String bar() {}

     ^                     ^ 


## Watch out for questions that use `true` and `false` reversed in an expression to throw you off
A simple but effective trick. Questions may reverse the boolean primitives `true` and `false` such that `false` appears as the output if the expression evaluates to `true` and vice versa.


```Java
boolean var = false;

boolean evaluate = var? false: true;

System.out.println(evaluate);
```

    true





    null



## REMEMBER: If you leave a local variable unassigned and place it's assignment within an if/else loop...
Java will throw an error when you try to make use of the variable *if there's a chance that it hasn't been initialized*.

__NOTE__: You could make the following sample work by changing `numOfAttendees` to a `final` and assigning a value greater-than or equal to `15`; that would make it a compile-time constant and the compiler would know the outcome of the `if` statement.


```Java
class Party {
    static int numOfAttendees; // this is a static variable so will get a default value, since here it's an `int` the default is `0`
    int minNumOfBeers = 20, minNumOfPizzas = 5; // these are instance vars so will get default values also but lets give them a value just to be different
    public static double calcBudget() { // calcBudget method
        int pizzaBudget, beerBudget, gamesBudget; // we're inside a method now so these are LOCAL vars and DO NOT get default values
        if (numOfAttendees > 15) { // we're using an if statement to determine if anyone will be attending the party before assigning values
            pizzaBudget = 50;
            beerBudget = 100;
            gamesBudget = 80;
        }
        return (pizzaBudget+beerBudget+gamesBudget); // now we're still inside the method and we're trying to use the LOCAL vars but since their assignment
                                                     // is inside an IF statement there's a chance that they won't be assigned, so the compiler will throw an error
    }
}
```


    ERROR: java.lang.IllegalStateException: variable pizzaBudget might not have been initialized

     return (pizzaBudget+beerBudget+gamesBudget)

             ^          ^                         

    

    variable beerBudget might not have been initialized

     return (pizzaBudget+beerBudget+gamesBudget)

                         ^         ^              

    

    variable gamesBudget might not have been initialized

    return (pizzaBudget+beerBudget+gamesBudget)

                                   ^          ^  


## Any exception that is not a subclass of `Error` or `RuntimeException` is a *checked-exception* and must either be declared in the method signature or handled
To me, it's easy to forget that `Exception` is itself a *checked-exception* since `RuntimeException` is a subclass of `Exception`, however, you must either declare or handle `Exception` and any subclass which isn't a child of `Error` or `RuntimeException`.

## An overriding method only needs to specify a subset of exception classes that the *overridden method may throw*
You don't necessarily have to re-throw the same exceptions that the original method threw unless there's a chance that your overriding method may throw such a *checked-exception* and doesn't handle it.

So, for example if you have a method which does some I/O operations and throws `IOException`, then you override that method with another which instead of throwing the exception handles it that's perfectly valid. Or if the overriding method doesn't perform any I/O operations that require declaring/handling a checked-exception.


```Java
import java.io.*;

class Foo {
    public void fooMethod() throws IOException {
        File f = new File("/Users/neal/Documents/foo.txt");
        FileReader fr = new FileReader(f);
        // some IO operations
    }
}

class Bar extends Foo {
    public void fooMethod() {
        try {
            File f = new File("/Users/neal/Documents/foo.txt");
            FileReader fr = new FileReader(f);
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
}
```




    com.twosigma.beaker.javash.bkr2e82c42b.Foo



## Leaving the test part of a `for` loop blank creates an infinite loop unless a break condition is included elsewhere within the loop
If you see a for loop that looks like `for (;;i--)` (presuming that `i` has been initialise before the loop), it's tempting to think that it will either not execute or only execute once since no test is provided. However, it actually creates an infinite loop and will only terminate if you include a break condition elsewhere within the loop.


```Java
int i = 0;
int j = 15;
LOOP:
    for (;;--j) {
        System.out.println("i is " + i + ". j is " + j);
        if (j<i) break LOOP;
    }
```

    i is 0. j is 15
    i is 0. j is 14
    i is 0. j is 13
    i is 0. j is 12
    i is 0. j is 11
    i is 0. j is 10
    i is 0. j is 9
    i is 0. j is 8
    i is 0. j is 7
    i is 0. j is 6
    i is 0. j is 5
    i is 0. j is 4
    i is 0. j is 3
    i is 0. j is 2
    i is 0. j is 1
    i is 0. j is 0
    i is 0. j is -1





    null



## REMEMBER: Although objects passed as arguments to a method are passed by reference, if you reassign the variable within the method...
..You're actually re-assigning the LOCAL variable. You can make changes to the actualy object since the actual object reference was passed to the method but as soon as you try to reassign the variable to point to a different object you're only changing the local version NOT the original.


```Java
package test.beaker;

class ReferenceFun {
    StringBuilder original = new StringBuilder("I'm the original?");
    
    public void fiddleWithRef(StringBuilder sb) {
        sb.replace(sb.indexOf("?"), sb.indexOf("?")+1, "!"); // successfully perform some operations on the actual object since we're working with it's reference
        sb = new StringBuilder("I'm NOT the original!"); // as soon as you reassign like this, what you're actually saying is 
                                                         // "reassign this local variable sb to point to a new obj" but the original remains unchanged
    }
}


```




    test.beaker.ReferenceFun




```Java
package test.beaker;

ReferenceFun rf = new ReferenceFun();
System.out.println(rf.original);
rf.fiddleWithRef(rf.original);
System.out.println(rf.original);
```

    I'm the original?
    I'm the original!





    null


