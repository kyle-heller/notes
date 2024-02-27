# Inheritance in Java
*Inheritance* is the process by which sub/child-classes can inherit existing fields/variables/methods from it's super/parent-class. Java supports *single-inheritance* meaning a class may inherit from only __ONE__ direct parent. However you can have multiple levels of inheritance such as class A extending class B which in turn extends class C.

At it's most basic the concept of inheritance is often described as being an *'is a'* relationship: 
- *a car __is a__ motor vehicle* thus it would be appropriate for a *car* class to inherit from *motor vehicle* parent class
- *a bear __is a__ mammal* thus it would be appropriate for a *bear* class to be a child of a *mammal* class
- *a human __is NOT an__ island* therefore it would not make sense to have a *human* class as a child of an *island* class

## Extending a class
If you write a class which doesn't explicitly extend another class Java will automatically set your class to be a child of the top-level `java.lang.Object` class. So if you define a class like `public class MyClass {}` Java will automatically insert `extends java.lang.Object` at compile time. However, since `Object` is the top-most class essentially all classes inherit from it even if just indirectly.

To extend a class in Java you use the `extends` keyword in your class declaration:
<br>`public class Foo extends Bar {}`


```Java
// PARENT CLASS
package test.beaker;

public class Airplane {
    final static boolean hasWings = true;
    int numberOfEngines = 2;
    boolean hasPropeller = false;
    
    public Airplane(int numberOfEngines) {
        this.hasPropeller = hasPropeller;
        this.numberOfEngines = numberOfEngines;
    }
}
```




    test.beaker.Airplane




```Java
// CHILD CLASS
package test.beaker;

public class JumboJet extends Airplane {
    final static int numberOfPassengers = 524;
    
    public JumboJet() {
        super(2);
    }
}
```




    test.beaker.JumboJet




```Java
package test.beaker;

JumboJet B747 = new JumboJet(); // instantiate JumboJet object
System.out.println(B747.hasWings); // access Airplane's hasWings variable
System.out.println(B747.numberOfEngines); // access JumboJet's numberOfEngines
System.out.println(B747.numberOfPassengers); // access JumboJet's numberOfPassengers (set using Airplane's contructor)
```

    true
    2
    524





    null



## Constructor Rules
It's worth revisiting the following contructor definition rules:
- The first statement of every constructor is either a call to another constructor within the same class (using `this()`), or a call to a parent-class constructor (using `super()`).
- `super()`, if used, must be the first statement in a constructor.
- If no `super()` call is present, Java will insert a no-argument one at the start of the constructor at compile time.
- If the parent-class doesn't have a no-argument constructor, and the child-class doesn't impliment one (by calling `super()` with the needed arguments), an error will be thrown at compile time.

So if you define a class like this:


```Java
public class Mouse {}
```




    com.twosigma.beaker.javash.bkrf2685cb9.Mouse



Java will convert it to this at compile time:


```Java
public class Mouse {
    public Mouse() { // no argument constructor for mouse added
        super(); // call to Object's (or another parent class) constructor within
    }
}
```




    com.twosigma.beaker.javash.bkrf2685cb9.Mouse



## Inherited class members

Java classes can use any `public` or `protected` members of the parent-class. If the parent and child are in the same *package*, the child can also use any default (*package protected*) members. A child class can never __directly__ access any `private` members of its parent.

To access inherited members of a class you can use the keywords `super` or `this`. `this` will access the inherited member within the current class whereas `super` will directy access members within the parent class. If you try to use `super` to access a member of the current class which was NOT inherited from the parent, you'll get a compile error.

### `super` vs `super()` and `this` vs `this()`
It's easy to confuse `super` with `super()` and `this` with `this()`, however, they're not interchangeable. `super()` is a call to the parent class' constructor whereas `super` is a keyword used to access members of the parent class. Likewise, `this()` is a call to the current class constructor and `this` is a keyword used to access instance variables/methods. If you override a parent-class' member in your child-class you can still access the parent-class' version (providing it's not `private`) by using `super`.


```Java
package test.beaker; // beakerx magic

public class Human { // parent class
    public static final String genus = "homo";
    public static final String species = "homo sapiens";
    private String name;
    private int age;
    
    public Human(String name) {
        System.out.println("Creating human...");
        this.name = name;
        this.age = 0;
        System.out.println("Human " + this.name + " created.");
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public String toString() {
        return ("Name: " + this.name + "\nAge: " + this.age);
    }
}
```




    test.beaker.Human




```Java
package test.beaker;

public class NationalHuman extends Human { // child class of human
    private String nationality;
    
    public NationalHuman(String name, String nationality) {
        super(name);
        this.nationality = nationality;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public String getNationality() {
        return (super.getName() + " is " + this.nationality); // uses SUPER keyword to access getName method and THIS keyword to access nationality variable
    }
}
```




    test.beaker.NationalHuman




```Java
package test.beaker;

NationalHuman dave = new NationalHuman("Dave", "Australian");
NationalHuman susan = new NationalHuman("Susan", "Irish");
NationalHuman antje = new NationalHuman("Antje", "German");

System.out.println("\n" + dave.getNationality());
System.out.println("\n" + susan.species);
System.out.println("\n" + antje);
```

    Creating human...
    Human Dave created.
    Creating human...
    Human Susan created.
    Creating human...
    Human Antje created.
    
    Dave is Australian
    
    homo sapiens
    
    Name: Antje
    Age: 0





    null



## Overriding inherited methods
If you have a method in the child-class with the same method-signature as in the parent-class (i.e. same name, parameters, return type) that's called overriding. In order to successfully override an inherited method the following conditions must be met (the JVM will check at compile-time):
- Must have the same *method-signature*
- Must have the same or more permissive access
- Must not throw a new or more broad __checked__ exception (i.e. if different, the checked exception in the child's overriding method must be a more specific version of the parents)
- If the method returns a value it has to be the same type (or a subclass of) the type returned by the parent's method

If the method in the child class has the same name but different signature it is *overloading* not *overriding*.


```Java
package test.beaker; // beakerx magic

class Pet {
    private String name;
    
    public Pet(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
}

class Dog extends Pet {
    private String breed;
    
    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }
    
    public void bark() {
        System.out.println("Woof woof!");
    }
    
    public String toString() {
        return (this.getName() + " is a " + this.breed);
    }
}

class MiniatureDog extends Dog {
    public MiniatureDog(String name, String breed) {
        super(name, ("miniature " + breed));
    }
    
    public void bark() { // overrides the bark method from parent
        System.out.println("Yip Yip!");
    }
}
```




    test.beaker.Pet




```Java
package test.beaker;

Pet nibblesTheBunny = new Pet("Nibbles");
Dog dexter = new Dog("Dexter", "weimaraner-cross");
MiniatureDog pebble = new MiniatureDog("Pebbles", "poodle");

dexter.bark();
pebble.bark();
System.out.println(dexter);
System.out.println(pebble);
```

    Woof woof!
    Yip Yip!
    Dexter is a weimaraner-cross
    Pebbles is a miniature poodle





    null



### Virtual Method Invocation (VMI)
Virtual Method Invocation (or Virtual Method Calling) is the process Java uses at runtime to determine which method should be executed in cases where a method was overridden. Without this process, inheritance likely wouldn't work at all and Java would always call the original parent-class version of the method.

## Hiding a method
If a child-class defines a static method with the same *method-signature* as a static method in its parent, this is known as a *hidden method*. Method hiding is similar to method overriding and as such the rules for successfully doing so are almost the same but with the additional requirement that both methods must be `static`.

If you try to use the same method signature for a method in the child-class but change from `static` you will receive a compiler error. Likewise, if you try to declare a signature with the same signature as in the parent but declared as `static` when the parent version was non-static, you will get a compiler error.

__NOTE__: while permitted, method-hiding is not recommended as it can lead to confusing and hard-to-read code.

### Overriding vs Hiding
A key difference between overriding methods and hiding methods, is that hiding a method will keep access to the original version of the method providing that the call to the method is defined in the parent class even if the method is called from an instance of the child class. Overriding a method will replace the parent version of the method even if the call to the method is in the parent class, providing that it's being accessed from an instance of the child.

This sounds very confusing so lets look at some examples.

OVERRIDING:


```Java
// OVERRIDING EXAMPLE
package test.beaker;

class Greeting {
    public String greetword() { // method in parent class
        return "Hello";
    }
    
    public String normalGreet() { 
        return (greetword() + " there!");
    }
}

class FormalGreeting extends Greeting {
    public String greetword() { // overridden method that replaces parent version of greetword in any instance of child class
        return "Good day";
    }
    
    public String formalGreet() { // 
        return (greetword() + " to you.");
    }
}
```




    test.beaker.Greeting




```Java
package test.beaker;

FormalGreeting formal = new FormalGreeting();

// note that both of the below output the same greetword of "Good day" even though one is the parent method, one is the child method
System.out.println(formal.formalGreet()); // call child's greeting from child instance
System.out.println(formal.normalGreet()); // call parent's greeting from child instance
```

    Good day to you.
    Good day there!





    null



HIDING:


```Java
// HIDING EXAMPLE
package test.beaker;

class NationalGreeting {
    public static String getGreetWord() { // static String in parent class
        return "Hello";
    }
    
    public String getGenericGreeting() {
        return getGreetWord();
    }
}

class IrishGreeting extends NationalGreeting {
    public static String getGreetWord() { // hiding static method from parent class
        return "Howya";
    }
    
    public String getIrishGreeting() {
        return getGreetWord();
    }
}
```




    test.beaker.NationalGreeting




```Java
package test.beaker;

IrishGreeting irish = new IrishGreeting();

// note that below outputs the respective greetword
System.out.println(irish.getIrishGreeting()); // call child's greeting method from child instance
System.out.println(irish.getGenericGreeting());// call parent's greeting method from child instance
```

    Howya
    Hello





    null



## Final methods
As you might expect, `final` methods cannot be overridden nor hidden by a child class. It doesn't matter if the child class redeclares the method as `final` also, it will still not compile.

## Hiding variables
Variables, unlike methods, cannot be overridden by a child class; they can only be hidden. As with method hiding, the parent variable will be available within the parent class (and subclasses & instances thereof) and the overridden version will be available within the child class (and instances & subclasses thereof). Unlike methods, hiding variables is not limited only to `static` variables, you can also hide instance variables.

__NOTE__: variable hiding is also not recommended for the same reason as method hiding.

## Abstract classes
*Abstract* classes are classes which cannot be instantiated. You can use abstract classes to define a parent class which is intended to be extended only and provide variables/methods which will be inherited. Obviously, since they exist to be extended, abstract classes cannot be `final` (otherwise it wouldn't be possible to extend them) nor can they be `private`.

### Abstract methods
You can also declare methods to be *abstract* which is essentially a placeholder for a method which __must__ be implemented by the class which extends the class. It's worth noting that:
1. You cannonot have abstract methods in a non-abstract class (but you can have non-abstract methods in an abstract class)
2. You must implement any abstract methods declared in an abstract class if you wish to extend that class

So, if you want to extend an abstract class and it contains abstract methods, you have to implement those methods in your class otherwise you'll get a compiler error. To declare an abstract method you simply declare the name and return type (access modifiers etc can also be included) followed by parentheses and a semi-colon (no curly braces or method body can be included). Similar to abstract classes, abstract methods cannot be `final` or `private`.


```Java
package test.beaker;

public abstract class Bottle { // abstract class
    protected int volume; // standard variables
    protected String lidType;
    
    public abstract String pour(); // abstract method
    
    public abstract String toString(); // abstract method
}

class Beer extends Bottle {
    public String producer;
    public String fluid;
    public String pour() { // implement the abstract "pour" method
        return "Tilt glass as you pour, slowly decreasing the glass tilt as you increase the bottle tilt.";
    }
    
    public Beer(String producer, String lidType, int volume) {
        this.volume = volume;
        this.lidType = lidType;
        this.producer = producer;
        this.fluid = "Beer";
    }
    
    public String toString() { // implement the abstract "toString" method
        return ("A " + this.volume + "ml " + this.lidType + " " + this.fluid + " made by " + this.producer);
    }
}
```




    test.beaker.Bottle




```Java
package test.beaker;

Beer heineken = new Beer("Heineken N.V.", "crown cork lid", 330);
System.out.println(heineken);
```

    A 330ml crown cork lid Beer made by Heineken N.V.





    null




```Java
package test.beaker;

Bottle wine = new Bottle(); // will throw an error as you can't instantiate an abstract class
```


    test.beaker.Bottle is abstract; cannot be instantiated

     Bottle wine = new Bottle()

                   ^           ^ 


### Concrete classes
A *concrete* class is the first non-abstract subclass that extends an abstract class and is thus required to implement all inherited abstract methods.

### Extending an abstract class with another abstract class
It's possible to extend one *abstract* class with another *abstract* class. In such a scenario, since the class doing the extended is also *abstract* it is __not__ required to implement any abstract methods present.

One interesting additional scenario is this: can abstract sub-class (which extends an abstract parent) implements a method which was abstract in the parent? Yes! If an abstract subclass implements an abstract method from it's parent, then any concrete subclass of that child class is no longer required to implement the method (since it was implemented by its abstract parent).


```Java
public abstract class Peripheral { // abstract parent
    public abstract void getDrivers();
}

abstract class InputDevice extends Peripheral { // abstract child of Peripheral
    public abstract void doInputStuff(); // abstract method
}

abstract class Mouse extends InputDevice {// abstract child of abstract child
    public void doInputStuff() { // this method was abstract in the parent but has been made concrete, that is implemented, here in another abstract class
        System.out.println("Click clickety click");
    }
} 

class TwoButtonMouse extends Mouse { // concrete child of abstract child
    public String [] buttons = {"Left-click", "Right-click"};
    public void getDrivers() { // this method must be implemented since it was declared abstract in Peripheral
        System.out.println("Searching for drivers...");
        System.out.println("Downloading driver...");
        }
    // NOTE since doInputStuff was implemented in Mouse (the parent-class of this class) it doesn't need to be re-implemented here
}
```




    com.twosigma.beaker.javash.bkrc393cf9f.Peripheral



### Summary of abstract class & method rules
Below is a summary of the rules for abstract classes & methods.

#### Abstract classes
- Cannot be instantiated directly
- Can be declared with any number (including zero) of abstract and/or non-abstract methods
- Cannot be declared as `private` or `final`
- If extending another abstract class, it inherits all of its abstract methods as its own
- The first *concrete* class of an abstract class must implement all abstract methods present

#### Abstract methods
- Can only be declared in abstract classes (i.e. you can't have an abstract method in a non-abstract class)
- Cannot be declared as `private` or `final`
- Cannot provide a method body or include curly braces
- Implementing an abstract method in a subclass follows the same rules as for overriding a method

## Interfaces
As mentioned above, Java doesn't allow multiple inheritance. However, it does allow classes to implement any number of *interfaces*. An *interface* is an abstract data type that defines a list of abstract public methods which any class implementing the interface must provide. Interfaces can also include a list of constant variables and default methods.

You declare interfaces with the keyword `interface` where you would normally see `class`. All interfaces are automatically `public` and `abstract`. So even if you don't declare your interface to be `public abstract` Java will insert that for you at compile time. Interfaces have the following characteristics:
- Methods are implicitly abstract (except `default` methods, more below)
- Classes do not `extend` interfaces but `implement` them
- Classes can implement more than one `interface`

Similarly, any variables in your interface are automatically `public static` and any methods are automaticallly `public abstract`.

__NOTE__: Although Java will insert `public`, `abstract`, and `static` as needed, it's considered best practice to include them yourself.


```Java
public abstract interface BoosterVaccine {
    public static final float DOSE = 23.4f;
    
    boolean amVaxxed();
}

class ThirdDose implements BoosterVaccine {
    public boolean amVaxxed() {
        return true;
    }
}
```




    com.twosigma.beaker.javash.bkrc393cf9f.BoosterVaccine



A class can implement many interfaces. To do so you use the same `extends` keyword but follow with all interfaces being implemented (each interface should be separated by a comma).


```Java
interface LiquidMetal {
    boolean isLiquidMetal = true;
}

interface CannotBeStopped {
    boolean isStoppable = false;
    
    public void whenShot();
}

interface Mission {
    String mission = "Kill John Connor"; 
}

interface HowsWolfy {
    String answer = "Wolfy's fine, dear";
}

class T1000 implements LiquidMetal, CannotBeStopped, Mission, HowsWolfy {
    public void whenShot() {
        System.out.println("[Your shots do nothing. T1000 automatically heals]");
    }
} // class implements all of the above interfaces
```




    com.twosigma.beaker.javash.bkrc393cf9f.LiquidMetal



### Rules for defining an a interface
Like abstract classes, there are certain rules for creating interfaces:
1. Cannot be instantiated directly
2. Is not required to have any methods
3. Cannot be `final` or `private`
4. All "top-level" interfaces are assumed to have `public abstract` as part of their declaration
5. Non-default methods in an interface are assumed to have `public abstract` in their method signature

### Inheriting an interface
Like abstract classes extending abstract classes, an interface can extend another interface and in fact can extend multiple interfaces.
<br>`public interface Garfunkel {}`
<br>`public interface Simon {}`
<br>`public interface FeelingGroovy extends Simon, Garfunkel {}`

An abstract class can also extend an interface and in such a case the abstract classes is treated like another interface extended the interface (i.e. inherits the abstract methods but is not required to implement them).

Two important rules to bear in mind when extending interfaces:
- An interface that extends another interface (also abstract classes that implement an interface) inherit all of the interface's abstract methods as it's own abstract methods
- The first concrete class which implements an interface (or extends an abstract class which implements an interface), must provide implementations for all abstract methods

### CAUTION: Classes, Abstract Classes, and Interfaces
Although it can seem like clases, abstract classes, and interfaces are all mixed around & can be used liberally, it should be noted that:
- a class cannot `extend` an interface, it must `implement` it
- an interface can `extend` another interface but it cannot `implement` an interface
- an interface cannot `extend` a class or abstract class

### Interface Variables
Interface variables are assumed to be `public`, `static`, and `final`. The value of an interface variable must be set when it is declared since the variable is `final`. All of that means that interface variables are:
- essentially constants
- accessible directly from the interface (i.e. don't require an instance)

### Default Methods
Java 8 introduced *default* methods to *interfaces*. *Default* methods are methods defined in the interface with the `default` keyword and which contain a method body (unlike normal methods within interfaces which are assumed to be `abstract` and thus cannot include a method body).

A default method is a type of abstract method which includes a default implementation. Any classes which implement the interface can override the default method if needed (though they're not required to do so). If not overridden the default implementation provided by the interface will be used. An interface can have multiple `default` methods.

Unlike interface variables which are assumed to be `static` and can thus be access without an instance, `default` methods are assumed to be instance methods and require an instance.

One unusual aspect of default methods is that a child interface (i.e. an interface that extends another interface) can redeclare a `default` method to be `abstract` thus requiring that any children of this new interface implement the previously default method. So, the child interface would essentially be saying, *"this default method in my parent interface is no longer default, it's abstract and my children need to reimplement it themselves"*.


```Java
package test.beaker;

public abstract interface Hello { // interface
    public default void print() { // default method
        System.out.println("Hello World!");
    }
}

class Hi implements Hello {} // class implements Hello but doesn't override print()

class Hey implements Hello { // class implements Hello and overrides print()
    public void print() {
        System.out.println("Hey World!");
    }
}
```




    test.beaker.Hello




```Java
package test.beaker;

Hi hi = new Hi();
hi.print(); // uses default method

Hey hey = new Hey();
hey.print(); // uses its own overridden version of method
```

    Hello World!
    Hey World!





    null



#### Summary of Default Method rules
The following are rules for Interface' default methods:
1. A `default` method can only be declared in an interface (not in a class or abstract class)
2. A default method must be declared with the `default` keyword
3. Unlike standard, non-default interface methods, a default method is NOT assumed to be `static`, `final`, or `abstract`
4. Default methods __are__, however, assumed to be `public` and cannot be `private` or `protected`

### Conflicting Default Methods
Since a class can implement multiple interfaces, what happens if two interfaces have the default methods with the same name? In short, a compiler error. The only way to avoid a compiler error would be for the class which is implementing the conflicting default methods to override them with it's on version:


```Java
interface ImTheBoss {
    public default void whosBoss() {
        System.out.println("I'm the boss!");
    }
}

interface NoImTheBoss {
    public default void whosBoss() {
        System.out.println("No, I am the one who is boss!");
    }
}

class ActualBoss implements ImTheBoss, NoImTheBoss {
    public void whosBoss() {
        System.out.println("Actually, it is I whom is boss.");
    }
}
```




    com.twosigma.beaker.javash.bkrc393cf9f.ImTheBoss



### Static Methods in Interfaces
In addition to default methods, Java 8 also introduced `static` methods for interfaces. *Static* interface methods are virtually identical to normal *static* class methods except that the interface methods are NOT inherited by any children.

#### Rules for static methods
1. Are assumed to be `public` and cannot be `private` or `protected`
2. To access a interface's static method you must refer to it using the interface name (since it is not inherited by any children)


```Java
package test.beaker;

public abstract interface Hoola {
    public static void doHoola() { // static method
        System.out.println("I'm hoola-ing my heart out! *hoola-hoola-hoola*");
    }
}

class Hoop implements Hoola {
    
}
```




    test.beaker.Hoola




```Java
package test.beaker;

Hoop myHoop = new Hoop();

Hoola.doHoola(); // OUTPUT: I'm hoola-ing my heart out! *hoola-hoola-hoola*
// uncomment the below to see it's output (an error)
// myHoop.doHoola();
```

    I'm hoola-ing my heart out! *hoola-hoola-hoola*





    null



## Polymorphism
Polymorphism is a principle of inheritance whereby objects can **a.)** take many forms and **b.)** inherit & change methods/variables from a parent. Essentially, it means that that you can call the same method in two different (but related) objects/classes and get different results. Additionally, polymorphism means that a Java object can be accessed using:
- a reference with the same type as the object
- a reference that is a superclass of the object
- a reference that defines an interface which the object implements


```Java
package test.beaker;

class SirenSound {
    public boolean isSirenLoud() {
        return true;
    }
    public String flashingLight = "Flashing Light!";
}

abstract interface Siren {
    public boolean hasSiren();
}

class RoadWorks extends SirenSound implements Siren {
    public String lights = "*FLASHING YELLOW LIGHTS*";
    public boolean hasSiren() {
        return true;
    }
    public boolean isSirenLoud() {
        return false;
    }
}
```




    test.beaker.SirenSound




```Java
package test.beaker;

RoadWorks roadworks = new RoadWorks(); // create a RoadWorks object
SirenSound sirensound = roadworks; // pass rw instance to SirenSound reference
Siren siren = roadworks; // pass rw instance to Siren reference

System.out.println(roadworks.lights); // accessing lights variable from rw object
System.out.println(siren.hasSiren()); // access hasSiren method
System.out.println(sirensound.flashingLight); // access isSirenLoud method
```

    *FLASHING YELLOW LIGHTS*
    true
    Flashing Light!





    null



In the above example we only create one object instance (`new RoadWorks()`). We then assign that instance to a `SirenSound` type reference and a `Siren` type reference. There's still only one object instance in memory but by assigning it to different types we change what properties exist within the object when it's accessed via those types (e.g. if we try to access the `lights` variable using `siren` or `sirensound` references we'll get an error because it only exists in RoadWorks type references).

Remember:
- The type of the __object__ determines the content of the object in memory
- The type of the __reference__ *to* the object determines what methods/vars are accessible via that reference


```Java
package test.beaker;

RoadWorks rw = new RoadWorks();
SirenSound ss = rw;
Siren s = rw;

System.out.println(ss.light);
```


    cannot find symbol

      symbol:   variable light

      location: variable ss of type test.beaker.SirenSound

     System.out.println(ss.light)

                        ^       ^  


### Polymorphic parameters
One common use of polymorphism, is defining functions which accept an instance of an interface to which you can then pass any class that implements the interface (as that would be casting from subtype, the class that implements the interface, to supertype, the insterface itself).

__NOTE__: When defining a method which takes polymorphic parameters that will be accessible outside the class it's defined in (either via subclasses or objects), it is considered good practice to use the superclass or interface type as the input parameters. This potentially allows the method to be reused/repurposed more easily because it can accept a wider range of argument types. For example, you might use the `List` interface as a parameter rather than the `ArrayList` class which implements `List` that way the method can accept both `List` and any class which implements it (not just `ArrayList` and it's children).


```Java
package test.beaker;

class Siren {
    public String makeNoise() {
        return "[LOUD SIREN NOISE]";
    }
}

class Ambulance extends Siren {
    public String makeNoise() {
        return "MEE-MAW..MEE-MAW..";
    }
}

class Police extends Siren {
    public String makeNoise() {
        return "WEE-OOH..WEE-OOH..";
    }
}

class NormalCar {
    public static void hearsSiren(Siren siren) { // method takes a Siren type object and calls it's makeNoise method
        System.out.println("is that a siren?..." + siren.makeNoise());
    }
}
```




    test.beaker.Siren




```Java
package test.beaker;

NormalCar.hearsSiren(new Siren()); // passing a new Siren object
NormalCar.hearsSiren(new Ambulance()); // passing a new Ambulance object (which is a subclass of Siren)
NormalCar.hearsSiren(new Police()); // passing a new Police object (which is a subclass of Siren)
```

    is that a siren?...[LOUD SIREN NOISE]
    is that a siren?...MEE-MAW..MEE-MAW..
    is that a siren?...WEE-OOH..WEE-OOH..





    null




```Java

```
