# Java Foundations: Refresher
Before pursuing the Java Associate cert you should have a decent foundational understanding of Java. This short refresher is not sufficient to cover the basics, it's just a refresher for those already familiar with Java.

## Java Technologies
Oracle's Java tech is divided into different products for different purposes. They are:
- **Java SE** (Standard Edition): used to develop applets that run within browsers and applications that run on desktop computers
- **Java EE** (Enterprise Edition): used to develop large enterprise, server-side, and client-side distributed applications
- **Java ME** (Modile Edition): used to create applications for resource-constrained consumer devices (phones, TVs, blu-ray players)
- **Java Card**: used for smartcards, phone sims

## JDK, JRE, and JVM
The development and execution of Java programs is handled by different packages.
- **JDK** (Java Development Kit) is used to develop Java software and includes a JRE
- **JRE** (Java Runtime Environment) is used to execute Java programs
- **JVM** (Java Virtual Machine) is what actually runs the Java code, the JVM comes included in the JRE

## Product Life Cycle (PLC) Stages
Software development is commonly divided into stages such as:
1. **Analysis** - the conception of the program, investigating a problem which you intend to solve with your app. The boundary of a problem is often referred to as the _scope_ of the project.
2. **Design** - the design of your program, creating mock-ups/blueprints etc.
3. **Development** - creating your program based on information from the analysis & design stages. 
4. **Testing** - testing your developed program, there are several methods of testing (UAT, unit testing, automated testing, TDD). Normally carried out by a dedicated testing team which doesn't contain the developers of the program.
5. **Implementation** - the deployment of your program to the live/production environment where it will be put into use.
6. **Maintenance** - developing patches & bug-fixes.
7. **End-of-Life (EOL)** - the stage at which you are no longer supporting your program with further development or maintenance.

## Key Features of the Java Language
Some features which set Java apart and make it a populate language:
- Platform independent: Java programs can be run on any platform that has a JRE and you do not need to develop different versions for different platforms.
- Object-oriented: Java is based on the Object-oriented programming (OOP) paradigm.

### The `main` method
Java's `main` method is where all Java programs begin execution. It is the entry-point for the JVM to run your code.

Not every class should have a main method but one should in order to start executing your code. You declare the main method like so:
`public static void main(String [] args)`

Breaking that down we're saying:
- `public`: this method can be accessed by any class
- `static`: this is a class method and as such can be called directly without instantiating an object first
- `void`: it returns nothing
- `main`: the name of the method (has to be `main` as the JVM will look for a main method)
- `(String [] args)`: the method takes a String array named `args` which will hold any arguments you pass to the program at runtime

For example if you have a class `SayHello` which loops over the `args` array and prints each, then executing `java SayHello hello there neal` would print *hello*, *there*, and *neal*.


```Java
class SayHello {
    public static void main (String [] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i] + " ");
        }
    }
}
```




    com.twosigma.beaker.javash.bkrc68e11c7.SayHello



### Comments
An important part of any programming language are comments. Comments allow you to include notes within your program which will not be executed. Java has three types of comments.

- Single line comments, which start with `//` and only cover a single line
<br>`// this is a single line comment`
<br><br>
- Multi line comments, which start with `/*` and continue until they reach `*/`. Anything between will be considered a comment and ignored by the JVM (Java Virtual Machine, which executes the code).
<br>`/* This is a multi`
<br>`line comment */`
<br><br>
- Javadoc strings, which start with `/**` and continue until they reach `*/`. These are very similar to multiline comments but can be recognised by a Javadoc tool which is used to automatically create documentation.
<br>`/** This is a documentation comment`
<br>`for use with the Javadoc tool */`

## Compiling and Running
Once you've got your `.java` file, you need to compile it using the `javac` command (unless you're using a full IDE which likely compiles it for you automatically once you save the file.

Assuming you're not using an IDE you would open a terminal (or command-prompt) and navigate to the directory where you saved your `.java` file. Then run `javac MyClassName.java`. If there are no error messages you will now see a `.class` file in the same directory as your `.java` file. This is a Java class file, a compiled & executable version of your class from the `.java` file.

To run your newly compiled program, in terminal/cmd-prompt again execute: `java MyClassName` (you don't need to say `.class` as the JVM will assume that).

## Classes: The building block of Java programs
Classes are the main building block of Java. A `Class` is like a blueprint (or recipe if you prefer) which you can use to build `Objects`. To make use of most classes you first need to *instantiate* and object of that class.

### Fields & Methods: the ingredients & instructions
If a class is a recipe then fields and methods are the ingredients & instructions within the recipe.

Fields are holders of data, they contain information about the class and/or any objects created from the class.

Methods are the actions that a class or object can take. They most often act upon the fields.

For example, imagine a class `Cheesecake`. The `Cheesecake` class might contain fields such as `eggs` or `sugar` and methods such as `mixEggsAndSugar`. In this example eggs and sugar are names representing whichever version of those ingredients we use (for example `eggs` could be free-range or vegan, `sugar` could be caster or brown.


```Java
public class Cheesecake {
    String sugar = "brown";
    String eggs = "vegan";
    public String mixEggsAndSugar() {
        return sugar + " sugar and " + eggs + " eggs have been mixed";
    }
}
```




    com.twosigma.beaker.javash.bkr2e144c8d.Cheesecake



### Creating a class
To create a basic class you need to create a `.java` file. The name of the file should be __identical__ to the `public` class you're creating (you can have multiple classes declared within a `.java` file but only one can be `public` and its name must match the file). By declaring a class to be `public` you're telling Java that it can be used by other classes.

So, in our `Cheesecake` example above, the file would be named `Cheesecake.java`.

#### Adding variables/fields to a class
To populate a class with fields (aka variables) you simply need to declare the `type` (`String`, `int`, `double`, `boolean`) of the variable and its *access modifier*. If you declare a variable to be `static` it becomes a class variable. If you declare a variable without the static keyword it becomes an instance variable.
<br>`String myStr = "Hello";`
<br>
#### Adding methods
Adding a method is very similar to adding a variable except that the `type` you assign determines the type *returned* by the method. If your method won't be returning anything you declare it as `void`, and you need to end your method name with parentheses `()`.
<br>`public void sayHello() { System.out.println(myStr) }`


```Java
// within MyFirstClass.java
public class MyFirstClass {
    String myString = "I am a string";
    int myNumber = 7;
    
    public void printMe() {
        System.out.println(myString + myNumber);
    }
}
```




    com.twosigma.beaker.javash.bkr2e144c8d.MyFirstClass



### The constructor
The constructor is a special method of the class which is responsible for carrying out tasks specific to the instantiation of objects. A constructor can be identified by having the same name as the class and NOT having any return type.

Not every class has a constructor specified but Java provides a default no-argument contructor which all classes inherit (providing that they don't overwrite it by defining their own constructor).


```Java
public class MyClass {
    MyClass() {} // constructor
}
```

## Static and Instance Blocks
In the same way that you can have static and instance methods & variables, you can also have static and instance blocks which are blocks of code surrounded by curly-braces that don't belong to a specific method, or loop. Sometimes referred to as *initializer* blocks these are often use to initialize variables of their respective types.

The static block will be executed __ONCE__ when the class is loaded for the first time.

The instance block will be executed prior to every invocation of the constructor.


```Java
public class Foo {
    // VARIABLES
    static int count; // static variable (shared by all objects of this class)
    int idNum; // (instance variable, unique to each object of this class)
    
    // INITIALIZER BLOCKS
    static {
        count = 0;
    } // static initializer block
    
    {
        idNum = (int) (Math.random() * 1);
    } // instance initializer block
    
} // class
```




    com.twosigma.beaker.javash.bkrec04da90.Foo



## Packages and Imports
Java comes with many, many built-in class. These classes are organised into *packages*. Not all of the available packages are automatically imported, most aren't. The `java.lang` package is the base package which contains all of the most important classes & members of the Java language, however, there are many frequently used classes & members which aren't automatically imported. If we want to use such a class we need to `import` it from its `package` into our program.

For example, lets say your program needs a random number generated. Java provides this functionality in the `Random` class which is within the `java.util` package. To make use of it we first need to import it like so:
<br>`import java.util.Random`
<br>
We can also do a more general import if there are many classes within the same package that we want:
<br>`import java.util.*`
<br>
The `*` says import everything from the `java.util` package.

### Fully qualified names
You don't always need to import a class or member from its package in order to use it. You can instead refer to the class/member using its *fully qualifed name*, where basically instead of importing the class/member you instead tell the JVM its exact address so that it can make use of it without importing.

`java.util.Random` is the fully qualitied name of the Random class. The JVM also won't object if you do both; import a class and use its fully qualified name. However, doing so is redundant and just creating additional work for yourself.

### Creating a package
If you don't specify a package at the start of your class file, Java will create your class in the *default package*. Generally speaking for any serious development, you should name your packages.

Naming a package is largely dependent on your directory structure (the place where you save the `.java` files). Lets say we have two classes as follows:

*// in directory "/home/Bob/Documents/projects/projectAlpha/MyFirstClass.java"*
<br>`package projectAlpha;`
<br>
<br>`public class MyFirstClass {`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`static String foo = "Hello World!";`
<br>`}`


*// in directory "/home/Bob/Documents/projects/projectBeta/MySecondClass.java"*
<br>`package projectBeta;`
<br>
<br>`import packageAlpha.MyFirstClass;`
<br>
<br>`public class MySecondClass {`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`public static void main(String [] args) {`
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`System.out.println(MyFirstClass.foo);`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`}`
<br>`}`

__NOTE__: The package statement must be the *FIRST* non-comment in your program (followed by any `import`s and finally your `class`. `package` and `import` statements cannot be placed inside a class.

## Creating Objects
Now that we have some classes, we can create some objects using them. To create an object you simply declare a new variable with your class name as the type and follow it with your class name + parentheses.

So, if we want to create an object from our `MyFirstClass` class, we can do so like this:
<br>`MyFirstClass obj = new MyFirstClass();`
<br>
What we're saying there is:
- create a variable named `obj` 
- which is of type `MyFirstClass`
- use that class' constructor (`MyFirstClass()`) to instantiate an object and assign to the `obj` variable

What we end up with is a variable named `obj` that contains an instance object of class `MyFirstClass`. You can now use `obj` to access any fields or methods belonging to that object.

### Instance initializers
When you see curly-braces (`{}`) which aren't attached to a method these are *instance initalizers*. If you create a program which initializes multiple fields in various places you need to keep track of the order of initialization:
- Fields and instance initializer blocks are executed in the order they apear in the file
- The contructor will execute *after* all fields and initializers have completed

NOTE: you can't refer to a field before it has been initialized. So if you do something like this:
<br>`{ System.out.println(foo); }`
<br>`String foo = "Hello World!";`
<br>
You'll get a compilation error as the initializer block tries to access `foo` before its been initialized.

Likewise, you should keep in mind the order of initialization (*fields & blocks, then constructors*) to ensure you understand how a piece of code will run. Take the following example:


```Java
public class NumberShouter {
    public NumberShouter(){
        number = 7;
    }
    
    public static void main (String [] args) {
        NumberShouter ns = new NumberShouter();
        System.out.println(ns.number);
    }
    private int number = 22;
    {number = 465;}
}

// output: 7
// - first number is set to 22
// - then it's set to 465
// - finally, since fields & blocks have run, the constructor executes which sets number to 7
```




    com.twosigma.beaker.javash.bkr2e144c8d.NumberShouter



## Primitive types
Java has 8 built in data types called *primitive types*.

name|type|example|size in bytes
:--|:--|:--|:--
`boolean`|true or false|`true`|NA
`byte`|8-bit integral|`123`|1
`short`|16-bit integral|`123`|2
`int`|32-bit integral|`123`|4
`long`|64-bit integral|`123`|8
`float`|32-bit floating-point/decimal|`123.04`|4
`double`|64-bit floating-point/decimal|`123.04`|8
`char`|16-bit Unicode value| `a`|2


One of these values present in your code is known as a `literal`. Java makes certain assumptions about some literals which can lead to confusion. 

For example, any whole-number present (e.g. `246`) is assumed to be an `int`. So if you type `long l = 4000000000;` Java will object because it assumes that number is an `int` but `4_000_000_000` is greater than the maximum allowed for an `int`. To avoid issues we need to add an `l` or `L` at the end of the number to tell Java to treat it as a `long`. So `long l = 4_000_000_000L;` won't cause any errors.

A similar example relates to decimals. Java assumes any decimal literal is a `double`. Which means `float f = 41.46;` will cause an error even though this number is within the range allowed for floats. Java sees that as *float f = double-literal* and since floats are smaller than doubles Java tells us we can't assign a double value to a float. To get around this, we can add an `f` or `F` to the end of any decimal literal to make it a float. So, `float f = 41.46f` will work.

### Casting & Type promotion
Java allows for the *widening* of variables (i.e. if you assign one variable type to a __larger__ variable type) and will automatically *promote* the variable in those cases. *Narrowing* or converting from one type to a __smaller__ type is NOT automatic as it can often lead to a loss or change of data, however, you can tell the JVM that you want to narrow a variable by *casting*. To cast you put the name of the target type in parentheses after before the value:


```Java
double d = 5.4d; // double is larger than int
int i = (int) d; // we can tell java we're ok with possible loss of data by casting d to an int
```




    null



## Variable initialization
In Java some variables have a default value, meaning that even if you don't initialize them they still contain a value of some sort and won't necessarily throw and error if doing something like printing them. Other variables, however, do not have a default value and will throw an error if you try to print them before initialization.

Local variables are variables defined within methods. These __DO NOT__ have a default value. So, this would throw an error:
<br>`String s1;`
<br>`System.out.println(s1);`

Instance and Class variables have default values as follows:

type|default value
:--|:--
`boolean`|`false`
`byte`,`short`,`int`,`long`|`0` (in the type's bit length)
`float`,`double`|`0.0` (in the type's bit length)
`char`|`\u0000` (NULL)
Object references|`null`

If you simply try to print one of these default values you won't have any problems but if you try to call methods on a `null` object, you will get an error.

### Variable Scope
It's important to understand variable scope. Scope is the domain in which a variable exists. Imagine a large bubble with many smaller bubbles inside it. Now imagine the surface of each bubble is like a two way mirror but reversed so those inside the bubble can see out but those outside the bubble can't see in.

This large bubble is the `global` scope and the bubbles within are various `local` scopes. 

Any variables you declare in the global scope are visible from within the smaller bubbles (except `private` variables but we'll cover that later). However, any variables you declare within the `local` scope of the smaller bubbles are only visible from within the bubble that holds the variable. Now imagine that each of the smaller inner bubbles have even smaller bubbles inside them. Each of those smaller bubbles have their own local scopes.

Every time you see a set of curly-braces, imagine those as the walls of a bubble and remember that within those braces you're in a different scope than outside them.

## Memory in Java
All Java objects are stored in your running program's `heap` memory. *The heap* is a term for the pool of memory which is allocated to your program. As your program runs any objects that get created are stored in this heap and the variables you assign the objects to are *pointers* pointing to the location in memory where the object is stored. Variable pointers and primitives exist in `stack` memory.

As objects become unreachable *automatic garbage collection* will dispose of them. Objects become unreachable when:
1. There are no longer any references pointing to it (e.g. if you assign a variable that was pointing to the object, to point to a different object)
2. All references to the object have gone out of scope

### The `System.gc()` method
This method is a way of suggesting that Java may want to run the garbage collector but it is not guaranteed that by calling this method you will trigger garbage collection.

### The `finalize()` method
Java allows the creation of a `finalize()` method which may or may not get called. The method gets called if garbage collection tries to collect the object to which is belongs. If the garbage collection doesn't happen, then `finalize()` doesn't get called. If the garbage collection tries to collect the object but fails (because it's still in use) then `finalize()` doesn't get called a second time.

## The Benefits of Java
Some key benefits of Java that are likely to be on the exam are:
- __Object Oriented__: Java is an Object Oriented language which means its based around classes and objects.
- __Encapsulation__: Encapsulation is the ability to protect or hide data.
- __Platform Independent__: Java programs are famously "compile once, run anywhere". Meaning that it doesn't matter if you're on Windows or Mac or Linux as long as the JRE (Java Runtime Environment) is available for your platform, then it can run a Java program and that program doesn't need to be specifically compiled for one platform or another.
- __Robust__: In this instance robust refers to Java's prevention of memory leaks by having automatica garbage collection.
- __Simple__: Simple here is in reference to Java as compared to languages like C++.
- __Secure__: Since Java programs are run inside the JVM (Java Virtual Machine) which sandboxes the programs, it's difficulat for Java to programs to cause unintended harm to systems they run on.

## Scope
Java uses *block* scope. A block is any code between curly-braces `{}`. Blocks can be nested and in such cases each block has it's own scope.


```Java
public class Scope {
    // VARIABLES
    // variables defined in the class have the scope of the entire class (i.e. can be access from anywhere in the class)
    static double myNum; // static/class variable
    int yourNum; // instance variable, one thing to keep in mind is that instance vars/methods cannot be access from a static context (i.e. from within a static method)
    
    static {
        myNum = 0.0d; // since the myNum variable was declared in the outer class scope, it is accessible within this static block
    }
    
    {
        yourNum = 5; // similar to myNum the yourNum variable was declared in outer class scope and is thus available here
    }
    
    // METHODS
    public static void statMethod() {
        int i = 0; // this is a local variable within the scope of the statMethod and thus can't be access outside of this method
    }
    
    public int intReturner(int j) { // this method has two local variables: j which is a parameter and newInt, both are accessible only within the method
        int newInt = j + yourNum;
        return newInt;
    }
}
```




    com.twosigma.beaker.javash.bkrec04da90.Scope




```Java

```
