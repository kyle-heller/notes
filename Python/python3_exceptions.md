# Exceptions and `Try`/`Except`
When Python encounters something it doesn't understand it will "raise an exception". An exception is Python's way of notifying the user of errors.


```python
print(2/0) # will raise a ZeroDivisionError exception
```


    ---------------------------------------------------------------------------

    ZeroDivisionError                         Traceback (most recent call last)

    <ipython-input-2-3822a443e7ef> in <module>
    ----> 1 print(2/0) # will raise a ZeroDivisionError exception
    

    ZeroDivisionError: division by zero


## Try
The `try` and `except` keywords are Python's way of allowing you to attempt something that may cause an error and allows you to then "handle" the error if one occurs.


```python
try:
    print(2/0)
except:
    print("Something went wrong")
```

    Something went wrong


### Chained except
You can add multiple except blocks to handle different errors. Python will check if the exception raise matches the name you provided and if so execute the block. NOTE: if you want to include an unnamed except block it should be last, after any & all named except blocks.


```python
try:
    print(2/0)
except ValueError:
    print("I got a ValueError.")
except ZeroDivisionError:
    print("I got a ZeroDivisionError.")
except:
    print("I got some other error.")
```

    I got a ZeroDivisionError.


#### Exception tree
Python 3 defines 63 built-in exceptions some of which branch off into more specific child errors. If the list of exceptions is a tree `BaseException` is the root from which all other exceptions originate. Look at the following list:

 - BaseException
  - SystemExit
  - Exception
    - ValueError
    - LookupError
      - IndexError
      - KeyError
    - ArithmeticError
      - ZeroDivisionError
  - KeyboardInterrupt
  
Each parent exception is more general (abstract) than it's children. This means that you could also catch, for example, a `ZeroDivisionError` with either an `ArithmeticError` block.


```python
try:
    print(2/0)
except ArithmeticError:
    print("I got some sort of arithmetic error")
except ZeroDivisionError:
    print("I got a zero division error")
```

    I got some sort of arithmetic error


#### Exception order
As you can see above, the exception will be handled by the first suitable except block. So, if you want to include multiple branches you should go from the specific to the general.


```python
try:
    print(2/0)
except ZeroDivisionError:
    print("I got a zero division error")
except ArithmeticError:
    print("I got some other type of arithmetic error")
except:
    print("I got an error of some sort.")
```

    I got a zero division error


#### Handling multiple exception types in a single block
You can also handle multiple exceptions in a single block.


```python
try:
    print(2/0)
except (ZeroDivisionError,IndexError,ValueError):
    print("I got either a zero division, index, or value error")
except:
    print("I got some other error")
```

    I got either a zero division, index, or value error


#### Function exceptions
Exceptions raised within a function can be handled either inside or outside the function.


```python
# Handled inside the function
def my_zerodiv_func():
    try:
        print(2/0)
    except:
        print("There was an error within the function, captain!")
    return None

my_zerodiv_func()
```

    There was an error within the function, captain!



```python
# Handled outside the function
def my_indexerr_func(word):
    print(word[32])
    
try:
    my_indexerr_func("tree")
except IndexError:
    print("I'm a Doctor not an IndexError!")
```

    I'm a Doctor not an IndexError!


#### Exception travel
Exceptions can "travel" across function and module boundaries. Meaning Python will look everywhere it can for a suitable exception to handle it and if it can't find one you will see a more traditional error like that at the very top of this page.


```python
def my_bad_func():
    # if python can't find a handler for the exception it encounters WITHIN the function....
    try:
        print(2/0)
    except ValueError:
        print("This isn't my error!")

try:
    # ... it will look OUTSIDE of the function
    my_bad_func()
except ZeroDivisionError:
    print("THIS is my error")
    
```

    THIS is my error



## Raising an exception with the `raise` keyword
Python allows you to intentionally raise an exception with the `raise` keyword


```python
def my_error_func():
    raise KeyError
    
try:
    my_error_func()
except ZeroDivisionError:
    print("Not me! I'm zero division.")
except ValueError:
    print("Not me either! I'm value.")
except KeyError:
    print("Me!! I'm the key error")
```

    Me!! I'm the key error


### re-raising
You can use the `raise` keyword without specifying an error WITHIN AN EXCEPT BLOCK. This will then RE-raise the error that brought it into the except block (sounds confusing, I know).


```python
def another_bad_func():
    try:
        print(2/0)
    except:
        print("Within the func: Uh oh, we got an error! Here, you take it!...")
        raise
        
try:
    another_bad_func()
except ZeroDivisionError:
    print("Outside the func: ..Ah yes, this is my error.")
    
```

    Within the func: Uh oh, we got an error! Here, you take it!...
    Outside the func: ..Ah yes, this is my error.


## Assert
The `assert` keyword can be used if you want to tell Python "if this isn't true stop what you're doing and give me an error".


```python
def my_weird_func():
    assert int(input("Enter a number higher than zero: ")) > 0
    
my_weird_func()
```

    Enter a number higher than zero: 0



    ---------------------------------------------------------------------------

    AssertionError                            Traceback (most recent call last)

    <ipython-input-24-9d1452a3f6d5> in <module>
          2     assert int(input("Enter a number higher than zero: ")) > 0
          3 
    ----> 4 my_weird_func()
    

    <ipython-input-24-9d1452a3f6d5> in my_weird_func()
          1 def my_weird_func():
    ----> 2     assert int(input("Enter a number higher than zero: ")) > 0
          3 
          4 my_weird_func()


    AssertionError: 


## Some useful built-in exceptions

Name|Description|Parent
:--|:--|--:|
ArithmeticError|An abstract/general exception caused by arithmetic operations|Exception
AssertionError|A concrete/specific exception raised by the `assert` keyword|Exception
BaseException|The most abstract/general exception of them all|
IndexError|A concrete/specific exception caused by trying to access a nonexistant index|LookupError
KeyboardInterrupt|A concrete exception raised when the user uses a shortcut to interrupt execution|BaseException
LookupError|An abstract/general exception caused by errors resulting from invalid references|Exception
MemoryError|A concrete exception raised when an operation cannot be completed due to lack of memory|Exception
OverflowError|A concrete exception raised when an operation produces a number too big to be stored|ArithmeticError
ImportError|A concrete exception raised when an import operation fails|StandardError
KeyError|A concrete exception raised when you try to access a collections non-existent element|LookupError



```python

```
