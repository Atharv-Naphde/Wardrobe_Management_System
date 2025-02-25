import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;
public class database {
    public static void main(){
        Scanner SC=new Scanner(System.in);
        System.out.println("what do you want the program to do?");
        queryselector(SC.next());
        givesvalues();
    }

    public static void newValues(String namei, String typei, String colourgroupi, String hexcodei){
        //This statement is responsible for setting values that need to be added or modify
        name = namei.substring(0,44);
        type = typei.substring(0,44);
        colourgroup = colourgroupi.substring(0,44);
        hexcode = hexcodei.substring(0,6);
        LocalDate date_boughti = LocalDate.now(); // Create a date object
        date_bought =String.valueOf(date_boughti);
        /* Older version of date calculator
        if(date_boughti.charAt(4)=='-'){
            date_bought = date_boughti.substring(0,9);
        }
        else
            System.out.println("Error: invalid date format. Format required is YYYY/MM/DD");

         */
    }
    //Below this comment and the comment below are values that will be added to the database, or modified.
    private static String name = "Test cloth: Placeholder"; //Placeholder Values
    private static String type = "top"; //Placeholder Values
    private static String colourgroup = "black"; //Placeholder Values
    private static String hexcode = "#FFFFFF"; //Placeholder Values
    private static String date_bought = "2020-12-20";
    //private static String date_bought = "2020-12-20"; //Placeholder Values
    //Above this comment and the comment below are values that will be added to the database, or modified.

    static String query ="SELECT * FROM colourgroup"; //This is the default query.
    public static void main(String Args[]){
        Scanner SC=new Scanner(System.in);
        System.out.println("what do you want the program to do?");
        queryselector(SC.next());
        givesvalues();

    }
    public static void givesvalues() {
        String url = "jdbc:mysql://127.0.0.1:3306/login_schema";
        String username = "root";
        String password = "SQL_Admin";
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            //The code paragraph below can be used as a reference to make different queries.
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                switch (query) {
                    case "SELECT * FROM clothingitems":
                        System.out.println(resultSet.getString("name"));
                        System.out.println(resultSet.getString("type"));
                        System.out.println(resultSet.getString("colourgroup"));
                        System.out.println(resultSet.getString("hexcode"));
                        System.out.println(resultSet.getString("date_bought"));
                        break;
                    case "SELECT name,type,hexcode,date_bought FROM clothingitems where colourgroup = 'black'": //find black clothing items
                        System.out.println(resultSet.getString("name"));
                        System.out.println(resultSet.getString("type"));
                        System.out.println(resultSet.getString("hexcode"));
                        System.out.println(resultSet.getString("date_bought"));
                        break;
                    case "SELECT name,type,hexcode,date_bought FROM clothingitems where colourgroup = 'white'"://find white clothing items
                        System.out.println(resultSet.getString("name"));
                        System.out.println(resultSet.getString("type"));
                        System.out.println(resultSet.getString("hexcode"));
                        System.out.println(resultSet.getString("date_bought"));
                        break;
                    case "SELECT colourgroup FROM complementary WHERE clothingitems.colourgroup = complementary.complementarycolour": //prints complementary colour. Does not work as intended.
                        System.out.println(resultSet.getString("colourgroup"));
                        break;
                    default: //This outputs the same answer as "SELECT * FROM clothingitems"
                        System.out.println("Error: Your selected query may be incorrect.");
                        System.out.println(resultSet.getString("name"));
                        System.out.println(resultSet.getString("type"));
                        System.out.println(resultSet.getString("colourgroup"));
                        System.out.println(resultSet.getString("hexcode"));
                        System.out.println(resultSet.getString("date_bought"));
                        break;

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void queryselector(String queryselect){
        switch(queryselect){ //This switch case may need to be repeated in the function above to execute statements properly.
            case "find complementary colour":
                query = "SELECT colourgroup FROM complementary WHERE clothingitems.colourgroup = complementary.complementarycolour";
                break;
            case "find black":
                query = "SELECT name,type,hexcode,date_bought FROM clothingitems where colourgroup = 'black'";
                break;
            case "find white":
                query = "SELECT name,type,hexcode,date_bought FROM clothingitems where colourgroup = 'white'";
                break;
            case "show all":
                query ="SELECT * FROM clothingitems";
                break;
            case "add clothing":
                query ="INSERT INTO `login_schema`.`clothingitems`\n" +
                        "(`name`,\n" +
                        "`type`,\n" +
                        "`colourgroup`,\n" +
                        "`hexcode`,\n" +
                        "`date_bought`)\n" +
                        "VALUES\n" +
                        "(\"Test Shirt 2\",\n" +
                        "\"top\",\n" +
                        "\"white\",\n" +
                        "\"#000000\",\n" +
                        "\"2020-2-20\");";
                break;
            default:
                query ="SELECT * FROM clothingitems";
                break;

        }
    }
}