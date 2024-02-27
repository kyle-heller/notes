# Lambda Expressions
Java 8 introduced *lambda expressions* which is essentially an anonymous function that gets passed around by other methods/functions. They have parameters and a body like normal methods but they don't have a name. In other languages they're often referred to as *closures*.

A very simple lambda expression might look something like this:
<br>`param -> param.doSomething()`

The above is a function that takes the parameter `param` and returns the result of calling the `doSomething()` method on `param`. We could rewrite it like this:
<br>`(Object param) -> { return param.doSomething(); }`

The parentheses around the parameter can be omitted if there's only a single paramater and it's type isn't being explicitly declared. Likewise the curly-braces and `return` keyword can be omitted when there's only a single statement.

The below table lists some examples of Lambda expressions:

Lambda Expression|Notes
:--|:--
`(Integer i1, Integer i2) -> { return i1 * i2; }`|This is the full syntax
`(Double d1, Double d2) -> d1 * d2`|Curly braces and *return* keyword can be omitted if the body is a single statement
`s -> { return s.charAt(2); }`|Parentheses around parameter can be omitted if there's only one param and it's *type* is not stated
`(String s) -> { return s.indexOf('a'); }`|If there's a single param but it's type is specified, parentheses are required
`(s1, s2) -> { String part1 = s1; String part2 = s2; if (part1.equals(part2) { return part1; } else {return part1 + part 2; }}`| Multi-statement body must be enclosed in braces
`() -> 12`|*Runnable* and *Callable* Functional Interfaces have abstract methods without params, so no target type is included

Lamda's can appear in any of the following contexts:
- assignments
- array initializers
- cast expressions
- constructor arguments
- lambda bodies
- method arguments
- return statements
- ternery expressions
- variable declarations

## Lambdas accessing variables
If lambdas are anonymous functions and functions often manipulate variables, then what variables can a lambda function access? This depends on the context but it's possible for lambdas to access instance & static variables and also method parameters & local variables as long as they're not trying to redeclare them.

## Functional Interfaces in Java
Lambda expressions need to have a *Functional Interface* (also known as a *single abstract method (SAM)*). *Functional Interfaces* provide target *types* (i.e. the return type) for lambda expressions in addition to method references. Functional Interfaces must have exactly one abstract method (`test`) and since the name of this method is known, the method name is excluded from the lambda expression.

A Functional Interface can have one or more default methods and one or more static methods. Default methods allow for the addition of new code to the interface. An example of a Functional Interface that includes default methods is the *Predicate* interface from `java.util.function`

## Predicates
`Predicate` is an interface provided by Java in the `java.util.function` package and looks like this:
<br>
<br>`public interface Predicate<T> {`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`boolean test(T t);`
<br>`}`

So, a `Predicate` takes a single input and returns a boolean.

An example of a method which uses the *Predicate* interface is *ArrayList's* `removeIf()` method which removes all elements of an *ArrayList* that satisfy the expression.


```Java
import java.util.ArrayList;

ArrayList<String> justiceLeague = new ArrayList<>();
justiceLeague.add("Superman");
justiceLeague.add("Wonder Woman");
justiceLeague.add("Batman");
justiceLeague.add("Hawkman");
System.out.println(justiceLeague);
justiceLeague.removeIf(hero -> hero.charAt(0) != 'B'); // lambda expression passed to removeIf()
System.out.println(justiceLeague);
```

    [Superman, Wonder Woman, Batman, Hawkman]
    [Batman]





    null



### Lambda Types
A lambda *type*, specifies the type of expression a method is expecting. For example, the `.replaceAll()` method from `java.util.List` has a signature like this:
<br>`.replaceAll(UnaryOperator<E> operator)`

This tells us that *replaceAll* takes a *UnaryOperator* type expression. A *UnaryOperator* has a single input and returns a value of the same *type* as the input i.e. if passed a `String` it will return a `String`.


```Java

```
