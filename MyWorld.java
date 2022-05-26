import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        Elephant e = new Elephant();
        addObject(e,300,350);
        
        scoreLabel = new Label(0,80);
        addObject(scoreLabel,50,50);
        
        spawnBanana();
        
    }
    
    /**
     * End the game and draw 'GameOver'
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("GameOver",100);
        addObject(gameOverLabel,300,200);
    }
    public void spawnBanana()
    {
        Banana a = new Banana();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(a,x,y);
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
}
