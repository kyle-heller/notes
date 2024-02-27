# Object Oriented Programming
## What is object oriented programming?
OOP is a programming method that tries to model software on real world objects and their interactions. As such a fundamental aspect of OOP is the creation of objects which contain fields/variables and functions/methods. In order to create objects you first need a class which will act as the blueprint or recipe for the object. A class is essentially a reusable set of instructions for the creation of objects. For example, in pseudo-code it might look something like this:
- create a `Shoes` class:
    - class takes `shoeType`, `size`, `brand`, `color`, and `price` parameters
    - creates an instance (an object) of type `Shoe` and assigns the `shoeType`, `size`, `brand`, `color`, and `price` properties for that specific instance
<br><br>
- create object `expensivePurpleShoes` which is an instance of `Shoes` and has the properties:
    - `shoeType="dress"`
    - `size=8`
    - `brand="Luxury Max"`
    - `color="purple"`
    - `price=2000`
    
As Java is at its core an Object Oriented language, all classes inherit from Java's base `java.lang.Object` class. Even if a class doesn't directly inherit from *Object*, at some point in its history a parent class will. For example, take the `java.util.ArrayList` class which has a family tree like this:
<br><br>`java.lang.Object
    |__java.util.AbstractCollection
            |__java.util.AbstractList
                    |__java.util.ArrayList
            `

## Benefits of OOP
Some of the key benefits of OOP are:
1. __Modularity__: self-contained bundles of code (objects/classes/packages) which can be imported and exported as needed
2. __Information hiding__: the ability to have fields and methods within a class/object which cannot be directly accessed
3. __Code re-use__: the modularity and atomic nature of OOP code encourages code re-use
4. __Improved debugging and testing__: since one of the focuses of OOP is modularity, the goal is to hack self contained bundles of code with a very specific purpose and thus more specific errors
5. __Popularity__: some other popular languages that use OOP are C#, F#, C++, Perl, Python

## Key terms
- __Objects__: the "things" we create for a specific purpose e.g. a Shoe object, a Shopping Cart object, a Window object, a Button object
- __Classes__: the blueprints which tell Java how to create an object of that class
- __Abstraction__: the creation of classes from *less specific* to *more specific* e.g. a Clothes class which is a parent of a MensClothes class which is a parent of a MensShirts class
- __Polymorphism__: the ability of child classes to inherit and change variables & methods from a parent class
- __Inheritance__: the passing down of variables & methods from parent class to child class
- __Encapsulation__: the protection and hiding of certain data within a class/object such that it can only be accessed via provided helper methods (getters & setters)

## Object Oriented Design
Object oriented design is the process of analysing and designing objects/products. The phases involved are:
- Analysis
    - Identification of problem(s) to be solved by object/product
    - Identification of key components of object/product
- Design
    - Use data from analysis phase
    - Create blueprints/models for final object/product
- OOP
    - Implement the blueprints from design phase
    
### Design principles
As part of OOPD you will often be working within or applying a specific set of design principles. Some common design principles are:
- SOLID
- GRASP
- DRY
- CRC

## UML (Unified Modeling Language)
UML is a graphical representation of classes/objects often used in the design phase to help blueprint your program/classes/objects and the relationships therein. It can be used to:
- Model objects, attributes, operations, and relationships
- Model dynamic behaviour(s) such as the specific interactions between objects/class and the resulting changes

There are various types of diagrams that can be created with UML, some common examples are:
1. Structure diagrams: modeling specific "things" i.e. classes, objects
2. Behaviour diagrams: modeling the behaviour(s) of a system/program
3. Interaction diagrams: modeling program flow i.e. the various paths of data through a program
4. Use Case diagrams: modeling systems, actors, and the interactions between e.g. a banking program, the users of the program, and the kinds of interactions users would have with it
5. State chart: models the state of an object as it progresses through a particular process

For example, lets say we want to create a *SuperCar* class. The UML model might look something like this:
 _______________
| SuperCar      |
 ---------------
| color         |
| maxSpeed      |
| fuelType      |
 ---------------
| startEngine() |
| brake()       |
 ---------------
Which would then be the basis for a class like this:


```Java
class SuperCar {
    String color;
    double maxSpeed;
    String fuelType;
    
    public void startEngine() {}
    public void brake() {}
}
```




    com.twosigma.beaker.javash.bkr9554a6a6.SuperCar



## DRY (Don't Repeat Yourself)
DRY is a design principle that aims to reduce the duplication of code by writing modular, re-usable code. Following a "write once, call when needed" concept. DRY is primarily achieved through proper planning.

One example of DRY in action might be CSS (Cascading Style Sheets) used to style HTML pages. You will often have a single style sheet that lays out the styling for an entire website including all sub-pages and each HTML document is linked to that one styles sheet. Contrast this with the pre-CSS method of styling HTML where each page would need to have the styles embedded within the HTML document (so if you wanted to change a font or color across the whole site you would need to edit every HTML document).

## CRC (Class Responsibility Collaboration) Card
CRC is an alternative to UML Use Cases, which documents the responsibilities and collaborations of a class. The goal of a CRC is to examine:
- What the class is
- What the class does
- What the class knows

A simple CRC might look like this:
 -------------------------------------------
|                 ShopWebsite               |
 -------------------------------------------
|   *Responsibilities*   | *Collaborators*  |
 -------------------------------------------
| Display info           | Product database |
 -------------------------------------------
| Accept orders          | Order database   |
 -------------------------------------------
| Send confirmation      | Customer database|
 -------------------------------------------
| Notify of stock levels |                  |
 -------------------------------------------
## SOLID
SOLID is a series of best practice principles for Object Oriented Design created by *Bob Martin*. The acronym stands for:
- Single responsibility
- Open-closed
- Liskov substitution
- Interface segregation
- Dependency inversion

### SRP: Single Responsibility Principle
_A class should only ever have one reason to change_ 
<br>Every class/module should have one job and everything within that class/module should be focused towards that one job. Benefits include being easier to maintain and easier to understand.

### OCP: Open/Closed Principle
_A class should be open for *extension* but closed for *modification*._
<br>If additional features/functionality is needed, inheritance should be used to do so, leaving the base class as it is.

### LSP: Liskov Substitution Principle
_Functions that use references to base classes should be able to use child classes._ 
<br>If we've followed the rest of the design principles, it should be possible for us to substitute a child class in place of one of its relative parents without sacrificing functionality.

### ISP: Interface Segregation Principle
_Clients should not be forced to depend on interfaces they don't use._-Bob Martin 
<br>If they're not using it, they shouldn't need it. Don't create an interface that does too many things. Try to be as granular as possible and break larger interfaces into multiple smaller ones if it makes sense to do so.

### DIP: Dependency Inverstion Principle
_Abstractions should not depend on details, details should depend on abstractions._
<br>High level modules should not depend on low level modules and both should depend on abstractions. Essentially what we're talking about here is working from less-specific to more-specific. Parent classes shouldn't know child classes. More detailed child classes should depend on more abstract parents.

## GRASP (General Responsibility Assignment Software Patterns)
GRASP is a list of 9 principles that define best practices for Object Oriented Design with a focus on the responsibilities of classes.
1. Information Expert
2. Creator
3. Low Coupling
4. High Cohesion
5. Controller
6. Polymorphism
7. Pure Fabrication
8. Indirection
9. Protected Variations

### Information Expert (or just "Expert")
__Problem__: What is a basic principle by which we can assign responsibilities to objects?
<br>__Solution__: Responsibility should fall to the class which has the needed information for the task at hand i.e. finding the right class for the job.

### Creator
__Problem__: Who should be responsible for creating new objects?
<br>__Solution__: Assign responsibility to the class that __a.)__ contains other objects __b.)__ uses other objects __c.)__ has the information needed to create other objects

### Low Coupling
__Problem__: How can we promote re-use and also reduce the interdependence of objects?
<br>__Solution__: Stress *low coupling* so that one object's dependence on another is minimal.

### High Cohesion
__Problem__: How can we ensure the responsibilities of an object are as singular/focused as possible?
<br>__Solution__: Try to use *high cohesion* so that the responsibilities are as focused and self-contained as possible. High cohesion is closely related to low coupling.

### Controller
__Problem__: How can we ensure that objects not part of the UI are handling requests properly?
<br>__Solution__: Keep the UI separate from the non-UI by using a *controller* which takes requests from the UI and assigns it to the appropriate non-UI object. Similar to MVC (Model View Controller).

### Polymorphism
__Problem__: How can we use an object as if it were an object of its superclass?
<br>__Solution__: Use *polymorphism* to ensure you can substitute a child for a parent and still be of the same type.

### Pure Fabrication
__Problem__: What do you do if you need to perform operations which don't belong with/in any of your existing objects?
<br>__Solution__: Create a new class specficially for this purpose.

### Indirection
__Problem__: How can we decouple objects to better support re-use?
<br>__Solution__: Create an intermediary class to act as the middle-man between objects where necessary.

For example, if you have two classes which need to communicate but in order to do so would dilute the single-responsibility of each class, you can create another class act as intermediary between them.

### Protected Variations
__Problem__: How do we avoid changes in one object impacting other objects?
<br>__Solution__: Identify points where changes seems likely and use well structured interfaces (as in points of contact/interaction, not the `interface` abstract data type) to stabilize changes and minimize variations.


```Java

```
