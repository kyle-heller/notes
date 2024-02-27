## Zip


```python
list1 = [5, 6,7]
list2 = ["potato", "potato", "potato more"]
list3 = zip(list1, list2)
for i in list3:
    print(i)
```

    (5, 'potato')
    (6, 'potato')
    (7, 'potato more')


## Enumerate


```python
phrase = "Open the pod bay doors, Hal"
for item in enumerate(phrase):
    print(item)
```

    (0, 'O')
    (1, 'p')
    (2, 'e')
    (3, 'n')
    (4, ' ')
    (5, 't')
    (6, 'h')
    (7, 'e')
    (8, ' ')
    (9, 'p')
    (10, 'o')
    (11, 'd')
    (12, ' ')
    (13, 'b')
    (14, 'a')
    (15, 'y')
    (16, ' ')
    (17, 'd')
    (18, 'o')
    (19, 'o')
    (20, 'r')
    (21, 's')
    (22, ',')
    (23, ' ')
    (24, 'H')
    (25, 'a')
    (26, 'l')


## Input


```python
soylent_green = input("What is Soylent Green made from?")
print(soylent_green)
print(type(soylent_green))
```

    What is Soylent Green made from?People
    People
    <class 'str'>


## List Comprehension


```python
my_phrase = "Gazpacho Soup"
my_list = [temp_var for temp_var in my_phrase]
print(my_list)
```

    ['G', 'a', 'z', 'p', 'a', 'c', 'h', 'o', ' ', 'S', 'o', 'u', 'p']



```python
num_list = [num for num in range(0,15)]
print(num_list)
```

    [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]



```python
new_phrase = "where we're going you won't need eyes"
new_list = [x for x in new_phrase if x != "e" and x != "'"]
print(new_list)
```

    ['w', 'h', 'r', ' ', 'w', 'r', ' ', 'g', 'o', 'i', 'n', 'g', ' ', 'y', 'o', 'u', ' ', 'w', 'o', 'n', 't', ' ', 'n', 'd', ' ', 'y', 's']



```python
new_list = [130,14000,90, 722, 43,19, 2784]
another_list = [x/20+3 for x in new_list]
print(another_list)

```

    [9.5, 703.0, 7.5, 39.1, 5.15, 3.95, 142.2]



```python
description_salad = ["dark", "groovy", "tall", "homely", "gormless"]
being_soup = ["hound", "bard", "alien", "cellist", "brigadier"]
jumble = [f"{x} {y}" for x in description_salad for y in being_soup]
print(jumble)
```

    ['dark hound', 'dark bard', 'dark alien', 'dark cellist', 'dark brigadier', 'groovy hound', 'groovy bard', 'groovy alien', 'groovy cellist', 'groovy brigadier', 'tall hound', 'tall bard', 'tall alien', 'tall cellist', 'tall brigadier', 'homely hound', 'homely bard', 'homely alien', 'homely cellist', 'homely brigadier', 'gormless hound', 'gormless bard', 'gormless alien', 'gormless cellist', 'gormless brigadier']



```python

```
