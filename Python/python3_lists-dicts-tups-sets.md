# Lists, Dictionaries, and Tuples
|type|code|features
|:--|:--|:--|
|dict|`{...}`|unordered, unsortable, retrieve items by key
|list|`[...]`|ordered, sortable, retrieve items by index
|tup|`(...)`|ordered, sortable, retrieve items by index, immutable
|set|`{...}`|unordered, unsortable, unique

## <div align="center">Lists</div>


```python
my_list = [1, 2, 3, "alphabet", "curious cat", 32.433]
print(my_list)
print(my_list[3])
print(my_list[2:5])
```

    [1, 2, 3, 'alphabet', 'curious cat', 32.433]
    alphabet
    [3, 'alphabet', 'curious cat']



```python
another_list = ["use", "the", ".pop", "method", "to", "remove", "the", "last", "item"]
print(another_list)
print(another_list.pop())
print(another_list)
```

    ['use', 'the', '.pop', 'method', 'to', 'remove', 'the', 'last', 'item']
    item
    ['use', 'the', '.pop', 'method', 'to', 'remove', 'the', 'last']


## <div align="center">Dictionaries</div>


```python
my_dict = {"Switch": "Nintendo", "Xbox": "Microsoft", "Playstation": "Sony"}
print(my_dict["Switch"])
another_dict = {
    "Nintendo": ["Switch", "Gamecube", "Gameboy", "3DS"],
    "Microsoft": ["Xbox", "Xbox360", "Xbox One", "Xbox Series"],
    "Sony": ["Playstation", "Playstation 2", "Playstation 3", "Playstation 4", "Vita"]
}
print(another_dict["Nintendo"])
print(another_dict["Microsoft"][3])
print(f'I like {another_dict["Nintendo"][0]} and {another_dict["Sony"][-2]} but I prefer the {another_dict["Microsoft"][-1]+" X"} user interface.')
```

    Nintendo
    ['Switch', 'Gamecube', 'Gameboy', '3DS']
    Xbox Series
    I like Switch and Playstation 4 but I prefer the Xbox Series X user interface.


## <div align="center">Tuples</div>


```python
my_tup = (1, 2, "Hello World", 43.564, "Hello World")
print(my_tup)
```

    (1, 2, 'Hello World', 43.564, 'Hello World')



```python
my_tup[1] = 4 # Will throw a TypeError as tuples are immutable
```


    ---------------------------------------------------------------------------

    TypeError                                 Traceback (most recent call last)

    <ipython-input-19-cbc8e1680b12> in <module>
    ----> 1 my_tup[1] = 4 # Will throw a TypeError as tuples are immutable
    

    TypeError: 'tuple' object does not support item assignment



```python
print(my_tup.count("Hello World")) # count method for tuples returns no. of occurences
print(my_tup.index("Hello World")) # index method for tuples return index of first occurence
```

    2
    2


## <div align="center">Sets</div>


```python
my_set = {1, 2, 3, 4}
print(my_set)
my_set.add(5)
print(my_set)
my_set.add(5)
print(my_set)
```

    {1, 2, 3, 4}
    {1, 2, 3, 4, 5}
    {1, 2, 3, 4, 5}



```python

```
