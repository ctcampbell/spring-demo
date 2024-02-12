package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
public class ApiController {

  @GetMapping(value = "/get/{username}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> get(String username, String password) {

    MockSqlConnection mockSqlConnection = new MockSqlConnection();
    mockSqlConnection.sqlConnection(username, password);
    
    String response = "SQL attempt made";

    return ResponseEntity.ok().body(response);
  }
  
}