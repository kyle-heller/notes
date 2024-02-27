# Interfaces

## What is an interface?
An interface is essentially an outline of a class with only abstract/default behaviours/methods. Think of it like a blueprint for a blueprint. 

Lets imagine I want various buildings created on my land and I intend to leave the details of what constitutes each building to whichever team is assigned to build it. I could create a rough structure of what a basic building is:
- Each building must have a roof
- Each building must have at least one entrance
- Each building must have at least four windows

Now that I have my outline, I create three different teams:
1. a *home* team to create a building to live in
2. a *shop* team to create a building for the sale of goods
3. a *storage* team to create a building for storage

I give each of these teams my very basic blueprint from which they will create their own detailed blueprints which meet the requirements of my original but add more features.

## Creating an interface
Lets create a simple interface as outlined above. Note how the methods declared have no curly braces.


```Java
package test.beaker;

// create my interface
public interface Building {
    public boolean hasWindows = true;
    
    public void enter();
    
    public void exit();
} // END interface
```




    test.beaker.Building



## Implementing classes from an interface
Now lets use that interface to __implement__ some classes using the `implement` keyword.


```Java
package test.beaker;

public class Home implements Building {
    public int numWindows = 8;
    
    public void enter() {
        System.out.println("Enter through the hall door.");
    } // END enter
    
    public void exit() {
        System.out.println("Exit through back door.");
    } // END exit
} // END home
```




    test.beaker.Home




```Java
package test.beaker;

public class Shop implements Building {
    public int numWindows = 6;
    
    public void enter() {
        System.out.println("Enter through front door.");
    } // END enter
    
    public void exit() {
        System.out.println("Exit through rear cargo door. Exit through side fire door in emergencies.");
    } // END exit
} // END shop
```




    test.beaker.Shop




```Java
package test.beaker;

public class StorageShed implements Building {
    public int numWindows = 4;
    
    public void enter() {
        System.out.println("Enter through front double doors");
    } // END enter
    
    public void exit() {
        System.out.println("Exit through front double doors, rear fire escape, or side entry.");
    } // END exit
} // END storageshed
```




    test.beaker.StorageShed




```Java
package test.beaker;

Home myHouse = new Home();
Shop myShop = new Shop();
StorageShed myShed = new StorageShed();

myHouse.enter();
myHouse.exit();

myShop.enter();
myShop.exit();

myShed.enter();
myShed.exit();
```

    Enter through the hall door.
    Exit through back door.
    Enter through front door.
    Exit through rear cargo door. Exit through side fire door in emergencies.
    Enter through front double doors
    Exit through front double doors, rear fire escape, or side entry.





    null




```Java

```
