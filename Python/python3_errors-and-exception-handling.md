## `Try`, `Except`, and `Finally`

- Three Keywords are used to handle erros in Python
    - `try`: This holds the block of code you wanted to attempt to run.
    - `except`: this will execute if an error gets thrown while attempting to run the code in the try block. You can use this to define specific actions to be taken in the event of specified errors.
    - `finally`: a final block of code which will be executed regardless of whether or not an error was thrown.


```python
def add(n1,n2):
    print(n1+n2)
```


```python
add(1,2)
```

    3



```python
number1 = 10
number2 = input("Pick a number:")
```

    Pick a number:23



```python
add(number1,number2) # will throw a TypeError
```


    ---------------------------------------------------------------------------

    TypeError                                 Traceback (most recent call last)

    <ipython-input-5-b411007135a9> in <module>
    ----> 1 add(number1,number2) # will throw a TypeError
    

    <ipython-input-1-48bddae7e371> in add(n1, n2)
          1 def add(n1,n2):
    ----> 2     print(n1+n2)
    

    TypeError: unsupported operand type(s) for +: 'int' and 'str'



```python
try:
    result = 10 + "10" # Same problem as above TypeError

except:
    print("Something went wrong!") # but this time we get a nice warning printed
    print("Let's do something else anyway:") # and can do some other stuff as well
    x = 41
    y = 25
    print(x + y)
    

```

    Something went wrong!
    Let's do something else anyway:
    66



```python
result
```




    20



## `except`-ing for specific errors


```python
try:
    f = open('testfile', 'r')
    f.write("Write a test line.")
except TypeError:
    print("Uh oh, you got a TypeError, dog!")
except OSError:
    print("Damn, looks like you got an OSError, dog.")
finally:
    print("I always run!")
```

    Damn, looks like you got an OSError, dog.
    I always run!


## Using Try-Except in a function


```python
def ask_for_int():
    while True:
        try:
            result = int(input("Pick a number:"))
        except:
            print("That's a no from me, dog.")
        else:
            print("Solid choice, dog.")
            break
        finally:
            print("End of try/except/finally")
```


```python
ask_for_int()
```

    Pick a number:E
    That's a no from me, dog.
    End of try/except/finally



```python

```
