# Importing Java Packages

## What are Packages?
A package is a collection of `classes` and `interfaces`. In Java all classes must be stored within a package. Any classes which you've used so far and *didn't* need to import are those stored in the __default package__.

## The `java.lang` Package
The fundamental classes & interfaces of the Java language are stored in the `java.lang` package which is automatically/implicitly imported.

One notable occupant is the `Object` class, the ultilmate parent class in Java from which all other classes are derived. The `String` and `Math` classes are two other such occupants.

## Importing Packages
There are two main ways to import packages in Java:

### Using the wildcard operator
If you want to import many classes from the same package, you use the __wildcard__ operator (`*`):
<br>`import java.util.*;`

This will make all clases from within that package available.

### Using the fully qualified name
If you only want to import one specific class you can use it's fully qualified name to import it:
<br>`import java.util.ArrayList;`

## Subpackages
A package stored within another package is known as a __subpackage__. 

To import a specific class from a subpackage using its fully qualified name, you would use this format: `import <package_name>.<subpackage_name>.<class_name>;`.

Importing all classes from a subpackage can be done like so: `import <package_name>.<subpackage_name>.*;`


```Java

```
