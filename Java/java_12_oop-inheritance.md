# Inheritance in Object Oriented Programming
## What is inheritance?
Inheritance is the passing of attributes & actions from a parent __superclass__ to a child __subclass__. To do this you would create a subclass *from* a superclass. So, there would be a way for you to base the creation of a new class on an existing class.

## Deciding whether or not to create a subclass

It's not always appropriate to create a child class. To help you decide consider whether the relationship can be described with "*is a*" or "*has a*":
- A `truck` __is a__ `vehicle` *a super/sub-class relationship makes sense*
- A `vehicle` __has a__ `truck` *a method or property relationship does not make sense*
- A `stethoscope` __is a__ `doctor` *a super/sub-class relationship does not make sense*
- A `doctor` __has a__ `stethoscope` *a method of property relationship makes sense*

## What are the benefits of inheritance?
The benefits include:
- Subclasses can inherit the methods and data from their superclass
- Subclasses can still create *new* methods
- Or they can __override__ existing methods
    <br>&nbsp;NOTE 1: overriding requires that the method still accept the same number and type of parameters passed to it (i.e. you can change what it does & how but not the input it accepts)
    <br>&nbsp;NOTE 2: you cannot override a method marked as `final`

## Overriding vs Overloading
Two different but similar sounding words to note are:
- __overriding__: changing the functionality of an existing, inherited method
- __overloading__: creating multiple methods with the same name that accept different arguments

### Overriding
Overriding a method is useful when you want to change the functionality of an existing method. Lets imagine you have a `Truck` subclass and a `Car` subclass both `extending` the `Vehicle` class. The `Vehicle` class provides a `horn()` method which we want to use but we'd like to change the sound. In our `Truck` subclass we __override__ the `horn()` method so it says *BEEP! BEEP!*. In our `Car` class we __override__ the `horn()` method so it says *meepmeep!*.

### Overloading
Overloading is useful if you want the same method to accept different arguments and output different results rather than defining multiple different methods. Lets imagine our `Truck` class has a `loadCargo()` method but we know our truck will be carrrying different types of cargo depending on the situation. We could define different methods like `loadColdCargo()`, `loadLiveCargo()`, `loadVolatileCargo()` and so on but it'd be a better user experience if we could have a single method. One way you could do so would be something like this:

<br>`public void loadCargo() {`
<br>&nbsp;&nbsp;`this.cargoType = "standard";`
<br>&nbsp;&nbsp;`this.cargoLoaded = true;`
<br>`}`
<br>
<br>`public void loadCargo(String live) {`
<br>&nbsp;&nbsp;`this.cargoType = "livestock";`
<br>&nbsp;&nbsp;`this.trailer = "aired";`
<br>&nbsp;&nbsp;`this.cargoLoaded = true;`
<br>`}`
<br>
<br>`public void loadCargo(boolean isVolatile) {`
<br>&nbsp;&nbsp;`this.isVolatile = true;`
<br>&nbsp;&nbsp;`this.trailer = "re-enforced";`
<br>&nbsp;&nbsp;`this.cargoLoaded = true;`
<br>`}`


```Java
package test.beaker;

public class Truck {
    private String cargoType;
    private boolean cargoLoaded = false;
    private String trailer;
    private int numOfPens;
    private boolean isVolatile = false;
    
    public void loadCargo() {
        this.cargoType = "perishables";
        this.trailer = "refrigerated";
        this.cargoLoaded = true;
        System.out.println(this.cargoType + " loaded into " + this.trailer + " trailer.");
    } // END std loadCargo
    
    public void loadCargo(String animal, int numAnimals) {
        this.cargoType = "livestock";
        this.numOfPens = numAnimals;
        this.trailer = "aired";
        this.cargoLoaded = true;
        System.out.println(this.numOfPens + " " + this.cargoType + " loaded into " + this.trailer + " trailer.");
    } // END live loadCargo
    
    public void loadCargo(boolean isVolatile) {
        this.isVolatile = isVolatile;
        this.cargoType = "fuel";
        this.trailer = "re-enforced";
        this.cargoLoaded = true;
        System.out.println(this.cargoType + " loaded into " + this.trailer + " trailer.");
    } // END volatile loadCargo
    
} // END truck
```




    test.beaker.Truck




```Java
package test.beaker;

Truck cowHaul = new Truck();
cowHaul.loadCargo("Cows",25);

Truck fuelHaul = new Truck();
fuelHaul.loadCargo(true);

Truck foodHaul = new Truck();
foodHaul.loadCargo();
```

    25 livestock loaded into aired trailer.
    fuel loaded into re-enforced trailer.
    perishables loaded into refrigerated trailer.





    null



## Types of inheritance

### Simple inheritance
The most basic type of inheritance is a straight line from partent to child to grandchild and so on.
<br>`Vehicle`
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;__v__
<br>`Truck`
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;__v__
<br>`Pick-up`

### Hierarchical inheritance
Think of a family tree, a shared root which then branches off to different sub parent/child relationships.
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`Table`
<br>&nbsp;&nbsp;&nbsp;__/__&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;__\\__
<br>`Home`&nbsp;&nbsp;&nbsp;`Office`

## Implementing inheritance
Two important keywords to note when implementing super/sub classes are:
- `extends`: this tells Java that what you're creating is a subclass
- `super`: this allows you to trigger the superclass' constructor from within your subclass

Create our superclass:


```Java
package test.beaker;

// create our parent/superclass
public class Vehicle {
    public String name = "Vehicle";
    
    public String move() {
        return " is moving...";
    } // END move
} // END vehicle
```




    test.beaker.Vehicle



Create our subclass by `extending` the superclass, overriding its `move` method:


```Java
package test.beaker;

public class Truck extends Vehicle { // note the EXTENDS word
    public String name = "Truck";
    
    public String move() { // OVERRIDE the move method
        return " is driving...";
    } // END move
    
    public String originalMove() {
        return super.move(); // use SUPER keyword to access superclass' version of the move method
    }
} // END truck
```




    test.beaker.Truck



Instantiate some objects and call methods:


```Java
package test.beaker;

Vehicle ship = new Vehicle();
Truck pickup = new Truck();

System.out.println(ship.name + ship.move());
System.out.println(pickup.name + pickup.move());
System.out.println(pickup.name + pickup.originalMove());
```

    Vehicle is moving...
    Truck is driving...
    Truck is moving...





    null



## Order of operations for inherited methods
If you have multipls super & sub classes with shared methods how do you know which version of the method will be called? One simple way to determine this is by imagining the JVM (Java Virtual Machine) as a search light which gradually increases in size until it finds a matching method. Lets imagine we've tried to call a `reverse()` method from our `pickup` object:
- Java will start with a small searchlight that only looks locally, near the place it was called (the `pickup` object)
- If it doesn't see the method it will expand its searchlight to include the class which instantiated the `pickup` (`Truck`)
- If it doesn't find a match in `Truck` it will expand the light again to include any parent/superclass of the `Truck` class


```Java

```
