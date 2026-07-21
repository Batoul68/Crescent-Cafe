package model;
public class MenuItem {
  
  private final int itemId;
  private final String itemName;
  private final double itemPrice;

  public MenuItem(int id, String name, double price) {
    // Input validation
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Item name can't be blank.");
    }    

    if (id < 0) {
      throw new IllegalArgumentException("Id can't be negative");
    }

    if (price < 0) {
      throw new IllegalArgumentException("Price can't be negative (we can't owe you money...)");
    }

    this.itemId = id;
    this.itemName = name;
    this.itemPrice = price;
  }

  public int getItemId() {
    return itemId;
  }
  
  public String getItemName() {
    return itemName;
  }

  public double getItemPrice() {
    return itemPrice;
  }

  @Override
  public String toString() {
    return (itemName + " " + itemPrice);
  }
}
