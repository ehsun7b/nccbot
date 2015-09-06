package com.ehsunbehravesh.nccbot.joke;

import com.sun.org.apache.regexp.internal.RESyntaxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author Ehsun Behravesh <post@ehsunbehravesh.com>
 */
public class ICNDBJokeAPI {

  private static final String url = "http://api.icndb.com/jokes/random";

  public String randomJoke() throws IOException {
    HttpClient client = new DefaultHttpClient();
    HttpGet request = new HttpGet(url);
    HttpResponse response = client.execute(request);
    /*
     BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

     String line;
     StringBuilder result = new StringBuilder();

     while ((line = rd.readLine()) != null) {
     result.append(line);
     }*/
    JsonReader reader = Json.createReader(response.getEntity().getContent());
    JsonObject jsonObject = reader.readObject();

    String type = jsonObject.getString("type");
    if (type != null && type.toLowerCase().equals("success")) {
      JsonObject value = jsonObject.getJsonObject("value");
      String joke = value.getString("joke");
      return joke;
    } else {
      System.out.println("Joke API failed! " + jsonObject.toString());
    } 
    
    return null;
  }

}
