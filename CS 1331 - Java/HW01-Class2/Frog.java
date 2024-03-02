
public class Frog {

private String name;
private int age;
private double tongueSpeed;
private boolean isFroglet;
private static String species = "Rare Pepe";


  public Frog(String name) {
  this(name, 5, 5.0);
  }

  public Frog(String name, double ageInYears, double tongueSpeed) {
    this(name, (int)(ageInYears*12), tongueSpeed);
  }
  public Frog(String name, int age, double tongueSpeed) {
    this.name = name;
    this.age = age;
    this.tongueSpeed = tongueSpeed;
    isFroglet = (age > 1 && age < 7) ? true : false;
  }

  // grow - takes in a whole number parameter representing the number of months.
  // Then it ages the Frog by the given number of months and increases 
  // tongueSpeed by 1 for every month the Frog grows until it becomes 12 months old.
  // If the Frog is 30 months old or more, then decrease tongueSpeed by 
  // 1 for every month that it ages beyond 30 months.
  // You must not decrease tongueSpeed to less than 5.
  // Remember to update isFroglet accordingly

// grow - takes in no parameters and ages the Frog by one month and updates tongueSpeed 
// accordingly as for the other grow method

  public void grow() {

    this.grow(1);
  }

  public void grow(int months) {
    do {
      if (age < 12 && months!= 0) {
  
        this.age += 1;
        months -= 1;
        this.tongueSpeed += 1.0;
  
      } else if (age >= 12 && age < 30 && months != 0){
        this.age += 1;
        months -= 1;

      } else if (age >= 30 && months != 0) {
        this.tongueSpeed -= 1.0;
        this.age += 1;
        months -= 1;

      }
      if (tongueSpeed < 5) {
        tongueSpeed = 5;
      }
    } while (months > 0);

    isFroglet = (age > 1 && age < 7);
    }

// old version
  // public void grow(int months) {
  //   // Calculate the remaining months until the Frog reaches 12 months
  //   int remainingMonths = Math.max(0, 12 - age);
  //   int monthsToAdd = Math.min(months, remainingMonths);


  //   age += months;
  //   tongueSpeed += monthsToAdd;
  //   System.out.println(tongueSpeed);
  //   System.out.println(age);
  
  //   // Decrease tongueSpeed by 1 for every month beyond 30 months
  //   if (age >= 30) {
  //       tongueSpeed -= months;

  //       // Ensure tongueSpeed is not less than 5
  //       if (tongueSpeed < 5) {
  //           tongueSpeed = 5;
  //       }
  //   }

    // Failed: Frog had initial age 25 and initial tongue speed 30. 
    // It was grown by 10 months and did not have proper final tongue speed.
    // expected:<25> but was:<20>

    // Update isFroglet accordingly
//     isFroglet = (age > 1 && age < 7);
// }


  public void eat(Fly fly) {
    if (fly.isDead() == true) {
      return;
    }
    else if (this.tongueSpeed >= fly.getSpeed()) {
      if (fly.getMass() <= (0.5 * this.age)) {
        this.grow();
        fly.setMass(0.0);
      }
      else {
        fly.setMass(0.0);
      }
    }
    else {
      fly.grow(1);
    }

  }


  public String toString() {
    if (this.isFroglet) {
        return String.format("My name is %s and I’m a rare froglet! I’m %d months old and my tongue has a speed of %.2f.",
                              this.name, this.age, this.tongueSpeed);
    } else {
        return String.format("My name is %s and I’m a rare frog. I’m %d months old and my tongue has a speed of %.2f.",
                              this.name, this.age, this.tongueSpeed);
    }
}

public static void setSpecies(String newSpecies) {
  species = newSpecies;
}

public static String getSpecies() {
  return species;
}

  public static void main(String[] args) {

    // Frog frog1 = new Frog("Coop", 59, 5);
    // System.out.println(frog1);
    // frog1.grow(8);
    // System.out.println(frog1);
  }
}


// Failed: Frog had initial age 59 and initial tongue speed 5. It was grown by 8 months and did not have proper final tongue speed.
// expected:<5> but was:<-3>
    // Failed: Frog had initial age 25 and initial tongue speed 30. 
    // It was grown by 10 months and did not have proper final tongue speed.

    // expected:<25> but was:<20>


