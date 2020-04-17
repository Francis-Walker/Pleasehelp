//Author Francis Walker

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Menu extends JFrame implements ActionListener {

    //creates varible to store settings
    private String difficulty;
    private String mapSize;

    public String getDifficulty(){
        return difficulty;
    }


//menu class
    public Menu(String diff,String ms){
        difficulty = diff;
        mapSize = ms;

        //creates new frame, sets size and defaults
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(300,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("Menu");

        //creates new button and set respective titles
        JButton start = new JButton("START GAME");
        JButton settings = new JButton("SETTINGS");
        JButton controls = new JButton("CONTROLS");
        JButton exit = new JButton("EXIT");

        //creates label to display current settings
        JLabel currentSettings = new JLabel("Map Size: "+mapSize +"     Difficulty: "+difficulty);

        //sets absolute postion of buttons Label
        start.setBounds(25,50,240,75);
        settings.setBounds(25,150,240,75);
        controls.setBounds(25,250,240,75);
        exit.setBounds(25,350,240,75);
        currentSettings.setBounds(25,450,240,50);

        //add actionListener to compoenets
        start.addActionListener(this);
        settings.addActionListener(this);
        controls.addActionListener(this);
        exit.addActionListener(this);

        //adds components to frame
        frame.add(start);
        frame.add(settings);
        frame.add(controls);
        frame.add(exit);
        frame.add(currentSettings);

        //shows frame
        frame.setVisible(true);

    }

    //allows code to function when actions are performed
    @Override
    public void actionPerformed(ActionEvent ae) {
        int dim = 0;
        int numE = 0;
        int numB = 0;
        int lives=0;
        //displays placeholder when buttons are clicked
        String action = ae.getActionCommand();
        if (action.equals("START GAME")){

            if (mapSize.equalsIgnoreCase("SMALL"))
            {
                dim = 15;
            }else if (mapSize.equalsIgnoreCase("MEDIUM"))
            {
                dim = 20;
            }else if (mapSize.equalsIgnoreCase("LARGE"))
            {
                dim = 25;
            }

            if (difficulty.equalsIgnoreCase("EASY"))
            {

                numE = 2;
                numB = 5;
                lives=10;
            }else if (difficulty.equalsIgnoreCase("NORMAL"))
            {
                numE = 5;
                numB = 7;
                lives=5;
            }else if (difficulty.equalsIgnoreCase("HARD"))
            {
                numE = 10;
                numB = 5;
                lives=2;

            }
            System.out.println(""+dim+","+numE+","+numB );
            new Maze(dim,numE,numB,lives);

        }
        if (action.equals("SETTINGS")){
           // JOptionPane.showMessageDialog(null, "Settings Place holder!");
            //displays settings menu when settings is clicked
            dispose();
            SettingsMenu sm = new SettingsMenu();

        }
        if (action.equals("CONTROLS")){
            JOptionPane.showMessageDialog(null, "" +
                    " USE the arrow keys to move UP, DOWN, LEFT, RIGHT" +
                    "\n USE SPACE to shoot (The bullet will go in the direction you last moved)" +
                    "\n Your life is displayed at the bottom of the screen" +
                    "\n Basic enemies move and shoot randomly" +
                    "\n Elite enemies will try to kill you" +
                    "\n Your life is determined by difficulty (change in settings)" +
                    "\n If the Boss sees you it will shoot at you" +
                    "\n _________________________________________________________________________" +
                    "\n DIFFICULTY" +
                    "\n EASY: 10 lives, 5 Basic enemies, 2 Elite enemies"+
                    "\n MEDIUM: 5 lives, 7 Basic enemies, 5 Elite enemies"+
                    "\n HARD: 2 lives, 5 Basic enemies, 10 Elite enemies"
            );
        }
        if (action.equals("EXIT")){
            JOptionPane.showMessageDialog(null, "You have exited!");
            System.exit(0);
        }
    }

    //displays meun
    public static void main(String [] args){
        new Menu("normal","medium");
    }
}
