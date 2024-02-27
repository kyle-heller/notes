# Decision constructs

## If statement
An `if` statement executes some code *if* a certain condition is met e.g. *if var1 == 3, print it* or *if var2 is not equal to "cheese" don't print it*. The syntax for an if statement in Java is:
<br>
<br>
`if (bool expression) {
    code block
    }`


```Java
String foo = "bar";
if (foo == "bar") {
    System.out.println(foo);
}

if (foo == "cheese") {
    System.out.println("Where's my cheese?");
}
```

    bar





    null



## If/Else
An if statement can be extended to include an `else` block which will only be executed if the `if` block isn't. The syntax is:
<br>
<br>
`if (bool expression) {
    code block
} // end if
else {
    code block
} // end else`


```Java
String detective1 = "Sherlock";
String detective2 = "Watson";

if (detective1 == "Sherlock" && detective2 == "Watson") {
    System.out.println("The crime has been solved!");
} // end if
else {
    System.out.println("Ugh, not Lestrade.");
} // end else
```

    The crime has been solved!





    null



## If/Else If
You can further extend the functionality of an `if` statement by using an `if`/`else if` which allows you to perform multiple checks for different code blocks e.g. *if var1 is 1 or 2 print "Freddy's coming for you", else if var2 is 3 or 4 print "better lock your door", else if var 3 is 5 or 6 print "get a crucifix"* and so on. The syntax is:
<br>
<br>
`if (bool expr) {
    code block
} // end if
else if (bool expr) {
    code block
} // end else if
else {
    clode block
} // end else`


```Java
int scarySong = 8;

if (scarySong == 1 || scarySong == 2) {
    System.out.println("Freddy's comin' for you");
} // end if
else if (scarySong == 3 || scarySong == 4) {
    System.out.println("Better lock your door");
} // end else-if 1
else if (scarySong == 5 || scarySong == 6) {
    System.out.println("Get a crucifix");
} // end else-if 2
else if (scarySong == 7 || scarySong == 8) {
    System.out.println("Gonna stay up late");
} // end else-if 3
else {
    System.out.println("Never sleep again!");
} // end else
```

    Gonna stay up late





    null



## Switch statement
Chaining multiple `if`/`else if` can eventually become unwieldy. To simplify this somewhat you can use a `switch` construct instead. The syntax is:
<br>
<br>
`switch (variable_to_test) {
    case literal_value:
        code block
        break;
    case literal_value:
        code block
        break;
    default:
        code block
} // end switch`

The variable being tested in a switch construct can only be of types `String`, `char`, `byte`, `short`, or `int`. The combination of a `case` keyword and a `literal_value` is referred to as a __case label__. The `[break;]` statement is an optional way to escape execution at a defined point. If you do not include any breaks then all code after a matching `case` will be executed until the end of the construct (this is called __fall-through__).


```Java
int nonScarySong = 9;
// Switch example 1
switch (nonScarySong) {
    case 1:
    case 2:
        System.out.println("Buckle my shoe");
        break;
    case 3:
    case 4:
        System.out.println("Knock at the door");
        break;
    case 5:
    case 6:
        System.out.println("Pick up sticks");
        break;
    case 7:
    case 8:
        System.out.println("Lay them straight");
        break;
    default:
        System.out.println("A big fat hen");
} // end switch
```

    A big fat hen





    null



## Using the ternery conditional operator as an `if`/`else`
The __ternery operator__ (`?:`) is used as a succinct if/else construct. The syntax is:
<br>
<br>`condition ? if_true_do_this : if_false_do_this`


```Java
String detective1 = "Holmes";
String detective2 = "LeStrade";
String status = (detective1=="Holmes")? "Solved!": "Pending...";

System.out.println(status);
```

    Solved!





    null




```Java

```
