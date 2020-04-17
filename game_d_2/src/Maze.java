//Francis Walker
import javax.swing.*;

public class Maze {
    //provides basic frame map is projected into
    public static void main(String[] args)
    {
        new Maze(25,0,20 , 10);
    }
    public Maze(int dim, int numEilte, int numBasic, int numLives){
        //creates basic Frame to allow other functionality
        JFrame f = new JFrame();
        f.setTitle("MAZE GAME");
        //adds a board to the frame
//         dim = 25;
//         numEilte = 5;
//         numBasic=10 ;
        JOptionPane.showMessageDialog(null,"Press Okay to Start\n" +
                "You will not lose life until you move\n End the game by defeating the boss " +
                "and moving to the red square.\n GOOD LUCK!");
        f.add(new Board(dim,numEilte,numBasic,numLives));

        //sets size and starting location,
        f.setSize(dim*33,dim*37);
        f.setLocationRelativeTo(null);

        //makes frame visible
        f.setVisible(true);
        //stops program on close of frame
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
