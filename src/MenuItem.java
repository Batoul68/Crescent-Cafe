public class MenuItem {
  
  public String itemName;
  public double itemPrice;

  public MenuItem(String name, double price) {
    this.itemName = name;
    this.itemPrice = price;
  }

  public String getItemName() {
    return itemName;
  }

  public double getItemPrice() {
    return itemPrice;
  }

  public void setItemName(String name) {
    itemName = name;
  }

  public void setItemPrice(double price) {
    itemPrice = price;
  }

  public String toString() {
    return (itemName + " " + itemPrice);
  }
}
