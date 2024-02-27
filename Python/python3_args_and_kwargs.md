## *args
Adding `*` to the start of your function parameters means the function will accept any number of parameters (convention is to use `args` as the parameter name, so your function would look like `myfunc(*args):...`)


```python
def sum_up(*args):
    return sum(args)
sum_up(1, 47, 98, 1400)
```




    1546



## \*\*kwargs
Adding `**` to the start of your function parameters means it will accept an undefined number of keyword arguments (convention is to use `**kwargs` as the parameter)


```python
def fruit_print(**kwargs):
    if 'fruit' in kwargs:
        print(f'I like eating {kwargs["fruit"]}!')
    else:
        print('No fruit :\(')
fruit_print(fruit="apple", veg="potato", junk="snickers")
```

    I like eating apple!



```python

```
