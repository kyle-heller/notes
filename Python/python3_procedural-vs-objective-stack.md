# stack / LIFO
A stack in data structure terms is like a stack of coins; if you want to add a coin you have to put it on the top of the stack and if you want to remove a coin you need to remove it from the top. LIFO is an acronym standing for Last In First Out, which is a handy description for a stack.

A stack is an object with two elementary operations, conventionally named _push_ (when a new element is placed on top) and _pop_ (when an element is removed from the top).

The `queue` structure is a stack/LIFO inverse where the first element added is the first element removed (i.e. FIFO - first in first out).

## A procedural stack
Lets implement a stack using procedural programming.


```python
proc_stack = [] # a standard Python list is perfect start

def push(val): # create a function to allow adding items to the stack
    proc_stack.append(val)
    
def pop(): # create a function to allow removing items from the stack
    val = proc_stack[-1]
    del proc_stack[-1]
    return val

push(1)
push(2)
push(3)
print(proc_stack)

print(pop())
print(proc_stack)
```

    [1, 2, 3]
    3
    [1, 2]


## An OOP stack
Lets implement the same stack using object oriented programming.

First, we'll define a class which can be used to instantiate stacks. 

We need to add a constructor function named `__init__` which is executed implicitly every time an object is instantiated using this class. The constructor requires at least one parameter (usually named `self` by convention) which represents the object being created (so that that the init function knows what object to add properties etc to).


```python
class ObjStack: # define a class to be used for instantiating stacks
    def __init__(self): # this is called the constructor and is implicitly executed when an object is instantiated
        self.stack_list = [] # adds an empty list property to any instantiated stack object
        
        
my_stack = ObjStack()
print(len(my_stack.stack_list))
```

    0


If you want the stack_list to be hidden from the outside world you can add a double underscore `__` to the start of the name. This makes the property "private" meaning it cannot be accessed except from within the class.


```python
class PrivateStack:
    def __init__(self):
        self.__stack_list = []
        
        
my_new_stack = PrivateStack()
print(len(my_new_stack.__stack_list))
```


    ---------------------------------------------------------------------------

    AttributeError                            Traceback (most recent call last)

    <ipython-input-6-adb6c82bf1d8> in <module>
          4 
          5 my_new_stack = PrivateStack()
    ----> 6 print(len(my_new_stack.__stack_list))
    

    AttributeError: 'PrivateStack' object has no attribute '__stack_list'



```python
class PrivateStack:
    def __init__(self):
        self.__stack_list = []
        
    def push(self, val): # all class methods must include the self parameter
        self.__stack_list.append(val)
        
    def pop(self):
        val = self.__stack_list[-1]
        del self.__stack_list[-1]
        return val
    
stack_object = PrivateStack()

stack_object.push(1)
stack_object.push(2)
stack_object.push(3)

print(stack_object.pop())


```

    3


## Creating a class FROM a class
Let's say we want to create another class which adds additional functionality to our PrivateStack class. We can do this by creating a new class which is based on our existing class.

To ensure that our new class will get all the properties from its parent we need to invoke the parent/superclass' init function from within our new class' init function.

We can also add some additional functionality to the push & pop functions our new class has inherited. We do this by defining the functions again but only adding the new features we want, then we simply invoke the parent's version of the function. This is called `overriding`.




```python
class ImprovedStack(PrivateStack):
    def __init__(self):
        PrivateStack.__init__(self) # to ensure our new class gets all the properties from its parent we need to explicitly invoke the parent's constructor
        self.__sum = 0
        
    def push(self, val):
        self.__sum += val # adding some new functionality to the existing push function
        PrivateStack.push(self, val) # rather than rewriting the superclass' function we're invoking it within the subclass' version
    
    def pop(self):
        val = PrivateStack.pop(self)
        self.__sum -= val
        return val
        
    def get_sum(self): # in order to access the private __sum variable we need a getter, a function which will obtain the value for us
        return self.__sum
```


```python

```
