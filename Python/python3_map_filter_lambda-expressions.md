## Map
The map function allows you to apply a specified function to every item in a specified list. e.g. `map(function_name,list)`.


```python
def square(num):
    return num**2
```


```python
my_nums = [1,2,3,4,5,6]
```


```python
for i in map(square,my_nums):
    print(i)
```

    1
    4
    9
    16
    25
    36



```python
list(map(square,my_nums))
```




    [1, 4, 9, 16, 25, 36]



## Filter
Filter will apply a given boolean-returning function (i.e. function must return `True` or `False`) to the matching items in a list. e.g. `filter(bool_function_name,list_of_items)` and return a filter object containing only those items from the given list which the given function matched.


```python
def check_even(num):
    return num % 2 == 0
```


```python
mynums = [1,2,3,4,5,6]
```


```python
for j in filter(check_even,mynums):
    print(j)
```

    2
    4
    6



```python
list(filter(check_even, mynums))
```




    [2, 4, 6]



## Lambda Expressions
Lambda expressions are anonymous functions described on a single line (kind of like arrow functions in JS). e.g. `lambda parameter: function_body`. A common use of lambda expressions is within functions such as `map()` and `filter()`.


```python
def square(num):
    return num ** 2
```


```python
lambda num: num ** 2
```




    <function __main__.<lambda>(num)>




```python
list(map(lambda num:num**2, mynums))
```




    [1, 4, 9, 16, 25, 36]




```python
list(filter(lambda num:num%2 == 0, mynums))
```




    [2, 4, 6]




```python

```
