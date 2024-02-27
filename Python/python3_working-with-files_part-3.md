# Binary files
Before looking at how Python works with binary files, lets look at one of the specialized classes Python uses to store "amorphous data" (data which has no specific shape or form, just a series of bytes).

## What is a bytearray
Python has more that one container able to handle this type of data but the one we're going to look at is called a __bytearray__. As the name would suggest it's an array containing (amorphous) bytes.

In order to have such a container with which to read in and process, for example, a bitmap image you have to create it explicitly:


```python
a_data = bytearray(10) # creates a bytearray able to store 10 bytes, this container will be filled with zeros
print(a_data)
print(len(a_data))
```

    bytearray(b'\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00')
    10


Bytearrays share some similiarities with standard Python lists. For example, they're __mutable__, the `len()` function recognises them, and you can access the array's elements using indexing.


```python
print(a_data[3])
```

    0


However, you cannot set any bytearray element to a non-integer value. If you try you'll get a `TypeError` exception. This integer value must be between 0 and 255 (inclusive), or you'll raise a `ValueError` exception.

## How to write a bytearray
The first step is creating a bytearray of sufficient size. Then we can populate the array with data of some sort. Finally, we can use the same `open()` and `write()` functions in binary (`b`) mode to actually write the file.


```python
from os import strerror

new_data = bytearray(10)

for i in range(len(new_data)):
    new_data[i] = 10 + i
    
try:
    byte_file = open("file.bin","wb")
    byte_file.write(new_data)
    byte_file.close()
except IOError as e:
    print("I/O error occurred:",strerror(e.errno))
    

```

## How to read from a bytearray
### The `readinto()` method
The first method to mention is the `readinto()` method which takes one argument, a bytearray to fill with the data being read.


```python
read_data = bytearray(10)

try:
    byte_file = open("file.bin","rb")
    byte_file.readinto(read_data)
    for i in data:
        print(hex(i),end=" ")
    byte_file.close()
except IOError as e:
    print("I/O error occurred:",strerror(e.errno))
```

    0xa 0xb 0xc 0xd 0xe 0xf 0x10 0x11 0x12 0x13 

### The `read()` method
Alternatively, we can use the same `read()` method as for text but passed as an argument for the `bytearray()` function. Invoking the `read()` method without arguments will attempt to read the entire file into memory. __Only use this method if you know that the files contents will fit in the available memory__.


```python
from os import strerror

try:
    bfile = open("file.bin","rb")
    bfdata = bytearray(bfile.read())
    bfile.close()
    
    for b in bfdata:
        print(hex(b),end=" ")
        
except IOError as e:
    print("I/O Error occurred:",strerror(e.errno))
```

    0xa 0xb 0xc 0xd 0xe 0xf 0x10 0x11 0x12 0x13 

If you pass an argument to the `read()` method, that argument specifies the maximum number of bytes to be read. In the following example we read 5 of the 10 bytes.


```python
try:
    bfile2 = open("file.bin", "rb")
    bf2data = bytearray(bfile2.read(5))
    bfile2.close()
    
    for b in bf2data:
        print(hex(b), end=" ")
        
except IOError as e:
    print("I/O Error occurred:",strerror(e.errno))
```

    0xa 0xb 0xc 0xd 0xe 

## Putting this knowledge to use
Lets use the knowledge we've acquired with regard to reading & writing files to create a functional albeit unimpressive tool for copying files.


```python
from os import strerror

char_count = 0

# prepare the file to copy
src_file = input("Enter the name of the file you want to copy: ")

try:
    file_to_copy = open(src_file,"rt")
except IOError as e:
    print("Unable to open the source file:",strerror(e.errno))
    exit(e.errno)
    
# prepare the destination file
dst_file = input("Enter a name for the destination file: ")

try:
    file_to_create = open(dst_file,"wt")
except IOError as e:
    print("Unable to create file:",strerror(e.errno))
    file_to_copy.close()
    exit(e.errno)

# do the copying    
try:
    incoming = file_to_copy.read(1)
    while incoming != '':
        for ch in incoming:
            char_count += 1
            file_to_create.write(ch)
            incoming = file_to_copy.read(1)
    file_to_copy.close()
    file_to_create.close()
except IOError as e:
    print("Unable to complete transaction:",strerror(e.errno))
```

    Enter the name of the file you want to copyriker.txt
    Enter a name for the destination filenew_riker.txt

