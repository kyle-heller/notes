# Strings continued
Strings are immutable.


```python
my_string = 'hijklmnopabcdefg'
del my_string[-1:-5] # will raise a TypeError
```


    ---------------------------------------------------------------------------

    TypeError                                 Traceback (most recent call last)

    <ipython-input-1-96202a03f3ce> in <module>
          1 my_string = 'hijklmnopabcdefg'
    ----> 2 del my_string[-1:-5]
    

    TypeError: 'str' object does not support item deletion


but you can still do most things, you just need to work around the rules of immutibility.


```python
my_string = 'hijklmnopabcdefg'
my_new_string = my_string[9:]+my_string[:9]
my_new_string += 'qrstuvw'
print(my_new_string)
```

    abcdefghijklmnopqrstuvw


## Operations on strings

### min()
`min()` is a function which will find the minimum (the character with the lowest `code point` value) in a string.


```python
print(min('aA'))
print(ord('a'))
print(ord('A'))
```

    A
    97
    65


### max()
`max()` is a function which will find the maximum (the character with the highest code point value) in a string.


```python
print(max('#~'))
print(ord('#'))
print(ord('~'))
```

    ~
    35
    126


### index()
The `index()` method will search a string for the given character and return it's index value of the first occurence.


```python
print('I am the very model of a modern major general.'.index('.'))
print('Soylent Green is people!'.index('G'))
```

    45
    8


### list()
The `list()` function will convert a string into a list, treating each character as a separate list item.


```python
hal_list = list('Open the pod bay doors, HAL')
print(hal_list)
```

    ['O', 'p', 'e', 'n', ' ', 't', 'h', 'e', ' ', 'p', 'o', 'd', ' ', 'b', 'a', 'y', ' ', 'd', 'o', 'o', 'r', 's', ',', ' ', 'H', 'A', 'L']


### count()
The `count()` method will count the number of occurences of a given character.


```python
print("Bow to your Sensei...BOW TO YOUR SENSEI!".count('B'))
```

    2


## String Methods
Some common string methods

### capitalize()


```python
print("what's wrong with TODAY today?".capitalize())
```

    What's wrong with today today?


### center()
The center() method has two variants. The single parameter version will try to center the text inside a field of the specified width. The two-parameter version will do the same but instead of whitespace as padding it will use the supplied character.


```python
# single parameter version
print("monday".center(20))

# two parameter version
print("friday".center(20,"!"))
```

           monday       
    !!!!!!!friday!!!!!!!


### endswith()
The `endswith()` method will return a boolean depending on whether or not a string ends with the given character.


```python
print("I know Kung Fu?".endswith("!"))
```

    False


### find()
The `find()` method works similarly to the `index()` except will return `-1` if the given substring isn't found (instead of raising an error) and it only works with strings. You can provide a second argument if you want to search the string beyond a specified index or three arguments if you want to search a specific section e.g. `my_string.find(char,startindex,endindex)`


```python
print("Nothing that has meaning is easy. Easy doesn't enter into grown-up life.".find("E"))
print("I wanna change my clothes, my hair, my face.".find("f"))
print("The rat man will forgive you....this time.".find("r",2))
print("I'll flip you. Flip you for real.".find("y",5,18))
```

    34
    39
    4
    10


### isalnum()
The `isalnum()` returns a boolean depending on whether or not the string contains only alphanumeric characters e.g. 'abcd123'.


```python
print("I'm blue abadee abadie do-abadee abadie".isalnum()) # whitespace and punctuation are not alphanumerical chars
print("Imblueabadeeabadiedoabadeeabadie".isalnum())
```

    False
    True


### isalpha() and isdigit()
As you might expect `isapha()` returns a boolean based on whether the string contains only letters. `isdigit()` does the same but for numbers.


```python
print("abcde1234".isalpha())
print("324506".isdigit())
```

    False
    True


### islower(), isupper(), and isspace()
`islower()` returns a bool based on whether or not the string is all lowercase. `isupper()` does the same but for uppercase. `isspace()` returns a bool based on whether or not the string is whitespace only.


```python
print("I'm not all lowercase".islower())
print("BUT I AM ALL UPPERCASE".isupper())
print("                                                ".isspace())
```

    False
    True
    True


### join()
`join()` is a string method but it expects a list argument and it will return the list items joined into a single string using the character provided e.g. `joining_char.join([list_to_be_joined])`


```python
print("~".join(["what","is","love","baby","don't","hurt","me"]))
```

    what~is~love~baby~don't~hurt~me


### lower()
Returns the string as all lowercase.


```python
print("I'M MAD AS HELL AND I'M NOT GONNA TAKE IT ANYMORE".lower())
```

    i'm mad as hell and i'm not gonna take it anymore


### lstrip()
Removes the leading whitespace i.e. whitespace at the beginning of the string. `rstrip()` does the same for the opposite side whereas `strip()` does both. Additionally you can provide characters which you also want removed.


```python
print("   foo".lstrip())
print("bar     foo".rstrip("foo"))
print("   foobar   ".strip())
```

    foo
    bar     
    foobar


### replace()
`replace()` takes two arguments and will replace all occurences of the first arg with the second arg.


```python
print("My name is Maximus Decimus Meridius. Father to a murdered son. Husband to a murdered wife. And I will have my vengeance.".replace("vengeance","cake"))
```

    My name is Maximus Decimus Meridius. Father to a murdered son. Husband to a murdered wife. And I will have my cake.


### rdind()
Essentially reversen-find. Does the same as the `find()` method but starts at the end and works backwards.


```python
print("Funny how?".rfind("F"))
```

    0


### split()
Kind of like the opposite of `join()`, it will split a string into a list using whitespace as the delimiter.


```python
print("I don't like cricket. No. I love it!".split("."))
```

    ["I don't like cricket", ' No', ' I love it!']


### startswith()
Same as `endswith()` but at the start.


```python
print("I shot the clerk?".startswith("I"))
```

    True


### swapcase()
Will reverse the case of it's string.


```python
print("I DON'T LIKE REGGAE. NO. i love it.".swapcase())
```

    i don't like reggae. no. I LOVE IT.



```python

```
