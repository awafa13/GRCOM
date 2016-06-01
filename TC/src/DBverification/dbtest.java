package DBverification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class dbtest {
	String dbUrl = "jdbc:mysql://localhost:4321/tc";
	String username ="gr";
	String password ="gr";
	String user = "root";
    String pass = "QAgridtest";
    String host = "10.4.1.32";
    int port=22;
    private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	private static final String MYSQL_HOST = "localhost";
	private static final Integer MYSQL_PORT = 4321;
	private static final String MYSQL_DB = "Aymen";
	private static final String MYSQL_DATABASE_URL = "jdbc:mysql://" + MYSQL_HOST + ":" + MYSQL_PORT + "/" + MYSQL_DB;
	private static final String MYSQL_USERNAME = "gr";
	private static final String MYSQL_PASSWORD = "gr";
	private static final String SSH_HOST = "10.4.1.32";
	private static final Integer SSH_HOST_PORT = 22;
	private static final String SSH_USER = "root";
	private static final String SSH_PASSWORD = "QAgridtest";

  @Test(priority=0)
  public void opensshsession() throws ClassNotFoundException, SQLException, JSchException, InterruptedException {
      JSch jsch = new JSch();
      Session session = jsch.getSession(user,host,port);   
      session.setPassword(pass);
      session.setConfig("StrictHostKeyChecking", "no");
      session.connect();
      System.out.println("connection successful");
      Integer rport = 3306;
	  int assinged_port = session.setPortForwardingL(MYSQL_PORT, MYSQL_HOST, rport);
	 System.out.println(MYSQL_HOST + ":" + assinged_port + " -> " + MYSQL_HOST + ":" + rport);
	  Class.forName("com.mysql.jdbc.Driver");     
      //Create Connection to DB 
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:4321/Aymen","gr","gr");
      System.out.println("db connection established");
      String query = "select BowlerNum  from bowler where MaxBowlingSpeed=64;";
      //Create Statement Object       
     Statement stmt = con.createStatement();                  
      // Execute the SQL Query. Store results in ResultSet        
   ResultSet rs= stmt.executeQuery(query);                         
      // While Loop to iterate through all data and print results     
      while (rs.next()){
                  String guid = rs.getString(1);                                                                                     
                  System. out.println("Membership Term is " + guid);     
          }       
       // closing DB Connection       
      con.close();       
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
