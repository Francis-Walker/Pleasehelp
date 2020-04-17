public class Bullet extends Entity{
    private boolean isPlayers = false;

    public boolean isPlayers() {
        return isPlayers;
    }

    public void setPlayers(boolean players) {
        isPlayers = players;
    }

    public Bullet(int tile_x, int tile_y, char dir)
    {
            this.setTileX(tile_x);
            this.setTileY(tile_y);
            this.setType("Bullet1");
            this.setImg();
            this.setFacing(dir);

    }





}
