package com.ehsunbehravesh.nccbot.service;

import com.ehsunbehravesh.nccbot.joke.JokeBank;
import com.ehsunbehravesh.nccbot.service.request.Update;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.HttpHeaders.USER_AGENT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Ehsun Behravesh <post@ehsunbehravesh.com>
 */
@Path("update")
public class UpdateHook {

  @Path("")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response getUpdate(Update update) {

    if (update.getMessage().getText() != null && update.getMessage().getText().startsWith("/")) {
      String response = getCommandResponse(update);

      try {
        sendPost(response);
      } catch (Exception ex) {
        Logger.getLogger(UpdateHook.class.getName()).log(Level.SEVERE, null, ex);
      }

    } else {
      String str = "update id: " + update.getUpdateId() + " - message text: " + update.getMessage().getText();

      str += " - user: " + update.getMessage().getFrom().getUsername();
      System.out.println("UPDATE: " + str);

      StringBuilder response = new StringBuilder();

      if (update.getMessage().getFrom().getUsername() != null && update.getMessage().getFrom().getUsername().toLowerCase().contains("paseban")) {

        response.append("chat_id=").append(update.getMessage().getChat().getId()).append("&");
        response.append("text=").append("سلام عمو سعید");

        System.out.println(response.toString());

        try {
          sendPost(response.toString());
        } catch (Exception ex) {
          Logger.getLogger(UpdateHook.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

      if (update.getMessage().getFrom().getUsername() != null && update.getMessage().getFrom().getUsername().toLowerCase().contains("omidvar")) {

        response.append("chat_id=").append(update.getMessage().getChat().getId()).append("&");
        response.append("text=").append("سلام عمو نبی، مدیر گروه");

        System.out.println(response.toString());

        try {
          sendPost(response.toString());
        } catch (Exception ex) {
          Logger.getLogger(UpdateHook.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

      response = new StringBuilder();
      response.append("chat_id=").append(update.getMessage().getChat().getId()).append("&");
      response.append("text=").append(randomBegForName())
              .append("&reply_to_message_id=").append(update.getMessage().getMessageId());

      System.out.println(response.toString());

      try {
        sendPost(response.toString());
      } catch (Exception ex) {
        Logger.getLogger(UpdateHook.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    return Response.ok().build();
  }

  private void sendPost(String params) throws Exception {

    String url = "https://api.telegram.org/bot124375120:AAHJc47jDJBCwCp2cXYDCKJfQhdb-wAnK_4/".concat("sendMessage");
    URL obj = new URL(url);
    HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

    //add reuqest header
    con.setRequestMethod("POST");
    con.setRequestProperty("User-Agent", USER_AGENT);

    String urlParameters = params;

    // Send post request
    con.setDoOutput(true);
    DataOutputStream wr = new DataOutputStream(con.getOutputStream());

    byte[] bytes = urlParameters.getBytes("UTF-8");
    wr.write(bytes);
    //wr.writeUTF(urlParameters);

    wr.flush();
    wr.close();

    int responseCode = con.getResponseCode();
    System.out.println("\nSending 'POST' request to URL : " + url);
    System.out.println("Post parameters : " + urlParameters);
    System.out.println("Response Code : " + responseCode);

    BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();

    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    in.close();

    //print result
    System.out.println(response.toString());

  }

  private String randomBegForName() {
    Random r = new Random(System.currentTimeMillis());
    int index = r.nextInt(4);
    String[] text = {
      "سلام خوبی؟",
      "سلام، اسم من جعفره. این اسمو مدیر گروه انتخاب کرده",
      "سلام به همگی",
      "سلام"
    };

    //String[] text = {"A", "B", "C", "D"};
    return text[index];
  }

  private String getCommandResponse(Update update) {
    String command = update.getMessage().getText().trim();

    if (command.contains(" ")) {
      command = command.substring(0, command.indexOf(" "));
      command = command.trim().toLowerCase();
    }

    while (command.startsWith("/")) {
      command = command.substring(1);
    }

    switch (command) {
      case "joke":
        Integer id = update.getMessage().getChat().getId();
        
        return sayJokeResponse(id);
      default:
        return menuResponse(update.getMessage().getChat().getId());
    }
  }

  private String menuResponse(int chatId) {
    String menu = "/joke - Send a joke";
    StringBuilder response = new StringBuilder();
    response.append("chat_id=").append(chatId).append("&");
    response.append("text=").append(menu);

    return response.toString();
  }

  private String sayJokeResponse(int chatId) {
    String joke = new JokeBank().joke(chatId);

    StringBuilder response = new StringBuilder();
    response.append("chat_id=").append(chatId).append("&");
    response.append("text=").append(joke);

    return response.toString();
  }
}
