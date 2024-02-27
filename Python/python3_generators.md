# Generators
A Python generator is a piece of code able to produce a series of values and control the iteration process. They are often referred to as "iterators". An iterator/generatro that you've already encountered is the `range()` function. 

So what's the difference between a generator and a function? A function returns one well defined value and is invokted only once. A generator returns a series of values and in general is (implicitly) invoked more than once. For example, the `range()` function...


```python
for i in range(5):
    print(i)
```

    0
    1
    2
    3
    4


It may look like it's invoked only once but it actually is invoked 6 times providing 5 values and finally signalling that the series is complete.

## The iterator protocol
The __iterator protocol__ is a way in which an object should behave to conform to the rules imposed by the context of the `for` and `in` statements. An object conforming to the iterator protocol os called an __iterator__.

An iterator must provide two methods:
- `__iter__()` which should return the object itself and which is invoked once (this is needed for Python to successfully start the iteration)
- `__next__()` which is intended to return the next value (first, second, third etc) of the desired series. It will be invoked by the `for`/`in` statements in order to pass the next iteration; if there are no more values to provide the method should raise the `StopIteration` exception.

Lets look at an example of an iterator (based on an iterator example from [edube.org](https://edube.org)).


```python
class Fib:
    def __init__(self, nn):
        print("Initialize iterator...")
        self.__n = nn
        self.__i = 0
        self.__p1 = self.__p2 = 1
        
    def __iter__(self):
        print("Give Python access to the iterator...")
        return self
    
    def __next__(self):
        print("Provide next iteration: ")
        self.__i += 1
        if self.__i > self.__n:
            raise StopIteration
        if self.__i in [1, 2]:
            return 1
        ret = self.__p1 + self.__p2
        self.__p1, self.__p2 = self.__p2, ret
        return ret
    
for i in Fib(10):
    print(i)
```

    Initialize iterator...
    Give Python access to the iterator...
    Provide next iteration: 
    1
    Provide next iteration: 
    1
    Provide next iteration: 
    2
    Provide next iteration: 
    3
    Provide next iteration: 
    5
    Provide next iteration: 
    8
    Provide next iteration: 
    13
    Provide next iteration: 
    21
    Provide next iteration: 
    34
    Provide next iteration: 
    55
    Provide next iteration: 


## Making an object iterable
You can build an iterator into a class such that an# object instantiated from the class becomes iterable.


```python
class IterableClass:
    def __init__(self,n):
        self.__iter = Fib(n) # add an iterator as property within this class's init method
        
    def __iter__(self):
        print("Give Python access to IterableClass iter...")
        return self.__iter
    
iter_obj = IterableClass(10)

for i in iter_obj:
    print(i)
```

    Initialize iterator...
    Give Python access to IterableClass iter...
    Provide next iteration: 
    1
    Provide next iteration: 
    1
    Provide next iteration: 
    2
    Provide next iteration: 
    3
    Provide next iteration: 
    5
    Provide next iteration: 
    8
    Provide next iteration: 
    13
    Provide next iteration: 
    21
    Provide next iteration: 
    34
    Provide next iteration: 
    55
    Provide next iteration: 


## The `yield` statement
One downside of the iterator protocol is the need to keep track of each iteration between `__iter__` invocations. In the above example we needed to store each iteration for use in determining the next. Thankfully Python provides a much more convenient and elegant way of defining iteratos: the `yield` keyword.

`yield` is like `return`'s brainier sibling. Whereas `return` provides you with something once and stops, `yield` provides you with something and also keeps track of what it gave you for use in the next iteration.


```python
def ret_func(n):
    for i in range(n):
        return i 

print(ret_func(10)) # will print a single number
    
for i in ret_func(10):
    print(i) # will throw an error because the return keyword only provides the one value and isn't iterable
```

    0



    ---------------------------------------------------------------------------

    TypeError                                 Traceback (most recent call last)

    <ipython-input-14-864d5e332f3d> in <module>
          5 print(ret_func(10)) # will print a single number
          6 
    ----> 7 for i in ret_func(10):
          8     print(i) # will throw an error because the return keyword only provides the one value and isn't iterable


    TypeError: 'int' object is not iterable



```python
def yie_func(n):
    for i in range(n):
        yield i

print(yie_func(10)) # prints an object identifier as the function gives you an iterator not a single result

for i in yie_func(10): # the result of the above is a generator so need to iterate through it to get the contents
    print(i)
```

    <generator object yie_func at 0x7fbb145695f0>
    0
    1
    2
    3
    4
    5
    6
    7
    8
    9


So, what would the above fibonacci sequence generator look like if implemented using the `yield` keyword?


```python
def fibo(n):
    p = pp = 1
    for i in range(n):
        if i in [0, 1]:
            yield 1
        else:
            n = p + pp
            pp, p = p, n
            yield n
            
fibos = fibo(10)

for i in fibos:
    print(i)
```

    1
    1
    2
    3
    5
    8
    13
    21
    34
    55



```python

```
