# Operators and Decision Constructs in Java

## Java Operators
An operator is a special symbol that applies certain actions to the values/variables/literals, referred to as *operands*, it's used with and returns a result. In Java there are 3 types of operators:
- `unary`: applied to *one* operand
- `binary`: applied to *two* operands
- `ternary`: applied to *three* operands

Operator name | Symbols | Examples
:--|:--|:--|
Post-unary | `expression++` and `expression--` | `x--;`
Pre-unary | `++expression` and `--expression` | `++y`
Other unary | `+`, `-`, `!` | `-5` (literal negative five), `!true` (literal false)
Multiplication/Division/Modulus | `*`, `/`, `%` | `x * y`
Addition/Subtraction | `+` and `-` | `x - y`
Shift operators | `<<`, `>>`, `>>>` |
Relational operators | `<`, `>`, `<=`, `>=`, `instanceof` | `obj instanceof Class`
Equality | `==` and `!=` | `x != y`
Bitwise Logical | `&`, `^`, `|` |
Short-circuit logical | `&&` and `||` |
Ternary | `[boolean expression] ? [if true] : [if false]` | `x < y ? x : y`
Assignment | `=`, `+=`, `-=`, `/=`, `%=`, `&=`, `^=`, `!=`, `<<=`, `>>=`, `>>>=`|

## Numeric Promotion
In Java, literals will sometimes be promoted to a larger data type if needed. The following are some general numeric promotion rules:
- If two values have different data types, java will automatically promote the smaller to a larger data type.
    - `long * int = long` in this case the int is promoted to a double as part of the operation.
- If one of the values is integral and the other is floating-point, Java will promote the integral to the same type as the floating-point.
    - `double * short = double` in this instance the short is promoted to a double
- `byte`, `short`, and `char` are first promoted to `int` any time they're used with a binary arithmetic operator, even if neither operand is an `int`
- After all promotions have been done and the operands have the same type, the resulting value will also have the same type.

## Literal Assumptions
Java makes certain assumptions about literals which are worth keeping in mind:
1. integral literals are assumed to be of type `int` (as opposed to byte, short, char, or long)
2. floating-point literals are assumed to be of type `double` (unless appended with `f` or `F`)

## Decision Constructs
Decision Constructs are methods of evaluating data to enable different actions depending on the result of the evaluation.

### `if` statement (aka `if-then` statement)
The most basic decision construct is an `if` statement (sometimes referred to as an `if-then` statement), where we tell Java to do something *if* a condition evaluates to true.


```Java
boolean hungry = true;

if(hungry) {
    System.out.println("I'm hungry!");
}
```

    I'm hungry!





    null



### `if-else` statement (aka `if-then-else` statement)
The `if-else` statement expands upon the `if` statement to allow you to specify an action if the initial expression is not true.


```Java
boolean thirsty = false;

if(thirsty) {
    System.out.println("Yes, I'd like some water please");
} else {
    System.out.println("I'm ok, thanks.");
}
```

    I'm ok, thanks.





    null



### The Ternary Operator
Java provides a nice shorthand for the `if-else` in the form of the *ternary operator*. The ternary operator consists of a conditional expression followed by `?`, then the action you want if the expression returns true, followed by `:`, and finally the action you want if the expression returns false. So, the form looks like this:
`<question> ? <if true> : <if false>`


```Java
boolean isRaining = true;

String doINeedAnUmbrella = isRaining ? "Yes, bring an umbrella" : "No umbrella necessary";

System.out.println(doINeedAnUmbrella);
```

    Yes, bring an umbrella





    null



### `switch` statement
The `switch` statement allows you to evaluate a single value and redirect to an appropriate branch. Each branch is representated by the `case` keyword. Two other important, though not mandatory, components of a switch statement are the `break` keyword and the `default` branch. `break` is used to tell Java to exit the switch statement after a particular branch has been executed (excluding the `break` keyword can cause *fall-through* where subsequent branches get executed until a `break` or the end of the switch. `default` allows you to set a default branch to be followed if none of the other branches execute.

__NOTE__
1. Switch can only evaluate the following data types:
- `int` and the `Integer` wrapper class
- `byte` and the `Byte` wrapper class
- `short` and the `Short` wrapper class
- `char` and the `Character` wrapper class
- `String`
- `enum` values
2. The `case` statement value must be one of the following:
- a literal
- enum constant
- final constant


```Java
String pet = "dog";

switch(pet) {
    case "cat":
        System.out.println("Kitty want some string?");
        break;
    case "bird":
        System.out.println("Polly want a cracker?");
        break;
    case "dog":
        System.out.println("Doggy want a belly rub?");
        break;
    default:
        System.out.println("I don't have any pets :(");
}
```

    Doggy want a belly rub?





    null



### `while` statement
The `while` statement will execute repeatedly as long as it's condition evaluates to true.


```Java
int cash = 5;
while(cash > 1) {
    System.out.println("I'll take 1 scratchcard please");
    cash--;
}
System.out.println("Better save my last 1 for the bus.");
```

    I'll take 1 scratchcard please
    I'll take 1 scratchcard please
    I'll take 1 scratchcard please
    I'll take 1 scratchcard please
    Better save my last 1 for the bus.





    null



### `do-while` statement
The `do-while` is a little like a reverse `while`, where you want the code to execute something and *then* evaluate if the expression is true. Very useful in cases where you want something to happen at least once.


```Java
int stopNum = 0;
int myStop = 7;

do {
    System.out.println("Sit on bus...");
    stopNum++;
} while(stopNum < myStop);
System.out.println("Time to get off!");
```

    Sit on bus...
    Sit on bus...
    Sit on bus...
    Sit on bus...
    Sit on bus...
    Sit on bus...
    Sit on bus...
    Time to get off!





    null




```Java

```
