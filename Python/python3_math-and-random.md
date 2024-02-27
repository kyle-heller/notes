# Math and Random modules

## Math


```python
import math
```


```python
value = 2.33
```


```python
math.floor(value) # rounds down
```




    2




```python
math.ceil(value) # rounds up
```




    3




```python
math.pi
```




    3.141592653589793




```python
math.e
```




    2.718281828459045




```python
math.inf
```




    inf




```python
math.nan
```




    nan




```python
math.log(100,10)
```




    2.0




```python
math.sin(10)
```




    -0.5440211108893698



## Random


```python
import random
```


```python
random.randint(0,100)
```




    49




```python
random.seed(101)
random.randint(0,100)
```




    74




```python
mylist = list(range(0,20))
```


```python
mylist
```




    [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]




```python
random.choice(mylist)
```




    17




```python
# WITH replacement (repetition of nums allowed)
random.choices(population=mylist,k=10)
```




    [6, 12, 8, 4, 8, 6, 2, 16, 13, 13]




```python
# WITHOUT replacement (repetition of nums NOT allowed)
random.sample(population=mylist,k=10)
```




    [8, 12, 18, 7, 13, 1, 6, 11, 10, 15]




```python
random.shuffle(mylist)
```


```python
mylist
```




    [8, 10, 17, 7, 1, 16, 9, 2, 4, 13, 18, 15, 5, 19, 12, 11, 3, 6, 14, 0]




```python
pwd
```




    '/home/neal/Documents/python_notes'




```python

```
