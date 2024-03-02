public abstract class Pet {

  String name;
  double health;
      // A percentage value ranging from 0.0 to 1.0
  int painLevel;
      // Ranges from 1 to 10

      public Pet(String name, double health, int painLevel) {
        this.name = name;
        if (health > 1.0){
          this.health = 1.0;
        } else if (health < 0.0) {
          this.health = 0.0;
        }

        if (painLevel > 10){
          this.health = 10;
        } else if (health < 1) {
          this.health = 1;
        }
        
      }


    protected void heal() {
      this.setHealth(1);
      this.setPainLevel(1);
    }
    public boolean equals(Pet o) {
      if (this.getName() == o.getName()) {
      return true;
      }
      else {
        return false;
      }
    }

    void speak() {
      String string = "Hello! My name is " + this.getName();
      if (painLevel > 5) {
        System.out.println(string.toUpperCase());
      }
      else {
        System.out.println(string);
      }
    }

    abstract int treat();

    String getName() {
      return this.name;
    }

    double getHealth() {
      return this.health;
    }

    int getPainLevel() {
      return this.painLevel;
    }

    void setHealth(double newHealth) {
      this.health = newHealth;
    }

    void setPainLevel(int newPainLevel) {
      this.painLevel = newPainLevel;
    }

    public static void main(String[] args) {
    }
}
