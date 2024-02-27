# Array and ArrayList

## Understanding Java Arrays
An *Array* is an object in *heap memory* which holds space for a specified number of ordered elements. A String is essentially an array of characters with some additional useful methods added. 

### Creating Arrays of Primitives
You create an *array* object in a very similar fashion to other objects but using square brackets `[]` rather than the word "array":
<br>`int [] intArr;`

Above we declare a variable of type `int []` but we haven't actually initialized an array yet. We can do so like this:
<br>`intArr = new int[12];`

Where `12` is the number of items in the array. To initialise an array you must either provide the length of the array (i.e. the number of items it will hold) like this:
<br>`int [] intArr = new int [4];`

The above creates a variable named `intArr` which is *array* that holds four (as yet undeclared) `int` primitives. To populate this array with `int` primitives we use index notation:
<br>`intArr[0] = 1;`

Now we've added the primitive `1` at index 0 of `intArr`.

Or you can declare and populate an array in one line by enclosing the elements you want in the array in *curly braces*:
<br>`int [] intArr = new int[] {0, 1, 2}`

That can be abbreviated even further by excluding the `new int[]` from the right hand side of the expression (this is referred to as an *anonymous array* as we haven't specified the type or size):
<br>`int []intArr = {0, 1, 2};`

__NOTE__: you can place the square brackets anywhere after the type and before the equals sign. The following are all valid:
<br>`int intArr[];`
<br>`int[] intArr;`
<br>`int []intArr;`
<br>`int intArr [];`


```Java
int [] intArr = {24, 161, 83};
System.out.println(intArr[0]);
System.out.println(intArr[1]);
System.out.println(intArr[2]);
System.out.println(java.util.Arrays.toString(intArr));
```

    24
    161
    83
    [24, 161, 83]





    null



### Mixing variable declarations
Java permits you to create primitive and primitive-array variables on one line, however, it's not an advisable practice and shouldn't be used. It's worth knowing that this is permitted though.


```Java
double dArray[], dub; // this creates one double-array "dArray" and one double "dub";

dub = 3.4D;
dArray = new double [2];

dArray[0] = dub;
dArray[1] = dub+dub;

System.out.println("Double variable: " + dub);
for (double d: dArray) {
    System.out.println("Double Array item: " + d);
}

```

    Double variable: 3.4
    Double Array item: 3.4
    Double Array item: 6.8





    null



### Creating an Array of reference variables
We're not limited solely to primitives with *arrays*; we can also create an array of object references. For example, String references:
<br>`String [] strArray = new String[4];`

__NOTE__: the array doesn't hold the String objects themselves, just references to their space in memory (i.e. in the String pool)


```Java
String [] strArr = new String[2];
strArr[0] = "Hello ";
strArr[1] = "World!";
System.out.println(java.util.Arrays.toString(strArr));
```

    [Hello , World!]





    null



### An initialized but unfilled array
As soon as you initialize an array, even if you haven't populated it's items yet (remember, when you initialize an array you have to either state how many elements will be in it or declare the elements), it will have a length equal to the declared number of elements. If you declared the number of element but haven't populated them yet each element will simply be `null`.


```Java
String [] strArr = new String [6];
System.out.println(strArr.length);
System.out.println(java.util.Arrays.toString(strArr));
```

    6
    [null, null, null, null, null, null]





    null



### Sorting an array
Java provides a `.sort()` method to allow you to easily sort arrays. Since the Arrays class isn't included in the standard library you need to import it (or use a fully qualified domain name):
<br>`import java.util.Arrays;`


```Java
import java.util.Arrays; // importing like this allows us to access Arrays methods by simply called `Array.methodName()`

String [] strArr = new String[3];
strArr[0] = "Hello ";
strArr[1] = "World";
strArr[2] = "!!";

System.out.println(Arrays.toString(strArr));
Arrays.sort(strArr); // sort the array in place
System.out.println(Arrays.toString(strArr));
```

    [Hello , World, !!]
    [!!, Hello , World]





    null



### Searching
Java provides a `.binarySearch(arrayToSearch, itemToSearchFor)` which can be used to search *sorted* arrays.

Use|Result
:-|:-
Target found in sorted array|Array index of the target element
Target not found in sorted array|Negative value representing 1 less than the index your target would need to be inserted to preserve sorting order
Unsorted array|Unpredictable result


```Java
import java.util.Arrays;

int [] numArr = {1, 2, 3, 4, 5};
System.out.println(Arrays.binarySearch(numArr, 5));
```

    4





    null



### Varargs
We'll deal with *varargs* in more detail later but for now it's useful to know that such a thing exists and can be treated as a normal array.
<br>`public static void main(String... args){}`

Above is a *main method* where rather than the usual String array `args` we've used *varargs*.

### Multidimensional arrays
Multidimensional arrays are basically arrays within arrays or nested-arrays. You declare them by adding additional square-brackets `[]`.


```Java
int [][] intArr = new int[4][6]; // declare an array of 4 elements each of which is an array of 6 elements
intArr[0][0] = 1;
intArr[1][0] = 2;
intArr[2][0] = 3;
intArr[3][0] = 4;

for (int [] i: intArr) {
    System.out.println(java.util.Arrays.toString(i));
}
```

    [1, 0, 0, 0, 0, 0]
    [2, 0, 0, 0, 0, 0]
    [3, 0, 0, 0, 0, 0]
    [4, 0, 0, 0, 0, 0]





    null



You can of course use shorthand here too:


```Java
double [][] nestedDoubleArr = {{1.0D},{2.0D, 2.1D},{3.0D, 3.1D, 3.2D}};
for (double [] d: nestedDoubleArr) {
    System.out.println(java.util.Arrays.toString(d));
}
```

    [1.0]
    [2.0, 2.1]
    [3.0, 3.1, 3.2]





    null



You can also start by just declaring the first dimension of the array and then populate it with further arrays:


```Java
char [][] chArr = new char [2][];
chArr[0] = new char [2];
chArr[1] = new char [1];
chArr[0][0] = 'a';
chArr[0][1] = 'b';
chArr[1][0] = 'c';

for (char [] ch: chArr) {
    System.out.println(java.util.Arrays.toString(ch));
}
```

    [a, b]
    [c]





    null



## ArrayList
One of the problems with *arrays* is that you need to know at initialization-time how many elements your array will have and after that point it can't be changed. `ArrayList` attempts to rectify that, they can change size as needed. Like *arrays*, an *arralist* is an ordered sequence.

Since *ArrayList* is in the `java.util` package, we need to either import it or use it's fully qualified name. Creating an *ArrayList* is also different from creating *Arrays* in that you need to use the class name `ArrayList` to create it:


```Java
import java.util.ArrayList;

ArrayList myFirstAL = new ArrayList(); // creates an ArrayList of default size
ArrayList mySecondAL = new ArrayList(5); // creates an ArrayList for 5 however will expand as you add elements

System.out.println(myFirstAL.size());
System.out.println(mySecondAL.size());
```

    0
    0





    null



### Generics
Java 5 introduced the concept of *generics* which allows you to tell Java what type of class the ArrayList will contain. You declare the type by enclosing it within a *diamond-operator* (`<>`). The diamond operator should be present on both side of the equation but only needs to contain the *type* on the left hand side.


```Java
import java.util.ArrayList;

ArrayList <String> myStrAL = new ArrayList<>(); // declares an ArrayList of type String
ArrayList <Object> myObjAl = new ArrayList<Object>(); // declares an ArrayList of type Object
```




    null



### Creating a copy of an ArrayList
You can create a copy of an *ArrayList* by simply passing the ArrayList you want to copy as an argument to a new constructor:


```Java
import java.util.ArrayList;

ArrayList<String> alOriginal = new ArrayList<>();
ArrayList<String> alCopy = new ArrayList<>(alOriginal);
```




    null



### ArrayList implements List
ArrayList is an implementation of an *interface* called `List`. Essentially, this means that an ArrayList is a type of List with List being a *kind of* parent type. A knock-on effect of this is that you can store an *ArrayList* in a *List* reference variable but not the other way 'round.


```Java
import java.util.ArrayList;
import java.util.List;

List<String> l1 = new ArrayList<>(); // compiles
ArrayList<String> a1 = new List<>(); // does NOT compile
```


    java.util.List is abstract; cannot be instantiated

     ArrayList<String> a1 = new List<>()

                            ^           ^ 


### ArrayList methods and a note about `E`
Below are some common ArrayList methods. Note, that `E` in these examples is a placeholder meaning "any class this array can hold". So, if you specified that the ArrayList holds `String` then `E` will represent `String`. If you didn't specify a type then `E` will represent `Object`.

### `.add()` method
The `.add()` method inserts a new value into the *ArrayList*:
<br>`myArrayList.add(index [optional], itemToAdd);`

__NOTE__: `.add()` has two possible return types - `boolean` and `void`. If you exclude the index argument the method will return `true`. If you include an index, there will be no return value (i.e. `void`).


```Java
import java.util.ArrayList;

ArrayList<String> strAL = new ArrayList<>(); // create a String ArrayList

strAL.add("Pear"); // add the string 
System.out.println(strAL); // print AL

strAL.add(0, "Apple");
System.out.println(strAL);

ArrayList objAL = new ArrayList();
objAL.add(Boolean.TRUE);
System.out.println(objAL);

objAL.add(0, Boolean.FALSE);
System.out.println(objAL);
```

    [Pear]
    [Apple, Pear]
    [true]
    [false, true]





    null



### `.remove()` method
The `.remove()` method removes the first matching value in the ArrayList or at the specified index (if one is provided):
<br>`myArrayList.remove(index);` or `myArrayList.remove(object);`

__NOTE__: `.remove()` also has two possible return types - boolean (if the argument was an object, true meaning object remove, false meaning not) and `E` (representing whatever the element at the index passed was).


```Java
import java.util.ArrayList;

ArrayList <String> newAL = new ArrayList<>(); // create string arraylist
newAL.add("Purple"); // add some strings
newAL.add("Monkey");
newAL.add("Dishwasher");
System.out.println(newAL); // print populated al

boolean removedFromAL = newAL.remove("Monkey"); // remove string using object argument and save return value to variable
System.out.println(newAL); // print changed al
System.out.println(removedFromAL); // print variable

String removedStrFromAL = newAL.remove(1); // remove string using index argument and save return value to variable
System.out.println(newAL); // print changed al
System.out.println(removedStrFromAL); // print variable
```

    [Purple, Monkey, Dishwasher]
    [Purple, Dishwasher]
    true
    [Purple]
    Dishwasher





    null



### `.set() method`
The `.set()` method changes an element of the ArrayList without changing the size of the ArrayList and returns the element that was replaced.
<br>`set(index, newElement);`


```Java
import java.util.ArrayList;

ArrayList<String> sAL = new ArrayList<>();
sAL.add("John");
sAL.add("Paul");
sAL.add("George");
sAL.add("Pete");
System.out.println(sAL);

String fifthBeatle = sAL.set(3, "Ringo");
System.out.println(sAL);
System.out.println(fifthBeatle);
```

    [John, Paul, George, Pete]
    [John, Paul, George, Ringo]
    Pete





    null



### `.isEmpty()` and `.size()` methods
The `.isEmpty()` and `size()` methods both look at how many items are in the ArrayList and both do what they sound like:

`myArrayList.isEmpty()` will return `true` or `false` depending on whether or not the AL is empty.

`myArrayList.size()` will return the current size of the AL.


```Java
import java.util.ArrayList;

ArrayList <String> strAL = new ArrayList<>();
System.out.println("The arraylist is empty: " + strAL.isEmpty());
System.out.println("The arraylist has " + strAL.size() + " items in it.");

strAL.add("Cup");
System.out.println("The arraylist is empty: " + strAL.isEmpty());
System.out.println("The arraylist has " + strAL.size() + " items in it.");
strAL.add("Vase");
System.out.println("The arraylist has " + strAL.size() + " items in it.");
```

    The arraylist is empty: true
    The arraylist has 0 items in it.
    The arraylist is empty: false
    The arraylist has 1 items in it.
    The arraylist has 2 items in it.





    null



### `.clear()` method
The `clear()` takes no arguments and allows you to discard all elements in an ArrayList.


```Java
import java.util.ArrayList;

ArrayList<String> newAL = new ArrayList<>();
newAL.add("Hello");
newAL.add("World");
newAL.add("!!");
System.out.println(newAL);
newAL.clear();
System.out.println(newAL);

newAL.add("Foo");
System.out.println(newAL);
```

    [Hello, World, !!]
    []
    [Foo]





    null



### `.contains()` method
The `.contains()` method checks if a provided element is present in the ArrayList and returns a boolean.
<br>`arrayListToSearch.contains(elementToSearchFor);`


```Java
import java.util.ArrayList;

ArrayList<String> strAL = new ArrayList<>();
strAL.add("VHS");
strAL.add("Betamax");
strAL.add("DVD");
strAL.add("Laserdisk");

System.out.println(strAL.contains("VHS"));
System.out.println(strAL.contains("Blu-Ray"));
```

    true
    false





    null



### `equals()` method
The `.equals()` method allows you to compare to ArrayLists to see if they contain the same elements in the same order.


```Java
import java.util.ArrayList;

ArrayList<String> smartphoneMakers1 = new ArrayList<>();
smartphoneMakers1.add("Apple");
smartphoneMakers1.add("Huawei");
smartphoneMakers1.add("Nokia");
smartphoneMakers1.add("Samsung");
smartphoneMakers1.add("Sony");
smartphoneMakers1.add("Xiaomi");

ArrayList<String> smartphoneMakers2 = new ArrayList<>();
smartphoneMakers1.add("Nokia");
smartphoneMakers2.add("Apple");
smartphoneMakers2.add("Xiaomi");
smartphoneMakers2.add("Samsung");
smartphoneMakers2.add("Huawei");
smartphoneMakers2.add("Sony");


System.out.println(smartphoneMakers1.equals(smartphoneMakers2));
```

    false





    null



### Adding Primitives to an ArrayList
All primitive types have what's called a *wrapper class*, which is an object type that corresponds to the primitive. The wrapper classes have methods which allow you to convert object back to primitive such as `.parseInt()`.

Primitive|Wrapper class|Construction
:--|:--|:--
boolean|Boolean|`new Boolean(false);`
byte|Byte|`new Byte((byte) 2);`
short|Short|`new Short((short) 3);`
int|Integer|`new Integer(4);`
long|Long|`new Long(5);`
float|Float|`new Float(6.0);`
double|Double|`new Double(7.0)`
char|Character|`new Character('a');`


```Java
Integer five = new Integer(5);
System.out.println(five);
System.out.println(1+five);
```

    5
    6





    null



### Converting Strings
The following are common methods use to convert Strings to primitives and wrapper classes.

Wrapper class|String to Primitive|String to Wrapper
:--|:--|:--
Boolean|`Boolean.parseBoolean("false");`|`Boolean.valueOf("FALSE");`
Byte|`Byte.parseByte("2");`|`Byte.valueOf("2");`
Short|`Short.parseShort("3");`|`Short.valueOf("3");`
Integer|`Integer.parseInt("4");`|`Integer.valueOf("4");`
Long|`Long.parseLong("5");`|`Long.valueOf("5");`
Float|`Float.parseFloat("6.0");`|`Float.valueOf("6.0");`
Double|`Double.parseDouble("7.0");`|`Double.valueOf("7.0");`


## Autoboxing
*Autoboxing* is a feature introduced in Java 5 where the JVM will automatically convert a primitive to it's relevant wrapper class (and vice-versa) when used in a context where an object is expected rather than a primitive.


```Java
import java.util.ArrayList;

ArrayList<Object> myPrims = new ArrayList<>(); // create object arraylist
myPrims.add(7); // add integer value which Java will autoconvert to wrapper class object
myPrims.add(6.5); // add float value which Java will autoconvert to wrapper class object
for (Object o: myPrims) {
    System.out.println(o);
}
```

    7
    6.5





    null



## Converting Array to ArrayList and vice-versa
`ArrayList` includes a `.toArray()` method that allows you to convert to a standard array, however, it defaults to type `Object`. If you want to convert to a different type you can pass a wrapper class constructor to it.


```Java
import java.util.ArrayList;

ArrayList <String> strAL = new ArrayList<>();
strAL.add("Superman");
strAL.add("Batman");
strAL.add("Wonder Woman");
String [] justiceLeague = strAL.toArray(new String[0]);
System.out.println(justiceLeague.length);

ArrayList <Integer> intAL = new ArrayList<>();
intAL.add(4);
intAL.add(7);
Integer [] intArr = intAL.toArray(new Integer[0]);
System.out.println(intArr.length);
```

    3
    2





    null



Converting from `Array` to `List` can be done using the `.asList()` method, however, this creates a *fixed-size* List (known as a *backed-list*) which is linked to the original array. When a change is made to one it is also made to the other.


```Java
import java.util.Arrays;
import java.util.List;

String [] strArr = {"Butter", "Milk", "Cheese"};
List<String> strL = Arrays.asList(strArr);
System.out.println(strL);
System.out.println(Arrays.toString(strArr));
strL.set(1, "Soy");
System.out.println(strL);
System.out.println(Arrays.toString(strArr));
```

    [Butter, Milk, Cheese]
    [Butter, Milk, Cheese]
    [Butter, Soy, Cheese]
    [Butter, Soy, Cheese]





    null




```Java
import java.util.ArrayList;

ArrayList<String> al = new ArrayList<>();
ArrayList<String> al2 = new ArrayList<>();
al.add("Hello");
al.add("World");
al2.add("World");
al2.add("Hello");
System.out.println(al == al2);
```

    false





    null




```Java

```
