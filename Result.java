
/**
 * Write a description of class Result here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Result
{   
    Team t1 = null;
    Team t2 = null;
    int t1Score = 0;     
    int t2Score = 0;
    public Result(Team team1, Team team2, int team1Score, int team2Score)    
    {
      t1 = team1;
      t2 = team2;
      t1Score = team1Score;
      t2Score = team2Score;
    }   
    public Team getWinningTeam(){
        if(t1Score>t2Score){
            return t1;
        }
        else if(t2Score>t1Score){
            return t2;
        }
        return null;
        
    }
    public String toString(){
        String s = t1.getName() +": "+t1Score+"    "+t2.getName()+": "+t2Score;
        return s;
    }
}
