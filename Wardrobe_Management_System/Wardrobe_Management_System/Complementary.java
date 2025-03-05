import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.String;
import java.util.Scanner;
/**
  This class finds the complementary colours of the item the user requires.
  */
public class Complementary extends UI
{
    public Complementary()//constructor to test functioning of class.
    {
        /*
        HexcodeToInt("#aabbcc");
        int[] testInt ={170,187,204};
        IntToHexcode(testInt);
        */
       //ComplementaryColour("aabbcc");
    }
    public void act()
    {
        //Works like a Main function
        int[] testInt ={170,187,204}; //corresponds to AABBCC
        if (Greenfoot.mouseClicked(this)){
            //make a function that can detect what colour the user has chosen, and have that function call this function when it is required.
            /*
            System.out.println(HexcodeToInt("#AABBCC"));//this function does not work properly
            System.out.println(IntToHexcode(testInt));
            System.out.println("Value from final calculation is:");
            System.out.println(ComplementaryColour("#aabbcc"));
            */
            Scanner AB = new Scanner(System.in);
            System.out.println("Enter Colour Code");
            String input = AB.nextLine();
            System.out.println("Complementary Colour Code: "+ ComplementaryColour(input));
        }
    }
    String ComplementaryColour(String comp)
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
    public int[] HexcodeToInt(String Hexcode)// input values like #rrggbb
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
       RGB[0]=Integer.parseInt(Red,16);//converts base 16 value to integer
       RGB[1]=Integer.parseInt(Green,16);
       RGB[2]=Integer.parseInt(Blue,16);
       
       return RGB;
    }
    public String IntToHexcode(int[] RGB)
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
