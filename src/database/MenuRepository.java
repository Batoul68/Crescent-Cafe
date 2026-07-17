package database;

import model.MenuItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

public class MenuRepository {
 ArrayList<MenuItem> drinksList = new ArrayList<MenuItem>();
  /**
   * Load all drinks from SQL database into MenuItems, add to list 
   * of all drinks.
   * 
   * @return list of all drinks
   */
  public ArrayList<MenuItem> getAllDrinks() {
   
    String sql = "SELECT drink_id, drink_name, drink_price FROM drinks";

    try (
      Connection connection = DatabaseConnection.getConnection();
      PreparedStatement statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
    ) {
      while(result.next()) {
        MenuItem newItem = new MenuItem(
          result.getInt("drink_id"),
          result.getString("drink_name"),
          result.getDouble("drink_price")
        );
        drinksList.add(newItem);
      }
    } catch (SQLException e) {
      System.out.println("Couldn't load drinks");
      e.printStackTrace();
    }
    return drinksList;
  }

  public void printDrinksList(ArrayList<MenuItem> drinks) {
    for (int i = 0; i < drinks.size(); i++) {
      System.out.println(
        drinks.get(i).getItemId() +
        drinks.get(i).getItemName() + 
        drinks.get(i).getItemPrice()
      );
    }
  }
}
