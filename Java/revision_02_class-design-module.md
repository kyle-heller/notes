## Casting an object to it's parent-class type doesn't change the object's type (just the reference type)
If you have two classes, *Parent* and *Child*, and *Child* overrides a method inherited from *Parent*, calling that method from a Child object which has been cast as a Parent reference type will still output the Child version of the method.

When you cast the *Child* object and assign to a *Parent* reference you don't actually change the type of the object, you just tell Java you want to treat it like a *Parent* object. However, the internal implementation of the object remains intact. So Java will look at the reference and check if the method you're trying to call exists in the parent, it does so it allows the object to execute the method, but the object's version of the method is still the overridden one.


```Java
package test.beaker;

class Parent {
    public boolean returnsBool() { // parent's returnsBool method returns 'true'
        return true;
    }
    
    public void strPrint(String str) {
        System.out.println(str);
    }
}

class Child extends Parent {
    @Override
    public boolean returnsBool() { // child overrides returnsBool method to return false
        return false;
    }
    
    public void newStrPrint(String str) {
        System.out.println(str);
    }
}
```




    test.beaker.Parent




```Java
package test.beaker;

Parent p = (Parent) new Child(); // create a new Child object and assign it to a Parent type reference
System.out.println(p.returnsBool()); // calling the returnsBool method calls the Child class' overridden version despite the reference being of type Parent
p.strPrint("Foo");
```

    false
    Foo





    null



## A `null` value can always be passed as an object value regardless of type
If you call a method which expects an Object parameter, you can pass `null` without running into any compile errors. However you may get a runtime error depending on what action the method tries to take using the passed in `null`.


```Java
package test.beaker;

class Foo {
    public static void checkClass(Object o) {
        System.out.println(o.getClass());
    }
}
```




    test.beaker.Foo




```Java
package test.beaker;

Foo.isInstanceOfObject(null);
```


    cannot find symbol

      symbol:   method isInstanceOfObject(<nulltype>)

      location: class test.beaker.Foo

     Foo.isInstanceOfObject(null)

     ^                     ^       


## Variables can never be abstract
You may see a simple seeming question which asks what modifiers do interface *variables* have, take note that the question is __VARIABLES__ not methods. Interface methods are assumed to be `public` but can also be `default`, `abstract`, and `static`. Interface *variables* can only be `public static` and `final`.

## Abstract classes can `implement` Interfaces without implementing the methods therein
It's easy to think that any time you see `implements` before an Interface that all of the Interface's non-default methods must be implemented but remember Abstract classes can implement an Interface while leaving the methods `abstract` and thus the first concrete class that `extends` the abstract class must implement the methods.

## Return types are only co-variant if the overriding method's return type is a *subclass* of the parent method
So, the return type must be the same or a subclass of the return type from the original method NOT a superclass.

## For overriding non-private methods in a parent class both must be `static` or neither should be
To override a non-private method either both should be `static` in which case you're __hiding__ rather than *overriding*, or NEITHER should be static (in which case you'd be *overriding*).

## A `static` method in an interface must have a method body
Any interface method declared as `static` must have a method body.

## Calling a hidden method depends on the reference
This is a little like the inverse of the rule at the top of this sheet where a calling an overridden method on a child object which has been cast to it's parent type will call the overridden version (despite the reference being to the parent, which holds the original version of the method).

In the case of *hidden* methods, the choice of which method is run depends on where it is referenced.


```Java

```
