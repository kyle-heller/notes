# Working with files in Python
Programs written in Python (and many other languages) do not communicate directly with the files but through abstract entities referred to as *streams* or *handles*. In order to interact with a stream you must first open, hence the act of connecting to a file in Python is called *opening the file* and uses the keyword `open`. Conversely the act of disconnecting a stream is called *closing the file* and uses the keyword `close`.

## File streams
Opening a file also requires telling Python what __mode__ you want to open the file in. If the file is successfully opened you will be able to perform only those operations permitted by the chosen mode.

In the most general terms, the main operations you will be performing on any stream are:
- __read__ from the stream
- __write__ to the stream

The three main modes you will use to perform the above operations are:
- __read mode__: a stream opened in this mode allows read operations only. Trying to write to the stream will throw an exception (specifically the `UnsupportedOperation` exception).
- __write mode__: a stream opened in this mode allows write operations only. Attempting to read from the stream will cause the same exception as noted above.
- __update mode__: this mode allows *both* read and write operations.

## A note on "current file position"
One quirk of how Python manipulates streams is that the stream behaves like a tape-recorder (think old audio cassettes or VHS videotapes); the act of reading from or writing to the stream moves the "tape" along such that you are in a different location than when you started. This is referred to as the __current file position__. So, if you've read the first 3 lines from a file, your current file position is now after those read lines. Meaning that if you want to reread those lines you'll need to "rewind" the "tape" and set your current file position back to the start.

## File handles
When you open a file Python creates an object to represent the file and erases the object when you close the file. Between opening and closing you can use this object to specify what operations you want performed on the stream. The operations you're able to perform are determined by the mode you specified when opening the stream.

In the same way that Python needs to know what operating mode you want to use, it also wants to know what type of file we're working with (i.e. is it text? is it binary?). By default (if you don't specify otherwise) Python will open the file in __text mode__ (denoted by `t`). If you specifically want to work with a binary file you would use the letter `b` when opening the file.

## Modes in detail

### operations
`r`: __read mode__
- File must exist and be readable others an exception will be raised.
- Only read operations can be performed.

`w`: __write mode__
- If file doesn't exist it will be created. If file exists it will be overwritten. If creation is n't possible for some reason, an exception will be raised.
- Only write operations can be performed.

`a`: __append mode__
- If file doesn't exist it will be created. If file exists the stream will start at the end of the existing file (previous contents remain unchanged).
- Both read and write operations can be performed.

`r+`: __read and update mode__
- File must exist and be writeable otherise an exception will be raised.
- Both read and write operations can be performed.

`w+`: __write and update mode__
- If file doesn't exist it will be created. 
- Both read and write operations can be performed.

### data type
`t`: __text mode__
- Default mode if `t` or `b` aren't specified

`b`: __binary mode__

Text mode|Binary mode|Description
:--|:--|:--
`rt`|`rb`|`read`
`wt`|`wb`|`write`
`at`|`ab`|`append`
`r+t`|`r+b`|`read and update`
`w+t`|`w+b`|`write and update`

## Opening a stream
Opening a stream can be done in a couple of ways, each using the `open` function.

One way is to assigne the object created during opening to a variable:
<br>`stream = open(filename, mode='r', encoding='None')`

## Pre-opened streams
There are three exceptions to the rule that operating on any stream requires that the `open()` function be invoked first. In particular if you import the `sys` module, because within that module three streams have already been opened.

- `sys.stdin`
    - stdin is short for "standard input"
    - normally associated with the keyboard, pre-open for reading and regarded as the primary data source for running programs
    - the well known `input()` function reads data from `stdin` by default
   
   
- `sys.stdout`
    - stdout is short for "standard output"
    - normally associated with the screen, pre-open for writing and regarded as the primary target for outputting data.
    - the `print()` function outputs data to the stdout stream.
   
   
- `sys.stderr`
    - stderr is short for "standard error output"
    - normally associated with the screen, pre-open for writing and regarded as the primary place where a running program should send information on the errors encountered during its work.
 


```python

```
