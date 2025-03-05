import java.sql.*;
import java.time.LocalDate;

public class CRUDE {
    //This class is made for testing the CRUDE of the database. Create, Read, Update, Delete, Execute
    public CRUDE() {
        //this is a constructor, use this for default values.
    }
    static final String url = "jdbc:mysql://127.0.0.1:3306/login_schema";
    static final String username = "root";
    static final String password = "SQL_Admin";
    private void connect() { //Copy this syntax everytime a connection needs to be made.
        //copy the try catch block into the code
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void displayAllItems(){ //Performs Read part of CRUDE
        String query = "SELECT * FROM clothingitems";
            try {
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
                while(result.next()) {
                    System.out.println(result.getString("name"));
                    System.out.println(result.getString("type"));
                    System.out.println(result.getString("colourgroup"));
                    System.out.println(result.getString("hexcode"));
                    System.out.println(result.getString("date_bought"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
    static private String colour= "black";
    public static void setColour(String setter){
        colour=setter;
    }
    public static void findColour(){
        String query = "SELECT name,type,hexcode,date_bought FROM clothingitems where colourgroup = '"+colour+"'";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()) {
                System.out.println(result.getString("name"));
                System.out.println(result.getString("type"));
                //System.out.println(result.getString("colourgroup")); still does not work.
                System.out.println(result.getString("hexcode"));
                System.out.println(result.getString("date_bought"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //The variables and method below are responsible for setting values for update functions
    private static String name = "Test cloth: Placeholder"; //Placeholder Values
    private static String type = "top"; //Placeholder Values
    private static String colourgroup = "black"; //Placeholder Values
    private static String hexcode = "#FFFFFF"; //Placeholder Values
    private static String date_bought = "2020-12-20";

    //consider removing newValues if addValues works.
    public static void newValues(String namei, String typei, String colourgroupi, String hexcodei) {
        //This statement is responsible for setting values that need to be added or modify
        name = namei;//.substring(0, 44);
        type = typei;//.substring(0, 44);
        colourgroup = colourgroupi;//.substring(0, 44);
        hexcode = hexcodei;//.substring(0, 6);
        LocalDate date_boughti = LocalDate.now(); // Create a date object
        date_bought = String.valueOf(date_boughti);
    }

    public static void addValues(String namei, String typei, String colourgroupi, String hexcodei) {
        //This statement is responsible for setting values that need to be added or modify
        name = namei;//.substring(0, 44);
        type = typei;//.substring(0, 44);
        colourgroup = colourgroupi;//.substring(0, 44);
        hexcode = hexcodei;//.substring(0, 6);
        LocalDate date_boughti = LocalDate.now(); // Create a date object
        date_bought = String.valueOf(date_boughti);
        String query = "INSERT INTO `login_schema`.`clothingitems`\n" +
                "(`name`,\n" +
                "`type`,\n" +
                "`colourgroup`,\n" +
                "`hexcode`,\n" +
                "`date_bought`)\n" +
                "VALUES\n" +
                "(\""+name+"\",\n" +
                "\""+type+"\",\n" +
                "\""+colourgroup+"\",\n" +
                "\""+hexcode+"\",\n" +
                "\""+date_bought+"\");";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            PreparedStatement p=null;
            p =connection.prepareStatement(query);
            p.execute();
            //ResultSet result = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //add a modify values function.
    /*
    UPDATE clothingitems
SET name = 'testUpdate', type = 'top', colourgroup = 'white', hexcode = '#000000', date_bought = '2020-2-20'
WHERE idclothingItems = 1;
     */
}
