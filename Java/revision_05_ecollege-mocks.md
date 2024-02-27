# Revision Notes for eCollege/Skillsoft Mock Exams

## *Top-level* class access modifiers
A "top-level" class, that is any class you define which doesn't inherit/extend another class can only be declared with `<default>` (i.e. no modifier) or `public`. You cannot use *private* or *protected* modifiers (however, you can use them with nested classes and/or subclasses).

## ArrayList's `.remove()` will remove the item at the index passed to it
The `.remove()` method takes an integer argument representing the index of the item to be removed, not the value of the item.


```Java
import java.util.ArrayList;

ArrayList<String> sa = new ArrayList<>();
sa.add("Hello World");
sa.add("0");
sa.add("Foo");
sa.remove(0);
System.out.println(sa);
```

    [0, Foo]





    null



## `java.util.regex.Pattern` class
The `Pattern` class from `java.util.regex` creates a compiled pattern object which represents a regular expression. The pattern object can then be used to a `Matcher` object that can match sequences of characters against the regular expression.

*Pattern* objects aren't instantiated like most classes but use *Pattern*'s `.compile()` static method.

An simple example of using the *Pattern* class to split a string (mirroring the functionality of `String`'s `.split()` method:


```Java
import java.util.regex.Pattern;

String s = "Hello,there,world";
Pattern p = Pattern.compile(",");
String[] sa = p.split(s);
for (String st: sa) {
    System.out.println(st);
}
```

    Hello
    there
    world





    null



## Unboxing/Autounboxing only applies to the primitive wrapper-classes (e.g. `Integer`, `Float` etc)
It's tempting to think that StringBuilder functions like a wrapper classes and will *unbox* the String within when needed (for example if you try to assign a StringBuilder to a String) but you must remember that String and StringBuilder are two different types of Object.


```Java
String s;
StringBuilder sb = new StringBuilder("Hello");
s = sb;
```


    incompatible types: java.lang.StringBuilder cannot be converted to java.lang.String

     s = sb

         ^ ^ 


## `ArrayList` does not have an `.insert()` method
To add an item to an *ArrayList* at a specified index you simply use the `.add()` method and pass an index as the first argument.


```Java
import java.util.ArrayList;

ArrayList<String> al = new ArrayList<>();
al.add("ABC");
al.add("GHI");
al.add(1, "DEF");
System.out.println(al);
```

    [ABC, DEF, GHI]





    null



## The initial capacity of `ArrayList` if no argument is passed to the constructor is `10`
If you create an *ArrayList* using the no-argument constructor, an empty ArrayList with an initial capacity of `10` is created.

## *Interface* methods are assumed to be `public abstract` unless the `default` modifier is used
Whether you specifiy `public abstract` or not when creating methods in an *interface*, they are assumed to be public and abstract unless you use the `default` modifier (in which case you also need to implement the method within the interface).

Keep this in mind for questions on the exam that relate to implementing methods, as you could have an interface method declared simply as:
<br>`void myAbMethod();`

Which might lead you to think implementing the method in a concrete class as `void myAbMethod() {}` would work but remember, you can't specify a more strict access modifier than the method you're overriding/implementing. Since `public abstract` are implicitly present in the interface you would need to implement the method in your concrete class as `public void myAbMethod() {}` or `protected void myAbMethod() {}`.

## REMEMBER:  A variable declared within a loop is only available within the loopIt's quite easy when you're working with a mixture of scopes to forget/overlook this.


```Java
int a = 0;
for (int b = 0; b < 4; b++) {
    a++;
}

System.out.println("a is " + a + " and b is " + b); // b was a local variable declared within the for loop and no longer exists
```


    cannot find symbol

      symbol:   variable b

      location: class com.twosigma.beaker.javash.bkrdb9e8a43.BeakerWrapperClass1261714175Id0041bac53d7f4afda87ae39a4ac8d392

    n("a is " + a + " and b is " + b)

                                   ^^  


## `$` and `_` are valid (if inadvisable) variable/method/class names
Java 8 will not prevent you from using `$` or `_` as identifiers, though the compiler may show a warning, and it's definintely not recommended.


```Java
int $ = 42;
int _ = 1;
System.out.println($*_);
```

    42





    null



## REMEMBER: the lack of an access modifier before a variable/method/class means `default` *package private*
Keep in mind that a method, variable, or class which has no access modifier (e.g. `public`, `private` etc) means that it has `default` access which is *package private*. *Package private* is the second most restrictive access after `private`.

If you see a question on the exam which has clearly marked two classes with specific package names, it's likely that the question includes an element of inter-package access so you should keep that in the forefront of your mind when reading the code.

## A subclass which `implements` an interface that was already implemented in the parent class doesn't necessarily need to implement abstract methods
This one is a little confusing; if you have a subclass which declares that is implementing an interface but the parent class also implemented that interface, the subclass doesn't have to implement any of the abstract methods (since they were already implemented in the parent class). I'm not entirely sure what the point is of implementing an interface in a subclass where the parent-class already implemented it but this is a scenario that came up on the mock test.


```Java
package test.beaker;

interface Foo {
    void bar(); // abstract method "bar"
}

class Parent implements Foo { // parent class
    public void bar() { // "bar" method implemented in Parent class
        System.out.println("I am the bar method"); 
    }
}

class Child extends Parent implements Foo { // Child class which extends Parent but also declares that it implements Foo
    // no implementation of "bar" method, yet no error message (because the parent class already implemented "bar" and that implementation is inherited by Child)
}
```




    test.beaker.Foo




```Java
package test.beaker;

Child ch = new Child();
ch.bar();
```

    I am the bar method





    null



## REMEMBER: Non-static methods cannot be called directly from a static context
This is a frustrating one because it's so basic and yet so easy to overlook/forget. If you have a method which isn't explicitly declared as `static`, trying to directly call the method (i.e. without instantiating an object of the class to which the method belongs) from *a static context* (e.g. from within a static method, for example the *main* method) you will get an error message.


```Java
package test.beaker;

class NoStaticMethods {
    public void nsMethod() {
        System.out.println("I am not static");
    }
}
```




    test.beaker.NoStaticMethods




```Java
package test.beaker;

// each of these cells in beakerX is essentially a main method, so this is a "static context"

NoStaticMethods.nsMethod();
```


    non-static method nsMethod() cannot be referenced from a static context

     NoStaticMethods.nsMethod()

     ^                       ^   


## Execution order for initializers and constructors
As we know, Java has `static` and instance *initializer blocks*. So, what if you have a class with *static initializers*, *instance initializers*, and a *constructor* each of which performs some actions? How do you know which action will happen first?

The order of execution is:
1. static initializer blocks
2. instance initializer blocks
3. constructor

If you have multiple initializers of each type then they execute in the order they appear (e.g. first static block, second static block, first instance block, second instance block etc).

__NOTE__: in the example below the main method's *"When will I print"* will print first but that won't necessarily happen via the command line (e.g. if you have several classes and compile & execute with javac/java), it depends on where the main method is located. For example, if the main method is declared within the top-level class then the main method's prints will run first. However, if the main method is declared inside a non-top-level class then the top-level (and any parent-class) static initializers will execute first.

This can be a tricky one to get your head around I'd suggest writing some code in a .java file to test this and executing via command-line (or an IDE if you prefer) to help get your head around it. Try creating several classes and then moving the main method between the classes to see how it changes the output.


```Java
package test.beaker;

class ExOrder {
    static { System.out.println("STATIC Initializer"); }
    { System.out.println("INSTANCE Initializer"); }
    public ExOrder() {
        System.out.println("CONSTRUCTOR");
    }
    { System.out.println("ANOTHER INSTANCE Initializer"); }
    static { System.out.println("Oh dear....a second STATIC Initializer too?!"); }
}
```




    test.beaker.ExOrder




```Java
package test.beaker;

System.out.println("When will I print?");
ExOrder eo = new ExOrder();
```

    When will I print?
    STATIC Initializer
    Oh dear....a second STATIC Initializer too?!
    INSTANCE Initializer
    ANOTHER INSTANCE Initializer
    CONSTRUCTOR





    null



## Trying to call a non-existant method is a COMPILE time error *not* RUNTIME
If, for example, you have try to call a child-class method using a parent-class reference that will cause a compile time error not a runtime exception.


```Java
package test.beaker;

class NewParent {
    public void doParenting() {
        System.out.println("I am parenting");
    }
}

class NewChild extends NewParent {
    public void doChildStuff() {
        System.out.println("I'm doing childish things");
    }
}
```




    test.beaker.NewParent




```Java
package test.beaker;

NewParent np = new NewParent();
NewChild nc = new NewChild();
np.doParenting();
nc.doChildStuff();
np.doChildStuff(); // notice that there's no output from the above correct method calls, because this is a compile error so no execution has happened
```


    cannot find symbol

      symbol:   method doChildStuff()

      location: variable np of type test.beaker.NewParent

     np.doChildStuff()

     ^              ^   


## Objects created within a function/method and assigned to a variable declared in a method are eligible for gc at completion of method
If an object is created within a method and assigned to a variable defined within a method, the object is then eligible for garbage collection upon completion of the method.

## Watch out for questions about garbage collection where one of the object class fields is a `static` reference
On the mock test there was a question about *garbage collection* where one of the classes had a `static` object reference field. Since static fields are shared by all objects when the rest of the objects references pointed to null, that static field will still be pointing to an object and thus that object is not yet eligible for gc.


```Java
package test.beaker;

class Example {
    static Example ex0;
    Example o;
}
```




    test.beaker.Example




```Java
package test.beaker;

Example ex1 = new Example(); // create a new object and assign to ref "ex1"
Example ex2 = new Example(); // create a new object and assign to ref "ex2"
Example ex3 = new Example(); // create a new object and assign to ref "ex3"
Example ex4 = new Example(); // create a new object and assign to ref "ex4"

ex2.ex0 = ex4; // assigne the "ex0" field to point to the same object as ex4, remember ex0 is a static field so it's shared by ALL objects of class ExampleOne
ex1.o = ex3; // assign ex1's "o" field to point to the same object as ex3
ex2=null; // change ex2 to point to nothing
ex3=null; // change ex3 to point to nothing
ex4=null; // change ex4 to point to nothing

// So how many objects are eligible for garbage collection?
// ANSWER: 1
// 4 objects were created
// ex1 still exists 
// ex2 was changed to null
// ex3 was changed to null but not before the object it pointed to was also assigned to ex1.o. So ex1.o still points to the object created for ex3.
// ex4 was changed to null but not before the object it pointed to was assigned to the static ex0 field
// so 1.) ex1 still exists
//    2.) ex1.o points to the object from ex3
//    3.) ex0 (the static field shared by all objects) still points to ex4
// Since ex1, ex3, and ex4 objects still have valid references the only object eligible for collection is ex2
```




    null



## Arrays are Objects
Remember that in Java all classes at some level inherit from `Object` as that's the ultimate top-level class. This means that you can assign an object of virtually any other class to an `Object` reference.


```Java
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

Object o1 = new int[1]; // assign an array to object ref
Object o2 = new ArrayList<>(); // assign an ArrayList to object ref
Object o3 = new Scanner(System.in); // assign a Scanner to an object ref
Object o4 = LocalDate.of(11, 01, 5); // assign a LocalDate to an object ref
```




    null



## Since arrays are objects, if an object has an array field there are two objects in memory (one for the object and one for the array object within)
This is one to watch out for in *garbage collection* questions. If you have a class which includes an instance field of type array any object of that class will create two objects in memory: the object itself and an array object which is referenced within the object.

## The rules for garbage collecting String literals is the same as other objects...
..namely that the garbage-collector will clear them if it finds them unreachable (i.e. no live/active references pointing to them).

## To be considered "well encapsulated" a getter must return reference to *copies* of mutable objects not the actual object reference
Watch out for questions about whether or not a class is *"well encapsulated"* where one of the class fields is a mutable object like an array or ArrayList. In such cases, to be considered well encapsulated the class, in addition to all the usual encapsulation steps like private fields & setters/getters, should have any getters return a reference to a __copy__ of the mutable object and not a reference to the actual object itself.

The reason being that a mutable object like an ArrayList is still mutable even if declared `final`; all that does is prevent the reference from being reassigned. So if your getter method returns a reference to the actual object, it can still be edited using mutator methods. Thus you should return a reference to a copy of the object not a reference to the actual object.

## Overriding methods which throw exceptions
Remember that if you're overriding a method you can only throw a checked exception of the same type or a subtype of that thrown by the original method. This means you can't throw a more broad/general checked exception but also that you can't throw a checked exception of a type which the original doesn't throw (and thus you also can't throw a checked exception if no checked exception was thrown by the original).


```Java
class Foo {
    public void print() throws NoSuchFieldException { // this exception is a child of Exception
        
    }
}

class Bar extends Foo {
    public void print() throws Exception {} // since the original threw NoSuchFieldException which is a child of Exception, we can't throw Exception here
                                            // as Exception is more broad/general than NoSuchFieldException
}
```


    ERROR: java.lang.IllegalStateException: print() in com.twosigma.beaker.javash.bkr2a2643b9.Bar cannot override print() in com.twosigma.beaker.javash.bkr2a2643b9.Foo

      overridden method does not throw java.lang.Exception

     public void print() throws Exception {} }

     ^                                      ^   



```Java
// same example as above but with the exceptions reversed
class Foo {
    public void print() throws Exception {} // original method throws Exception
}

class Bar extends Foo {
    public void print() throws NoSuchFieldException {} // overriding the original with a child of Exception...no errors
}
```




    com.twosigma.beaker.javash.bkr2a2643b9.Foo



## A switch statement's cases must be *compile-time constants* or *enum* values
The *case* labels in a `switch` must be *compile-time constants* or `enum` values. You can use other values for the switch expression but not the case labels. So, for example you can have String literals as the case labels but not a variable which points to a String literal.


```Java
// switch with string literal label
String s = "Hello";
switch (s) {
    case "Hello":
        System.out.println("Here");
}
```

    Here





    null




```Java
// switch with string variable
String s = "Hello";
switch(s) {
    case s:
        System.out.println("Here");
}
```


    constant string expression required

     case s:

          ^^  


## The Period class takes a character sequences representing the period in question
The format of the character sequence is `P<number of years>Y<number of months>M<number of weeks>W<number of days>D`.

Example|Meaning
:--|:--
`P2Y`| Period.ofYears(2)
`P3M`| Period.ofMonths(3)
`P4W`| Period.ofWeeks(4)
`P5D`| Period.ofDays(5)
`P1Y2M3D`| Period.of(1, 2, 3)
`P1Y2M3W4D`| Period.of(1, 2, 25)
`P-1Y2M`| Period.of(-1, 2, 0)
`-P1Y2M`| Period.of(-1, -2, 0)


```Java
import java.time.Period;

Period p = Period.parse("P12Y");
System.out.println(p.getMonths());
```

    0





    null



## `Runnable` and `Callable` interfaces do not have target types

## List inherits the `.stream()` method from the `java.util.Collection` interface
This method creates a sequential stream using the Collection it was called on as the source.

## Java doesn't have any problem with multiple semi-colons
The JVM will not object if you have a bunch of semi-colons `;` one after the other.


```Java
class MyClass {
    public void myMethod() {;;;;;;;;}
}
```




    com.twosigma.beaker.javash.bkr2a2643b9.MyClass



## A *functional interface* must contain exactly *ONE* abstract method
The interface can contain multiple default methods but can have only ONE `abstract` method.


```Java

```
