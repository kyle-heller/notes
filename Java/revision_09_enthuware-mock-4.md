# Revision notes from Enthuware Mock Test 4

## Chained assignment works in Java but chained initialization does not
Java allows you to assign multiple variables to the same value in a single line like this:
<br>`a = b = c = 5;`

However, it doesn't allow chained initialization:
<br>`int a = b = c = 5;`


```Java
int a, b, c;
a = b = c = 5;
System.out.println(a + " " + b + " " + c);
```

    5 5 5





    null




```Java
int a = b = c = 5; // will error out
```


    cannot find symbol

      symbol:   variable b

      location: class com.twosigma.beaker.javash.bkr6728cae8.BeakerWrapperClass1261714175Id7521dca12c714cef98ac7bae4468b798

     int a = b = c = 5

             ^^         

    

    cannot find symbol

      symbol:   variable c

      location: class com.twosigma.beaker.javash.bkr6728cae8.BeakerWrapperClass1261714175Id7521dca12c714cef98ac7bae4468b798

     int a = b = c = 5

                 ^^     


## `final` variables can be *hidden* in subclasses
It's possible to hide `final` variables in a subclass.


```Java
class One {
    final int num = 1;
}

class Two extends One {
    int num = 2;
}
```




    com.twosigma.beaker.javash.bkr6728cae8.One



## `isArray()` is a class method which returns `true` if the class is an Array
You can call `isArray()` on a class to get a boolean which confirms whether or not the class it's called on is Array. This method will not work if called directly on an array object.


```Java
int [] ia = {1, 2, 3};
System.out.println(ia.getClass().isArray());

Object o = new Object();
System.out.println(o.getClass().isArray());
```

    true
    false





    null




```Java
int [] ia = {1, 2, 3};
System.out.println(ia.isArray());
```


    cannot find symbol

      symbol:   method isArray()

      location: variable ia of type int[]

     System.out.println(ia.isArray())

                        ^         ^    


## `final` is an acceptable modifier for the *main* method and will not interfer with execution
`final` when used on a method means that the method cannot be overridden (though it can still be hidden). Making a `static` method `final` prevents a subclass from implementing the same static method. So, when used with the *main* method, there's essentially no effect:


```Java
package test.beaker;

class Foo {
    public final static void main(String [] args) {
        System.out.println("This is the main method");
    }
}
```




    test.beaker.Foo




```Java
package test.beaker;

Foo f = new Foo();
```




    null



## `ArrayList` implements `RandomAccess`
`RandomAccess` is an interface used by *List* implementations to indicate they support fast random access.

## `ArrayList` allows you to access it's elements in a random order
Since you can access any element by it's index using the `.get();` method.

## The use of the word `super` to access the members of a parent class only works for classes
Thus if you try to use `super.methodName();` to access an *interface* method it won't work (it would work to access a parent class' method). If you want to access a method from an interface you need to prefix `super` with the interface name: `<interface name>.super.<method name>`. However, this can only be done if the class you're trying to access it from directly implements the interface in question.

## It's possible/acceptable to redeclare an implemented method as `abstract` in an abstract class or sub-interface
Java will not object if you redeclare a default or concrete method as abstract in an abstract subclass or subinterface, it just means that any concrete class which extends/implements the class/interface that redeclared the method will need to reimplement it.


```Java
interface Baby {
    public default String hello() {
        return "Hello";
    }
}

interface Toddler extends Baby {
    public String hello(); // redeclare the "hello" method as abstract within an subinterface
}

abstract class AnotherBaby implements Baby {
    public abstract String hello(); // redeclaring the "hello" method as abstract within an abstract class
}

class Child implements Toddler {
    public String hello() {
        return "Hiya";
    }
}
```




    com.twosigma.beaker.javash.bkr6728cae8.Baby



## REMEMBER: The *default* no-args constructor is not automatically provided if the class defines it's own >0 args constructor
Since the default no-args constructor implicitly calls `super()` it's tempting to think that any constructor you define will include an implicit call to `super()` but that's not the case. If you define a constructor for your class with >0 args then there will NOT be a default no-args constructor automatically provided which also means no implicit call to `super()` unless you explicitly call it within your defined constructor.

## A `return` in a `finally` block supercedes a `return` in `try`/`catch` blocks
If a try/catch has a `finally` block associated with it and there is a `return` in either/both the try/catch AS WELL AS in the `finally`, the return in the `finally` block will supercede the others as `finally` is always the last thing executed in a try/catch/finally and is executed before anything is returned.


```Java
try {
    return "Hello";
}
catch(Exception e) {}
finally {
    return "Goodbye";
}
```




    Goodbue




```Java
try {
    throw new Exception();
}
catch(Exception e) {
    return "Oh well";
}
finally {
    return "Goodbye";
}
```




    Goodbue



## `System.gc()` is equivalent to `Runtime.getRuntime().gc()`
May not come up in the exam but it's worth knowing that if you see `Runtime.getRuntime().gc()` it is equivalent to calling `System.gc()`; both ask the JVM to perform garbage collection, however, there's no guarantee that the JVM will do so.

## Variables cannot be `abstract` or `native`
These modifiers can only be used for member methods.

## REMEMBER: A switch statement can take `byte`, `char`, `short`, `int`, and `String`
Permitted types are:
- `byte` 
- `char`
- `short`
- `int`
- `String`
- `enum`
- `Byte`
- `Character`
- `Short`
- `Integer`

The following are __NOT__ permitted in a switch:
- `long`
- `float`
- `double`
- `boolean`
- `Long`
- `Float`
- `Double`
- `Boolean`

## Each *case label* in a *switch* must be assignable to the same *type* as the *switch variable*
The compiler will throw an error if you try to use a case label which cannot be assigned to a reference type matching the *switch variable*. For example, if you are using a switch with a `byte` type variable and try to use a `boolean`, `float`, `double`, `String`, or an integer value which is outside the permitted range for a `byte` (-128 to 127), you will get a compiler error.

## You don't need to know the specific integral value that a character represents
However, it's worth remembering that all English language characters (both upper and lowercase) are below the 127 maximum value allower by a `byte`

## A `do`/`while` loop cannot take instantiation or increment within the while condition
Unlike a `for` loop, you cannot put instantiation or increment/decrement between a `while`'s parentheses; it will only accept a `boolean` or an expression that evaluates to a `boolean`.

## While you can use empty curly braces assign an empty array to an array ref variable AND arrays are objects...
..an empty set of curly braces alone is not a valid object itself.

So, while `int [] ia = {};` is a valid way to create an empty array and assign to the reference `ia`.

Doing `Object [] oa = { new Object(), "string", {}, new Integer(5)};` will throw a compiler error as `{}` alone is not a valid object.


```Java
int [] ia = {};
```




    null




```Java
Object [] oa = {new Object(), new Integer(5), "Hello", {}};
```


    illegal initializer for java.lang.Object

    ct(), new Integer(5), "Hello", {}}

                                   ^ ^  


## A constructor can take the same type as itself as an argument
It seems a little confusing, but a constructor can take an object of the type the constructor creates as an argument.


```Java
package test.beaker;

class Example {
    
    public Example() {}
    
    public Example(Example ex) {
        System.out.println("I'm the example class constructor");
    }
}
```




    test.beaker.Example




```Java
package test.beaker;

Example e1 = new Example();

Example e2 = new Example(e1);
```

    I'm the example class constructor





    null



## A constructor _CANNOT_ be  `final`, `static`, or `abstract`
While a constructo CAN be `public`, `private`, `protected`, and `<default: package private>`, it *CANNOT* be `final`, `static`, or `abstract`.

## REMEMBER: The condition of a `while`/`do while` loop is evaluated on each iteration
This means that if there's an assignment within the parens, it will be reassigned on each loop (providing the assignment returns a `boolean`).


```Java
boolean bool = false;
int i = 5;
do{ // remember a do while loop always executes it's code block at least ONCE
    i-- ;
    System.out.println(bool);// first loop, prints: false. second loop prints: true
} while (bool = !bool); // sets the value of bool to it's opposite on each loop: 1st loop sets to "true" causing the loop to repeat, 2nd loop sets to "false" ending the loop
System.out.println(b); // after loop as finished we see the value printed is: false
System.out.println( i );
```

    false
    true
    false
    3





    null



## REMEMBER: A `double`/`float`/`long` cannot be assigned to an `int` without an explicit cast
Even if you're using `Integer`'s `.parseInt()` method, you cannot assign a `float`, `double`, or `long` value to an `int` variable.


```Java
int i = (int) 4.3;
int j = (int) 71.5f;
int k = (int) 2000d;
```




    null




```Java
int l = Integer.parseInt("2.5");
```


    ERROR: java.lang.NumberFormatException: For input string: "2.5"


## A date/datetime parsing exception is a *runtime* expression
The date/time related classes throw a `java.time.DateTimeException` which extends `RuntimeException`.


```Java

```
