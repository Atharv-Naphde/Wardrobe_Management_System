import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract class UI extends Actor
{
    /**
     * Act - do whatever the UI wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        getImage().scale(160,60); //Scales Buttons. Image size is 160*60.
    }
}
