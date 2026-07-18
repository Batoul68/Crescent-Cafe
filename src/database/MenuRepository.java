package database;

import model.MenuItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

public class MenuRepository {
  /**
  * Sends SQL query to helper method to get all drinks
  * 
  * @return list of all drinks returned from loadMenuItems
  */
  public List<MenuItem> getAllDrinks() {
    String sql = """
      SELECT drink_id AS item_id,
      drink_name AS item_name,
      drink_price AS item_price FROM drinks
      """;

    return loadMenuItems(sql);
  }

  /**
  * Sends SQL query to helper method to get all sizes
  * 
  * @return list of all drinks
  */
  public List<MenuItem> getAllSizes() {
    String sql = """
      SELECT size_id AS item_id,
      size_name AS item_name,
      price_adjustment AS item_price FROM sizes
      """;

    return loadMenuItems(sql);
  }

  /**
  * Helper method that loads data from SQL database into MenuItems, adding to list 
  * of MenuItems
  * 
  * @return list of loaded MenuItems
  * @param sql query
  */
  private List<MenuItem> loadMenuItems (String query) {
    List<MenuItem> menuItems = new ArrayList<>();
    
    try (
      Connection connection = DatabaseConnection.getConnection();
      PreparedStatement statement = connection.prepareStatement(query);
      ResultSet result = statement.executeQuery();
    ) {
      while(result.next()) {
        MenuItem newItem = new MenuItem(
          result.getInt("item_id"),
          result.getString("item_name"),
          result.getDouble("item_price")
        );
        menuItems.add(newItem);
      }
    } catch (SQLException e) {
      // stop program from running if MenuItems can't load from database
      throw new RuntimeException("Unable to load menu items", e);
    }

    return menuItems;
  }
}
