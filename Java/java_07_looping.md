# Looping in Java
Looping is a way to have code execute repeatedly as long as a specified condition is met. There are several looping constructs available in Java including:
- A `while` loop: repeats *while* an expression is true
    <br>e.g. "*while x is 10 do this*"
- A `for` loop: repeats for a set number of times.
    <br>e.g. "*for x number do this*"
    - An __enhanced__ `for` loop will loop through the elements of an array
- A `do/while` loop: executes *once* then continues *while* a condition is true.
    <br>e.g. "*do this, then repeat as long as x is true*"
    
Construct|When to use
:--|:--
`while`|To loop indefinitely
`for`|To loop a fixed number of times
`for`+|To loop through an array
`do/while`|To execute code at least once and loop indefinitely

## While
A while loop will only execute its code if and as long as a condition is true. The syntax is:
<br>`while (boolean expression) {repeat this code}`

Example:
<br>
<br>`boolean sunIsUp = false;`
<br>`while (!sunIsUp) {` //*remember the ! here means __NOT__, so while NOT sunIsUp basically means while sunIsUp is false*
    <br>&nbsp;&nbsp;&nbsp;&nbsp;`boolean vampireHunting = true;`
    <br>&nbsp;&nbsp;&nbsp;&nbsp;`System.out.println("I love drinking blood!");`
    <br>`}`


```Java
int batteryPercentage = 100;
while (batteryPercentage>15) {
    System.out.println("Can you hear me now? Hello?");
    batteryPercentage -= 25;
}
System.out.println("Dang battery");
```

    Can you hear me now? Hello?
    Can you hear me now? Hello?
    Can you hear me now? Hello?
    Can you hear me now? Hello?
    Dang battery





    null



## For
The standard `for` loop executes its code a set number of times. The syntax is:
<br>`for (counter_variable; boolean_expression; counter_increment) {repeat this code}`

Example:
<br>
<br>`for (int i = 5; i > 0; i--){`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`System.out.println("Countdown: " + i);`
<br>`}`



```Java
for (int i = 0; i < 3; i++) {
    System.out.println("Where's the money Leboffski?");
}
```

    Where's the money Leboffski?
    Where's the money Leboffski?
    Where's the money Leboffski?





    null



## Enhanced For
An __enhanced__ `for` loop is used for looping through arrays. The syntax is:
<br>`for (<type> variable_name: array_to_loop) {repeat this code}`

Example:
<br>
<br>`for (String name: favFilms) {`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`System.out.println(name);`
<br>`}`


```Java
String beatles[] = {"John", "Paul", "George", "Ringo"};

for (String name: beatles) {
    System.out.println(name + " is a Beatle");
}
```

    John is a Beatle
    Paul is a Beatle
    George is a Beatle
    Ringo is a Beatle





    null



However, you can accomplish the same thing with a standard `for` loop in combination with the arrays `.length` property:


```Java
String beatles[] = {"John", "Paul", "George", "Ringo"};

for (int i = 0; i < beatles.length; i++) {
    System.out.println(beatles[i] + " is a Beatle");
}
```

    John is a Beatle
    Paul is a Beatle
    George is a Beatle
    Ringo is a Beatle





    null



## Do/While
A `do/while` loop will execute its code once regardless of any condition, then for each repeat it will only execute if the condition is met. The syntax is:
<br>`do {repeat this code} while (expression)`

Example:
<br>`do {`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`System.out.println("I am the walrus.");`
<br>`} while (isJohnLennon);`


```Java
boolean isJohnLennon = false;
do {
    System.out.println("I am the walrus"); // will execute AT LEAST once
} while (isJohnLennon); // semi-colon is MANDATORY
```

    I am the walrus





    null



## Breaking a loop
There are two keywords you can use to interrupt a loop:
- `break`: which will cause the code to exit the loop
- `continue`: will cause the loop to skip the current iteration and continue


```Java
String beatleList [] = {"John", "Paul", "Pete", "George", "Mick Jagger", "Ringo"};

for (String name: beatleList) {
    if (name == "Pete") { // skip Pete
        continue;
    }
    if (name == "Mick Jagger") { // stop if Mick appears
        break;
    }
    System.out.println(name);
}
```

    John
    Paul
    George





    null


