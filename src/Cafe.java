import java.util.ArrayList;
import java.util.Scanner;
public class Cafe {

  static ArrayList<MenuItem> listOfDrinks = new ArrayList<MenuItem>();
  static ArrayList<MenuItem> listOfSizes = new ArrayList<MenuItem>();
  public ArrayList<Order> listOfOrders = new ArrayList<Order>();
  String [] drink_names = {"Moonlight Latte", "Strawberry Cloud Matcha", "Starlight Hot Chocolate", "Vanilla Comet Cold Brew", "Lavendar Dream Tea"};
  double [] dirnk_prices = {5.50, 6.25, 4.75, 5.25, 4.50};
  String [] size_names = {"small", "medium", "large"};
  double [] size_prices = {0.0, 0.75, 0.75};
  private final Scanner input = new Scanner(System.in);
  
  public Cafe() {
    initializeDrinkMenu();
    initializeSizeMenu();
  }

  /*        initializeDrinkMenu       
  * This method creates a MenuItem with a drink_name and drink_price
  * and adds it to the listOfDrinks until all drinks on the menu are added.
  *
  * @param - void
  * return - void
  */
  public void initializeDrinkMenu() {
    for (int i = 0; i < drink_names.length; i++){
      MenuItem newItem = new MenuItem(drink_names[i], dirnk_prices[i]);
      listOfDrinks.add(newItem);
    }
  }

  /*        initializeSizeMenu       *
  * This method creates a MenuItem with a size and price (medium and large are an extra $0.75)
  * and adds it to the listOfSizes with small, medium, and large.
  *
  * @param - void
  * return - void
  */
  public void initializeSizeMenu() {
    for (int i = 0; i < size_names.length; i++){
      MenuItem newSize = new MenuItem(size_names[i], size_prices[i]);
      listOfSizes.add(newSize);
    }
  }

   /*        runCafe       *
  * This method displays the main menu and reads the users choice, calling
  * calling the method that corresponds to their choice. It loops until
  * the cafe is closed.
  *
  * @param - void
  * return - void
  */
  public void runCafe() {
    int userChoice;
    boolean open = true;

    do {
      displayMenu();
      System.out.print("Select a menu item: ");

      do {
        while(!input.hasNextInt()) {
          System.out.print("Invalid, please enter a number: ");
          input.next();
        }

        userChoice = input.nextInt(); 
        input.nextLine();

        if (userChoice <= 0) {
          System.out.print("Invalid, please enter a number greater than 0: ");
        }
      } while(userChoice<= 0);
      
      switch(userChoice) {
        case 1: 
          createOrder();
          break;
        //case 2: 
          //closeCafe();
          //open = false;
          //break;
        default:
          System.out.println("That's not a menu option, please enter a valid item! ~");
          break;
      }
    } while (open);
  }

  /*        createOrder       *
  * This method gathers user info to create an Order object. The order is added to a
  * listOfOrders and the receipt is displayed.
  *
  * @param - void
  * return - void
  */
  public void createOrder() {
    displayCreateOrder();

    String customer_name = promptName();
    System.out.println(customer_name);
    //int drink_selection = promptDrink();
    //int size_selection = promptSize();
   
    //make newOrder Order object with info
    //add newOrder to list of Orders
    //newOrder.displayReceipt
  }


  public void displayMenu() {
    displayLines();
    // try to get it to support these characters:.✦ ݁˖ ☾res☾ent ☾afé .✦ ݁˖
    System.out.println("Cresecent Café");
    displayLines();
    System.out.println("1. Place a new order\n2. Close the café");
  }

  public void displayLines() {
    System.out.println("==============================");
  }

  public void displayCreateOrder() {
    displayLines();
    System.out.println("CREATE NEW ORDER");
    displayLines();
  }
/* 
  public void displayDrinks() {
    //display drinks
  }

  public void displaySizes() {
    //display sizes
  }
  */

  /*        getName       *
  * This method prompts the user for their name and validates the input, then cleans it.
  *
  * @param - void
  * return - String
  */

  public String promptName() {
    System.out.print("What's the name for the order?: ");
    while(true) {
      String name = input.nextLine().trim();

      if (!name.matches("[\\p{L} '-]+")) {
        System.out.print("Invalid, only use letters, spaces, apostrophes, or hyphens: ");
      }
      else if (name.length() < 3) {
        System.out.print("Invalid, please enter a name that is at least 3 letters: ");
      }
      else{
        return (name.substring(0,1).toUpperCase().concat(name.substring(1,name.length()).toLowerCase()));
      }
    }
  }
/* 
  public int promptDrink() {
    //validate user input and return the menu number for the drink (should correspond with position in list of MenuItems (drinks))
  }

  public int promptSize() {
    //validate user input and return the menu number for the size (should correspond with position in list of MenuItems (sizes))
  }
  */
  
}
