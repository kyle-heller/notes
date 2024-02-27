# Inheritance in Object programming
In Object Oriented Programming, inheritance is the passing of attributes and methods from the superclass to a newly created class (the subclass). In other words, inheritance is a way of building new classes based on existing classes and passing some or all of the attributes & methods from that pre-existing class to its children.


```python
class Mammal: # superclass of both primate and hominid
    pass

class Primate(Mammal): # subclass of mammal and superclass of hominid
    pass

class Hominid(Primate): # subclass of both primate and mammal
    pass
```

## `issubclass()`
A useful function for determining the relationship between two classes. It will check if the first argument given is a subclass of the second argument. e.g. `issubclass(isthisclass, achildofthisclass)` will return `True` if `isthisclass` is a subclass of `achildofthisclass`.


```python
print(issubclass(Primate,Mammal)) # is Primate a subclass of Mammal
print(issubclass(Hominid,Mammal)) # is Hominid a subclass of Mammal
print(issubclass(Mammal,Primate)) # is Mammal a subclass of Primate
print(issubclass(Primate,Primate)) # this is an odd one...is Primate a subclass of itself (yes, every class is)
```

    True
    True
    False
    True


## `isinstance()`
What about objects? Well, there's a handy function for that too. Much like the previous function this one will check if the first argument is the child of the second argument but in this case it's checking if the first is an `instance` of the second (i.e. is the first argument (an object) created by the second argument (a class).
`isinstance(my_object,ObjectCreatorClass)`


```python
human = Hominid()
gorilla = Primate()

print(isinstance(human, Hominid))
print(isinstance(human, Mammal))
print(isinstance(gorilla, Hominid))
```

    True
    True
    False


## The `is` operator
The `is` operator check whether two variables refer to the __same__ object.


```python
human_adult = Hominid()
human_teen = Hominid()
human_child = Hominid()
another_human_adult = human_adult

print(human_adult is human_teen)
print(human_teen is human_child)
print(another_human_adult is human_adult)
```

    False
    False
    True


## Inheriting methods from superclass
This example demonstrates how a subclass inherits methods from its superclass. Note how there is no `__str__` method within the subclass yet an object instantiated using the subclass still prints the nicely formatted string.


```python
class NewClassWithStr:
    def __init__(self,name):
        self.name = name
        
    def __str__(self):
        return "My name is " + self.name
    
class SubclassWithoutStr(NewClassWithStr):
    def __init__(self, name):
        NewClassWithStr.__init__(self, name) # trigger the superclass constructor passing it the self and name arguments
        
obj_without_str = SubclassWithoutStr("Bob")


print(obj_without_str)
```

    My name is Bob


## The `super()` function
Another way of accessing the superclass' methods is using the `super()` function. Note, you don't need to (and shouldn't) pass the `self` argument if using the `super()` function.


```python
class MySuperclass:
    def __init__(self, greeting, name):
        self.greeting = greeting
        self.name = name
        
    def __str__(self):
        return self.greeting + "! My name is " + self.name + "."
    
class MySubclass(MySuperclass):
    def __init__(self, greeting, name):
        super().__init__(greeting, name)
        
neal = MySubclass("Howdy","Neal")

print(neal)
```

    Howdy! My name is Neal.


## Class variable inheritance
Class variables are also subject to inheritance.


```python
class ANewClass:
    super_var = 1
    def __init__(self):
        pass
    
class ANewSubclass(ANewClass):
    sub_var = 42
    def __init__(self):
        pass
    
a_new_object = ANewSubclass()

print(a_new_object.super_var)
print(a_new_object.sub_var)
```

    1
    42


## Instance variable inheritance
Instance variables can also be inherited but only if the superclass constructor is invoked within the subclass definition.


```python
class Super:
    def __init__(self):
        self.supVar = 1
        
class Sub(Super):
    def __init__(self):
        self.subVar = 32
        
class Sub2(Super):
    def __init__(self):
        super().__init__() # invoke superclass' init 
        self.subVar = 532
        
new_obj_1 = Sub()
new_obj_2 = Sub2()

print(hasattr(new_obj_1,"supVar"))
print(hasattr(new_obj_2,"supVar"))
```

    False
    True


## Multiple inheritance
Although single inheritance (1-superclass-to-1-subclass as above) is the preferred/recommended route you can also have multiple superclasses e.g. `class Hominid(Primate, Mammal)`. 

But what happens if both of the parents have different methods/properties with the same name? First, it's worth clarifying what happens in single-inheritance when more than one superclass have methods/properties with the same name. The bottom-most definition of the method/property supercedes any previous definitions (i.e. the most recent definition is the one that is used).


```python
class SingleInh1:
    parvar=41
    def __init__(self):
        pass
    
    def printparvar(self):
        return f"My parvar value is {self.parvar}"
        
class SingleInh2(SingleInh1):
    parvar=891
    def __init__(self):
        pass
    
    def printparvar(self):
        return f"My parvar is better and it's {self.parvar}"
        
class SingleInh3(SingleInh2):
    pass

single_inh_obj = SingleInh3()

print(single_inh_obj.parvar,single_inh_obj.printparvar())
```

    891 My parvar is better and it's 891


In the case of multiple inheritance Python looks from bottom-to-top (i.e. latest defined) AND left-to-right. So, overall Python looks for object components in the following order:
- In the object itself
- In the objects superclass(s), going from bottom to top and selecting the first match
- If there are multiple matches on the same level, from left to right


```python
class LeftParent:
    var="LEFT"
    def fun(self):
        return "I'm the Left"
    
class RightParent:
    var="RIGHT"
    def fun(self):
        return "I'm the right"
    
class BothChild(LeftParent, RightParent):
    pass

class BothChildReversed(RightParent, LeftParent): # just changing the order of the superclasses in parentheses
    pass

child_obj = BothChild()
child_obj_reversed = BothChildReversed()

print(child_obj.var,child_obj.fun())
print(child_obj_reversed.var,child_obj_reversed.fun())
```

    LEFT I'm the Left
    RIGHT I'm the right



```python

```
