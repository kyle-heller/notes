public class Cat extends Pet {

  private int miceCaught;
  private final int DEFAULT_MICE_CAUGHT = 0;

  Cat(String name, double health, int painLevel) {
    super(name, health, painLevel);
    this.setMiceCaught(this.DEFAULT_MICE_CAUGHT);
  }

  Cat(String name, double health, int painLevel, int miceCaught) {
    super(name, health, painLevel);
    if (miceCaught < 0) {
      this.setMiceCaught(this.DEFAULT_MICE_CAUGHT);
    }
    else {
    this.setMiceCaught(miceCaught);
    }
  }

  int treat() {
    double treatmentTime = 0;
    int treatmentTimeRounded;
    this.heal();

    if (getMiceCaught() < 4) {
      treatmentTime = (this.getPainLevel()*2)/this.getHealth();
    }

    else if (getMiceCaught() >= 4 && getMiceCaught() <= 7) {
      treatmentTime = this.getPainLevel()/this.getHealth();
    }
    
    else if (getMiceCaught() > 7) {
      treatmentTime = this.getPainLevel()/(this.getHealth()*2);
    }

    treatmentTimeRounded = (int) Math.ceil(treatmentTime);
    return treatmentTimeRounded;
  }
  
  int getMiceCaught() {
    return miceCaught;
  }

  void setMiceCaught(int newMiceCaught) {
    this.miceCaught = newMiceCaught;
  }

  @Override
  void speak() {
    super.speak();
    int remainingPain = this.getPainLevel();

    if (this.getPainLevel() <= 5) {
      while (remainingPain > 0) {
        System.out.print("meow ");
        remainingPain--;
      }
    }
    else if (this.getPainLevel() > 5) {

      while (remainingPain > 0) {
        System.out.print("meow ");
        remainingPain--;
      }
    }
    System.out.println();
  }

  public boolean equals(Cat o) {
    if (super.equals(o)) {
      if (this.getMiceCaught() == o.getMiceCaught()) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
  }

}
