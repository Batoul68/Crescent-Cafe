import java.util.Scanner;

// This class will validate all console input from the user
public class ConsoleInput {
  private final Scanner scanner;

  public ConsoleInput(Scanner scanner){
    this.scanner = scanner;
  }

  /**
  * Continuously prompt user for a number until it is a valid whole number
  * and within the target range.
  *
  *  @param prompt message displayed to user
  *  @param min minimum accepted value
  *  @param max maximum accepted value
  *  @return validated number
  */
 public int readIntInRange(String prompt, int min, int max) {
  while (true) {
    System.out.print(prompt);
    String userInput = scanner.nextLine().trim();

    try {
      int number = Integer.parseInt(userInput);

      if (number >= min && number <= max) {
        return number;
      }

      System.out.printf("Out of bounds! Please enter a number from %d to %d.%n", min, max);

    } catch (NumberFormatException e) {
      System.out.println("Please enter a whole number");
    }
  }
 }


}
