package tw.com.anncode.gameobject;

import java.awt.*;

// Tank 動態
// Wall 靜態
public class Wall extends GameObject {

    // // 位置 ===================> 已優化
    // private int x;
    // private int y;

    // 連續非單塊
    // 水平 OR 垂直
    private boolean horizontal;
    // 數量
    private int bricks;
    // // 圖形 ===================> 已優化
    // private Image image;

    public Wall(Image[] image, int x, int y, boolean horizontal, int bricks) {
        super(image, x, y);
        // this.x = x; ===================> 已優化
        // this.y = y; ===================> 已優化
        this.horizontal = horizontal;
        this.bricks = bricks;
        // this.image = image; ===================> 已優化
    }

    // ===================> 已優化
    // public int getX() {
    // return this.x;
    // }
    // public void setX(int x) {
    // this.x = x;
    // }
    // public int getY() {
    // return this.y;
    // }
    // public void setY(int y) {
    // this.y = y;
    // }

    public boolean isHorizontal() {
        return this.horizontal;
    }

    public boolean getHorizontal() {
        return this.horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public int getBricks() {
        return this.bricks;
    }

    public void setBricks(int bricks) {
        this.bricks = bricks;
    }

    // ===================> 已優化
    @Override
    public void draw(Graphics g) {
        for (int i = 0; i < bricks; i++) {
            if (horizontal) {
                g.drawImage(image[0], x + i * width, y, null);
                // g.drawImage(image, x + i * image.getWidth(null), y, null);
            } else {
                g.drawImage(image[0], x, y + i * height, null);
                // g.drawImage(image, x, y + i * image.getHeight(null), null);
            }
        }

    }

    // 碰撞 (覆寫getRectangle方法)
    // 牆連成一條
    @Override
    public Rectangle getRectangle() {
        if (horizontal) {
            return new Rectangle(x, y, bricks * width, height);
        }
        return new Rectangle(x, y, width, bricks * height);
    }

    @Override
    public void ai() {

    }

}
