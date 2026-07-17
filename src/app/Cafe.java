package app;
import database.DatabaseConnection;
import input.ConsoleInputValidator;
import model.MenuItem;
import model.Order;

import java.util.ArrayList;
import java.util.Scanner;

public class Cafe {

  private final Scanner input = new Scanner(System.in);
  private final ConsoleInputValidator consoleInput = new ConsoleInputValidator(input);

  static ArrayList<MenuItem> listOfDrinks = new ArrayList<MenuItem>();
  static ArrayList<MenuItem> listOfSizes = new ArrayList<MenuItem>();
  public ArrayList<Order> listOfOrders = new ArrayList<Order>();
  String [] drink_names = {"Moonlight Latte", "Strawberry Cloud Matcha", "Starlight Hot Chocolate", "Vanilla Comet Cold Brew", "Lavendar Dream Tea"};
  double [] dirnk_prices = {5.50, 6.25, 4.75, 5.25, 4.50};
  String [] size_names = {"Small", "Medium", "Large"};
  double [] size_prices = {0.0, 0.75, 0.75};
  
  public Cafe() {
    initializeDrinkMenu();
    initializeSizeMenu();
  }

  /**  
  * This method creates a MenuItem with a drink_name and drink_price
  * and adds it to the listOfDrinks until all drinks on the menu are added.
  */
  public void initializeDrinkMenu() {
    for (int i = 0; i < drink_names.length; i++){
      //MenuItem newItem = new MenuItem(drink_names[i], dirnk_prices[i]);
      //listOfDrinks.add(newItem);
    }
  }

  /**
  * This method creates a MenuItem with a size and price (medium and large are an extra $0.75)
  * and adds it to the listOfSizes with small, medium, and large.
  */
  public void initializeSizeMenu() {
    for (int i = 0; i < size_names.length; i++){
      //MenuItem newSize = new MenuItem(size_names[i], size_prices[i]);
      //listOfSizes.add(newSize);
    }
  }

  /**
  * This method displays the main menu and reads the users choice, calling
  * calling the method that corresponds to their choice. It loops until
  * the cafe is closed.
  */
  public void runCafe() {
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
    int itemNumber = 1;
    for (int i = 0; i < listOfDrinks.size(); i++) {
      int amountOfDots = lineWidth - listOfDrinks.get(i).getItemName().length();
      System.out.printf(
        "%h %s %s $%.2f%n", itemNumber, listOfDrinks.get(i).getItemName(), ".".repeat(amountOfDots), listOfDrinks.get(i).getItemPrice()
      );
      itemNumber++;
    }
  }

  /**
   * Displays the size menu
   */
  public void displaySizes() {
    System.out.println("\nSIZES");
    int lineWidth = 25;
    int itemNumber = 1;
    for (int i = 0; i < listOfSizes.size(); i++) {
      int amountOfDots = lineWidth - listOfSizes.get(i).getItemName().length();
      System.out.printf(
        "%h %s %s $%.2f%n", itemNumber, listOfSizes.get(i).getItemName(), ".".repeat(amountOfDots), listOfSizes.get(i).getItemPrice()
      );
      itemNumber++;
    }
  }
}
