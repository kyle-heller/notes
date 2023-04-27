# Data Types

Ruby is a strongly object-oriented language, which means that absolutely everything in Ruby is an object, even the most basic data types. We’ll start here with four of Ruby’s basic data types: numbers (integers and floats), strings, symbols, and Booleans (true, false, and nil).

## Literals

A literal is any notation that lets you represent a fixed value in source code. For instance, all of the following are literals in Ruby:

```
'Hello, world!'          # string literal
375                      # integer literal
3.141528                 # float literal
true                     # boolean literal
{ 'a' => 1, 'b' => 2 }   # hash literal
[ 1, 2, 3 ]              # array literal
:sym                     # symbol literal
nil                      # nil literal
```

## Numbers (Integers and Floats)

Numbers are represented many ways in Ruby. The most basic form of a number is called an integer. It is represented by the whole number only, with no decimal point. A more complex form of a number is called a float. A float is a number that contains a decimal.

```
# Example of integer literals
1, 2, 3, 50, 10, 4345098098

# Example of float literals
1.2345, 2345.4267, 98.2234
```

It’s important to keep in mind that when doing arithmetic with two integers in Ruby, the result will always be an integer.

```
17 / 5    #=> 3, not 3.4
```

To obtain an accurate answer, just replace one of the integers in the expression with a float.

```
17 / 5.0  #=> 3.4
```

Ruby has all the typical math operators you would expect:

```
# Addition
1 + 1   #=> 2

# Subtraction
2 - 1   #=> 1

# Multiplication
2 * 2   #=> 4

# Division
10 / 5  #=> 2

# Exponent
2 ** 2  #=> 4
3 ** 4  #=> 81

# Modulus (find the remainder of division)
8 % 2   #=> 0  (8 / 2 = 4; no remainder)
10 % 4  #=> 2  (10 / 4 = 2 with a remainder of 2)
```

**#between**



### Modulo

This is represented by the % symbol. It can be referred to as the remainder operator as well, though that is not strictly correct. (There are some subtle differences between modulo and remainder operations). In modulo expressions, the value to the left of the % is called the dividend, and the value to the right is called the modulus.

When working with positive integers, the modulo operator returns the remainder of a division operation. Let's test this.

```
irb :001 > 16 % 5
=> 1
```

### Modulo vs Remainder

In mathematics, there is a subtle, but important, difference between modulo and remainder operations. We won't get into the mathematical definitions, but the effect can be summarized as follows:

Modulo operations return a positive integer when the second operand is positive, and a negative integer when the second operand is negative.

Remainder operations return a positive integer when the first operand is positive, and a negative integer when the first operand is negative.

We can see this definition at work in this table:

| a   |  b  | a % b (modulo) | a.remainder(b) | a.divmod(b) |
| --- | :-: | -------------: | -------------: | ----------: |
| 17  |  5  |              2 |              2 |      [3, 2] |
| 17  | -5  |             -3 |              2 |    [-4, -3] |
| -17 |  5  |              3 |             -2 |     [-4, 3] |
| -17 | -5  |             -2 |             -2 |     [3, -2] |

## Converting Number Types

Ruby makes it very easy to convert floats to integers and vice versa.

```
# To convert an integer to a float:
13.to_f   #=> 13.0

# To convert a float to an integer:
13.0.to_i #=> 13
13.9.to_i #=> 13
```

As shown in the last example above, when Ruby converts a float to an integer, the decimal places are simply cut off. Ruby doesn’t do any rounding in this conversion.

## Some Useful Number Methods

### even?

```
6.even? #=> true
7.even? #=> false
```

### odd?

```
6.odd? #=> false
7.odd? #=> true
```

## Strings

A string is a list of characters in a specific sequence.

In programming, we often have to work with text data like names, messages, and descriptions. Ruby uses strings to represent such data. You write string literals with either single quotes ('hi there') or double quotes ("hi there") on either side of the text; note that the quotes are syntactic components, not part of the value. Both single and double quote formats create a string. However, there are some subtle differences.

If you'd like to include single quotes within your string then you have two options. You can either use the double quote method or the single quote method with escaping:

```
Ex. 1: with double quotes
irb(main):002:0> "The man said, 'Hi there!'"
=> "The man said, 'Hi there!'"

Ex 2: with single quotes and escaping
irb(main):005:0> 'The man said, \'Hi there!\''
=> "The man said, 'Hi there!'"
```

Double quotes allow something called string interpolation. To try it out, type the following into an irb session:

```
irb :001 > a = 'ten'
=> "ten"

irb :002 > "My favorite number is #{a}!"
=> "My favorite number is ten!"
```

### Concatenation

In true Ruby style, there are plenty of ways to concatenate strings.

```
# With the plus operator:
"Welcome " + "to " + "Odin!"    #=> "Welcome to Odin!"

# With the shovel operator:
"Welcome " << "to " << "Odin!"  #=> "Welcome to Odin!"

# With the concat method:
"Welcome ".concat("to ").concat("Odin!")  #=> "Welcome to Odin!"
```

### Substrings

You can access strings inside strings inside strings.

```
"hello"[0]      #=> "h"

"hello"[0..1]   #=> "he"

"hello"[0, 4]   #=> "hell"

"hello"[-1]     #=> "o"
```

### Escape Characters

Escape characters allow you to type in representations of whitespace characters and to include quotation marks inside your string without accidentally ending it. As a reminder, escape characters only work inside double quotation marks.

```
\\  #=> Need a backslash in your string?
\b  #=> Backspace
\r  #=> Carriage return, for those of you that love typewriters
\n  #=> Newline. You'll likely use this one the most.
\s  #=> Space
\t  #=> Tab
\"  #=> Double quotation mark
\'  #=> Single quotation mark
```

### String Interpolation

String interpolation is a handy way to merge Ruby code with strings. The basic syntax is: #{ruby expression goes here}, and the returned expression will be concatenated with the surrounding string.

```
name = "Odin"

puts "Hello, #{name}" #=> "Hello, Odin"
puts 'Hello, #{name}' #=> "Hello, #{name}"
```

### Common String Methods

There are many useful string methods that are built into Ruby and you can find them all in the Ruby docs. https://ruby-doc.org/core-3.1.2/String.html

### #capitalize

```
"hello".capitalize #=> "Hello"
```

### #include?

```
"hello".include?("lo")  #=> true

"hello".include?("z")   #=> false
```

### #upcase

```
"hello".upcase  #=> "HELLO"
```

### #downcase

```
"Hello".downcase  #=> "hello"
```

### #empty?

```
"hello".empty?  #=> false

"".empty?       #=> true
```

### #length

```
"hello".length  #=> 5
```

### #reverse

```
"hello".reverse  #=> "olleh"
```

### #split

```
"hello world".split  #=> ["hello", "world"]

"hello".split("")    #=> ["h", "e", "l", "l", "o"]
```

### #strip

```
" hello, world   ".strip  #=> "hello, world"
```

### #sub

```
"he77o".sub("7", "l")           #=> "hel7o"
```

### #gsub

```
"he77o".gsub("7", "l")          #=> "hello"
```

### #insert

```
"hello".insert(-1, " dude")     #=> "hello dude"
```

### #delete

```
"hello world".delete("l")       #=> "heo word"
```

### #prepend

```
"!".prepend("hello, ", "world") #=> "hello, world!"
```

## Converting other Objects to Strings

Using the to_s method, you can convert pretty much anything to a string. Here are some examples:

```
5.to_s        #=> "5"

nil.to_s      #=> ""

:symbol.to_s  #=> "symbol"
```

## Symbols

Ruby symbols are defined as “scalar value objects used as identifiers, mapping immutable strings to fixed internal values.” Essentially what this means is that symbols are immutable strings.

While Strings are used to work with data symbols identify something.

Ruby symbols are created by placing a colon (:) before a word.

```
# Examples of symbols
:name
:a_symbol
:"surprisingly, this is also a symbol"
```

## nil

In programming, we need a way to express "nothing", and in Ruby, we do this through something called nil. A variable with a value of nil could be described as having 'nothing' or being 'completely empty', or even just simply 'not any specific type'. A situation where this may occur is where output is expected but none is returned, such as:

```
irb :001 > puts "Hello, World!"
Hello, World!
=> nil
```

The puts method prints out a string and returns nothing, so we see nil being returned after the string is displayed.

It is possible to check if something is a nil type by using .nil?. For example:

```
irb :001 > "Hello, World".nil?
=> false
```

An important property of the nil type is that when used in an expression, such as an if statement, it will be treated as false, as it represents an absence of content.

```
irb :001 > if nil
irb :002 > puts "Hello, World!"
irb :003 > end
=> nil
```

if false or if nil won't execute the corresponding condition, because false and nil are considered as falsy values.

In other words, if you cast nil or false as a boolean, it will return false. Every other kind of value is considered truthy in Ruby.

There's an important caveat to this which can best be illustrated by the following example:

```
irb :001 > false == nil
=> false
```

## Booleans

The Boolean values true and false represent exactly what you think they do: true represents something that is true, and false represents something that is false.

### Check for Truthiness

A quick hack (not only specific to Ruby, it also works with JavaScript) is to prepend a double exclamation mark before the variable.

```
!!nil        # nil => false
!!false      # boolean false => false
!!true       # boolean true => true
!!0          # number zero => true
!!42         # number other than zero => true
!!""         # empty string => true
!!" "        # spaces-only string => true
!!"sth"      # non-empty string => true
!![]         # empty array => true
!![nil]      # array with empty values => true
!!['a', 'z'] # non-empty array => true
!!{}         # empty hash => true
!!{a: nil}   # hash with empty values => true
!!{a: 42}    # non-empty hash => true
!!/regex/    # regex => true
!!Time.now   # any object => true
```

## Type Conversion

```
5.to_s        #=> "5"
nil.to_s      #=> ""
:symbol.to_s  #=> "symbol"

# To convert an integer to a float:
13.to_f   #=> 13.0

# To convert a float to an integer:
13.0.to_i #=> 13
13.9.to_i #=> 13

irb :001 > '4'.to_i
=> 4

irb :002 > '4 hi there'.to_i
=> 4

irb :003 > 'hi there 4'.to_i
=> 0

irb :004 > '4'.to_f
=> 4.0

irb :005 > '4 hi there'.to_f
=> 4.0

irb :006 > 'hi there 4'.to_f
=> 0.0
```

## Basic Data Structures

### Arrays

An array is used to organize information into an ordered list. The list can be made up of strings, integers, floats, booleans, or any other data type. In Ruby, an array literal is denoted by square brackets [ ]. Inside the brackets you can create a list of elements separated by commas.

```
irb :001 > [1, 2, 3, 4, 5]
=> [1, 2, 3, 4, 5]
```

We've created an array of integers 1 through 5. Each element in an array can be accessed via an index. The indexes are numbered starting at zero. Thus, if we wanted only the first element in the array we could do this.

```
irb :001 > [ 1, 2, 3, 4, 5][0]
=> 1
```

### Hashes

A hash, sometimes referred to as a dictionary, is a set of key-value pairs. Hash literals are represented with curly braces { }. A key-value pair is an association where a key is assigned a specific value. A hash consists of a key, usually represented by a symbol, that points to a value (denoted using a =>) of any type of data. Let's make some hashes to get the feel of it. Type along!

```
irb :001 > {:dog => 'barks'}
=> {:dog => 'barks'}
```

The above is a hash literal that specifies a single key-value pair. Like arrays, we can have multiple items in a hash if we separate them with commas, but they will not necessarily be in any specific order. Let's add some more items to our hash.

```
irb :001 > {:dog => 'barks', :cat => 'meows', :pig => 'oinks'}
=> {:dog => 'barks', :cat => 'meows', :pig => 'oinks'}
```

What if we wanted to find out what noise a cat makes? We can retrieve a value by its key:

```
irb :001 > {:dog => 'barks', :cat => 'meows', :pig => 'oinks'}[:cat]
=> "meows"
```

## Expressions and Return

An expression is anything that can be evaluated, and pretty much everything you write in Ruby is an expression. An expression in Ruby always returns something, even if that's an error message or nil.

Ruby expressions always return a value, even if that value is nil or an error.
