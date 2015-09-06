package com.ehsunbehravesh.nccbot.bean;

import java.sql.Connection;
import java.sql.SQLException;
import javax.ejb.Stateless;
import javax.naming.NamingException;

/**
 *
 * @author Ehsun Behravesh <post@ehsunbehravesh.com>
 */
@Stateless
public class ConnectionBean {

  public Connection connection() throws NamingException, SQLException {
    javax.naming.InitialContext ctx = new javax.naming.InitialContext();
    javax.sql.DataSource ds = (javax.sql.DataSource) ctx.lookup("jdbc/nccbot");
    java.sql.Connection conn = ds.getConnection();
    return conn;
  }

    // Add business logic below. (Right-click in editor and choose
  // "Insert Code > Add Business Method")
}
