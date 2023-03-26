# Conditional Logic

Any conditional statement will always have an expression that evaluates to true or false. Based on this answer, the computer will decide whether or not to execute the code that follows. If it’s true, then the code will be processed; if it’s false, the code will be skipped, and you can provide some other code that will be run instead. There can even be several conditional statements on one line, but keep in mind that too many can make code look cluttered.

## Truthy and Falsy in Ruby

The only false values in Ruby are the values nil and false themselves. That’s it! Everything else is considered true.

## If Statement

The simplest way to control the flow of your code using conditionals is with the if statement.

```
if statement_to_be_evaluated == true
  # do something awesome...
end

if 1 < 2
  puts "Hot diggity, 1 is less than 2!"
end
#=> Hot diggity, 1 is less than 2!
```

If there is only one line of code to be evaluated inside the block, then you can rewrite the code to be more succinct and take up only one line:

```
puts "Hot diggity damn, 1 is less than 2" if 1 < 2
```

## If/Else and Elsif

We often want to check a condition and run some code if it’s true but then run some other code if it’s false. This is done with an if...else statement.

```
if attack_by_land == true
  puts "release the goat"
elsif attack_by_sea == true
  puts "release the shark"
else
  puts "release Kevin the pigeon"
end
```

## Boolean Logic

To determine whether an expression evaluates to true or false, you’ll need a comparison operator. There are several provided by Ruby:

== (equals) returns true if the values compared are equal.

```
5 == 5 #=> true
5 == 6 #=> false
```

!= (not equal) returns true if the values compared are not equal.

```
5 != 7 #=> true
5 != 5 #=> false
```

> (greater than) returns true if the value on the left of the operator is larger than the value on the right.

```
7 > 5 #=> true
5 > 7 #=> false
```

< (less than) returns true if the value on the left of the operator is smaller than the value on the right.

```
5 < 7 #=> true
7 < 5 #=> false
```

> = (greater than or equal to) returns true if the value on the left of the operator is larger than or equal to the value on the right.

```
7 >= 7 #=> true
7 >= 5 #=> true
```

<= (less than or equal to) returns true if the value on the left of the operator is smaller than or equal to the value on the right.

```
5 <= 5 #=> true
5 <= 7 #=> true
```

#eql? checks both the value type and the actual value it holds.

```
5.eql?(5.0) #=> false; although they are the same value, one is an integer and the other is a float
5.eql?(5)   #=> true
```

#equal? checks whether both values are the exact same object in memory. This can be slightly confusing because of the way computers store some values for efficiency. Two variables pointing to the same number will usually return true.

```
a = 5
b = 5
a.equal?(b) #=> true
```

This expression is true because of the way computers store integers in memory. Although two different variables are holding the number 5, they point to the same object in memory. However, consider the next code example:

```
a = "hello"
b = "hello"
a.equal?(b) #=> false
```

This happens because computers can’t store strings in the same efficient way they store numbers. Although the values of the variables are the same, the computer has created two separate string objects in memory.

<=> (spaceship operator) is most commonly used in sorting functions and returns the following:

-1 if the value on the left is less than the value on the right;
0 if the value on the left is equal to the value on the right; and
1 if the value on the left is greater than the value on the right.

```
5 <=> 10    #=> -1
10 <=> 10   #=> 0
10 <=> 5    #=> 1
```

## Logical Operators

The && operator returns true if both the left and right expressions return true.

```
if 1 < 2 && 5 < 6
  puts "Party at Kevin's!"
end

# This can also be written as
if 1 < 2 and 5 < 6
  puts "Party at Kevin's!"
end
```

|| - the "or" operator. Either the expression to the left has to be true, or the expression to the right has to be true for the entire expression to be evaluated to true.

```
irb :001 > (4 == 4) || (5 == 5)
=> true

irb :002 > (4 == 5) || (5 == 5)
=> true

irb :002 > (4 == 5) || (5 == 6)
=> false
```

One thing to keep in mind with the && and || operators is the order of logic. The expressions are always evaluated from left to right.

Ruby follows an order of precedence when deciding how to evaluate multiple expressions. The following is a list of operations from highest order of precedence (top) to lowest (bottom).

1. <=, <, >, >= - Comparison
2. ==, != - Equality
3. && - Logical AND
4. || - Logical OR

Ex.

```
if x && y || z
  # do something
end
```

First the x && y statement will be executed. If that statement is true, then the program will execute the # do something code on the next line. If the x && y statement is false, then the z will be evaluated. If the z is true, the code on the next line will be evaluated. If the z is false, then the code will exit the if statement.

## Short Circuit Evaluation

Using the && operator, both expressions must return true. If the first expression encountered returns false, then the second expression is never checked. To the Ruby interpreter, it’s pointless to evaluate the second half as the overall expression can never return true.

With the || operator, if the first expression evaluates to true, then the second expression is never checked because the complete expression is already true, and the code in the block is run.

```
if 10 < 2 || 5 < 6 #=> although the left expression is false, there is a party at Kevin's because the right expression returns true
  puts "Party at Kevin's!"
end

# This can also be written as
if 10 < 2 or 5 < 6
  puts "Party at Kevin's!"
end
```

The ! operator reverses the logic of the expression. Therefore, if the expression itself returns false, using the ! operator makes the expression true, and the code inside the block will be executed.

# Case Statements

Case statements are a neat way of writing several conditional expressions that would normally result in a messy if...elsif statement. You can even assign the return value from a case statement to a variable for use later.

Case statements use the reserved words case, when, else, and end. You create one by first defining a case and then evaluating the value of the case and what operation to complete if that case is true.

```
grade = 'F'

did_i_pass = case grade #=> create a variable `did_i_pass` and assign the result of a call to case with the variable grade passed in
  when 'A' then "Hell yeah!"
  when 'D' then "Don't tell your mother."
  else "'YOU SHALL NOT PASS!' -Gandalf"
end
```

If you need to do some more complex code manipulation, you can remove the then keyword and instead place the code to be executed on the next line.

```
grade = 'F'

case grade
when 'A'
  puts "You're a genius"
  future_bank_account_balance = 5_000_000
when 'D'
  puts "Better luck next time"
  can_i_retire_soon = false
else
  puts "'YOU SHALL NOT PASS!' -Gandalf"
  fml = true
end
```

An unless statement works in the opposite way as an if statement: it only processes the code in the block if the expression evaluates to false. You should use an unless statement when you want to not do something if a condition is true, because it can make your code more readable than using if !true.

```
age = 19
puts "Welcome to a life of debt." unless age < 18

unless age < 18
  puts "Down with that sort of thing."
else
  puts "Careful now!"
end
```

## Ternary Operator

The ternary operator is a one-line if...else statement that can make your code much more concise.

Its syntax is conditional statement ? <execute if true> : <execute if false>. You can assign the return value of the expression to a variable.

```
age = 19
response = age < 18 ? "You still have your entire life ahead of you." : "You're all grown up."
puts response #=> "You're all grown up."
```

Ternary expressions should usually be used to select between 2 values, not to choose between two actions. (An action would be something like printing a value or setting a variable to a new value.) The ternary expression's result should almost always be assigned to a variable, passed to a method as an argument, or returned by a method. If you're not doing one of those things, an if/else statement is a better choice.

Good examples:

```
foo = hitchhiker ? 42 : 3.1415    # Assign result of ?: to a variable
puts(hitchhiker ? 42 : 3.1415)    # Pass result as argument
return hitchhiker ? 42 : 3.1415    # Return result
```

Bad examples:

```
hitchhiker ? (foo = 42) : (bar = 3.1415) # Setting variables
hitchhiker ? puts(42) : puts(3.1415)      # Printing
```
