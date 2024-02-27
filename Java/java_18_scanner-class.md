# The `Scanner` class

## What is a scanner?
`Scanner` is a class located in the `java.util` package which allows us to read data in (for example from the keyboard or from a file).

## Getting user input
As with most Java classes you need to instantiate an object in order to use scanners and pass the constructor some info. For example if we want to get user input from the keyboard we need to pass `System.in` which tells Java to read from the standard input device (the keyboard).


```Java
import java.util.Scanner;

Scanner keyboardInput = new Scanner(System.in);

System.out.print("Enter your favourite word: ");
String userFavWord = keyboardInput.nextLine();
System.out.printf("%nYour favourite word is \"%s\".%n", userFavWord);
```

    Enter your favourite word: Blob
    
    Your favourite word is "Blob".





    null



## What methods are available in the `Scanner` class?
The following methods is a short list of *some* methods included in the Scanner class.

Method|Description
:--|:--
`nextByte()`|Reads an integer of type `byte`
`nextShort()`|Reads an integer of type `short`
`nextInt()`|Reads an integer of type `int`
`nextLong()`|Reads an integer of type `long`
`nextFloat()`|Reads a number of type `float`
`nextDouble()`|Reads a number of type `double`
`next()`|Reads a string which ends before a whitespace character
`nextLine()`|Reads a string which ends when `<Enter>`/`<Return>` is typed


```Java
import java.util.Scanner;

Scanner keyboardInput = new Scanner(System.in);

System.out.print("Pick a number between -128 and 127: ");
byte byteInput = keyboardInput.nextByte();
System.out.printf("Your byte input was: %d",byteInput);
```

    Pick a number between -128 and 127: 120
    Your byte input was: 120




    null




```Java
import java.util.Scanner;

Scanner keyboardInput = new Scanner(System.in);

System.out.print("Enter a decimal: ");
float floatIn = keyboardInput.nextFloat();
System.out.printf("Your decimal was: %.2f%n",floatIn);
```

    Enter a decimal: 3.456
    Your decimal was: 3.456000





    null




```Java
import java.util.Scanner;

Scanner keyboardInput = new Scanner(System.in);

System.out.print("Type something: ");
String smthIn = keyboardInput.next();
System.out.printf("You typed: %s", smthIn);
```

    Type something: Bah Weep Grana
    You typed: Bah




    null




```Java
import java.util.Scanner;

Scanner numInput = new Scanner(System.in);

int theNum;

do {
    System.out.print("Please enter a number between 1 and 5: ");
    theNum = numInput.nextInt();
} while (theNum != 1
         && theNum != 2
         && theNum != 3
         && theNum != 4
         && theNum != 5);
numInput.close();
System.out.println("You chose " + theNum);
```

    Please enter a number between 1 and 5: 7
    Please enter a number between 1 and 5: 4
    You chose 4





    null




```Java

```
