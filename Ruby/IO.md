# Input And Output

## Output Commands

**Puts**

The puts statement instructs the program to display a value. This will add a new line at the end of each line it writes. Puts returns nil.

```
irb(main):001:0> puts "Learning to code is cool!!"
Learning to code is cool!!
=> nil

irb(main):002:0> puts "Hey, I want 2 key lime pies."
Hey, I want 2 key lime pies.
=> nil
```

**Print**

The print statement instructs the program to display the value. The cursor is positioned on the same line. Print returns nil.

```
irb(main):001:0> print "Learning to code is FUN!"
Learning to code is FUN!=> nil

irb(main):002:0> print "1234"
1234=> nil
```

**Putc**

Unlike the puts statement, which outputs the entire string onto the screen, the putc statement can be used to output one character at a time. Returns entire string.

```
irb(main):020:0> putc str
H=> "Hello Ruby!"
```

## Input Commands

**Gets**

The gets statement can be used to take any input from the user from standard screen called STDIN.

When we use gets, program execution will stop and wait for user input. After the user presses Enter, the program will continue its execution.

The gets command always returns a new line at the end of the input. You can use the #chomp method to trim seperators such as the new line at the end of the return value of gets.

Gets returns the user input.

```
irb(main):001:0> gets
The Odin Project
=> "The Odin Project\n"
```

## Opening and Closing Files
