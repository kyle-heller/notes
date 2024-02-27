# Revision notes for incorrectly answered questions
The following are notes from questions which I got wrong in PCAP prep

## Python packages
The following are true with regard to Python packages:
- The shebang statement (`#!`) which appears at the top of files is a Unix command for how the file should be handled and has no effect on MS Windows.
- If you want to use a packages in a non-standard directory you should append the directory's path to the path variable using the `sys` module.
- Packages *should* have an `__init__.py`, however, they __will__ work without one.
- During the first import of a module Python translates its source code into a *__semi__-compiled* format stored in the `.pyc` files and deploys these files to the `__pycache__` directory located in the module's home directory.

## Exception handling
Look at the following code:


```python
class Err(Exception):
    def __init__(self, msg):
        self.message = msg
        
    def __str__(self):
        return "From Err block"
    
try:
    print("Start")
    raise Exception ("Error raised")
except Err as e:
    print(e)
else:
    print("From else block")
```

    Start



    ---------------------------------------------------------------------------

    Exception                                 Traceback (most recent call last)

    <ipython-input-18-29c58853756f> in <module>
          8 try:
          9     print("Start")
    ---> 10     raise Exception ("Error raised")
         11 except Err as e:
         12     print(e)


    Exception: Error raised


It will print `Start` and then raise an *unhandled* exception because:
- the `except` branch is only handling `Err` class exceptions whereas the exception we raised is `Exception` class.

If we revised line 10 to `raise Err("Error raised")` we would now handle the exception, however, the message printed would be `From Err block` as that is explicitly defined as the `__str__` method of the `Err` class. If we deleted the `__str__` method from the `Err` class, *then* we would get `Error raised` as the output.


```python
class Err(Exception):
    def __init__(self, msg):
        self.message = msg
        
#     def __str__(self):
#         return "From Err block"
    
try:
    print("Start")
    raise Err ("Error raised")
except Err as e:
    print(e)
else:
    print("From else block")
```

    Start
    Error raised


## `assert "zero"`
Look at the following code:


```python
try:
    assert "zero"
except:
    print("one", end=" ")
else:
    print("two", end=" ")
finally:
    print("three")
```

    two three


It will print:
<br>`two three`

Because:
- `assert` only raises an error if the value being checked is `False` (i.e. empty strings, empty lists, False, 0 etc).
- a non-empty string evaluates as `True`, as such no assertion error is raised and the executing is `try`>`else`>`finally`.

## `int` divided by `int` equals `float`
Look at the following code:


```python
string_convert = str(16**1/2)

new_string = ""

for ch in string_convert:
    new_string += ch
    
print(new_string[-1])
```

    0


It will ouput `0` because:
- Brackets have priority so the maths calculation is done first, then __PEMDAS__ has exponentiation executed first so:
    - 16**1 = 16
    - 16 / 2 = 8<b>.0</b> (remember integer divided by integer is always a float)
- The `for` loop adds `8.0` to the `new_string` string
- Index `-1` prints the final character of the string which is `0`

## An object instance changing a class variable
Look at the following code:


```python
class MyClass:
    c_var = 0
    
    def __init__(self):
        self.value = 0
        
obj_a = MyClass()
obj_a.c_var = 5
obj_b = MyClass()
print(obj_a.c_var, obj_b.c_var)
```

    5 0


It will output `5 0` because:
- `c_var` is a class variable (aka a static variable) which can be accessed using `MyClass.c_var`. 
- `obj_a` and `obj_b` are both instances of `MyClass` and thus can __read__ the `c_var` variable
- Python will first look within the object(s) for a particular var and if it's not present will then look in class from which the objects are derived. However, the class variable can only be __read__ via the object instances not changed.
- Since the object instances cannot write to the class variable Python will instead create a new local variable within the object. So `obj_a.c_var` no longer points to the class variable `c_var` but a new *local* var of the same name within the `obj_a` instance. Thus printing `obj_a.c_var` will print the local var value of `5`
- In the meantime, `obj_b` hasn't tried to write to `c_var` so it will still point to the original class var which is still `0`

## The `__name__` class property
Look at the following code:


```python
class NewClass:
    pass

obj = NewClass()

print(NewClass.__name__)
print(type(obj).__name__)
```

    NewClass
    NewClass


Both `print`s will output the class name `NewClass`.
- The `__name__` property is a built in __class__ property
- In order to print the class name using an object instance we need to use the `type()` function which will return the class name and thus the second print is essentially access the same `NewClass.__name__` property.
- If we were to try printing `obj.__name__` directly, Python would raise an `AttributeError` as objects do not have a `__name__` property.

## The `__module__` property
Look at the following code:


```python
# inside my_module.py

class AnotherClass:
    pass

print(AnotherClass.__module__)
```

    __main__


It will output `__main__` because:
- We can see that no `import` statements are present which means the `AnotherClass` class was defined in the currently running script (`my_module.py`).
- Since we're currently running `my_module.py`, the `__module__` property will return `__main__` (this is the name Python gives to the currently running document.
- If we were running a different file and had imported `AnotherClass` from `my_module.py` *then* the output would be `my_module.py`

## Class variable inheritance
Look at the following code:


```python
class One:
    pass

class Two(One):
    var = 1
    
class Three(One):
    var = 2
    
class Four(Two, Three):
    pass

four_obj = Four()

print(four_obj.var)
```

    1


The code is __valid__ and will output `1`.
- This is a demonstration of the *diamond problem* of multiple inheritance. 
- Since classes `Two` and `Three` are both subclasses of `One` there is no __method resolution order__ (MRO) conflict and `Four` will inherit first from the left-most parent which is `Two`
- If `Three` had been a subclass of `Two` instead *then* we would have triggered a `TypeError` due to an MRO conflict.

## File handling
- The `open()` method returns an iterable object and this can be used to iterate through the data in the file
- The `readlines()` method returns an *empty* __list__ if the stream opened is an empty file
- `rb` is the `read, binary` mode
- `readinto()` is the method used to read from a binary file. It returns the number of successfully read bytes. The method will try to fill all available space in its argument. If there are more data than available space the operation will stop before the the end of the file.

## The `dir()` function
The `dir()` function will return an alphabetically sorted list of all entities within the given module. However, this will only work if the module *as a whole* has been imported first.


```python
# WILL WORK
import os # import the os module

print(dir(os)) # use the dir() function to get a list of entities within os

# ------------------------------------

# WILL NOT WORK, (NameError raised)
from math import sqrt

print(dir(math))
```

    ['CLD_CONTINUED', 'CLD_DUMPED', 'CLD_EXITED', 'CLD_KILLED', 'CLD_STOPPED', 'CLD_TRAPPED', 'DirEntry', 'EX_CANTCREAT', 'EX_CONFIG', 'EX_DATAERR', 'EX_IOERR', 'EX_NOHOST', 'EX_NOINPUT', 'EX_NOPERM', 'EX_NOUSER', 'EX_OK', 'EX_OSERR', 'EX_OSFILE', 'EX_PROTOCOL', 'EX_SOFTWARE', 'EX_TEMPFAIL', 'EX_UNAVAILABLE', 'EX_USAGE', 'F_LOCK', 'F_OK', 'F_TEST', 'F_TLOCK', 'F_ULOCK', 'GRND_NONBLOCK', 'GRND_RANDOM', 'GenericAlias', 'MFD_ALLOW_SEALING', 'MFD_CLOEXEC', 'MFD_HUGETLB', 'MFD_HUGE_16GB', 'MFD_HUGE_16MB', 'MFD_HUGE_1GB', 'MFD_HUGE_1MB', 'MFD_HUGE_256MB', 'MFD_HUGE_2GB', 'MFD_HUGE_2MB', 'MFD_HUGE_32MB', 'MFD_HUGE_512KB', 'MFD_HUGE_512MB', 'MFD_HUGE_64KB', 'MFD_HUGE_8MB', 'MFD_HUGE_MASK', 'MFD_HUGE_SHIFT', 'Mapping', 'MutableMapping', 'NGROUPS_MAX', 'O_ACCMODE', 'O_APPEND', 'O_ASYNC', 'O_CLOEXEC', 'O_CREAT', 'O_DIRECT', 'O_DIRECTORY', 'O_DSYNC', 'O_EXCL', 'O_LARGEFILE', 'O_NDELAY', 'O_NOATIME', 'O_NOCTTY', 'O_NOFOLLOW', 'O_NONBLOCK', 'O_PATH', 'O_RDONLY', 'O_RDWR', 'O_RSYNC', 'O_SYNC', 'O_TMPFILE', 'O_TRUNC', 'O_WRONLY', 'POSIX_FADV_DONTNEED', 'POSIX_FADV_NOREUSE', 'POSIX_FADV_NORMAL', 'POSIX_FADV_RANDOM', 'POSIX_FADV_SEQUENTIAL', 'POSIX_FADV_WILLNEED', 'POSIX_SPAWN_CLOSE', 'POSIX_SPAWN_DUP2', 'POSIX_SPAWN_OPEN', 'PRIO_PGRP', 'PRIO_PROCESS', 'PRIO_USER', 'P_ALL', 'P_NOWAIT', 'P_NOWAITO', 'P_PGID', 'P_PID', 'P_PIDFD', 'P_WAIT', 'PathLike', 'RTLD_DEEPBIND', 'RTLD_GLOBAL', 'RTLD_LAZY', 'RTLD_LOCAL', 'RTLD_NODELETE', 'RTLD_NOLOAD', 'RTLD_NOW', 'RWF_DSYNC', 'RWF_HIPRI', 'RWF_NOWAIT', 'RWF_SYNC', 'R_OK', 'SCHED_BATCH', 'SCHED_FIFO', 'SCHED_IDLE', 'SCHED_OTHER', 'SCHED_RESET_ON_FORK', 'SCHED_RR', 'SEEK_CUR', 'SEEK_DATA', 'SEEK_END', 'SEEK_HOLE', 'SEEK_SET', 'ST_APPEND', 'ST_MANDLOCK', 'ST_NOATIME', 'ST_NODEV', 'ST_NODIRATIME', 'ST_NOEXEC', 'ST_NOSUID', 'ST_RDONLY', 'ST_RELATIME', 'ST_SYNCHRONOUS', 'ST_WRITE', 'TMP_MAX', 'WCONTINUED', 'WCOREDUMP', 'WEXITED', 'WEXITSTATUS', 'WIFCONTINUED', 'WIFEXITED', 'WIFSIGNALED', 'WIFSTOPPED', 'WNOHANG', 'WNOWAIT', 'WSTOPPED', 'WSTOPSIG', 'WTERMSIG', 'WUNTRACED', 'W_OK', 'XATTR_CREATE', 'XATTR_REPLACE', 'XATTR_SIZE_MAX', 'X_OK', '_Environ', '__all__', '__builtins__', '__cached__', '__doc__', '__file__', '__loader__', '__name__', '__package__', '__spec__', '_check_methods', '_execvpe', '_exists', '_exit', '_fspath', '_fwalk', '_get_exports_list', '_spawnvef', '_walk', '_wrap_close', 'abc', 'abort', 'access', 'altsep', 'chdir', 'chmod', 'chown', 'chroot', 'close', 'closerange', 'confstr', 'confstr_names', 'copy_file_range', 'cpu_count', 'ctermid', 'curdir', 'defpath', 'device_encoding', 'devnull', 'dup', 'dup2', 'environ', 'environb', 'error', 'execl', 'execle', 'execlp', 'execlpe', 'execv', 'execve', 'execvp', 'execvpe', 'extsep', 'fchdir', 'fchmod', 'fchown', 'fdatasync', 'fdopen', 'fork', 'forkpty', 'fpathconf', 'fsdecode', 'fsencode', 'fspath', 'fstat', 'fstatvfs', 'fsync', 'ftruncate', 'fwalk', 'get_blocking', 'get_exec_path', 'get_inheritable', 'get_terminal_size', 'getcwd', 'getcwdb', 'getegid', 'getenv', 'getenvb', 'geteuid', 'getgid', 'getgrouplist', 'getgroups', 'getloadavg', 'getlogin', 'getpgid', 'getpgrp', 'getpid', 'getppid', 'getpriority', 'getrandom', 'getresgid', 'getresuid', 'getsid', 'getuid', 'getxattr', 'initgroups', 'isatty', 'kill', 'killpg', 'lchown', 'linesep', 'link', 'listdir', 'listxattr', 'lockf', 'lseek', 'lstat', 'major', 'makedev', 'makedirs', 'memfd_create', 'minor', 'mkdir', 'mkfifo', 'mknod', 'name', 'nice', 'open', 'openpty', 'pardir', 'path', 'pathconf', 'pathconf_names', 'pathsep', 'pidfd_open', 'pipe', 'pipe2', 'popen', 'posix_fadvise', 'posix_fallocate', 'posix_spawn', 'posix_spawnp', 'pread', 'preadv', 'putenv', 'pwrite', 'pwritev', 'read', 'readlink', 'readv', 'register_at_fork', 'remove', 'removedirs', 'removexattr', 'rename', 'renames', 'replace', 'rmdir', 'scandir', 'sched_get_priority_max', 'sched_get_priority_min', 'sched_getaffinity', 'sched_getparam', 'sched_getscheduler', 'sched_param', 'sched_rr_get_interval', 'sched_setaffinity', 'sched_setparam', 'sched_setscheduler', 'sched_yield', 'sendfile', 'sep', 'set_blocking', 'set_inheritable', 'setegid', 'seteuid', 'setgid', 'setgroups', 'setpgid', 'setpgrp', 'setpriority', 'setregid', 'setresgid', 'setresuid', 'setreuid', 'setsid', 'setuid', 'setxattr', 'spawnl', 'spawnle', 'spawnlp', 'spawnlpe', 'spawnv', 'spawnve', 'spawnvp', 'spawnvpe', 'st', 'stat', 'stat_result', 'statvfs', 'statvfs_result', 'strerror', 'supports_bytes_environ', 'supports_dir_fd', 'supports_effective_ids', 'supports_fd', 'supports_follow_symlinks', 'symlink', 'sync', 'sys', 'sysconf', 'sysconf_names', 'system', 'tcgetpgrp', 'tcsetpgrp', 'terminal_size', 'times', 'times_result', 'truncate', 'ttyname', 'umask', 'uname', 'uname_result', 'unlink', 'unsetenv', 'urandom', 'utime', 'wait', 'wait3', 'wait4', 'waitid', 'waitid_result', 'waitpid', 'waitstatus_to_exitcode', 'walk', 'write', 'writev']



    ---------------------------------------------------------------------------

    NameError                                 Traceback (most recent call last)

    <ipython-input-38-33634c170447> in <module>
          9 from math import sqrt
         10 
    ---> 11 print(dir(math))
    

    NameError: name 'math' is not defined


## AssertionError message
In order for an `AssertionError` to provide a message, the message should usually be declared after the assert statement like so:
<br>`assert x, "x is false"`


```python
def assert_me(me):
    assert me, "me is false"

try:
    assert_me(0)
except AssertionError as e:
    print(e)
```

    me is false


## How Python handles very large numbers
Python will represent sufficiently large numbers using scientific notation e.g. `1E250`. Beyond such numbers, Python will consider the number to be infinite and so represent it with the word `inf`. If you attempt to perform operations on such numbers which exceed Python's capacity, an `OverflowError` will be raised.


```python
m1 = 1e250
m2 = 1e189
print(m1*m2) # inf
print(m1**2) # overflow
```

    inf



    ---------------------------------------------------------------------------

    OverflowError                             Traceback (most recent call last)

    <ipython-input-62-33d1824e7c82> in <module>
          2 m2 = 1e189
          3 print(m1*m2) # inf
    ----> 4 print(m1**2) # overflow
    

    OverflowError: (34, 'Numerical result out of range')


### UTF-8 and UCS-4
- `UTF-8` stands for *Unicode Transformation Format - 8bit* and uses variable bytes (one to four) for characters.
- `UCS-4` stands for *Universal Character Set - 4bytes* and uses 4 bytes per character.
- a code point is a number representing a character. e.g. the UTF-8 code point for `!` is `21`
- `UTF-8` is fully backwards compatible with `ASCII` as both use 1-byte to represent the first 255 (ASCII only uses 127 of those, i.e. it provides space for 255 chars but only uses 127)

## Python classes and emptiness
Python classes can have empty properties and empty methods. The only mandatory requirement is a unique name.


```python
class ANewClass:
    pass
```

## Python classes and local vars
Python classes can contain several different types of variables.
- __class variables__: aka *static variables* declared before the constructor and shared by all instances created from said class
- __instance variables__: declared within the constructor or at any time in the life of an instance
- __local variables__: the arguments provided to any methods


```python
class VarClass:
    class_var = 0 # Class/static variable
    
    def __init__(self):
        instance_var = 1 # instance variable
        
    def local_setter(local_var): # the local_var passed here is a local variable
        self.local_var = local_var # despite the name this is an instance var that's been set to the value of the local var passed to it
```

## The `hasattr()`  function
The `hasattr` function takes an object/class and string and returns `True` if the object/class contains an attribute with the string as its name.


```python
class AttrClass:
    class_var = 0
    
    def __init__(self):
        self.instance_var = 2
        
obj = AttrClass()

print(hasattr(obj, "instance_var")) # object has instance_var
print(hasattr(AttrClass, "instance_var")) # class does not have instance var
print(hasattr(AttrClass, "class_var")) # class has class var
print(hasattr(AttrClass(), "instance_var")) # () means this is an instance and not the class
```

    True
    False
    True
    True


## The `weekheader` function
Contrary to the info in the official PCAP course, the `weekheader` does not always return the 3-digit version of the weekday names regardless of the number passed to it. If you pass the numbers 1 to 8 it will return the 3 digit version but 9 or above will return the full weekday names.


```python
import calendar

print(calendar.weekheader(4))
print(calendar.weekheader(7))
print(calendar.weekheader(9))
print(calendar.weekheader(18))
```

    Mon  Tue  Wed  Thu  Fri  Sat  Sun 
      Mon     Tue     Wed     Thu     Fri     Sat     Sun  
      Monday   Tuesday  Wednesday  Thursday   Friday   Saturday   Sunday 
          Monday            Tuesday           Wednesday           Thursday            Friday            Saturday            Sunday      


## `random()`
- `random.random()` is always < 1

## `e`, `log()`, and `exp()` from `math` module
- `e` is *Euler's number* which is a mathematical constant approx. equal to `2.71828`. It is the base of the "natural logarithm".
- `log()` is the log function which takes 2 parameters, the first is the number you want to log, the second is the base. The default base is `e`.
- `exp()` is the exponentiation function. __NOTE__: anything to the power of `0` is always `1`

## Things to remember about global vars
1. If you use the same name for a global var and a function definition's paramater, you cannot then use the `global` keyword to access the global var within the function. Doing so will raise a `SyntaxError`.
2. When using the `global` keyword to access a global var within a function, you cannot then ruse the same name to define a local variable. Doing so will simply overwrite the global var.


```python
# Example 1
y = 7

def my_func(x,y):
    global y
    
```


      File "<ipython-input-111-8a3038734832>", line 5
        global y
        ^
    SyntaxError: name 'y' is parameter and global




```python
# Example 2
j = 7

def my_function(q,r):
    global j
    j = 8
    print(j)
    
my_function(3,2)
print(j)
```

    8
    8


## lambda function `SyntaxErrors`
Both of the following will raise a `SyntaxError`:
- `lambda`s cannot use the `return` keyword
- `lambda`s cannot take tuples as a parameters


```python
lambda x: return x
```


      File "<ipython-input-114-ea7030706cc2>", line 1
        lambda x: return x
                  ^
    SyntaxError: invalid syntax




```python
lambda (x,y): x+y
```


      File "<ipython-input-115-f79544defa75>", line 1
        lambda (x,y): x+y
               ^
    SyntaxError: invalid syntax



## Exceptions and Assertions
- The order of exception branches is important as the first match is always executed. Thus it is better to place more concrete exceptions above more abstract/general ones.
- Assertions don't supersede exceptions or validate the data - they are supplements.
- Assertions evaluate a condition/expression and only raise an `AssertionError` exception when it is False, None, or 0

## `.split()`
This method will split a string at spaces (default) or a given character and return a list. If there are no occurences of the given character within the string a list will still be returned but it will have only one item (the full string).


```python
my_string = "abce efgh ijklmn"
new_string = my_string.split(",")
print(new_string)
print(len(new_string))
```

    ['abce efgh ijklmn']
    1


## `ord` and `len`
- `ord("z")-ord("Y") == 33` as upper and lowercase unicode points are 32 code points apart.
- `len("""""")==0` as an empty multiline string is 0 in length
- `len("\n")==1` as the newline character has a length of 1

## `sort()`
The `sort` function sorts the list in place (`sorted` returns a copy of the list which has been sorted). `sort` takes two optional parameters:
1. a function which is used to sort the list
2. a bool `reverse=True/False` which reverses the sorted list


```python
name_list = ["Neal","Dexter","Harvey"]
name_list.sort(key=lambda x: (x[-1], x[-2]), reverse=True)

print(name_list)
```

    ['Harvey', 'Dexter', 'Neal']


## Polymorphism and class constructors
- __polymorphism___ is the ability of a subclass to modify its superclass' behaviour
- a __constructor__ is used to instantiate objects

## `super().__init__()`
When invoking a superclass' constructor from within a subclass using `super().__init__()` you do not need to pass the `self` parameter. In all other cases you do.
- `super().__init__()` is valid
- `super().__init__(self)` is NOT valid
- `Class.__init__(self)` is valid
- `Class.__init__()` is NOT valid

## Bitwise operators

Operator|Description|Syntax
:--|:--|:--
`&`|Bitwise __AND__|`x & y`
`\|`|Bitwise __OR__|`x \| y`
`~`|Bitwise __NOT__|`~x`
`^`|Bitwise __XOR__|`x ^ y`
`>>`|Bitwise __right shift__|`x>>`
`<<`|Bitwise __left shift__|`x<<`


__&__: returns `1` if *both* bits are `1`, else `0`


```python
a = 1
b = 0
c = 1
d = 1
b1 = 1010
b2 = 0b100 # use 0b if starting a binary number with 0

print(a & b)
print(c & d)
print(b1 & b2)
```

    0
    1
    0


__|__: returns `1` if *either* of the bits is `1`, else `0`


```python
e = 0

print(a | b)
print(b | e)
print(110 | 101)
```

    1
    0
    111


__~__: changes each bit to it's opposite

__NOTE__: all integers in Python are implicitly signed i.e. `11` is actually `+11` even though you don't see the `+`. This means when using the __~__ (bitwise NOT) the sign will be reversed also.


```python
print(~b2)
```

    -5


__^__: returns `1` if *one* of the bits is `1` and the other is `0`, else `0`.


```python
print(c ^ d)
print(a ^ b)
```

    0
    1


__>>__: shifts the bits of first operand to the left by the number of the second operand.
    <br>e.g. `1011>>2=101100`

## `round()`
When dealing with `x.5` numbers, `round` will round __down__ if the `x` number is even and __up__ if it's odd.


```python
print(round(2.5))
print(round(3.5))
```

    2
    4


## `try` without `except`
`try` can be used without an `except` block if a `finally` block is present. Otherwise a `SyntaxError` will be raised.


```python
try:
    print("foo")
finally:
    print("bar")
```

    foo
    bar


## `**` right-side execution
In Python, the exponentiation operator (`**`) has a right-sided binding meaning that if you chain them the result will be calculated from right to left.

So, `2**3**4` is calculated as `2**(3**4)` i.e. `2**81`

## `_` can be used in place of a comma
So, `1_000` is a valid integer.


```python
print(1_000+50)
```

    1050


## class inheritance and vairable priorities
- When Python looks for a variable within an object/class *local* variables take precedence when there are multiple variables with the same name.
- If a constructor has __NOT__ been declared in a subclass, the subclass will automatically inherit the constructor of its superclass.


```python
class A:
    def __init__(self):
        self.var = 1
        
class B(A):
    var = 3

class C(A):
    var = 5

class D(B,C):
    pass

obj = D()
print(obj.var)
```

    1


## `Math.ceil()` & `Meth.floor()` and negative numbers
The `Math.ceil()` function rounds the given number __up__ to the next integer. Bear in mind that this means for negative numbers the number will round closer to zero on a number line (as opposed to further from 0 with positive numbers). 

For example `Math.ceil(9.3)` will round up to `10` (further from 0 on a number line) and `Math.ceil(-3.8)` will round up to `-3` (closer to 0 on a number line).

Conversely, `Math.floor()` rounds __down__ to the next integer. So for a positive number it will bring the number *closer* to `0` on a number line but for negative numbers it will push the integer further away from `0`. For example `Math.floor(6.4)` will round down to `6` but `Math.floor(-6.4)` will round down to `-7`.


```python
import math as m

print(m.ceil(9.3))
print(m.ceil(-3.8))
print(m.floor(6.4))
print(m.floor(-6.4))
```

    10
    -3
    6
    -7


## Factorial refresher
The factorial of a *number* is the product of all whole numbers from said *number* down to one. The factorial symbol is a number followed by an exclamation: `n!`.

Number|Factorial description|Factorial
:--|:--|:--
`2!`|`2x1`|`2`
`3!`|`3x2x1`|`6`
`8!`|`8x7x6x5x4x3x2x1`|`40320`

The `Math.factorial()` function can be used to calculate this.


```python
print(m.factorial(8))
print(8*7*6*5*4*3*2*1)
```

    40320
    40320


## `isinstance()` includes inheritance
The `isinstance` function doesn't *only* check if an object was instantiated by a given class, it will also return `True` if the object was instantiated by a subclass of the given class.


```python
class A:
    pass

class B(A):
    pass

class C(B):
    pass

obj = C()
print(isinstance(obj, A))
```

    True


## `write` mode will overwrite file content upon opening
Any of the `write` modes (`w`, `w+`) will immediately overwrite an existing file's content. Meaning that as soon as you call the `open()` function with one of the write modes, if the file exists any content is erased regardless of whether or not you call the `.write()` method.


```python
file = open("existing.txt", "w") # any existing content in the file is now gone
file.close()
```

## `ASCII` is a subset of `UTF-8`
While ostensibly a *standard* and an *encoding* respectively, these days `ASCII` is considered a subset of `UTF-8`.

## String comparison and code points
Numbers have lower code points (smaller numbers) than letters, and capital letters have lower code points than lowercase letters.

In other words `ord("1")`<`ord("A")`<`ord("a")`.


```python
print(ord("1"))
print(ord("A"))
print(ord("a"))
print(ord("1")<ord("A")<ord("a"))
```

    49
    65
    97
    True


## When slicing, the second index is always exclusive
Regardless of whether using negative indexing or otherwise, the second index of a slice is __always exclusive__ of the number at that index.


```python
a = "abcdefg"
# indices for above are "0123456" 
print(a[0:4])
print(a[-4:-1])
```

    abcd
    def


## The `__dict__` attribute only includes attributes *FOR* object
When accessing the `__dict__` attribute of an object, bear in mind that the dictionary will include only attributes specifically for that object (i.e. it will NOT include class variables).


```python
class NewClass:
    c_var = 1
    def __init__(self):
        self.i_var = 2
    
new_obj = NewClass()

print(new_obj.__dict__)
```

    {'i_var': 2}


## Using `try`/`except` within a `for` loop
You can use a `try`/`except` within a `for` loop.


```python
for i in range(4):
    try:
        print("Plop! "*i)
    except Exception as e:
        print(e)
```

    
    Plop! 
    Plop! Plop! 
    Plop! Plop! Plop! 


## Be mindful of Invoking a superclass' constructor *after* instantiating vars
If invoking a superclass' init method directly within a subclass, it's advisable to do so before setting any variables as if any of the variables have the same name as vars within the superclass' constructor they will be overwritten with the values provided by said constructor.


```python
class SuperClass:
    def __init__(self):
        self.var_1 = 1
        self.var_2 = 2
        
class SubClass(SuperClass):
    def __init__(self):
        self.var_1 = 3
        self.var_2 = 4
        super().__init__()

        
sub_obj = SubClass()

print(sub_obj.var_1, sub_obj.var_2)
```

    1 2


## A reverse slice using only negative indices without a reverse step
As we know, using negative indices for a slice is valid. However, be aware that if you try to slice in reverse (i.e. with a larger negative index as the start and smaller negative as the end) you also need to use a negative step. Otherwise you will get an empty string.


```python
a = "abcdefg"
b = a[-1:-4] # no step
print("My reversed string:", b)
c = a[-1:-4:-1] # negative 1 step (i.e. going backward 1 step digit at a time)
print("My ACTUAL reversed string:", c)
```

    My reversed string: 
    My ACTUAL reversed string: gfe


## Defining a class method without the `self` parameter
If you define a class method without passing the `self` parameter the method can only successfully invoked directly by the class e.g. `Class.method()`.


```python
class MyClass:
    def my_func():
        print("Wahoo!")
        
my_obj = MyClass()
MyClass.my_func() # invoking the function with the class (will work)
try:
    my_obj.my_func() # invoking the function from an object (won't work)
except TypeError as e:
    print(e)
```

    Wahoo!
    my_func() takes 0 positional arguments but 1 was given


## The `random` function, if seeded with same value on same machine, will return same values
Although the `random()` function from the `random` module is *pseudo*-random, if you seed it with the same value on the same machine you will get the same values.


```python
import random as r

r.seed(0)

for i in range(3):
    print(r.random())
```

    0.8444218515250481
    0.7579544029403025
    0.420571580830845



```python
r.seed(0)

for i in range(3):
    print(r.random())
```

    0.8444218515250481
    0.7579544029403025
    0.420571580830845


## The `__name__` variable gets its value depending on how it is executed
If we have a two files as follows:
- `subfile.py` containing `print(__name__)`
- `mainfile.py` containing `import subfile`

And we run `mainfile.py`, the result printed to the console will be `subfile` even though the output was trigger by the currently running file (imports implicitly execute) since the invokation of the print function is within subfile, that's where the `__name__` variable is pulled from. If we had run `subfile` directly, the output would've been `__main__`.

## Inheritance succession
When creating a subclass which inherits from two or more class which are themselves related through inheritance, you need to make sure the higher class up the chain is passed *after* the closer class. Otherwise a __method resolution order__ will be unclear and a `TypeError` raised.

One way to look at it is like the floors of a building. The 1st floor is built upon the ground floor, the second floor upon the first. If you're taking an elevator from the second floor, you need to pass the first floor before you can reach the ground floor.


```python
class GroundFloor:
    pass

class FirstFloor(GroundFloor):
    pass

class SecondFloor(FirstFloor, GroundFloor):
    pass

class ThirdFloor(SecondFloor, FirstFloor):
    pass
```

The elevator analogy gets a little murky when we start mixing around the multiple inheritance and skipping levels.

Let's try a geekier analogy. Look at the below list of *Star Trek* characters. Each character has a line of succession with their immediate superior being listed first in parentheses. If we try to change it so that, for example, Lt Cmdr Data reports to Cpt Picard *before* Cmdr Riker we'll get an error. However, we could have Data report to Cpt Sisko first since he's not a member of Sisko's crew and thus doesn't have a direct superior before Sisko.


```python
class AdmiralNachayev: # Most senior
    pass

class CaptainPicard(AdmiralNachayev): # 2nd most senior, directly below Adml Nachayev
    pass

class CommanderRiker(CaptainPicard): # 3rd most senior, directly below Cpt Picard
    pass

class LtCommanderData(CommanderRiker, CaptainPicard): # 4th most senior, directly below Cmdr Riker
    pass

class CaptainSisko(AdmiralNachayev): # 2nd most senior, directly below Adml Nachayev
    pass

class CommanderWorf(CaptainSisko): # 3rd most senior, directly below Cpt Sisko
    pass

class ChiefOBrien(CommanderWorf, CaptainSisko): # 4th most senior, directly below Cmdr Worf
    pass

class LieutenantDax(CommanderWorf, CaptainSisko): # 4th most senior, directly below Cmdr Worf
    pass

class EnsignNog(ChiefOBrien, LieutenantDax, CommanderWorf): # Most junior, directly below Chief O'Brien/Lt Dax
    pass
```

## The `.read()` method
When working with files, the `read()` method reads the file byte-by-byte.


```python
file = open("text.txt")
for i in file.read():
    print(i, end="| ")
file.close()
```

    H| e| l| l| o|  | t| h| e| r| e| 
    | a| b| c| 
    | d| e| f| 
    | g| h| i| 
    | 

## The `readline()` method
The `readline()` method will try to read a single line. Passing an integer to this method will terminate the read at the character of that index.


```python
file = open("text.txt")
for i in file.readline():
    print(i, end="| ")
file.close()
```

    H| e| l| l| o|  | t| h| e| r| e| 
    | 

## The `readlines()` method
The `readlines()` method will try to read the entire file one line at a time.


```python
file = open("text.txt")
for i in file.readlines():
    print(i, end="| ")
file.close()
```

    Hello there
    | abc
    | def
    | ghi
    | 

## `__init__` method is discoverable within objects when using `hasattr()`
When using the `hasattr()` function, the `__init__` method will return `True` for both classes and objects.


```python
class A:
    def __init__(self):
        pass

obj_1 = A()

print(hasattr(A, "__init__"))
print(hasattr(obj_1, "__init__"))
```

    True
    True


## Object returned by `open()` is a generator that reads line-by-line
The object returned by the `open()` function is an iterable/generator that reads the file __line-by-line__.


```python
file = open("text.txt")
for i in file:
    print(i)
file.close()

file = open("text.txt")
a = [i for i in file]
print(a)
file.close()
```

    Hello there
    
    abc
    
    def
    
    ghi
    
    ['Hello there\n', 'abc\n', 'def\n', 'ghi\n']


## `__bases__` attribute is a tuple containing direct superclasses
The `__bases__` attribute is a tuple containing the direct superclasses of the it's class. If the class has no superclass it will be a tuple containing Python's class object.


```python
class J:
    pass

class K(J):
    pass

class R(K,J):
    pass

print(J.__bases__)
print(K.__bases__)
print(R.__bases__)
```

    (<class 'object'>,)
    (<class '__main__.J'>,)
    (<class '__main__.K'>, <class '__main__.J'>)


## The variable in a for loop can be reassigned
When creating a `for` loop we normally have a variable `i` which holds the value of the current iteration, however, that variable can be reassigned within the loop even.


```python
text = "abcdefg"

for i in text:
    i = "x"

print(text)
```

    abcdefg


## The `index()` function raises an exception upon failure
Unlike the `find()` function which will return `-1` if it cannot find the given substring, the `index()` function will raise a `ValueError` exception if the substring isn't present.


```python
sport = "baskeball"

try:
    sport.index("football")
except ValueError as e:
    print(f"I told you it would raise an exception:",e)
```

    I told you it would raise an exception: substring not found



```python

```
