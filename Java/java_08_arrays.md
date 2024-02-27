# Creating and using arrays
Arrays are containers of sequential related data. For example you can have an array of `int`s, an array of `string`s, an array of object references. The length of an array is established at creation and fixed from that point on (i.e. you can't change it once created).

Each item in an array is *indexed* meaning you can access using a reference to its index. __NOTE__: arrays are zero indexed, so the first item is at index `0`, the second at index `1`, and so on.

Arrays are handled by an *implicit* `Array` object which isn't available in the Java API. As with any object you need to declare a referecem instantiate, and then initialise an Array object before you can use it.

## Declaring
The syntax to create a one-dimensional array is:
<br>`type [] array_identifier;`


```Java
String [] myStringArray;
```




    null



## Instantiating
Before you can initialise an array, you need to instantiate an `Array` object large enough to hold the values. To do so you define the number of elements in the array:
<br>`array_identifier = new type [lenght];`


```Java
String [] myStringArray;
myStringArray = new String [4];
```




    null



## Populating
After instantiation each element of the array is initialised with whatever the zero or null value for that primitive type is. For example, an array of `int` would have each element set to `0`, an array of object references would have each set to `null`. You can populate an array with data after creation using the following syntax:
<br>`myIntArray[0] = 52;`
<br>`myIntArray[1] = 7;`
<br>`myIntArray[2] = 824;`
<br>`myIntArray[3] = 19;`


```Java
String [] myStringArray;
myStringArray = new String [3];
myStringArray[0] = "Hello";
myStringArray[1] = "World";
myStringArray[2] = "!";
```




    null



## Declaring, instantiating, and populating all at once
If you know what you want in your array when you're creating it, you can declare, instantiate, and fill it all together using this syntax:
<br>`type [] array_identifer = {values};`


```Java
String [] myStringArray = {"Hello", "World", "!"};
```




    null



## Accessing array items
You can access array items in the same way you set them; using indices:
<br>`String myFirstEl = myStringArray[0];`


```Java
String [] myStringArray;
myStringArray = new String [3];
myStringArray[0] = "Hello";
myStringArray[1] = "World";
myStringArray[2] = "!";
System.out.println(myStringArray[0]);
```

    Hello





    null



## Array primitives are stored differently to a primitive
Arrays are objects referred to by an object reference variable. This means that the way a primitive array is stored in memory differs from the way a primitive data type is stored. Consider the following code:
<br>`char size = 'L';`
<br>`char [] sizes = {'S', 'M', 'L'};`

The value of the `size` is a `char`: `L`. Whereas the value of `sizes` is `0x334009` (which is an address in memory) that points to an object of type `array of char` with three values. The value of `sizes[0]` is the `char`:`S`, the value of `sizes[1]` is the `char`:`M` and so on.

## The `args` array
When you pass strings to a progam on the command line, the strings are put in the `args` array. To use these strings, you must extract them from the args array and, optionally, convert them to their proper type (because the args array is of type `String`).
<br>
<br>`>java ArgsTest Hello World!`
<br>`args[0] is Hello`
<br>`args[1] is World!`

## Array length
You can determine the number of items in an array using the `[array_name].length` property.
<br>`myStringArray.length`


```Java
String [] myStringArray;
myStringArray = new String [3];
myStringArray[0] = "Hello";
myStringArray[1] = "World";
myStringArray[2] = "!";
System.out.println(myStringArray[0]);
System.out.println(myStringArray.length);
```

    Hello
    3





    null


