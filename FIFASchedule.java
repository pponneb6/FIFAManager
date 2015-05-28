import java.util.ArrayList;
/**
 * Write a description of class Schedule here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FIFASchedule
{
    private Team t1;
    private ArrayList<Team> listOfTeams = new ArrayList<Team>();
    public FIFASchedule(Team team1,ArrayList<Team> teams)
    {
        t1 = team1;
        listOfTeams = teams;
    }
    public String makeSchedule(){
        String s = "";
        for(int i = 0; i<listOfTeams.size(); i++){
            if(t1.getName() != listOfTeams.get(i).getName()){
            s+=t1.getName()+" vs. "+listOfTeams.get(i).getName() + "\n";
        }
        
        }
        return s;
     }

    
}
