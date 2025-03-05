import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** This class is the background for the program's UI. All UI elements
 * exist on top of this layer.
 */
public class UI_Background extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public UI_Background()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
         //Final size should be 1920 x 1080 pixels. (1920, 1080, 1);
        super(192*6, 108*6, 1); 
        
        //positions centere of image to center of background
        //addObject(new Placeholder_Image(),96*6,54*6); //remove once all elements are in place.
        
        
        //Interaction Menu Items below
        addObject(new Menu_Container(),1024,224); //Menu Container, background
        addObject(new Complementary(),1024,84); //Complementary Find Button
        addObject(new Add_Item(),1024,154); //Add Item Button
        addObject(new Modify_Item(),1024,224); //Modify Item Button
        addObject(new Remove_Item(),1024,364); //Remove Item Button

        
        //ItemCard UI below
        addObject(new ItemCard_Background(),236,324); //Item Card background Left
        addObject(new ItemCard_Background(),656,324); //Item Card background Right
        
        
        //Database Navigation UI below
        addObject(new Navigation_Background(),1010,534);
        //NativeLoader loader = new NativeLoader();
        
    }
}
