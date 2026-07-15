public class Order {

  // Variable declarations
  public String customer_name;
  public int drink_selection;
  public int size_selection;

  //Override default constructor
  public Order(String name, int drink, int size) {
    customer_name = name;
    drink_selection = drink;
    size_selection = size;
  }

  //Override default toString
  public String toString() {
    return (customer_name + " " + Cafe.listOfDrinks.get(drink_selection) + Cafe.listOfSizes.get(size_selection));
  }
}
