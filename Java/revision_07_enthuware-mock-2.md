# Revision notes from Enthuware Mock Test 02

## Switch statements can't use booleans for the expression or case label
Switch statements can use:
- `byte`
- `short`
- `char`
- `int`
- `enum`
- `String`
- `Character`
- `Byte`
- `Short`
- `Integer`

## Pre-increment/pre-decrement operation doesn't supercede prior invokations of the incremented/decremented variable in a left-to-right expression
If you have an expression performing multiple operations of equal value and one of the operations is a pre-increment/decrement, the increment/decrement operation will happen when it is reached (i.e. it doesn't change the value of the variable its operating on until it is reached when moving from left to right).

Lets look at an example:


```Java
int a = 2;

int b = a + a + (a * a) + ++a;
// so, does the pre-increment of a impact the earlier references to a in the expression? i.e. will it be 2 + 2 + (2 * 2) + 3 [OUTPUT: 11] or 3 + 3 + (3 * 3) + 3 [OUTPUT: 18]?
// the order of the operations will be
// 1. parentheses (since parens have precedence)
// 2. the rest of the operations are all addition, so they have the same precedence and will execute left-to-right
System.out.println(b);
```

    11





    null



## `private` members of a class can be accessed from within the same class
So, if you have a `private` member variable being access appropriately from within a *main method* that is inside the same class the variable was declared in, it will not cause an error.


```Java
// will not execute normally since we're inside a beaker cell but also won't throw any errors
package test.beaker;

class Foo {
    private int i = 0;
    
    public static void main(String [] args) {
        Foo f = new Foo();
        f.i = 2; // access the private variable via an instance of Foo from within the main method
        System.out.println(f.i);
    }
}
```




    test.beaker.Foo



## `.getClass()` always returns the class of the object on which it's called regardless of the type of the reference pointing to it
For example if you have a `String`-object which is being pointed to by an *Object*-type variable and call `.getClass()` on it, you will get `java.lang.String`


```Java
Object o = new String("Hello"); // String-type object assigned to an Object-type reference
System.out.println(o.getClass()); // call getClass on the reference
```

    class java.lang.String





    null



## You cannot use `==` to compare objects of unrelated classes
Java will know at compile time that the two objects can never be equal since they're of different, unrelated classes and it will throw a compiler error. You can, however, use the `.equals()` method to compare objects of different, unrelated classes (it will return `false`, but it's still a valid, executable piece of code).


```Java
// compare unrelated objects with ==
int [] ia = {1, 2};
String s = "Hello";

System.out.println(ia == s);
```


    incomparable types: int[] and java.lang.String

     System.out.println(ia == s)

                        ^      ^  



```Java
// compare unrelated objects with .equals()

int [] ia = {1, 2};
String s = "Hello";

System.out.println(ia.equals(s));
```

    false





    null



## `java.lang.Number` is not `final` and can be extended
The wrapper classes `Integer`, `Long`, `Double` etc extend `Number` (however, those classes are themselves `final`).

The following are `final` classes:
- `String`
- `StringBuilder`
- `StringBuffer`
- `Boolean`
- `Integer`
- `Long`
- `Short`
- `Character`
- `Byte`
- `Float`
- `Double`
- `System`

## A labeled *break* or *continue* must always exist within the loop where the label is declared
You can't break a labeled-loop from outside the loop.


```Java
int i = 0;
LABEL1:
    for (; i < 5; i++) {
        System.out.println("Inside LABEL1");
        LABEL2:
            System.out.println("Inside LABEL2");
    }
if (i>3) {
    System.out.println("Breaking LABEL1 from outside");
    break LABEL1;
}
```


    undefined label: LABEL1

     break LABEL1;

     ^            ^ 


## When assigning object reference variables to an array the object is passed by reference (similar to passing an object as a method argument)
So, if you create an array and add to it using a reference-variable, you're actually just storing the reference/pointer not the variable itself. This means that if you redirect the reference variable outside the array to point to another object, the array index will still point to the original object.


```Java
String s = new String("Hello"); // create object and assign to variable o1

String [] sa = new String[3]; // create object array
sa[0] = s; // assign array index 1 to point to the same object as o1

s = null; // redirect o1 to point to null

System.out.println(s); // s now contains null
System.out.println(sa[0]); // sa[0] still contains the reference to the original String object
```

    null
    Hello





    null



## An overridden method will still supercede the original even if called from within the constructor of the original class
Let's say we have a class *X* which has a *greet()* method that prints "Hello". Then we have a class *Y* which overrides *X*'s *greet* method to say "Hi". Within *X*'s constructor the *greet* method is called. If we create a new instance of *Y* the implicit call to `super()` will execute *X*'s constructor and call *greet()*, however, since this is all being done from instantiation of a *Y* object, the overridden version of *greet()* will be used.


```Java
package test.beaker;

class X {
    public void greet() {
        System.out.println("Hello"); // X's version of greet says "Hello"
    }
    
    public X() {
        greet();
    }
}

class Y extends X {
    public void greet() {
        System.out.println("Hi"); // Y's overridden version of greet says "Hi"
    }
}
```




    test.beaker.X




```Java
package test.beaker;

Y y1 = new Y(); // instantiate a new Y object which implicitly calls `super()` which in turn calls `greet()`
// OUTPUT: Hi
// even though the call to greet() was within X's constructor, the fact that we got it from a Y instantiation causes the overridden version of greet() to be executed
```

    Hi





    null



## If a constructor makes use of a static or instance variable which hasn't yet been initialized, the default value will be used
This sounds pretty straightforward but is easy to overlook when dealing with multiple classes. First, imagine we have class *One* and class *Two* where *Two* extends *One* and overrides a method within. Now let's say that *One*'s constructor includes a call to the method that's been overridden AND that the overridden method makes use of an instance variable from *Two*. So, we know from the example above that if we instantiate an object of *Two* there will be an implicit call to `super()` and the overridden method will be used but what's easy to overlook is that even though this is being triggered by instantiation of an object of type *Two*, execution hasn't actually gotten to *Two* yet (it's still within the call to `super()` i.e. *One*'s constructor). Since no instance of *Two* exists yet, no instance variables have been initialized and thus the default value for whatever type of variable it is (i.e. `0` for an int, `null` for an Object etc) will be used.


```Java
package test.beaker;

class One {
    public String dance = "mashed-potato";
    public One() {
        dance();
    }
    
    public void dance() {
        System.out.printf("the %s!", dance);
    }
}

class Two extends One {
    public String newDance = "alligator";
    public void dance() {
        System.out.printf("Do the %s!", newDance);
    }
}
```




    test.beaker.One




```Java
package test.beaker;

Two t1 = new Two();
// since we're instantiating a Two object the overridden version of dance() is used
// however, the overriden version of dance uses the variable newDance which is an instance variable for objects of type Two
// but no objects of Two exist yet! We're in the process of creating one but the constructor hasn't gotten as far as Two instantiation yet
// it's still working through the implicit call to `super()`
```

    Do the null!




    null



## An object of a class that implements an interface can be cast to a reference of that interface
This sounds like gibberish but what it means is, if you have an object of type *Car* and the *Car* class `implements` *Automobile* then you can create a *Car* object and then assign that object to an *Automobile* type reference


```Java
package test.beaker;

interface Automobile {}
interface TurboEngine {}

class Car implements Automobile {}

class SuperCar extends Car implements TurboEngine {}
```




    test.beaker.Automobile




```Java
package test.beaker;

SuperCar sc = new SuperCar(); // create a SuperCar object

Automobile a = sc; // SuperCar fits inside an Automobile because it "is a" Car which itself implements Automobile

TurboEngine te = (TurboEngine) a; // this is the interesting one, even though Automobile and TurboEngine aren't related, we can cast a to a TurboEngine
// this works because the object that a is pointing to is a SuperCar which implements TurboEngine
```




    null



## Numbers with scientific notation for Euler's number `e` are always of type `double` in Java
The scientific notation `e` represents *times 10 raised to the power of*. So, `23e4` means *23x10^2* or *23x10x10*. This notation is often used for abbreviating extremely large numbers so Java assumes that this notation represents a `double`. This means that even if you have a fairly small number like *2e2* which would easily fit inside an `int` or `float` it's still assumed to be a double.


```Java
System.out.println(2e2);
```

    200.0





    null



## A number starting `0` is *Octal* and is considered an `int`, a number starting `0x` is *Hexadecimal*
Octal, Hexadecimal, Decimal, Binary are all integers in Java. 


```Java

```
