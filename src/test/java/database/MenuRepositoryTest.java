package database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import model.MenuItem;

public class MenuRepositoryTest {

  @Test
  void MenuRepositoryLoadsDrinks() {
    MenuRepository repository = new MenuRepository();

    List<MenuItem> drinks = repository.getAllDrinks();

    assertNotNull(drinks);
    assertFalse(drinks.isEmpty());
  }

  @Test
  void MenuRepositoryVerifyKnownDrinkLoads() {
    MenuRepository repository = new MenuRepository();

    List<MenuItem> drinks = repository.getAllDrinks();
    
    MenuItem foundDrink = null;

    for (MenuItem drink : drinks) {
      if (drink.getItemId() == 1) {
        foundDrink = drink;
        break;
      }
    }

    assertNotNull(foundDrink);
    assertEquals("Moonlight Latte", foundDrink.getItemName());
    assertEquals(5.50, foundDrink.getItemPrice(), 0.001);
  }

  @Test
  void MenuRepositoryLoadsSizes() {
    MenuRepository repository = new MenuRepository();

    List<MenuItem> sizes = repository.getAllSizes();

    assertNotNull(sizes);
    assertFalse(sizes.isEmpty());
  }

  @Test
  void MenuRepositoryVerifyKnownSizeLoads() {
    MenuRepository repository = new MenuRepository();

    List<MenuItem> sizes = repository.getAllSizes();
    
    MenuItem foundSize = null;

    for (MenuItem size : sizes) {
      if (size.getItemId() == 1) {
        foundSize = size;
        break;
      }
    }

    assertNotNull(foundSize);
    assertEquals("Small", foundSize.getItemName());
    assertEquals(0.00, foundSize.getItemPrice(), 0.001);
  }

  @Test
  void MenuRepositoryAllDrinksLoad() {
    MenuRepository repository = new MenuRepository();

    List<MenuItem> drinks = repository.getAllDrinks();

    for (MenuItem drink : drinks) {
      assertNotNull(drink);
    }
  }

  @Test
  void MenuRepositoryAllSizesLoad() {
    MenuRepository repository = new MenuRepository();

    List<MenuItem> sizes = repository.getAllSizes();

    for (MenuItem size : sizes) {
      assertNotNull(size);
    }
  }
}
