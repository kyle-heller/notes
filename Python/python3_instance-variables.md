# Instance variables
A class can be equipped with two different kinds of data. One type are called `instance variables` and can only exist when explicitly created & added to an object (either during initialization or at any point in the objects life) and thus can only exist if an object of that class has been instantiated. Any existing property can also be removed at any time.

This approach has several consequences:
- different objects of the same class may possess different sets of properties
- there must be a way to safely check if a specific object owns the property (otherwise an exception will be raised)
- each object carries its own set of properties and these will not interefere with the properties of other objects


```python
class MyExample:
    def __init__(self, val=1):
        self.first = val # set property "first"
        
    def set_second(self, val):
        self.second = val # set property "second"
        
example_obj_1 = MyExample()
example_obj_2 = MyExample(2)

example_obj_2.set_second(3)

example_obj_3 = MyExample(4)
example_obj_3.third = 5 # create & set property "third" ad hoc

print(example_obj_1.__dict__)
print(example_obj_2.__dict__)
print(example_obj_3.__dict__)
```

    {'first': 1}
    {'first': 2, 'second': 3}
    {'first': 4, 'third': 5}


## Mangling
When you add a double underscore to the start of a property name (i.e. making it "private") what Python actually does is `mangle` the name by prepending a single underscore followed by the class name. For example:


```python
class MyNewClass:
    def __init__(self):
        self.__secret_prop = "Shhhh"

my_new_obj = MyNewClass()        
print(my_new_obj._MyNewClass__secret_prop) # we're able to access this private property by using the mangled name
```

    Shhhh


So making a property private is quite limited and works more as a suggestion than an actual rule.


```python

```
