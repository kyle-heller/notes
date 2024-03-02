
public class Fly {
  private double mass;
  private double speed;
  
  public Fly() {
    this(5.0, 10.0);
  }

  public Fly(double userMass) {
    this(userMass, 10.0);
  }

  public Fly(double userMass, double userSpeed) {
    this.mass = userMass;
    this.speed = userSpeed;
  }

  public String toString() {
    if (mass == 0) {
        return String.format("I’m dead, but I used to be a fly with a speed of %.2f.", speed);
    } else {
        return String.format("I’m a speedy fly with %.2f speed and %.2f mass.", speed, mass);
    }
}

// grow - takes in an integer parameter representing the added 
// mass. Then it increases the mass of the Fly by the given number of mass. 
// As mass increases, speed changes as follows:
//         If mass is less than 20: increases speed by 1 for 
//         every mass the Fly grows until it reaches 20 mass.
//         If the mass is 20 or more: decreases speed by 0.5 
//         for each mass unit added over 20.

 
  public void grow(int increasedMass) {
    
    do {
    if (mass < 20 && increasedMass!= 0) {

      this.mass += 1;
      this.speed +=1;
      increasedMass -= 1;

    }
    else if (mass >= 20 && increasedMass!= 0) {
      this.mass += 1;
      this.speed -= 0.5;
      increasedMass -= 1;
    }
  } while (increasedMass > 0);
      
  }


  // public void grow(int months) {
  //   // Calculate the remaining months until the Frog reaches 12 months
  //   int remainingMonths = Math.max(0, 12 - age);
  //   int monthsToAdd = Math.min(months, remainingMonths);

  //   age += months;
  //   tongueSpeed += monthsToAdd;
  
  //   // Decrease tongueSpeed by 1 for every month beyond 30 months
  //   if (age >= 30) {
  //       System.out.println(tongueSpeed);
  //       tongueSpeed -= months;
  //       System.out.println(tongueSpeed);

  //       // Ensure tongueSpeed is not less than 5
  //       if (tongueSpeed < 5) {
  //           tongueSpeed = 5;
  //       }
  //   }

  public boolean isDead() {
    return (mass == 0) ? true : false;
  }

  public double getMass() {
    return mass;
  }

  public double getSpeed() {
    return speed;
  }

  public void setMass(double userMass) {
    mass = userMass;
  }

  public void setSpeed(double userSpeed) {
    speed = userSpeed;
  }


  

  public static void main(String[] args) {

    Fly fly1 = new Fly(10.0, 50.0);
    System.out.println(fly1.toString());
    fly1.grow(45);
    System.out.println(fly1.toString());

    Fly fly2 = new Fly(20.0, 1.0);
    System.out.println(fly2.toString());
    fly2.grow(0);
    System.out.println(fly2.toString());


  }


}
