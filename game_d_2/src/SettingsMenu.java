import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


//extends JFrame implements ActionListener

    public class SettingsMenu extends JFrame implements ActionListener  {

        private JComboBox<String> difficulty;
        JComboBox<String> mapSize;

        public SettingsMenu(){
            //creates new frame and sets defaults
            JFrame frame = new JFrame();
            frame.setLayout(null);
            frame.setSize(300,500);
            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //creates arrays to stores the various settings values
            String[] difficultyOption = {"EASY", "NORMAL", "HARD"};
            String[] mapSizeOption = {"SMALL", "MEDIUM", "LARGE"};

            //creates dropdown to allow to select settings
            difficulty = new JComboBox<String>(difficultyOption);
            mapSize = new JComboBox<String>(mapSizeOption);

            //creates buttons to allow user flow and saving of changed settings
            JButton confirm = new JButton("CONFIRM");
            JButton back = new JButton("BACK");

            //creates labels to direct user which setting they are changing
            JLabel difficultyLabel = new JLabel("Difficulty");
            JLabel mapSizeLabel = new JLabel("Map Size");

            //set absolute postions of components
            difficultyLabel.setBounds(25,20,250,25);
            difficulty.setBounds(25,50,250,75);

            mapSizeLabel.setBounds(25,130,250,25);
            mapSize.setBounds(25,160,250,75);

            back.setBounds(25,250,100, 75);
            confirm.setBounds(150,250,100, 75);


            //adds components to frame
            frame.add(mapSize);
            frame.add(difficulty);
            frame.add(back);
            frame.add(confirm);
            frame.add(difficultyLabel);
            frame.add(mapSizeLabel);

            frame.setTitle("Settings Menu");
            frame.setVisible(true);




            //add actionListener to compoenets
            back.addActionListener(this);
            confirm.addActionListener(this);

}
        //allows code to function when actions are performed
        @Override
        public void actionPerformed(ActionEvent ae) {

            //displays placeholder when buttons are clicked
            String action = ae.getActionCommand();
            if (action.equals("CONFIRM")){
                dispose();
                String diff = ""+ Objects.requireNonNull(this.difficulty.getSelectedItem()).toString();
                String ms = ""+Objects.requireNonNull(this.mapSize.getSelectedItem()).toString();
                new Menu(diff,ms);

            }
        }

    }
