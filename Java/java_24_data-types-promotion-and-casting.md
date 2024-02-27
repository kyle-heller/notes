# Data types, promotion, and casting in Java
This notebook will give an overview of data-types as well as discuss promotion and casting.

## Primitive Data Types
The primitive data types in Java are:
- Integral (`byte`, `short`, `int`, `long`)
- Floating point (`float`, `double`)
- Textual (`char`)
- Logical (`boolean`)

### Integral Types
Type|Length|Range
:--|:--|:--
`byte`|8 bits|$$-2^{7} \Rightarrow (2^{7}-1)$$ (aka `-128` to `127`)
`short`|16 bits|$$-2^{15} \Rightarrow (2^{15}-1)$$ (aka `-32,768` to `32,767`)
`int`|32 bits|$$-2^{31} \Rightarrow (2^{31}-1)$$ (aka `-2,147,483,648` to `2,147,483,647`)
`long`|64 bits|$$-2^{63} \Rightarrow (2^{63}-1)$$ (aka `-9,223,372,036,854,775,808` to `9,223,372,036,854,775,807`)

The default type for integral literals in Java is `int` and the JVM will assume an integral literal is an `int` unless otherwise declared/cast.

### Floating Point Types
Type|Length
:--|:--
`float`|32 bits
`double`|64 bits

The default type for floating literals is `double` and the JVM will assume a floating literal is a `double` unless declared with `F` at the end of the literal (e.g. `0.1F`) or cast;.

### Textual Type
Type|Length
:--|:--
`char`|16 bits

To declare a `char` you must use single quotes (e.g. `char myChar = 'U';`).

## Constants
You can declare a variable to be *constant* (i.e. it's value cannot change) using the `final` keyword. Convention is to put constant variable names all UPPERCASE with underscores (`_`) separating words.


```Java
final int MY_CONSTANT_INT = 5;
MY_CONSTANT_INT = 7; // Will throw an error
```


    cannot assign a value to final variable MY_CONSTANT_INT

     MY_CONSTANT_INT = 7

     ^              ^     


## Promotion
Promotion is when you convert one type to a larger type. If you assign a small type to a larger type using `=` the JVM will automatically convert the type to the larger.

For example, given the integral types:
`byte < short < int < long`
<br>
`byte myByte = 1;`
<br>
`short myShort = myByte;`

Similarly since integral types are smaller than floating types:
<br>
`int myInt = 32;`
<br>
`float myFloat = myInt;`

Something to keep in mind is that since Java assumes any integral literal to be an `int`, that if you declare a `long` variable and don't put an `L` at the end of the literal, what you're actually doing is assigning an `int` literal to a `double` variable and Java will automatically promote it as such.

**CAUTION**: Keep the ranges of types in mind when doing large sums, as if the result of an sum exceeds the maximum value allowed by the type, the value will be warped. If you need to, for example, multiply two large `int`s and there's a risk that the result will exceed the max value of `int` type, you can make one of the `int`s a `long` and Java will make sure the result is a `long`.

## Casting
Casting is the functionality Java provides to allow you to promote (or demote) types. To do so, you simply put your target type in parenthesis between the `=` and the value.


```Java
int num1 = 1;
float num2 = 3.0F;
byte num3 = (byte) (num1 + num2); // Java doesn't throw an error because we are explicitly telling the JVM to cast the sum of the int & float to a smaller
```




    null



## Compiler Assumptions for Integral and Floating Point Types
- Most operations result in `int` or `long`
    - `byte`, `char`, and `short` values are automatically promoted to `int` prior to an operation
    - If an expression contains a `long`, the entire expression is promoted to `long`
- If an expression contains a floating point, the entire expression is promoted to floating point
- All literal floating point values are viewed as `double`

### Possible problem with automatic promotion
One issue you can run into with automatic promotion is if you try to assign the result of a, for example, `short` operation to a `short` variable. Since Java automatically promotes the `shorts` to `int` before completing the operation, you are essentially trying to assigne an `int` to a `float` and Java will throw a compiler error.


```Java
short x, y, z;
x = 1;
y = 2;
z = x + y; // Will error out
```


    incompatible types: possible lossy conversion from int to short

     z = x + y

         ^    ^ 



```Java
short a, b, c;
a = 1;
b = 2;
c = (short) (a + b); // casting the operation to short prevents error but can result in a loss of precision
```




    null


