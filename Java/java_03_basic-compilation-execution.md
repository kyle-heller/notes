# Compiling and executing Java files
## Testing created classes
Most classes you create cannot be tested (or executed) by themselves. In order to do so you need to execute another class to create an object instance of the class you want to test. You can use a *test* or *main* class to test each of your classes.

Each test class should be clearly named so that you (or any other developer) can easily tell what class the test is for. The test class name should be the name of the class its testing followed by the word "Test". For example if you have a class named `Car`, its test class should be named `CarTest`.

Test classes in Java have two tasks to perform:
1. to provide a starting point (called the __main method__) for your program
2. creating an object instance of your class

## The `main` method
The __main method__ is a special method that the JVM recognizes as the start point for every Java program which runs from the command line or a prompt. Thus any class that you need to run from CLI or prompt must have a main method.

The syntax for the main method is very similar to the previously discussed method syntax. However, there are two *required* modifiers: `public` and `static`. Since the main method returns no values it has a return type of `void`. The name/identifer of the main method is `main`. The main method accepts zero or more objects of type `String`: `(String args[])`. This syntax allows you to type in values on the command line which will be used by your program while its running.

Combining the above gives us a syntax like this:
<br><br>`public static void main (String args[])`

## Compiling
The process of compilation converts the class files you write into bytecode that can be executed by the JVM. As noted previously, if your Java source files contains a public class, the source file must be named `[ClassName].java`. So, if we have a public `Car` class in its own file, and a test class for `Car` in its own file we should have two files:
- `Car.java`
- `CarTest.java`

To compile these files you would first navigate to the directory that contains them, then execute:
<br>`javac [filename]`

So, continuing the `Car` example we would expect to run two commands:
<br><br>>`javac Car.java`
<br>>`javac CarTest.java`


If compilation executes successfully and without errors, you can expect to see a `[ClassName].class` file for each compilation. For `Car` we'd have:
<br>`Car.class` and `CarTest.class`

If you compile a class which references other objects, any classes for those objects which haven't yet been compiled will also be executed. So, if we'd compiled `CarTest.java` which references `Car.java` we should have both `.class` files.

## Executing compiled files
To execute the files you've compiled in the JVM you would run the command:
<br>`java [classname]`

## Hello World! aka putting it all together
Lets put the preceding info to practice by creating a simple "Hello World".

First, we need to create a class in your editor of choice:


```Java
/* inside HelloWorld.java file */

public class HelloWorld {
    public String message="Hello World!";
    // method to print message
    public void printMessage() {
        System.out.println(message);
    } // end of printMessage method
}
```

Then we need to create a test class for our HelloWorld class:


```Java
/* inside HelloWorldTest.java file */

public class HelloWorldTest {
    public static void main (String args[]) { // declare the main method
        HelloWorld testHelloWorld = new HelloWorld(); // instantiate an object
        testHelloWorld.printMessage(); // call the object's printMessage method
    } // end of main method
}
```

Now that we have our two files, we just need to navigate to the directory where they're saved and open a terminal, then execute the following:
<br><br>>`javac HelloWorld.java`
<br>>`javac HelloWorldTest.java`

At this point you should have two new `.class` files named `HelloWorld.class` and `HelloWorldTest.class`. To execute our code run the following in terminal:
<br><br>>`java HelloWorldTest`

You should see "Hello World!" printed in the terminal.

## Lets do that here in the notebook
Lets use some of BeakerX's cool functionality to run that here in the notebook:


```Java
package test.beaker;

// define the class
public class HelloWorld {
    public String message="Hello World!";
    // method to print message
    public void printMessage() {
        System.out.println(message);
    } // end of printMessage method
}
```




    test.beaker.HelloWorld




```Java
package test.beaker;

// instantiate an object and call the printMessage method
HelloWorld tsthw = new HelloWorld();
tsthw.printMessage();
```

    Hello World!





    null




```Java

```
