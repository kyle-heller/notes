# Revision based on results from Enthuware Mock Exam 01

## Using `System.out.println(<exception>)` does NOT print a *stack trace*
When printing an exception using by passing the exception to`System.out.println()` a *stack trace* is __NOT__ printed. To print the stack trace you can use the `.printStackTrace()` method that all exceptions inherit from *Throwable*.


```Java
try {
    throw new Exception();
}
catch (Exception e) {
    System.out.println("Printing the exception using System.out.println:");
    System.out.println("\t"+e);
    System.out.println();
    System.out.println("Printing the stack trace using .printStackTrace:");
    e.printStackTrace();
}
```

    Printing the exception using System.out.println:
    	java.lang.Exception
    
    Printing the stack trace using .printStackTrace:


    java.lang.Exception
    	at com.twosigma.beaker.javash.bkr7e3cf724.BeakerWrapperClass1261714175Ida8b59e2ffc3e4b4996d685648aff4581.beakerRun(BeakerWrapperClass1261714175Ida8b59e2ffc3e4b4996d685648aff4581.java:35)
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



## Wrapper class' `.valueOf()` method returns an object of the type parsed from the String passed to it
Each of the wrapper classes (Integer, Float, Long etc) has a `.valueOf()` method which takes a String and will return an object of the class parsed from the String. So for example the following will assign an Integer object representing the value 4 to the variable *foo*:


```Java
Integer foo = Integer.valueOf("4");
System.out.println("foo is an object of " + foo.getClass() + " representing the int " + foo);
```

    foo is an object of class java.lang.Integer representing the int 4





    null



## Objects are passed by reference meaning...
...that you can make changes to an object using a local variable within a method, however, if the local variable within the method is re-assigned all that does is re-assign the local variable. The original variable that held the reference which was passed to the method continues to point to the original reference unless directly reassigned within the method.


```Java
package test.beaker;

class MyWord {
    String innerWord;
    public MyWord(String w) {
        innerWord = w;
    }
    
    public static void muddleWords(MyWord m1, MyWord m2) { // this method takes in the object references
        MyWord.changeWord(m2, "NewWord"); // use changeWord on m2 which changes the innerWord of that object (i.e. we're acting directly on the object the reference points to)
        m1 = m2; // but here all we're doing is re-assigning the local variable m1 to point to the same reference as m2
    }
    
    public static void changeWord(MyWord mw, String newWord) {
        mw.innerWord = newWord;
    }
}
```




    test.beaker.MyWord




```Java
package test.beaker;

MyWord word1 = new MyWord("Original");
MyWord word2 = new MyWord("AlsoOriginal");

MyWord.muddleWords(word1, word2); // since the muddleWords method didn't make any changes to the object referenced by word1 it still contains the original innerWord

System.out.println("word1 contains: " + word1.innerWord + ", word2 contains: " + word2.innerWord);

// so, within muddleWords we go:
// "Hey, changeWord() method go to the object that m2 points to and change its innerWord variable"
// then we say "Now lets change the variable m1 so it points to the same reference as m2", we haven't told word1 to point somewhere else so it stays the same
```

    word1 contains: Original, word2 contains: NewWord





    null



## Strings computed at runtime
Strings computed at runtime are treated as newly created. Strings which are computed at runtime __by constant expressions__ (i.e. using *literals* or *final* variables) are newly created __*but are treated as if they were literals*__.


```Java
String s1 = "Hello"; // s1 is a compile-time variable (not constant)
final String s2 = "World"; // final variable, this is a compile-time constant

String s3 = s1 + " " + s2; // s3 is concatenating a compile-time variable (s1) and a compile-time constant (s2)
String s4 = "Hello " + s2; // s4 is concatenating two compile-time constants; the final variable s2 and the String literal "Hello"


System.out.println((s1+" "+s2) == "Hello World"); // FALSE because concatenating s1 (not a constant) with s2 is a newly created string object
System.out.println(("Hello " + s2) == "Hello World"); // TRUE because a literal and a final variable are both compile-time constants
System.out.println(("Hel" + "lo" + " " + "Wor" + "ld") == "Hello World"); // TRUE because these are all literals (compile-time constants)
System.out.println(s3 == s4); // FALSE because s3 is a compile-time variable (not constant)

```

    false
    true
    true
    false





    null



## REMEMBER: Co-Variant return types are acceptable when overriding methods
Watch out for questions where overriding methods change the return type to a *co-variant return type* (a type which is a subclass of the type returned by the original method) and nothing else. It's easy to mistakenly think this is a case of invalid overloading but when we're dealing with inheritance the changing of a return type to a co-variant type is a valid form of method overriding.


```Java
// bad example
class Foo {
    public void myMethod() {
        System.out.println("foo");
    }
}

class Bar extends Foo {
    public String myMethod() { // since the original method returns nothing changing the return type to String is invalid, if we added a parameter this would work as overloading
        return "bar";
    }
}
```


    ERROR: java.lang.IllegalStateException: myMethod() in com.twosigma.beaker.javash.bkr7e3cf724.Bar cannot override myMethod() in com.twosigma.beaker.javash.bkr7e3cf724.Foo

      return type java.lang.String is not compatible with void

     public String myMethod() { return "bar"; }

     ^                                         ^ 



```Java
// good example
class Foo {
    public Object myMethod() {
        return new Object();
    }
}

class Bar extends Foo {
    public String myMethod() { // since String is a subclass of object this is a co-variant return type and a valid example of overriding
        return new String("bar");
    }
}
```




    com.twosigma.beaker.javash.bkr7e3cf724.Foo



## `java.lang.SecurityException` is a *RuntimeException*
*SecurityException* extends `RuntimeException` and is thrown by the *security manager* upon security violation (e.g. if a sandboxed java app tries to use a prohibited API such as file I/O).

## A slice/range starting and ending at the same index will be empty
The only exception could be if a method that takes indices expects the first index to be non-zero-based. Otherwise what you're saying by using the same index for start and finish position is place an imaginary cursor at index A and don't move it thus it's empty.

## The `.getClass()` method (inherited from `Object`) is *polymorphic*
This means that the method is bound at runtime and thus will return the actual class of the object it's called on even if the object is assigned to a variable of a different class.


```Java
package test.beaker;

class One {}

class Two extends One {}
```




    test.beaker.One




```Java
package test.beaker;

One one = new One();
Two two = new Two();
one = two;

System.out.println("One is " + one.getClass()); // Prints 'test.beaker.Two' even though one is a variable of type One
System.out.println("Two is " + one.getClass());
```

    One is class test.beaker.Two
    Two is class test.beaker.Two





    null



## The `.` operator has greater precendence that the `(cast)` operator
If you're trying to call a method on an object after casting it, you need to make sure to encase the cast in parentheses before the dot operator:
<br>`Object o = new Integer(5); int i = (Integer) o.intValue();` // this will throw a compiler error because Java tries to call *.intValue()* on *o* before it's been recast
<br>`Object o = new Integer(5); int i = ((Integer) o).intValue();` // this will work


```Java
// bad example
Object o = new Integer(5);
int i = (Integer) o.intValue();
System.out.println(i);
```


    cannot find symbol

      symbol:   method intValue()

      location: variable o of type java.lang.Object

     int i = (Integer) o.intValue()

                       ^         ^   



```Java
// good example
Object o = new Integer(5);
int i = ((Integer) o).intValue();
System.out.println(i);
```

    5





    null



## `Predicate` is typed to `List` in the `checkList` method
This means that the parameter type in a lambda expression must be a List.

Q45
