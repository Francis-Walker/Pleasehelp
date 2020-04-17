import javax.swing.*;
import java.sql.SQLOutput;

public class Player extends Entity {

    public Player(int tile_x,int tile_y)
    {
        this.setFacing('l');
        this.setTileX(tile_x);
        this.setTileY(tile_y);
        this.setType("player1");
        this.setImg();
        this.setHealth(5);
    }

    public void hit(){
        //System.out.println("Player hit" + this.getHealth());
        this.setHealth(this.getHealth()-1);

        if (this.getHealth()==0){
            JOptionPane.showMessageDialog(null, "You have died");
            //System.out.println("You Dead");
            System.exit(0);
        }
    }


}
