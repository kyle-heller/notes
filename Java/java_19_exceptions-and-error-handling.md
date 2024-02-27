# Exceptions and Error Handling in Java
Exceptions are pre-defined error messages that most languages include. When executing complex code which is likely to encounter errors it's beneficial to have a way of handling such errors. In particular you want to:
1. Obtain info about why the error occurred
2. Supply the user with a useful message

When an exception occurs we say it has been "*thrown*" and in Java the throwing of an exception creates an object which can be passed to a __catch__ block (that's a piece of code designed to be run if a specified error is thrown, it allows you more control over execution). In Java there are three main types of objects which can be *thrown* and all are derived from a superclass `Throwable`:
- `Error`: these are typically external, unchecked errors and are automatically thrown to the calling method
- `RuntimeException`: normally caused by programming mistakes (typos, missing syntax etc), these are also unchecked and automatically thrown to the calling method
- `Exception`: these errors must be checked which means the exception must be explicitly thrown to the calling method or caught by a `try`/`catch` block

A throwable is the only object type which can be used as an argument in a `catch` clause and the only object type that can be "throw" to the calling method.

## The call stack
The "call stack" is a sequence of methods each triggered by the previous method. For example, lets say you have a `main` method which calls a `sayHello` method. The `sayHello` method calls an `preferredGreeting` method in turn calls an `obtainName` method and so on. This sequence from origin point to endpoint is the __call stack__. Each method call returns its result to the method that called it. So `obtainName` passes its return back to `preferredGreeting` which returns to `sayHello` etc.

If an exception is not __caught__ it will be passed up the call stack in much the same way that a successful execution's result would be albeit with an exception object. If an exception *is* caught it will be thrown to the applicable catch block rather than running back up the call stack.

## Where should exceptions be handled?
It's good practice to handle exceptions in the method in which they occur since the calling method may not be eqipped to do so. Since exceptions can't be ignored they need to be either handled within the method that threw it or elsewhere in the call stack (otherwise the program will stop).

## How to handle an exception
The handling of exceptions is done using a `try`/`catch`. The structure looks similar to an `if`/`else`. The idea is that you encase the code which you think is most likely to encounter errors within a `try` block and then in the `catch` block you tell Java what to do if an error occurs.
<br>
<br>`public void myMethod() {`
<br>&nbsp;&nbsp;&nbsp;&nbsp;__`try {`__
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`..do something...`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`}`
<br>&nbsp;&nbsp;&nbsp;&nbsp;__`catch (Exception e) {`__
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`..do something w/ e...`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`}`

The following are considered best practices:
- catch the specific exception thrown rather than a general superclass like `Exception` or `Throwable`
- examine the exception to determine the cause
- it's  not necessary to catch *every* exception


```Java
package test.beaker;

public class ExChecker {
    public void sayHello() {
        try {
            getGreeting();
        }
        catch (Exception e) { // exception is the most general error and should generally not be used like this
            System.out.println("We got an error: " + e);
        } // catch
    } // sayHello
    
    public void getGreeting() throws Exception { // adding "throws Exception" here ensures that it will be thrown to the place that calls it
        throw new Exception(); // you can explicitly tell Java to throw an exception, useful for testing & debugging
    }
} // class
```




    test.beaker.ExChecker




```Java
package test.beaker;

ExChecker tester = new ExChecker();
tester.sayHello();
```

    We got an error: java.lang.Exception





    null



It's advisable to look up any class you intend to use in the [Java API Documentation](https://docs.oracle.com/javase/7/docs/api/) to determine what exceptions given class may throw. For example, the `File` class contains a `createNewFile()` method which can throw two different exceptions:
- `IOException`: A checked exception which is thrown if an I/O (input/output) error occurs.
- `SecurityException`: A runtime exception relating to write access.

## Chaining `catch` blocks
In the event that a method can throw multiple exceptions and you want include a catch for each, you can chain catch blocks. If an exception is thrown and an applicable `catch` is present only the applicable catch block will execute.


```Java
package test.beaker;

import java.io.*;

public class MultiEx {
    public void callEx() {
        try {
            definedEx();
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        catch (Exception e) {
            System.out.println(e);
        } // try-catch
    } // callEx
    
    public void definedEx() throws FileNotFoundException, ArrayIndexOutOfBoundsException { /* since we're handling the exception in the calling method and not this method
                                                                                            we need to tell Java that we expect this method to throw one an exception*/
        throw new FileNotFoundException();
    }
    
} // class
```




    test.beaker.MultiEx




```Java
package test.beaker;

MultiEx test = new MultiEx();
test.callEx();
```

    java.io.FileNotFoundException





    null



## What happens after an exception is handled?
If you successfully catch & handle an exception, execution of the code resumes after the `catch` block (assuming that the caught exception wasn't critical to program execution). There may be times that you explicitly *don't* want execution to resume after an exception has been caught, in which case you can terminate the program within the `catch` block using:
<br>
<br>`System.exit(1);`

## Defining your own exceptions
Since exceptions are classes and we've seen you can *extend* classes to create your own which inherit from their parent, you can create custom exceptions in the same way. Lets say we have a `Phone` class for which we want to need define some exceptions for specific functions:


```Java
package test.beaker;

// define our custom exception
public class NoSignalException extends Exception {
    public NoSignalException() {
    }
    public NoSignalException(String msg) {
        super(msg);
    }
}
```




    test.beaker.NoSignalException




```Java
package test.beaker;

// define a phone class to make use of the custom exception
public class Phone {
    public int signalBars;
    
    public Phone() {
        this.signalBars = 15;
    } // constructor
    
    public void makeCall() throws NoSignalException { // since we're not catching the exception we need to declare it in the method signature
        if (this.signalBars > 25) {
            System.out.println("Making call...");
        } else {
            throw new NoSignalException("Signal of " + this.signalBars + "% is too weak to make call."); // if signalBars is low throw exception
        } // if-else
    } // makeCall
}
```




    test.beaker.Phone




```Java
package test.beaker;

// trigger our exception by instantiating an object and calling the method we defined
Phone mobile = new Phone();
mobile.makeCall();
```


    ERROR: test.beaker.NoSignalException: Signal of 15% is too weak to make call.


## Exception class hierarchy
As mentioned above, all exceptions come from a parent class `Throwable`. There are two main groups of exceptions within this tree:
- Unchecked exceptions
- Checked exceptions

Unchecked exceptions are don't necessarily require a try/catch block. You can choose to handle them but the compiler won't force you to do so. Ideally if we are careful in writing code we won't incur any of these. Exceptions that inherit from the `Error` class are also classified as *unchecked* and represent a critical error which the program normally can't ignore/recover from.

Checked exceptions are checked at compile time by the compiler and are often often the result of external resources such as databases or files not being available. If a method can throw a checked exception it must either handle the exception with a try/catch or declare the exception as part of the __method signature__ otherwise the program will not compile. Example of declaring exception in a method signature: `public void myMethod() throws Exception {}`

Exception|Subclass of|Category
:--|:--|:--
`Throwable`|`Object`|-
`Error`|`Throwable`|Unchecked
`Exception`|`Throwable`|Checked
`LinkageError`|`Error`|Unchecked
`VirtualMachineError`|`Error`|Unchecked
`AWTerror`|`Error`|Unchecked
`AWTException`|`Exception`|Checked
`IOException`|`Exception`|Checked
`RuntimeException`|`Exception`|Unchecked
`ArithmeticException`|`RuntimeException`|Unchecked
`NullPointerException`|`RuntimeException`|Unchecked
`ArrayIndexOutOfBoundException`|`RuntimeException`|Unchecked
`IllegalArgumentException`|`RuntimeException`|Unchecked
`InterruptedIOException`|`IOException`|Checked
`EOFException`|`IOException`|Checked
`FileNotFoundException`|`IOException`|Checked

## The `finally` block
In the event that you want some code to run regardless of whether an exception was thrown or caught, you can use a `finally` block which is placed after the last `catch` block.
<br>`try {`
<br>&nbsp;&nbsp;&nbsp;`...try code...`
<br>`} catch {`
<br>&nbsp;&nbsp;&nbsp;`...catch code...`
<br>__`} finally {`__
<br>&nbsp;&nbsp;&nbsp;`...finally code...`
<br>`}`


```Java
package test.beaker;

public class EThrower {
    public void throwEx() throws Exception {
        throw new Exception();
    } // throwEx
} // class
```




    test.beaker.EThrower




```Java
package test.beaker;

EThrower et = new EThrower();
try {
    et.throwEx();
    System.out.println("I'll print if there ISN'T exception");
}
catch(Exception e) {
    System.out.println("I'll print if there IS an exception");
}
finally {
    System.out.println("I'll print either way");
}
```

    I'll print if there IS an exception
    I'll print either way





    null




```Java

```
