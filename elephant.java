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
    GreenfootImage [] idle = new GreenfootImage[8];
    
    /**
     * Constructor - The code that gets run one time when object is created
     */
    public Elephant()
    {
        for (int i = 0;i<idle.length;i++)
        {
            idle[i] = new GreenfootImage("images/idle" + i +".png");
        }
        setImage(idle[0]);
    }
    
    /*
     * Animate the elephant
     */
    int imageIndex = 0;
    public void animateElephant()
    {
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
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
        //Remove banana if elephant eats it
        
        //Animate the elephant
        animateElephant();
    
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
