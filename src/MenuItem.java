public class MenuItem {
  
  // Variable declarations
  public String item_name;
  public double item_price;

  // Override default constructor
  public MenuItem(String name, double price) {
    item_name = name;
    item_price = price;
  }

  // Override default toString
  public String toString() {
    return (item_name + " " + item_price);
  }
}
