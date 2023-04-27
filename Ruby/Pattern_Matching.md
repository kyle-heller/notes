# Pattern Matching

Formally, pattern matching is the process of checking any data (be it a sequence of characters, a series of tokens, a tuple, or anything else) against other data.

In terms of programming, depending on the capabilities of the language, this could mean any of the following:

Matching against an expected data type
Matching against an expected hash structure (e.g. presence of specific keys)
Matching against an expected array length
Assigning the matches (or a part of them) to some variables

Two formats for pattern matching in Ruby.

The case/in format is best used when there are multiple conditionals you could possibly match against and you need to check against all of them. The hash rocket syntax is best used when the data structure you are matching against is known, such as the login data example we used above.

The case/in format looks similar to the case statement it just replaces 'when' with 'in' though they cannot be mixed.

If you do not provide an else expression, any failing match will raise a NoMatchingPatternError.

```ruby
grade = 'C'

case grade
in 'A' then puts 'Amazing effort'
in 'B' then puts 'Good work'
in 'C' then puts 'Well done'
in 'D' then puts 'Room for improvement'
else puts 'See me'
end
```

The second format is a one line syntax using the trusty hash rocket that will be familiar to you from hashes.

We’ll get to matching against hashes shortly so don’t worry about the exact syntax of what is happening. Just note that we can use the hash rocket => to match against some kind of structure. The second format is still considered experimental so the examples that follow will use the case statement format.

```ruby
login = { username: 'hornby', password: 'iliketrains' }

login => { username: username }

puts "Logged in with username #{username}"

#=> Logged in with username hornby
```

## Return Values

There are two possible outcomes for a pattern match statement - either there is a match or there is no match. If there is a match, it will return the last evaluated value in the body of the matching branch. If there are no matches, the pattern matching statement will return NoMatchingPatternError. Consider the following example, where the variable result is assigned the value 3.

```ruby
grade = 'C'

result = case grade
  in 'A' then 1
  in 'B' then 2
  in 'C' then 3
  else 0
end

puts result
#=> 3
```

When we puts something inside a case statement, we’ll use #=> to show what puts will print. In your terminal, however, you’ll see the value printed followed by => nil, since puts returns nil. We’ll omit that because it’s not relevant to what we’re trying to show you. Just be aware that the nil you see is just the return value of puts. Standard Ruby behaviour.

As you’ll see, though, the point of a pattern match usually is to not only match against a pattern, but also bind all or part of the match to one or more variables that you can then use outside of the pattern match expression.

## Types of Patterns

### Any Ruby object which is matched using ===. The Object Pattern.

A pattern that matches any Ruby object using the === operator.

Any object can be used in a pattern match. It is matched using === to compare the two objects and is the same basis for matches in the case/when format. This pattern is usually used within other patterns, such as the array pattern.

```ruby
case input
when Integer
  puts "Input is an integer"
when String
  puts "Input is a string"
else
  puts "Input is some other type of object"
end
```

### A variable capture / Variable Pattern

A pattern that matches any object and assigns it to a

```ruby
case input
in x => Integer
  puts "Input is an integer with value #{x}"
in y => String
  puts "Input is a string with value #{y}"
end
```

### An As Pattern

A pattern that captures the matched object to a variable name using the syntax pattern as variable_name.

```ruby
case input
in some_value as x
  puts "The value is #{some_value} and has been assigned to the variable x"
end
```

### An Alternative Pattern

A pattern that matches against one or more patterns using the syntax pattern1 | pattern2 | ....

```ruby
case input
in 0 | "0"
  puts "Input is either the integer 0 or the string '0'"
end
```

### A Guard Condition

A pattern that matches only when a guard condition is true, using the syntax pattern if condition.

```ruby
case input
in x if x < 10
  puts "Input is less than 10"
in x if x >= 10 && x < 20
  puts "Input is between 10 and 20"
else
  puts "Input is 20 or greater"
end
```

### An Array Pattern

A pattern that matches arrays of a specific length or with specific elements using syntax like [pattern1, pattern2, ...] or [pattern1, *pattern2].

```ruby
case input
in [x, y]
  puts "Input is an array with two elements: #{x.inspect} and #{y.inspect}"
in [x, *rest]
  puts "Input is an array with at least two elements: #{x.inspect} and the rest: #{rest.inspect}"
end
```

### A Hash Pattern

A pattern that matches hashes with specific key-value pairs using syntax like {key1: pattern1, key2: pattern2, ...} or {key1: pattern1, \*\*rest}.

```ruby
case input
in {name: "John", age: age}
  puts "Input has a name of 'John' and an age of #{age}"
in {name: "Mary", **rest}
  puts "Input has a name of 'Mary' and additional key-value pairs: #{rest.inspect}"
end
```

### Rightward Assignment

An experimental feature that allows variables to be assigned values using the => operator in a rightward direction, as in pattern => variable_name.

```ruby
case input
in foo => bar
  puts "The value
```

### A Find Pattern

An experimental feature that allows patterns to be used to search for a value in an object or data structure,

```ruby
numbers = [1, 2, [3, 4], [5, [6, 7]]]
case numbers
in [*outer, Find[Array => [x, Find[Integer => 7]]]]
  puts "The array [#{x}, 7] was found in #{outer.inspect}"
end

#The array [6, 7] was found in [[1, 2], [3, 4], [5, [6, 7]]]
```

In this example, we are searching the numbers array for the pattern [x, 7] nested within another array. We are using the Find pattern to search for this specific nested pattern. If a match is found, we capture the elements that precede the matched pattern in the outer variable and print out the result. In this case, the output would be:

## Variable Binding and Pinning in Ruby

As we have seen in some of the above examples, pattern matching is really useful in assigning part of the patterns to arbitrary variables. This is called variable binding, and there are several ways we can bind to a variable:

With a strong type match, e.g. in [Integer => a] or in {a: Integer => a}
Without the type specification, e.g. in [a, 1, 2] or in {a: a}.
Without the variable name, which defaults to using the key name, e.g. in {a:} will define a variable named a with the value at key a.
Bind rest, e.g. in [Integer, *rest] or in {a: Integer, \*\*rest}.
How, then, can we match when we want to use an existing variable as a sub-pattern? This is when we can use variable pinning with the ^ (pin) operator:

```ruby
a = 1
case {a: 1, b: 2}
in {a: ^a}
  "matches"
end
```

You can even use this when a variable is defined in a pattern itself, allowing you to write powerful patterns like this:

```ruby
case order
in {billing_address: {city:}, shipping_address: {city: ^city}}
  puts "both billing and shipping are to the same city"
else
  raise "both billing and shipping must be to the same city"
end
```

One important quirk to mention with variable binding is that even if the pattern doesn't fully match, the variable will still have been bound. This can sometimes be useful.

But, in most cases, this could also be a cause of subtle bugs — so make sure that you don't rely on shadowed variable values that have been used inside a match. For example, in the following, you would expect the city to be "Amsterdam", but it would instead be "Berlin":

```ruby
city = "Amsterdam"
order = {billing_address: {city: "Berlin"}, shipping_address: {city: "Zurich"}}
case order
in {billing_address: {city:}, shipping_address: {city: ^city}}
  puts "both billing and shipping are to the same city"
else
  puts "both billing and shipping must be to the same city"
end
puts city # Berlin instead of Amsterdam
```

## Matching Ruby's Custom Classes

You can implement some special methods to make custom classes pattern matching aware in Ruby.

For example, to pattern match a user against his first_name and last_name, we can define deconstruct_keys on the class:

```ruby
class User
  def deconstruct_keys(keys)
    {first_name: first_name, last_name: last_name}
  end
end

user = User.new

case user
in {first_name: "John"}
  puts "Hey, John"
end
```

The keys argument to deconstruct_keys contains the keys that have been requested in the pattern. This is a way for the receiver to provide only the required keys if computing all of them is expensive.

In the same way as deconstruct_keys, we could provide an implementation of deconstruct to allow objects to be pattern matched as an array. For example, let's say we have a Location class that has latitude and longitude. In addition to using deconstruct_keys to provide latitude and longitude keys, we could expose an array in the form of [latitude, longitude] as well:

```ruby
class Location
  def deconstruct
    [latitude, longitude]
  end
end

case location
in [Float => latitude, Float => longitude]
  puts "#{latitude}, #{longitude}"
end
```

## Using Guards for Complex Patterns

If we have complex patterns that cannot be represented with regular pattern match operators, we can also use an if (or unless) statement to provide a guard for the match:

```ruby
case [1, 2]
in [a, b] if b == a * 2
  "matches"
else
  "no match"
end
```

## Pattern Matching with =>/in Without case

If you are on Ruby 3+, you have access to even more pattern matching magic. Starting from Ruby 3, pattern matching can be done in a single line without a case statement:

```ruby
[1, 2, "Three"] => [Integer => one, two, String => three]
puts one # 1
puts two # 2
puts three # Three

# Same as above
[1, 2, "Three"] in [Integer => one, two, String => three]
```

Given that the above syntax does not have an else clause, it is most useful when the data structure is known beforehand.

As an example, this pattern could fit well inside a base controller that allows only admin users:

```ruby
class AdminController < AuthenticatedController
  before_action :verify_admin

  private

  def verify_admin
    Current.user => {role: :admin}
  rescue NoMatchingPatternError
    raise NotAllowedError
  end
end
```
