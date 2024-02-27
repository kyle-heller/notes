# Revision Notes from Module 5 Quiz
These are revision notes specific to questions on the eCollege Module 5 quiz

## Remember: You cannot access a non-static method/variable from a static context
Static methods/variables exist on the class itself and do not belong to any specific instance. You can access static methods/vars from an instance method but you cannot do the reverse (since static methods/vars live on the class and its possible to use them without ever instantiating an object, instance methods/vars are effectively invisible to static/class methods/vars).


```Java
package test.beaker; // required for beakerx magics

public class Foo {
    private int myNum = 0; // instance variable
    private static int yourNum = 1; // static variable
    
    public int getMyNum() { // instance method
        return this.myNum;
    }
    
    public static int getYourNum() { // static method
        return yourNum;
    }
}
```




    test.beaker.Foo




```Java
// ACCESS STATIC FROM NON-STATIC (INSTANCE)
package test.beaker; // beakerx magic

Foo f1 = new Foo(); // create an instance
System.out.println("Calling static method from an instance: " + f1.getYourNum()); // call static method from instance
System.out.println("Calling static method from the class: " + Foo.getYourNum()); // call static method from class
System.out.println("Calling a non-static method from an instance: " + f1.getMyNum()); // call non-static method from instance
```

    Calling static method from an instance: 1
    Calling static method from the class: 1
    Calling a non-static method from an instance: 0





    null




```Java
// ACCESS NON-STATIC FROM STATIC
package test.beaker; // beakerx magic

Foo.getMyNum(); // access non-static method from static context (i.e. the class)...will throw an error,
```


    non-static method getMyNum() cannot be referenced from a static context

     Foo.getMyNum()

     ^           ^   


## Labels are not permitted within method signature
*Labels* in Java allow you to add a user-defined label to a looping construct which allows you to user `break <label>;` or `continue <label>;`. This can give you some more fine-grained control when nesting loops. However, you cannot use labels as part of a method signature or to simply label a method (though you can use labels inside a method).

## Wrapper classes for primitives are subclasses of `Object`
It's worth repeating that wrapper classes for primitives (e.g. `Integer` for `int`, `Float` for `float`, `Boolean` for `boolean`) are subclasses of Java's `Object` class. This means that autoboxing will allow a constructor which expects an Object argument to accept a primitive (as the primitive will be autoboxed to it's wrapper class, which is recognized by the constructor as an object).


```Java
package test.beaker; // beakerx magic

public class WrapperTest {
    public WrapperTest(Object o) { // constructor which expects an object
        System.out.println("I have received an object");
    }
    
    public WrapperTest(int i) { // constructor which expects an int
        System.out.println("I have received an int");
    }
}
```




    test.beaker.WrapperTest




```Java
package test.beaker; // beakerx magic

WrapperTest wt1 = new WrapperTest(5);
WrapperTest wt2 = new WrapperTest(false);
WrapperTest wt3 = new WrapperTest(0.5f);
WrapperTest wt4 = new WrapperTest(6.4);
```

    I have received an int
    I have received an object
    I have received an object
    I have received an object





    null



## Watch out for instance initializers immediately after a static initializer
Exam questions may ask you to determine a specific output which is defined by the time that different initializers run:
- static initializers run once when the class is first loaded
<br>`static {}`
- instance initializers run every time an object is instantiated __BEFORE__ the constructor
<br>`{}`
- constructor runs every time an object is instantiated __AFTER__ instance initializers

It can be easy to mistakenly see an instance initializer which is immediately after a static initializer as part of the static initializer, like this:


```Java
public class Hello {
    public static String msg = "Hello"; // static variable
    int number = 0; // instance variable
    float decimal = 0.0f; // instance variable
    {
        number++; // first INSTANCE initializer block
    }
    static
    {msg = msg + " World!";} // this is the STATIC initializer
    {decimal = 1.5f;} // this is another INSTANCE initializer
}
```




    com.twosigma.beaker.javash.bkr6eba67e1.Hello



## `static final` variables must be set exactly once
If there are `static final` variables in a class, they must be set __ONCE__ (and only once) in the declaration line or a static initializer block. If you fail to initialize a `static final` variable in either location the compiler will throw an error.


```Java

```
