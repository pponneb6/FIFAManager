import java.lang.Object;
import java.util.ArrayList;
/**
 * Write a description of class Team here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Team
{
    private String name;
    private int rating;
    ArrayList<Player> squad = new ArrayList<Player>();
    public Team(String s, int r){
        name = s;
        rating = r;
    }
    public void addPlayer(Player p){
        squad.add(p);
    }
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Name:" + name);
        sb.append("\tRating: " + rating);
        for(int i = 0; i<squad.size(); i++){
            sb.append("\nPlayer:" + squad.get(i).getName());
            sb.append("\tRating:" + squad.get(i).getRating());
        }
        return sb.toString();
    }
    public int getRating(){
        return rating;
    }
    public String getName(){
        return name;
    }
    
}
