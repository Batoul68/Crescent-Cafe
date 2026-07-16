import java.util.Scanner;

// This class will validate all console input from the user
public class ConsoleInputValidator {
  private final Scanner scanner;

  public ConsoleInputValidator(Scanner scanner){
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

  /**
  * Continuously prompt the user, calling readNonBlankString(), until user inputs
  * a non blank string with valid characters. Cleans the name before returning it.
  *
  *  @param prompt message displayed to user
  *  @return validated and clean name
  */
 public String readName(String prompt) {
  while (true) {
    String name = readNonBlankString(prompt);

    if (name.matches("[\\p{L} '-]+")) {
      return (name.substring(0,1).toUpperCase().concat(name.substring(1,name.length()).toLowerCase()));
    }

    System.out.println("Please only use letters, spaces, apostrophes, and hyphens");
  }
 }

  /**
  * Continuously prompt the user until user inputs a non blank string.
  * Return the non blank input.
  *
  *  @param prompt message displayed to user
  *  @return non blank input
  */
 public String readNonBlankString(String prompt) {
  while (true) {
    System.out.print(prompt);
    String text = scanner.nextLine().trim();

    if (!text.isBlank()) {
      return text;
    }

    System.out.println("You can't leave this blank!");
  }
 }
}
