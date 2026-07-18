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
  ArrayList<MenuItem> sizeList = new ArrayList<MenuItem>();
  
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

  /**
  * Load all drinks from SQL database into MenuItems, add to list 
  * of all drinks.
  * 
  * @return list of all drinks
  */
  public ArrayList<MenuItem> getAllSizes() {
    String sql = "SELECT size_id, size_name, price_adjustment FROM sizes";

    try (
      Connection connection = DatabaseConnection.getConnection();
      PreparedStatement statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
    ) {
      while(result.next()) {
        MenuItem newItem = new MenuItem(
          result.getInt("size_id"),
          result.getString("size_name"),
          result.getDouble("price_adjustment")
        );
        sizeList.add(newItem);
      }
    } catch (SQLException e) {
      System.out.println("Couldn't load sizes");
      e.printStackTrace();
    }
    return sizeList;
  }

}
