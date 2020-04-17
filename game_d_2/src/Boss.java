public class Boss extends Entity {

    public Boss(int tile_x,int tile_y)
    {
        this.setFacing('l');
        this.setTileX(tile_x);
        this.setTileY(tile_y);
        this.setType("boss");
        this.setImg();
        this.setHealth(1);
    }

    public void hit() {
       // System.out.println("Boss hit" + this.getHealth());
        this.setHealth(this.getHealth() - 1);
    }
}
