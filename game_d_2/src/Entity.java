import javax.swing.*;
import java.awt.*;

public class Entity {
    private int tileX,tileY;
    private int health;
    private boolean isAlive;
    private Image img;
    private char facing;
    private String type;

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int changHealth) {
        this.health = changHealth;

    }

    public Image getImg() {
        return img;
    }

    public void setImg() {
        //ImageIcon load = new ImageIcon("resources/CharactarIcons/"+this.getType()+".png");
        ImageIcon load = new ImageIcon(getClass().getResource(this.getType()+".png")) ;
        this.img = load.getImage();
    }

    public char getFacing() {
        return facing;
    }

    public void setFacing(char facing) {
        this.facing = facing;
    }

    public int getTileX() {
        return tileX;
    }

    public void setTileX(int tileX) {
        this.tileX = tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public void setTileY(int tileY) {
        this.tileY = tileY;
    }

    //move entity by parsed change in tiles
    public void move(int dx, int dy)
    {

        tileX = tileX+(dx);
        tileY = tileY+(dy);

    }
    public void move() {

        if(this.getFacing()=='u'){
            this.setTileY(this.getTileY()-1);
        }else
        if(this.getFacing()=='d'){
            this.setTileY(this.getTileY()+1);
        }else
        if(this.getFacing()=='l'){
            this.setTileX(this.getTileX()-1);
        }else
        if(this.getFacing()=='r'){
            this.setTileX(this.getTileX()+1);
        }

    }

    public Bullet shoot(){
       // System.out.println("shoot");
        Bullet bul = new Bullet(this.tileX,this.tileY,this.facing);
        //bul.move();
        return bul;
    }





}
