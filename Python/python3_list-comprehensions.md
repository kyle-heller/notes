# Python list comprehensions
In Python list comprehensions are a succinct, elegant way to create lists.


```python
# method 1: the normal way
list_1 = []

for i in range(10):
    list_1.append(i)
    
print(list_1)
```

    [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]



```python
# method 2: list comprehension
list_2 = [i for i in range(10)]

print(list_2)
```

    [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]


## A novel use of conditional expressions
The following syntax allows you to nest a conditional expression within a list comprehension.


```python
# example 1
list_3 = [i if i % 2 == 0 else "x" for i in range(10)]

print(list_3)

# example 2
target_names = ["john", "paul", "george", "ringo"]

candidates = [
    "dave", 
    "george", 
    "sarah", 
    "nikita", 
    "paul", 
    "lucas", 
    "oleg", 
    "silvia", 
    "john", 
    "nestor",
    "ringo"
]

the_beatles = [i for i in candidates if i in target_names]

print(the_beatles)

```

    [0, 'x', 2, 'x', 4, 'x', 6, 'x', 8, 'x']
    ['george', 'paul', 'john', 'ringo']
    dave is not a beatle
    george is beatle
    sarah is not a beatle
    nikita is not a beatle
    paul is beatle
    lucas is not a beatle
    oleg is not a beatle
    silvia is not a beatle
    john is beatle
    nestor is not a beatle
    ringo is beatle


## Using list comprehension to create a generator
List comprehension can also be used to create a generator (aka an iterator). The secret here is to use parentheses rather than square brackets.


```python
long_beatles = (f"{j} is beatle" if j in target_names else f"{j} is not a beatle" for j in candidates)

print(long_beatles) # to prove this is a generator object

for i in long_beatles: # using iteration to print the contents
    print(i,end="\n")
```

    <generator object <genexpr> at 0x7fc4d40d2660>
    dave is not a beatle
    george is beatle
    sarah is not a beatle
    nikita is not a beatle
    paul is beatle
    lucas is not a beatle
    oleg is not a beatle
    silvia is not a beatle
    john is beatle
    nestor is not a beatle
    ringo is beatle


What's the difference between iterating through the `long_beatles` generator above versus doing the same for the `the beatles` list? Not much as far as the actual output printed to the screen is concerned. The difference lies in how they're created; `the_beatles` is created as a whole and exists when the loop is being executed, `long_beatles` is not a list at all - there are only the subsequent values produced by the generator one-by-one.


```python

```
