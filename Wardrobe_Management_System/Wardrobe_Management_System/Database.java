import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.sql.*;
/**
 * This class is responsible for the connection to, and management of, the MySQL database
 */
abstract class Database extends Actor
{
    /*
    public Connection openConnection() 
    {
          Properties properties = new Properties();
          properties.put("user", "EnterUsernameHere");
          properties.put("password", "EnterPasswordHere");
          properties.put("characterEncoding", "ISO-8859-1");
          properties.put("useUnicode", "true");
          String url = "jdbc:mysql://hostname/database";

          Class.forName("com.mysql.jdbc.Driver").newInstance();
          Connection c = DriverManager.getConnection(url, properties);
          return c;
    }
    
    public void connectToAndQueryDatabase(String username, String password) 
    {

        Connection con = DriverManager.getConnection("jdbc:myDriver:myDatabase",username,password);

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM Table1");

        while (rs.next()) 
        {
            int x = rs.getInt("a");
            String s = rs.getString("b");
            float f = rs.getFloat("c");
        }
    }
    */
    public void act()
    {
        // Add your action code here.
    }
}
