package com.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpPostExample {
  private static final String POST_URL = "http://localhost:9999/rpk/post";
  private static final String JSON_BODY = "[{\"underlying\":\"NVDA\",\"symbol\":\"NVDA241108C00050000\",\"bidPrice\":97.75,\"askPrice\":98.25,\"bidSize\":26,\"askSize\":25,\"timestamp\":\"2024-11-07T17:16:16.000Z\"}]";

  public static void main(String[] args) {
    try {
      // Create an HttpClient
      HttpClient client = HttpClient.newBuilder()
          .connectTimeout(Duration.ofSeconds(10))
          .build();

      // Create the POST request
      HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create(POST_URL))
          .header("Content-Type", "application/json")
          .POST(HttpRequest.BodyPublishers.ofString(JSON_BODY))
          .build();

      // Send the request and get the response
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

      // Print the response
      System.out.println("Status code: " + response.statusCode());
      System.out.println("Response body: " + response.body());

    } catch (Exception e) {
      System.err.println("Error sending POST request: " + e.getMessage());
      e.printStackTrace();
    }
  }
}