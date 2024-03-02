public class RedAstronaut extends Player implements Impostor {

  private String skill;

  public RedAstronaut(String name) {
    super(name, 15);
    this.skill = "experienced";
  }
  public RedAstronaut(String name, int susLevel, String skill) {
    super(name, susLevel);
    this.skill = skill;
  }
  
@Override
  public void emergencyMeeting() {//**
    // - A Player that is frozen cannot call an emergency meeting.
    // - Holds a meeting and votes out (freezes) the most suspicious Player, only considering Players that are not frozen
    //   - The player that has the highest susLevel (that is NOT the current impostor calling the meeting) will be accused of being the impostor and will be voted off
    //   - If two players have the same highest susLevel, no player will be voted off.
    //   - Hint: think of an easy way to do this without having to iterate through the entire array. Check the Java API for Arrays for a method you can use
    // - Make sure to change the frozen variable of the player to true when voting off players (don’t call the freeze method!)
    // - At the end of the vote, check if the game is over using the provided method in Player.java
    // - Does not return anything
  }

  public void freeze(Player p) {

    if (p.isFrozen() == true || this.isFrozen() == true) {
      return;
    } else if (p instanceof RedAstronaut) {
      return;
    } else if (this.getSusLevel() < p.getSusLevel()) {
      p.setFrozen(true);
    }
      else if (this.getSusLevel() > p.getSusLevel()) {
        this.setSusLevel(this.getSusLevel() * 2);
      }
      else {
        return;
      }
      if (gameOver()) {
      }
    // - Implements the method provided in the Impostor interface.
    // - It is not possible to freeze another Impostor, and an
    // - Impostor that is frozen cannot attempt to freeze. If the passed in Player is an Impostor, 
    // the method should end. Freezing an already frozen Player should also do nothing. - A freeze is 
    // successful if the RedAstronaut’s susLevel is less than the Player’s - If the freeze is 
    // unsuccessful, the RedAstronaut’s susLevel doubles (multiply the current susLevel by 2) - 
    // Remember to change the frozen boolean value for the Crewmate as needed. - After the freeze 
    // attempt, check if the game is over using the provided method in Player.java - Does not return 
    // anything
  
  }

  public void sabotage(Player p) {
    if (this.isFrozen() == true) {
      return;
    } else if (p.isFrozen() == true) {
      return;
    } else {
        if (this.getSusLevel() < 20) {
          p.setSusLevel((int)((p.getSusLevel()) + (p.getSusLevel() * .5)));
        }
        else {
          p.setSusLevel((int)((p.getSusLevel()) + (p.getSusLevel() * .25)));
        }
    }
  //   - `sabotage(Player p)`
  // - It is not possible to sabotage another Impostor, and an Impostor that is frozen cannot sabotage. Also, sabotaging a frozen Player should do nothing.
  // - If the Impostor’s susLevel is under 20, through shifty maneuvers and cunning words, they are able to increase the Crewmate’s susLevel by 50%
  // - Otherwise, they can only manage to increase the Crewmate’s susLevel by 25%
  // - (Note: In both cases, the the Crewmate’s susLevel is rounded down to the nearest int value)
  // - Does not return anything
  }

  @Override
  public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
  
      RedAstronaut other = (RedAstronaut) obj;
  
      return this.getName().equals(other.getName()) &&
             this.isFrozen() == other.isFrozen() &&
             this.getSusLevel() == other.getSusLevel() &&
             this.skill.equals(other.skill);
  }

  public String toString() {

    String string = super.toString() + String.format(" I am an %s player!", this.skill);
    if (super.getSusLevel() > 15) {
      return string.toUpperCase();
    }
    return string;
  }


  public static void main(String[] args) {

  }
}