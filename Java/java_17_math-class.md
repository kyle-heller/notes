# Java's `Math` Class

## What is the `Math` class
The `Math` class provides commonly used mathematical functions and is defined in the `java.lang` package.

## Importing the `Math` class
Since `Math` is in the `java.lang` package it's already implicity imported in every new class file.

## Using `Math`
Many of the methods in the `Math` class are declared as `static` which means we can use them with a class reference (`<class_name>.<method_name>`) and don't need to instantiate an object first. Since the `Math` class is implicitly imported we can make use of its methods by simply calling them with `Math.<method>`.


```Java
System.out.println(Math.abs(-7)); // return absolute value
System.out.println(Math.PI); // Pi
System.out.println(Math.ceil(61.41));
System.out.println(Math.floor(61.41));
```

    7
    3.141592653589793
    62.0
    61.0





    null



## Useful methods
Below are some commonly used `Math` methods.

### `ceil(double x)`
Takes a `double` and returns the smallest double value that is greater than or equal to the argument


```Java
System.out.println(Math.ceil(4.3));
```

    5.0





    null



### `floor(double x)`
Takes a `double` and returns the largest double value that is less than or equal to the argument


```Java
System.out.println(Math.floor(4.8));
```

    4.0





    null



### `max(x, y)`
Takes two `int`/`long`/`float`/`double` and returns the greater.


```Java
System.out.println(Math.max(224, 365)); // int
System.out.println(Math.max(81565435l, 215956423l)); // long
System.out.println(Math.max(21.4f, 22.9f)); // float
System.out.println(Math.max(2755.7d, 3215.7d)); // double
```

    365
    215956423
    22.9
    3215.7





    null



### `min(x, y)`
Takes two `int`/`long`/`float`/`double` and returns the lesser.


```Java
System.out.println(Math.min(224, 365)); // int
System.out.println(Math.min(81565435l, 215956423l)); // long
System.out.println(Math.min(21.4f, 22.9f)); // float
System.out.println(Math.min(2755.7d, 3215.7d)); // double
```

    224
    81565435
    21.4
    2755.7





    null



## `pow(x, y)`
Returns the value of the first argument raised to the power of the second argument.


```Java
System.out.println(Math.pow(24, 17));
```

    2.9079779498268256E23





    null



### `random()`
Returns a double value between `0.0` and `1.0`.


```Java
System.out.println(Math.random());
```

    0.6190658639655292





    null



### `sqrt()`
Returns the rounded positive square root of a double value


```Java
System.out.println(Math.sqrt(64));
```

    8.0





    null




```Java

```
