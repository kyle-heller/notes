# Closures
A __closure is a nested function which still has access to values in the enclosing scope even if they are no longer present in memory__. This is a bit of an abstract one so lets break it down.


```python
def enclosing_function(message):
    # this is the enclosing function
    def nested_function():
        # this is the nested function
        print(message)
        
    return nested_function # returning the nested function, makes this a "closure"

func_var = enclosing_function("Message") # assign the function call to a variable

func_var() # even though the function has already been executed above when assigning it
           # we can still rerun it by calling the variable as if it were a function
```

    Message



```python
del enclosing_function # we can even delete the original function

func_var() # and the preserved function call will still work
```

    Message


## What criteria defines a `closure`?
In order to be considered a closure the following must be met:
- Have a nested function (i.e. a function within a function)
- The nested function must refer to a value defined in the enclosing function.
- The enclosing function must `return` the nested function (not return it's result or directly call it)

## When is it appropriate to use closures?
Closures can avoid the use of global variables/values and provide some form of "data hiding". When there are few methods to be implemented in a class, closures can provide an alternative, more elegant solution. However, if the number of attributes & methods gets larger it's better to implement a class.

Lets create a very simple closure which we can then use, similar to a class, to define some other objects which will inherit behaviour from the closure.


```python
def rhythm_instruments(instrument):
    def rhythm_sound():
        if instrument == "bass" or instrument == "drums":
            print("Thud thud thud")
        elif instrument == "guitar":
            print("Strum strum strum")
        elif instrument == "vocal":
            print("Shoop Shoop Shoop")
    return rhythm_sound # this is the closure

bass = rhythm_instruments("bass")
drums = rhythm_instruments("drums")
guitar = rhythm_instruments("guitar")
backing_vocal = rhythm_instruments("vocal")

bass()
drums()
guitar()
backing_vocal()
```

    Thud thud thud
    Thud thud thud
    Strum strum strum
    Shoop Shoop Shoop



```python

```
