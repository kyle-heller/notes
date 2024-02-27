# Exceptions

## What are exceptions?
Exceptions are Java's way of telling you that it encountered a problem during execution. There are three main types of exception:
- __Checked Exceptions__: these are exceptions which must either be __handled__ or __thrown__. These are all descendents of the `Exception` class (except any which extend the `RuntimeException` class)
- __Runtime Exceptions__ (aka Unchecked Exceptions): these are unexpected errors, often due to typos/bad syntax. They are unchecked (don't need to be handled or thrown).
- __Errors__: these are critical errors outside the control of Java e.g. *network connection dropped* or *ran out of memory*

__NOTE__: Compiler errors are NOT exceptions

Type|Features|Can be caught?|Required to *handle* or *throw*?
:--|:--|:--|:--
Runtime exceptions|subclass of `RuntimeException`|Yes|No
Checked exception|subclass of `Exception` but not `RuntimeException`|Yes|Yes
Error|subclass of `Error`|No|No

## Exception family tree
As with almost everything in Java, exceptions are classes which ultimately find their root in `java.lang.Object`. The actual lineage of exceptions is something like this:

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`java.lang.Object`
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`|`
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`java.lang.Throwable`
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`/`&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`\`
<br>`java.lang.Exception`&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`java.lang.Error`
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`|`
<br>`java.lang.RuntimeException`

## Dealing with exceptions
There are two ways of dealing with checked exceptions; Java has a rule called the "*handle or declare rule*" which essentially states that there are two options:
1. __Throw__ the exception - i.e. pass the exception back up the chain to the code which invoked the function/method/variable/operation that caused the exception.
2. __Handle__ the exception - deal with it in place, within the method where the exception was raised.

## Declaring that an exception will be thrown
If you're not going to *handle* a checked exception then you need to declare that your method will *throw* it, if encountered. This is done by adding `throws <exception name>` to your method signature:
<br>
<br>`public void myMethod() throws Exception {}`

When throwing an exception you will then need to either *throw* or *handle* it in the method to which you are throwing. For example, you can't do this:
<br>
<br>`public void parentMethod() {`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`childMethod();`// call child method
<br>`}`
<br>
<br>`public void childMethod() throws Exception {}`

Java will give you an error as you've thrown the exception (in this case from `childMethod()` to `parentMethod()` but you haven't thrown or handled it within `parentMethod`.

## Throwing exceptions
Outside of the JVM throwing exceptions you can throw them yourself using the following syntax:
<br>
<br>`throw new <exception name>();`

Here you're using the `throw` keyword and then instantiating a new exception object to be thrown using `new <exception name>();` for example:
<br>
<br>`throw new Exception();` // throwing a new instance of the `Exception` class

## Handling exceptions with `try/catch`
We've seen how to *throw* exceptions, so how to we *handle* them? We use a construct called a *try/catch statement*. First, the code which is likely to throw an exception is encased in a `try` block like this:
<br>
<br>`try {`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`//code that may error`
<br>`}`

Then you follow that immediately with one (or more) `catch` blocks:
<br>
<br>`catch(<exception name> e) {`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`// do something with the exception, e.g. print info to screen`
<br>`}`

So all together it would look something like this:


```Java
try {
    throw new Exception(); // throw an Exception here just as an example
}
catch(Exception e) { // you don't have to use "e" here, it's just a variable to hold the exception object
    System.out.println("Uh oh, encountered an error: " + e);
}
```

    Uh oh, encountered an error: java.lang.Exception





    null



### Chaining `catch` blocks
In the event that your try block may throw a number of different exceptions, you can include different *catch* blocks for each; there's an important caveat - you must list the catch blocks from *MOST* specific exception type to *LEAST* specific.

For example, lets say we have some code which may throw a custom `FooException` (more on custom exceptions later), but also might throw an `ArrayIndexOutOfBoundsException`(this is an unchecked exception I'm just using it for convenience here), or it may throw some other exception that you're not thinking of. You might handle this scenario by doing something like this:
<br>`try {`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`// do something to throw an exception`
<br>`}`
<br>`catch (FooException fe) {`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`// do something with FooException`
<br>`}`
<br>`catch (ArrayIndexOutOfBoundsException aioob) {`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`// do something with ArrayIndex exception`
<br>`}`
<br>`catch (Exception e) {`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`// do something with Exception`
<br>`}`

Here we've gone from most specific exception down to least specific. If we put `Exception` at the top, Java would give us an error message.

### Adding a `finally` block
`finally` allows you to add a block of code to the end of your *try/catch* which will __always__ be executed, even if an exception is thrown. Normally, after an exception is thrown Java will do whatever you put in the *catch* block and then stop. *Finally* allows you to have some code which will always run regardless. If no exception is thrown the *finally* block executes after the *try* block is finished. If an exception is throw, the *finally* block runs after the *catch* block is finished.
<br>
<br>`try {`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`// do something to throw an exception`
<br>`}`
<br>`catch (FooException fe) {`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`// do something with FooException`
<br>`}`
<br>`finally {`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`// this code will always execute, exception or no`
<br>`}`

__NOTE__: There is an exception to the idea that `finally` always executes - Java has a `System.exit(int)` method which tells Java to stop *immediately*.


```Java
try {
    System.out.println("Doing something...");
    throw new Exception();
} catch (Exception e) {
    System.out.println("I only execute if an exception is thrown...");
    System.out.println("Well what do you know...an exception: " + e);
} finally {
    System.out.println("I will always run, regardless of whether or not an exception is thrown.");
}
```

    Doing something...
    I only execute if an exception is thrown...
    Well what do you know...an exception: java.lang.Exception
    I will always run, regardless of whether or not an exception is thrown.





    null



## Throwing an error within a `catch` or `finally` block
So, you've caught an exception in your thrown within your `try` block in your fancy `catch` block. That's that? All good? Not necessarily. It's possible for an exception to be thrown within your *catch* block (or your *finally* block)! So what do we do now?

Well, you could add another *try/catch* within your *catch* block.

What if *BOTH* the `catch` block and the `finally` block throw exceptions? The last exception throw is the important one in such a case; the finally block's exception will essentially override the catch exception. This is often handled by, again, nesting another `try/catch` within the `finally` block (so any exception thrown by `catch` doesn't get lost).

## Common exceptions
According to the *Java SE 8 Programmer 1 Study Guide* for the OCA exam you need to be able to recognise if a particular exception a runtime exception, checked exception, or error and whether it is thrown by the JVM or by the programmer.

### Runtime Exceptions
RuntimeExceptions extend the `RuntimeException` class which is a child of `Exception`. The following is a list of some common runtime exceptions.

Exception|Thrown by|Cause
:--|:--|:--
`ArithmeticException`|JVM|Attempt to divide by zero.
`ArrayIndexOutOfBoundsException`|JVM|Access a non-existent array index.
`ClassCastException`|JVM|Attempt to cast an object to a subclass of which it is not an instance.
`IllegalArgumentException`|Programmer|A method is passed an illegal/incorrect argument.
`NullPointerException`|JVM|A null reference where an object is required.
`NumberFormatException`|Programmer|Attempt to convert a String to a numeric type and the string doesn't have an appropriate format.

- __ArithmeticException__: trying to divide an int by zero gives an undefined result which causes the JVM to throw this exception which includes `/ by zero`.
<br>*Example*: `int badCalc = 14 / 0;`
<br><br>
- __ArrayIndexOutOfBoundsException__: if you try to access an array index that doesn't exist (i.e. higher than the last elemenet index or less than 0) the JVM throws this error.
<br>*Example*: `int [] ia = {1, 2, 3}; System.out.println(ia[3]);`
<br><br>
- __ClassCastException__: if you try to cast an object to a class from which it doesn't descend the JVM throws which includes the object and target class names.
<br>*Example*: `String s = "Hello"; Integer i = (Integer) s;`
<br><br>
- __IllegalArgumentException__: explicitly called by the programmer in cases where you want to defend against incorrect arguments being passed & notify the user.
<br>*Example*: `if (arg !instanceof Integer) { throw new IllegalArumentException(); }`
<br><br>
- __NullPointerException__: instance variables & methods must be accessed using a non-null reference (i.e. a ref to an actual object). If the ref is `null` the JVM throws this.
<br>*Example*: `Object o; System.out.println(o.toString());`
<br><br>
- __NumberFormatException__: if you try to convert a String to a number using, for example, `.parseInt()` but the argument passed is a String which contains only letters, this error will be thrown.
<br>*Example*: `Integer.parseInt("hello");`

### Checked Exceptions
Checked exceptions descend from the `Exception` class (excluding any that extend `RuntimeException`) and must be either declared/thrown or caught/handled. The following are some commont checked exceptions.

Exception|Thrown by|Cause
:--|:--|:--
`FileNotFoundException`|Programmer|Attempt to reference a file that doesn't exist.
`IOException`|Programmer|Problem reading from or writing to a file.

### Errors
Errors extend the `Error` class. They are throw by the JVM and should not be handled or declared. Below are some common errors.

Error|Cause
:--|:--
`ExceptionInInializerError`|A static initializer throws an exception and doesn't handle it.
`StackOverflowError`|A method calls itself too many times (aka *inifite recursion*).
`NoClassDefFoundError`|A class used in the code is available at compile time but not runtime.

## Unreachable `catch` statement'
Declaring an unused exception isn't considered *unreachable code* which gives you the option to change method implementation in the future such that the exception may be thrown. However, if you try to catch an exception which can't be thrown by the code in the *try* block, Java will know that it's not possible to reach the *catch* block.

## Printing an exception
There are three ways to print exception info:
1. Print the whole error
2. Print the error message
3. Print the stack trace


```Java
try {
    throw new Exception("error message");
}
catch (Exception e) {
    System.out.println("FULL ERROR:");
    System.out.println(e); // print the whole error
    System.out.println("--------");
    System.out.println();
    System.out.println("MESSAGE ONLY:");
    System.out.println(e.getMessage()); // print just the error message;
    System.out.println("--------");
    System.out.println();
    System.out.println("STACK TRACE ONLY:");
    e.printStackTrace(); // print just the stack trace
}
```

    FULL ERROR:
    java.lang.Exception: error message
    --------
    
    MESSAGE ONLY:
    error message
    --------
    
    STACK TRACE ONLY:


    java.lang.Exception: error message
    	at com.twosigma.beaker.javash.bkrd7d4d2e5.BeakerWrapperClass1261714175Id9ca7fca28cf844bcac7dab94c95cfb80.beakerRun(BeakerWrapperClass1261714175Id9ca7fca28cf844bcac7dab94c95cfb80.java:35)
    	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    	at java.lang.reflect.Method.invoke(Method.java:498)
    	at com.twosigma.beakerx.javash.evaluator.JavaCodeRunner.compileAndRunCode(JavaCodeRunner.java:121)
    	at com.twosigma.beakerx.javash.evaluator.JavaCodeRunner.compileCode(JavaCodeRunner.java:99)
    	at com.twosigma.beakerx.javash.evaluator.JavaCodeRunner.runCode(JavaCodeRunner.java:84)
    	at com.twosigma.beakerx.javash.evaluator.JavaCodeRunner.call(JavaCodeRunner.java:58)
    	at com.twosigma.beakerx.javash.evaluator.JavaCodeRunner.call(JavaCodeRunner.java:39)
    	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
    	at java.lang.Thread.run(Thread.java:745)





    null



## Multiple Exceptions in a single `catch`
It's possible to have multiple exceptions in a single catch by separating them with the pipe/vertical-line. However, the exceptions must not be directly related (e.g. a parent and child).


```Java
try {
    throw new ClassNotFoundException("This is an exception");
}
catch(ArithmeticException | ClassNotFoundException e) {
    System.out.println(e);
}
```

    java.lang.ClassNotFoundException: This is an exception





    null



## Try-with-resources statement
A *try-with-resources* statement is a `try` statement that declares one or more *resources*; a *resource* in this context is an object that must be closed after the program is finished with it (for example a `BufferedReader` object used to read data in should be closed). The *try-with-resources* statement ensures that  each resource is closed at the end of the statement. Any object which implements the `java.lang.AutoCloseable` interface (which includes objects hat implement `java.io.Closeable`) can be used as a *resource*.

The syntax for a *try-with-resources* statement is similar to a normal *try* block but with the addition of parameters encased in brackets immediately after the `try` keyword:


```Java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

class MyReader {
    static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) { // try-with-resources being passed BufferedReader object
            return br.readLine();
        }
    }
}
```




    com.twosigma.beaker.javash.bkrc2e6f5a0.MyReader



Unlike a normal *try* you don't need to include a `catch` block. You can include `catch` and `finally` blocks if you choose and those will be run after the declared resources have been closed.

## Declaring multiple errors
A method may throw more than one exception, in such a case the exceptions are separated by comma:


```Java
class MyExTest {
    public void exThrower() throws ArithmeticException, ArrayIndexOutOfBoundsException, ClassCastException {
        // method body
    }
}
```




    com.twosigma.beaker.javash.bkrc2e6f5a0.MyExTest



## Creating custom exceptions
Since exceptions are just classes you can create your own exceptions by extending the `Exception` class (or one of it's subclasses). Custom exceptions will never be automatically thrown, they must always be explicitly thrown in your code.


```Java
package test.beaker;

class MyCustomException extends Exception {
    public MyCustomException(String msg) {
        super(msg); // pass msg string to parent constructor
    }
    
    public String getMessage() { // override the getMessage method
        return "Here is the error message: " + super.getMessage();
    }
}
```




    test.beaker.MyCustomException




```Java
package test.beaker;

try {
    throw new MyCustomException("custom error message"); // explicitly throw our custom exception
}
catch(MyCustomException mce) {
    System.out.println(mce.getMessage());
}
```

    Here is the error message: custom error message





    null




```Java

```
