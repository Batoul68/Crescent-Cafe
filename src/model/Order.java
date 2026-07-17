package model;
public class Order {

  public String customerName;
  public MenuItem drinkItem;
  public MenuItem sizeItem;

  public Order(String name, MenuItem drink, MenuItem size) {
    // Input validation
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("You have a name given to you at birth, please enter it.");
    }
    

    if (drink == null) {
      throw new IllegalArgumentException("You have to order something!");
    }

    if (size == null) {
      throw new IllegalArgumentException("You must choose a size, you can't run away.");
    }

    this.customerName = name;
    this.drinkItem = drink;
    this.sizeItem = size;
  }

  /**
   * Displays the receipt for the order
   */
  public void displayReceipt() {
    System.out.println("\nCustomer: "+customerName);
    System.out.println(sizeItem.getItemName()+" "+drinkItem.getItemName());
    System.out.printf("%s $%.2f", "Drink total: ", orderTotal());
  }

  /**
   * Calculates the total for the order
   * 
   * @return order total
   */
  public double orderTotal() {
    double total = drinkItem.getItemPrice() + sizeItem.getItemPrice();
    return total;
  }

  public String getCustomerName() {
    return customerName;
  }

  public MenuItem getDrink() {
    return drinkItem;
  }

  public MenuItem getSize() {
    return sizeItem;
  }

  public void setCustomerName(String name) {
    this.customerName = name;
  }

  public void setDrink(MenuItem drink) {
    this.drinkItem = drink;
  }

  public void setSize(MenuItem size) {
    this.sizeItem = size;
  }

  public String toString() {
    return (customerName + " " + drinkItem.getItemName() + drinkItem.getItemPrice());
  }
}
