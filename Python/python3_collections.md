# Collections
The collections module is built into Python and offers special container types.

## Counter
The Counter class provides several methods for counting the contents of a list or string.


```python
from collections import Counter
```


```python
my_list = ['a','a',12,1]
```


```python
Counter(my_list)
```




    Counter({'a': 2, 12: 1, 1: 1})




```python
my_sentence = 'This is a sentence with some words such as sentence and words'
```


```python
Counter(my_sentence)
```




    Counter({'T': 1,
             'h': 3,
             'i': 3,
             's': 9,
             ' ': 11,
             'a': 3,
             'e': 7,
             'n': 5,
             't': 3,
             'c': 3,
             'w': 3,
             'o': 3,
             'm': 1,
             'r': 2,
             'd': 3,
             'u': 1})




```python
split_sentence = Counter(my_sentence.split())
```


```python
split_sentence.most_common()
```




    [('sentence', 2),
     ('words', 2),
     ('This', 1),
     ('is', 1),
     ('a', 1),
     ('with', 1),
     ('some', 1),
     ('such', 1),
     ('as', 1),
     ('and', 1)]



## Default Dictionary
Default Dictionary allows you to avoid/pre-empty a `KeyError` when trying to call an invalid key.


```python
d = {'this': 1, 'that': 2, 'these': 3}
```


```python
d['those'] # will throw an error
```


    ---------------------------------------------------------------------------

    KeyError                                  Traceback (most recent call last)

    <ipython-input-18-9ec4a5e9e192> in <module>
    ----> 1 d['those'] # will throw an error
    

    KeyError: 'those'



```python
from collections import defaultdict
```


```python
d_dict = defaultdict(lambda: 0)
```


```python
d_dict["fav_number"] = 3
```


```python
d_dict["fav_number"]
```




    3




```python
d_dict["non_existant"]
```




    0




```python
print(d_dict)
```

    defaultdict(<function <lambda> at 0x7f90e1efe670>, {'fav_number': 3, 'non_existant~': 0, 'non_existant': 0})


## Named Tuple
Adds the ability for tuples to have named indices (like a dict).


```python
my_tuple = (1, "dog", "burritos", "blue")
```


```python
my_tuple[3]
```




    'blue'




```python
from collections import namedtuple
```


```python
Person = namedtuple('Person', ['number_of_pets', 'type_of_pets', 'fav_food', 'eye_colour'])
```


```python
me = Person(number_of_pets=2,type_of_pets='dogs',fav_food='burritos',eye_colour='blue')
```


```python
me.number_of_pets
```
