package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class OrderTest {

  @Test
  void constrcutorStoresOrderInformation() {
    MenuItem drink = new MenuItem(1, "Matcha", 3.30);
    MenuItem size = new MenuItem(1, "medium", 0.75);
    Order order = new Order("sam", drink, size);

    assertEquals("sam", order.getCustomerName());
    assertEquals(drink, order.getDrink());
    assertEquals(size, order.getSize());
  }

  @Test
  void orderTotalIncludesDrinkAndSizePrices () {
    MenuItem drink = new MenuItem(1, "Matcha", 3.30);
    MenuItem size = new MenuItem(1, "medium", 0.75);
    Order order = new Order("sam", drink, size);

    assertEquals(4.05, order.orderTotal(), 0.001);
  }

  @Test
  void constructorRejectsNullCustomerName() {
    MenuItem drink = new MenuItem(1, "Matcha", 3.30);
    MenuItem size = new MenuItem(1, "medium", 0.75);
    
    assertThrows(
      IllegalArgumentException.class, 
      () -> new Order(null, drink, size)
    );
  }

  @Test
  void constructorRejectsEmptyCustomerName() {
    MenuItem drink = new MenuItem(1, "Matcha", 3.30);
    MenuItem size = new MenuItem(1, "medium", 0.75);
    
    assertThrows(
      IllegalArgumentException.class, 
      () -> new Order("", drink, size)
    );
  }

  @Test
  void constructorRejectsNullDrink() {
    MenuItem size = new MenuItem(1, "medium", 0.75);
  
    assertThrows(
      IllegalArgumentException.class, 
      () -> new Order("", null, size)
    );
  }

  @Test
  void constructorRejectsNullSize() {
    MenuItem drink = new MenuItem(1, "Matcha", 3.30);

    assertThrows(
      IllegalArgumentException.class, 
      () -> new Order("", drink, null)
    );
  }



}
