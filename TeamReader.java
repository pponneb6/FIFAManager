import java.util.ArrayList;
import java.io.*;
import java.lang.Object;
import java.util.Scanner;

/**
 * Write a description of class TeamReader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TeamReader
{
    private ArrayList<Team> teams = new ArrayList<Team>();
    public TeamReader()
    { 
    }
    public void readTeams(){
        File folder = new File("Teams");
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String fileName = file.getName();
                String extension = "";

                int i = fileName.lastIndexOf('.');
                if (i > 0) {
                    extension = fileName.substring(i+1);
                }
                if (extension.equals("txt"))
                {
                    
                    readFile(fileName);
                }
            }
        } 
        
    }
    public void readFile(String fileName)
    {
        String line = null;
        

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader("Teams/"+fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);       
            int i = 0;
            Team t1 = null;
            
            while((line = bufferedReader.readLine()) != null) {
               
                String[] parts = line.split(",");
                String part1 = parts[0]; 
                String part2 = parts[1]; 
                if(i==0){
                    t1 = new Team(part1.trim(),Integer.parseInt(part2.trim()));
                }
                else{
                    Player p1 = new Player(part1.trim(),Integer.parseInt(part2.trim()));
                    t1.addPlayer(p1);
                }
                i++;
            } 
            teams.add(t1);
            

            // Always close files.
            bufferedReader.close();            
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                   
            // Or we could just do this: 
            // ex.printStackTrace();
        }

    }
    public String[] getTeamNames(){
        String[]  teamNames = new String[teams.size()];
        for(int i = 0; i<teams.size(); i++){
            teamNames[i] = teams.get(i).getName();
        }
        return teamNames;
    }
    public ArrayList<Team> getTeams(){
        return teams;
    }

   
}
