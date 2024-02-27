# Revision notes from Enthuware Mock Test 7

## If you have an overloaded method that takes either a `Integer` wrapper object or a `long` primitive...
..and you pass an `int` primitive to that method, will Java autobox the `int` to an `Integer` object or will it widen the `int` to make it a `long`?

Well, since *widening* pre-dates the availability of wrapper classes, Java will first try to widen.


```Java
package test.beaker;

class MyFoo {
    public void myMethod(Integer i) { // Integer wrapper method
        System.out.println("Integer wrapper object method!");
    }
    
    public void myMethod(long l) { // long primitive method
        System.out.println("long primitive method!");
    }
}
```




    test.beaker.MyFoo




```Java
package test.beaker;

MyFoo mf = new MyFoo();

mf.myMethod(4); // pass the method an int primitive
```

    long primitive method!





    null



## If a method makes use of a static member but accesses it via an instance...
..the compiler will instruct the JVM to access the static member directly via the class rather than via the instance (which doesn't exist yet during compilation). This means that even if the instance which you're accessing the member via is `null`, you will still be able to make use of the static member.


```Java
package test.beaker;

class ExampleClass {
    static String greet = "Hello";
    static ExampleClass getEx() { // this method returns null
        return null;
    }
}
```




    test.beaker.ExampleClass




```Java
package test.beaker;

System.out.println(ExampleClass.getEx().greet); // works even though we're calling greet on what we know will be a null object at runtime
```

    Hello





    null



## A for loop's expression consists of three parts
1. Initialization: where you declare/initialize the variable to be used for iteration e.g. `int i = 0;`
2. Condition: the test of your variable e.g. `i < 10;`
3. Update: the increment/decrement of your variable e.g. `i++`

The update part of the expression can accept the following statements:
- Assignment
- Preincrement/decrement
- Postincrement/decrement
- Method invocation
- Class instance creation expression

This means that a for loop who's update section calls a method which doesn't return anything will work (though it may cause an infinite loop if you don't increment/decrement your variable elsewhere in the loop.


```Java
for (int i = 0; i < 10; System.out.println("Boop")) {
    i++; // without this we'd enter an infinite loop
}
```

    Boop
    Boop
    Boop
    Boop
    Boop
    Boop
    Boop
    Boop
    Boop
    Boop





    null



## The true/false sections of the `? :` operator must return some value
The `? :` operation looks like this `<some condition> ? <if true> : <if false>;`. The true/false parts must return some value. If for example you try to use `System.out.println()` to print something to the screen depending on what the outcome is, the return will be `void` in both cases since `println` returns nothing.


```Java
int i = 5;
int j = i < 6? System.out.println("Yes"): System.out.println("No");
```


    incompatible types: bad type in conditional expression

        void cannot be converted to int

     int j = i < 6? System.out.println("Yes"): System.out.println("No")

                    ^                        ^                           

    

    incompatible types: bad type in conditional expression

        void cannot be converted to int

     6? System.out.println("Yes"): System.out.println("No")

                                   ^                       ^ 


## REMEMBER: Arrays are objects, and objects are passed by reference
So, if you have a method which takes an array reference and makes some changes to it (e.g. increments an `int` element) the actual array will be updated. However, as with objects if you reassign the reference within the method you're just reassigning the local variable pointing to the reference and not the original.

## REMEMBER: You cannot have two case labels with the same value in a `switch`
In this case the question was a little sneaky in that it used two differently formatted integers (`1_000_000` and `1000000`) so I should have noticed that.

## `Period` manipulates dates in terms of *days*/*months*/*years*. `Duration` manipulates dates in terms of *hours*/*minutes*/*seconds*
This means that `Period` may not take Daylight Savings into account when adjusting a date, whereas `Duration` will.

## `StringBuilder`'s `.toString()` method will always return a new string
So, if you assign the output of `toString()` from the same `StringBuilder` object to two different variables and then compare them using `==` the result will be false (since each call to `toString` created a new String).

## REMEMBER: The dot operator `.` has higher precedence than the cast operator `(<cast>)` 
So anytime you see a dot operation (e.g. the calling of a method) which is dependent upon a cast happening first, the cast must be encased in parens. For example lets imagine the class `Foo` below has variable `greet` containing the string *Hello* but the class `Bar` which is a child of `Foo` sets it's version of `greet` to *Goodbye*:
<br>`System.out.println( (Foo) b.greet );` // will not compile as you're essentially trying to cast the output of *b.greet* (a String) to *Foo*
<br>`System.out.println( ((Foo) b).greet );` // will print *Hello*


```Java
package test.beaker;

class Foo {
    public String greet = "Hello";
}

class Bar extends Foo {
    public String greet = "Goodbye";
}
```




    test.beaker.Foo




```Java
package test.beaker;

Bar b = new Bar();
System.out.println(b.greet);
System.out.println(((Foo) b).greet);
// System.out.println((Foo) b.greet); // uncomment this line to see compile error
```

    Goodbye
    Hello





    null




```Java

```
