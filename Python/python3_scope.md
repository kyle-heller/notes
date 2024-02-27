## <div align="center">LEGB Rule</div>
|Letter|Name|Description|
|:--|:--|:--|
|L|Local|Names assigned in any way within a function (`def` or `lambda`) and not declared global in that function|
|E|Enclosing function locals|Names in the local scopre of any and all enclosing functions (`def` or `lambda`), from inner to outer|
|G|Global (module)| Names assigned at the top-level of a module file, or declared global in a `def` within the file|
|B|Built-in (Python)|Names preassigned in the built-in names module: `open`, `range`, `SyntaxError`|


```python
# Local example
# "num" here is a locally scoped variable
lambda num:num**2
```




    <function __main__.<lambda>(num)>



A function will check first if a given variable is present in the local scope, if not it will check the enclosing scope, followed by the global scope.


```python
# name is given the value "Bob" in the global scope
name = "Bob"

def greet():
    # name is given the value "Jim" in the enclosing scope
    name = "Jim" # comment out this line to see the global scope take precedence
    
    def hello():
        # name is given the value "Dave" in the local scope
        name = "Dave" # comment out this line to see the enclosing scope take precedence
        
        print('Hello '+name)
        
    hello()

greet()
```

    Hello Dave



```python

```
