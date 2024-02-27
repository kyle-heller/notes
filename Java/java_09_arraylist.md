# Java's ArrayList
Java offers another way to store lists of related data called an `ArrayList`. It can store only objects (not primitives) and has a set of useful methods for manage its contents such as `add()`, `get()`, `indexOf()`, and more. Additionally you don't need to specify a size when you instantiate an ArrayList; as you add elements it will grow as needed.

## Using the `ArrayList` class
`ArrayList` exists in the `java.util` package. To use an `ArrayList` in your program you can either fully qualify it on each use:
<br>__`java.util.ArrayList`__ `myNewList;`

Or use an import statement at the top of your program so you can refer to it more succinctly throughout:
<br>__`import java.util.ArrayList;`__
<br>`public class ArrayListOne {`
<br>&nbsp;&nbsp;&nbsp;&nbsp;`public static void main(String [] args){`
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;__`ArrayList myNewArray;`__
<br>&nbsp;&nbsp;&nbsp;&nbsp;`}`
<br>`}`

## Declaring & Instantiating
Declaring and instantiating ArrayLists is the same as any other object.


```Java
// fully qualified
java.util.ArrayList myAList; // declaring variable myAList as an ArrayList
myAList = new java.util.ArrayList(); // populating the declared variable with a new instance of the ArrayList class
```




    null




```Java
// imported version
import java.util.ArrayList;

ArrayList newArrList; // declaring variable newArrList as an ArrayList type
newArrList = new ArrayList(); // populating the variable with a newly instantiated ArrayList object
```




    null



## Populating an ArrayList
There are several methods you can use to add, remove, and adjust ArrayList data.

### The `add()` method


```Java
import java.util.ArrayList;

ArrayList coolBandNames;
coolBandNames = new ArrayList();

coolBandNames.add("Wyld Stallyns");
coolBandNames.add("Gwar");

System.out.println(coolBandNames);

coolBandNames.add(0, "Slowburn"); // pass an index as first arg to insert at that position

System.out.println(coolBandNames);
```

    [Wyld Stallyns, Gwar]
    [Slowburn, Wyld Stallyns, Gwar]





    null



### The `remove()` method


```Java
java.util.ArrayList malInTheMiddle;
malInTheMiddle = new java.util.ArrayList();

malInTheMiddle.add("Hal");
malInTheMiddle.add("Lois");
malInTheMiddle.add("Francis");
malInTheMiddle.add("Reece");
malInTheMiddle.add("Malcolm");
malInTheMiddle.add("Dewey");

System.out.println(malInTheMiddle);

malInTheMiddle.remove("Francis"); // removes the named element
malInTheMiddle.remove(0); // removes the element at index 0

System.out.println(malInTheMiddle);
```

    [Hal, Lois, Francis, Reece, Malcolm, Dewey]
    [Lois, Reece, Malcolm, Dewey]





    null



### The `size()` method


```Java
import java.util.ArrayList;

ArrayList littlePiggies;
littlePiggies = new ArrayList();

littlePiggies.add("Market");
littlePiggies.add("Home");

System.out.println(littlePiggies.size());
```

    2





    null



### The `get()` method


```Java
java.util.ArrayList<String> pets = new java.util.ArrayList<String>();

pets.add("Dexter");
pets.add("Kolo");
pets.add("Shipsy");
pets.add("Harvey");
pets.add("Jessie");
pets.add("Tiny");

for (int i = 0; i < pets.size(); i++) {
    System.out.println(pets.get(i));
}
```

    Dexter
    Kolo
    Shipsy
    Harvey
    Jessie
    Tiny





    null



### The `contains()` method


```Java
import java.util.ArrayList;

ArrayList<String> enemies = new ArrayList<String>();

enemies.add("Superman");
enemies.add("Don in accounts payable");
enemies.add("Frank the barber");

if (enemies.contains("Superman")) {
    System.out.println("Lex Luthor!");
}
```

    Lex Luthor!





    null



## Primitives in an ArrayList
As mentioned, you can't store primitives in an ArrayList:
<br>`ArrayList grades;`
<br>`grades = new ArrayList();`
<br>`grades.add(75);` __this won't work__

However, you could do this:
<br>`grades.add(new Integer(75));`

## Declaring object types
You can specify the type of objects an ArrayList contains by using angled brackets. This is referred to as *generics*.


```Java
import java.util.ArrayList;

ArrayList <String> counties = new ArrayList();
counties.add("Dublin");
counties.add("Cork");
counties.add("Monaghan");
```




    null



## Calling methods on elements
As well as calling methods on an ArrayList itself, you can call methods on the elements within.

__NOTE__: in order to prevent an "unsafe or unchecked operations" warning when calling methods on elements you should declare the type (generic) during declaration/instantiation.


```Java
java.util.ArrayList<String> cereals = new java.util.ArrayList<String>();

cereals.add("Corn Flakes");
cereals.add("Eggos");
cereals.add("Golden Grahams");

System.out.println(cereals.get(2).length()); // prints the length of the element at index 2 (Golden Grahams)
```

    14





    null



## Using an iterator
To loop through an ArrayList's contents you can use a for loop but there's another option offered by Java. An __iterator__. Iterators act like a cursor in that when created the cursor is placed at the start of the ArrayList and as you loop through the cursor will be moved along.


```Java
import java.util.ArrayList;
import java.util.Iterator;

ArrayList<String> comicChar = new java.util.ArrayList<>();

comicChar.add("Spider-Man");
comicChar.add("Captain America");
comicChar.add("Punisher");
comicChar.add("Ghost Rider");

Iterator it = comicChar.iterator(); // create an iterator
while (it.hasNext()) { // use the hasNext method to determine if there's still items inside
    System.out.println(it.next()); // use the next method to get the next item
}
```

    Spider-Man
    Captain America
    Punisher
    Ghost Rider





    null




```Java

```
