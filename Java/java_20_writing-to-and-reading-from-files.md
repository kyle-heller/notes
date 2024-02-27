# Writing to and reading from files in Java
__NOTE__: There are no questions on the *Foundations* exam related to writing/reading to/from files.

## Writing to a file
To write to a file we're going to use several classes from the `java.io` package:
- `File`: to instantiate a file type object which is a representation of a file for Java to work with.
- `FileWriter`: a "*convenience class*" for writing characters to file.
- `BufferedWriter`: a wrapper class that writes text to a "character-output stream", buffering characters to provide efficient writing.
- `PrintWriter`: prints formatted representations of objects to a text-output stream.
- `IOException`: to handle exceptions that may occur

Why are so many classes needed to write to a file? [According to the API](https://docs.oracle.com/javase/7/docs/api/):
<br>
<br>*In general, a Writer sends its output immediately to the underlying character or byte stream. Unless prompt output is required, it is advisable to wrap a BufferedWriter around any Writer whose write() operations may be costly, such as FileWriters and OutputStreamWriters. Without buffering, each invocation of a print() method would cause characters to be converted into bytes that would then be written immediately to the file, which can be very inefficient.*


```Java
package test.beaker;

import java.io.*; // lazily import everything from IO

public class FileOut {
    public void writeOut() {
        File file = new File("hello_world.txt"); // instantiate a File object
        
        try {
            FileWriter fWrite = new FileWriter(file, true); // instantiate a FileWriter object, this is the point where an exception is most likely
            
            BufferedWriter bWrite = new BufferedWriter(fWrite); // instantiate a BufferedWriter to make the above writer more efficient
            
            PrintWriter pWrite = new PrintWriter(bWrite); // instantiate a PrintWriter to actually take our input and pass it through to the above writers
            
            pWrite.println("Hello World!"); // text to write to the file
            
            System.out.println("File write successful!"); // if execution gets this far there likely hasn't been an exception
            
            pWrite.close(); // close the stream
        }
        catch(IOException e) {
            System.out.println("File write failed: " + e); // message if exception occurs
        }
    } // writeOut
} // class
```




    test.beaker.FileOut




```Java
package test.beaker;

FileOut myFile = new FileOut();
myFile.writeOut(); // if successful you should see the file "hello_world.txt" in the same directory as this notebook
```

    File write successful!





    null



## Reading from a file
To read from the file we just created we're going to use a very similar process with several more classes from `java.io`:
- `File`: to instantiate the file object so we can work with it
- `FileReader`: to instantiate a reader object for reading from the file
- `BufferedReader`: the reading corollary of __BufferedWriter__, a wrapper class to make reading characters more efficient. [Per the API](https://docs.oracle.com/javase/7/docs/api/): *Without buffering, each invocation of read() or readLine() could cause bytes to be read from the file, converted into characters, and then returned, which can be very inefficient.*
- `IOException`: to handle exceptions


```Java
package test.beaker;

import java.io.*; // lazily import all IO classes

public class FileIn {
    public void readIn() {
        File file = new File("hello_world.txt"); // instantiate file object
        
        try {
            FileReader fRead = new FileReader(file); // create reader
            
            BufferedReader bRead = new BufferedReader(fRead); // create buffered read
            
            String line = bRead.readLine(); // create variable to represent the lines being read
            
            while (line != null) { // check if there's anything else to be read
                System.out.println(line);
                line = bRead.readLine();
            } // while
            System.out.println("File read successful!"); // if we got this far probably no exceptions
        }
        catch(IOException e) {
            System.out.println("File read failed: " + e); // handle IOException if thrown
        } // try-catch
    } // readIn
} // class

```




    test.beaker.FileIn




```Java
package test.beaker;

FileIn myFileRead = new FileIn();
myFileRead.readIn();
```

    Hello World!
    File read successful!





    null




```Java

```
