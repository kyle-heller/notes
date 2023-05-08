# Error Handling

Error handling is an important aspect of software development, and it is generally a good idea to include error handling in your methods to make them more robust and reliable.

Adding error handling to your methods can help prevent errors and unexpected behavior that could potentially crash your program or cause other issues. Error handling can also provide useful feedback to users or other parts of your code, helping them to understand what went wrong and how to fix it.

However, the amount of error handling you include in your methods can depend on a few factors, such as the intended use of the method and the complexity of the code. For example, if a method is only used in a small part of your program and is relatively simple, you may not need to include extensive error handling. On the other hand, if a method is critical to the functioning of your program or involves complex operations, it may be more important to include robust error handling.

In general, it's a good idea to think about the potential errors that could occur in your method and how you might handle them. By planning for potential errors and including appropriate error handling in your code, you can help ensure that your code is more reliable and easier to maintain in the long run.

To add error handling to your code, you can use Ruby's begin, rescue, and ensure keywords. Here's an example of how you could modify the substrings function to handle errors:

```
def substrings(string, dictionary)
  begin
    raise ArgumentError, "string argument must be a string" unless string.is_a?(String)
    raise ArgumentError, "dictionary argument must be an array of strings" unless dictionary.is_a?(Array) && dictionary.all? {|word| word.is_a?(String)}

    results_array = []
    results_counted = Hash.new(0)

    dictionary.each {|substring| results_array += string.downcase.scan(substring)}
    results_array.each do |result|
      results_counted[result] += 1
    end

    return results_counted

  rescue ArgumentError => e
    puts "Error: #{e.message}"
  rescue => e
    puts "Unexpected error: #{e.message}"
  ensure
    puts "Substrings function complete."
  end
end
```

This modified code uses begin, rescue, and ensure to handle two types of errors: ArgumentError and any other unexpected errors.

The begin block encloses the entire function, and the rescue blocks specify what to do in case an error occurs. If an ArgumentError is raised (because the string argument is not a string or the dictionary argument is not an array of strings), a custom error message is printed to the console. For any other unexpected errors, a generic error message is printed. The ensure block is executed regardless of whether an error occurs or not, and simply prints a message indicating that the function is complete.

With this error handling in place, if an error occurs when the substrings function is called, a helpful error message will be printed to the console, allowing you to quickly identify and fix the problem.

In the above example, e is a variable that is used to reference the error object that was raised by Ruby. In the rescue block, we're using the => syntax to assign the error object to the variable e, like so:

```
rescue ArgumentError => e
  puts "Error: #{e.message}"
```

This means that if an ArgumentError is raised, the error object will be assigned to the variable e. We can then use the e variable to access information about the error, such as its message or backtrace.

For example, in the above code, we're using e.message to retrieve the error message associated with the error object. We're then including this error message in a custom error message that we're printing to the console.

Using a variable like e to reference the error object is a common convention in Ruby and other programming languages. It helps to make your code more readable and easier to understand, especially when working with complex error handling logic.

## Types of Errors

In programming, there are many different types of errors that can occur. Some of the most common types of errors that you might define or handle in your code include:

Syntax errors: These errors occur when the code violates the rules of the programming language syntax. This can happen if you forget a closing parenthesis, for example, or if you misspell a keyword.

Runtime errors: These errors occur when the program is running and something goes wrong, such as trying to divide by zero or accessing an array element that doesn't exist.

Logical errors: These errors occur when the program runs without crashing, but produces incorrect results. This can happen if there's a mistake in the program's logic, such as using the wrong formula to calculate a result.

Input errors: These errors occur when the program receives unexpected or invalid input from the user or another part of the system. This can happen if the user enters a string instead of a number, for example, or if a file is missing.

Resource errors: These errors occur when the program is unable to access or use a required resource, such as a file or network connection.

When defining error handling in your code, it's important to consider all of these types of errors and plan for how your code will handle them. By being proactive and anticipating potential errors, you can write more robust and reliable code that is less likely to crash or produce incorrect results.

## Types of Errors in Ruby

In Ruby, there are many different types of errors that you might encounter. Some of the most common types of errors in Ruby include:

ArgumentError: This error occurs when a method is called with the wrong number or type of arguments.

NoMethodError: This error occurs when you call a method on an object that doesn't respond to that method.

NameError: This error occurs when you reference a variable or constant that doesn't exist.

TypeError: This error occurs when you try to perform an operation on objects of the wrong type, such as adding a string to an integer.

LoadError: This error occurs when Ruby is unable to load a required file or library.

SyntaxError: This error occurs when the code violates the rules of the Ruby syntax.

RuntimeError: This is a catch-all error that can occur when something goes wrong at runtime, such as dividing by zero or accessing an array element that doesn't exist.

There are many other types of errors in Ruby, but these are some of the most common. When writing code in Ruby, it's important to be aware of these error types and plan for how your code will handle them. This can help you write more robust and reliable code that is less likely to crash or produce incorrect results.

## Using retry

The retry statement redirects the program back to the begin statement. This is helpful if your begin/rescue block is inside a loop and you want to retry the same command and parameters that previously resulted in failure.

Here's a simple example; I use the raise statement to create my own Exception to be caught:

```
for i in 'A'..'C'
  retries = 2
  begin
    puts "Executing command #{i}"
    raise "Exception: #{i}"
  rescue Exception=>e
    puts "\tCaught: #{e}"
    if retries > 0
      puts "\tTrying #{retries} more times\n"
      retries -= 1
      sleep 2
      retry
    end
  end
end
```

```
Executing command A
   Caught: Exception: A
   Trying 2 more times
Executing command A
   Caught: Exception: A
   Trying 1 more times
Executing command A
   Caught: Exception: A
Executing command B
   Caught: Exception: B
   Trying 2 more times
Executing command B
   Caught: Exception: B
   Trying 1 more times
Executing command B
   Caught: Exception: B
Executing command C
   Caught: Exception: C
   Trying 2 more times
Executing command C
   Caught: Exception: C
   Trying 1 more times
Executing command C
   Caught: Exception: C
```

## Using retry with OpenURI

The following snippet of code attempts to download pages from Wikipedia. The third entry, xj3490, refers to a non-existent page and is guaranteed to fail:

```
require 'open-uri'
remote_base_url = "http://en.wikipedia.org/wiki"

[1900, 1910, 'xj3490', 2000].each do |yr|

 retries = 3

 begin
   url = "#{remote_base_url}/#{yr}"
   puts "Getting page #{url}"
   rpage = open(url)
 rescue StandardError=>e
   puts "\tError: #{e}"
   if retries > 0
       puts "\tTrying #{retries} more times"
       retries -= 1
       sleep 1
       retry
   else
       puts "\t\tCan't get #{yr}, so moving on"
   end
 else
   puts "\tGot page for #{yr}"
 ensure
   puts "Ensure branch; sleeping"
   sleep 1

 end
end
```

The output is:

```
Getting page http://en.wikipedia.org/wiki/1900
   Got page for 1900
Ensure branch; sleeping
Getting page http://en.wikipedia.org/wiki/1910
   Got page for 1910
Ensure branch; sleeping
Getting page http://en.wikipedia.org/wiki/xj3490
   Error: 403 Forbidden
   Trying 3 more times
Getting page http://en.wikipedia.org/wiki/xj3490
   Error: 403 Forbidden
   Trying 2 more times
Getting page http://en.wikipedia.org/wiki/xj3490
   Error: 403 Forbidden
   Trying 1 more times
Getting page http://en.wikipedia.org/wiki/xj3490
   Error: 403 Forbidden
      Can't get xj3490, so moving on
Ensure branch; sleeping
Getting page http://en.wikipedia.org/wiki/2000
   Got page for 2000
Ensure branch; sleeping
```

As you can see in the highlighted code above, the ensure branch is skipped by the retry. The retry statement can be very useful but because of the "jump" it creates in your program flow, take care in using it so that your script isn't difficult to understand. And of course, if you don't have some kind of limiting condition, such as retries > 0 – just a simple decrementing variable I set up for this script – your script will end up in an infinite loop.

## Exception and Error Classes

Not all errors are the same. And so when designing your exception handling blocks, you may find it necessary to write rescue statements for specific errors, rather than just a catch-all rescue statement as we've done so far.

This section will make more sense if you have a little understanding of object-oriented programming. The basic concept as it relates to exceptions and errors is this:

- Every type of error and exception is derived from the Exception class
- If your code rescues a StandardError, it will only rescue errors that are derived from StandardError.
- If your code rescues an Exception, it will basically handle every possible error that could happen, including all errors of StandardError type and its children types.

## The Exception Family Tree

```
Exception
    NoMemoryError
    ScriptError
        LoadError
        NotImplementedError
        SyntaxError
    SignalException
        Interrupt
    StandardError
        ArgumentError
        IOError
            EOFError
        IndexError
            StopIteration
        LocalJumpError
        NameError
            NoMethodError
        RangeError
            FloatDomainError
        RegexpError
        RuntimeError
        SecurityError
        SystemCallError
        SystemStackError
        ThreadError
        TypeError
        ZeroDivisionError
    SystemExit
    fatal
```

As you can see, the StandardError class covers just about any kind of syntax-type error. For example, if your code tries to read from a file that doesn't exist:

## Unintended Consequences of Too Wide a Net (aka can't break out with interupt)

```
while 1
   puts "Enter a number>>"
   begin
     num = Kernel.gets.match(/\d+/)[0]
   rescue StandardError=>e
     puts "Erroneous input!"
     puts e
     puts "\tTry again...\n"
   else
     puts "#{num} + 1 is: #{num.to_i+1}"
   end
end
```

Output:

```
~ :)  ruby extest.rb
Enter a number>>
5
5 + 1 is: 6
Enter a number>>
a
Erroneous input!
undefined method `[]' for nil:NilClass
   Try again...

Enter a number>>
```

Run the script but use Ctrl-C to break out of it. You should see something like this as you are kicked out to the command prompt

```
Enter a number>>
^Cextest.rb:4:in `gets': Interrupt
   from extest.rb:4
~ :)
```

Instead of rescuing StandardError – which is the default class of error that is rescued if you don't specify otherwise) – modify the code so that it will rescue the Exception class:

```
while 1
   puts "Enter a number>>"
   begin
     num = Kernel.gets.match(/\d+/)[0]
   rescue Exception=>e
     puts "Erroneous input!"
     puts e
     puts "\tTry again...\n"
   else
     puts "#{num} + 1 is: #{num.to_i+1}"
   end
end
```

Run it from the command line. It'll execute in the same way as it did before. However, when you try Ctrl-C to break out of the program, you'll find that it won't let you:

```
~ :) ruby extest.rb
Enter a number>>
7
7 + 1 is: 8
Enter a number>>
a
Erroneous input!
undefined method `[]' for nil:NilClass
   Try again...
Enter a number>>
^CErroneous input!

   Try again...
Enter a number>>
^CErroneous input!

   Try again...
Enter a number>>
```

Unfortunately it won't print out the type of exception, but what's happening is that Ctrl-C creates an Interrupt-type exception. But because our program is designed to rescue Exception, which includes Interrupt, the program "rescues" our Ctrl-C action. Thus, we can't use that to break out of the program (you'll just have to shut down your command line window to get out of it.)

The main lesson here is that while it may be convenient to rescue everything, it may cause unwanted effects and behavior. Be specific when possible.
