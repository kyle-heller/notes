# Decorators and Functions within functions

## Functions within functions &  Functions that `return` functions


```python
def hello(name="Neal"):
    print("The hello() function has been executed!")
    
    def greet():
        return "\t This is the greet() function inside hello!"
    
    def welcome():
        return "\t This is welcome() inside hello!"
    
    print(greet())
    print(welcome())
    if name == "Neal":
        return greet
    else:
        return welcome
```


```python
hello()
```

    The hello() function has been executed!
    	 This is the greet() function inside hello!
    	 This is welcome() inside hello!





    <function __main__.hello.<locals>.greet()>




```python
greet() # Will throw an error as greet() only exists within the scope of the hello function
```


    ---------------------------------------------------------------------------

    NameError                                 Traceback (most recent call last)

    <ipython-input-13-908f44780674> in <module>
    ----> 1 greet() # Will throw an error as greet() only exists within the scope of the hello function
    

    NameError: name 'greet' is not defined



```python
new_function = hello() 
"""
Since hello() returns the greet() function itself if name is "Neal", we have essentially
assigned greet() to the name new_function. Meaning we can now call it 
outside of the scope of hello() by using new_function()
"""
```

    The hello() function has been executed!
    	 This is the greet() function inside hello!
    	 This is welcome() inside hello!





    '\nSince hello() returns the greet() function itself if name is "Neal" we have essential\nassigned greet() to the name new_function. Meaning we can now call it \noutside of the scope of hello() by using new_function()\n'




```python
new_function()
```




    '\t This is the greet() function inside hello!'




```python
def yeah(some_func1, some_func2):
    print("Yeah.")
    
    some_func1()
    some_func2()
```


```python
def i_guess():
    print("I guess.")
    
def ok():
        print("OK.")
```


```python
yeah(ok, i_guess)
```

    Yeah.
    OK.
    I guess.


## Decorators


```python
def new_decorator(some_original_func):
    
    def wrap_func():
        print("Doing some additional stuff!!")
        
        some_original_func()
        
        print("Doing some more additional stuff! Very important!")
        
    return wrap_func
```


```python
def this_function_needs_a_decorator():
    print("Please decorate me!")
```


```python
decorated_function = new_decorator(this_function_needs_a_decorator)
```


```python
decorated_function()
```

    Doing some additional stuff!!
    Please decorate me!
    Doing some more additional stuff! Very important!



```python
@new_decorator
def another_function_in_need_of_a_decorator():
    print("Please decorate me also.")
```


```python
another_function_in_need_of_a_decorator()
```

    Doing some additional stuff!!
    Please decorate me also.
    Doing some more additional stuff! Very important!



```python

```
