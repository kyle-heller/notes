## Nested Collections

Nested collections in Ruby, or collections that contain other collections as elements, can be useful for a variety of reasons. Here are a few examples:

1. Representing complex data structures: Nested collections can be used to represent complex data structures that are difficult to model using single-level collections like arrays or hashes. For example, you might use a nested hash to represent a multi-dimensional data set, or a nested array to represent a tree structure.

2. Organizing related data: Nested collections can be used to group related data together in a hierarchical fashion. For example, you might use a hash with nested arrays to represent a group of people, with each person's name, age, and address stored in an array that is nested within the hash.

3. Iterating over collections: Nested collections can make it easier to iterate over a collection of elements and perform operations on subsets of those elements. For example, you might use nested loops to iterate over a two-dimensional array and perform calculations on each element.

4. Reducing duplication: Nested collections can help reduce duplication of data by allowing you to reuse common elements across different subsets of data. For example, you might use a nested hash to represent a group of people, with each person's name, age, and address stored in a nested hash that is shared across multiple people.

Overall, nested collections can be a powerful tool for modeling complex data structures, organizing related data, and simplifying code that involves iteration and duplication.

## Nested Arrays

Arrays can contain any type of data, including other arrays. An array that contains other arrays is called a nested array, or a multidimensional array.

Nested arrays can be useful to store groups of similar data or positional data. The following nested array of test scores is storing groups of similar data and the teacher mailboxes is storing groups of positional data.

```
test_scores = [
  [97, 76, 79, 93],
  [79, 84, 76, 79],
  [88, 67, 64, 76],
  [94, 55, 67, 81]
]

teacher_mailboxes = [
  ["Heller", "Baker", "Clark", "Davis"],
  ["Jones", "Lewis", "Lopez", "Moore"],
  ["Perez", "Scott", "Smith", "Young"]
]
```

## Accessing Elements

You already know that every element in an array has an index. Accessing a specific element within a nested array is as simple as calling array[x][y], where x is the index of the nested element and y is the index inside of the nested element.

```
teacher_mailboxes[0][0]
#=> "Adams"
teacher_mailboxes[1][0]
#=> "Jones"
teacher_mailboxes[2][0]
#=> "Perez"
```

If you try to access an index of a nonexistent nested element, it will raise an NoMethodError, because the nil class does not have a [] method. However, just like a regular array, if you try to access a nonexistent index inside of an existing nested element, it will return nil.

```
teacher_mailboxes[3][0]
#=> NoMethodError
teacher_mailboxes[0][4]
#=> nil
```

If you want a nil value returned when trying to access an index of a nonexistent nested element, you can use the #dig method. This method can also be used when accessing a nonexistent index inside of an existing nested element.

```
teacher_mailboxes.dig(3, 0)
#=> nil
teacher_mailboxes.dig(0, 4)
#=> nil
```

## Creating a New Nested Array

In a previous lesson you were taught to create a new array, by calling the Array.new method with up to 2 optional arguments (initial size and default value), like Array.new(3) or Array.new(3, 7). However, there is one major “gotcha” that is important to point out. According to the documentation the second optional argument, for the default value, should only be used with an immutable (unable to be changed) object such as a number, boolean value, or symbol. Using a string, array, hash, or other mutable object may result in confusing behavior because each default value in the array will actually be a reference to the same default value. Therefore, any change to one of the elements will change all of the elements in the array.

Changing the value of the first element in the first nested array, causes the first element to change in all three nested arrays! This same behavior will happen with strings, hashes, or any other mutable objects.

```
mutable = Array.new(3, Array.new(2))
#=> [[nil, nil], [nil, nil], [nil, nil]]
mutable[0][0] = 1000
#=> 1000
mutable
#=> [[1000, nil], [1000, nil], [1000, nil]]
```

To create an immutable array of mutable objects (string, array, hash, etc), you will need to pass the default value for Array.new via a block, using curly braces, instead of the second optional argument. The code in the block gets evaluated for every slot in the array, creating multiple objects to initialize the array with, rather than references to the same object.

```
immutable = Array.new(3) { Array.new(2) }
#=> [[nil, nil], [nil, nil], [nil, nil]]
immutable[0][0] = 1000
#=> 1000
immutable
#=> [[1000, nil], [nil, nil], [nil, nil]]
```

## Adding and Removing Elements

You can add another element to the end of nested array using the #push method or the shovel operator <<. If you want to add an element to a specific nested array, you will need to specify the index of the nested array.

```
test_scores << [100, 99, 98, 97]
#=> [[97, 76, 79, 93], [79, 84, 76, 79], [88, 67, 64, 76], [94, 55, 67, 81], [100, 99, 98, 97]]
test_scores[0].push(100)
#=> [97, 76, 79, 93, 100]
test_scores
#=> [[97, 76, 79, 93, 100], [79, 84, 76, 79], [88, 67, 64, 76], [94, 55, 67, 81], [100, 99, 98, 97]]
```

Using this similar syntax, you can add or remove elements from the entire nested array or from a specific nested element.

```
test_scores.pop
#=> [100, 99, 98, 97]
test_scores[0].pop
#=> 100
test_scores
#=> [[97, 76, 79, 93], [79, 84, 76, 79], [88, 67, 64, 76], [94, 55, 67, 81]]
```

## Iterating Over a Nested Array

Let’s break down how to iterate over a nested array using the #each_with_index method. You might find it helpful to think of a nested array as having rows and columns. Each row is the nested element and each column is the index of the nested element. When we iterate over the teacher_mailboxes example, each element will be one row.

```
teacher_mailboxes.each_with_index do |row, row_index|
  puts "Row:#{row_index} = #{row}"
end
#=> Row:0 = ["Adams", "Baker", "Clark", "Davis"]
#=> Row:1 = ["Jones", "Lewis", "Lopez", "Moore"]
#=> Row:2 = ["Perez", "Scott", "Smith", "Young"]
#=> [["Adams", "Baker", "Clark", "Davis"], ["Jones", "Lewis", "Lopez", "Moore"], ["Perez", "Scott", "Smith", "Young"]]
```

To iterate over the individual elements inside of each row, you will need to nest another enumerable method inside.

```
teacher_mailboxes.each_with_index do |row, row_index|
  row.each_with_index do |teacher, column_index|
    puts "Row:#{row_index} Column:#{column_index} = #{teacher}"
  end
end
#=> Row:0 Column:0 = Adams
#=> Row:0 Column:1 = Baker
#=> Row:0 Column:2 = Clark
#=> Row:0 Column:3 = Davis
#=> Row:1 Column:0 = Jones
#=> Row:1 Column:1 = Lewis
#=> Row:1 Column:2 = Lopez
#=> Row:1 Column:3 = Moore
#=> Row:2 Column:0 = Perez
#=> Row:2 Column:1 = Scott
#=> Row:2 Column:2 = Smith
#=> Row:2 Column:3 = Young
#=> [["Adams", "Baker", "Clark", "Davis"], ["Jones", "Lewis", "Lopez", "Moore"], ["Perez", "Scott", "Smith", "Young"]]
```

Although these examples are a bit contrived, it is important to note that if we only need each teacher’s name it would be beneficial to use #flatten before iterating.

```
teacher_mailboxes.flatten.each do |teacher|
  puts "#{teacher} is amazing!"
end
#=> Adams is amazing!
#=> Baker is amazing!
#=> Clark is amazing!
#=> Davis is amazing!
#=> Jones is amazing!
#=> Lewis is amazing!
#=> Lopez is amazing!
#=> Moore is amazing!
#=> Perez is amazing!
#=> Scott is amazing!
#=> Smith is amazing!
#=> Young is amazing!
#=> ["Adams", "Baker", "Clark", "Davis", "Jones", "Lewis", "Lopez", "Moore", "Perez", "Scott", "Smith", "Young"]
```

Now let’s take a look at a more complicated example of nesting two predicate enumerables together. Using the above nested array of test scores, let’s determine if any student scored higher than 80 on everything.

```
test_scores = [[97, 76, 79, 93], [79, 84, 76, 79], [88, 67, 64, 76], [94, 55, 67, 81]]
#=> [[97, 76, 79, 93], [79, 84, 76, 79], [88, 67, 64, 76], [94, 55, 67, 81]]

test_scores.any? do |scores|
  scores.all? { |score| score > 80 }
end
#=> false
```

```
This seems pretty straight-forward. It returns false, because none of the nested arrays have scores that are all over 80. What do you think will happen if we switch #any? and #all?? Do you think we will get the same results?
```

```
test_scores.all? do |scores|
  scores.any? { |score| score > 80 }
end
#=> true
```

The results are different, because now it is determining if all of the nested arrays contain any number over 80. This returns true, because each of the nested arrays have at least one number over 80.

## Nested Hashes

The hashes that you’ve seen so far have single key/value pairs. However, just like arrays, they can be nested, or multidimensional. Nested hashes are a very common way to store complex associated data.

```
vehicles = {
  alice: {year: 2019, make: "Toyota", model: "Corolla"},
  blake: {year: 2020, make: "Volkswagen", model: "Beetle"},
  caleb: {year: 2020, make: "Honda", model: "Accord"}
}
```

## Accessing Data

Accessing a specific element in a nested hash is very similar to a nested array. It is as simple as calling hash[:x][:y], where :x is the key of the hash and :y is the key of the nested hash.

```
vehicles[:alice][:year]
#=> 2019
vehicles[:blake][:make]
#=> "Volkswagen"
vehicles[:caleb][:model]
#=> "Accord"
```

Similar to nested arrays, if you try to access a key in a nonexistent nested hash, it will raise an NoMethodError, therefore you may want to use the #dig method. As expected, if you try to access a nonexistent key in an existing nested hash, it will return nil.

```
vehicles[:zoe][:year]
#=> NoMethodError
vehicles.dig(:zoe, :year)
#=> nil
vehicles[:alice][:color]
#=> nil
vehicles.dig(:alice, :color)
#=> nil
```

## Adding and Removing Data

You can add more nested hashes, just like a regular hash. Let’s say Dave just bought a new vehicle and we want to add it to the list.

```
vehicles[:dave] = {year: 2021, make: "Ford", model: "Escape"}
#=> {:year=>2021, :make=>"Ford", :model=>"Escape"}
vehicles
#=> {:alice=>{:year=>2019, :make=>"Toyota", :model=>"Corolla"}, :blake=>{:year=>2020, :make=>"Volkswagen", :model=>"Beetle"}, :caleb=>{:year=>2020, :make=>"Honda", :model=>"Accord"}, :dave=>{:year=>2021, :make=>"Ford", :model=>"Escape"}}
```

You can also add an element to one of the nested hashes. Let’s say that Dave really loves his new Escape and thinks we should keep track of the color of the vehicles. To add a new key/value pair to a nested hash, specify the key of the nested hash right before naming the new key.

```
vehicles[:dave][:color] = "red"
#=> "red"
vehicles
#=> {:alice=>{:year=>2019, :make=>"Toyota", :model=>"Corolla"}, :blake=>{:year=>2020, :make=>"Volkswagen", :model=>"Beetle"}, :caleb=>{:year=>2020, :make=>"Honda", :model=>"Accord"}, :dave=>{:year=>2021, :make=>"Ford", :model=>"Escape", :color=>"red"}}
```

Deleting one of the nested hashes will be just like a regular hash. Let’s say Blake has decided to sell his Beetle and backpack across Europe. So, let’s delete Blake’s car.

```
vehicles.delete(:blake)
#=> {:year=>2020, :make=>"Volkswagen", :model=>"Beetle"}
vehicles
#=> {:alice=>{:year=>2019, :make=>"Toyota", :model=>"Corolla"}, :caleb=>{:year=>2020, :make=>"Honda", :model=>"Accord"}, :dave=>{:year=>2021, :make=>"Ford", :model=>"Escape", :color=>"red"}}
```

To delete one of the key/value pairs inside of a nested hash, you first specify the key of the hash. Let’s say Dave decided that we don’t need to specify the color of his vehicle. Therefore, we specify vehicles[:dave] before we indicate the key of the nested hash to delete.

```
vehicles[:dave].delete(:color)
#=> "red"
vehicles
#=> {:alice=>{:year=>2019, :make=>"Toyota", :model=>"Corolla"}, :caleb=>{:year=>2020, :make=>"Honda", :model=>"Accord"}, :dave=>{:year=>2021, :make=>"Ford", :model=>"Escape"}}
```

## Useful Methods

**#delete**

```
vehicles[:dave].delete(:color)
#=> "red"
vehicles
#=> {:alice=>{:year=>2019, :make=>"Toyota", :model=>"Corolla"}, :caleb=>{:year=>2020, :make=>"Honda", :model=>"Accord"}, :dave=>{:year=>2021, :make=>"Ford", :model=>"Escape"}}
```

**#select**

```
vehicles.select { |name, data| data[:year] >= 2020 }
#=> {:caleb=>{:year=>2020, :make=>"Honda", :model=>"Accord"}, :dave=>{:year=>2021, :make=>"Ford", :model=>"Escape"}}
```

**#collect/map**

```
vehicles.collect { |name, data| name if data[:year] >= 2020 }
#=> [nil, :caleb, :dave]
```

**#compact**

```
vehicles.collect { |name, data| name if data[:year] >= 2020 }.compact
#=> [:caleb, :dave]
```

**#filter_map**
Combines functionality of map and compact.

```
vehicles.filter_map { |name, data| name if data[:year] >= 2020 }
#=> [:caleb, :dave]
```

**#dig**

If you want a nil value returned when trying to access an index of a nonexistent nested element, you can use the #dig method. This method can also be used when accessing a nonexistent index inside of an existing nested element.

```
teacher_mailboxes.dig(3, 0)
#=> nil
teacher_mailboxes.dig(0, 4)
#=> nil
```

## More Iterating Examples

```
contacts = {
  "Jon Snow" => {
    name: "Jon",
    email: "jon_snow@thewall.we",
    favorite_ice_cream_flavors: ["chocolate", "vanilla", "mint chip"],
    knows: nil
  },
  "Freddy Mercury" => {
    name: "Freddy",
    email: "freddy@mercury.com",
    favorite_ice_cream_flavors: ["strawberry", "cookie dough", "mint chip"]
  }
}

contacts.each do |person, data|
  puts "#{person}: #{data}"
end
```

Outputs:

```
Jon Snow:
{ :name=>"Jon",
  :email=>"jon_snow@thewall.we",
  :favorite_ice_cream_flavors=>["chocolate", "vanilla", "mint chip"],
  :knows=>nil
}

Freddy Mercury:
{ :name=>"Freddy",
:email=>"freddy@mercury.com",
:favorite_ice_cream_flavors=>["strawberry", "cookie dough", "mint chip"]
}
```

```
contacts.each do |person, data|
  #at this level, "person" is Jon Snow or Freddy Mercury and "data" is a hash of
  #key/value pairs to iterate over the "data" hash, we can use the following line:

  data.each do |attribute, value|
    puts "#{attribute}: #{value}"
  end
end
```

Outputs:

```
name: Jon
email: jon_snow@thewall.we
favorite_ice_cream_flavors: ["chocolate", "vanilla", "mint chip"]
knows: nil

name: Freddy
email: freddy@mercury.com
favorite_ice_cream_flavors: ["strawberry", "cookie dough", "mint chip"]
```

```
contacts.each do |person, data|
  #at this level, "person" is Jon Snow or Freddy and "data" is a hash of
  #key/value pairs to iterate over the "data" hash, we can use the following
  #line:

  data.each do |attribute, value|
    #at this level, "attribute" describes the key of :name, :email,
    #:favorite_ice_cream_flavors, or :knows we need to first check and see if
    #the key is :favorite_ice_cream_flavors, if it is, that means the VALUE is
    #an array that we can iterate over to print out each element

    if attribute == :favorite_ice_cream_flavors
      value.each do |flavor|
        # here, each index element in an ice cream flavor string
        puts "#{flavor}"
      end
    end
  end
end
```

Outputs:

```
chocolate
vanilla
mint chip
strawberry
cookie dough
mint chip
```
