# Object Oriented Programming (OOP)
## What is OOP
Object Oriented Programming is focused on the creation and interaction of *objects*. Some of the benefits of OOP are:
- Modularity
- The ability to hide information from the use (known as __information hiding__)
- Code re-use
- Improved debugging & testing


The basis of OOP are *classes* and *objects*. __Classes__ are essentially the blueprints for *objects*. __Objects__ in turn are collections of __attributes__ and __operations__ which are defined by the object's parent *Class*. *Attributes* usually contain a value representing the state of the attribute. *Operations* are actions carried out by the object and often make use of an attribute. For example, lets say we want to create a `clock` object. To do this we should consider the attributes and operations that make up a clock.

- Clock
    - Attributes
        - __second__=0-59
        - __minute__=0-59
        - __hour__=0-23
        - __second_hand__=second
        - __minute_hand__=minute
        - __hour_hand__=hour
    - Operations
        - __update_seconds__: every 1 seconds add `1` to `second` attribute
        - __update_minutes__: every 60 seconds add `1` to `minute` attribute
        - __update_hours__: every 60 minutes add `1` to `hour` attribute
        - __move_second_hand__: move second_hand clockwise 1 notch every time `update_seconds` changes
        - __move_minute_hand__: move minute_hand clockwise 1 notch every time `update_minutes` changes
        - __move_hour_hand__: move hour_hand clockwise 1 notch every 60 minutes.

### Key Concepts
- Abstraction: creating classes that are very general/abstract which can in turn be the basis for more specific/concrete classes & objects.
- Polymorphism: the idea that child classes can modify behaviours inherited from their parent/super class(es).
- Inheritance: the passing of attributes and operations from parent/super-class to child/sub-class.
- Encapsulation: the ability to hide certain data from users.

### Creating an object variable
When it comes to objects, variables hold a pointer to the object's location in memory unlike with primitive types where the variable holds the primitive itself.

Consider the following examples, imagine we have a Shoe class:
<br>
<br>`int a = 5;` *this is a primitive variable*
<br>
<br>`Shoe runner;` *we declare the variable to of "Shoe" type*
<br>`runner = new Shoe();` *we instantiate a new Shoe object and assign it to the runner variable*
<br>
<br>`Shoe dress = new Shoe();` *here we declare and instantiate on the same line*


```Java
package test.beaker;

public class Shoe {
    public String shoeType;
    public String shoeColour;
    public int shoeSize;
    public String name;
    
    public void wear(String shoeType, String name) {
        if (shoeType == "laced") {
            System.out.println("Tie " + name + " laces.");
        } else if  (shoeType == "slip-on") {
            System.out.println("Pull on " + name + "s.");
        } // END if
    } // END wear
} // END class
```




    test.beaker.Shoe




```Java
package test.beaker;

Shoe runner = new Shoe();

runner.shoeType = "laced";
runner.name = "high top";
runner.shoeColour = "white";
runner.shoeSize = 9;
runner.wear(runner.shoeType, runner.name);

Shoe slipper = new Shoe();

slipper.shoeType = "slip-on";
slipper.name = "cloud-stepper";
slipper.shoeColour = "blue";
slipper.shoeSize = 11;
slipper.wear(slipper.shoeType, slipper.name);
```

    Tie high top laces.
    Pull on cloud-steppers.





    null



## Object methods
Methods are the operations/actions that an object can perform (often these actions are performed on the objects own attributes). A method can also be referred to as a function or procedure. A method may:
- Accept input (optional)
- Do some processing
- Return a value (optional)

Ideally methods should perform one specific task. Methods are constructed using the following syntax:
<br>`access_modifier return_type method_name (parameters) { code_block and option_return}`


```Java
package test.beaker;

public class Dog {
    public String barkSound;
    public String furColour;
    public String earType;
    public String name;
    
    // this is a METHOD
    public void bark(String barkSound){
        System.out.println(barkSound + "! " + barkSound + "!");
    } // END bark
    
    public int legs(){
        return 4;
    } // END legs
    
} // END dog
```




    test.beaker.Dog




```Java
package test.beaker;

Dog jessie = new Dog();
jessie.barkSound = "Woof";
jessie.furColour = "White with black patches";
jessie.earType = "pointy";
jessie.bark(jessie.barkSound);
jessie.name = "Jessie";
System.out.println(jessie.name + " has " + jessie.legs() + " legs");
```

    Woof! Woof!
    Jessie has 4 legs





    null



### Modifiers  (with help from [stackabuse](https://stackabuse.com/non-access-modifiers-in-java) and [javatpoint](https://www.javatpoint.com/access-modifiers))
Modifiers are keywords that Java provides to allow you to finely tune your variabe/class. 

#### Access modifiers
Access modifiers tell Java what the scope of a method/class/constructor is.

Modifier|Meaning|Available within Class|Available within package|Available outside package (via subclass)|Available outside package
:--|:--|:--|:--|:--|:--
`private`|Available within class|Y|N|N|N
`default`|Available within package|Y|Y|N|N
`protected`|Available within package and outside package *__IF__ a child class is created*.|Y|Y|Y|N
`public`|Available everywhere|Y|Y|Y|Y

#### Non-access modifiers
Non-access modifiers control various things such including scope, inheritance, polymorphism and more.

Modifier|Meaning
:--|:--
`static`|Belongs to the class and not to objects of the class (e.g. you don't need to instantiate an object to access)
`final`|Defines a constant, i.e. the values cannot be changed
`abstract`|Applied to a method means the method should be implemented in a subclass, applied to a class means the class contains abstract methods
`synchronized`|Controls thread access to a block/method
`volatile`|The variable's value is always read from the main memory, not from a specific thread's memory
`transient`|Skipped when serializing an object

### Return types
The return type of a function/method needs to be declared when creating it. This tells Java what to expect the function/method to return (if anything) when it's run.

Return Type|Meaning
:--|:--
`void`|No value will be returned
`byte`|A byte primitive value will be returned
`char`|A char primitive value will be returned
`short`|A short primitive value will be returned
`int`|An int primitive value will be returned
`Cat`|Return an object reference of type `Cat`

### Passing arguments to methods
When passing arguments to a method the type of variable being passed effects how it is passed. 

#### Passing primitives
Primitives are __passed by value__, meaning that a copy of the value within the variable is passed. Thus any changes to that value do not effect the original.


```Java
package test.beaker;

public class CountClass {
    
    public void firstMethod() {
        int x = 25;
        secondMethod(x); // call secondMethod on the value of x
        System.out.println("The value of X is " + x);
    } // END firstMethod
    
    public void secondMethod(int x) {
        x = 50; // this sets the value of a new local version of x NOT the original x defined within firstMethod
    } // END secondMethod
} // END CountClass
```




    test.beaker.CountClass




```Java
package test.beaker;

CountClass newObject = new CountClass();

newObject.firstMethod();
```

    The value of X is 25





    null



#### Passing object references
Since object variables store a reference to the object's location in memory and not the object itself, when the value is copied it's still pointing to the same memory location. This means that any changes made using that reference will change the object itself. So, using the same format as the above primitive version:


```Java
package test.beaker;

public class Mug {
    public boolean handle;
    public String colour;
    public String material;
    public String contents;
    
    public boolean isFull(Mug cup){ // isFull method is passed the pointer/reference to the location in memory where the Mug object instance is stored
        if (cup.contents != null) {
            return true;
        } else {
            return false;
        } // END if
    } // END isFull
    
    public void drink(Mug cup) { // drink method acts upon the same pointer/reference thus changing the object itself
        if (cup.isFull(cup)) {
            System.out.println("Gulp gulp gulp");
            cup.contents = null;
        }
    } // END drink
}
```




    test.beaker.Mug




```Java
package test.beaker;

Mug coffeeCup = new Mug();

coffeeCup.handle = true;
coffeeCup.colour = "black";
coffeeCup.material = "porcelain";
coffeeCup.contents = "coffee";

System.out.println("Got coffee? " + coffeeCup.isFull(coffeeCup)); // cup is full
coffeeCup.drink(coffeeCup); // call drink method
System.out.println("Got coffee? " + coffeeCup.isFull(coffeeCup)); // cup is now empty
```

    Got coffee? true
    Gulp gulp gulp
    Got coffee? false





    null



### Method overloading
__Overloading__ is when we have multiple methods with the same name but accepting different parameters (and optionally different `return` types). One example of overloading can be seen in the `java.lang.Math` class. Consider the following methods:

Type|Method name & description
:--|:--
`double`|`max(double a, double b)` returns the greater of two `double` values
`float`|`max(float a, float b)` returns the greater of two `float` values
`int`|`max(int a, int b)` returns the greater of two `int` values
`long`|`max(long a, long b)` returns the greater of two `long` values

## Static methods & variables vs Instance methods & variables
A __static__ member of a class is shared by all instances created from the class and doesn't belong to any one object instance. They can be accessed by all objects instantiated from the class but belong to the Class itself (hence sometimes referred to as *Class variables/methods*). *static* methods/variables <u>cannot</u> access *instance* variables/methods.

An __instance__ member of a class only exists within any objects instantiated from the class and it's value may be different in every instance. *instance* methods/variables <u>can</u> access *static* methods/variables.

## Object Oriented Analysis (OOA)
Is the process of analysing a problem from an OOP perspective.

## Problem Domain
Since *Java* is an object-oriented programming language one of the main duties/goals of a Java programmer is to develops solutions to solve a particular problem/need. The *scope* of the problem you want to address is called the __problem domain__. Most projects start by defining a *problem domain*. This involves gather requirements and writing a *statement of scope* which briefly outlines what you, the developer, want to achieve.

For example, a scope statement for a project to create an ecommerce system might be: "*create a system allowing the online ordering of products with integrated payment processing*"

## Objects within a problem domain
To validate objects in a problem domain you need to first identify the properties of all the objects:
- objects can be __physical__ or __conceptual__
    - A customer account is an example of a __conceptual__ object as it doesn't have a physical presence
    - A car is an example of a __physical__ object
- objects have __attributes__
    - Attributes are charactistics such as the size, name, shape, value that represent the state of an object
    - The value of all of an objects attributes is often referred to as the object's __current state__
- objects have __operations__
    - Operations are things an object can do such as changing an attributes value or displaying a particular message.
    - Operations *usually* affenct an objects attributes.
    - The operations an object performs are often referred to as its *behaviour*
    
Object names are often nouns such as *account* or *shirt*. Object attributes are often nouns also such as *size* or *colour* but in the context of its value, the attribute is an adjective of the noun describing the object.

Object operations are usually verbs or noun-verb combinations, such as *print receipt* or *increase value*.

When judging whether or not to recognise an object we need to assess its relevence to the *problem domain*. To determine this you should asses:
- Whether the object exists withing the boundaries of the problem domain
- Whether the object is required for the solution to be complete
- Whether the object is required for the interaction between the user and the solution.

## Booleans
A boolean is an attribute with only two states: true or false, on or off etc.

## Attributes as references to other objects
It's not uncommmon for an object attribute to contain a reference to another object. Consider a *customer* object which has an *order number* attribute referring to the customer's most recent *order* which is itself an object. That *order* object might contain a *product id* which referse to a separate *product* object and so on.

## Classes
A __class__ in OOP is essentially a blueprint or template (or recipt) for an object. All objects of that class may be referred to as *instances*. A class is the way you define an object. For example, we might have a __car__ class which is used to instantiate various different car objects. 

## Variables and Methods
In Java (and many other languages) an objects *attributes* are represented by `variables` and its *operations* are represented by `methods`.
- Variables: the Java language mechanism for holding data
- Methods: the Java programming language mechanism for perorming operations

## Modeling classes
The first phase of the design stage consists of __modeling__; visually organizing a program and its classes. Each class in a design should be modeled as a closed box with the class name at the top followed by a list of its variables (including a range of possible values) and a list of methods.
<br>`+-------------+
|ClassName    |
+-------------+
|size:0-10    |
|color: Blue  |
+-------------+
|changeColor()|
+-------------+
`

Convention in Java is for attribute and method names to be written in *camelCase*.

*Unified Modeling Language* (UML) is a tool to aid in the modeling process.

Modeling classes are similar to modeling database structures. Your object data can be stored in a Java Database Connectivity (JDBC) API. The JDBC API allows you to read and write records by using Structured Query Language (SQL).
