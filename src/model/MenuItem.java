package model;
public class MenuItem {
  
  public String itemName;
  public double itemPrice;

  public MenuItem(String name, double price) {
    // Input validation
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Item name can't be blank.");
    }    

    if (price < 0) {
      throw new IllegalArgumentException("Price can't be negative (we can't owe you money...)");
    }

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
