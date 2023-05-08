# Space Complexity

## What is space complexity?

Space complexity can be considered to be the total space used by an algorithm relative to the size of the input. Thinking back to the previous lesson, you’ll recall that we don’t consider the efficiency of an algorithm in how it performs in one specific instance of that algorithm running. Instead, we want to know how the efficiency changes when the size of the input changes.

Measuring space complexity considers the space used by your algorithm input and auxiliary space. Auxiliary space is the extra space used by the algorithm. These can be things like temporary variables created during the execution of the algorithm. They won’t have a lasting impact on memory space but during the execution of the algorithm will need to be considered. Therefore, you can consider the space complexity to be the total amount of working memory our algorithm needs.

Great cheat cheat -> https://www.bigocheatsheet.com/

## How do we measure space complexity?

The good news is that we measure space complexity in exactly the same way as time complexity. You already learned about Big O in the last lesson, so you already know how to measure the efficiency of your code. The difference is that you’ll need to think about how your algorithm is utilizing memory rather than time.

The first thing to know is that, like time complexity, we measure space complexity by considering all steps including any constants, and then we drop the constants when applying a Big O Notation to the algorithm. So we may have an algorithm that uses memory in Linear Complexity as the input changes, and in doing so creates 3 temporary variables. So we can think of the complexity of our algorithm as O(N) + 3 auxiliary variables using memory. Because those 3 variables are the same no matter our input size, we don’t concern ourselves with them when considering the space complexity of our algorithm. So we’d say the space complexity is O(N). This should be familiar to you from the time complexity lesson.

O(1) - Constant Complexity
O(log N) - Logarithmic Complexity
O(N) - Linear Complexity
O(N log N) - N x log N Complexity
O(n²) - Quadratic Complexity
O(n³) - Cubic Complexity
O(2ⁿ) - Exponential Complexity
O(N!) - Factorial Complexity

## O(1) - Constant Complexity

Consider this example.

```ruby
def multiply(num1, num2)
  num1 * num2
end
```

Here it should hopefully be clear that no matter the arguments we enter when we call the function, only two variables are created. It doesn’t change. Therefore, we can consider the space this takes is always O(1).

## O(N) - Linear Complexity

Most data structures you come across will have a space complexity of O(N). That makes sense - when you increase the number of items in your data structure, it increases the space that data structure occupies in a linear way.

```ruby
def sum_arr(arr)
  copy_arr = arr.dup
  sum = 0
  copy_arr.each do |number|
    sum += number
  end
  return sum
end
```

We wrote this in a slightly more verbose way than you’d normally write it in Ruby to make it a little clearer. Here we have a method which accepts an array. Within, we have two variables. One called sum and the other copy_arr which holds a copy of the array passed in. We then have an each loop that iterates over the array. The amount of space that this algorithm takes depends on the array that is passed to it. It could be 3 elements in the array or 300. When we don’t know the length of the array, we refer to it as N, so we have N + 1 variable called sum. We know that we drop constants with Big O, so we are left with N, or O(N) for its Big O notation.

Why did we make a copy of the array? That will be discussed in a later section.

The complexity is replicated no matter the data structure:

```ruby
def sum_hash_values(hash)
  copy_hash = hash.dup
  sum = 0
  copy_hash.each do |_, value|
    sum += value
  end
  return sum
end
```

Here as the hash size increases, the space it uses grows in a linear way.

## Other Complexities

As we’ve stated, many data structures share O(N) space complexity, and therefore you won’t write many algorithms with a space complexity that differs.

You do find some recursive functions that may have a different space complexity and some sorting algorithms. You normally won’t have much reason to consider anything else though.

In the last lesson one of the assignments was a link to the Big-O cheat sheet. If you take another look at it now, you may have a better appreciation for just how amazing it is as a reference for space and time complexity. If you scroll down to the data structures and then the sorting algorithms section, you’ll see it gives you the time and space complexities. Notice just how many are O(N), especially for data structures. Many sorting algorithms have just O(1) space complexity, something to keep in mind as you come across different sorting algorithms during your learning.

That’s why we won’t be diving into examples for other Big O notations with space complexity. We’d have to come up with convoluted examples that wouldn’t represent most code you’ll write. If you do come across a good real world example in your own code, then do let us know and we may consider adding it here for others to consider.

## Other Considerations

One of the common areas that causes confusion when considering space complexity is what constitutes using space in the context of an algorithm. In an earlier example we wrote methods that duplicated an array and hash argument. We did that to be explicit. But what if we’d written the method as:

```ruby
def sum_arr(arr)
  sum = 0
  arr.each do |number|
    sum += number
  end
  return sum
end
```

When a data structure is passed in as the argument, especially for languages that pass arrays by reference rather than value, it can be a bit unclear if that method considers the space used by that data structure when calculating its space complexity. If we didn’t count it, then it would be easy for all our methods to have great space usage on paper because we put the onus on the caller to allocate that space. If we did count it, but the data structure was created for use by many different methods, then the space complexity for all those methods is O(N) when they aren’t utilizing additional space. Then consider that if your method receives an array as an input and loops it, an index must be created for the loop which uses additional space.

The first answer to analyzing space complexity provides some great context to the question and gives some thought-provoking answers.

Ultimately when you consider Big O measures the worst-case scenario, it would be easier to err on the side of caution and do consider the space of arguments passed to your method.

## Calculating Space Complexity

When we talk about big O, we know that time and space complexities tend to deal with this value n. Typically n represents the number of elements in a given data structure and can determine the amount of bytes needed to execute a function. Some languages like Java and C++ require that you allocate the amount of space needed to declare a data structure before even adding anything into it! Without going too far, I want to simply make you aware of the fact that space is calculated in terms of bytes. Essentially n would be the number of elements but also the amount of bytes that would be required to execute a function.

With that in mind, we can break down the memory consumption of an algorithm into three different parts that mainly affect the space complexity:

**variables and constants**
Any function or algorithm that is based purely in variables or constants that are fixed and do not change over time will be measured as O(1) or constant space. These variables or constants will always take up the same amount of memory and thus do not need to be re-calculated for space after the program finishes running.

**inputs**
The initial parameters we are given to begin the function are important for space complexity. If we are given an array then we already know that there will need to be space allocated for the amount of elements in the array.

**execution**
Some functions will run and be completed right away, whereas some functions could be recursive or call other functions inside of itself. These functions could hold other functions on the stack waiting to be executed while it finishes. Space complexity is different for both of these situations. If a function completes as soon as it is called, no extra space is needed for it to be done. But in the case of a recursive function or a function calling another function inside of itself, extra space is needed in order to hold the values that are waiting to be executed.

**Examples**

1. ```ruby
   def get_sum(x, y, z)
   sum = 0
   sum = x + y + z
   return sum
   end
   ```

For this example, we can see that there are only 3 parameters and 1 variable that we need to worry about. All of these values are fixed and will not change in the future. Therefore the space complexity overall will be O(1).

2. ```ruby
      def get_sum(array)
        sum = 0
        for i in [0...array.length]
          sum += array[i]
        end
        return sum
      end
   ```

   For this example we have our sum variable, but we also have a for loop. Any loop will take up as much space as the length of the item we are looping over. In this case we need to loop through the array to find out the total of all of the values in the array, thus our space complexity will be O(n) or linear where n is the number of elements in our array. This is because the space will continue to increase at the same rate as n will. If we think of a linear graph, it is simply a diagonal line as the values increase proportionally, as n gets larger so does the amount of space needed.

3. ```ruby
   def get_sum(array)
     size = array.length
     if size == 1
       return array[0]
     else
       return (array[0] + get_sum(array[1...size]))
     end
   end
   ```

This last example I wanted to include because it brings up the issue of recursion and space complexity. We can see here that the function is calling itself multiple times and what would you guess is the space complexity? It's actually O(n) because each time the function calls itself again, space needs to be made for the value to being stored on the stack, waiting for execution. Compared to its iterative counterpart, this takes up much more space where an iterative approach would use the same variable space over and over again, thus being only O(1).

## Recursion and Space Complexity

Space complexity in algorithm development is a metric for how much storage space the algorithm needs in relation to its inputs. -Technopedia

So if my solution to an algorithm involves creating two hash-tables, my space complexity is going to be a lot higher than if it only involves creating a single primitive variable.

Finally, what is the Call Stack?

In computer science, a call stack is a stack data structure that stores information about the active subroutines of a computer program. - Wikipedia

Translation, it's how many tasks the system is juggling at once.

With recursion, every time you call the function recursively you add one more function to the call stack. Until you hit the 'bottom' and start traveling back up or out, you're adding one each time. Now suppose that your function requires establishing a variable. That variable is being established anew every time you call the function.

It goes like this. You have a function that requires that 2 rocks be balanced in your hands. Every time you call the function, you add two more rocks to your pile. You can't start putting rocks down until the function they are for finishes. Because of the nested nature of recursion, you're doing a lot of things at once, and so that pile is going to grow bigger and bigger and may get pretty unwieldy and heavy.

That pile of rocks is your space complexity! The more levels of recursion you have, the higher it will get. You're going to get better performance out of your machine the fewer functions you've got going.

Recursion is really neat, and can lead to some beautifully simple code, but it definitely has its drawbacks.
