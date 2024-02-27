# Closing streams
The final operation performed on a stream (excluding the `stdin`, `stdout`, and `stderr` streams) should be __closing__. This is done by invoking the `close()` method from within the open stream. Example:

`
stream = open(file.txt,'a')
...
stream.close()
`

## Stream problems
The IOError object is equipped with a property named `errno` and you can access it as follows:

`
try:
    open(file.txt)
except IOError as e:
    print(e.errno)
`

The value of the `errno` likely points to one of the predefined constants in the errno module:
- `errno.EACCES` = Permission denied e.g. trying to open a file which is read-only
- `errno.EBADF` = Bad file number e.g. when you try to operate on an unopened stream
- `errno.EEXIST` = File exists e.g. if you try to rename a file with its previous name
- `errno.EFBIG` = File too large i.e. the file is larger than the max allowed by your OS
- `errno.EISDIR` = Is a directory e.g. you try to treat a directory name as if it were a file name
- `errno.EMFILE` = Too many open files i.e. you tried to simultaneously open more streams than allowed by your OS
- `errno.ENOENT` = No such file or directory i.e. you tried to access a non-existent file/directory
- `errno.ENOSPC` = No space left on device i.e. there is no free space on your drive

### Using the `strerror()` function from the `os` module
To simplify the process of determining which exception has been raised and accessing a user-friendly description we can leverage the `strerror()` function from the `os` module.


```python
from os import strerror
from errno import ENOENT

try:
    raise IOError(ENOENT, 'Not a file')
except IOError as e:
    print("The file could not be opened:", strerror(e.errno))
```

    The file could not be opened: No such file or directory


## Writing to a file
Lets finally write to a file.


```python
stream = open("newfile.txt","wt",encoding="utf-8") # open the stream in write-text & assign to variable
text = "Beautiful is better than ugly.\nExplicit is better than implicit.\nSimple is better than complex.\nComplex is better than complicated."
stream.write(text) # write the above text to the file
stream.close() # close the stream
```

## Reading from a file
We're going to use the `read` mode to obtain the text in the file and then print it.

### The `read()` method
The `read()` method is versatile and can either read char by char or all at once. The latter is advisable unless you know exactly how much text is in the file in question.


```python
stream = open("newfile.txt","rt",encoding="utf-8") # open the stream in read-text mode and assign to variable
ch = stream.read(1) # to be cautious lets read the file character by character
while ch != "": # while the character isn't empty
    print(ch, end="") # print the char
    ch = stream.read(1) # we need to explicitly tell Python to move to the next char, omitting this would create a perpetual loop
stream.close() # close the stream
```

    Beautiful is better than ugly.
    Explicit is better than implicit.
    Simple is better than complex.
    Complex is better than complicated.

### The `readline()` method
An alternative to using the `read()` is `readline()` which does what the name suggests; reads line-by-line.


```python
char_count = line_count = 0
stream = open("newfile.txt","rt",encoding="utf-8") # open the stream in read-text mode and assign to variable
line = stream.readline() # read the contents line-by-line
while line != "":
    line_count+=1 # lets count the number of lines
    for ch in line:
        print(ch,end="") # while we're at it lets count the characters too
        char_count+=1
    line = stream.readline() # don't forget to tell Python to move to the next line
stream.close() # close the stream
print("\n\nCharacters in file:",char_count)
print("Lines in file:",line_count)
```

    Beautiful is better than ugly.
    Explicit is better than implicit.
    Simple is better than complex.
    Complex is better than complicated.
    
    Characters in file: 131
    Lines in file: 4


### The `readlines()` method
You may be able to guess what this method does, it simply allows you to read multiple lines at ones. By default, if no arguments are passed it will try to read all the contents and return a list of strings with one element per line in the file. However, you can also tell it to read only x number of bytes at once.


```python
char_count = line_count = 0
stream = open("newfile.txt","rt",encoding="utf-8") # open the stream in read-text mode and assign to variable
x_lines = stream.readlines(2) # read the contents
while len(x_lines) != 0:
    for line in x_lines:
        line_count += 1
        for ch in line:
            print(ch, end="")
            char_count += 1
    x_lines = stream.readlines(2) # don't forget to tell Python to move to the next line
stream.close() # close the stream
print("\n\nCharacters in file:",char_count)
print("Lines in file:",line_count)
```

    Beautiful is better than ugly.
    Explicit is better than implicit.
    Simple is better than complex.
    Complex is better than complicated.
    
    Characters in file: 131
    Lines in file: 4


## The `open()` function's object
As mentioned previously, the `open()` function returns an object. It's worth noting that this object is __iterable__. The object's iteration protocol includes the `__next__` method which will simply return the next line read in from the file. This also means that the object will automatically close when the end of the file is reached (thus you don't always need to invoke `close()` explicitly).


```python
from os import strerror

try:
    ccount = lcount = 0
    for line in open("newfile.txt", "rt"):
        lcount += 1
        for ch in line:
            print(ch,end="")
            ccount += 1
    print("\n\nCharacters in file:",ccount)
    print("Lines in file:",lcount)
except IOError as e:
    print("I/O Error: ",strerror(e.errno))
```

    Beautiful is better than ugly.
    Explicit is better than implicit.
    Simple is better than complex.
    Complex is better than complicated.
    
    Characters in file: 131
    Lines in file: 4


## Writing to files continued
In the above example when writing to a file we wrote a chunk of text all at once but you can also write character-by-character if you'd like.


```python
from os import strerror

try:
    newfile = open("newtext.txt","wt")
    for i in range(21):
        line = "Line no. " + str(i+1) + "\n"
        for ch in line:
            newfile.write(ch)
    newfile.close()
except IOError as e:
    print("I/O Error:",strerror(e.errno))
    
read_the_new_file = open("newtext.txt","rt")
for l in read_the_new_file:
    print(l)
    
```

    Line no. 1
    
    Line no. 2
    
    Line no. 3
    
    Line no. 4
    
    Line no. 5
    
    Line no. 6
    
    Line no. 7
    
    Line no. 8
    
    Line no. 9
    
    Line no. 10
    
    Line no. 11
    
    Line no. 12
    
    Line no. 13
    
    Line no. 14
    
    Line no. 15
    
    Line no. 16
    
    Line no. 17
    
    Line no. 18
    
    Line no. 19
    
    Line no. 20
    
    Line no. 21
    



```python

```
