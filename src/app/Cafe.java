package app;
import database.DatabaseConnection;
import database.MenuRepository;
import input.ConsoleInputValidator;
import model.MenuItem;
import model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cafe {

  private final Scanner input = new Scanner(System.in);
  private final ConsoleInputValidator consoleInput = new ConsoleInputValidator(input);

  private List<MenuItem> listOfDrinks;
  private List<MenuItem> listOfSizes;
  private List<Order> listOfOrders;
  
  public Cafe() {
    listOfDrinks = new ArrayList<>();
    listOfSizes = new ArrayList<>();
    listOfOrders = new ArrayList<>();
  }

 /**
  * This method loads the drinks and sizes from a database into ArrayLists 
  * and checks if the lists are empty or not, making sure the database has
  * data in it
  * 
  * @return if the lists are empty or not
  */
  private boolean loadMenu() {
    MenuRepository menuRepository = new MenuRepository();

    listOfDrinks = menuRepository.getAllDrinks();
    listOfSizes = menuRepository.getAllSizes();

    if (listOfDrinks.isEmpty()) {
      System.out.println("No drinks are available at this time!");
      return false;
    }

    if (listOfSizes.isEmpty()) {
      System.out.println("No drink sizes are available at this time.");
      return false;
    }

    return true;
 }

  /**
  * This method displays the main menu and reads the users choice, calling
  * calling the method that corresponds to their choice. It loops until
  * the cafe is closed.
  */
  public void runCafe() {
    if (!loadMenu()){
      System.out.println("Cafe is sold out today! Please come again tomorrow.");
      return;
    }
    
    int userChoice;
    boolean open = true;

    do {
      displayMenu();
      userChoice = consoleInput.readIntInRange("\nSelect a menu item: ",1 , 2);
      
      switch(userChoice) {
        case 1: 
          createOrder();
          break;
        case 2: 
          System.out.println("\nCafe is now closed, thank you for coming in today!\n");
          open = false;
          break;
        default:
          System.out.println("That's not a menu option, please enter a valid item! ~");
          break;
      }
    } while (open);
  }

  /**
  * This method gathers user info to create an Order object. The order is added to a
  * listOfOrders and the receipt is displayed.
  */
  public void createOrder() {
    displayCreateOrder();

    String customerName = promptName();
    System.out.println("\nWelcome to Crescent Café " + customerName + "!"); 

    displayDrinks();
    int drinkSelection = promptDrink();

    displaySizes();
    int sizeSelection = promptSize();

    Order newOrder = new Order(customerName, listOfDrinks.get(drinkSelection-1), listOfSizes.get(sizeSelection-1));
    listOfOrders.add(newOrder);

    System.out.println("\n");
    displayReceiptTitle();
    newOrder.displayReceipt();
    System.out.println("\n");
    displayLines();
    System.out.println("\nYour order is being prepared!\n");
   
    //make newOrder Order object with info
    //add newOrder to list of Orders
    //newOrder.displayReceipt
  }

  /**
  * This method prompts the user for their name and sends it to ConsoleInputValidator, returning
  * a clean and valid name.
  *
  * @return validated and cleaned name
  */
  public String promptName() {
    String name = consoleInput.readName("\nWhat's the name for the order?: ");
    return name;
  }

  /**
  * This method prompts the user for their drink choice and sends it to ConsoleInputValidator, 
  * returning a valid number.
  *
  * @return validated drink selection
  */
  public int promptDrink() {
    int drink = consoleInput.readIntInRange("\nWhich drink would you like?: ", 1, 5);
    return drink;
  }

  /**
  * This method prompts the user for their size choice and sends it to ConsoleInputValidator, 
  * returning a valid number.
  *
  * @return validated size selection
  */
  public int promptSize() {
    int size = consoleInput.readIntInRange("\nSelect a drink size: ",1, 3);
    return size;
  }

  /**
   * Displays main menu
   */
  public void displayMenu() {
    displayLines();
    // try to get it to support these characters:.✦ ݁˖ ☾res☾ent ☾afé .✦ ݁˖
    System.out.println("\tCresecent Café");
    displayLines();
    System.out.println("1. Place a new order\n2. Close the café");
  }

  /**
   * Displays equal signs to make things prettier
   */
  public void displayLines() {
    System.out.println("=================================");
  }

  /**
   * Displays a sign when creating a new order
   */
  public void displayCreateOrder() {
    displayLines();
    System.out.println("\tCREATE NEW ORDER");
    displayLines();
  }

  /**
   * Displays a sign for the receipt
   */
  public void displayReceiptTitle() {
    displayLines();
    System.out.println("\tCRESCENT CAFÉ RECEIPT");
  }

  /**
   * Displays the drink menu
   */
  public void displayDrinks() {
    System.out.println("\nDRINK MENU");

    int lineWidth = 25;

    for (int i = 0; i < listOfDrinks.size(); i++) {
      int totalDots = lineWidth - listOfDrinks.get(i).getItemName().length();

      System.out.printf(
        "%d %s %s $%.2f%n",
        listOfDrinks.get(i).getItemId(),
        listOfDrinks.get(i).getItemName(),
         ".".repeat(totalDots), 
        listOfDrinks.get(i).getItemPrice()
      );
    }
  }

  /**
   * Displays the size menu
   */
  public void displaySizes() {
    System.out.println("\nSIZES");

    int lineWidth = 25;

    for (int i = 0; i < listOfSizes.size(); i++) {
      int totalDots = lineWidth - listOfSizes.get(i).getItemName().length();

      System.out.printf(
        "%d %s %s $%.2f%n",
        listOfSizes.get(i).getItemId(),
        listOfSizes.get(i).getItemName(),
         ".".repeat(totalDots), 
        listOfSizes.get(i).getItemPrice()
      );
    }
  }
}
