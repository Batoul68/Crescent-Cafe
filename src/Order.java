public class Order {

  public String customer_name;
  public int drink_selection;
  public int size_selection;

  public Order(String name, int drink, int size) {
    customer_name = name;
    drink_selection = drink;
    size_selection = size;
  }

  public String toString() {
    return (customer_name + " " + Cafe.listOfDrinks.get(drink_selection) + Cafe.listOfSizes.get(size_selection));
  }
}
