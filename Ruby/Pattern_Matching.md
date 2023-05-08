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

The variable pattern binds a variable or variables to the values that match the pattern.

The basic format is:

```ruby
age = 15

case age
in a
  puts a
end

# => 15
```

This example isn’t useful in itself, but lays the foundation for use in other patterns as we’ll see.

Something to take note of is that the variable pattern always binds the value to the variable. Be careful if there is another variable with the same name in the outer scope which you’ll need.

```ruby
a = 5

case 1
in a
  a
end

puts a
#=> 1
```

Above, you might have thought you were comparing the value held in the initial a variable against the value 1 from the case statement. What actually happened is a variable assignment pattern match. To avoid this, Ruby provides the pin operator ^ which instead matches against a variable of that name.

### An As Pattern

The as pattern is similar to the variable pattern but can be used to manage more complex assignments. This will make most sense when using Arrays and Hashes so examples will be shown when covering those patterns but the general pattern is written as follows:

```ruby
case 3
in 3 => a
  puts a
end

# => 3
```

It uses the hash rocket in the same way the one line pattern match does. Look out for the examples in later sections for clarification on when this pattern could be useful.

### An Alternative Pattern

A pattern that matches against one or more patterns using the syntax pattern1 | pattern2 | ....

```ruby
case 0
in 0 | 1 | 2
  puts :match
end

# => match
```

There isn’t much more to it. The same rules apply as with any other pattern. So you can use the ^ operator if you are using variables to compare.

### A Guard Condition

This isn’t a pattern per se, but a way to make sure the pattern is only matched if the guard condition holds true.

```ruby
some_other_value = true

case 0
in 0 if some_other_value
  puts :match
end

# => match
```

You can use any expression in the condition that can evaluate to true or false. You can also use unless instead of if if it suits you.

### An Array Pattern

Matching against arrays can be done in a few different ways. At its most basic, you can match against the exact elements in the array.

```ruby
arr = [1 ,2]

case arr
in [1, 2] then puts :match
in [3, 4] then puts :no_match
end

# => match
```

That works using the === operator from the object pattern match so would work using case/when. That’s no fun, so let’s ramp it up a little bit.

```ruby
arr = [1, 2]

case arr
in [Integer, Integer]
  puts :match
in [String, String]
  puts :no_match
end

# => match
```

Here we’ve matched against the type of the arrays elements. This is an example of Ruby matching against a pattern rather than the actual values in the array.

What happens if we have more elements in the array?

```ruby
arr = [1, 2, 3]

case arr
in [Integer, Integer]
  puts :no_match
end

# => [1, 2, 3] (NoMatchingPatternError)
```

An error! Ruby appears to only match against arrays with the same number of elements. What if you want to match against only part of an array? Use the trusty splat \*.

```ruby
arr = [1, 2, 3]

case arr
in [Integer, Integer, *]
  puts :match
end

# => match
```

You can place the splat anywhere in an array to match against multiple entries.

```ruby
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

case arr
in [Integer, Integer, *, Integer, Integer]
  puts :match
end

# => match
```

Here we are checking only the first and last two elements are Integers. You can also mix and match between checking actual values and types.

```ruby
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

case arr
in [Integer, Integer, *, 9, 10]
  puts :match
end

# => match
```

If you want to scoop up the values of the array matched against the splat, you can use the variable pattern.

```ruby
arr = [1, 2, 3, 4]

case arr
in [1, 2, *tail]
  p tail
end

# => [3, 4]
```

If you don’t care about some values in the array and are happy to match against any value for that index you can use \_.

```ruby
arr = [1, 2, 3, 4]

case arr
in [_, _, 3, 4]
  puts :match
end

# => match
```

Let’s say you want to match against an array of two numbers, but only if they aren’t the same number. You can use a guard clause.

```ruby
arr = [1, 2]
case arr
in [a, b] unless a == b
  puts :match
end

# => match
```

You can even match against nested arrays.

```ruby
arr = [1, 2, [3, 4]]

case arr
in [_, _, [3, 4]]
  puts :match
end

# => match
```

This is where the real power of pattern matching shines: traversing deeply nested structures for matches.

You can incorporate the variable pattern to bind matching values to variables to use later.

```ruby
arr = [1, 2, 3, 4, 5]

case arr
in [1, 2, 3, a, b]
  puts a
  puts b
end

# => 4
# => 5
```

Let’s say you have a nested array and you want to match against both the nested array and some individual parts of it. This is where the as pattern can be used.

```ruby
case [1, 2, 3, [4, 5]]
in [1, 2, 3, [4, a] => arr]
  puts a
  p arr
end

# => 5
# => [4, 5]
```

Be careful with variable reassignment as we discussed earlier.

```ruby
arr = [1, 2, 3]

case [1, 2, 4]
in arr
  :match
end

p arr

# => [1, 2, 4]
```

One last point to note is that when matching an array the [] are optional on the outer array.

```ruby
arr = [1, 2, 3, 4]

case arr
in 1, 2, 3, 4
  puts :match
end

# => match
```

### A Hash Pattern

Pattern Matching with Hashes works in a similar way to arrays with a couple of important differences. The first is that pattern matching only works for symbol keys, not string keys. The reason for this is to do with how Ruby matches against a hash. This may change in future Ruby versions. The second important difference is that unlike with arrays, you can match against parts of a Hash without having to handle the fact there may be additional key-value pairs.

We can match against the actual values of a hash.

```ruby
case { a: 'apple', b: 'banana' }
in { a: 'aardvark', b: 'bat' }
  puts :no_match
in { a: 'apple', b: 'banana' }
  puts :match
end

# => match
```

```ruby
 case { a: 'apple', b: 'banana' }
 in { a: 'aardvark', b: 'bat' }
   puts :no_match
 in { a: 'apple' }
   puts :match
 end

# => match
```

We can match against a hash and assign values to variables.

```ruby
case { a: 'apple', b: 'banana' }
in { a: a, b: b }
  puts a
  puts b
end

# => apple
# => banana
```

Because of Ruby syntactic sugar for hashes, we could rewrite the above as below. Note how we don’t have to provide names for the variables. This isn’t pattern matching behaviour but normal Ruby hash behaviour.

```ruby
case { a: 'apple', b: 'banana' }
in { a:, b: }
  puts a
  puts b
end

# => apple
# => banana
```

As with arrays, with hashes you can omit the brackets {}.

```ruby
case { a: 'apple', b: 'banana' }
in a:, b:
  puts a
  puts b
end

# => apple
# => banana
```

You can use the double splat \*\* to scoop up multiple key-value pairs.

```ruby
case { a: 'ant', b: 'ball', c: 'cat' }
in { a: 'ant', **rest }
  p rest
end

# => { :b => "ball", :c => "cat" }
```

Something to be mindful of with hashes is that because a hash will match with only a subset of keys matching, you need to guard against situations where you don’t want that behaviour.

```ruby
case { a: 'ant', b: 'ball' }
in { a: 'ant' }
  'this will match'
in { a: 'ant', b: 'ball' }
  'this will never be reached'
end
```

If you want to ensure you only match exactly you can use \*\*nil.

```ruby
case { a: 'ant', b: 'ball' }
in { a: 'ant', **nil }
  puts :no_match
in { a: 'ant', b: 'ball' }
  puts :match
end

# => match
```

We can use the as pattern to assign the entire hash match to a variable.

```ruby
case { a: 'ant', b: 'ball' }
in { a: 'ant' } => hash
  p hash
end

#=> { :a => 'ant', :b => 'ball' }
```

### Rightward Assignment

Usually, you place variables on the left of an expression that binds a value to that variable. With rightward assignment you deconstruct an object and assign values to variables on the right of the expression. Instead of using = to assign you use a hash rocket =>.

All of the previous patterns we’ve covered can be used in this syntax.

```ruby
case input
in foo => bar
  puts "The value
```

The case/in format is best used when there are multiple conditionals you could possibly match against and you need to check against all of them. The hash rocket syntax is best used when the data structure you are matching against is known, such as the login data example we used above.

### A Find Pattern

As we saw earlier, we can match against part of a hash using the array pattern match. So what do you do if you need to match against part of an array? The as pattern would capture all of the array and the variable pattern captures individual parts of it. To address this, Ruby added the find pattern.

It works by placing a _ either side of the part you want to match. You can even use the variable pattern to give each _ a variable name to reference later. Let’s look at some examples.

```ruby
case [1, 2, 3]
in [*pre, 1, 2, 3, *post]
  p pre
  p post
end

# => []
# => []
```

Because everything was matched between the pattern our pre and post variables were assigned empty arrays. Let’s see what happens when they aren’t.

```ruby
case [1, 2, 3, 4, 5]
in [*pre, 2, 3, *post]
  p pre
  p post
end

# => [1]
# => [4, 5]
```

Here’s an interesting one. Let’s say you have a mixed array of strings and integers and want to match on the first instance of two consecutive strings. While that would be a bit of a pain to implement without using pattern matching, with the find pattern it’s easy. We can even throw in the as pattern to grab the values of the two consecutive strings.

```ruby
case [1, 2, "a", 4, "b", "c", 7, 8, 9]
in [*pre, String => x, String => z, *post]
  p pre
  p x
  p z
  p post
end

# => [1, 2, "a", 4]
# => "b"
# => "c"
# => [7, 8, 9]
```

As a last example, we’ll consider a common use case which will hopefully show where the find pattern could be a better fit than a conventional Ruby solution. It’s not uncommon in Ruby to find yourself with an array of hashes or JSON data, and you might need to locate a record from that data. You need to match that data on a few hash keys. The data might look something like this.

```ruby
data = [
  {name: 'James', age: 50, first_language: 'english', job_title: 'general manager'},
  {name: 'Jill', age: 32, first_language: 'italian', job_title: 'leet coder'},
  {name: 'Helen', age: 24, first_language: 'dutch', job_title: 'biscuit quality control'},
  {name: 'Bob', age: 64, first_language: 'english', job_title: 'table tennis king'},
  {name: 'Betty', age: 55, first_language: 'spanish', job_title: 'pie maker'},
]
```

Let’s say you get a name, age, and job title as parameters. If that person exists, you need to return their first language, otherwise nil. Before pattern matching, you may do something like this.

```ruby
name = 'Jill'
age = 32
job_title = 'leet coder'

match = data.find do |person|
  person[:name] == name && person[:age] == age && person[:job_title] == job_title
end

match&.fetch(:first_language)
```

A couple of things to note here. Firstly, because match could be nil if it couldn’t find a record, we had to use the & safe search navigator to check that we could call fetch on match. Otherwise, it would have blown up with a no method error. Secondly, while this isn’t actually that bad, imagine we had more than 3 fields to search. What if there were 10? Our code would start to get out of control.

Now let’s see how we could have handled it using a pattern match.

```ruby
name = 'Jill'
age = 32
job_title = 'leet coder'

case data
in [*, { name: ^name, age: ^age, first_language: first_language, job_title: ^job_title }, *]
else
  first_language = nil
end

puts first_language

# => italian
```

With pattern matching, we do need to consider the case if there is no match. Without the else clause, we’d get the no matching pattern error. But that is exactly what the else clause is for in the case statement. We get a couple of benefits from doing it this way. Firstly, we can bind the first_language value to a variable right there in the pattern. Secondly, and we acknowledge this is somewhat subjective, but we find it beneficial in the case statement to see exactly what kind of data structure we’re trying to match against. This can be useful when getting to grips with code where the data may come from a third party API. And remember, this is still a very simplistic example. In the real world, data can be nested several levels deep which can lead to a horrible tangle of spaghetti code when trying to make sure you can locate a value several levels deep. What if you had to dive 6 levels, but grab a value or two along the way from a couple of the higher levels? No problem with pattern matching.

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
