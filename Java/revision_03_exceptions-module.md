# Revision notes from Exceptions module quiz

## When casting, the type on BOTH sides of equals sign matters


```Java
Object o = new Integer(1);
String s = (String) o;
System.out.println(s);
```


    ERROR: java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String


## `java.io.IOException` is always thrown programmatically (i.e. explicitly thrown by the programmer)
`IOException` is never thrown by the JVM without having been explicitly thrown in the code.

## `NumberFormatException` is always thrown programmatically
`NumberFormatException` is never thrown by the JVM without having been explicitly thrown in the code.

## `ExceptionInInitializerError`, `NullPointerException`, and `ArrayIndexOutOfBounds` are thrown by the JVM
These exceptions do not need to be explicitly thrown in the code.

## A method that declares an exception isn't required to throw that exception
Java won't throw an error if the method doesn't throw the exception which is declared.


```Java
class Foo {
    public void test() throws ArithmeticException {
        System.out.println();
    }
}
```




    com.twosigma.beaker.javash.bkrfb271382.Foo



## RuntimeExceptions can be thrown in any method
`RuntimeException` and it's children can be thrown in any method.

## A method cannot throw a more broad checked exception than that which is declared
If you declare that a method throws a particular checked exception, you cannot then have the method body throw a more general/broad checked exception (regardless of whether or not it's related to the declared exception).


```Java
import java.io.IOException;

public class Foo {
    public void test() throws IOException {
        throw new Exception();
    }
}
```


    ERROR: java.lang.IllegalStateException: unreported exception java.lang.Exception; must be caught or declared to be thrown

     throw new Exception();

     ^                     ^ 


## Errors can be handled or declared but it is considered bad practice
Although it's bad practive to declare or handle `Error` type exceptions there's no rule to prevent you from doing so.

## Exceptions can be returned by a method
Any Java type, including `Exception` can be a return type. However, in a method that does so the exception object will be returned rather than thrown.


```Java

```
