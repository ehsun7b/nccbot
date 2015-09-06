package com.ehsunbehravesh.nccbot.bean;

import com.ehsunbehravesh.nccbot.entity.Joke;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.naming.NamingException;

/**
 *
 * @author Ehsun Behravesh <post@ehsunbehravesh.com>
 */
@Stateless
public class JokeBean {

  @Inject
  private ConnectionBean connectionBean;

  public void save(Joke joke) {
    Connection connection = null;

    try {
      connection = connectionBean.connection();
      
      connection.createStatement().executeQuery("SET NAMES utf8mb4");
      
      String sql = "INSERT INTO joke (content, owner, date) VALUES (?, ?, ?)";
      PreparedStatement stmnt = connection.prepareStatement(sql);
      

      String content = joke.getContent();
      stmnt.setString(1, content);
      stmnt.setString(2, joke.getOwner());
      stmnt.setDate(3, new java.sql.Date(joke.getDate().getTime()));

      stmnt.executeUpdate();
    } catch (NamingException | SQLException ex) {
      Logger.getLogger(JokeBean.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException ex) {
          Logger.getLogger(JokeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
  }

}
