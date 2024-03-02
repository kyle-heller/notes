public class Dog extends Pet {

  private double droolRate;
  private final double DEFAULT_DROOL_RATE = 5.0;

  Dog(String name, double health, int painLevel) {
    super(name, health, painLevel);
    this.setDroolRate(this.DEFAULT_DROOL_RATE);
  }

  Dog(String name, double health, int painLevel, double droolRate) {
    super(name, health, painLevel);
    this.setDroolRate(droolRate);
  }

  @Override
  int treat() {
    double treatmentTime = 0;
    int treatmentTimeRounded;
    this.heal();

    if (getDroolRate() < 3.5) {
      treatmentTime = (this.getPainLevel()*2)/this.getHealth();
    }

    else if (getDroolRate() >= 3.5 && getDroolRate() <= 7.5) {
      treatmentTime = this.getPainLevel()/this.getHealth();
    }
    
    else if (getDroolRate() > 7.5) {
      treatmentTime = this.getPainLevel()/(this.getHealth()*2);
    }

    treatmentTimeRounded = (int) Math.ceil(treatmentTime);
    return treatmentTimeRounded;
  }

  //     void speak():
//         Calls parent method
//         Prints “bark” number of times of the painLevel
//             e.g.: if painLevel = 3
//                 Prints “bark bark bark”
//         ALL UPPERCASE if painLevel is greater than 5, not inclusive

@Override
  void speak() {
    super.speak();
    int remainingPain = this.getPainLevel();

    if (this.getPainLevel() <= 5) {
      while (remainingPain > 0) {
        System.out.print("bark ");
        remainingPain--;
      }
    }
    else if (this.getPainLevel() > 5) {

      while (remainingPain > 0) {
        System.out.print("bark ");
        remainingPain--;
      }
    }
    System.out.println();
  }

  public boolean equals(Dog o) {
    if (super.equals(o)) {
      if (this.getDroolRate() == o.getDroolRate()) {
        return true;
      }
    }
    return false;
  }
  
  double getDroolRate() {
    return this.droolRate;
  }

    
  void setDroolRate(double newDroolRate) {
    this.droolRate = newDroolRate;
  }

  public static void main(String[] args) {
  }
}

