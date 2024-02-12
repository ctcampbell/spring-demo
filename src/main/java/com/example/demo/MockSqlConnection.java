package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MockSqlConnection {

	public MockSqlConnection() {};

  public void sqlConnection(String username, String password) {
    String jdbcUrl = "jdbc:mysql://localhost:3306/spring-demo";

    System.out.println(username + " " + password);

    try {
      Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

      String sql = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery(sql);

      String result;
      if (rs.first()) {
        result = "found some stuff";
      } else {
        result = "found nothing";
      }

      System.out.println(result);

      connection.close();

    } catch (SQLException e) {
      System.err.println(e.getMessage());
    }
  }

}
