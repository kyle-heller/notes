# Revision notes from Enthuware Mock Test 6

## `Period`'s `of...` methods are *static*
The `Period` class has methods such as `.ofMonths()` and `.ofDays()` but these are *static* methods and cannot be chained. So, for example `Period.ofMonths(2).ofDays(12)` will return `12 days` only as that's the last method called on the class.

## To get a period of multiple inputs (days *and* months *and* years) you can use the `.of(int years, int months, int days)` method
This method will provide an *instance* based on the passed arguments.


```Java
import java.time.*;

LocalDate ld = LocalDate.of(2010, 11, 5);
ld = ld.plus(Period.of(0, 2, 12));
System.out.println(ld);
```

    2011-01-17





    null



## Exceptions are a mechanism for...
...among other things:
- Determining what to do when something unexpected happens
- Logging unexpected behaviour

## Any exception thrown in a *static initializer block* will be wrapped into an `ExceptionInInitializerError` which will then be thrown
So, even if you get a `RuntimeException` in your initializer block the exception output will actualy be an `ExceptionInInitializerBlock`.


```Java
package test.beaker;

class InitErrorExample {
    static int[] ia = new int[0];
    static int x;
    static {x=ia[1];} // cause an ArrayIndexOutOfBounds error within the static initializer
}
```




    test.beaker.InitErrorExample




```Java
package test.beaker;

InitErrorExample iee = new InitErrorExample(); // even though the error raised in the initializer was ArrayIndexOutOfBounds the output will show ExceptionInInitializerError
```


    ERROR: java.lang.ExceptionInInitializerError


## *static* and *instance* initializer blocks can only throw `RuntimeException`s by default
If you try to throw a checked exception from within an a initializer block your code will not compile.

However, you can throw a checked exception from an *instance* initializer __IF__ you first declare that the constructor(s) of the class `throw` that exception.

## If the the left-hand operand of a binary operator completes abruptly, no part of the right-hand operand will be evaluated
If you're assigning the outcome of an operation to a variable and the left-hand side of the operation ends abruptly (e.g. due to an exception) then any operations in the right-hand part will not complete.


```Java
int a = 0; // assign a to be zero
try {
    int b = (5/a) + (++a); // increment a as part of the right hand side of the operation
}
catch (Exception e) { // catch the exception thrown by zero division in the above operation
    System.out.println(a); // print a to see if it was successfully incremented
}
```

    0





    null



## `protected` variables are inherited by any class which extends the original in a different package...
..but it cannot be modified via an instance of the original class (it CAN be modified via an instance of the child class though). The protected variable can also be modified from any class within the same package.

## The `.equals()` method of wrapper-classes will always return `true` if passed the same instance on which it's called
For example, if you have an `Integer` `a` and you call `a.equals(a);` the output will always be `true`.


```Java
Integer i = new Integer(5);
System.out.println(i.equals(i));
```

    true





    null



## The `.equals()` method of wrapper-classes will return `false` if the refernces being compared refer to...
..instances of *different* classes.


```Java
byte b1 = 1;
Byte b = new Byte(b1);
Float f = new Float(1f);
System.out.println(b.equals(f));
```

    false





    null



## The *access-modifer* and *non-access modifer* keywords can be used in any order
Java will not object if you switch the order. For example, both `public static void main` and `static public void main` are perfectly fine.

Q53

## Java allows *multiple inheritance of type* but NOT *multiple inheritance of state*
Multiple inheritance of *type* refers to the fact that a class can implement multiple interfaces (interfaces are a *type*). However, interfaces do not have any *state* as they can't be instantiated. Only classes contain *state* and you cannot extend multiple classes. Therefore, Java only allows *single inheritance of state*.

## Passing an `int` to `StringBuilder`'s constructor will create an empty stringbuilder with an initial capacity of the int value
*StringBuilder* includes a `public StringBuilder(int capacity)` constructor which will allow you to create a StringBuilder by passing an `int` value to the constructor. This creates an empty stringbuilder but with a capacity matching the int value that was passed.


```Java

```
