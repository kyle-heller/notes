```python

```


```python

```


```python
class Book():
    
    def __init__(self,title,author,pages):
            self.title = title
            self.author = author
            self.pages = pages
            
    def __str__(self):
        return f"'{self.title}' by {self.author}"
    
    def __len__(self):
        return self.pages
    
    def __del__(self):
        print("A book object has been deleted.")
```


```python
b = Book("Python Course", "José",200)
```


```python
print(b)
```

    'Python Course' by José



```python
str(b)
```




    "'Python Course' by José"




```python
len(b)
```




    200




```python
del b
```

    A book object has been deleted.



```python
len(b)
```


    ---------------------------------------------------------------------------

    NameError                                 Traceback (most recent call last)

    <ipython-input-22-97d8916a185b> in <module>
    ----> 1 len(b)
    

    NameError: name 'b' is not defined



```python

```
