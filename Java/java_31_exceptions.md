# Exceptions
## What are exceptions?
Exceptions are Java's way of handling errors both expected and unexpected. When something goes wrong during program execution Java will gather some information about the error (when it happened, the location in the code that it occurred, what message was returned) and creates an `Exception` which is *thrown* to the code that invoked the problematic method. 

`Exception` is a class and is the base Java exception (in much the same way that `Object` is the base class from which all others derive). Java has a library of exceptions defined for different scenarios, some common exceptions are:
- `java.lang.ArrayIndexOutOfBoundsException`: thrown when you attempt to acces a nonexistent array index
- `java.lang.ClassCastException`: thrown when attempting to case an object to an illegal type
- `java.lang.NullPointerException`: thrown when attempting to use an object reference which hasn't been instantiated

Additionally, Java allows you to create your own exceptions. For example:


```Java
public class MyCoolException extends Exception {}
```




    com.twosigma.beaker.javash.bkr7441b011.MyCoolException



## Stack trace
A *stack trace* is the output from an error which tells you whereabouts in the code that an error was encountered. A stack trace might look something like this:
<br><br>`Exception in thread "main"`
<br>`java.lang.ArrayIndexOutOfBoundsException: 5`' // name of the exception
<br>&nbsp;&nbsp;&nbsp;&nbsp;`at MyArray.addElement(MyArray.java:19)` // the code that caused the exception is line 19 in MyArray.java
<br>&nbsp;&nbsp;&nbsp;&nbsp;`at MyException.main(MyException.java:20)` // the place where the bad code was called, line 20 of MyException.java

## What does *throw* mean in the context of exceptions?
Java refers to the passing of errors as *throwing*. So, a method might *throw* a certain exception. This comes from the parent-class of `Exception` which is `Throwable`. `Throwable` has three main subclasses:
- `Error`: Usually an unrecoverable external error. This is an *unchecked* exception.
- `RuntimeException`: Usually due to a programming error such as bad syntax. This is an *unchecked* exception.
- `Exception`: A recoverable error. This is a *checked* exception.

## Checked vs Unchecked
An unchecked exception is an exception which doesn't need to be explicitly taken care of by the developer. Java will happily output this kind of error to the user. A checked exception, however, must be either *caught* (handled by special code included by the developer) or *thrown* (explicitly passed to the method which invoked the bad code that code will in turn need to either *catch* or *throw*).

## How to `throw` and `catch` exceptions
Throwing and catching exceptions is done by using the keywords `throw` and `catch`.

### Throwing an exception
If a method is going to throw an exception rather than handle it, the method signature should include `throws` and the exception type that might be thrown.


```Java
package test.beaker;

class ExampleClass {
    public String isThisCool(String input) throws CoolException { // method signature states that this method might throw CoolException
        if (input != "Magic Word") {
            throw new CoolException("This is a cool exception"); // use the "throw" keyword to throw a new instance of CoolException
        } else {
            return "Cool";
        }
    }
}

class CoolException extends Exception {
    public CoolException(String input) {
        super(input);
    }
}
```




    test.beaker.ExampleClass




```Java
package test.beaker;

ExampleClass ec = new ExampleClass();
System.out.println(ec.isThisCool("foo"));
```


    ERROR: test.beaker.CoolException: This is a cool exception


### Catching an exception
In order to catch an exception you need to use a `try/catch` block which looks a little like an if/else:
<br>`try {`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`code that might error`
<br>`}`
<br>`catch (Exception e) {`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`do something with the error`
<br>`}`

The `try` block is where you place the code which might run into problems and cause an error. There are multiple places that you can put the try/catch, for example you could put it inside the method which may have an exception, in which case you wouldn't need to have `throws <Exception>` in the method signature, because you'll be handling it. The `catch` block then receives the error info, providing that the exception type it's expecting is the same or more general than the exception thrown, and performs whatever actions the developer implemented.

Since `Exception` is the base exception, a lazy method is to use `Exception` as the input to `catch` (this is not considered a best practice but can be useful when troubleshooting):
<br>`catch (Exception e) {}` // here we're saying to catch any exception of type `Exception` and save to a variable `e`


```Java
package test.beaker;

class ExTest {
    public void doSomething() {
        try {
            ExampleClass e = new ExampleClass(); // we're going to use the class we defined above to get an exception
            e.isThisCool("foo");
        }
        catch (CoolException ce) { // here we're catching the specific exception CoolException
            System.out.println("Encountered an Exception. Error Message: " + ce.getMessage()); // now we use Exceptions .getMessage() method to print a nice message
        }
    }
}
```




    test.beaker.ExTest




```Java
package test.beaker;

ExTest et = new ExTest();
et.doSomething();
```

    Encountered an Exception. Error Message: This is a cool exception





    null



### Best practices for exception handling
1. Catch the actual exception expected to be thown NOT a superclass.
2. Examine the exception to try recovering cleanly by determining the exact problem.
3. Not all exceptions need to be handled.

### Handling multiple exceptions
What if your code has a risk of throwing various exceptions at different points? Well, you could include separate try/catch blocks at each point where an exception may occur. Or you can include multiple `catch` blocks to code for various possible exceptions. When doing the latter the `catch` blocks should proceed from most specific to least specific.


```Java
class MultiEx {
    public String myMethod() {
        try {
        Object o = new Object();
        }
        catch (IllegalArgumentException iae) { // list the most specific exception first
            System.out.println("Got an Illegal Argument Exception: " + iae.getMessage());
        }
        catch (Exception e) { // then you can code for less specific exceptions
            System.out.println("Got an Exception: " + e.getMessage());
        }
        
    }
}
```




    com.twosigma.beaker.javash.bkr7441b011.MultiEx




```Java

```
