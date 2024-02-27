# Revision Notes from the Enthuware Foundation Test

## `if/else` can have empty statements
`if` and `else` clauses can be empty (i.e. just `;` separating them):


```Java
if (true); else;
```




    null



## An exception throw in an initializer block will cause `ExceptionInInitializerError` to be thrown
Regardless of what error is thrown within an initializer block Java will throw an `ExceptionInInitializerError`. Essentially overwriting the error within the initializer.


```Java
package test.beaker;

class Example {
    static {
        if(true) throw new NullPointerException();
    }
}
```




    test.beaker.Example




```Java
package test.beaker;

Example e = new Example();
```


    ERROR: java.lang.ExceptionInInitializerError


## An exception can only be explicitly thrown in an initializer block if.. 
..it's possible for the intializer to complete normally. This means that you can't only include `throw new <exception name>();` between the curly-braces and nothing else as Java will detect that it's not possible for the initializer to ever complete successfully and throw compile error (`IllegalStateException`). The reason it works in the above example is that the `throw new NullPointerException();` is enclosed within an if clause.


```Java
class Example {
    static {
        throw new NullPointerException();
    }
}
```


    ERROR: java.lang.IllegalStateException: initializer must be able to complete normally

     static { throw new NullPointerException(); }

     ^                                           ^ 


## `ClassNotFoundException` vs `NoClassDefFoundError` 
Both are runtime exceptions relating to a class not being found. The causes are:

`ClassNotFoundException` is thrown when you try to load a class at runtime using `Class.forName()` or `loadClass()` and the requested class is not found in *classpath*. The most common cause is trying to run an application without updating the *classpath* with *JAR* files. It is a *checked* exception that inherits from `java.lang.Exception`.

`NoClassDefFoundError` occurs when a program was compiled successfully but the class is no longer present at runtime. It is an *error* rather than an *exception* and inherits from `LinkageError`.

## floats are not precise to nine significant digits
This means that there will always be a loss of data when casting from float to int if the number has 9 or more digits:


```Java
int i = 123456789;
float f = i;
System.out.println(f);
System.out.println(i);
System.out.println((int) f);
System.out.println(i - (int)f);
```

    1.23456792E8
    123456789
    123456792
    -3





    null



## Overriding methods can change return type to any subclass of original return type
An overriding method can change the return type providing the new return type is a subclass of the return type from the method being overridden (*covariant return type*). This does not apply when the return type of the original method is a *primitive* type (because primitives don't have subclasses).

## The *synchronized* keyword can only be applied to a method or block
This keyword relates to *threads* & *monitors* so you don't need to know the details yet just know that it can only be used with methods or blocks.

## Rules for switch statement
1. Only `String`, `byte`, `char`, `short`,`int` (and their wrapper classes `Integer`, `Short` etc) and `enum` can be used as types of switch variable.
2. The *case* constants must be assignable to the switch variable. E.g. if the variable is `String` then the *case* constants must be `String`.
3. The switch variable must be large enough to hold all the *case* constants. E.g. if the variable is `int` then none of the *case* constants can exceed the max `int` value.
4. All *case* constants should be *compile time constants*. This means they can be *literals* such as `5`, `0.3`, `'x'`, or a `final` variable the value of which is computed at compile time.
5. No two *case* constants can have the same value.
6. Can have 0-1 *default* labels (i.e. none or one).

## `LocalDate`, `LocalTime`, `LocalDateTime` implement `TemporalAccessor` and have no relation to the old `java.util.Date`
It's easy to mistakenly believe that the new Date/Time classes introduced in Java 8 are extension of the old ones (`java.util.Date`, `java.sql.Date`), however, they have no relation. They implement the `TemporalAccessor` interface. Nor do they have any parent/child relationship to each other.

These classes use the calendar system defined in *ISO-8601* as the default calendar (this is based on the Gregorian calendar and is a used globally as a defacto standard). To make use of different calendar systems you can use the `java.time.chrono` package or create your own.

## `LocalDate`, `LocalTime`, `LocalDateTime` are *immutable*
These classes are all immutable and cannot be instantiated directly. To create objects of this type you need to use the static factory methods provided by the classes (e.g. `.of()`).


```Java
import java.time.*;

LocalDate d = LocalDate.of(2028, Month.MARCH, 15);
System.out.println(d);
```

    2028-03-15





    null



## Only `ZonedDateTime` contains time-zone info
The above Date/Time classes do not contain time-zone info. To make use of time-zones you need to use the `java.time.ZonedDateTime` class which is another immutable DateTime class but also records a time-zone with a zone offset used to handle ambiguous local date-times.

## `Duration` and `Period` classes
The `java.time` package, in addition to the above date/time classes, provides the `Duration` and `Period` classes.

`Duration` is used for quantities of time in terms of hours, minutes, and seconds.
<br>`Period` is used for quantities of time in terms of years, months, and days.

__NOTE__: *Duration* and *Period* differ in their treatment of daylight savings time when added to `ZonedDateTime`. A *Duration* will add an exact number of seconds, thus duration of one day is always exactly 24hrs whereas *Period* will add a "conceptual" day treying to maintain the local time.

## The `~` operator only operates on integral types
This is the *bitwise complement* operator which only operates on integral types (i.e. byte, short, char, int, long) and inverts the bits.

## The `&` operator operates on integral and boolean types
The bitwise AND operator copies a bit if it exists in both operands. The specifics of bitwise operators are outside the scope of this exam. Just know that it operates on both integral and boolean types.


```Java
System.out.println(2 & 2);
System.out.println(2 & 1);
System.out.println(445 & 445);
System.out.println(445 & 444);
System.out.println(22 & 22);
System.out.println(true & false);
```

    2
    0
    445
    444
    22
    false





    null



## `Boolean` wrapper class
1. `Boolean` has two constructors:
    - `Boolean(String)`: allocates a Boolean object representing the String value *true* if the string is not `null` and is equal (ignoring case) to `true`. Otherwise allocates object representing `false`.
    - `Boolean(boolean)`: allocates a Boolean object representing the boolean passed in.
2. `Boolean` has two static helper methods for creating booleans:
    - `Boolean.parseBoolean(String)`: returns a primitive boolean of `true` if not `null` and is equal (ignoring case) to *true*, else returns `false`
    - `Boolean.valueOf(String)`/`Boolean.valueOf(boolean)`: return a reference to either `Boolean.TRUE` or `Boolean.FALSE` wrapper objects/static constants (NOT new Boolean objects).
3. When using the equality operator (`==`) with booleans, if exactly one of the operands is a Boolean wrapper, it is first unboxed into a boolean primitive and then compared. If both are Boolean wrappers only their references are compared (as with  other objects).

## The `.equals()` method first checks if the two objects are of the same class
Before unboxing, where applicable, and comparing values the `.equals()` method first checks if the object being passed and the calling object are of the same class. If not, it immediately returns `false`.

## The equality operator (`==`) knows at compile time if it's not possible to compare its operands
If you try to use the `==` to compare two objects of different, unrelated classes you will get a compile error because the operator already knows that its not possible to test the equality of the objects.

## A `private` member can only be accessed within the class it is declared
Instantiating an object of the class does not grant access to private members.

## `package private` aka *default* (no access modifier stated) members can only be accessed from within the same package
So, once again, instantiating an object of the class does not grant access if the class where instantiation is happening is in a different package.

## A `protected` member is inherited by a subclass and is accessible within the subclass...however
Per the Java Language Specification: "*protected members of a class are accessible outside the package only in subclasses of that class and only when they are fields of objects that are being implemented by the code that is accessing them*". In other words, a protected member is accessible in a subclass outside the package only using a reference whose declared type is of the same subclass (or a subclass of the subclass).

This is a tough one to wrap your head around so lets look at some examples:


```Java
// in package com.myexamples
class A {
    protected void sayHello() {
        System.out.println("Hello");
    }
}

// in package come.yourexamples
// import com.myexamples.A;
class B extends A {
    public static void main(String [] args) {
        A a = new A();
        a.sayHello(); // this will not work because:
                      // 1.) class B is in a different package AND
                      // 2.) the reference 'a' is of type A which is not the same type as the class from which we're trying to access the protected member (B)
        
        B b = new B(); // this will work as B is the same type as the class from which we're trying to access the protected member
        
    }
}
```




    com.twosigma.beaker.javash.bkrd8b66df4.A



## In the case of *abstract* methods overriding is the same thing as implementing
The terminology can be a little confusing, in the case of *abstract* methods "implementing" such a method and "overriding" it are effectively the same. Abstract methods are meant to be overridden, they are methods which describe behaviour but don't implement it. So any concrete subclasses extending the abstract class must implement/override the abstract methods.

## A `short`/`char` *variable* can never be assigned to a `char`/`short` without explicit casting
Whereas a `short`/`char` CONSTANT *can* be assigned to a `char`/`short` IF the value fits.

## Although `char` and `short` are both 16-bit, `short` is *signed* and thus is technically "larger"
This is why explicit casting is always needed to convert between the two.

Primitive|Value range
:--|:--
`char` | `0` to `65,535`
`short` | `-32,768` to `32,767`

## A constructor can call *either* `super()` or `this()` but NOT both...
..and whichever is called must be the first line in the constructor.

## REMEMBER: Constructors are NOT inherited
If no constructor is declared the default constructor is implicitly called by Java but that's not the same thing as inheritance.

## Auto-unboxing happens when performing operations on wrapper class Objects 
When trying to perform operations such as `+`,`-`, `*`, `/` on objects of primitive wrapper classes (`Integer`, `Byte`, `Short`, `Long`, `Float`, `Double`) providing the objects are of the same class (or a subclass) *auto-unboxing* will be done automatically to allow the operations.


```Java
Integer i1 = new Integer(1);
Integer i2 = new Integer(2);
int a = i1 + i2; // no issue assigning the addition of two objects since to a primitive var because auto-unboxing converts the wrapper objects to their corresponding primitive
System.out.println(a);
```

    3





    null



## Arrays of length zero are permitted
You can create zero length arrays easily in Java:;


```Java
int [] zeroInts = new int[0];
String [] zeroStrs = new String[0];
System.out.println(zeroInts.length);
System.out.println(zeroStrs.length);
```

    0
    0





    null



## A zero length array is NOT the same as a `null` array
A `null` array is an array reference that has been initialized to `null` (i.e. no object exists in memory) whereas as zero-length array is a valid array Object which just has no items in it.


```Java
int [] zeroInts = new int[0];
int [] nullArr = null;
System.out.println(zeroInts == null);
System.out.println(nullArr == null);
```

    false
    true





    null



## Private methods cannot be overridden in subclasses
Only methods which are inherited can be overridden and since `private` methods are not inherited they cannot be overridden.

## A *functional interface* must have exactly ONE `static` method..
.. and may have other `default` or `abstract` methods


