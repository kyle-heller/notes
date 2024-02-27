```python

```


```python

```

## Classes


```python
class Animal():
    
    def __init__(self):
        print("Animal Created.")
        
    def whom_am_i(self):
        print("I am an animal.")
        
    def eat(self):
        print("I am eating.")
```


```python
my_animal = Animal()
```

    Animal Created.


## Class Inheritance


```python
# derived class (inherits from given class)
class Dog(Animal):
                
    def __init__(self):
        Animal.__init__(self)
        print("Dog Created.")
        
    def bark(self):
        print("WOOF!")
```


```python
my_dog = Dog()
```

    Animal Created.
    Dog Created.



```python
my_dog.bark()
```

    WOOF!


## Polymorphism


```python
class Dog():
    
    def __init__(self,name):
        self.name = name
        
    def speak(self):
        return self.name + " says 'WOOF!'"
```


```python
class Cat():
    
    def __init__(self,name):
        self.name = name
        
    def speak(self):
        return self.name + " says 'MEOW!'"
```


```python
dexter = Dog("Dexter")
maggie = Cat("Maggie")
```


```python
print(dexter.speak())
print(maggie.speak())
```

    Dexter says 'WOOF!'
    Maggie says 'MEOW!'



```python
for pet in [dexter,maggie]:
    print(type(pet))
    print(type(pet.speak()))
```

    <class '__main__.Dog'>
    <class 'str'>
    <class '__main__.Cat'>
    <class 'str'>



```python
def pet_speak(pet):
    print(pet.speak())
```


```python
pet_speak(dexter)
```

    Dexter says 'WOOF!'



```python
pet_speak(maggie)
```

    Maggie says 'MEOW!'



```python
class Animal():
    
    def __init__(self,name):
        self.name = name
        
    def speak(self):
        raise NotImplementedError("Subclass must implement this abstract method")
```


```python

```
