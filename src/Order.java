public class Order {

  public String customerName;
  public MenuItem item;

  public Order(String name, MenuItem menu) {
    // Input validation
    if (customerName == null || customerName.isBlank()) {
      throw new IllegalArgumentException("Customer name can't be blank");
    }

    if (menu == null) {
      throw new IllegalArgumentException("Menu item can't be null");
    }

    this.customerName = name;
    this.item = menu;
  }

  public String getCustomerName() {
    return customerName;
  }

  public MenuItem getItem() {
    return item;
  }

  public void setCustomerName(String name) {
    this.customerName = name;
  }

  public void setItem(MenuItem menu) {
    this.item = menu;
  }

  public String toString() {
    return (customerName + " " + item.getItemName() + item.getItemPrice());
  }
}
