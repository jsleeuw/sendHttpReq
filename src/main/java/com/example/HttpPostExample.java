package com.example;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpPostExample {
  public static void main(String[] args) throws Exception {
    String url = "YOUR_URL_HERE";
    String jsonInputString = "YOUR_JSON_HERE";

    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestMethod("POST");
    con.setRequestProperty("Content-Type", "application/json");
    con.setDoOutput(true);

    try (OutputStream os = con.getOutputStream()) {
      byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
      os.write(input, 0, input.length);
    }

    int responseCode = con.getResponseCode();
    System.out.println("Response Code : " + responseCode);

    // Add response reading logic here if needed
  }
}