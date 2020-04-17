public class BasicEnemy extends Entity {

    public BasicEnemy(int tile_x,int tile_y)
    {
        this.setFacing('d');
        this.setTileX(tile_x);
        this.setTileY(tile_y);
        this.setType("Basic_Enemy1");
        this.setImg();
    }

    public void hit(){

    }


}
