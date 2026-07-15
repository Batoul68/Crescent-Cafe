import java.util.ArrayList;
import java.util.List;
public class Cafe {

  // Variable declarations
  static ArrayList<MenuItem> listOfDrinks = new ArrayList<MenuItem>();
  static ArrayList<MenuItem> listOfSizes = new ArrayList<MenuItem>();
  public ArrayList<Order> listOfOrders = new ArrayList<Order>();
  String customer_name;
  int drink_selection;
  int size_selection;
  String [] drink_names = {"Moonlight Latte", "Strawberry Cloud Matcha", "Starlight Hot Chocolate", "Vanilla Comet Cold Brew", "Lavendar Dream Tea"};
  double [] dirnk_prices = {5.50, 6.25, 4.75, 5.25, 4.50};
  String [] size_names = {"small", "medium", "large"};
  double [] size_prices = {0.0, 0.75, 0.75};
  
  public Cafe() {
    initializeDrinkMenu();
    initializeSizeMenu();
  }

  /*        initializeDrinkMenu       *
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
/* 
  public void runCafe() {
    //call displayMenu()
    //loop while cafe is open (cafeOpen=true)
    //take user input for menuChoice
    //switch statement based on menuChoice
    //call methods relating to the menu options
  }

  public void createOrder() {
    //call methods to get user info
    //customer_name = getName()
    //drink_selection = getDrink()
    //size_selection = getSize()
    //make newOrder Order object with info
    //add newOrder to list of Orders
    //newOrder.displayReceipt
  }

  public void displayMenu() {
      //Display the main menu with options
    }

  public void displayDrinks() {
    //display drinks
  }

  public void displaySizes() {
    //display sizes
  }

  public String getName() {
    //validate user input and return clean name
  }

  public int getDrink() {
    //validate user input and return the menu number for the drink (should correspond with position in list of MenuItems (drinks))
  }

  public int getSize() {
    //validate user input and return the menu number for the size (should correspond with position in list of MenuItems (sizes))
  }
  */
}
