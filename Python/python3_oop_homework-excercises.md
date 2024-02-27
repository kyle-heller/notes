___

<a href='https://www.udemy.com/user/joseportilla/'><img src='../Pierian_Data_Logo.png'/></a>
___
<center><em>Content Copyright by Pierian Data</em></center>

# Object Oriented Programming
## Homework Assignment

#### Problem 1
Fill in the Line class methods to accept coordinates as a pair of tuples and return the slope and distance of the line.


```python
# distance = sqrt((x2 - x1)**2 + (y2 - y1)**2)
# slope = (y2 - y1) / (x2 - x1)

import math

class Line:
    
    def __init__(self,coor1,coor2):
        self.x1,self.y1 = coor1
        self.x2,self.y2 = coor2
    
    def distance(self):
        x = (self.x2 - self.x1)**2
        y = (self.y2 - self.y1)**2
        return math.sqrt(x + y)
    
    def slope(self):
        return (self.y2-self.y1) / (self.x2 - self.x1)
```


```python
# EXAMPLE OUTPUT

coordinate1 = (3,2)
coordinate2 = (8,10)

li = Line(coordinate1,coordinate2)
```


```python
li.distance()
```




    9.433981132056603




```python
li.slope()
```




    1.6



________
#### Problem 2

Fill in the class 


```python
# cylinder_volume = π * cylinder_radius² * cylinder_height
# base_area = 2 * π * r²
# lateral_area = (2 * π * r) * h
# total_area = base_area + lateral_area

class Cylinder:
    
    def __init__(self,height=1,radius=1):
        self.height = height
        self.radius = radius
        self.pi = 3.14
        
    def volume(self):
        return self.pi * (self.radius**2) * self.height
    
    def surface_area(self):
        base_area = 2 * self.pi * (self.radius**2)
        lateral_area = (2 * self.pi * self.radius) * self.height
        return base_area + lateral_area
```


```python
# EXAMPLE OUTPUT
c = Cylinder(2,3)
```


```python
c.volume()
```




    56.52




```python
c.surface_area()
```




    94.2




```python

```
