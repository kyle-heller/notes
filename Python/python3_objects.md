# OOP - Object Oriented Programming

## Objects are defined using the `class` keyword and are Capitalized


```python
class MyNewObject():
    pass
```

## Functions within objects are called `methods` for example the `init` method


```python
class MyNewObject():
    
    def __init__(self, param1, param2):
        self.param1 = param1
        self.param2 = param2
```

## The `init` method is how you will create an `instance` of your object (the object itself is the mould you will use to create instances).


```python
class Dog():
    
    def __init__(self, temperment, bark_volume):
        self.temperment = temperment
        self.bark_volume = bark_volume
        
wolfie = Dog("fine", "loud")
```

## The parameters listed in your init method are params you will expect to be passed any time an instance is being created. Those params then get added to the instance as `attributes`.


```python
print(wolfie.temperment)
print(wolfie.bark_volume)
```

    fine
    loud



```python

```
