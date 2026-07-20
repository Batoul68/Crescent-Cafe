package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class MenuItemTest {

  @Test
  void constructorStoresMenuItemInformation() {
    MenuItem drink = new MenuItem(1, "Moonlight Latte", 5.50);

    assertEquals(1, drink.getItemId());
    assertEquals("Moonlight Latte", drink.getItemName());
    assertEquals(5.50, drink.getItemPrice(), 0.001);
  }

  @Test
  void decimalValueStoredProperly() {
    MenuItem drink = new MenuItem (1, "Moonlight Latte", 6.25);

    assertEquals(6.25, drink.getItemPrice());
  }

  @Test
  void constructorRejectsNullName() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new MenuItem(1, null, 6.25)
    );
  }

  @Test
  void constructorRejectsEmptyName() {
    assertThrows(
      IllegalArgumentException.class, 
      () -> new MenuItem(1, "",5.50)
    );
  }

  @Test
  void constructorRejectsNegativePrice() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new MenuItem(1, "yummy drink", -6.25)
    );
  }

  @Test
  void constructorAcceptsZeroPrice() {
    MenuItem size = new MenuItem (1, "small", 0.00);
    assertEquals(0.00, size.getItemPrice());
  }

  @Test
  void constructorRejectsNegativeId() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new MenuItem(-1, "yummy drink", 3.33)
    );
  };
}
