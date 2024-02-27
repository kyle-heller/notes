# Encapsulation
## What is encapsulation
Encapsulation is an object-oriented concept which states that classes shouldn't expose their internal workings to external users to minimize the chances of bad (or malicious) data being introduced. Rather classes should hide their workings behind a public interface which allows users to interact with the class in approved ways. To do this we can use the `private` keyword:
<br>
<br>`private String secretWord = "marshmallow";`


```Java
package beaker.test;

public class Student {
    private int studentID = 325761;
    private double annualFee = 2167.44;
    private boolean isPaid = false;
} // END student
```




    beaker.test.Student




```Java
package beaker.test;

Student neal = new Student();

neal.isPaid = true; // will raise an error because isPaid is a private variable
```


    isPaid has private access in beaker.test.Student

     neal.isPaid = true

     ^          ^        


## Getters and Setters
In many cases you may want users to be able to see or use `private` variables/methods but not change them. To do this we can use *getter* and *setter* methods with the `this` keyword.


```Java
package beaker.test;

public class Student {
    private int studentID = 123456;
    private double annualFee = 2167.44;
    private boolean isPaid = false;
    private String studentDOB = "June 4th 1988";
    
    // getter methods
    public double getFee() { // public because we want users to be able to use this method
        return this.annualFee; // use the THIS keyword to tell Java to access the property on the object instance which calls it
    } // END getFee
    
    public String getDOB() {
        return this.studentDOB;
    } // END getDOB
    
    // setter methods
    public void setDOB(String date) {
        this.studentDOB = date;
    } // END setDOB
} // END student
```




    beaker.test.Student




```Java
package beaker.test;

Student neal = new Student();

System.out.println("Fee due: €" + neal.getFee());
System.out.println("Student Date of Birth: " + neal.getDOB());
neal.setDOB("March 6th 1985");
System.out.println("Student Date of Birth: " + neal.getDOB());
```

    Fee due: €2167.44
    Student Date of Birth: June 4th 1988
    Student Date of Birth: March 6th 1985





    null




```Java

```
