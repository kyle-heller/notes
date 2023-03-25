# Loops

## Basic Loop

Loop that will loop continually unless conditions in a break statement are met. Usually there is a more fitting loop available.

```
i = 0

loop do
  puts "i is #{i}"
  i += 1
  break if i == 10
end
```

## While Loop

Will loop until a condition is met which must be specified up front. It will run until its break condition is met, which could be for a variable number of loops or a number of loops that is initially unknown.

```
i = 0
while i < 10 do
  puts "i is #{i}"
  i += 1
end
```

######

You can also use while loops to repeatedly ask a question of the user until they give the desired response:

```
while gets.chomp != "yes" do
  puts "Will you go to prom with me?"
end
```

## Until Loop

Opposite of the while loop. It continues for as long as a condition is false. Used to avoid negation (!) which is considered harder to read/understand.

```
i = 0
until i >= 10 do
  puts "i is #{i}"
  i += 1
end
```

######

```
until gets.chomp == "yes" do
  puts "Will you go to prom with me?"
end
```

## Do/while loop (not included in Ruby explicitly)

Works in a similar way to a while loop; one important difference is that the code within the loop gets executed one time, prior to the conditional check to see if the code should be executed. In a "do/while" loop, the conditional check is placed at the end of the loop as opposed to the beginning. Unfortunately, Ruby doesn't have a built-in "do/while" loop -- we have to use loop and break to emulate the behavior of a "do/while" loop.

```
loop do
  answer = gets.chomp
  if answer != 'Y'
    break
  end
end
```

## Ranges

Ruby lets us use something called a range to define an interval. All we need to do is give Ruby the starting value, the ending value, and whether we want the range to be inclusive or exclusive.

```
(1..5) # inclusive range: 1, 2, 3, 4, 5
(1...5) # exclusive range: 1, 2, 3, 4
```

We can make ranges of letters, too!

```
('a'..'d') # a, b, c, d
```

A range literal:

Ranges that use '..' to include the given end value.

```
(1..4).to_a # => [1, 2, 3, 4]
('a'..'d').to_a # => ["a", "b", "c", "d"]
```

Ranges that use '...' to exclude the given end value.

```
(1...4).to_a # => [1, 2, 3]
('a'...'d').to_a # => ["a", "b", "c"]
```

## For Loop

A for loop is used to iterate through a collection of information such as an array or range. These loops are useful if you need to do something a given number of times while also using an iterator.

```
for i in 0..5
  puts "#{i} zombies incoming!"
end
```

## Times Loop

Loops for a specified number of times. You can also access the number it is currently iterating through. Loops start from zero index unless specified otherwise.

```
5.times do
puts "Hello, world!"
end
```

```
5.times do |number|
puts "Alternative fact number #{number}"
end

# Alternative fact number #0

# Alternative fact number #1

# Alternative fact number #2...
```

## Upto and Downto Loops

Iterate from a starting number either up to or down to another number, respectively.

```
5.upto(10) {|num| print "#{num} " } #=> 5 6 7 8 9 10

10.downto(5) {|num| print "#{num} " } #=> 10 9 8 7 6 5
```

## Break and Next

The break keyword allows us to exit a loop at any point, so any code after a break will not be executed. Note that break will not exit the program, but only exit the loop and execution will continue on from after the loop.

Next can be used to skip the rest of the current iteration and start executing the next iteration

```
i = 0
loop do
  i = i + 2
  if i == 4
    next # skip rest of the code in this iteration
  end
  puts i
  if i == 10
    break
  end
end

#2
#6
#8
#10
```

# Scope and Loops

## Loop Loop Scope

As with any other block in Ruby, the block passed to the loop loop introduces a new scope. From inside the block, you can access variables that were initialized outside of the block. However, from outside the block, you can't access any variables that were initialized inside the block.

```
loop do
  x = 42
  break
end

puts x # Raises an error -- x is not in scope outside of the block
```

####

```
x = 42
loop do
  puts x # Prints 42 -- x is in scope inside the block
  x = 2 # We can even change the value of x
  break
end

puts x # 2 -- the value was changed
```

## While/Until/For Loop Scope

Unlike the loop method, these are not implemented as a method. One consequence of this difference is, that unlike loop, a while loop does not have its own scope -- the entire body of the loop is in the same scope as the code that contains the while loop:

```
x = 0
while x < 5
  y = x \* x
  x += 1
end

puts y # 16
```

## Iterators

Iterators are methods that naturally loop over a given set of data and allow you to operate on each element in the collection.

```
names = ['Bob', 'Joe', 'Steve', 'Janice', 'Susan', 'Helen']

names.each { |name| puts name }

Bob
Joe
Steve
Janice
Susan
Helen
```

## Blocks

A block is just some lines of code ready to be executed.

Two formats to use

Single line - {|| action}
Multi line - do end

```
names = ['Bob', 'Joe', 'Steve', 'Janice', 'Susan', 'Helen']
```

```
names.each { |name| puts name }
```

```
names.each do
 |name| puts name
 end
```

## Recursion

Recursion is another way to create a loop in Ruby. Recursion is the act of calling a method from within itself.

Example 1: Let's say you wanted to double the number until the pre-doubled number is 10 or greater. You could create the following method:

```
def doubler(start)
puts start \* 2
end
```

And then you can use it like this:

```
irb(main):001:0> def doubler(start)
irb(main):002:1> puts start \* 2
irb(main):003:1> end
=> :doubler
irb(main):004:0> doubler(2)
4
=> nil
irb(main):005:0> doubler(4)
8
=> nil
irb(main):006:0> doubler(8)
16
=> nil
```

You can do this much more simply using recursion. Take a look at this version of the method:

```
irb(main):001:0> def doubler(start)
irb(main):002:1> puts start
irb(main):003:1> if start < 10
irb(main):004:2> doubler(start \* 2)
irb(main):005:2> end
irb(main):006:1> end
=> :doubler
irb(main):007:0> doubler(2)
2
4
8
16
=> nil
```

Example 2:

We are using a method that uses recursion to calculate the nth number in the fibonacci sequence. You can learn more about the fibonacci sequence here. Basically, it is a sequence of numbers in which each number is the sum of the previous two numbers in the sequence.

```
def fibonacci(number)
if number < 2
number
else
fibonacci(number - 1) + fibonacci(number - 2)
end
end

puts fibonacci(6)
```

![alt text](https://d2aw5xe2jldque.cloudfront.net/books/ruby/images/fibonacci_diagram.jpg "Recursion Graphic")

The key concept with recursion is that there is some baseline condition that returns a value, which then "unwinds" the recursive calls. You can think of the successive recursive calls building up, until some value is returned, and only then can the recursive calls be evaluated.
