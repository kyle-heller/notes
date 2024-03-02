public class Gameplay {
    
  public static void main(String[] args) {
    
    // Create a BlueAstronaut with the following fields:
    // - name = “Bob”, susLevel = 20, numTasks = 6, taskSpeed = 30
    BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);

    // Create a BlueAstronaut with the following fields:
    // - name = “Heath”, susLevel = 30, numTasks = 3, taskSpeed = 21
    BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 21);

    // Create a BlueAstronaut with the following fields:
    // - name = “Albert”, susLevel = 44, numTasks = 2, taskSpeed = 0
    BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);

    // Create a BlueAstronaut with the following fields:
    // - name = “Angel”, susLevel = 0, numTasks = 1, taskSpeed = 0
    BlueAstronaut angel = new BlueAstronaut("Angel", 0, 1, 0);

    // Create a RedAstronaut with the following fields:
    // - name = “Liam”, susLevel = 19, skill = "experienced"
    RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");

    // Create a RedAstronaut with the following fields:
    // - name = “Suspicious Person”, susLevel = 100, skill = "expert"
    RedAstronaut suspicious_Person = new RedAstronaut("Suspicious Person", 100, "expert");
  
    // Have the objects do the following:

    // 1. Have RedAstronaut Liam sabotage BlueAstronaut Bob. After the sabotage:
    liam.sabotage(bob);
    //    - Bob should have: susLevel = 30, frozen = false
    System.out.println(bob);

    // 2. Have RedAstronaut Liam freeze RedAstronaut Suspicious Person:
    System.out.println(suspicious_Person);
    liam.freeze(suspicious_Person);

    //    - Nothing should happen
    System.out.println(suspicious_Person);


    // 3. Have RedAstronaut Liam freeze BlueAstronaut Albert. After the freeze:
    liam.freeze(albert);
  
    //    - Liam should have: susLevel = 19
    //    - Albert is now frozen
    System.out.println(liam);
    System.out.println(albert);

    // 4. Have BlueAstronaut Albert call an emergency meeting:
    albert.emergencyMeeting();

    //    - Nothing should happen since he is frozen

    // 5. Have RedAstronaut Suspicious Person call an emergency meeting:
    suspicious_Person.emergencyMeeting();
    //    - This will result in a tie between Bob and Heath, so nothing should happen

    // 6. Have BlueAstronaut Bob call an emergency meeting:
    bob.emergencyMeeting();
    //    - Suspicious Person should have: frozen = true
    System.out.println(suspicious_Person);

    // 7. Have BlueAstronaut Heath complete tasks:
    heath.completeTask();

    //    - Heath should have: numTasks = 1
    System.out.println(heath);

    // 8. Have BlueAstronaut Heath complete tasks:
    heath.completeTask();

    //    - “I have completed all my tasks” should be printed to console
    //    - Heath should have: numTasks = 0, susLevel = 15
    System.out.println(heath);


    // 9. Have BlueAstronaut Heath complete tasks:
    heath.completeTask();

    //    - Nothing should happen

    // 10. Have RedAstronaut Liam freeze Angel:
    liam.freeze(angel);

    //     - Angel should have: frozen = false
    //     - Liam should have: susLevel = 38
    System.out.println(angel);
    System.out.println(liam);

    // 11. Have RedAstronaut Liam sabotage Bob twice:
    System.out.println(bob);
    liam.sabotage(bob);
    System.out.println(bob);
    liam.sabotage(bob);
    
    //     - Bob should have: susLevel = 46 (30 -> 37 -> 46)
    System.out.println(bob);


    // 12. Have RedAstronaut Liam freeze Bob:
    //     - Bob should have: frozen = true
    liam.freeze(bob);
    System.out.println(bob);

    // Now there are two options going forward:

    // // - Option 1

    // //   - Have BlueAstronaut Angel call emergency meeting:
    // angel.emergencyMeeting();
    // //     - Liam should have: frozen = true
    // System.out.println(liam);
    // //     - “Crewmates win!” should be printed to console

    // - Option 2
    //   - Have RedAstronaut Liam call sabotage on Heath 5 times:
    System.out.println(heath);
    liam.sabotage(heath);
    System.out.println(heath);
    liam.sabotage(heath);
    System.out.println(heath);
    liam.sabotage(heath);
    System.out.println(heath);
    liam.sabotage(heath);
    System.out.println(heath);
    liam.sabotage(heath);

    //     - Heath should have: susLevel = 41 (15->18->22->27->33->41)
    System.out.println(heath);


    //   - Have RedAstronaut Liam freeze Heath:
    liam.freeze(heath);
    //     - Heath should have: frozen = true
    System.out.println(heath);
    //     - “Impostors win!” should be printed to console


  }
}