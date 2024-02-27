# Operators, Promotion, and Type casting

## Order of operations
As with most programming languages a clear order of operations needs to be set for occasions when multiple operations are requested at the same time. Java's order of operations is as follows:

Code|Meaning|Importance
:--|:--|:--
`()`|Parentheses|1
`++`&`--`|Increment/Decrement|2
`*`&`/`|Multiplication/Division|3
`*`&`-`|Addition/Subtraction|4

If multiple operations of the same importance are requested at the same time they are evaluated from left to right.

## Binary operators
Binary operators are operators which take two "operands" e.g. *add this to that*.

Operator|Name|Usage|Example
:--|:--|:--|:--
`+`|Plus|Add numerical values/concatenate strings w/ other strings, variables etc|`System.out.println("I am "+myAge+" years old")`
`-`|Minus|Subtract numerical values|`netSalary = grossSalary - taxDue`
`*`|Times|Multiplication/Duplication|`bunnyMultiplier = bunny * 2`
`/`|Divide|Division|`System.out.println(42/12)`
`%`|Modulus/Remainder|Returns remainder of division|`System.out.print(12%11) // prints 1`

__NOTE__: *division by zero will result in an error message*

## Unary operators
Unary operators only take one operand e.g. *increase this by 1*.

Operator|Name|Usage
:--|:--|:--
`+`|Unary Plus|Indicates positive value
`-`|Unary Minus|Indicates negative value
`++`|Increment|Increase by 1
`--`|Decrement|Decrease by 1
`!`|Logical complement|Inverts the value of a boolean

## Assignment operators
As you'd expect, assignment operators assign a value.

Operator|Name|Description|Example
:--|:--|:--|:--
`=`|equals|Assigns the value on the right to the item on the left|`myInt = 10`
`+=`|plus-equals|Increases and assigns the item on the left by the item on the right|`myInt += 1`
`-=`|minus-equals|Decreases and assigns the item on the left by the item on the right|`myInt -= 4`
`*=`|times-equals|Multiplies and assigns the item on the left by the item on the right|`myInt *= 3`
`/=`|divide-equals|Divides and assigns the item on the left by the on the right|`myInt /= 2`
`%=`|remainder-equals|Gets the remainder of the item on the left divided by the item on the right and assigns|`myInt %= 1`

## Logical operators
Logical operators are generally used for comparing two things e.g. *Is this bigger than that*.

### Equality & relational Operators

Operator|Meaning
:--|:--
`==`|Equal to
`!=`|Not equal to
`>`|Greater than
`>=`|Greater than or equal to
`<`|Less than
`<=`|Less than or equal to

### Conditional operators

Operator|Meaning
:--|:--
`&&`|Conditional AND
`\|\|`|Conditional OR
`!`|NOT
`?:`|Ternary (shorthand for `if then else` statement)

__NOTE__: *In the case of `&&` the second part of the operation will only be reached if the first part is true. In the case of `||` the second part will only be reached if the first part is false. For example "is x AND y true" you only need to worry about whether "y" is true if you've already established that "x" is true.*

### Type comparison operator

Operator|Meaning
:--|:--
`instanceof`|Compares an object to a specified type

## Increment and Decrement
As in many languages Java has a shorthand for incrementing and decrementing by `1`:
- `++` increments (increases) the value by 1
- `--` decrements (decreases) the value by 1

The placement of the increment/decrement is important as Java includes the concept of *pre*-decrement/increment and *post*-decrement/increment. If you're performing multiple operations at the same time and you place the `++`/`--` *before* the variable to be incremented/decremented then Java will perform the increment/decrement before any other operations. 

Example:


```Java
int myInt = 7; // initialise myInt with value of 7
System.out.println(myInt++); // print and THEN increment by 1
System.out.println(myInt); // just print (so we can see that it was in fact incremented)
```

    7
    8





    null



## Type casting and Promotion
If you try to assign a variable or expression to another variable of a different type, there's a good change you will receive an error unless you're assigning to a larger (as in memory) type. For example:


```Java
int num1 = 42; // int is 32 bits
int num2 = 5; // int is 32 bits
byte num3 = num1 + num2; // byte is 8 bits
```


    incompatible types: possible lossy conversion from int to byte

     byte num3 = num1 + num2

                 ^          ^ 


To fix this you can either __promote__ the bottom variable to a larger type or __type cast__ the first to variables to a smaller type.


```Java
// EXAMPLE 1: promotion
int num4 = 42;
int num5 = 5;
int num6 = num4 + num5;

// EXAMPLE 2: type casting
int num7 = 42;
int num8 = 5;
byte num9 = (byte)(num7 + num8);
```




    null



### Promotion
Promotion is the act of changing a variable from a smaller to a larger type (as in example one above).

### Type casting
Type casting is the act of changing a variable from a larger type down to a smaller type. The format is:
<br>`variable_name = (type)(value)` *(you only need the second set of parentheses if the value is an expression)*

__USE WITH CAUTION__ as type casting can often result in a loss of data

### Compiler auto-changing type
In some cases the Java compiler will automatically change a variable to a larger type. This is called __promotion__. Promotions may be automatically done by the compiler if data would not be lost by doing so. Such promotions occur under the following conditions:
- If you assign a smaller type (on the right of the `=`) to a larger type (on the left of the `=`). Example: 
    <br>`int job1 = 100;`
    <br>`int job2 = 56;`
    <br>`long job3 = job1 * job2;`
- If you assign an int type to a float type, because there are no decimal places to lose

The compiler makes some assumptions when evaluating an expression. Most operations result in an `int` or `long`.
- `byte`, `char`, and `short` values are promoted to `int` before an operation is performed.
- If either of type `long` the other is also promoted to `long` and the result will be `long`.
- If an expression contains a `float` the entire expression is promoted to `float`
- *literal* floating-point values are seen as `double`. This is why we need to put `F` or `f` at the end of a float value (doing so tells Java that it's a float). Example:
    <br>`float myFloat = 31.5f;`
    - You can also type cast to float instead of using the `F`/`f` assignment. Example:
    <br>`float myFloat = (float) 31.5;`


```Java
byte b1 = 1, b2 = 2;
byte b3 = b1 + b2; // will result in an error even though all are bytes because the b1 and b2 are promoted to int before the addition is performed
```


    incompatible types: possible lossy conversion from int to byte

     byte b3 = b1 + b2

               ^      ^ 


### Temporary memory location
When an equation is being assigned to a variable, before the assignment happens the equation is placed in a temporary memory location. This locations size is always equal to either an `int` or the largest type used in the expression. So, if you have a `long` to which you're assigning the result of an expression which is `int * int`, before the expression is assigned to the larger `long` size variable it is placed in a temporary memory of space `int`. This means that if the result of the expression is greater than what an `int` can hold your result will likely be incorrect due to loss of data (as the result will be truncated to fit an `int`).
<br>`int first = 2_120_342;`
<br>`int second = 2_325_860;`
<br>`long = first + second;`

To avoid such an occurence you can make sure that one of the variables in your expression is a `long`.


```Java
int first = 55555; // int
int second = 66666; // int
long third = first * second; // temporarily stored in an int before being assigned to a long

System.out.println("Lossy calculation: " + third);

int smaller = 55555; // int
long larger = 66666; // long
long largest = smaller * larger; // temprarily stored in the largest var of the equation (long) before being assigned to a long

System.out.println("Non-lossy calculation: " + largest);
```

    Lossy calculation: -591337666
    Non-lossy calculation: 3703629630





    null



### Assigning the result of an expresssion to `long`
If you declare a `long` and try to initialise it with an expression whose result may exceed the boundaries of an `int` you need to make sure to cast one of the values with an `L`/`l` (otherwise the calculation will lose data in the temporary `int` sized storage).


```Java
long myLong = 55555 * 66666; // incorrect value due to loss of data
System.out.println(myLong);

long myActualLong = 55555L * 66666;
System.out.println(myActualLong);
```

    -591337666
    3703629630





    null



## Loss of magnitude vs loss of precision
One intricacy of type conversion that's a little unintuitive is that __loss of magnitude__ (i.e. *this will not fit into that*) requires explicit casting (meaning you have to force the data and essentially confirm that you're ok with any loss of data) whereas __loss of precision__ (i.e. *this will fit into that but might not match exactly*) doesn't require casting.

Java works on a "widening path" where `byte`<`short`<`int`<`long`<`float`<`double`. So conversion going from left-to-right (e.g. `long` to `float`) will not require casting whereas a conversion going from right-to-left (e.g. `double` to `long`) will.

## Bitwise operators
Bitwise operators are operators specifically for use with __long__, __int__, __short__, __char__, and __byte__ values. They cannot be used on __boolean__, __float__, __double__, or class types. They're used to test, set, and shift individual bits (hence the name bitwise) that make up a value. Bitwise operations are generally used in systems-level programming.

Operator|Meaning
:--|:--
`&`|Bitwise AND
`\|`|Bitwise OR
`^`|Bitwise exclusive OR
`>>`|Shift right
`>>>`|Unsigned shift right
`<<`|Shift left
`~`|One's complement (unary NOT)


```Java

```
