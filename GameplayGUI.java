import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class GameplayGUI extends JPanel implements ActionListener
{
    private JComboBox teamList = null;
    private JEditorPane textPane = null;
    private JEditorPane playTextPane = null;
    private JButton showTeamSheet, advanceGame;
    
    private JButton playButton = null;
    private ArrayList<Team> teams = new ArrayList<Team>();
    private String[] teamNames = null;
    private TeamReader teamReader = new TeamReader();
    private String chosenTeamName = null;
    private Team chosenTeam = null;

    
    public GameplayGUI()
    {

        super(new BorderLayout());
        //super(new GridLayout(1,1));
        
        teamReader.readTeams();
        teamNames = teamReader.getTeamNames();
        teams = teamReader.getTeams();

        JTabbedPane tabbedPane = new JTabbedPane();
        
        JPanel manageTeamPanel = createManageTeamPanel();
        tabbedPane.add("Manage Team", manageTeamPanel);
        
        JPanel playGamePanel = createPlayGamePanel();
        tabbedPane.add("Play Game", playGamePanel);
        
        
        add(tabbedPane, BorderLayout.CENTER);

    }
    
    private JPanel createManageTeamPanel() {
        
        JPanel panel = new JPanel(new BorderLayout());
        
        teamList = new JComboBox(teamNames);
       
        teamList.addActionListener(this);

        textPane = new JEditorPane(); 
        textPane.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension(500, 500));
        
        panel.add(teamList, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createPlayGamePanel() {
        
        JPanel panel = new JPanel(new BorderLayout());
        
        JPanel buttonPanel =  new JPanel(new FlowLayout());
        playButton = new JButton("Play");
        playButton.addActionListener(this);
        
        buttonPanel.add(playButton);
       
        playTextPane = new JEditorPane(); 
        playTextPane.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(playTextPane);
        scrollPane.setPreferredSize(new Dimension(500, 500));
        
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
        
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("FIFA Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new GameplayGUI();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed (ActionEvent event)
    {
        if (event.getSource() == teamList) {

            JComboBox cb = (JComboBox)event.getSource();
        
            chosenTeamName = (String)cb.getSelectedItem();
            for(int l = 0; l<teams.size(); l++){
                if(teams.get(l).getName().equals(chosenTeamName)){
                    chosenTeam = teams.get(l);
                    break;
                }

            }
            
            textPane.setText(chosenTeam.toString());
            playTextPane.setText("");
            
        }
        else if(event.getSource() == playButton) {
            Simulater sim = new Simulater();
            
            for (int i=0; i<teams.size(); i++) {
                if(chosenTeam.getName()!=teams.get(i).getName()) {
                    Result r = sim.simulate(chosenTeam, teams.get(i));
                    String s = playTextPane.getText() + "\n" + r.toString();
                    playTextPane.setText(s);
                }
            }
            
        }
    }
    

}
    

