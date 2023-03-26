# Methods

'A named block of code that takes input and returns output'

Methods are an object’s behaviour

Objects have methods, allowing us to do interesting stuff with them. An object’s methods are things that the object can do.

Another way of putting this is: Methods are a way of assigning a name to a certain piece of code. Just like a variable allows to “look up” or refer to the object that the name was assigned to … methods allow to execute their code.

## Creating a Method

```
def my_name
  "Joe Smith"
end

puts my_name    #=> "Joe Smith"
```

- def is a built-in keyword that tells Ruby that this is the start of a method definition.

- my_name is the name of your new method. You can name your methods almost anything you want, but there are some constraints and conventions, which are described in the next section.

- "Joe Smith" is the code inside the method body. All of the logic for your method is contained in the indented lines of the method body. This particular method returns a string when the method is called.

- end is a built-in keyword that tells Ruby that this is the end of the method definition.

## Naming Methods

- You cannot name your method one of Ruby’s approximately 40 reserved words, such as end, while, or for. Checkout the full list here. http://www.java2s.com/Code/Ruby/Language-Basics/Rubysreservedwords.htm
- You cannot use any symbols other than \_, ?, !, and =.
- You cannot use ?, !, or = anywhere other than at the end of the name.
- You cannot begin a method name with a number.

```
method_name      # valid
_name_of_method  # valid
1_method_name    # invalid
method_27        # valid
method?_name     # invalid
method_name!     # valid
begin            # invalid (Ruby reserved word)
begin_count      # valid
```

## Calling a Method

In Ruby, methods that belong to (are defined on) objects can be used (called) by adding a dot, and then the method name, like so:

```
object.method
```

In this case, #reverse is a built-in method for String objects.

However, there are also some built-in methods that Ruby makes globally accessible, such as print and puts. These methods are called with just their name and any arguments. (If you’re super curious, these methods are made globally available by the Kernel module through the Object class, but that’s far more than you need to know right now.)

```
puts "anything" #=> anything
```

It’s worth noting that in most languages, arguments are passed to methods by wrapping them in parentheses (). In Ruby, however, the parentheses are generally optional. We could rewrite the above code as puts("anything"), which Ruby would interpret in the same way.

## Parameters and Arguments

Sometimes an object needs a little bit of extra information in order to do what you ask for.

Parameters are variables that your method will receive when it is called. You can have more meaningful and useful interactions with your methods by using parameters to make them more versatile.

When defining a method Ruby will start reading the code at the top, and find the keyword def. This tells Ruby that we’re about to define a new method.

Methods need a name, so Ruby looks for it next.

Ruby then checks if we define anything to “input” to the method (remember, this is optional). She finds the parentheses, and knows that we’re about to define a list of things that can be given to the method. This list is called an argument list.

Inside the method body the arguments are known as local variables: You can see how the code in our method body uses the variable name number.

```
def add_two(number)
  number + 2
end
```

**parameters** act as placeholder variables in the template of your method, whereas **arguments** are the actual variables that get passed to the method when it is called.

**Default Parameters**

If you don't want to provide arguments for each parameter that your method accepts you can use default parameters.

```
def greet(name = "stranger")
  "Hello, " + name + "!"
end

puts greet("Jane") #=> Hello, Jane!
puts greet #=> Hello, stranger!
```

## Method Returns

In Ruby, a method always return exactly one single thing (an object).

The returned object can be anything, but a method can only return one thing, and it also always returns something.

Ruby offers implicit returns which means that a Ruby method will return the last expression that was evaluated even without the return keyword.

```
def even_odd(number)
  if number % 2 == 0
    "That is an even number."
  else
    "That is an odd number."
  end
end

puts even_odd(16) #=>  That is an even number.
puts even_odd(17) #=>  That is an odd number.
```

An explicit **return** (using the keyword return) essentially tells Ruby, “This is the last expression you should evaluate.”

```
def my_name
  return "Joe Smith"
  "Jane Doe"
end

puts my_name #=> "Joe Smith"
```

For example, an explicit return can be useful when you want to write a method that checks for input errors before continuing.

```
def even_odd(number)
  unless number.is_a? Numeric
    return "A number was not entered."
  end

  if number % 2 == 0
    "That is an even number."
  else
    "That is an odd number."
  end
end

puts even_odd(20) #=>  That is an even number.
puts even_odd("Ruby") #=>  A number was not entered.
```

## Chaining Methods

One of the magical properties of methods that allows you to write very concise code is being able to chain methods together. This can be done using Ruby’s built-in methods or with methods that you create.

```
phrase = ["be", "to", "not", "or", "be", "to"]

puts phrase.reverse.join(" ").capitalize
#=> "To be or not to be"
```

## Predicate Methods

You will sometimes encounter built-in Ruby methods that have a question mark (?) at the end of their name, such as even?, odd?, or between?. These are all predicate methods, which is a naming convention that Ruby uses for methods that return a Boolean, that is, they return either true or false.

```
puts 5.even?  #=> false
puts 6.even?  #=> true
puts 17.odd?  #=> true

puts 12.between?(10, 15)  #=> true
```

## Bang Methods

By adding a ! to the end of your method, you indicate that this method performs its action and simultaneously overwrites the value of the original object with the result.

```
puts whisper.downcase! #=> "hello everybody"
puts whisper #=> "hello everybody"
```

## Method Scope

Names are known (or defined) in a certain scope, and unknown (or undefined) outside of this scope.

Every time there is a method call, and the flow of execution enters the method’s body, it enters a new scope, or “room”. Things that are “local” to this method’s scope (i.e. things that are “inside” of the room), are only visible in this scope. Outside of it, they are unknown.

## Combining Methods
