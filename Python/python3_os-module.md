# The `os` module
Python's os module allows you to interact with the operating system. It provides functions that work with Unix and Windows systems. Some of the operations it enables:
- get info about the operating system
- manage processes
- operate on I/O streams using file descriptors

## Getting info about the OS
Python can easily get info about the operating system using a function called `uname` which returns an object with the following attributes:
- `sysname` - stores the name of the os
- `nodename` - stores the machine name on the network
- `release` - stores the operating system release
- `version` - stores the operating system version
- `machine` - stores the hardware identified

__NOTE__: if you're using a windows system you would use the uname function from the `platform` module rather than the `os` module.


```python
import os
os_info = os.uname()

print(f"Your operating system is {os_info.nodename} ({os_info.sysname}).")
```

    Your operating system is manjaro (Linux).


You can quickly distinguish between operating systems using the `name` attribute which shows the following:
- __posix__ for a Unix os.
- __nt__ for Windows.
- __java__ if your code is written in Jython.


```python
import os

print(os.name)
```

    posix


## Creating directories with Python
The os module provides a function called `mkdir` which, as with the `mkdir` command on Unix & Windows, allows you to create a directory. It requires a path that can be relative or absolute. If a directory by that name already exists a `FileExistsError` will be raised.

Functions used in the below example are:
- `mkdir()`: used to create a directory
- `listdir()`: used to list the contents of the current directory


```python
import os

os.mkdir("TEST_DIRECTORY")
for i in os.listdir(): # get a list of the contents of the current directory
    if i == "TEST_DIRECTORY": # a for loop to format it so we can see the directory we just created, if it's there
        print(f"\n\n***{i}****\n")
    else:
        print(i,end=", ")
```

    python3_working-with-files_part-2.ipynb, python3_pythons-objective-exceptions.ipynb, .screenlayout, .zshrc, python3_instance-variables.ipynb, python3_inheritance.ipynb, riker.txt, Templates, python3-modules.ipynb, Downloads, python3_creating-a-hierarchy-of-classes.ipynb, .bashrc, go, .npm, python3_strings-continued.ipynb, python3_closures.ipynb, .zhistory, .ipython, .gtkrc-2.0, Desktop, python3_working-with-files_part-1.ipynb, file.bin, slimblade.sh, python3_character-encoding.ipynb, .Xclients, .ipynb_checkpoints, .xinitrc, 
    
    ***TEST_DIRECTORY****
    
    .urxvt, python3_procedural-vs-objective-stack.ipynb, python3_generators.ipynb, temp, Documents, .nv, text.txt, .pki, .gitkraken, python3_working-with-files_part-3.ipynb, .bash_logout, .cache, Untitled.ipynb, Untitled2.ipynb, .config, .gitconfig, Videos, python3_os-module.ipynb, .nvidia-settings-rc, .mozilla, Public, .jupyter, newfile.txt, Untitled3.ipynb, .dir_colors, python3_classes-and-objects-extra.ipynb, python3_lambda-functions.ipynb, python3_multi-inheritance-and-method-resolution-order.ipynb, Pictures, .var, python3_exceptions.ipynb, .gnupg, python3_oop_class-hierarchies-and-object-instantiation.ipynb, .i3, .dmenurc, Untitled1.ipynb, python3_list-comprehensions.ipynb, .zcompdump, newtext.txt, .local, new_riker.txt, python3_class-variables.ipynb, Music, .bash_profile, .idlerc, file.txt, Untitled4.ipynb, .ssh, 

### Recursive directory creation
The mkdir function can be used to create a single directory at once but what if you know you want to create multiple nested directories? For that, we have the `makedirs` function which will create all directories in the path provided.

Functions used in the following example:
- `makedirs()`: used to create multiple, nested directories
- `chdir()`: change into the specified directory
- `getcwd()`: used to get the current working directory (equivalent to the unix `pwd` print working directory)


```python
import os

os.makedirs("TEST_LEVEL3/TEST_LEVEL2/TEST_LEVEL1") # create 3 directories Lvl3>Lvl2>Lvl1
os.chdir("TEST_LEVEL3/TEST_LEVEL2/TEST_LEVEL1") # change into the innermost directory (Lvl1)
print(os.getcwd()) # print the current working directory showing all 3 levels
os.chdir("../../..")
```

    /home/neal-i3/TEST_LEVEL3/TEST_LEVEL2/TEST_LEVEL1
    /home/neal-i3/TEST_LEVEL3


## Removing directories
The os module includes a couple of functions for deleting direcories:
- `rmdir()`: will delete a single, empty directory
- `removedirs()` will delete a series of empty, nested directories

If any of the directories passed to either function is empty (or doesn't exist) an exception will be raised.


```python
import os

os.makedirs("ANOTHER_TEST/AT_LVL2")
os.chdir("ANOTHER_TEST/AT_LVL2")
print(os.getcwd())
os.chdir("../../")
os.removedirs("ANOTHER_TEST/AT_LVL2")
print(os.listdir())
```

    /home/neal-i3/TEST_LEVEL3/ANOTHER_TEST/AT_LVL2


## The `system()` function
The `system()` function allows you to run normal system commands through Python. For example, rather than using `os.mkdir("test_directory")` you could use `os.system("mkdir test_directory")`. If run on Windows the function will return the value returned by the shell, on Unix it will return the exit status of the process i.e. on a Unix system if the command was successful you would receive `0` as the exist status.


```python
import os

returned_val = os.system("mkdir yet_another_test")
print(returned_val)
os.chdir("yet_another_test")
print(os.getcwd())
os.chdir("../")
returned_val = os.system("rmdir yet_another_test")
print(returned_val)
```

    0
    /home/neal-i3/yet_another_test
    0


# Lets create a search function
Lets use the knowledge we've covered here to create a function that takes a path and a search word and searches all directories in the path for that word.


```python
import os

# create some folders to use
os.mkdir("./tree")
os.chdir("tree")
os.makedirs("c/other_courses/cpp")
os.makedirs("c/other_courses/python")
os.makedirs("cpp/other_courses/c")
os.makedirs("cpp/other_courses/python")
os.makedirs("python/other_courses/c")
os.makedirs("python/other_courses/cpp")
os.chdir("../")


def searcher(search_path, search_target):
    target_count = 0
    os.chdir(search_path) # enter the provided directory
    contents = os.listdir() # obtain a list of the contents
    if search_target in contents: # if our target is in the contents change into it
        os.chdir(search_target)
        target_count += 1 # increment our target count
        print(f"Target {target_count}: {os.getcwd()}") # print the path 
        os.chdir("../") # navigate back out to parent directory and continue

    for d in contents: # loop through the rest of the contents
        if os.path.isdir(d): # if the item is a directory change into it
            os.chdir(d)
            inner_dir = os.listdir() # obtain a list of the contents
            if search_target in inner_dir: # if our target is in the contents change into it
                os.chdir(search_target)
                target_count += 1 # increment
                print(f"Target {target_count}: {os.getcwd()}") # print path
                os.chdir("../..") # navigate back out
            for i in inner_dir: # loop through this inner directory
                if os.path.isdir(i): # if the current loop is a directory change into it
                    os.chdir(i)
                    ininind = os.listdir()
                    if search_target in ininind: # if our target is present change into it
                        os.chdir(search_target)
                        target_count += 1 # increment
                        print(f"Target {target_count}: {os.getcwd()}") # print path
                        os.chdir("../") # navigate back out
                    os.chdir("../..")
    os.chdir('/home/neal-i3')
    print(f"Found {target_count} {search_target}s")


searcher("./tree","python")
```

    Target 1: /home/neal-i3/tree/python
    Target 2: /home/neal-i3/tree/cpp/other_courses/python
    Target 3: /home/neal-i3/tree/c/other_courses/python
    Found 3 pythons



```python

```
