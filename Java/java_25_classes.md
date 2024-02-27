# Java Classes
Java classes are defined in a `.java` file which is then compiled using, for example, `javac FileName.java` in terminal which creates a `.class` file containing Java bytecode. 

## The basic structure of a Java class
The structure of a class is commonly as follows:
- Package statement: e.g. `package myJavaFiles.myClasses;`
    - The package statement is optional but recommended and is essentially the path to the class you're defining. For example if I create a *Hello* class in a directory *myJavaFiles/myClasses* the package statement might be as above. If present, the package statement must be the first line in your file.
- Import statement: e.g. `import myJavaFiles.myClasses.FirstClass;`
    - The import statement allows you to import any classes, variables, or functions from other packages/classes which you intend to use in the class you're defining. If present, import statements must be placed before your class in the file.
- Public class declaration: e.g. `public class FirstClass {}`
    - The public class is normally the primary class you're defining in your file (your class file can contain multiple classes but only one *public* class) and the name of your file should match your public class. For example if my class is named `FirstClass` as above then my file name has to be `FirstClass.java`.
- Variable: e.g. `String myStringVar`, `int myInt = 1` etc
    - Variables (sometimes called "fields") are the holders of information within your class. Variables often describe the state or attributes of your class.
- Constructor(s): e.g. `public FirstClass() {}`
    - Constructors are methods which are called at the time of object instantiation. The format for a constructor is to use the same name as the class it belongs to, followed by parentheses. If you don't define a constructor the default constructor will be used. If you do define a constructor, then the default constructor will be overwritten.
- Methods: e.g. `public String myStringReturner() {}`, `public static void main(String [] args){}`
    - Methods are the functions which reside in your class. If variables describe the state of your class/objects, then methods are the actions that your class/objects can perform.


```Java
package test.beaker; // required by beakerx 

public class MyClass {// class
    String s = "abcd"; // class variables
    int i = 123;
    
    public MyClass() {// constructor
        this.s = s; // instance vars
        this.i = i;
    }
    
    public String stringReturner() {// method
        return this.s + " " + this.i;
    }
}
```




    test.beaker.MyClass




```Java
package test.beaker;

MyClass newObj = new MyClass(); // instantiate an object from our class
System.out.println(newObj.stringReturner());// print output of method call
```

    abcd 123





    null



## Package statement
As noted above, the `package` keyword is used to group classes together. A package is implemented as a folder and, like a folder, provides a *namespace* to a class. For example if we have a class like this:
<br>`package com.myfiles.myclasses;`
<br>`public class MyFirstClass {}`

That would describe a directory structure such as this:
<br>`+com`
<br>`|__+myfiles`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`|__+myclasses`
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`|__+MyFirstClass.java`

## Imports
You can import a particular class or function using the `import` keyword. However, you can also forgo the import statement and instead refer to any external classes/functions etc using their *fully qualified domain name*. For example, if we had another class which used `MyFirstClass` we could either:
- Import with `import com.myfiles.myclasses.MyFirstClass`
- Not import and simply refer to the class within our file using `com.myfiles.myclasses.MyFirstClass`

Example: `com.myfiles.myclasses.MyFirstClass mfc = new com.myfiles.myclasses.MyFirstClass();`

You can also import all classes from a particular package using: `import com.myfiles.myclasses.*`. However, this is not considered a best practice.

__NOTE__: if the class you're importing is in the same package as the class you want to use it, you don't need an import statement or fully qualified domain name.

## The `final` keyword
In Java we can use the keyword `final` to declare constant variables, functions/methods, and classes. In the case of variables/functions/methods this prevents them from being reassigned. In the case of classes, it prevents the class from being extended by other classes.

__NOTE__: `final` references must always refer to the same object, however, the contents of the the object can be modified.


```Java
final String s = "Hello";
s = "Goodbye"; // will throw an error
```


    cannot assign a value to final variable s

     s = "Goodbye"

     ^^             


## The `static` keyword
The `static` modifier keyword is used to declare methods & variables as class-level (often referred to as *class methods*/*class variables*. This means that they can be used/accessed without first instantiating an object of the class to which they belong. One common use is when all objects of a certain class need to share a particular variable/method. 

### Static methods (aka class methods)
An example of a static method that you would already have seen is the `main` method:;
<br>`public static void main (String [] args) {}`

Breaking this up into each word what it means is:
- `public`: can be used by other classes
- `static`: it lives in the class in which it was defined and can be accessed directly on the class (i.e. without instantiating an object of the class)
- `void`: does not return anything
- `main`: the name of the method
- `(String [] args)`: accepts an argument array of type String

There are many `static` methods included in Java's `java.lang.Math` class for example. Static methods are often used in place of constructors to perform tasks related to object initialization. 

__NOTE__: static methods CANNOT access non-static methods/variables within the same class. If you try to do so you will get an error stating that a non-static method cannot be called from a static context.

### Static variables (aka class variables)
Static variables are:
- Limited to a single copy per JVM
- Useful for containing shared data (all object instances instantiated from the class which contains the static var, can access the static var)
- Initialized when the containing class is first loaded

### `static` initializer block
A static initializer block, is a block of code prefixed by the word `static` and surrounded by braces `{}` and is commonly used to initialize class variables.


```Java
package test.beaker; // needed by beakerx

public class NewClass {
    public static String classString; // static or class variable
    public static int classInt; // static or class variable
    
    static {// static initializer block
        System.out.println("Initializing static vars....");
        classString = "Hello";
        classInt = 41;
    }
}
```




    test.beaker.NewClass




```Java
package test.beaker;

NewClass myNewObj01 = new NewClass();
NewClass myNewObj02 = new NewClass();

System.out.println("Class string accessed from myNewObj01: " + myNewObj01.classString);
System.out.println("Class string accessed from myNewObj02: " + myNewObj01.classString);
System.out.println("Class int accessed directly from NewClass: " + NewClass.classInt);

```

    Initializing static vars....
    Class string accessed from myNewObj01: Hello
    Class string accessed from myNewObj02: Hello
    Class int accessed directly from NewClass: 41





    null



## Static imports
You can also use `static` when importing static members of a class in order to make them useable under their simple name (rather than by their fully qualified name).


```Java
import static java.lang.Math.random;

System.out.println(random());
```

    0.9143271548875568





    null



## Immutable Classes
An immutable class is a class whose object state cannot be modified once created; any modification of the object will result in a new immutable object. One example of an immutable class is Java's Java.lang.String class; you cannot change a String object, when you try a new String is created in memory.

To create an immutable class, the class should be declared as `final` so that it cannot be *extended*, all fields should be declared as `private` and `final`, there should be no *setter* methods, and all fields should be initialized via the *constructor*.

Lets first look at a generic, mutable class:


```Java
package test.beaker; // needed by beakerx

public class Human {
    private String name;
    private int age;
    public Human(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    
    public void identify() {
        System.out.println("Hello, my name is " + this.name + " and I am " + this.age + " years old.");
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}
```




    test.beaker.Human




```Java
package test.beaker;

Human neal = new Human("Neal",39);
neal.identify();

neal.setName("Jim");
neal.setAge(86);
neal.identify();
```

    Hello, my name is Neal and I am 39 years old.
    Hello, my name is Jim and I am 86 years old.





    null



So currently, we can create a human object but nothing stops us from changing the fields. As demonstrated above we can change the `neal` object's name & age field such that they no longer represent neal.

Let's make the human class immutable.


```Java
package test.beaker; // needed by beakerx

public final class ImmutableHuman { // add FINAL modifier
    private final String name; // make fields FINAL also
    private final int age;
    
    public ImmutableHuman(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void identify() {
        System.out.println("Hello, my name is " + this.name + " and I am " + this.age + " years old.");
    }

}
```




    test.beaker.ImmutableHuman




```Java
package test.beaker;

ImmutableHuman jim = new ImmutableHuman("Jim", 86);
jim.identify();
```

    Hello, my name is Jim and I am 86 years old.





    null



And if we try to re-assign the name:


```Java
package test.beaker;

ImmutableHuman mike = new ImmutableHuman("mike", 41);

mike.name = "Peter";

// NOTE: we can still re-assign the "mike" variable to point to a different object, but can't change the object that was first instantiated as mike.
// if we want to prevent mike from being re-assigned we can declare the variable as `final` also.
```


    name has private access in test.beaker.ImmutableHuman

     mike.name = "Peter"

     ^        ^           


## Nested classes
A nested class is a class declared within the body of another class. There are several types of nested classes:
- Inner classes
    - Member classes
    - Local classes
    - Anonymous classes
- Static nested classes

Some benefits of using nested classes are:
1. they can provide a logical grouping of classes. For example if a class is useful only to one other class, it might be best to make it a "helper" class.
2. they can provide increased encapsulation. If your main class has private fields but a helper class needs access to them, nesting the class grants it access to those fields. Additionally you can declare the nested class itself as private.
3. can lead to more readable, maintainable code. Assuming that the grouping is logical and we're not dealing with multiple nestings.

### Inner class
An inner class is considered to be part of the class it is defined within and as such inherits access to all private members of that class.


```Java
class Outer { // outer class
    private int a = 1;
    private String b = "foo";
    
    private class Inner { // inner class
        private String innerMethod() {
            return b + a; // can access private members of outer class
        }
    } // inner
    
} // outer 
```




    com.twosigma.beaker.javash.bkr90a687a7.Outer



### Local class
An inner class declared within a method body is called a *local* class.


```Java
class Outer {
    private int a = 1;
    private String b = "foo";
    private String stringReturner() { // method
        class LocalClass { // class declared within outer class' method
            private String localStr = b+a;
        }
        return new LocalClass().localStr; // create instance & return string
    }
}
```




    com.twosigma.beaker.javash.bkr90a687a7.Outer



### Static nested class
A static nested class is not an inner class despite being declared inside another class. As with static variables & methods, you define a static nested class using the `static` keyword. Static nested classes can be instantiated before the class that contains them and are therefore unable to access any non-static members of the enclosing class.


```Java
package test.beaker;

class Outer {
    private int a = 1;
    private String b = "foo";
    static class StatInner {
        public static void fooPrint() {
            System.out.println("Foo");
        }
    }
}
```




    test.beaker.Outer




```Java
package test.beaker;

Outer.StatInner si = new Outer.StatInner();
si.fooPrint();
```

    Foo





    null



### Anonymous class
An anonymous class is an expression rather than a normal class definition. To create an anonymous class you use the `new` keyword along with the name of a class or interface you want to extend, any required parameters, and a class body (which can contain methods but not statements). When compiling a class that contains anonymous classes, a separate `.class` file will be generated and the name will follow the format `<outerclassname>$<index>.class` where `<index>` is the index number of the anonymous class within the outer class.


```Java
class Outer {
    private int a = 1;
    private String b = "foo";
    
    Outer foo = new Outer() { // anonymous class assigned to Outer type reference "foo"
        public String indentifyYourself() { // method belonging to anonymous class
            return "I am the identifyYourself method of an anonymous class";
        }
        
        
    };
}
```




    com.twosigma.beaker.javash.bkr90a687a7.Outer




```Java

```
