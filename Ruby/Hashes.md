# Hashes

## Creating New Hashes

This example shows the most basic way to create a hash, which is to use the hash literal of curly braces ({}). Keys and values are associated with a special operator called a hash rocket: =>.

```
# 'Rocket' syntax
american_cars = {
  :chevrolet => "Corvette",
  :ford => "Mustang",
  :dodge => "Ram"
}
# 'Symbols' syntax
japanese_cars = {
  honda: "Accord",
  toyota: "Corolla",
  nissan: "Altima"
}
```

You can also use the ::new method on the Hash class.

```
my_hash = Hash.new
my_hash               #=> {}
```

Example hashes:

```
jon_snow = {
  name: "Jon",
  email: "jon_snow@thewall.we"
}
```

## Accessing Values

You can access values in a hash the same way that you access elements in an array. When you call a hash’s value by key, the key goes inside a pair of brackets, just like when you’re calling an array by index.

```
shoes = {
  "summer" => "sandals",
  "winter" => "boots"
}

shoes["summer"]   #=> "sandals"
```

If you try to access a key that doesn’t exist in the hash, it will return nil:

```
shoes["hiking"]   #=> nil
```

Sometimes, this behavior can be problematic for you if silently returning a nil value could potentially wreak havoc in your program. Luckily, hashes have a fetch method that will raise an error when you try to access a key that is not in your hash.

```
shoes.fetch("hiking")   #=> KeyError: key not found: "hiking"

shoes.fetch("hiking", "hiking boots") #=> "hiking boots"
```

## Adding and Changing Data

You can add a key-value pair to a hash by calling the key and setting the value, just like you would with any other variable.

```
shoes["fall"] = "sneakers"

shoes     #=> {"summer"=>"sandals", "winter"=>"boots", "fall"=>"sneakers"}

```

You can also use this approach to change the value of an existing key.

```
shoes["summer"] = "flip-flops"
shoes     #=> {"summer"=>"flip-flops", "winter"=>"boots", "fall"=>"sneakers"}
```

## Removing Data

Deleting data from a hash is simple with the hash’s #delete method, which provides the cool functionality of returning the value of the key-value pair that was deleted from the hash.

```
shoes.delete("summer")    #=> "flip-flops"
shoes                     #=> {"winter"=>"boots", "fall"=>"sneakers"}
```

## Useful Methods

**#keys** and **#values**

```
books = {
  "Infinite Jest" => "David Foster Wallace",
  "Into the Wild" => "Jon Krakauer"
}

books.keys      #=> ["Infinite Jest", "Into the Wild"]
books.values    #=> ["David Foster Wallace", "Jon Krakauer"]
```

**#merge**

Notice that the values from the hash getting merged in (in this case, the values in hash2) overwrite the values of the hash getting… uh, merged at (hash1 here) when the two hashes have a key that’s the same.

```
hash1 = { "a" => 100, "b" => 200 }
hash2 = { "b" => 254, "c" => 300 }
hash1.merge(hash2)      #=> { "a" => 100, "b" => 254, "c" => 300 }
```

You can also use the bang suffix (!) to make this change destructive.

**#each**

```
person = {name: 'bob', height: '6 ft', weight: '160 lbs', hair: 'brown'}

person.each do |key, value|
  puts "Bob's #{key} is #{value}"
end
```

For a full list of the methods that work on hashes, check out the Ruby Docs https://ruby-doc.org/core-3.1.2/Hash.html

**#key?**

The key? method allows you to check if a hash contains a specific key. It returns a boolean value.

```
irb :001 > name_and_age = { "Bob" => 42, "Steve" => 31, "Joe" => 19}
=> {"Bob"=>42, "Steve"=>31, "Joe"=>19}
irb :002 > name_and_age.key?("Steve")
=> true
irb :003 > name_and_age.key?("Larry")
=> false
```

**#select**
The select method allows you to pass a block and will return any key-value pairs that evaluate to true when passed to the block.

```
irb :004 > name_and_age.select { |k,v| k == "Bob" }
=> {"Bob"=>42}
irb :005 > name_and_age.select { |k,v| (k == "Bob") || (v == 19) }
=> {"Bob"=>42, "Joe"=>19}
```

**#fetch**

The fetch method allows you to pass a given key and it will return the value for that key if it exists. You can also specify an option for return if that key is not present. Take a look at the Ruby docs here to see what else is possible.

```
irb :006 > name_and_age.fetch("Steve")
=> 31
irb :007 > name_and_age.fetch("Larry")
=> KeyError: key not found: "Larry"
     from (irb):32:in `fetch'
     from (irb):32
     from /usr/local/rvm/rubies/ruby-2.5.3/bin/irb:16:in `<main>'
irb :008 > name_and_age.fetch("Larry", "Larry isn't in this hash")
=> "Larry isn't in this hash"
```

**#to_a**

The to_a method returns an array version of your hash when called. Let's see it in action. It doesn't modify the hash permanently though.

```
irb :009 > name_and_age.to_a
=> [["Bob", 42], ["Steve", 31], ["Joe", 19]]
irb :010 > name_and_age
=> {"Bob"=>42, "Steve"=>31, "Joe"=>19}
```

## Optional Parameters

You may recall in chapter three on methods, we talked about the ability to assign default parameters to your methods so that the output is always consistent. You can use a hash to accept optional parameters when you are creating methods as well. This can be helpful when you want to give your methods some more flexibility and expressivity. More options, if you will! Let's create a method that does just that.

```
# optional_parameters.rb

def greeting(name, options = {})
  if options.empty?
    puts "Hi, my name is #{name}"
  else
    puts "Hi, my name is #{name} and I'm #{options[:age]}" +
         " years old and I live in #{options[:city]}."
  end
end

greeting("Bob")
greeting("Bob", {age: 62, city: "New York City"})
```

We used Ruby hash's empty? method to detect whether the options parameter, which is a hash, had anything passed into it.

At the end we called the method twice. Once using no optional parameters, and a second time using a hash to send the optional parameters. You can see how using this feature could make your methods much more expressive and dynamic.

Alternative method:

```
greeting("Bob", age: 62, city: "New York City")
```

Notice the curly braces, { }, are not required when a hash is the last argument, and the effect is identical to the previous example. This convention is commonly used by Rails developers.

## When To Use Hash vs Array

When deciding whether to use a hash or an array, ask yourself a few questions:

- Does this data need to be associated with a specific label? If yes, use a hash. If the data doesn't have a natural label, then typically an array will work fine.

- Does order matter? If yes, then use an array. As of Ruby 1.9, hashes also maintain order, but usually ordered items are stored in an array.

- Do I need a "stack" or a "queue" structure? Arrays are good at mimicking simple "first-in-first-out" queues, or "last-in-first-out" stacks.
