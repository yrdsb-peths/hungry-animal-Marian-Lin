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
    GreenfootImage [] idlea = new GreenfootImage[8];
    GreenfootImage [] idled = new GreenfootImage[8];
    
    //Direction the elephant is facing
    String facing = "a";
    SimpleTimer animtionTimer = new SimepaleTimer
    /**
     * Constructor - The code that gets run one time when object is created
     */
    public Elephant()
    {
        for (int i = 0;i<idlea.length;i++)
        {
            idlea[i] = new GreenfootImage("images/idle" + i +".png");
            idlea[i].scale(100,100);
        }
        for(int i = 0;i <idled.length;i++)
        {
            idled[i] = new GreenfootImage("images/idle" + i +".png");
            idled[i].mirrorHorizontally();
            idled[i].scale(100,100);
        }
        
        animationTimer.mark();
        //Initial elephant image
        setImage(idlea[0]);
    }
    
    /*
     * Animate the elephant
     */
    int imageIndex = 0;
    public void animateElephant()
    {   
        if(animationTimer.millisElapsed()<100)
        {
            return;
        }
        animationTimer.mark();
        if(facing.equals("a"))
        {
            setImage(idlea[imageIndex]);
            imageIndex = (imageIndex + 1) % idlea.length;
        }
        else
        {
            setImage(idled[imageIndex]);
            imageIndex = (imageIndex + 1) % idled.length;
        }
    }    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("d"))
        {
            move(3);
            facing = "a";
        }
        if(Greenfoot.isKeyDown("a"))
        {
            move(-3);
            facing = "d";
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
