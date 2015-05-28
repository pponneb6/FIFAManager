
/**
 * Write a description of class Simulater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Simulater
{

    public Simulater()
    {
    }

    public Result simulate(Team t1, Team t2) {
        
        int rate1 = t1.getRating();
        int rate2 = t2.getRating();
        int higher = 0;
        int lower = 0;
        Team teamHigh = null;
        Team teamLow = null;
        int prob = 0;
        int teamHighScore = 0;
        int teamLowScore = 0;   
        
        if(rate1>rate2){
            teamHigh = t1;
            teamLow = t2;
        }
        else if(rate2>rate1){
            teamHigh = t2;
            teamLow = t1;
        }
        
        
        //see what the difference is between the two teams
        if(Math.abs(rate1-rate2)==3){
            prob = 5;
        }
        else if(Math.abs(rate1-rate2)==2){
            prob = 4;
        }
        else if(Math.abs(rate1-rate2)==1){
            prob =3;
        }
        else{
            prob = 2;
        }
        int numberOfGoals = (int)(Math.random()*6)+0;
        int whoScored = 0;
        for(int i = 0; i<numberOfGoals;i++) {
            whoScored = (int)(Math.random()*prob)+1;
            if(prob == 5 ){
                
                if((whoScored == 1 || whoScored == 2 || whoScored ==3 || whoScored ==4)){
                    teamHighScore++;
                }
                else {
                    teamLowScore++;
                }

            }
            else if(prob == 4){
                
                if(whoScored == 1 || whoScored == 2 || whoScored ==3 ){
                    teamHighScore++;
                }
                else{
                    teamLowScore++;
                }
            }
            else if(prob == 3){
                
                if(whoScored == 1 || whoScored == 2 ){
                    teamHighScore++;
                }
                else{
                    teamLowScore++;
                }
            }
            else if(prob == 2){
                
                if(whoScored == 1 ){
                    teamHighScore++;
                }
                else{
                    teamLowScore++;
                }
            }
        }
        if(teamHighScore == teamLowScore){
            whoScored = (int)(Math.random()*2)+1;
            if(whoScored == 2){
                teamHighScore++;
            }
            else if(whoScored ==1){
                teamLowScore++;
            }
        }
        
        Result game = new Result(t1,t2,teamHighScore,teamLowScore);
        return game;
        
    }

}


