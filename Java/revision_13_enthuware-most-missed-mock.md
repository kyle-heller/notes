# Revision notes from Enthuware Most Missed Mock

## REMEMBER: when accessing methods & member fields/variables via a reference...
...that the methods depend on the type of the __OBJECT__ but the fields/variables depend on the type of the __REFERENCE__.


```Java
package test.beaker;

interface NewFooInterface {
    int fooNum = 0; // 
    public void fooMethod();
}

class NewFooClass implements NewFooInterface {
    int fooNum = 5;
    public void fooMethod() {
        System.out.println("Incrementing fooNum...");
        this.fooNum++;
    }
}
```




    test.beaker.NewFooInterface




```Java
package test.beaker;

NewFooInterface nf = new NewFooClass(); // create a NewFooClass object but assign it to a NewFooInterface reference
nf.fooMethod(); // calling the .fooMethod() calls that method from the NewFooClass object as methods depend on the type of the OBJECT (a NewFooClass object in this case)
System.out.println(nf.fooNum); // printing .fooNum will print 0 since fields/variables depend on the type of the REFERENCE (a NewFooInterface reference in this case)
System.out.println(((NewFooClass)nf).fooNum); // To prove that the fooMethod() call above worked we can cast nf to be NewFooClass and print the fooNum field from the object
```

    Incrementing fooNum...
    0
    6





    null



## Computed strings, string literals, and string constant across packages & classes
Determining whether a string is referring to an existing String object, or a newly created string can be a little tricky especially when you include strings imported from different packages and strings created by concatenating variables & literals. Here are some rules worth remembering:
1. Literal strings in the same class and package represent references to the __SAME__ String object
2. Literal strings in different classes within the same package represent references to the __SAME__ String object
3. Literal strings in different classes in different packages represent references to the __SAME__ String object
4. Strings computed by **constant** expressions (for example by concatenating literals) are computed at compile time and treated as if they were literals
5. Strings computed at __runtime__ are newly created and thus considered NEW
6. Explicitly interning a computed string (using the `.intern()` method) is the same as a String literal (so if that literal already exists then it's the same object and not new).


```Java
package test.beaker;

class StringFoo {
    static String myString = "Hello";
}

class StringFu {
    static String myString = "Hello";
}
```




    test.beaker.StringFoo




```Java
package test.beaker;

String hello = "Hello";
String hel = "Hel";
String lo = "lo";
System.out.println(hello == StringFoo.myString); // TRUE as we're variables holding the same existing string object
System.out.println(hello == StringFu.myString); // TRUE same as above
System.out.println(StringFoo.myString == StringFu.myString); // TRUE same as above
System.out.println(hello == "Hel" + "lo"); // TRUE as we're comparing the variable holding one string object to a concatenation of two literals which results in the same string object
System.out.println(hello == (hel + lo)); // FALSE as we're comparing the result of concatenating to runtime variables which results in a new String
System.out.println(hello == (hel + lo).intern()); // TRUE as we're concatenating the variables BUT using .intern() to compare the literal within
```

    true
    true
    true
    true
    false
    true





    null



## REMEMBER: integral literals with `e` in them are `double`s
Scientific notation `e` in the middle of a large number represents a `double` literal.


```Java
float f = 21e2; // error as 21e2 is a double literal not float
```


    incompatible types: possible lossy conversion from double to float

     float f = 21e2

               ^   ^ 


## REMEMBER: Numbers starting with `0x` are integral literals


```Java
char c = 0x12;
int i = 0x4200;
```




    null



## When working with nested classes you can use `<outer-class>.this.<member>` to access the outer class members from within the inner class
The `this` keyword is often used within a class method to refer to an instance of the class. However, you can in certain cases also combine `this` with the outer class name to refer to an instance of the outer class from within an inner/nested class.


```Java
package test.beaker;

class OuterClass {
    private String s = "Hello";
    
    class InnerClass { // this class is nested within OutClass thus, using the `this` keyword would refer to an instance of InnerClass
        private String s = "World";
        
        String getS() {
            return this.s; // here we use this.<member> to access the private String s
        }
        
        String getOriginalS() {
           return OuterClass.this.s; // this method belongs to InnerClass so how can we access the OuterClass' private String? By using OuterClass.this.<member>
        }
    }
    
    OuterClass() {
        System.out.println( new InnerClass().getS());
        System.out.println( new InnerClass().getOriginalS());
    }
}
```




    test.beaker.OuterClass




```Java
package test.beaker;

OuterClass oc = new OuterClass();
```

    World
    Hello





    null



## Lambda expressions do not create a new scope for variables
This means that if you already have a variable declared within the same scope as your lambda you cannot re-use the same variable name within your lambda expression to refer to a different variable.

## A `finally` block will always execute (unless `System.exit()` is called before execution)
This means that even if your `try`/`finally` is nested within a loop and `break` is called before the `finally` would execute the finally will still complete.


```Java
LOOP: {
    try {
        System.out.println("Inside try");
        break LOOP; // break LOOP within the try block, since the try/catch/finally is nested within LOOP does this prevent finally from execiting?
    }
    catch(Exception e) {
        System.out.println("Inside catch");
    }
    finally {
        System.out.println("Inside finally");
    }
}
```

    Inside try
    Inside finally





    null



## REMEMBER: Implicit narrowing occurs when assigning `int` literals to `short`, `byte`, and `char` providing the int value fits within
This also means that a method with a return type of `byte`, `short`, or `char` can return an `int` literal as long as the value fits within the type it's being returned as.


```Java
class Narrower {
    public byte intToByte() {
        return 4; // 4 here is an int literal but the compiler won't object due to implicit narrowing
    }
    
    public short intToShort() {
        return 64; // 64 here is an int literal...
    }
    
    public char intToChar() {
        return 200; // 200 here is an int literal...
    }
    
}
```




    com.twosigma.beaker.javash.bkr4a6125b5.Narrower



## REMEMBER: When overriding a method, the overriding version of the method must return the __EXACT__ type in the case of primitives
Or, co-variant return types in the case of classes/objects.


```Java
class PrimitiveReturner {
    public long returnLong() {
        return 12L;
    }
}

class PrimitiveOverrider extends PrimitiveReturner {
    public short returnLong() { // will cause a compile error as we're trying to return a different primitive type to the original method
        return 12;
    }
}
```


    ERROR: java.lang.IllegalStateException: returnLong() in com.twosigma.beaker.javash.bkr4a6125b5.PrimitiveOverrider cannot override returnLong() in com.twosigma.beaker.javash.bkr4a6125b5.PrimitiveReturner

      return type short is not compatible with long

     public short returnLong() { return 12; }

     ^                                       ^ 


## String's `.charAt()` method can take a `char`, `short`, or `short` as each will be implicitly promoted to `int`


```Java
String s = "Hello";
char c = 0;
byte b = 1;
short sh = 2;

System.out.println(s.charAt(c));
System.out.println(s.charAt(b));
System.out.println(s.charAt(sh));
```

    H
    e
    l





    null



## REMEMBER: Wrapper-classes constructor will automatically parse a valid string passed
Since the wrapper classes have `.parse<type>()` and `.<type>Value()` (e.g. `.parseInteger()`, `.longValue()`)methods it can be easy to think that you must use one of these when passing a string to a wrapper's constructor but the classes include an overloaded constructor for string arguments and thus you can simply pass a valid string directly to the constructor.

__NOTE__: `.parse<type>()` methods are *static* and can be called directly from the class but `<type>Value()` are *non-static* and thus require an instance.


```Java
int i = new Integer("12");
System.out.println(i);
```

    12





    null




```Java

```
