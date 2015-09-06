package com.ehsunbehravesh.nccbot.service;

import com.ehsunbehravesh.nccbot.bean.JokeBean;
import com.ehsunbehravesh.nccbot.entity.Joke;
import com.ehsunbehravesh.nccbot.joke.JokeBank;
import com.ehsunbehravesh.nccbot.service.request.Update;
import com.ehsunbehravesh.nccbot.service.request.User;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.net.ssl.HttpsURLConnection;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
@Stateless
@Path("update")
public class UpdateHook {

  @Inject
  private JokeBean jokeBean;

  @Path("add")
  @GET
  public String addTest() {
    Joke joke = new Joke("ehsun7b", " joke joke joke");
    String result = "ok";
    try {
      jokeBean.save(joke);
    } catch (Exception ex) {
      result = "Error: " + ex.getMessage();
    }

    return result;
  }

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

    return text[index];
  }

  private String getCommandResponse(Update update) {
    String command = update.getMessage().getText().trim();

    if (command.contains(" ")) {
      //command = command.substring(0, command.indexOf(" "));
      command = command.trim().toLowerCase();
    }

    while (command.startsWith("/")) {
      command = command.substring(1);
    }

    if (command.equals("joke")) {
      Integer id = update.getMessage().getChat().getId();
      return sayJokeResponse(id);
    } else if (command.startsWith("addjoke")) {
      Integer id = update.getMessage().getChat().getId();
      User user = update.getMessage().getFrom();

      if (command.startsWith("addjoke ")) {
        String content = command.substring(command.indexOf(" ") + 1);
        return addJoke(id, user, content);
      } else {
        return addJoke(id, user, null);
      }
    } else {
      return menuResponse(update.getMessage().getChat().getId());
    }

  }

  private String menuResponse(int chatId) {
    String menu = "/joke - Tell a joke\n/addjoke - Add a joke";
    StringBuilder response = new StringBuilder();
    response.append("chat_id=").append(chatId).append("&");
    response.append("text=").append(menu);

    return response.toString();
  }

  private String sayJokeResponse(int chatId) {
    String joke;
    try {
      //joke = new ICNDBJokeAPI().randomJoke();
      joke = new JokeBank().joke(chatId);
    } catch (Exception ex) {
      Logger.getLogger(UpdateHook.class.getName()).log(Level.SEVERE, null, ex);
      joke = "Error! :(";
    }

    StringBuilder response = new StringBuilder();
    response.append("chat_id=").append(chatId).append("&");
    response.append("text=").append(joke);

    return response.toString();
  }

  private String addJoke(int chatId, User user, String content) {
    String result;

    if (content != null && content.trim().length() > 0) {
      String username = user.getUsername();

      if (username == null || username.trim().length() <= 0) {
        //throw new JokeException("Username not found!");
        result = "خطا! حساب تلگرام شما نام کاربری ندارد.";
      } else {

        Joke joke = new Joke(username, content);

        try {
          jokeBean.save(joke);
          result = "دریافت شد! ممنونم.";
        } catch (Exception ex) {
          result = "Error: " + ex.getMessage();
        }
      }
    } else {
      result = "لطفا بعد از /addjoke جوک را بنویسید";
    }

    StringBuilder response = new StringBuilder();
    response.append("chat_id=").append(chatId).append("&");
    response.append("text=").append(result);

    return response.toString();
  }
}
