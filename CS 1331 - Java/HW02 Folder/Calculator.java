
import java.util.Scanner;

class Calculator {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    
    Scanner scanner = new Scanner(System.in);

    System.out.println("Add, Subtract, Multiply, Divide, or Alphabetize?");
    System.out.print("Enter your operation: ");
    String userInput = scanner.nextLine().toUpperCase();


    switch (userInput) {
      case "ADD":
        try {
        System.out.println("Enter two numbers to add:");
        String addNumber1 = scanner.next();
        String addNumber2 = scanner.next();
        int addInt1 = Integer.parseInt(addNumber1);
        int addInt2 = Integer.parseInt(addNumber2);
        System.out.println((addInt1 + addInt2) + "\n");

        }
        catch (NumberFormatException eInt) {
          System.out.println("Invalid input entered. Terminating...\n");
          break;
        }
                    break;
      case "SUBTRACT":
        System.out.println("Enter two numbers to subtract:");
        String subNumber1 = scanner.next();
        String subNumber2 = scanner.next();    

        int subInt1 = Integer.parseInt(subNumber1);
        int subInt2 = Integer.parseInt(subNumber2);
        System.out.println((subInt1 - subInt2) + "\n");
        break;
      case "MULTIPLY":
        System.out.println("Enter two numbers to multiply:");
          String multNumber1 = scanner.next();
          String multNumber2 = scanner.next();

        double multDouble1 = Double.parseDouble(multNumber1);
        double multDouble2 = Double.parseDouble(multNumber2);
        System.out.printf("%.2f\n", (multDouble1 * multDouble2));
        

        break;
      case "DIVIDE":
        System.out.println("Enter two numbers to divide:");
        String divNumber1 = scanner.next();
        String divNumber2 = scanner.next();

        double divDouble1 = Double.parseDouble(divNumber1);
        double divDouble2 = Double.parseDouble(divNumber2);
        if (divDouble2 != 0) {
        System.out.printf("%.2f\n", (divDouble1 / divDouble2));
        }
        else {
        break;
        }

        break;
      case "ALPHABATIZE":
        System.out.println("Enter two words:");
        String word1 = scanner.next();
        String word2 = scanner.next();
        
        String word1Standardized = word1.toLowerCase();
        String word2Standardized = word2.toLowerCase();

        int result = word1Standardized.compareTo(word2Standardized);
        if (result < 0) {
          System.out.println(word1 + " comes before " + word2 + " alphabetically.\n");
        }
        else if (result > 0) {
          System.out.println(word2 + " comes before " + word1 + " alphabetically.\n");
            }
        else {
          System.out.println("Chicken or Egg.\n");
        }
            

          
        break;
        default:
        System.out.println("Invalid input entered. Terminating...\n");
    }
      
  }
}

