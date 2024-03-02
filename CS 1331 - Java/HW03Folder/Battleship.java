import java.util.Scanner;

public class Battleship {

    public static void main(String[] args) {
        
        System.out.println("Welcome to Battleship!\n");

    char[][] player1targethistory = getPlayer1Coords();
    char[][] player2targethistory = getPlayer2Coords();

    boolean game_won = false;
      
    do {
    player2targethistory = player1TakeAim(player2targethistory);
    if (checkWin(player2targethistory) == true) {
      System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
      break;
    }
    player1targethistory = player2TakeAim(player1targethistory);
    if (checkWin(player1targethistory) == true) {
      System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
      break;
    }
    } while (game_won == false);

    System.out.println("\nFinal boards:\n");
    printBattleShip(player1targethistory);
    System.out.println();
    printBattleShip(player2targethistory);
    
    }
    
    // Use this method to print game boards to the console.
    private static void printBattleShip(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");
        }
    }
    
        private static void printBattleShip2(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");
        }
    }
    
      private static char[][] newBoard() {

    char[][] matrix = new char[5][5];

    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            matrix[i][j] = '-';
        }
    }
    return matrix;
  }

  private static int[] getInput() {

    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int[] array = new int[2];
    array[0] = a;
    array[1] = b;

    return array;
  }


    private static char[][] getPlayer1Coords() {
    //Prompt player 1 to enter coordinates for five ships of length one. If the coordinate is good add ship to the 2d array as @ symbol
    char[][] matrix = newBoard();
    int i = 1;
    System.out.println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.");
    do {
      System.out.println("Enter ship " + (i) +  " location:");
      int[] input;
      input = getInput();

      if ((input[0] >= 5 || input[0] < 0 || input[1] >= 5 || input[1] < 0)) {
            System.out.println("Invalid coordinates. Choose different coordinates.");
        }
        else if ((matrix[input[0]][input[1]] == '@') && (input[0] < 5) && (input[1] < 5)) {
            System.out.println("You already have a ship there. Choose different coordinates.");
        } else if ((matrix[input[0]][input[1]] == '-') && (i != 6)) {
            matrix[input[0]][input[1]] = '@';
            if (i !=4) {
            }
          i++;
        } else {
          break;
        }
    } while (i < 6);

    printBattleShip(matrix);
      
    for (int b = 0; b < 100; b++) {
        System.out.println();
    }

    return matrix;
    }

    private static char[][] getPlayer2Coords() {
    //Prompt player 2 to enter coordinates for five ships of length one. If the coordinate is good add ship to the 2d array as @ symbol
    char[][] matrix = newBoard();
    int i = 1;
    System.out.println("PLAYER 2, ENTER YOUR SHIPS' COORDINATES.");
    do {
      System.out.println("Enter ship " + (i) +  " location:");
      int[] input;
      input = getInput();

      if ((input[0] >= 5 || input[0] < 0 || input[1] >= 5 || input[1] < 0)) {
            System.out.println("Invalid coordinates. Choose different coordinates.");
        }
        else if ((matrix[input[0]][input[1]] == '@') && (input[0] < 5) && (input[1] < 5)) {
            System.out.println("You already have a ship there. Choose different coordinates.");
        } else if ((matrix[input[0]][input[1]] == '-') && (i != 6)) {
            matrix[input[0]][input[1]] = '@';
            if (i !=4) {
            }
          i++;
        } else {
          break;
        }
    } while (i < 6);

    printBattleShip(matrix);
      
    for (int b = 0; b < 100; b++) {
        System.out.println();
    }

    return matrix;
    }

  


  private static char[][] player1TakeAim(char[][] targethistory) {
    
    boolean incorrect = false;
    System.out.println("Player 1, enter hit row/column:");


      do {
      int[] input;
      input = getInput();
      if ((input[0] >= 5 || input[0] < 0 || input[1] >= 5 || input[1] < 0)) {
            System.out.println("Invalid coordinates. Choose different coordinates.");
            System.out.println("Player 1, enter hit row/column:");
            incorrect = true;
        }
        else if ((targethistory[input[0]][input[1]] == '@') && (input[0] < 5) && (input[1] < 5)) {
            targethistory[input[0]][input[1]] = 'X';
            System.out.println("PLAYER 1 HIT PLAYER 2's SHIP!");
            if (checkWin(targethistory) == true) {
                printBattleShip2(replaceChar(targethistory));
                incorrect = false; 
            } else {
            printBattleShip(replaceChar(targethistory));
          System.out.println();
                incorrect = false;
            }
        } else if (targethistory[input[0]][input[1]] == '-') {
            targethistory[input[0]][input[1]] = 'O';
            System.out.println("PLAYER 1 MISSED!");
            printBattleShip(replaceChar(targethistory));
            System.out.println();
            incorrect = false;
        } else if (targethistory[input[0]][input[1]] == 'X') {
            System.out.println("You already fired on this spot. Choose different coordinates.");
            System.out.println("Player 1, enter hit row/column:");
            incorrect = true;
        } else {
            System.out.println("You already fired on this spot. Choose different coordinates.");
            System.out.println("Player 1, enter hit row/column:");
            incorrect = true;
        }
      } while (incorrect == true);

    return targethistory;
  }


  private static boolean checkWin(char[][] targethistory) {
        for (int i = 0; i < targethistory.length; i++) {
            for (int j = 0; j < targethistory[i].length; j++) {
                if (targethistory[i][j] == '@') {
                    return false; 
                }
            }
        }
        return true;
    }
  private static char[][] player2TakeAim(char[][] targethistory) {

    boolean incorrect = false;
    System.out.println("Player 2, enter hit row/column:");
      do {
      int[] input;
      input = getInput();
      if ((input[0] >= 5 || input[0] < 0 || input[1] >= 5 || input[1] < 0)) {
            System.out.println("Invalid coordinates. Choose different coordinates.");
            System.out.println("Player 2, enter hit row/column:");
            incorrect = true;
        }
        else if ((targethistory[input[0]][input[1]] == '@') && (input[0] < 5) && (input[1] < 5)) {
            targethistory[input[0]][input[1]] = 'X';
            System.out.println("PLAYER 2 HIT PLAYER 1's SHIP!");
            if (checkWin(targethistory) == true) {
                printBattleShip2(replaceChar(targethistory));
                incorrect = false;
            } else {
                printBattleShip(replaceChar(targethistory));
                System.out.println();
                incorrect = false;
            }
        } else if (targethistory[input[0]][input[1]] == '-') {
            targethistory[input[0]][input[1]] = 'O';
            System.out.println("PLAYER 2 MISSED!");
            printBattleShip(replaceChar(targethistory));
            System.out.println();
            incorrect = false;
        } else if (targethistory[input[0]][input[1]] == 'X') {
            System.out.println("You already fired on this spot. Choose different coordinates.");
            System.out.println("Player 2, enter hit row/column:");
            incorrect = true;
        } else {
            System.out.println("You already fired on this spot. Choose different coordinates.");
            System.out.println("Player 2, enter hit row/column:");
            incorrect = true;
        }
      } while (incorrect == true);

    return targethistory;
  }
    
    public static char[][] replaceChar(char[][] array) {
        int rows = array.length;
        int cols = array[0].length;

        char[][] newarray = new char[rows][];

        for (int i = 0; i < rows; i++) {
            newarray[i] = array[i].clone();
        }

        for (char[] row : newarray) {
            for (int j = 0; j < row.length; j++) {
                if (row[j] == '@') {
                    row[j] = '-';
                }
            }
        }

        return newarray;
    }
}







 