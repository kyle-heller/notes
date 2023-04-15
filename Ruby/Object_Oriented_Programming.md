# Objected Oriented Programming

Object-oriented programming (OOP) is a programming paradigm that is based on the concept of objects, which are instances of classes that encapsulate data and behavior. Ruby is an object-oriented programming language, and it provides many features that make it easy to work with objects and classes.

Here are some of the key concepts of object-oriented programming in Ruby:

Classes: A class is a blueprint for creating objects. It defines the properties and behaviors of the objects that will be created from it.

Objects: An object is an instance of a class. It has its own state (represented by instance variables) and behavior (represented by methods).

Encapsulation: Encapsulation is the practice of hiding the internal state and behavior of an object from the outside world. This is typically done by making instance variables and methods private or protected.

Inheritance: Inheritance is a mechanism for creating new classes from existing classes. The new class, called a subclass, inherits all the properties and behaviors of the existing class, called the superclass, and can also add its own properties and behaviors.

Polymorphism: Polymorphism is the ability of objects of different classes to respond to the same message in different ways. This is achieved in Ruby through the use of method overriding and method overloading.

Here is an example of a simple class in Ruby:

```
class Person
  attr_accessor :name, :age

  def initialize(name, age)
    @name = name
    @age = age
  end

  def say_hello
    puts "Hello, my name is #{@name} and I am #{@age} years old."
  end
end
```

In this example, we define a class called Person that has two instance variables (name and age) and a method called say_hello. The attr_accessor method is used to create getter and setter methods for the instance variables. The initialize method is called when a new object is created from the class, and it sets the initial values of the instance variables. The say_hello method simply prints out a greeting using the instance variables.

To create a new object from this class, we can use the following code:

```
person = Person.new("John", 30)
person.say_hello
```

This will create a new Person object with the name "John" and age 30, and then call the say_hello method on it, which will print out the greeting "Hello, my name is John and I am 30 years old."

## Classes

Classes: A class is a user-defined data type that defines a set of properties and behaviors. The properties are represented by instance variables, and the behaviors are represented by methods. To create a new class, you use the class keyword, followed by the name of the class and any superclass it may inherit from.

For example:

```
class Animal
  def speak
    puts "I am an animal"
  end
end
```

This creates a new class called Animal that has a single method called speak.

## Objects

Objects: An object is an instance of a class. It is created using the new method and can be assigned to a variable. An object has its own state, which is represented by the values of its instance variables, and its own behavior, which is represented by its methods.

```
animal = Animal.new
animal.speak
```

This creates a new instance of the Animal class and assigns it to the animal variable. The speak method is then called on the animal object, which prints out "I am an animal".

## Encapsulation

Encapsulation: Encapsulation is the practice of hiding the internal details of an object from the outside world, and only exposing a public interface that can be used to interact with the object. In Ruby, this is achieved by using the private and protected keywords to mark instance variables and methods as not accessible from outside the object.

Methods are public by default in Ruby, so if you don’t specify public or private, your methods will be public.

You should change the default thought in your head from "everything is accessible, what do I need to hide?" to "everything should be hidden, what do I absolutely need to make externally available?" That principle will take you far, especially when designing things like APIs that will be used by other programs. The more you make available to people, the harder it will be later on to hide it again.

For example:

```
class Person
  def initialize(name)
    @name = name
  end

  def greet(other_person)
    puts "Hello #{other_person.name}, my name is #{@name}"
  end

  def name
    @name
  end

  private

  def secret_info
    puts "My social security number is 123-45-6789"
  end
end

person1 = Person.new("Alice")
person2 = Person.new("Bob")
person1.greet(person2)
person2.secret_info # This will cause an error because secret_info is private
```

In this example, the secret_info method is marked as private, which means it can only be called from within the Person class itself. The greet method is marked as public, which means it can be called from outside the object. The name method is also public, but it only provides read access to the @name instance variable.

## Inheritance

Inheritance is a mechanism for creating new classes from existing classes. The new class, called a subclass, inherits all the properties and behaviors of the existing class, called the superclass, and can also add its own properties and behaviors. Here's an example:

```
class Vehicle
  def start_engine
    puts "Starting engine..."
  end

  def stop_engine
    puts "Stopping engine..."
  end
end

class Car < Vehicle
  def drive
    puts "Driving..."
  end
end
```

In this example, the Vehicle class has two methods (start_engine and stop_engine) that are inherited by the Car class. The Car class also has its own method (drive) that is specific to cars.

To create a new object from the Car class, we use the new method just like before:

```
car = Car.new
car.start_engine #=> "Starting engine..."
car.drive #=> "Driving..."
car.stop_engine #=> "Stopping engine..."
```

This creates a new Car object and calls the inherited start_engine and stop_engine methods, as well as the drive method specific to cars.

## Polymorphism

Polymorphism is the ability of objects of different classes to respond to the same message in different ways. In Ruby, this is achieved through method overriding and method overloading.

Method overriding occurs when a subclass defines a method with the same name as a method in its superclass. The subclass's method "overrides" the superclass's method, and the subclass's method is called instead.

Here's an example:

```
class Animal
  def speak
    puts "I am an animal"
  end
end

class Dog < Animal
  def speak
    puts "Woof!"
  end
end

class Cat < Animal
  def speak
    puts "Meow!"
  end
end
```

In this example, we have three classes: Animal, Dog, and Cat. The Dog and Cat classes are subclasses of Animal. Each of these classes has a speak method, but they all behave differently.

To use polymorphism with these classes, we can create an array of Animal objects, which can contain instances of Animal, Dog, or Cat:

```
animals = [Animal.new, Dog.new, Cat.new]
```

We can then call the speak method on each of these objects:

```
animals.each do |animal|
  animal.speak
end
```

When we call speak on each object in the array, Ruby uses polymorphism to call the appropriate speak method for each object. The first speak method is called on an instance of Animal, so it prints "I am an animal". The second speak method is called on an instance of Dog, so it prints "Woof!". The third speak method is called on an instance of Cat, so it prints "Meow!".

This is an example of how polymorphism allows us to write more flexible and reusable code. We can write code that works with a variety of objects, even if we don't know their specific type at runtime.

## Class Variables

In Ruby, class variables are attached to the class in which they are declared. A class variable should be declared with two @ symbols preceding it.

```
class Child
  @@children = 0
  def initialize(name, birth_year)
    @name = name
    @birth_year = birth_year
    @@children +=1
  end

  def self.children_added
    return @@children
  end

end

naomi = Child.new("Naomi", 2006)
bertha = Child.new("Bertha", 2008)

puts Child.children_added # => 2
```

## .new Method

In Ruby, a new class instance can be created by calling the .new method of the class. Arguments to the class’ initialize method can be passed in to the .new call.

```
class Fighter
  def initialize(name, style, division, age)
    @name = name
    @style = style
    @division = division
    @age = age
  end
end

conor = Fighter.new("Conor", "mixed martial arts", "Welterweight", 31)
```

## Instance Variable

In Ruby, the @ symbol is used to signify an instance variable. Instance variables hold a value specific to each instance of that class, not to all members of the class itself.

```
class Student
  def initialize(name, grade)
    @name = name
    @grade = grade
  end
end

# In this example, name and grade are the instance variables.
```

## Initialize Method

In a Ruby class, an initialize method is used to generate new instances of the class. It is usually the first method of a class.

```
class Person
  def initialize
    # this code runs when a new instance is created
  end
end

#Every time Person.new is called, the initialize method of the Person class is called.
```

## Class

A Ruby class is used to organize and model objects with similar attributes and methods.

```
class NewClass
  # code for this class
end


# A basic class definition consists of the class keyword, the name of the class in CamelCase (with the first letter capitalized) format, and an end keyword.
```

## Super Keyword

Ruby’s built-in super keyword is used to directly access the attributes or methods of a superclass. This means a class with super will inherit the attributes or methods of a superclass.

```
class Trip
  def initialize(duration, price)
    @duration = duration
    @price = price
  end
end


class Cruise < Trip
  def initialize(duration, price)
    super
  end
end

spain_backpacking = Trip.new(14, 800.00)
carnival = Cruise.new(7, 2400.00)

#In this example, the Cruise class inherits from the Trip class and all of its attributes, including duration and price, are carried over with the super keyword.
```

Another more common way of using super is with initialize. Let's see an illustration of that:

```
class Animal
  attr_accessor :name

  def initialize(name)
    @name = name
  end
end

class GoodDog < Animal
  def initialize(color)
    super
    @color = color
  end
end

bruno = GoodDog.new("brown")        # => #<GoodDog:0x007fb40b1e6718 @color="brown", @name="brown">
```

The interesting concept we want to explain is the use of super in the GoodDog class. In this example, we're using super with no arguments. However, the initialize method, where super is being used, takes an argument and adds a new twist to how super is invoked. Here, in addition to the default behavior, super automatically forwards the arguments that were passed to the method from which super is called (initialize method in GoodDog class). At this point, super will pass the color argument in the initialize defined in the subclass to that of the Animal superclass and invoke it. That explains the presence of @name="brown" when the bruno instance is created. Finally, the subclass' initialize continues to set the @color instance variable.

When called with specific arguments, eg. super(a, b), the specified arguments will be sent up the method lookup chain. Let's see a quick example:

```
class BadDog < Animal
  def initialize(age, name)
    super(name)
    @age = age
  end
end

BadDog.new(2, "bear")        # => #<BadDog:0x007fb40b2beb68 @age=2, @name="bear">
```

This is similar to our previous example, with the difference being that super takes an argument, hence the passed in argument is sent to the superclass. Consequently, in this example when a BadDog class is created, the passed in name argument ("bear") is passed to the superclass and set to the @name instance variable.

There's one last twist. If you call super() exactly as shown -- with parentheses -- it calls the method in the superclass with no arguments at all. If you have a method in your superclass that takes no arguments, this is the safest -- and sometimes the only -- way to call it:

```
class Animal
  def initialize
  end
end

class Bear < Animal
  def initialize(color)
    super()
    @color = color
  end
end

bear = Bear.new("black")        # => #<Bear:0x007fb40b1e6718 @color="black">
```

If you forget to use the parentheses here, Ruby will raise an ArgumentError exception since the number of arguments is incorrect.

## attr_reader and attr_writer Methods

In Ruby, attr_reader and attr_writer are methods used to read and write variables, respectively.

```
class Student
  attr_reader :name
  attr_writer :name
  def initialize(name)
    @name = name
  end
end
#In this example, Ruby is able to both read and write the @name instance variable since it was passed to attr_reader and attr_writer as a symbol.

top_student = Student.new("Jyothi")
puts top_student.name # => Jyothi
#In classes with attr_reader, instance variables can be accessed using . notation

puts top_student.name # => Jyothi
top_student.name = "Anika"
puts top_student.name # => Anika
#In classes with attr_writer, instance variables can be reassigned using . notation
```

## Private, Protected, and Public

A **public** method is a method that is available to anyone who knows either the class name or the object's name. These methods are readily available for the rest of the program to use and comprise the class's interface (that's how other classes and objects will interact with this class and its objects).

Sometimes you'll have methods that are doing work in the class but don't need to be available to the rest of the program. These methods can be defined as **private**. How do we define private methods? We use the private method call in our program and anything below it is private (unless another method, like protected, is called after it to negate it).

Public and private methods are most common, but in some less common situations, we'll want an in-between approach. For this, we can use the protected method to create **protected** methods. Protected methods are similar to private methods in that they cannot be invoked outside the class. The main difference between them is that protected methods allow access between class instances, while private methods do not.

```
class Person
  def initialize(age)
    @age = age
  end

  def older?(other_person)
    age > other_person.age
  end

  protected

  attr_reader :age
end

malory = Person.new(64)
sterling = Person.new(42)

malory.older?(sterling)  # => true
sterling.older?(malory)  # => false

malory.age
  # => NoMethodError: protected method `age' called for #<Person: @age=64>
```

```
class Viking < Person
    ...
    def attack(recipient)
        if recipient.dead
            puts "#{recipient.name} is already dead!"
            return false
        end
        damage = (rand * 10 + 10).round(0)
        recipient.take_damage(damage)  # `take_damage` called on `recipient`!
    end
    protected
        def take_damage(damage)
            self.health -= damage
            puts "Ouch! #{self.name} took #{damage} damage and has #{self.health} health left"
            die if @health <= 0
            # `die` called from within the same object as take_damage was (the `recipient` as well!)
        end
    private
        def die
            puts "#{self.name} has been killed :("
            self.dead = true  # assume we've defined a `dead` instance variable
        end
end

> oleg = Viking.create_warrior("Oleg")
 => #<Viking:0x007ffd4b8b5588 @age=24.58111251562904, @name="Oleg", @health=120, @strength=10, @dead=false>
> sten = Viking.create_warrior("Sten")
 => #<Viking:0x007ffd4b8e1700 @age=28.80998656037281, @name="Sten", @health=120, @strength=10, @dead=false>
> 10.times { oleg.attack(sten) }
Ouch! Sten took 19 damage and has 101 health left
Ouch! Sten took 10 damage and has 91 health left
Ouch! Sten took 13 damage and has 78 health left
Ouch! Sten took 17 damage and has 61 health left
Ouch! Sten took 15 damage and has 46 health left
Ouch! Sten took 11 damage and has 35 health left
Ouch! Sten took 14 damage and has 21 health left
Ouch! Sten took 14 damage and has 7 health left
Ouch! Sten took 18 damage and has -11 health left
Sten has been killed :(
Sten is already dead!
 => 10
> sten
=> #<Viking:0x007ffd4c048840 @age=25.601709008134428, @name="Sten", @health=-11, @strength=10, @dead=true>
```

## Ruby namespace

In Ruby, the term namespace refers to a module the contains a group of related objects. An example of a Ruby namespace is the Math module.

```
#To retrieve a constant from the Math module, the scope resolution operator (::), should be used.

puts Math::PI
# => 3.141592653589793

#In this example, Ruby is targetting the PI constant from the Math module using the scope resolution operator, (::), and printing its value to the console.
```

If you 'include' a module in a class the objects of that class can use the methods from that module. You don't need to keep typing :: either.

If you 'extend' a module in a class the actual class can use the methods from that module.

You can also use modules for namespacing. In this context, namespacing means organizing similar classes under a module. In other words, we'll use modules to group related classes. Therein lies the first advantage of using modules for namespacing. It becomes easy for us to recognize related classes in our code. The second advantage is it reduces the likelihood of our classes colliding with other similarly named classes in our codebase. Here's how we do it:

```
module Mammal
  class Dog
    def speak(sound)
      p "#{sound}"
    end
  end

  class Cat
    def say_name(name)
      p "#{name}"
    end
  end
end
```

We call classes in a module by appending the class name to the module name with two colons(::)

```
buddy = Mammal::Dog.new
kitty = Mammal::Cat.new
buddy.speak('Arf!')           # => "Arf!"
kitty.say_name('kitty')       # => "kitty"
```

## require Keyword

In Ruby, the require keyword is used to fetch a certain module which isn’t yet presented in the interpreter. It is best practice to place this at the beginning of your code.

```
require 'date'

puts Date.today
# => 2020-04-16
```

## include Keyword

Any class that includes a certain module can use those module’s methods!

A nice effect of this is that you no longer have to prepend your constants and methods with the module name. Since everything has been pulled in, you can simply write PI instead of Math::PI.

```
class Angle
include Math

  attr_accessor :radians

  def initialize(radians)
    @radians = radians
  end

  def cosine
    cos(@radians)
  end
end

acute = Angle.new(1)
acute.cosine
```

```
module Action
  def jump
    @distance = rand(4) + 2
    puts "I jumped forward #{@distance} feet!"
  end
end

class Rabbit
  include Action
  attr_reader :name
  def initialize(name)
    @name = name
  end
end

class Cricket
  include Action
  attr_reader :name
  def initialize(name)
    @name = name
  end
end

peter = Rabbit.new("Peter")
jiminy = Cricket.new("Jiminy")

peter.jump
jiminy.jump
```

You may wonder when to use class inheritance vs mixins. Here are a couple of things to consider when evaluating these choices.

You can only subclass (class inheritance) from one class. You can mix in as many modules (interface inheritance) as you'd like.
If there's an "is-a" relationship, class inheritance is usually the correct choice. If there's a "has-a" relationship, interface inheritance is generally a better choice. For example, a dog "is an" animal and it "has an" ability to swim.
You cannot instantiate modules. In other words, objects cannot be created from modules.

## extend Keyword

The extend keyword mixes a module’s methods at the class level. This means that class itself can use the methods, as opposed to instances of the class.

```
# ThePresent has a .now method that we'll extend to TheHereAnd

module ThePresent
 def now
   puts "It's #{Time.new.hour > 12 ? Time.new.hour - 12 : Time.new.hour}:#{Time.new.min} #{Time.new.hour > 12 ? 'PM' : 'AM'} (GMT)."
 end
end

class TheHereAnd
 extend ThePresent
end

TheHereAnd.now
```

## Ruby Module

In Ruby, a module contains a set of methods, constants, or classes which can be accessed with the . operator similarly to classes . Unlike classes, it is impossible to create instances of a Ruby module.

```
#A Ruby module can be created using the module keyword followed by the module name written in CapitalizedCamelCase format finalized with an end.

module MyPizza
  FAVE_TOPPING = "Buffalo Chicken"
end
#In this example, myPizza is a module that holds a constant, FAVE_TOPPING, set equal to the string, Buffalo Chicken.
```

```
module Speak
  def speak(sound)
    puts sound
  end
end

class GoodDog
  include Speak
end

class HumanBeing
  include Speak
end

sparky = GoodDog.new
sparky.speak("Arf!")        # => Arf!
bob = HumanBeing.new
bob.speak("Hello!")         # => Hello!
```

## attr_accessor Method

In Ruby, attr_accessor, used to make a variable both readable and writeable, is a shortcut to attr_reader and attr_writer.

```
class CollegeStudent
  attr_reader :dorm
  attr_accessor :major

  def initialize(dorm, major)
    @dorm = dorm
    @major = major
  end
end

#In this example, Ruby is able to only read the @dorm instance variable but both read and write the @major instance variable since it was passed to the attr_accessor method.
```

## Scope

Check out the code in the editor. See how some variables start with $, @, or @@? This helps mark them as global, instance, and class variables (respectively). We’ll explain these in the next section. Run the code to see how these different variables work!

```
class Computer
  $manufacturer = "Mango Computer, Inc."
  @@files = {hello: "Hello, world!"}

  def initialize(username, password)
    @username = username
    @password = password
  end

  def current_user
    @username
  end

  def self.display_files
    @@files
  end
end

# Make a new Computer instance:
hal = Computer.new("Dave", 12345)

puts "Current user: #{hal.current_user}"
# @username belongs to the hal instance.

puts "Manufacturer: #{$manufacturer}"
# $manufacturer is global! We can get it directly.

puts "Files: #{Computer.display_files}"
# @@files belongs to the Computer class.
```

Output:

```
Current user: Dave
Manufacturer: Mango Computer, Inc.
Files: {:hello=>"Hello, world!"}
```

**Scope of Class methods vs Instance methods**

- Class methods have access to other class methods and class variables but don't have access to instance methods or instance variables

- Instance methods can call other instance methods, instance variables, class methods, or class variables

## Method Lookup

When you call a method, how does Ruby know where to look for that method? Ruby has a distinct lookup path that it follows each time a method is called. Let's use our program from above to see what the method lookup path is for our GoodDog class. We can use the ancestors method on any class to find out the method lookup chain.

```
module Speak
  def speak(sound)
    puts "#{sound}"
  end
end

class GoodDog
  include Speak
end

class HumanBeing
  include Speak
end

puts "---GoodDog ancestors---"
puts GoodDog.ancestors
puts ''
puts "---HumanBeing ancestors---"
puts HumanBeing.ancestors
```

The output looks like this:

```
---GoodDog ancestors---
GoodDog
Speak
Object
Kernel
BasicObject

---HumanBeing ancestors---
HumanBeing
Speak
Object
Kernel
BasicObject
```

The Speak module is placed right in between our custom classes (i.e., GoodDog and HumanBeing) and the Object class that comes with Ruby. In Inheritance you'll see how the method lookup chain works when working with both mixins and class inheritance.

This means that since the speak method is not defined in the GoodDog class, the next place it looks is the Speak module. This continues in an ordered, linear fashion, until the method is either found, or there are no more places to look.

## States and Behaviors

- State refers to the data associated to an individual object (which are tracked by instance variables).

- Behaviors are what objects are capable of doing.

For example, using our GoodDog class from earlier, we may want to create two GoodDog objects: one named "Fido" and one named "Sparky". They are both GoodDog objects, but may contain different information, such as name, weight, and height. We would use instance variables to track this information. This should tell you that instance variables are scoped at the object (or instance) level, and are how objects keep track of their states.

Even though they're two different objects, both are still objects (or instances) of class GoodDog and contain identical behaviors. For example, both GoodDog objects should be able to bark, run, fetch, and perform other common behaviors of good dogs. We define these behaviors as instance methods in a class. Instance methods defined in a class are available to objects (or instances) of that class.

In summary, instance variables keep track of state, and instance methods expose behavior for objects. Let's take a closer look at how to define them in a class.

## Constructors

A constructor is a special method of the class that gets automatically invoked whenever an instance of the class is created. Like methods, a constructor may also contain a group of instructions or a method that will execute at the time of object creation.

Important points to remember about Constructors:
Constructors are used to initializing the instance variables.
In Ruby, the constructor has a different name, unlike other programming languages.
A constructor is defined using the initialize and def keywords.
It is treated as a special method in Ruby.
Constructors can’t be overloaded in Ruby.
Constructors can’t be inherited.
It returns the instance of that class.

## Calling Methods With self

The reason our setter methods didn't work is because Ruby thought we were initializing local variables. Recall that to initialize or create new local variables, all we have to do is x = 1 or str = "hello world". It turns out that instead of calling the name=, height= and weight= setter methods, what we did was create three new local variables called name, height and weight. That's definitely not what we wanted to do.

To disambiguate from creating a local variable, we need to use self.name= to let Ruby know that we're calling a method. So our change_info code should be updated to this:

```
def change_info(n, h, w)
  self.name = n
  self.height = h
  self.weight = w
end
```

This tells Ruby that we're calling a setter method, not creating a local variable. To be consistent, we could also adopt this syntax for the getter methods as well, though it is not required.

```
def info
  "#{self.name} weighs #{self.weight} and is #{self.height} tall."
end
```

Uses:

1. Use self when calling setter methods from within the class. In our earlier example we showed that self was necessary in order for our change_info method to work properly. We had to use self to allow Ruby to disambiguate between initializing a local variable and calling a setter method.

2. Use self for class method definitions.

To be clear, from within a class...

- self, inside of an instance method, references the instance (object) that called the method - the calling object. Therefore, self.weight= is the same as sparky.weight=, in our example.

- self, outside of an instance method, references the class and can be used to define class methods. Therefore if we were to define a name class method, def self.name=(n) is the same as def GoodDog.name=(n).

Thus, we can see that self is a way of being explicit about what our program is referencing and what our intentions are as far as behavior. self changes depending on the scope it is used in, so pay attention to see if you're inside an instance method or not. self is a tricky concept to grasp in the beginning, but the more often you see its use, the more you will understand object oriented programming. If the explanations don't quite make sense, just memorize those two rules above for now.

## Class Methods

Thus far, all the methods we've created are instance methods. That is, they are methods that pertain to an instance or object of the class. There are also class level methods, called class methods. Class methods are methods we can call directly on the class itself, without having to instantiate any objects. We haven't implemented any class methods at this point, so let's do that now.

When defining a class method, we prepend the method name with the reserved word self., like this:

```
# ... rest of code ommitted for brevity

def self.what_am_i         # Class method definition
  "I'm a GoodDog class!"
end
```

Then when we call the class method, we use the class name GoodDog followed by the method name, without even having to instantiate any objects, like this:

```
GoodDog.what_am_i          # => I'm a GoodDog class!
```

Why do we need a class method for this? This example is a little contrived, but class methods are where we put functionality that does not pertain to individual objects. Objects contain state, and if we have a method that does not need to deal with states, then we can just use a class method, like our simple example. We'll take a look at a more useful example in the next section.

## The to_s Method

The to_s instance method comes built in to every class in Ruby. In fact, we have been using it all along. For example, suppose we have the GoodDog class from above, and the sparky object as well from above.

```
puts sparky      # => #<GoodDog:0x007fe542323320>
```

What's happening here is that the puts method automatically calls to_s on its argument, which in this case is the sparky object. In other words puts sparky is equivalent to puts sparky.to_s. The reason we get this particular output lies within the to_s method in Ruby. By default, the to_s method returns the name of the object's class and an encoding of the object id.

Note: puts method calls to_s for any argument that is not an array. For an array, it writes on separate lines the result of calling to_s on each element of the array.

To test this, we can add a custom to_s method to our GoodDog class, overriding the default to_s that comes with Ruby.

```
class GoodDog
  DOG_YEARS = 7

  attr_accessor :name, :age

  def initialize(n, a)
    @name = n
    @age  = a * DOG_YEARS
  end

  def to_s
    "This dog's name is #{name} and it is #{age} in dog years."
  end
end
```

Let's try again:

```
puts sparky      # => This dog's name is Sparky and is 28 in dog years.
```

And yes, it works! We were able to change the output by overriding the to_s instance method.

There's another method called p that's very similar to puts, except it doesn't call to_s on its argument; it calls another built-in Ruby instance method called inspect. The inspect method is very helpful for debugging purposes, so we don't want to override it.

```
p sparky         # => #<GoodDog:0x007fe54229b358 @name="Sparky", @age=28>
```

This output implies that p sparky is equivalent to puts sparky.inspect.

Besides being called automatically when using puts, another important attribute of the to_s method is that it's also automatically called in string interpolation. We've seen this before when using integers or arrays in string interpolation:

```
irb :001 > arr = [1, 2, 3]
=> [1, 2, 3]
irb :002 > x = 5
=> 5
irb :003 > "The #{arr} array doesn't include #{x}."
=> The [1, 2, 3] array doesn't include 5.
```

Here, the to_s method is automatically called on the arr array object, as well as the x integer object. We'll see if we can include our sparky object in a string interpolation:

```
irb :001 > "#{sparky}"
=> "This dog's name is Sparky and it is 28 in dog years."
```

In summary, the to_s method is called automatically on the object when we use it with puts or when used with string interpolation. This fact may seem trivial at the moment, but knowing when to_s is called will help us understand how to read and write better OO code.
