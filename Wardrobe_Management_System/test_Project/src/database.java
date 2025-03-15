/*
This class is currently redundant. consider removing once all of its code is repourposed/ refactored.
 */




import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;
public class database {
    //static String query ="SELECT * FROM colourgroup"; //This is the default query.
    //static String queryexecute = "";//This is a copy query made for complex multi-line queries, and may not be required when code is fixed.
    //static String queryselect = "";

    //Main method is not allowed without arguments. This method is a placeholder and will not be used.
    public static void main(String[] Args){
        //main();
        CRUDE.display();
    }
    public static void main(){
        Scanner SC=new Scanner(System.in);
        System.out.println("what do you want the program to do?");
        //queryselector(SC.next());
        //queryselect = SC.next();
        givesvalues(SC.nextInt());

    }

    public static void selectObject(String select){
        //This program allows the user to select the object based on its name. This can also be modified to include searching by other values
        //("SELECT name,type,hexcode,date_bought FROM clothingitems where name = "+select)
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


    public static String queryselector(String select){
        //this is a setter method.
        return select;
    }

    //this method below is an int version of givesvalues() used for testing.
    public static void givesvalues(int select) {
        String url = "jdbc:mysql://127.0.0.1:3306/login_schema";
        String username = "root";
        String password = "SQL_Admin";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement1 = connection.createStatement();
            String query;
            //The code below this switch statement is a modification to the original queryselector algorithm that enables multiple queries. Currently, It does not work.
            switch (select) {
                case 1://"show all":
                    query = "SELECT * FROM clothingitems";
                    ResultSet result = statement1.executeQuery(query);
                    while(result.next()){
                        System.out.println(result.getString("name"));
                        System.out.println(result.getString("type"));
                        System.out.println(result.getString("colourgroup"));
                        System.out.println(result.getString("hexcode"));
                        System.out.println(result.getString("date_bought"));
                    }
                    break;
                case 2://"find black":
                    query = "SELECT name,type,hexcode,date_bought FROM clothingitems where colourgroup = 'black'";
                    ResultSet findBlack = statement1.executeQuery(query);
                    System.out.println(findBlack.getString("name"));
                    System.out.println(findBlack.getString("type"));
                    System.out.println(findBlack.getString("hexcode"));
                    System.out.println(findBlack.getString("date_bought"));
                    break;
                case 3://"find white":
                    query = "SELECT name,type,hexcode,date_bought FROM clothingitems where colourgroup = 'white'";
                    ResultSet findWhite = statement1.executeQuery(query);
                    System.out.println(findWhite.getString("name"));
                    System.out.println(findWhite.getString("type"));
                    System.out.println(findWhite.getString("hexcode"));
                    System.out.println(findWhite.getString("date_bought"));
                    break;
                case 4://"add item":
                    //add a case statement to select object, and a scanner that can allow the user to add the new values.
                    //"INSERT INTO clothingitems " bla bla bla
                    //selectObject(name)

                    break;
                case 5://"modify item":
                    //add a case statement to select object, and a scanner that can allow the user to add the modified values.
                    //selectObject(name)
                    //UPDATE table_name
                    //SET column1 = value1, column2 = value2, ...
                    //WHERE condition;
                    break;
                default: //This outputs the same answer as "SELECT * FROM clothingitems"
                    System.out.println("Error: Your selected query may be incorrect.");
                    query = "SELECT * FROM clothingitems";
                    ResultSet result1 = statement1.executeQuery(query);
                    while(result1.next()){
                        System.out.println(result1.getString("name"));
                        System.out.println(result1.getString("type"));
                        System.out.println(result1.getString("colourgroup"));
                        System.out.println(result1.getString("hexcode"));
                        System.out.println(result1.getString("date_bought"));
                    }
                    break;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            /*
    public static void givesvalues(String select) {
        String url = "jdbc:mysql://127.0.0.1:3306/login_schema";
        String username = "root";
        String password = "SQL_Admin";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement1 = connection.createStatement();
            String query;
            //The code below this switch statement is a modification to the original queryselector algorithm that enables multiple queries. Currently, It does not work.
            switch (select) {
                case "show all":
                    query = "SELECT * FROM clothingitems";
                    ResultSet result = statement1.executeQuery(query);
                    while(result.next()){
                        System.out.println(result.getString("name"));
                        System.out.println(result.getString("type"));
                        System.out.println(result.getString("colourgroup"));
                        System.out.println(result.getString("hexcode"));
                        System.out.println(result.getString("date_bought"));
                    }
                    break;
                case "find black":
                    query = "SELECT name,type,hexcode,date_bought FROM clothingitems where colourgroup = 'black'";
                    ResultSet findBlack = statement1.executeQuery(query);
                    System.out.println(findBlack.getString("name"));
                    System.out.println(findBlack.getString("type"));
                    System.out.println(findBlack.getString("hexcode"));
                    System.out.println(findBlack.getString("date_bought"));
                    break;
                case "find white":
                    query = "SELECT name,type,hexcode,date_bought FROM clothingitems where colourgroup = 'white'";
                    ResultSet findWhite = statement1.executeQuery(query);
                    System.out.println(findWhite.getString("name"));
                    System.out.println(findWhite.getString("type"));
                    System.out.println(findWhite.getString("hexcode"));
                    System.out.println(findWhite.getString("date_bought"));
                    break;
                case "add item":
                    //add a case statement to select object, and a scanner that can allow the user to add the new values.
                    //"INSERT INTO clothingitems " bla bla bla
                    //selectObject(name)

                    break;
                case "modify item":
                    //add a case statement to select object, and a scanner that can allow the user to add the modified values.
                    //selectObject(name)
                    //UPDATE table_name
                    //SET column1 = value1, column2 = value2, ...
                    //WHERE condition;
                    break;
                default: //This outputs the same answer as "SELECT * FROM clothingitems"
                    System.out.println("Error: Your selected query may be incorrect.");
                    query = "SELECT * FROM clothingitems";
                    ResultSet result1 = statement1.executeQuery(query);
                    while(result1.next()){
                        System.out.println(result1.getString("name"));
                        System.out.println(result1.getString("type"));
                        System.out.println(result1.getString("colourgroup"));
                        System.out.println(result1.getString("hexcode"));
                        System.out.println(result1.getString("date_bought"));
                    }
                    break;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */


            /*
            //all the code below is older code.
            //The code paragraph below can be used as a reference to make different queries.
            ResultSet resultSet = statement1.executeQuery(query);
            while(resultSet.next()) {
                switch (queryexecute) {
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
                        case
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
    public static String queryselector(String queryselect){
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
                        "(name,\n" +
                        "type,\n" +
                        "`colourgroup`,\n" +
                        "`hexcode`,\n" +
                        "`date_bought`)\n" +
                        "VALUES\n" +
                        "("+"\""+name+"\",\n" +
                        "("+"\""+type+"\",\n" +
                        "("+"\""+colourgroup+"\",\n" +
                        "("+"\""+hexcode+"\",\n" +
                        "("+"\""+date_bought+"\",\n" +
                        ");";
                        /* The values below need to be enclosed in comments, or removed.
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
        return queryselect;
    */
    }
}