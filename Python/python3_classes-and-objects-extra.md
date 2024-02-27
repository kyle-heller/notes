# Some useful additional info on classes & objects
Each Python class and object comes equipped with some useful attributes that are worth knowing.

## The `__dict__` property
This allows you to view the methods & attributes within an object or class.


```python
class NewClass:
    def __init__(self, val="Hello"):
        self.greeting = val
        
    def goodbye(self):
        print("Goodbye")
        
new_object = NewClass("Where am I?")

print(NewClass.__dict__)
print(new_object.__dict__)
        
```

    {'__module__': '__main__', '__init__': <function NewClass.__init__ at 0x7fc594e51dc0>, 'goodbye': <function NewClass.goodbye at 0x7fc594e51700>, '__dict__': <attribute '__dict__' of 'NewClass' objects>, '__weakref__': <attribute '__weakref__' of 'NewClass' objects>, '__doc__': None}
    {'greeting': 'Where am I?'}


## The `__name__` property
This is a string which contains the name of the class (note: it's only present in the class not the object). If you want to want to obtain access the class name property from an object you need to do so in combination with the `type()` function.


```python
print(NewClass.__name__) # getting the class name from the class
print(type(new_object).__name__) # getting the class name from an object using the type() function
```

    NewClass
    NewClass


## The `__module__` property
This property stores the name of the module which contains the class definition. NOTE: If the class is defined in the currently running file (i.e. it hasn't been imported from elsewhere) the string will be "`__main__`".


```python
print(NewClass.__module__)
print(new_object.__module__)
```

    __main__
    __main__


## The `__bases__` property
This is a tuple containing the classes (not just class names) which are direct superclasses (parents) for the given class. Only classes have this property, not objects.


```python
class AnotherNewClass(NewClass):
    def __init__(self):
        print("I'm a child of NewClass")

class SpecialNewClass():
    def __init__(self):
        print("I have no parent")
        
print(AnotherNewClass.__bases__) # shows NewClass as parent
print(SpecialNewClass.__bases__) # shows Python object class as its parent
```

    (<class '__main__.NewClass'>,)
    (<class 'object'>,)


## The `__str__` method
When Python needs a class or object to be presented as a string (e.g. putting an object or string into the `print()` function) it tries to invoke the `__str__()` method. If you haven't overridden it with something the default will be a rather ugly string like `<__main__.NewClass object at 0x12347cc45x>`. However, you can override this to be something more useful.


```python
class NewClassWithStr():
    def __init__(self,name):
        self.name = name
    
    def __str__(self):
        return "Hi I'm " + self.name + ". I'm an object of the NewClassWithStr."
    
bob_the_object = NewClassWithStr("Bob")
print(bob_the_object)
```

    Hi I'm Bob. I'm an object of the NewClassWithStr.


## Reflection and Introspection
These are two important activities in objective programming.
- __introspection__ is the ability of a program to examine the type or properties of an object *at runtime*
- __reflection__ is the ability of a program to manipulate the values, properties, and functions of an object *at runtime*

In other words, you can manipulate an object without knowing the complete class/object definition because the object and/or its class contain the metadata which allows you to recognize its features during execution.


```python

```
