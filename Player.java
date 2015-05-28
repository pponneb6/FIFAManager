
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player 
{
    private int rating;
    private String name;
    private String position ="";
    private String pos = "";
   
    public Player(String n, int r)
    {
        rating = r;
        name = n;
        position = pos;


    }
    public String getName(){
        return name;
    }
    public int getRating(){
        return rating;
    }

    
}
