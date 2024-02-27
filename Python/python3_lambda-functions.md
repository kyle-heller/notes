# Lambda functions
A `lambda` function is a function without a name (aka an __anonymous function__). These are normally very short, very simple functions where you're more interested in the result provided by the function than the function itself.

The form of lambda functions is as follows:
<br>`lambda parameters: expression`

__NOTE__: [PEP8](https://www.python.org/dev/peps/pep-0008/#programming-recommendations) recommends NOT assigning lambdas to variables but defining them using the `def` keyword like a normal function


```python
def self_power(x): return x**x
def power(x,y): return x**y
def name_printer(z): print("Hi, I'm",z)

print(self_power(2))
print(power(29,12))
name_printer("Neal")
```

    4
    353814783205469041
    Hi, I'm Neal


## Why do we need lambda functions?
The most interesting use for lambdas contrary to the example above is using them as they're really intended - __anonymous functions whose purpose is to evaluate and provide a result__. An example of this use would be a function within a function.

Take the following, where we create `do_something` which takes a value `n`. Within the function body we have a `lambda` that multiplies `a` by `n` but where does `a` come from? We create 3 variables that hold versions of the `do_something` function in which the `n` value has already been passed (2 for `doubler`, 3 for `tripler`, 4 for `quadrupler`). Each of these can then be passed a value which will be used a `a`.


```python
def do_something(n):
    return lambda a: a * n

doubler = do_something(2)
tripler = do_something(3)
quadrupler = do_something(4)

print(doubler(2))
print(tripler(2))
print(quadrupler(2))
```

    4
    6
    8


## Using lambdas with the `map()` function
As shown previously the `map()` function takes two arguments, a function and a list, and applies the the first argument (the function) to every element in the second argument (the list) and returns an iterator.


```python
list_1 = [x for x in range(5)]
list_2 = list(map(lambda x:2**x, list_1)) # lambda 1:returns 2 to the power of each element

print(list_2)

for x in map(lambda x:x*x, list_2): # lambda 2: returns each element times itself
    print(x, end=' ')
```

    [1, 2, 4, 8, 16]
    1 4 16 64 256 

## Using lambdas with the `filter()` function
The `filter()` function is very similar to `map()` except instead of applying the first argument (function) to every element of the second (list), it filters the second argument using the first.


```python
import random

random.seed()
data = [random.randint(12,89) for x in range(5)]
filtered = list(filter(lambda x: x>0 and x%2==0,data))

print(data)
print(filtered)
```

    [20, 29, 50, 89, 39]
    [20, 50]



```python

```
