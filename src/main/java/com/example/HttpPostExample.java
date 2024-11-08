package com.example;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpPostExample {
  public static void main(String[] args) throws Exception {
    String url = "http://localhost:9999/rpk/post";
    String jsonInputString = "[{\"underlying\":\"NVDA\",\"symbol\":\"NVDA241108C00050000\",\"bidPrice\":97.75,\"askPrice\":98.25,\"bidSize\":26,\"askSize\":25,\"timestamp\":\"2024-11-07T17:16:16.000Z\"}]";

    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestMethod("POST");
    con.setRequestProperty("Content-Type", "application/json");
    con.setRequestProperty("Feed-Name", "option-quotes");
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