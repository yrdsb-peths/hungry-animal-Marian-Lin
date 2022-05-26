import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class elephant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound elephantSound = new GreenfootSound("elephant5.mp3");
    GreenfootImage idle = new GreenfootImage("images/idle0.png");
    
    /**
     * Constructor - The code that gets run one time when object is created
     */
    public Elephant()
    {
        setImage(idle);
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("d"))
        {
            move(3);
        }
        if(Greenfoot.isKeyDown("a"))
        {
            move(-3);
        }   
        
        if(isTouching(Banana.class))
        {
            removeTouching(Banana.class);
            MyWorld world = (MyWorld)getWorld();
            world.increaseScore();
            world.spawnBanana();
            elephantSound.play();
        }
    }
}
