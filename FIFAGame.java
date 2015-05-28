import java.util.ArrayList;
import java.io.*;
import java.lang.Object;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class fifagame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FIFAGame 
{
   
   
    
    public static void main(String [ ] args) {
        Team chosenTeam = null;
        // reading files that contain team info
        TeamReader teamReader = new TeamReader();
        teamReader.readTeams();
        ArrayList<Team> teams = teamReader.getTeams();

        System.out.println("\n"+"\n");
        System.out.println("Teams To Choose From:");
        for(int k = 0; k<teams.size(); k++){
            System.out.println(teams.get(k).getName());
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("\n");
        System.out.print("What Team do you Pick: ");
        String s = sc.nextLine();

        for(int l = 0; l<teams.size(); l++){
            if(teams.get(l).getName().equals(s)){
                chosenTeam = teams.get(l);
                break;
            }

        }
        System.out.println( "       2015 Season Schedule       ");
        FIFASchedule s1 = new FIFASchedule(chosenTeam, teams);
        System.out.println(s1.makeSchedule());
        Simulater sim = new Simulater();
        //for(int a = 0; a<teams.size(); a++){
        int decision = 1;
        int a = 0;
        while(decision == 1){
            if(decision ==1){

                if(chosenTeam.getName()!=teams.get(a).getName()){
                    System.out.println(sim.simulate(chosenTeam,teams.get(a)).toString());
                }
                a++;
                if (a == teams.size()){
                    break;
                }
            }
            System.out.print(" Enter 1 to advance to next game or enter 0 to quit: ");
            decision = sc.nextInt();
        }

        

    }

}
