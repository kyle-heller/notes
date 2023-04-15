# Substrings

## Example 1

```
def substrings(text, dictionary)
  result = Hash.new(0)
  lowered_text = text.downcase

  dictionary.each do |word|
    matches = lowered_text.scan(word).length
    result[word] = matches unless matches == 0
  end

  return result
end

dictionary = ["below","down","go","going","horn","how","howdy","it","i","low","own","part","partner","sit"]

substrings("Howdy partner, sit down! How's it going?", dictionary)
```

This is a Ruby code that defines a function substrings that takes two arguments, text and dictionary. The function returns a Hash that contains the counts of each word in the dictionary that appears in the text argument.

Here's a line-by-line explanation of the code:

```
def substrings(text, dictionary)
```

This line defines a function called substrings that takes two arguments: text and dictionary.

```
  result = Hash.new(0)
```

This line creates a new Hash object called result with a default value of 0. This hash will be used to store the counts of each word in the dictionary that appears in the text.

```
  lowered_text = text.downcase
```

This line creates a new string object called lowered_text that is a lowercase version of the text argument. This will make it easier to compare the words in the dictionary to the words in the text, since we don't have to worry about case sensitivity.

```
  dictionary.each do |word|
    matches = lowered_text.scan(word).length
    result[word] = matches unless matches == 0
  end
```

This block of code iterates over each word in the dictionary array using the .each method.
For each word in the dictionary, the scan method is called on lowered_text with the word as an argument. This returns an array of all the occurrences of word in lowered_text.
The .length method is called on this array to get the count of occurrences.
The count is stored in the result hash with the word as the key.
The unless statement checks if matches is equal to 0, and if it is not, it assigns matches to the value of result[word].
In other words, this block of code counts the number of times each word in the dictionary appears in the text, and stores the count in the result hash.

```
  return result
end
```

This line marks the end of the function definition, and specifies that the result hash should be returned when the function is called.

```
dictionary = ["below","down","go","going","horn","how","howdy","it","i","low","own","part","partner","sit"]
```

This line creates an array called dictionary that contains a list of words.

```
substrings("Howdy partner, sit down! How's it going?", dictionary)
```

This line calls the substrings function with two arguments: a string and the dictionary array.

The function returns a hash that contains the counts of each word in the dictionary array that appears in the string argument.

In this case, the output would be: { "down" => 1, "how" => 2, "howdy" => 1, "it" => 2, "i" => 3, "own" => 1, "part" => 1, "partner" => 1, "sit" => 1 }. This is because each word in the dictionary appears at least once in the string argument.

## Example 2

```
def substrings(string, dictionary)
  string = string.downcase
  count = string.split(' ').reduce(Hash.new(0)) do |object, word|
    dictionary.each {|element| object[element] += 1 if word.include?(element)}
    object
  end
  return count
end
```

This is a Ruby code that defines a function substrings that takes two arguments, string and dictionary. The function returns a Hash that contains the counts of each word in the dictionary that appears in the string argument.

Here's a line-by-line explanation of the code:

```
def substrings(string, dictionary)
```

This line defines a function called substrings that takes two arguments: string and dictionary.

```
  string = string.downcase
```

This line creates a new string object called string that is a lowercase version of the string argument. This will make it easier to compare the words in the dictionary to the words in the string, since we don't have to worry about case sensitivity.

```
  count = string.split(' ').reduce(Hash.new(0)) do |object, word|
    dictionary.each {|element| object[element] += 1 if word.include?(element)}
    object
  end
```

This block of code initializes a new Hash object called count with a default value of 0.
The split method is called on the string object with a space character as an argument. This splits the string into an array of words.

The reduce method is called on this array with count as the initial value of the memo object. This allows us to iterate over each word in the array and build up the count hash.

For each word in the array, the each method is called on the dictionary array.

For each word in the dictionary, if it appears in the current word being iterated over in the array, the value for that dictionary word is incremented by 1 in the count hash.

After all the words in the dictionary have been checked against the current word being iterated over, the reduce method returns the updated count hash as the new memo object.

In other words, this block of code counts the number of times each word in the dictionary appears in the string, and stores the count in the count hash.

```
  return count
end
```

This line marks the end of the function definition, and specifies that the count hash should be returned when the function is called.

Therefore, if we call the function substrings with the string "Howdy partner, sit down! How's it going?" and the dictionary ["below","down","go","going","horn","how","howdy","it","i","low","own","part","partner","sit"], the function will return a hash that counts the occurrences of each word in the dictionary in the string argument. The output will be: { "down" => 1, "how" => 2, "howdy" => 1, "it" => 2, "i" => 3, "own" => 1, "part" => 1, "partner" => 1, "sit" => 1 }.

## Example 3

```
def substrings(string, dictionary)
  results_array = []
  results_counted = Hash.new(0)
  dictionary.each {|substring| results_array += string.downcase.scan(substring)}
  results_array.each do |result|
    results_counted[result] += 1
  end
  return results_counted
end

dictionary = ["below","down","go","going","horn","how","howdy","it","i","low","own","part","partner","sit"]

substrings("Howdy partner, sit down! How's it going?", dictionary)
```

This is a Ruby code that defines a function substrings that takes two arguments, string and dictionary. The function returns a Hash that contains the counts of each substring in the dictionary that appears in the string argument.

Here's a line-by-line explanation of the code:

```
def substrings(string, dictionary)
```

This line defines a function called substrings that takes two arguments: string and dictionary.

```
  results_array = []
  results_counted = Hash.new(0)
```

These lines initialize an empty array called results_array and a new hash called results_counted with a default value of 0. The results_array will be used to store all the substrings found in the string argument, and results_counted will be used to store the count of each substring.

```
  dictionary.each {|substring| results_array += string.downcase.scan(substring)}
```

This block of code iterates over each substring in the dictionary array and uses the scan method to find all occurrences of each substring in the string argument (after converting it to lowercase). The resulting substrings are then appended to the results_array.

```
  results_array.each do |result|
    results_counted[result] += 1
  end
```

This block of code iterates over each substring in the results_array and increments the count for that substring in the results_counted hash.

```
  return results_counted
end
```

This line marks the end of the function definition, and specifies that the results_counted hash should be returned when the function is called.

Therefore, if we call the function substrings with the string "Howdy partner, sit down! How's it going?" and the dictionary ["below","down","go","going","horn","how","howdy","it","i","low","own","part","partner","sit"], the function will return a hash that counts the occurrences of each substring in the dictionary in the string argument. The output will be: { "how"=>2, "howdy"=>1, "part"=>1, "partner"=>1, "it"=>2, "i"=>3, "sit"=>1, "down"=>1, "own"=>1, "go"=>1, "going"=>1 }.
