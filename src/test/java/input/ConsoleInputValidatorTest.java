package input;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ConsoleInputValidatorTest {
  
  // readIntInRange() tests
  @Test
  void readIntInRangeReturnsValidNumber() {
    Scanner scanner = new Scanner("3");
    ConsoleInputValidator validator = new ConsoleInputValidator(scanner);

    int result = validator.readIntInRange("Choose an option: ", 1, 5);

    assertEquals(3, result);
  }

  @Test
  void readIntInRangeAcceptsMinimum() {
    Scanner scanner = new Scanner("1");
    ConsoleInputValidator validator = new ConsoleInputValidator(scanner);

    int result = validator.readIntInRange("Choose an option: ", 1, 5);

    assertEquals(1, result);
  }

  @Test
  void readIntInRangeAcceptsMaximum() {
    Scanner scanner = new Scanner("5");
    ConsoleInputValidator validator = new ConsoleInputValidator(scanner);

    int result = validator.readIntInRange("Choose an option: ", 1, 5);

    assertEquals(5, result);
  }

  @Test
  void readIntInRangeRetriesNonnumericInput() {
    Scanner scanner = new Scanner("hello\n2");
    ConsoleInputValidator validator = new ConsoleInputValidator(scanner);

    int result = validator.readIntInRange("Choose an option: ", 1, 5);

    assertEquals(2, result);
  }

  @Test
  void readIntInRangeRetriesInputBelowRange() {
    Scanner scanner = new Scanner("0\n2");
    ConsoleInputValidator validator = new ConsoleInputValidator(scanner);

    int result = validator.readIntInRange("Choose an option: ", 1, 5);

    assertEquals(2, result);
  }

  @Test
  void readIntInRangeRetriesInputAboveRange() {
    Scanner scanner = new Scanner("6\n2");
    ConsoleInputValidator validator = new ConsoleInputValidator(scanner);

    int result = validator.readIntInRange("Choose an option: ", 1, 5);

    assertEquals(2, result);
  }

  @Test
  void readIntInRangeRetriesMultipleInvalidInputs() {
    Scanner scanner = new Scanner("-4\nnot a number\n10\n2");
    ConsoleInputValidator validator = new ConsoleInputValidator(scanner);

    int result = validator.readIntInRange("Choose an option: ", 1, 5);

    assertEquals(2, result);
  }

  // readNonBlankString() tests
  @Test
  void readNonBlankStringReturnsValidString() {
    Scanner scanner = new Scanner("Word");
    ConsoleInputValidator validator = new ConsoleInputValidator(scanner);

    String word = validator.readNonBlankString("Enter a string: ");

    assertEquals("Word", word);
  }

  @Test
  void readNonBlankStringRetriesAfterEmptyLine() {
    Scanner scanner = new Scanner("\nWord");
    ConsoleInputValidator validator = new ConsoleInputValidator(scanner);

    String word = validator.readNonBlankString("Enter a string: ");

    assertEquals("Word", word);
  }

  @Test
  void readNonBlankStringRemovesWhitespace() {
    Scanner scanner = new Scanner("          Word           ");
    ConsoleInputValidator validator = new ConsoleInputValidator(scanner);

    String word = validator.readNonBlankString("Enter a string: ");

    assertEquals("Word", word);
  }

  // readName() tests
  @Test
  void readNameReturnsValidName() {
    Scanner scanner = new Scanner("Rachel");
    ConsoleInputValidator validator = new ConsoleInputValidator(scanner);

    String name = validator.readName("Enter a name: ");

    assertEquals("Rachel", name);
  }

  @Test
  void readNameAcceptsNameWithSpace() {
    Scanner scanner = new Scanner("Mary Anne");
    ConsoleInputValidator validator = new ConsoleInputValidator(scanner);

    String name = validator.readName("Enter a name: ");

    assertEquals("Mary anne", name);
  }

  @Test
  void readNameAcceptsNameWithApostrophe() {
    Scanner scanner = new Scanner("O'connor");
    ConsoleInputValidator validator = new ConsoleInputValidator(scanner);

    String name = validator.readName("Enter a name: ");

    assertEquals("O'connor", name);
  }

  @Test
  void readNameAcceptsNameWithHyphen() {
    Scanner scanner = new Scanner("Mary-Beth");
    ConsoleInputValidator validator = new ConsoleInputValidator(scanner);

    String name = validator.readName("Enter a name: ");

    assertEquals("Mary-beth", name);
  }

  @Test
  void readNameRetriesInputWithNumbers() {
    Scanner scanner = new Scanner("Rachel123\nRachel");
    ConsoleInputValidator validator = new ConsoleInputValidator(scanner);

    String name = validator.readName("Enter a name: ");

    assertEquals("Rachel", name);
  }

  @Test
  void readNameRetriesInputWithUnsupportedSymbols() {
    Scanner scanner = new Scanner("Ra#chel\n$%$\nRachel");
    ConsoleInputValidator validator = new ConsoleInputValidator(scanner);

    String name = validator.readName("Enter a name: ");

    assertEquals("Rachel", name);
  }
}
