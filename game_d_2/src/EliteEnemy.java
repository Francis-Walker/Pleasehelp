import java.lang.Math;

public class EliteEnemy extends Entity {

    public EliteEnemy(int tile_x, int tile_y) {
        this.setFacing('d');
        this.setTileX(tile_x);
        this.setTileY(tile_y);
        this.setType("Elite_Enemy1");
        this.setImg();
    }

    public boolean ai(int playerX, int playerY) {
        int dx = this.getTileX() - playerX;
        int dy = this.getTileY() - playerY;
        boolean check = false;

        if (Math.abs(dx) <1) {
            if (dy < 0) {
                this.setFacing('d');
                check = true;
            } else {
                this.setFacing('u');
                check = true;
            }

        } else if (Math.abs(dy) <1) {
            if (dx < 0) {
                this.setFacing('r');
                check = true;
            } else {
                this.setFacing('l');
                check = true;
            }

        } else if (Math.abs(dx) < Math.abs(dy)) {
            if (dx < 0) {
                this.setFacing('r');

            } else {
                this.setFacing('l');

            }

        } else{
            if (dy < 0) {
                this.setFacing('d');

            } else {
                this.setFacing('u');

            }
        }
        return check;
    }
}
