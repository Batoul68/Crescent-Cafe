public class MenuItem {
  
  public String item_name;
  public double item_price;

  public MenuItem(String name, double price) {
    item_name = name;
    item_price = price;
  }

  public String toString() {
    return (item_name + " " + item_price);
  }
}
