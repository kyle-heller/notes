# Constructors

## What is a constructor?
A constructor is a method for instantiating objects. We've seen this before when using the `new` keyword to instantiate an object:
<br>`Car ford = new Car("blue");`

In the above example we tell Java that we're calling a constructor method by using the `new` keyword and telling it what constructor by calling the class name with parentheses. The word "blue" within the parentheses is an argument being passed to the constructor. In order to do this the constructor would need to be capable of accepting arguments. In this scenario we can imagine that the `Car()` constructor has been written to accept a *colour* parameter with which to set the instance colour of the object it creates.

## Specifying a constructor
Java includes a default constructor in any class but we can explicitly define a constructor ourselves by calling the class name (with parentheses) within the class definition. You can combine this with use of the `this` keyword to set properties on any instances that will be created.

Lets create a book class:


```Java
package test.beaker;

public class Book {
    // create instance variables
    private String title;
    private String author;
    private int numPages;
    private String language;
    private float price;
    private boolean inPrint;
    private String releaseDate;
    private String genre;
    
    // create constructor method
    public Book(String title, String author, int numPages, String language, float price, boolean inPrint, String releaseDate, String genre) {
        this.title = title;
        this.author = author;
        this.numPages = numPages;
        this.language = language;
        this.price = price;
        this.inPrint = inPrint;
        this.releaseDate = releaseDate;
        this.genre = genre;
    } // END constructor
    
    // getter methods
    public String getTitle() {
        return this.title;
    } // END getTitle
    
    public String getAuthor() {
        return this.author;
    } // END getAuthor
    
    public int getNumPages() {
        return this.numPages;
    } // END getNumPages
    
    public String getLanguage() {
        return this.language;
    } // END getLanguage
    
    public float getPrice() {
        return this.price;
    } // END getPrice
    
    public boolean getInPrint() {
        return this.inPrint;
    } // END getInPrint
    
    public String getReleaseDate() {
        return this.releaseDate;
    } // END getReleaseDate
    
    public String getGenre() {
        return this.genre;
    } // END getGenre
    
    // setter methods
    public void setTitle(String title) {
        this.title = title;
    } // END setTitle
    
    public void setAuthor(String fullname) {
        this.author = fullname;
    } // END setAuthor
    
    public void setNumPages(int num) {
        this.numPages = num;
    } // END setNumPages
    
    public void setLanguage(String lang) {
        this.language = lang;
    } // END setLanguage
    
    public void setPrice(float price) {
        this.price = price;
    } // END setPrice
    
    public void setInPrint(boolean inPrint) {
        this.inPrint = inPrint;
    } // END setInPrint
    
    public void setReleaseDate(String date) {
        this.releaseDate = date;
    } // END setReleaseDate
    
    public void setGenre(String genre) {
        this.genre = genre;
    } // END setGenre
    
    public String toString() {
        return "Title: " + this.title
            + "\nAuthor: " + this.author
            + "\nNo. of Pages: " + this.numPages
            + "\nLanguage: " + this.language
            + "\nPrice: " + this.price
            + "\nIs in Print: " + this.inPrint
            + "\nRelease Date: " + this.releaseDate
            + "\nGenre: " + this.genre;
    } // END toString
    
} // END book
```




    test.beaker.Book



Now lets instantiate some books:


```Java
package test.beaker;

Book boysLife = new Book("Boys Life","Rober R McCammon",581,"English",10.99f,true,"Mar 23rd 1991","Mystery");
System.out.println(boysLife.toString());
```

    Title: Boys Life
    Author: Rober R McCammon
    No. of Pages: 581
    Language: English
    Price: 10.99
    Is in Print: true
    Release Date: Mar 23rd 1991
    Genre: Mystery





    null



If you've explictly created a constructor which expects arguments, then trying to use it without passing any will cause an error:


```Java
package test.beaker;

Book twilight = new Book();
```


    constructor Book in class test.beaker.Book cannot be applied to given types;

      required: java.lang.String,java.lang.String,int,java.lang.String,float,boolean,java.lang.String,java.lang.String

      found: no arguments

      reason: actual and formal argument lists differ in length

     Book twilight = new Book()

                     ^         ^ 


## Implicit constructor calls
When an object is created from a class, that class' constructor is invoked along with the constructor of every superclass above it in the chain/hierarchy. If you don't specify a constructor in your class Java will invoke the default constructor without any arguments.

### Important concepts
1. The first line of a constructor must be either a call to a `super` constructor or a call to an __overloaded__ constructor in the current class using the `this` keyword
2. You cannot include *both* a call to the `super` constructor AND a call to an overloaded `this` constructor.
3. If a class has no defined parent, then its parent is the Java `Object` class and the `Object` constructor is called


```Java
package test.beaker;

public class Comic extends Book {
    private String publisher;
    private String hero;
    
    // constructor
    public Comic(String title, String author, int numPages, String lang, float price, boolean inPrint, String releaseDate, String genre, String publisher, String hero) {
        super(title, author, numPages, lang, price, inPrint, releaseDate, genre);
        this.publisher = publisher;
        this.hero = hero;
    } 
    
    public String toString() {
        return super.toString() 
            + "\nPublisher: " + this.publisher 
            + "\nHero: " + this.hero;
    }
    
} // END comic
```




    test.beaker.Comic




```Java
package test.beaker;

Comic batmanHush = new Comic("Hush", "Jeff Loeb, Jim Lee", 200, "English", 21.99f, true, "Spring 2002", "Superhero", "DC", "Batman");

System.out.println(batmanHush.toString());
```

    Title: Hush
    Author: Jeff Loeb, Jim Lee
    No. of Pages: 200
    Language: English
    Price: 21.99
    Is in Print: true
    Release Date: Spring 2002
    Genre: Superhero
    Publisher: DC
    Hero: Batman





    null




```Java

```
