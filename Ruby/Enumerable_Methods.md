# Enumerable Methods

##Basic Enumerable Methods

Enumerables are a set of convenient built-in methods in Ruby that are included as part of both arrays and hashes. There are some iteration patterns that you’ll find yourself doing again and again, such as transforming, searching for, and selecting subsets of elements in your collections. Enumerables were designed to make implementing these iteration patterns (and therefore your life as a developer) much, much easier.

Enumerable gives you lots of useful ways of doing something to every element of a collection object (an array or hash, for instance), which is a very common thing to do when you're building programs and websites.

https://ruby-doc.org/core-3.1.2/Enumerable.html

## Enumerable Iterators Cheat Sheet

- #each returns the original object it was called on because it's really used for its side effects and not what it returns
- #each_with_index passes not just the current item but whatever position in the array it was located in.
- #select returns a new object (e.g. array) filled with only those original items where the block you gave it returned true
- #map returns a new array filled with whatever gets returned by the block each time it runs.
- #reduce passes not just the element but whatever was returned by the previous iteration into the block. You can either specify the initial value or it will just default to the first item of the array. It ultimately returns whatever the result of the last iteration is.
- #any? returns true/false (see the question mark?) and answers the question, "do ANY of the elements in this object pass the test in my block?". If your block returns true on any time it runs, any? will return true.
- #all? returns true/false and answers the question, "do ALL the elements of this object pass the test in my block?". Every time the block runs it must return true for this method to return true.
- #none? returns true only if NONE of the elements in the object return true when the block is run.
- #find returns the first item in your object for which the block returns true.
- #group_by will run your block and return a hash that groups all the different types of returns from that block. - #grep returns an array with those items that actualy match the specified criteria (RegEx) (using a === match)

## Predicate Enumerable Method Cheatsheet

- #all? returns true if ALL elements are true (or empty array)
- #any? returns true if AT LEAST one element is true (or non-empty array)
- #one? returns true if EXACTLY one element is true (or array is of size 1)
- #none? returns true if NO elements are true (or empty array)

These 4 methods return either true or false.

Since Ruby 2.5 these 4 methods (any? / all? / none? / one?) also take an argument which works like grep’s argument.

```
[:orange, :apple, :coconut].any?(Symbol)
# true
[1,2,3].all?(1..10)
# true
```

This is a nice little shortcut if you want to check for a class, regular expression or a range.

## #each

Calling #each on an array will iterate through that array and will yield each element to a code block, where a task can be performed:

```
friends = ['Sharon', 'Leo', 'Leila', 'Brian', 'Arun']

friends.each { |friend| puts "Hello, " + friend }

#=> Hello, Sharon
#=> Hello, Leo
#=> Hello, Leila
#=> Hello, Brian
#=> Hello, Arun

#=> ["Sharon", "Leo", "Leila", "Brian" "Arun"]
```

- friends is the array that contains strings of your friends’ names.
- .each is the enumerable method you are calling on your friends array.
- { |friend| puts "Hello, " + friend } is a block, and the code inside this block is run for each element in your array. Because we have 5 friends in our array, this block will be run 5 times, once with each of the 5 elements.
- Within the block, you’ll notice that we have |friend|, which is known as a block variable. This is the element from your array that the block is currently iterating over. You can use any variable name that you find helpful here; in this example, we could have used |x|, but |friend| is more descriptive of what each element is. In the first iteration, the value of |friend| will be 'Sharon'; in the second iteration, its value will be 'Leo'; in the third, 'Leila'; and so on until it reaches the end of the array.

#each also works for hashes with a bit of added functionality. By default, each iteration will yield both the key and value individually or together (as an array) to the block depending on how you define your block variable:

```
my_hash = { "one" => 1, "two" => 2 }

my_hash.each { |key, value| puts "#{key} is #{value}" }

one is 1
two is 2
#=> { "one" => 1, "two" => 2}

my_hash.each { |pair| puts "the pair is #{pair}" }

the pair is ["one", 1]
the pair is ["two", 2]
#=> { "one" => 1, "two" => 2}
```

You may have noticed in the above code examples that #each returns the original array or hash regardless of what happens inside the code block. This is an important thing to keep in mind when debugging your code as it can lead to some confusion.

```
friends = ['Sharon', 'Leo', 'Leila', 'Brian', 'Arun']

friends.each { |friend| friend.upcase }

#=> ['Sharon', 'Leo', 'Leila', 'Brian', 'Arun']
```

You might expect this to return ['SHARON', 'LEO', 'LEILA', 'BRIAN', 'ARUN'], but you’d be wrong—dead wrong. It actually returns the original array you called #each on.

## #each_with_index

This method is nearly the same as #each, but it provides some additional functionality by yielding two block variables instead of one as it iterates through an array. The first variable’s value is the element itself, while the second variable’s value is the index of that element within the array. This allows you to do things that are a bit more complex.

For example, if we only want to print every other word from an array of strings, we can achieve this like so:

```
fruits = ["apple", "banana", "strawberry", "pineapple"]

fruits.each_with_index { |fruit, index| puts fruit if index.even? }

#=> apple
#=> strawberry
#=> ["apple", "banana", "strawberry", "pineapple"]
```

Just like with the #each method, #each_with_index returns the original array it’s called on.

## #map (also known as #collect)

The #map method (also called #collect) transforms each element from an array according to whatever block you pass to it and returns the transformed elements in a new array.It won’t change the original.If you want to change the original array you can use map!.

#map may seem confusing at first, but it is extremely useful.

```
friends = ['Sharon', 'Leo', 'Leila', 'Brian', 'Arun']

friends.map { |friend| friend.upcase }
#=> `['SHARON', 'LEO', 'LEILA', 'BRIAN', 'ARUN']`
```

Maybe now you’re getting hungry from all this intense learning and you want to change your McDonald’s order from medium to extra large.

```
my_order = ['medium Big Mac', 'medium fries', 'medium milkshake']

my_order.map { |item| item.gsub('medium', 'extra large') }
#=> ["extra large Big Mac", "extra large fries", "extra large milkshake"]
```

```
salaries = [1200, 1500, 1100, 1800]

salaries.map { |salary| salary - 700 }
#=> [500, 800, 400, 1100]
```

Doubling numbers:

```
array = [1,2,3]
array.map { |n| n * 2 }
# [2, 4, 6]
```

Convert strings to integers:

```
array = ["11", "21", "5"]
array.map { |str| str.to_i }
# [11, 21, 5]
```

Convert hash values to symbols:

```
hash = { bacon: "protein", apple: "fruit" }
hash.map { |k,v| [k, v.to_sym] }.to_h
# {:bacon=>:protein, :apple=>:fruit}
```

```
> my_array.collect{|num| num**2 }
=> [4,16,36,64,10000]
```

```
u = User.all
@user_emails = u.map { |user| user.email }
```

## #map_with_index

If you need an index with your values you can use the with_index method.

```
array = %w(a b c)
array.map.with_index { |ch, idx| [ch, idx] }
# [["a", 0], ["b", 1], ["c", 2]]
```

You can pass a parameter to with_index if you don’t want to start from index 0.

## #select

The #select method (also called #filter) passes every item in an array to a block and returns a new array with only the items for which the condition you set in the block evaluated to true.

First, let’s explore how we would accomplish the same thing using #each:

```
friends = ['Sharon', 'Leo', 'Leila', 'Brian', 'Arun']
invited_list = []

friends.each do |friend|
  if friend != 'Brian'
    invited_list.push(friend)
  end
end

invited_list
 #=> ["Sharon", "Leo", "Leila", "Arun"]
```

Using our shiny new #select method, this code can be simplified down to two lines:

```
friends = ['Sharon', 'Leo', 'Leila', 'Brian', 'Arun']

friends.select { |friend| friend != 'Brian' }

 #=> ["Sharon", "Leo", "Leila", "Arun"]
```

Now that we’ve cut out Brian, we can send out the invites! Let’s say that the friends who you invited to your party have gotten back to you, and their responses are all recorded in a hash. Let’s use #select to see who’s coming.

Recall that when you use an enumerable method with a hash, you need to set up block variables for both the key and the value:

```
responses = { 'Sharon' => 'yes', 'Leo' => 'no', 'Leila' => 'no', 'Arun' => 'yes' }
responses.select { |person, response| response == 'yes'}
#=> {"Sharon"=>"yes", "Arun"=>"yes"}
```

```
> my_array.select{|item| item%2==0 }
=> [2,4,6,8,100]      # wow, that was easy.
```

```
> my_hash = {"Joe" => "male", "Jim" => "male", "Patty" => "female"}
> my_hash.select{|name, gender| gender == "male" }
=> {"Joe" => "male", "Jim" => "male"}
```

## #reduce (also called #inject)

The reduce method reduces an array or hash down to a single object. You should use #reduce when you want to get an output of a single value.

A classic example of when #reduce is useful is obtaining the sum of an array of numbers. First, let’s explore how we would achieve this using #each:

```
my_numbers = [5, 6, 7, 8]
sum = 0

my_numbers.each { |number| sum += number }

sum
#=> 26
```

This isn’t too bad in terms of number of lines of code, but we had to introduce a temporary local variable (sum) outside of the enumerable. It would be much nicer if we could do all of this within the enumerable:

```
my_numbers = [5, 6, 7, 8]

my_numbers.reduce { |sum, number| sum + number }
#=> 26
```

The first block variable in the #reduce enumerable (sum in this example) is known as the accumulator. The result of each iteration is stored in the accumulator and then passed to the next iteration. The accumulator is also the value that the #reduce method returns at the end of its work. By default, the initial value of the accumulator is the first element in the collection, so for each step of the iteration, we would have the following:

1. Iteration 0: sum = 5 + 6 = 11
2. Iteration 1: sum = 11 + 7 = 18
3. Iteration 2: sum = 18 + 8 = 26

We can also set a different initial value for the accumulator by directly passing in a value to the #reduce method.

```
my_numbers = [5, 6, 7, 8]

my_numbers.reduce(1000) { |sum, number| sum + number }
#=> 1026
```

Another example:

```
votes = ["Bob's Dirty Burger Shack", "St. Mark's Bistro", "Bob's Dirty Burger Shack"]

votes.reduce(Hash.new(0)) do |result, vote|
  result[vote] += 1
  result
end
#=> {"Bob's Dirty Burger Shack"=>2, "St. Mark's Bistro"=>1}
```

The zero in the hash.new is the default value. See the following example:

```
hundreds = Hash.new(100)
hundreds["first"]         #=> 100
hundreds["mine"]          #=> 100
hundreds["yours"]         #=> 100
```

Once you set the value for a key equal to something else, the default value is overwritten:

```
hundreds = Hash.new(100)
hundreds["new"]           #=> 100
hundreds["new"] = 99
hundreds["new"]           #=> 99
```

Now that we know that this new hash with a default value of 0 is our accumulator (which is called result in the code block), let’s see what happens in each iteration:

1. Iteration 0:
   result = {}
   Remember, this hash already has default values of 0, so result["Bob's Dirty Burger Shack"] == 0 and result["St. Mark's Bistro"] == 0
2. Iteration 1:
   The method runs result["Bob's Dirty Burger Shack"] += 1
   result = {“Bob’s Dirty Burger Shack” => 1}
3. Iteration 2:
   The method runs result["St. Mark's Bistro"] += 1
   result = {“Bob’s Dirty Burger Shack” => 1, “St. Mark’s Bistro” => 1}
4. Iteration 3:
   The method runs result["Bob's Dirty Burger Shack"] += 1
   result = {“Bob’s Dirty Burger Shack” => 2, “St. Mark’s Bistro” => 1}

Note that this example returns a hash with several key => value pairs. So even though the result is more complicated, #reduce still just returns one object, a hash.

## Bang Methods

Enumerables like #map and #select return new arrays but don’t modify the arrays that they were called on. This is by design since we won’t often want to modify the original array or hash and we don’t want to accidentally lose that information.

If you wanted to change the original array instead, you could use a bang method such as #map!:

```
friends = ['Sharon', 'Leo', 'Leila', 'Brian', 'Arun']

friends.map! { |friend| friend.upcase }
#=> `['SHARON', 'LEO', 'LEILA', 'BRIAN', 'ARUN']`

friends
#=> `['SHARON', 'LEO', 'LEILA', 'BRIAN', 'ARUN']`
```

Now when we call our original friends array again, it returns the changed values from the #map! method. Instead of returning a new array, #map! modified our original array.

## Return Values of Enumerables

So if it’s not a good idea to use bang methods but we need to re-use the result of an enumerable method throughout our program, what can we do instead?

One option is to put the result of an enumerable method into a local variable:

```
friends = ['Sharon', 'Leo', 'Leila', 'Brian', 'Arun']

invited_friends = friends.select { |friend| friend != 'Brian' }

friends
#=> ['Sharon', 'Leo', 'Leila', 'Brian', 'Arun']

invited_friends
#=> ["Sharon", "Leo", "Leila", "Arun"]
```

An even better option would be to wrap your enumerable method in a method definition:

```
friends = ['Sharon', 'Leo', 'Leila', 'Brian', 'Arun']

def invited_friends(friends)
  friends.select { |friend| friend != 'Brian' }
end

friends
#=> ['Sharon', 'Leo', 'Leila', 'Brian', 'Arun']

invited_friends(friends)
 #=> ["Sharon", "Leo", "Leila", "Arun"]
```

## #group_by

#group_by will run your block and return a hash that groups all the different types of returns from that block. For example:

```
> names = ["James", "Bob", "Joe", "Mark", "Jim"]
> names.group_by{|name| name.length}
=> {5=>["James"], 3=>["Bob", "Joe", "Jim"], 4=>["Mark"]}
```

## #grep

#grep returns an array with those items that actualy match the specified criteria (RegEx) (using a === match)

```
> names = ["James", "Bob", "Joe", "Mark", "Jim"]
> names.grep(/J/)
=> ["James", "Joe", "Jim"]
```

## Shorthand Versions

You can also use a shorthand version when calling a method that doesn't need any arguments.

```
["11", "21", "5"].map(&:to_i)
```

```
["orange", "apple", "banana"].map(&:class)
```

# Predicate Enumerable Methods

A predicate method is indicated by a question mark (?) at the end of the method name and returns either true or false.

## #include?

The #include? method works exactly like you think it should. If we want to know whether a particular element exists in an array, we can use the #include? method. This method will return true if the element you pass as an argument to #include? exists in the array or hash; otherwise, it will return false.

First, let’s explore how we would achieve this with the #each method:

```
numbers = [5, 6, 7, 8]
element = 6
result = false

numbers.each do |number|
  if number == element
    result = true
  end
end

result
# => true

element = 3
result = false

numbers.each do |number|
  if number == element
    result = true
  end
end

result
#=> false
```

Using #include?, this code can be greatly simplified:

```
numbers = [5, 6, 7, 8]

numbers.include?(6)
#=> true

numbers.include?(3)
#=> false
```

For another example, let’s return to the friends and invited_friends arrays from the previous lesson:

```
friends = ['Sharon', 'Leo', 'Leila', 'Brian', 'Arun']

invited_list = friends.select { |friend| friend != 'Brian' }

invited_list.include?('Brian')
#=> false
```

## #any?

The #any method returns true if any elements in your array or hash match the condition within the block; otherwise, it will return false.

Let’s say we want to see if there is any number greater than 500 or less than 20 in an array of numbers. First, let’s see how we could achieve this using #each.

```
numbers = [21, 42, 303, 499, 550, 811]
result = false

numbers.each do |number|
  if number > 500
    result = true
  end
end

result
#=> true

numbers = [21, 42, 303, 499, 550, 811]
result = false

numbers.each do |number|
  if number < 20
    result = true
  end
end

result
#=> false
```

Using #any?, this code can be greatly simplified:

```
numbers = [21, 42, 303, 499, 550, 811]

numbers.any? { |number| number > 500 }
#=> true

numbers.any? { |number| number < 20 }
#=> false
```

## #all?

The all? method is also fairly intuitive. It only returns true if all the elements in your array or hash match the condition you set within the block; otherwise, it will return false.

Let’s say that we want to check whether all the words in our list are more than 6 characters long. First,let’s see how we could achieve this using #each:

```
fruits = ["apple", "banana", "strawberry", "pineapple"]
matches = []
result = false

fruits.each do |fruit|
  if fruit.length > 3
    matches.push(fruit)
  end

  result = fruits.length == matches.length
end

result
#=> true

fruits = ["apple", "banana", "strawberry", "pineapple"]
matches = []
result = false

fruits.each do |fruit|
  if fruit.length > 6
    matches.push(fruit)
  end

  result = fruits.length == matches.length
end

result
#=> false
```

Using #all?, this code can be greatly simplified:

```
fruits = ["apple", "banana", "strawberry", "pineapple"]

fruits.all? { |fruit| fruit.length > 3 }
#=> true

fruits.all? { |fruit| fruit.length > 6 }
#=> false
```

Special note to keep in mind while debugging: #all? will return true by default unless the block returns false or nil. So if you call #all? on an empty array or hash (i.e., there are no elements for the block to evaluate), it will return true.

## #none?

As you might expect, #none? performs the opposite function of #all?. It returns true only if the condition in the block matches none of the elements in your array or hash; otherwise, it returns false.

First, let’s see how this could be achieved using #each. You’ll notice that this approach is very similar to what we did for #all?.

```
fruits = ["apple", "banana", "strawberry", "pineapple"]
matches = []
result = false

fruits.each do |fruit|
  if fruit.length > 10
    matches.push(fruit)
  end

  result = matches.length == 0
end

result
#=> true

fruits = ["apple", "banana", "strawberry", "pineapple"]
matches = []
result = false

fruits.each do |fruit|
  if fruit.length > 6
    matches.push(fruit)
  end

  result = matches.length == 0
end

result
#=> false
```

Using #none?, this can be greatly simplified:

```
fruits = ["apple", "banana", "strawberry", "pineapple"]

fruits.none? { |fruit| fruit.length > 10 }
#=> true

fruits.none? { |fruit| fruit.length > 6 }
#=> false
```
