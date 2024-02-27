# <div align="center">String Interpolation</div>

## .format


```python
print("This is a sentence and {}.".format("this is another sentence"))
print("I am the very model of a {} {} {}.".format("modern", "major", "general"))
```

    This is a sentence and this is another sentence.
    I am the very model of a modern major general.



```python
print("I am the very model of a {2} {1} {0}.".format("modern", "major", "general"))
print("I am the very model of a {era} {rank2} {rank1}.".format(era="modern", rank1="major", rank2="general"))
```

    I am the very model of a general major modern.
    I am the very model of a modern general major.


### Float formatting
`{value:width.precision f}`

<div align="center">Before</div>


```python
print("{good} legs good. {better} legs better.".format(good=2, better=400/97))
```

    2 legs good. 4.123711340206185 legs better.


<div align="center">After</div>


```python
print("{good} legs good. {better:1.3f} legs better.".format(good=2, better=400/97))
```

    2 legs good. 4.124 legs better.


## % Placeholder
|placeholder|type|result|
|:--|:--|:--|
|`%s`|string|inserts as normal|
|`%r`|report|string representation of object (basically it inserts with quotation marks|
|`%d`|integer|converts to whole number|


```python
print("This is quite similar to the %r method but uses the %s symbol." %(".format", "modulo"))
print("Here is a number converted from a decimal: %d" %(3.14532))
print("You can also do %s with this placeholder. For example: %1.3f" %("float formatting", 24.56811097412))
```

    This is quite similar to the '.format' method but uses the modulo symbol.
    Here is a number converted from a decimal: 3
    You can also do float formatting with this placeholder. For example: 24.568


## F-Strings
`f"the string you want with {variables} inserted wherever you {want} them"`


```python
liquid1 = "tears"
liquid2 = "rain"
liquid3 = "soup"
print(f"All those moments will be lost in time. Like {liquid1} in {liquid2}.")
print(f"You can use '!r' to get the 'string representation' like this:")
```

    All those moments will be lost in time. Like tears in rain.



```python
functionality = "string representation"
print(f"You can add '!r' after an f-string placeholder to return the {functionality} like this: {functionality!r}")
```

    You can add '!r' after an f-string placeholder to return the string representation like this: 'string representation'



```python
insert1 = "curly braces"
insert2 = 42.98345678123
print(f"Float formatting is very similar but with {insert1} like this: {insert2:{0}.{3}f}")
```

    Float formatting is very similar but with curly braces like this: 42.983



```python

```
