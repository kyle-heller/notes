# Method Resolution Order (MRO)
MRO is a strategy which a particular programming language scans through the upper part of a class's hierarch in order to find the method it needs. Different languages implement different MROs. As noted previously Python scans from bottom-to-top and then left-to-right. What happens if you mix things around?




```python
class Top:
    def print_top(self):
        print("Top")
        
class Middle(Top):
    def print_mid(self):
        print("Middle")
        
class Bottom(Top, Middle): # listing Top before Middle contradicts the established hierarchy (Top>Middle>Bottom)
    def print_bot(self):
        print("Bottom")
        
        
new_object = Bottom()

new_object.print_bot()
new_object.print_mid()
new_object.print_top()
```


    ---------------------------------------------------------------------------

    TypeError                                 Traceback (most recent call last)

    <ipython-input-3-b5fd10827334> in <module>
          7         print("Middle")
          8 
    ----> 9 class Bottom(Top, Middle): # listing Top before Middle contradicts the established hierarchy (Top>Middle>Bottom)
         10     def print_bot(self):
         11         print("Bottom")


    TypeError: Cannot create a consistent method resolution
    order (MRO) for bases Top, Middle


## The Diamond Problem
The __diamon problem__ describes a possible confusing situation that can arise when using multiple inheritance. So called because of this pattern:

&nbsp;&nbsp;&nbsp;`A
 / \
B   C
 \ /
  D
`

Where __A__ is the top-most superclass, __B__ and __C__ are subclases derived from A, and __D__ is the bottom-most subclass and is derived from *BOTH* B and C.

Now if B and C both have a method of the same name, which one will be used by D?


```python
class Top:
    def print_top(self):
        print("Top")
        
class LeftMiddle(Top):
    def print_mid(self):
        print("Left Middle")
        
class RightMiddle(Top):
    def print_mid(self):
        print("Right Middle")
        
class Bottom(LeftMiddle, RightMiddle): 
    def print_bot(self):
        print("Bottom")
        
        
new_object = Bottom()

new_object.print_bot()
new_object.print_mid()
new_object.print_top()
```

    Bottom
    Left Middle
    Top



```python

```
