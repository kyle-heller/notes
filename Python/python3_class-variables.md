# Class variables
A class variable is a property which exists within a specific class only and is stored outside of any object instance. Thus a class variable can exist even if no objects have been created (whereas instance variables can only exist once an object has been initialized).

Class variables are created by assignment before the `__init__` function.




```python
class NewExample:
    counter = 0 # class variable is created outside of the init function
    def __init__(self, val=1):
        self.__first = val
        NewExample.counter += 1 # class variable is incremented within the init function
        
new_obj_1 = NewExample()
new_obj_2 = NewExample(3)
new_obj_3 = NewExample(5)

print(new_obj_1.__dict__, new_obj_1.counter)
print(new_obj_2.__dict__, new_obj_2.counter)
print(new_obj_3.__dict__, new_obj_3.counter)
```

    {'_NewExample__first': 1} 3
    {'_NewExample__first': 3} 3
    {'_NewExample__first': 5} 3


Since we incremented the class variable `counter` by 1 within the init function, it counts how many objects were instantiated. From the `print` output you can see that the class variable is accessible from each object even though its not listed in the objects `__dict__` and that the value is the same across all objects.

## Mangling
Mangling is the same in class variables as instance variables (i.e. any of your private properties can be access using the mangled version of its name).

## hasattr
The `hasattr` function allows you to check if a given class or object has a given attribute. Its form is `hasattr(class/object, attribute)` and will return `True` if the attribute is present and `False` if not.


```python
class AnotherClass:
    def __init__(self):
        self.greeting = "Hello"

another_object = AnotherClass()

another_object.farewell = "Goodbye"

print(hasattr(AnotherClass,"farewell"))
print(hasattr(another_object,"farewell"))
```

    False
    True



```python

```
