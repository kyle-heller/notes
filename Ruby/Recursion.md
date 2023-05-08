# Recursion

Recursion is defined as a function that calls itself as part of it's execution.

When you define a recursive function you need two things:

1. Guard clause (aka Base Case) which when triggered will terminate the recursive process. There can be more than one base case.

2. Recursive case in which the recursion will actually occur.

In general but not always recursion replaces loops we'd use in non-recursive functions.

Recursive algorithms are a type of algorithm known as Divide and Conquer which you can read more about here:
https://en.wikipedia.org/wiki/Divide-and-conquer_algorithm

There can be more than one base case. An example of multiple base cases can be seen with the Fibonacci sequence recursive method.

The Fibonacci number sequence is
defined as follows:

- The first element is 0.
- The second element is 1.
- The nth element is the sum of the (n-1)th and (n-2)th elements.

There can also be multiple recursive cases. An example of this is the The Collatz conjecture.

The Collatz conjecture:

The Collatz conjecture is applies to positive integers and
speculates that it is always possible to get "back to 1" if you
follow these steps:

- If n is 1, stop.
- Otherwise, if n is even, repeat this process on n/2.
- Otherwise, if n is odd, repeat this process on 3n + 1.

Write a recursive function collatz (n) that calculates how
many steps it takes to get to 1 if you start from n and recurse
as indicated above.

```ruby
def collatz(n)
# Base Case
  if n == 0
    return n
# Recursive Case #1
  elsif n.even?
    1 + collatz(n/2)
# Recursive Case #2
  else
    1 + collatz((3*n)+1)
   end
end
```

https://www.freecodecamp.org/news/how-recursion-works-explained-with-flowcharts-and-a-video-de61f40cb7f9/

Examples:

```javascript
function countDown(n) {
  for (let i = n; i > 0; i--) {
    console.log(i);
  }
  console.log("Hooray");
}

function countDownRecursive(n) {
  if (n <= 0) {
    console.log("Hooray");
    return;
  }
}

countDownRecursive(3);
--countDownRecursive(2);
----countDownRecursive(1);
------countDownRecursive(0);
------return;
----return;
--return;
return;
```

```javascript
function sumRange(n) {
  let total = 0;
  for (let i = n; i > 0; i--) {
    total += i
  }
  return total
}

function sumRangeRecursive(n, total = 0) {
  if (n <= 0) {
    return total
  }
  return sumRangeRecursive(n-1, total + n)
}

sumRangeRecursive(3, 0)
--sumRangeRecursive(2, 3)
----sumRangeRecursive(1, 5)
------sumRangeRecursive(0, 6)
------return 6
----return 6
--return 6
return 6
```

For this example it's difficult to do with a loop because we don't know how deep the structure of the object goes. It could go 1 level deep or it could be 100 levels deep. With recursion this type of issue is relatively simple.

```javascript
const tree = {
  name: "John",
  children: [
    {
      name: "Jim",
      children: [],
    },
    {
      name: "Zoe",
      children: [
        { name: "Kyle", children: [] },
        { name: "Sophia", children: [] },
      ],
    },
  ],
};

function printChildrenRecursive(t) {
  if (t.children.length === 0) {
    return;
  }
  t.children.forEach((child) => {
    console.log(child.name);
    printChildrenRecursive(child);
  });
}

printChildrenRecursive("John");
--printChildrenRecursive("Jim");
--return;
--printChildrenRecursive("Zoe");
----printChildrenRecursive("Kyle");
----return;
----printChildrenRecursive("Sophia");
----return;
--return;
return;
```

Factorial recursion method:

```ruby

def factorial_recursion(n)
  if n == 1
    return 1
  else
    n * factorial_recursion(n-1)
  end
end

fact(n) = n * fact(n-1)

fact(1) = 1
fact(2) = 1 * fact(1)
fact(3) = 3 * fact(2)
fact(4) = 4 * fact(3)
fact(5) = 4 * fact(4)
...

#Non recursive method

def factorial(n)
  product = 1
    while n > 0
      product *= n
      n -= 1
    end
  product
end

```

Measuring Rocks example:

```ruby
# make some random rocks
rocks = 30.times.map{rand(200) + 1}
puts rocks.join(', ')
max_rock = 0

# non recursive method
rocks.each do |rock|
  max_rock = rock if max_rock < rock
end

puts "Heaviest rock is: #{max_rock}"

## or with inject
puts "Heaviest rock is: #{rocks.inject{|max_rock, rock| max_rock > rock ? max_rock : rock}}"

#recursive method
def rock_judger(rocks_arr)
    if rocks_arr.length <= 2  # the base case
      a = rocks_arr[0]
      b = rocks_arr[-1]
    else
      a = rock_judger(rocks_arr.slice!(0,rocks_arr.length/2))
      b = rock_judger(rocks_arr)
    end

    return a > b ? a : b
end


rocks = 30.times.map{rand(200) + 1}
puts rocks.join(', ')
puts "Heaviest rock is: #{rock_judger(rocks)}"

```

Define a recursive function that returns true if a string is a palindrome and false otherwise.

```ruby
def palindrome(string)
  string == string.reverse
end

def palindrome_recursive(string)
  if string.length == 1 || string.length == 0
    return true
  else
    if string[0] == string[-1]
    palindrome_recursive(string[1...-1])
    else
    false
    end
  end
end

#Moves inward until there is only one character to compare
# string[0] == string[-1]
# string[1] == string[-2]
# string[2] == string[-3]
```

Define a recursive function that takes an argument n and prints "n bottles of beer on the wall", "(n-1) bottles of beer on the wall", ..., "no more bottles of beer on the wall".

```ruby
def bottles_of_beer(n)
  if n == 0
    puts "no more bottles of beer on the wall"
  else
    puts "#{n} bottles of beer on the wall"
    bottles_of_beer(n - 1)
  end
end
```

Define a recursive function that takes an argument n and returns the fibonacci value of that position. The fibonacci sequence is 0, 1, 1, 2, 3, 5, 8, 13, 21... So fib(5) should return 5 and fib(6) should return 8.

```ruby
def fibonacci(n)
  if n == 0
    return 0
  elsif n == 1
    return 1
  else
    fibonacci(n-1) + fibonacci(n-2)
  end
end
```

Define a recursive function that flattens an array. The method should convert [[1, 2], [3, 4]] to [1, 2, 3, 4] and [[1, [8, 9]], [3, 4]] to [1, 8, 9, 3, 4].

```ruby
def flatten(array, result = [])
  array.each do |el|
    if el.kind_of?(Array)
      flatten(el, result)
    else
      result << el
    end
  end
  result
end
```

Use the roman_mapping hash to define a recursive method that converts an integer to a Roman numeral.

```ruby
roman_mapping = {
  1000 => "M",
  900 => "CM",
  500 => "D",
  400 => "CD",
  100 => "C",
  90 => "XC",
  50 => "L",
  40 => "XL",
  10 => "X",
  9 => "IX",
  5 => "V",
  4 => "IV",
  1 => "I"
}

def integer_to_roman(roman_mapping, number, result = "")
  return result if number == 0
  roman_mapping.keys.each do |divisor|
    quotient, modulus = number.divmod(divisor)
    result << roman_mapping[divisor] * quotient
    return integer_to_roman(roman_mapping, modulus, result) if quotient > 0
  end
end
```

Use the roman_mapping hash to define a recursive method that converts a Roman numeral to an integer.

```ruby
roman_mapping = {
  "M" => 1000,
  "CM" => 900,
  "D" => 500,
  "CD" => 400,
  "C" => 100,
  "XC" => 90,
  "L" => 50,
  "XL" => 40,
  "X" => 10,
  "IX" => 9,
  "V" => 5,
  "IV" => 4,
  "I" => 1
}

def roman_to_integer(roman_mapping, str, result = 0)
  return result if str.empty?
  roman_mapping.keys.each do |roman|
    if str.start_with?(roman)
      result += roman_mapping[roman]
      str = str.slice(roman.length, str.length)
      return roman_to_integer(roman_mapping, str, result)
    end
  end
end
```

Using iteration, write a method #fibs which takes a number and returns an array containing that many numbers from the fibonacci sequence. Using an example input of 8, this method should return the array [0, 1, 1, 2, 3, 5, 8, 13].
Now write another method #fibs_rec which solves the same problem recursively. This can be done in just 3 lines (or 1 if you’re crazy, but don’t consider either of these lengths a requirement… just get it done).

```ruby
def fibs(n)
  if n == 0
    return []
  elsif n == 1
    return [0, 1]
  else
    fibs_array = fibs(n-1)
    fibs_array << fibs_array[-1] + fibs_array[-2]
  end
end
```

0
1
1
2
3
5
8
13
