# Python Modules
A module, as defined by the Python Tutorial, is a file containing Python definitions and statements which can be imported and used when needed. The Python standard library is a collection of modules included as extras with Python.

## Importing modules with the `import` keyword


```python
import math # will import the entire math module making the functions etc within available to use w/ dot-notation

round_up = math.ceil(11.3)
print(round_up)

```

    12



```python
from math import floor # imports the floor func from the math module which can then be used directly

round_down = floor(3.2)
print(round_down)
```

    3



```python
from math import sqrt as sq_root # import sqrt function and give it a name of your choosing

square_root = sq_root(12)
print(square_root)
```

    3.4641016151377544


If you want to see what functions etc are within a module you can use the `dir()` function


```python
print(dir(math)) # rather messy looking list

for item in dir(math): # make it a little easier to read with a for loop
    print(item," | ",end="")
```

    ['__doc__', '__file__', '__loader__', '__name__', '__package__', '__spec__', 'acos', 'acosh', 'asin', 'asinh', 'atan', 'atan2', 'atanh', 'ceil', 'comb', 'copysign', 'cos', 'cosh', 'degrees', 'dist', 'e', 'erf', 'erfc', 'exp', 'expm1', 'fabs', 'factorial', 'floor', 'fmod', 'frexp', 'fsum', 'gamma', 'gcd', 'hypot', 'inf', 'isclose', 'isfinite', 'isinf', 'isnan', 'isqrt', 'lcm', 'ldexp', 'lgamma', 'log', 'log10', 'log1p', 'log2', 'modf', 'nan', 'nextafter', 'perm', 'pi', 'pow', 'prod', 'radians', 'remainder', 'sin', 'sinh', 'sqrt', 'tan', 'tanh', 'tau', 'trunc', 'ulp']
    __doc__  | __file__  | __loader__  | __name__  | __package__  | __spec__  | acos  | acosh  | asin  | asinh  | atan  | atan2  | atanh  | ceil  | comb  | copysign  | cos  | cosh  | degrees  | dist  | e  | erf  | erfc  | exp  | expm1  | fabs  | factorial  | floor  | fmod  | frexp  | fsum  | gamma  | gcd  | hypot  | inf  | isclose  | isfinite  | isinf  | isnan  | isqrt  | lcm  | ldexp  | lgamma  | log  | log10  | log1p  | log2  | modf  | nan  | nextafter  | perm  | pi  | pow  | prod  | radians  | remainder  | sin  | sinh  | sqrt  | tan  | tanh  | tau  | trunc  | ulp  | 

## The `random` module
The random module provides several mechanisms to generate/work with pseudorandom numbers. A random number generator takes a value called a "seed" as an input and calculates a random number based on that input (method will vary depending on the algorithm). The length of a cycle in which the values generated are unique may be long but it is finite; eventually the values will start to repeat.

### The random function (i.e. `random.random()`)
The random function generates a float between 0.0 and 1.0


```python
import random

for i in range(10):
    print(random.random())
```

    0.6282874505869175
    0.19038739787932746
    0.2720983829193637
    0.4241396816590456
    0.034419753925003405
    0.515069959908128
    0.41984410825071805
    0.35613698888257883
    0.7074401711449537
    0.16886122313064245


###  `randrange()` and `randint()` functions
randrange() requires at least one integer input and will generate a random number between 0 and the input e.g. `randrange(5)` will randomly select an integer between 0 and 4. If you want to get more exolicit the inputs are `randrange(start,end,step)`.

randint() requires 2 inputs and will randomly select an integer between the first input and the second input INCLUSIVE. So `randint(1,5)` will produce a random integer between 1 and 5.


```python
print(random.randrange(5))
```

    1



```python
print(random.randint(1,5))
```

    3


### The `choice()` and `sample()` functions
choice() takes a sequence of numbers and will randomly choose one from it. sample() similarly takes a sequence of numbers but additionally requires an integer value representing how many numbers you want back. It will then return a list with your chosen quantity of the input numbers in a random order.


```python
numbers = [1,2,3,4,5,6,7,8,9,10]

print(random.choice(numbers))
print(random.sample(numbers,6))
```

    9
    [5, 2, 7, 3, 8, 10]


## The `platform` module
The platform module allows you to access data pertaining to the system on which your Python instance is running.


```python
from platform import platform

print(platform())
```

    Linux-5.9.16-1-MANJARO-x86_64-with-glibc2.33



```python
from platform import machine

print(machine())
```

    x86_64



```python
from platform import system

print(system())
```

    Linux



```python
from platform import version

print(version())
```

    #1 SMP PREEMPT Mon Dec 21 22:00:46 UTC 2020



```python
from platform import python_implementation, python_version_tuple

print(python_implementation())
print(python_version_tuple)

for atr in python_version_tuple():
    print(atr)
```

    CPython
    <function python_version_tuple at 0x7efd95823820>
    3
    9
    2



```python

```
