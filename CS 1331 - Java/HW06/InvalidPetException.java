public class InvalidPetException extends RuntimeException {

  // Default constructor with a default message
  public InvalidPetException() {
      super("Your pet is invalid!");
  }

  // Constructor with a custom message
  public InvalidPetException(String message) {
      super(message);
  }

  public static void main(String[] args) {
  }
}