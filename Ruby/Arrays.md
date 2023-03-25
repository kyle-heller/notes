# Arrays

An ordered list of values. The elements in an array can be any combination of variables, numbers, strings, and other Ruby objects (including other arrays!).

```
num_array = [1, 2, 3, 4, 5]
str_array = ["This", "is", "a", "small", "array"]
```

## Creating Arrays

Arrays are commonly created with an array literal, which is simply a special syntax used to create instances of an array object. To create a new array using an array literal, use square brackets ([]).

An array can also be created by calling the Array.new method. When you call this method, you can also include up to 2 optional arguments (initial size and default value):

```
Array.new #=> []
Array.new(3) #=> [nil, nil, nil]
Array.new(3, 7) #=> [7, 7, 7]
Array.new(3, true) #=> [true, true, true]
```

## Accessing Elements

Every element in an array has an index which starts at zero. There are also some special indices such as -1 and -2 which start from the end of the list.

```
str_array = ["This", "is", "a", "small", "array"]

str_array[0] #=> "This"
str_array[1] #=> "is"
str_array[4] #=> "array"
str_array[-1] #=> "array"
str_array[-2] #=> "small"
```

Ruby also provides the #first and #last array methods, which should be self-explanatory. In addition, these methods can take an integer argument, e.g., myArray.first(n) or myArray.last(n), which will return a new array that contains the first or last n elements of myArray, respectively.

```
str_array = ["This", "is", "a", "small", "array"]

str_array.first #=> "This"
str_array.first(2) #=> ["This", "is"]
str_array.last(2) #=> ["small", "array"]
```

## Adding and Removing Elements

#push method

shovel operator <<

Both methods will add elements to the end of an array and return that array with the new elements. Both the push and the << methods mutate the caller, so the original array is modified.

The #pop method will remove the element at the end of an array and return the element that was removed.

```
num_array = [1, 2]

num_array.push(3, 4) #=> [1, 2, 3, 4]
num_array << 5 #=> [1, 2, 3, 4, 5]
num_array.pop #=> 5
num_array #=> [1, 2, 3, 4]
```

The #unshift method adds elements to the beginning of an array and returns that array (much like #push).

The #shift method removes the first element of an array and returns that element (much like #pop).

```
num_array = [2, 3, 4]

num_array.unshift(1) #=> [1, 2, 3, 4]
num_array.shift #=> 1
num_array #=> [2, 3, 4]
```

It’s also useful to know that both #pop and #shift can take integer arguments:

```
num_array = [1, 2, 3, 4, 5, 6]

num_array.pop(3) #=> [4, 5, 6]
num_array.shift(2) #=> [1, 2]
num_array #=> [3]
```

## Adding and Subtracting Arrays

Adding two arrays will return a new array built by concatenating them, similar to string concatenation. The concat method works the same way.

```
a = [1, 2, 3]
b = [3, 4, 5]

a + b #=> [1, 2, 3, 3, 4, 5]
a.concat(b) #=> [1, 2, 3, 3, 4, 5]
```

To find the difference between two arrays, you can subtract them using -. This method returns a copy of the first array, removing any elements that appear in the second array.

```
[1, 1, 1, 2, 2, 3, 4] - [1, 4] #=> [2, 2, 3]
```

## Basic Array methods

Ruby gives you many methods to manipulate arrays and their contents (over 150!), many of which are beyond the scope of this lesson. For full documentation, go to http://ruby-doc.org/, click on “Core API”, scroll down to the Classes section, and click on “Array”. There, you’ll find the most up-to-date documentation on the various methods available to Ruby arrays along with explanations.

Calling the #methods method on an array will also yield a long list of the available methods.

num_array.methods #=> A very long list of methods

Other common methods:

```
[].empty? #=> true
[[]].empty? #=> false
[1, 2].empty? #=> false

[1, 2, 3].length #=> 3

[1, 2, 3].reverse #=> [3, 2, 1]

[1, 2, 3].include?(3) #=> true
[1, 2, 3].include?("3") #=> false

[1, 2, 3].join #=> "123"
[1, 2, 3].join("-") #=> "1-2-3"
```

### #insert

With insert you can add a new element to an array at any position.

```
arr.insert(3, 'apple') #=> [0, 1, 2, 'apple', 3, 4, 5, 6]
```

### #sample

Returns one or more random elements.

```
a = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
a.sample # => 3
a.sample # => 8
```

### #shuffle!

Replaces self with its elements in random order.

```
a = [1, 2, 3] #=> [1, 2, 3]
a.shuffle #=> [2, 3, 1]
a #=> [1, 2, 3]
```

### #uniq

Iterates through an array, deletes any duplicate values that exist, then returns the result as a new array.

Returns a new Array containing those elements from self that are not duplicates, the first occurrence always being retained.

With no block given, identifies and omits duplicates using method eql? to compare:

```
a = [0, 0, 1, 1, 2, 2]
a.uniq # => [0, 1, 2]
```

With a block given, calls the block for each element; identifies (using method eql?) and omits duplicate values, that is, those elements for which the block returns the same value:

```
a = ['a', 'aa', 'aaa', 'b', 'bb', 'bbb']
a.uniq {|element| element.size } # => ["a", "aa", "aaa"]
```

### #map

Iterates over an array applying a block to each element of the array and returns a new array with those results. It does not mutate the caller.

collect method is an alias to map.

```
irb :001 > a = [1, 2, 3, 4]
=> [1, 2, 3, 4]
irb :002 > a.map { |num| num**2 }
=> [1, 4, 9, 16]
irb :003 > a.collect { |num| num**2 }
=> [1, 4, 9, 16]
irb :004 > a
=> [1, 2, 3, 4]
```

### #delete_at

Eliminates the value at a certain index from your array. Mutates the caller.

```
irb :005 > a.delete_at(1)
=> 2
irb :006 > a
=> [1, 3, 4]
```

### #delete

The delete method permanently deletes all instances of the provided value from the array.

```
irb :007 > my_pets = ["cat", "dog", "bird", "cat", "snake"]
=> ["cat", "dog", "bird", "cat", "snake"]
irb :008 > my_pets.delete("cat")
=> "cat"
irb :009 > my_pets
=> ["dog", "bird", "snake"]
```
