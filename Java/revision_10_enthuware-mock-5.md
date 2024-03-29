# Revision notes from Enthuware Mock Test 5

## Inheritance of *state*, *type*, *implementation*
- *Inheritace of state* refers to the inheritance of instance fields/variables.

- *Inheritance of implementation* refers to the inheritance of instance methods.

- *Inheritance of types* refers to Java's ability to inherit from multiple *interfaces* and/or extend from multiple *classes*.

## You cannot throw a checked exception from a `catch` block unless the catch itself is nested within a `try` or...
The method which holds the `catch` is declared to throw the checked exception.


```Java
try {
    throw new Exception();
}

catch (Exception e) {
    throw new Exception();
}
```


    ERROR: java.lang.Exception


## Wrapper class constructors will not automatically convert larger/greater primitives
For example, the constructor for `Short` expects a `short` primitve and will throw an error if you pass an`int` unless you cast it to a `short` first. The principle is the same as when trying to assign an `int` primitive to a `short` variable.


```Java
// Short constructor with an int
Short s = new Short(7);
```


    no suitable constructor found for Short(int)

        constructor java.lang.Short.Short(short) is not applicable

          (argument mismatch; possible lossy conversion from int to short)

        constructor java.lang.Short.Short(java.lang.String) is not applicable

          (argument mismatch; int cannot be converted to java.lang.String)

     Short s = new Short(7)

               ^           ^ 



```Java
// Short constructor with an int cast to a short
Short s = new Short((short)7);
```




    null



## A reference to static field only initializes the class which declares that static field
This is a tricky one; basically if you have a static field which is inherited by a child class and then during program execution that static field is referred to via the child class (e.g. `ChildClass.staticField`) this will NOT cause intialization of the child class since in this case the child class didn't declare the static field (it inherited it).

So, a question about this is testing your knowledge of when/what causes initialization of a class.


```Java
package test.beaker;

class Parent { 
    static { System.out.println("Parent initialized");}
    static String nickName; // we're declaring a static field 'nickName' in the Parent class which will be inherited by any children
}

class Mammy extends Parent { // Mammy extends Parent and so inherits the field 'nickName'
    static {
        System.out.println("Mammy initialized");
        nickName = "Mammy"; // here we're using a static initializer block to set nickName to 'Mammy'
    } 
}
```




    test.beaker.Parent




```Java
package test.beaker;

System.out.println(Mammy.nickName); // prints null

// EXPLANATION: since referencing a static field only initializes the class which DECLARES that field
// only Parent is initialized which is why we see 'Parent initialized' but not 'Mammy initialized'
// Java essentially looks at 'nickName' and sees it is "static" so it goes straight to where it was declared
// and initializes that class so that the 'nickName' field exists. Mammy never gets initialized, thus we never set the value of 
// nickName to 'Mammy'
```

    null





    null



## A `char` holding the value `0` if printed, will print a blank space
If the `char` is cast to an `int` first, it will print `0`


```Java
char c = 0;
System.out.println("char value: " + c);
System.out.println("int value: " + (int)c);
```

    char value:  
    int value: 0





    null



## If a parent class method throws a checked exception and a child's inherited version doesn't...
...if you try to access the child version via a parent reference, even though the overridden version of the method is contained within the object, Java will detect that the parent version of the method throws a checked exception which must be caught or handled.

This sounds more confusing than it is so lets look at an example:


```Java
package test.beaker;

class A {
    protected void m() throws Exception { // this version of m() throws an exception
        System.out.println("I'm the exception throwing method!");
    }
}

class B extends A {
    public void m() { // this version of m() does NOT throw an exception
        System.out.println("I'm the overridden method which doesn't throw an exception!");
    }
}

class Tester {
    public Tester() {
        A a = new B(); // even though this is a B object and thus contains the overridden version of m(), since we've assigned it to an A reference
        try {          // when Java sees we're trying to call m() from an A reference it knows that A's version of that method throws a checked exception
            a.m();     // so we have to either encase it in a try/catch or declare it to be thrown
        }
        catch (Exception e) {}
        // a.m(); // here's a call to a.m() without a try/catch, if you uncomment this line you'll see that it gives a compile error
    }
}
```




    test.beaker.A




```Java
package test.beaker;

Tester t = new Tester();
```

    I'm the overridden method which doesn't throw an exception!





    null



## String's `.replace()` method returns a new String
This is a simple enough one to grasp but easy to overlook. As we know, calling `.replace()` on a string returns a new version of the string it's called on with whatever replacement is passed in. This doesn't change the string it's called on (as strings are immutable) but you can re-assign your string variable to point to the new string returned by `.replace()`.

Since a new string is returned, if you try to compare the output of `.replace()` to another output of `.replace()` (even if the characters are the same )using the equality operator `==` it will return false; as you'd be comparing two new string objects.

__However__, if you compare the original string to the output of `.replace()` but don't actually make any changes via the method it will return `true`.


```Java
String s = "Hello";
String s1 = s.replace('H', 'h'); // s1 = 'hello'
String s2 = s.replace('H', 'h'); // s2 = 'hello'
String s3 = s.replace('o', 'o'); // s3 uses .replace() but doesn't make any changes to the original string
System.out.println("The output of s1==s2: " + (s1 == s2)); // returns false since they're two different string objects
System.out.println("The output of s==s3: " + (s == s3));
```

    The output of s1==s2: false
    The output of s==s3: true





    null



## *CONSTANT* values up to an `int` can be assigned to variables of lesser size (e.g. `short`, `byte`) providing that the value fits
So, assigning an `int` variable to a `short` or `byte` will cause an error *unless* the `int` is `final` (i.e. a constant).


```Java
// a final int (a constant) = NO ERROR
final int i = 85;
short s = i;
```




    null




```Java
// an int variable = ERROR
int i = 85;
short s = i;
```


    incompatible types: possible lossy conversion from int to short

     short s = i

               ^^ 


## Operands of mathematical operators are ALWAYS promoted to *at least* an `int`
So, any time you perform a mathematical operation on an integral type it will be promoted to *at least* an `int`. This means you need to be careful when assigning the outcome of those operations even if you know the outcome would fit into a smaller type (such as `short` or `byte`) Java will have already promoted the operands to at least an `int` and you would need to either assign to an `int` or cast back down to a `byte`/`short`.


```Java
byte b1 = 5;
byte b2 = 2;
byte result = b1 + b2; // Error as you're trying to assign an int to a byte
```


    incompatible types: possible lossy conversion from int to byte

     byte result = b1 + b2

                   ^      ^ 



```Java
byte b1 = 5;
byte b2 = 2;
byte result = (byte)(b1+b2); // casting the result of the operation (note the parentheses) to a byte works
```




    null



## Compount assignment operators (`+=`, `*=` etc) have an internal cast to the original type
So, when you do `variable1 *= variable2` the operation is equivalent to `variable1 = (variable1-type)(variable1 * variable2)`. This can have unexpected results if you're not mindful.


```Java
short s = 1;
s *= 20.57; // this is equivalent to: s = (short)(s * 20.57) so the result will automatically be cast back to a short
System.out.println(s);
```

    20





    null



## REMEMBER: A `ClassCastException` is a `RuntimeException` NOT a compile-time error
This is something I seem to struggle to remember; if you try to cast an object of class `A` to a `B` type where `B` is a child of `A`, you will get a `java.lang.ClassCastException` which is a `Runtime` exception NOT a compile-time error.


```Java
package test.beaker;

class A {}
class B extends A {}
```




    test.beaker.A




```Java
package test.beaker;

A a = new A();
B b = new B();
b = (B) a; // we're trying to fit an A-type object into a B-type reference, if the object was a B-type assigned to an A reference casting it to a B would work
```


    ERROR: java.lang.ClassCastException: test.beaker.A cannot be cast to test.beaker.B



```Java
package test.beaker;

A a = new B();
B b = (B) a; // casting here works because the inner object is already B-type, it's just assigned to an A reference
```




    null



## `StringBuilder` does NOT have a `trim()` method
`.trim()` is a `String` method, not `StringBuilder`.

## Watch out for sneaky questions that include confusing or bad code but nest it within a loop that will never be executed
Be careful to examine the conditions of any loop to ensure it will actually execute before making any determinations about the code within the loop. A question may include code which will definitely throw an exception but nest it within a `while` loop that never executes and thus no exception is thrown.


```Java
package test.beaker;

class Dodgy {
    static int sint = 4;
    public Dodgy() {
        while(sint > 5) {
            throw new ArithmeticException();
        }
        System.out.println("No exception");
    }
}
```




    test.beaker.Dodgy




```Java
package test.beaker;

Dodgy d = new Dodgy();
```

    No exception





    null



## The exam may include a question which asks you about how an existing program could be changed to fit new requirements
Be mindful that such a question may be asking you to make a judgement about whether such revisions to an existing program would break other programs which make use of the code. So, you be given a piece of code and asked *how could you change the output of X without causing problems for other existing programs that make use of the code?*. In such a case the correct answer *may* be that you can't accomplish the goal, particularly if the desired outcome requires making previously `public` fields/methods `private`.

## Be mindful of parentheses placement when casting floating-point numbers
This is simple enough but worth keeping in mind, that the outcome of an operation can vary widely depending on the placement of parentheses when casting floating-point numbers.


```Java
float f = 5.4f;
double d = 12.7;

int a = (int) f + (int) d; // here we're casting the values of 'f' and 'd' to int BEFORE the operation which means 5 + 12 and that
System.out.println(a);

int b = (int)(f + d); // here we're casting the output of 'f + d' to an int which means 5.4 + 12.7 = 18.1 then casts to 18
System.out.println(b);
```

    17
    18





    null



## A `break` without a label always breaks the innermost loop
Simple but worth repeating.

## REMEMBER: Chained `if` and `else` act like opening and closing braces
Any `else` is automatically assumed to pair with it's closest un-elsed `if` working outward from the innermost pair. So, if you chain multiple `if`/`else` just be mindful that each `else` acts as a closing brace for the previous un-closed `if` and works from the innermost nested pair outward.


```Java
boolean bool = true;

if (bool)
if (bool)
System.out.println("SECOND If"); // I execute if both IFs are true
else
System.out.println("Else for SECOND If"); // I can never be reached
else
System.out.println("Else for FIRST If"); // I execute if the FIRST If is false
```

    SECOND If





    null



## When instantiating objects of a child class there is always an implicit call to `super()` inserted by the JVM
Even when you define a constructor for your child object and don't explicitly call `super()`, Java will automatically insert such a call for you. This is why it's important to be mindful of whether or not a super-class has a no-argument constructor (if not you need to make sure to explicitly call `super()` with the required arguments).

## When casting an object you are telling the compiler that at runtime the object will refer to an object of the type being cast
The compiler will check if it's __possible__ for the object in question to be of the type in your cast (i.e. that they are related), however, since no objects have been instantiated at compile-time there's no way to know for certain; it's possible that at runtime the object in question won't actually be the type you said it would and the result is a `ClassCastException`.

If the compiler can tell that the cast in question is never possible because it's not possible for the object being cast to be of the type it's casting to, then you'll get a compiler error.


```Java
package test.beaker;

class Super {}

class Sub1 extends Super {}

class Sub2 extends Super {}
```




    test.beaker.Super




```Java
package test.beaker;

// Example where it passes compile but throws an error at runtime

Super sup = new Super();
Sub1 sub1 = new Sub1();
Sub2 sub2 = new Sub2();

sub1 = (Sub1) sup;
```


    ERROR: java.lang.ClassCastException: test.beaker.Super cannot be cast to test.beaker.Sub1



```Java
package test.beaker;

// Example where it fails at compile time
Super supAgain = new Super();
Sub1 sub1Again = new Sub1();
Sub2 sub2Again = new Sub2();
sub1Again = (Sub2) sub2Again;
```


    incompatible types: test.beaker.Sub2 cannot be converted to test.beaker.Sub1

     sub1Again = (Sub2) sub2Again

                 ^               ^ 


## `Booleab.TRUE` and `Boolean.FALSE` are *constant* wrapper OBJECTS
So, if a method returns either of these it is return a Boolean object not the primitive values `false` or `true`.

## Wrapper class' `.parse<type>()` methods return primitives not objects
The `.valueOf()` method will return an object of the wrapper type but the `parse` methods simply return the primitive value of the argument passed.

## When accessing fields/variables via an object, it is the type of the *reference variable* that you need to pay attention to
Unlike instance methods which are determined by the *object type*, data (fields/variables) is determined by the type of the *reference variable* which is pointing to the object.


```Java
package test.beaker;

class Balloon {
    boolean willFloat = false;
    
    public String letGo() {
        return "Sinks to ground";
    }
}

class HeliumBalloon extends Balloon {
    boolean willFloat = true; // hides the willFloat variable IF ACCESSED VIA a HeliumBalloon REFERENCE
    
    public String letGo() { // overrides the letGo() method if access via a HeliumBalloon OBJECT
        return "Floats away";
    }
}
```




    test.beaker.Balloon




```Java
package test.beaker;

Balloon b1 = new HeliumBalloon();
System.out.println("\nBalloon ref + HeliumBalloon obj:");
System.out.println("Will I float... " + b1.willFloat + "\nLet's try... " + b1.letGo());

HeliumBalloon b2 = new HeliumBalloon();
System.out.println("\nHeliumBalloon ref + HeliumBalloon obj:");
System.out.println("Will I float... " + b2.willFloat + "\nLet's try... " + b2.letGo());

Balloon b3 = new Balloon();
System.out.println("\nBalloon ref + Balloon obj:");
System.out.println("Will I float... " + b3.willFloat + "\nLet's try... " + b3.letGo());
```

    
    Balloon ref + HeliumBalloon obj:
    Will I float... false
    Let's try... Floats away
    
    HeliumBalloon ref + HeliumBalloon obj:
    Will I float... true
    Let's try... Floats away
    
    Balloon ref + Balloon obj:
    Will I float... false
    Let's try... Sinks to ground





    null



## None of the wrapper classes have a no-argument constructor
They all expect an agument to be passed when creating a new object.

## REMEMBER: `null` can always be passed where an object argument is expected
This means that if you have an overridden method with several versions expecting an object argument and you pass `null` to the method, since several version can accept `null` the most specific version will be used.


```Java
package test.beaker;

class SpecificityExample {
    public void exMethod(Object o) {
        System.out.println("I expect an object, which is the ultimate parent class and thus I'm the LEAST specific method");
    }
    
    public void exMethod(java.io.IOException io) {
        System.out.println("I expect an IOException object which is more specific than object");
    }
    
    public void exMethod(java.io.FileNotFoundException fnf) {
        System.out.println("I expect a FileNotFoundException which is more specific than IOException and thus I'm the MOST specific method");
    }
}
```




    test.beaker.SpecificityExample




```Java
package test.beaker;

SpecificityExample se = new SpecificityExample();
se.exMethod(null);
```

    I expect a FileNotFoundException which is more specific than IOException and thus I'm the MOST specific method





    null




```Java

```
