public class BlueAstronaut extends Player implements Crewmate {
private int numTasks;
private int taskSpeed;

  public BlueAstronaut(String name) {
    super(name, 15);
    this.numTasks = 6;
    this.taskSpeed = 10;
  }
  public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
    super(name, susLevel);
    this.numTasks = numTasks;
    this.taskSpeed = taskSpeed;

  }
  private void emergencyMeeting() {
    if (this.isFrozen()) {
        // A frozen player cannot call an emergency meeting
        break;
    }

    Player[] players = getPlayers();

    if (players.length == 0) {
        // No players in the game, nothing to vote off
        return;
    }

    // Initialize mostSus to the first non-frozen player
    Player mostSus = null;
    for (int i = 0; i < players.length; i++) {
        if (!players[i].isFrozen()) {
            mostSus = players[i];
            break;
        }
    }

    // Iterate through the players array to find the most suspicious player
    for (int i = 0; i < players.length; i++) {
        if (!players[i].isFrozen() && players[i].getSusLevel() > mostSus.getSusLevel()) {
            mostSus = players[i];
        }
    }

    // Check if there are multiple players with the same highest susLevel
    boolean multipleHighestSus = false;
    for (int i = 0; i < players.length; i++) {
        if (!players[i].isFrozen() && players[i].getSusLevel() == mostSus.getSusLevel() && players[i] != mostSus) {
            multipleHighestSus = true;
            break;
        }
    }

    // Vote off (freeze) the most suspicious player if there is a clear choice
    if (!multipleHighestSus && mostSus != this) {
        mostSus.setFrozen(true);
    }

    // Check if the game is over
    if (gameOver()) {
    }
}



    // - A Player that is frozen cannot call an emergency meeting.
    // - Holds a meeting and votes out (freezes) the most suspicious individual of the Player objects, only considering Players that are not frozen
    //   - The player that has the highest susLevel will be accused of being the impostor and will be voted off (This could be them!)
    //   - If two players have the same highest susLevel, no player will be voted off.
    //   - Hint: think of an easy way to do this without having to iterate through the entire array. Check the Java API for Arrays for a method you can use.
    // - Make sure to change the frozen variable of the player to true when voting off players (don’t call freeze!)
    // - At the end of the vote, check if the game is over using the provided method in Player.java
    // - Does not return anything

  public void completeTask() {

    if (this.isFrozen() == true) {
    }
    else if (this.getTaskSpeed() > 20 && this.numTasks != 0) {
      this.setNumTasks(getNumTasks() - 2);
      if (this.numTasks < 0) {
        System.out.println("I have completed all my tasks");
        this.setSusLevel((int)(this.getSusLevel()*.5));
      }
    }
    else if (this.numTasks != 0) {
      this.setNumTasks(this.getNumTasks() - 1);
      if (this.numTasks < 0) {
        System.out.println("I have completed all my tasks");
        this.setSusLevel((int)(this.getSusLevel()*.5));
      }
    }
    if (this.numTasks < 0) {
      this.setNumTasks(0);
    } 
    return;

    // - A BlueAstronaut that is frozen cannot complete tasks.
    // - If taskSpeed is greater than 20, subtract 2 from numTasks. Otherwise, subtract 1 from numTasks.
    //   - If numTasks falls below 0, set it to 0
    // - After BlueAstronaut is done with their tasks, meaning numTasks is equal to 0 (only for the first time),
    //   - Print out “I have completed all my tasks”
    //   - Then reduce BlueAstronaut’s susLevel by 50% (round down)
    // - Does not return anything.
  }

  @Override
  public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
  
      BlueAstronaut other = (BlueAstronaut) obj;
  
      return this.getName().equals(other.getName()) &&
             this.isFrozen() == other.isFrozen() &&
             this.getSusLevel() == other.getSusLevel() &&
             this.numTasks == other.numTasks &&
             this.taskSpeed == other.taskSpeed;
  }


  public int getTaskSpeed() {
    return taskSpeed;
  }

  public void setNumTasks(int num) {
    this.numTasks = num;
    return;
  }

  public int getNumTasks() {
    return this.numTasks;
  }

  public String toString() {

    String string = super.toString() + String.format(" I have %d tasks left over.", this.numTasks);
    if (super.getSusLevel() > 15) {
      return string.toUpperCase();
    }
    return string;
  }

}