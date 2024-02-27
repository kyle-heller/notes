# Class hierarchies
Think of `Class`, in the object oriented programming way of thinking, as like a category. For example, if we create a _vehicles_ class denoting "moving transportation piloted by humans" we can define more specific `subclasses` under that `superclass` such as:
 - Vehicles
  - Land Vehicles
    - Wheeled Vehicles
      - Car
    - Tracked Vehicles
      - Tank
  - Air Vehicles
    - Airplane
    - Fighter Jet
  - Water Vehicles
    - Freighter
    - Scooner
    - Yacht

Another example could be animals:
 - Animals
   - Mammals
     - Wild
     - Domesticated
   - Reptiles
   - Birds
   - Fish
   - Amphibians

# Objects
If classes are like categories, then what constitutes a category? Well, one way of thinking about is that it's a set or grouping. So, a class is like a set of objects. Therefore an object is an entity belonging to a class.

An object is an incarnation of the requirements, traits, and qualities that define a specific class.

# Inheritance
One of the fundamental concepts of object programming is `inheritance`. Any object bound to a specific class hierarchy inherits all the traits, requirements, and qualities defined inside any of the `superclasses`. The specific class that created the object may also define NEW traits, requirements, and qualities which will in turn be inherited by any `subclasses` of that class.

- Vehicles
        Trait: movement
        Feature: ability to carry 1 or more people
 - Land Vehicles
         Trait: movement
         Feature: ability to carry 1 or more people
         Requirement: travels on land
   - Car
          Trait: movement
          Feature 1: ability to carry 1 or more people
          Feature 2: has windows
          Requirement 1: travels on land
          Requirement 2: has 4 wheels

Object programming conventions assume that every existing object may be equipped with three groups of attributes:
- an object has a *name* that uniquely identifies it within its home namespace (although there may be some anonymous objects also)
- an object has a *set of individual properties* which make it original, unique, or outstanding (however, it is possible to have objects with no properties at all)
- an object has a *set of abilities to perform specific activities* able to change the object itself, or some other objects.

Example 1: "Max is a large cat who sleeps all day"
    Object name: Max
    Home class: Cat
    Property: Size(large)
    Activity: Sleeps(all day)
    
Example 2: "A pink Cadillac went quickly"
    Object name: Cadillac
    Home class: Wheeled vehicles
    Property: Colour(pink)
    Activity: Go (quickly)

# Creating a class
To create/define a class you use the `class` keyword and a colon (convention is to use Captial Casing for class names).


```python
class MyNewClass:
    pass
```

# Creating an object
To create an object from a class you use an appropriate name of your choosing, the assignment operator `=`, and parentheses after the class name. This is called `instantiation` as the object you create is an `instance` of the class used to create it.


```python
my_new_object = MyNewClass()
```


```python

```
