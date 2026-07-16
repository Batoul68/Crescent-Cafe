public class Order {

  public String customerName;
  public MenuItem drinkItem;
  public MenuItem sizeItem;

  public Order(String name, MenuItem drink, MenuItem size) {
    // Input validation
    if (customerName == null || customerName.isBlank()) {
      throw new IllegalArgumentException("Customer name can't be blank");
    }

    if (drink == null) {
      throw new IllegalArgumentException("Drink can't be null");
    }

    if (size == null) {
      throw new IllegalArgumentException("Size can't be null");
    }

    this.customerName = name;
    this.drinkItem = drink;
    this.sizeItem = size;
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

  public void setSiz(MenuItem size) {
    this.sizeItem = size;
  }

  public String toString() {
    return (customerName + " " + drinkItem.getItemName() + drinkItem.getItemPrice());
  }
}
