# Variables

Variables are used to store information to be referenced and manipulated in a computer program. They also provide a way of labeling data with a descriptive name, so our programs can be understood more clearly by the reader and ourselves.

It is helpful to think of variables as containers that hold information. Their sole purpose is to label and store data in memory. This data can then be used throughout your program.

```
desired_location = "Barcelona"
johns_location = desired_location

desired_location  #=> "Barcelona"
johns_location    #=> "Barcelona"
```

```
johns_location.upcase!  #=> "BARCELONA"

desired_location        #=> "BARCELONA"
johns_location          #=> "BARCELONA"
```

```
irb :001 > a = 4
=> 4
irb :002 > b = a
=> 4
irb :003 > a = 7
=> 7
```

**Variables are References**

The information you name with a variable is stored in memory on your computer, so a variable is effectively a reference or a pointer to that address in memory. This is important to know as it can sometimes be the cause of unexpected behavior from your code.

## Assigning Value to Variables

Naming variables is known as one of the most difficult tasks in computer programming. When you are naming variables, think hard about the names. Try your best to make sure that the name you assign your variable is accurately descriptive and understandable to another reader.

When you assign a variable, you use the = symbol. The name of the variable goes on the left and the value you want to store in the variable goes on the right.

```
irb :001 > first_name = 'Joe'
=> "Joe"

irb :002 > first_name
=> "Joe"
```

Let's try a little something. Look at the following irb session.

```
irb :001 > a = 4
=> 4
irb :002 > b = a
=> 4
irb :003 > a = 7
=> 7
```

What is the value of b at this point? Take your best guess and then type this session into irb to find out.

You'll notice that the value of b remains 4, while a was re-assigned to 7. This shows that variables point to values in memory, and are not deeply linked to each other. If this is confusing, don't worry, we'll have plenty of exercises for you to complete that will make this information clear and obvious. And when in doubt, always try it out in irb.

## Variable Scope

A variable's scope determines where in a program a variable is available for use. A variable's scope is defined by where the variable is initialized or created. In Ruby, variable scope is defined by a method definition or by a block. They have different behaviors when it comes to variable scope.

Methods - In terms of variable scope, methods have self-contained scope. That means that only variables initialized within the method's body can be referenced or modified from within the method's body. Additionally, variables initialized inside a method's body aren't available outside the method's body. It's a bit like an impenetrable bubble.

Block - A block is a piece of code that follows a method's invocation, delimited by either curly braces {} or do/end. With blocks, the one rule that we want to emphasize is that: **Inner scope can access variables initialized in an outer scope, but not vice versa.**

## Types of Variables

There are five types of variables. Constants, global variables, class variables, instance variables, and local variables.

**Constants**
declared by capitalizing every letter in the variable's name

```
MY_CONSTANT = 'I am available throughout your app.'
```

**Global Variables**

Global variables are declared by starting the variable name with the dollar sign ($). These variables are available throughout your entire app, overriding all scope boundaries. Rubyists tend to stay away from global variables as there can be unexpected complications when using them.

```
$var = 'I am also available throughout your app.'
```

**Class Variables**

Class variables are declared by starting the variable name with two @ signs. These variables are accessible by instances of your class, as well as the class itself. When you need to declare a variable that is related to a class, but each instance of that class does not need its own value for this variable, you use a class variable. Class variables must be initialized at the class level, outside of any method definitions. They can then be altered using class or instance method definitions.

```
@@instances = 0

```

**Instance Variables**

Instance variables are declared by starting the variable name with one @ sign. These variables are available throughout the current instance of the parent class. Instance variables can cross some scope boundaries, but not all of them. You will learn more about this when you get to OOP topics, and should not use instance variables until you know more about them.

```
@var = 'I am available throughout the current instance of this class.'
```

**Local Variables**

Local variables are the most common variables you will come across and obey all scope boundaries. These variables are declared by starting the variable name with neither $ nor @, as well as not capitalizing the entire variable name.

```
var = 'I must be passed around to cross scope boundaries.'
```
