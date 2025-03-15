import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class CRUDE {
    //This class is made for executing the CRUDE of the database. Create, Read, Update, Delete, Execute.

    static final String url = "jdbc:mysql://127.0.0.1:3306/login_schema";
    static final String username = "root";
    static final String password = "SQL_Admin";

    //The connect function exists only as a placeholder to test the connection to the database.
    private void connect() { //Copy this syntax everytime a connection needs to be made.
        //copy the try catch block into the individual functions.
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void display(){
        System.out.println("-------------------------------------------------------------");
        System.out.println("Welcome to the Wardrobe Management System!");
        System.out.println("Program menu:");
        System.out.println("1. Show all items");
        System.out.println("2. Add item to database");
        System.out.println("3. Remove item from database");
        System.out.println("4. Modify an item");
        System.out.println("5. Find items by colour");
        System.out.println("6. Find Complement! (This does not currently work)");
        System.out.println("-------------------------------------------------------------");

        Scanner menuSelect=new Scanner(System.in);
        int exit = 0;
        while(exit!=1){
            switch(menuSelect.nextInt()){
                case 1:
                    showAllItems();
                    System.out.println("Press 0 to exit, 1 to continue. Otherwise, select from 1-6 again.");
                    if(menuSelect.nextInt()==0)
                        exit=1;
                    break;
                case 2:
                    System.out.println("Enter name");
                    String addName = menuSelect.nextLine();
                    System.out.println("Enter type");
                    String addType = menuSelect.nextLine();
                    System.out.println("Enter colourgroup");
                    String addColourgroup = menuSelect.nextLine();
                    System.out.println("Enter hexcode");
                    String addHexcode = menuSelect.nextLine();
                    CRUDE.addValues(addName, addType, addColourgroup, addHexcode);
                    System.out.println("Item(s) added!");
                    //CRUDE.modifyValues(testName,testType, testColourgroup, testHexcode);
                    System.out.println("Press 0 to exit, 1 to continue. Otherwise, select from 1-6 again.");
                    if(menuSelect.nextInt()==0)
                        exit=1;
                    break;
                case 3:
                    System.out.println("Enter name of item you wish to delete.");
                    String deleteName = menuSelect.nextLine();
                    deleteItem(deleteName);
                    System.out.println("Item(s) deleted!");
                    System.out.println("Press 0 to exit, 1 to continue. Otherwise, select from 1-6 again.");
                    if(menuSelect.nextInt()==0)
                        exit=1;
                    break;
                case 4:
                    System.out.println("Enter name");
                    String testName = menuSelect.nextLine();
                    System.out.println("Enter type");
                    String testType = menuSelect.nextLine();
                    System.out.println("Enter colourgroup");
                    String testColourgroup = menuSelect.nextLine();
                    System.out.println("Enter hexcode");
                    String testHexcode = menuSelect.nextLine();
                    //CRUDE.addValues(testName,testType, testColourgroup, testHexcode);
                    CRUDE.modifyValues(testName,testType, testColourgroup, testHexcode);
                    System.out.println("Item(s) modified!");
                    System.out.println("Press 0 to exit, 1 to continue. Otherwise, select from 1-6 again.");
                    if(menuSelect.nextInt()==0)
                        exit=1;
                    break;
                case 5:
                    System.out.println("Enter the colour you wish to search");
                    setColour(menuSelect.next());
                    findColour();
                    System.out.println("Press 0 to exit, 1 to continue. Otherwise, select from 1-6 again.");
                    if(menuSelect.nextInt()==0)
                        exit=1;
                    break;
                case 6:
//                    System.out.println("Enter the hexcode you want the complementary of");
//                    System.out.println("The complementary colour is: "+ComplementaryColour(menuSelect.next()));
                    System.out.println("This function does not work. Press 0 to exit, 1 to continue. Otherwise, select from 1-6 again.");
                    if(menuSelect.nextInt()==0)
                        exit=1;
                    break;
                default:
                    showAllItems();
                    System.out.println("Press 0 to exit, 1 to continue. Otherwise, select from 1-6 again.");
                    if(menuSelect.nextInt()==0)
                        exit=1;
                    break;


            }
        }

    }

    static StringBuilder itemNameList = new StringBuilder("Placeholder Items List");
    public static void showAllItems(){ //Performs Read part of CRUDE
        itemNameList.delete(0,itemNameList.length());
        String query = "SELECT * FROM clothingitems";
            try {
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
                while(result.next()) {
                    System.out.println(result.getString("name"));
                    itemNameList.append(result.getString("name")+ "\n");
                    System.out.println(result.getString("type"));
                    //itemsList.append(result.getString("type")+ "\n");
                    System.out.println(result.getString("colourgroup"));
                    //itemsList.append(result.getString("colourgroup")+ "\n");
                    System.out.println(result.getString("hexcode"));
                    //itemsList.append(result.getString("hexcode")+ "\n");
                    System.out.println(result.getString("date_bought"));
                    //itemsList.append(result.getString("date_bought")+ "\n");

                }
                result.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

    public static String displayItemNames(){
        showAllItems();
        String ListOfItems = itemNameList.toString();
        return ListOfItems;
    }

    public static String[] selectItem(String namei){
        String[] resultString = new String[5];
        String query = "SELECT * FROM clothingitems WHERE name = '"+namei+"'";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()) {
                System.out.println(result.getString("name"));
                resultString[0]=String.valueOf(result.getString("name"));
                System.out.println(result.getString("type"));
                resultString[1]=String.valueOf(result.getString("type"));
                System.out.println(result.getString("colourgroup"));
                resultString[2]=String.valueOf(result.getString("colourgroup"));
                System.out.println(result.getString("hexcode"));
                resultString[3]=String.valueOf(result.getString("hexcode"));
                System.out.println(result.getString("date_bought"));
                resultString[4]=String.valueOf(result.getString("date_bought"));
            }
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultString;
    }


    static private String colour= "black";
    public static void setColour(String setter){
        colour=setter;
    }
    static String allColour ="";
    public static void findColour(){
        String query = "SELECT name,type,hexcode,date_bought FROM clothingitems where colourgroup = '"+colour+"'";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()) {
                System.out.println(result.getString("name"));
                allColour += String.valueOf(result.getString("name")) + "\n";
                System.out.println(result.getString("type"));
                //System.out.println(result.getString("colourgroup")); //still does not work.
                System.out.println(result.getString("hexcode"));
                System.out.println(result.getString("date_bought"));
            }
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getAllColour(){
        return allColour;
    }

    public static String typeSearch(String typei){
        String allType ="";
        String query = "SELECT name FROM clothingitems where type = '"+typei+"'";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()) {
                System.out.println(result.getString("name"));
                allType += String.valueOf(result.getString("name")) + "\n";
            }
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allType;
    }

    public static String hexcodeSearch(String hexcodei){
        String allType ="";
        String query = "SELECT name FROM clothingitems WHERE hexcode = '"+hexcodei+"'";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()) {
                System.out.println(result.getString("name"));
                allType += String.valueOf(result.getString("name")) + "\n";
            }
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allType;
    }

    public static String dateSearch(String datei){
        String allType ="";
        String query = "SELECT name FROM clothingitems WHERE date_bought = '"+datei+"'";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()) {
                System.out.println(result.getString("name"));
                allType += String.valueOf(result.getString("name")) + "\n";
            }
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allType;
    }

    //The variables and method below are responsible for setting values for update functions
    private static String name = "Test cloth: Placeholder"; //Placeholder Values
    private static String type = "top"; //Placeholder Values
    private static String colourgroup = "black"; //Placeholder Values
    private static String hexcode = "#FFFFFF"; //Placeholder Values
    private static String date_bought = "2020-12-20";


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
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Item added!");
    }
    public static void modifyValues(String namei, String typei, String colourgroupi, String hexcodei) {
        //This statement is responsible for setting values that need to be added or modify
        name = namei;//.substring(0, 44);
        type = typei;//.substring(0, 44);
        colourgroup = colourgroupi;//.substring(0, 44);
        hexcode = hexcodei;//.substring(0, 6);
        LocalDate date_boughti = LocalDate.now(); // Create a date object
        date_bought = String.valueOf(date_boughti);
        String query = "UPDATE clothingitems\n" +
                "SET type = '"+type+"', colourgroup = '"+colourgroup+"', hexcode = '"+hexcode+"', date_bought = '"+date_bought+"'\n" +
                "WHERE name = '"+name+"';";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            PreparedStatement p=null;
            p =connection.prepareStatement(query);
            p.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Item modified!");
    }

    public static void deleteItem(String namei){
        String query = "DELETE FROM clothingitems WHERE name= '"+namei+"';";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            PreparedStatement p=null;
            p =connection.prepareStatement(query);
            p.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Item deleted!");
    }




    //Below this comment is the function to find complementary colour.
    static String ComplementaryColour(String comp)
    {
        /*call the HexcodeToInt() function
         * subtract int values from 255
         * call the IntToHexcode() function
         */
        int[] calculate=HexcodeToInt(comp);
        for(int i=0;i<=2;i++)
        {
            calculate[i]=(255-calculate[i]);
        }
        return IntToHexcode(calculate);
    }

    /**converts text into array of separate integer values.
     * this function currently does not work for all input vales.
     */
    public static int[] HexcodeToInt(String Hexcode)// input values like #rrggbb
    {
        String Red = Hexcode.substring(1,3);
        String Green = Hexcode.substring(3,5);
        String Blue = Hexcode.substring(5);
        /*int[] RGB = new int[3];
        RGB[0]= Integer.valueOf(Red);
        RGB[1]=Integer.valueOf(Green);
        RGB[2]=Integer.valueOf(Blue);
        */
        int[] RGB = new int[3];
        //If error throws, convert radix from 10 to 16.
        RGB[0]=Integer.parseInt(Red,10);//converts base 16 value to integer
        RGB[1]=Integer.parseInt(Green,10);
        RGB[2]=Integer.parseInt(Blue,10);

        return RGB;
    }
    public static String IntToHexcode(int[] RGB)
    {
        //Returns a hexadecimal code that is readable by user.
        String Hexcode= "#";
        for(int i=0;i<=2;i++)
        {
            //Hexcode+= String.valueOf(RGB[i]);
            Hexcode+= decToHex(RGB[i]);
        }
        return Hexcode;
    }
    /** decToHex is a function used to convert decimal values into hexadecimal.
     * Source: https://www.geeksforgeeks.org/java-program-for-decimal-to-hexadecimal-conversion/
     */
    static String decToHex(int n)
    {
        // Creating an array to store octal number
        int[] hexNum = new int[100];

        // counter for hexadecimal number array
        int i = 0;
        while (n != 0) {

            // Storing remainder in hexadecimal array
            hexNum[i] = n % 16;
            n = n / 16;
            i++;
        }

        // Printing hexadecimal number array
        // in the reverse order
        String output="";
        for (int j = i - 1; j >= 0; j--) {
            if (hexNum[j] > 9)
                output+= (char)(55 + hexNum[j]);
            else
                output+= hexNum[j];
        }
        return output;
    }
}
