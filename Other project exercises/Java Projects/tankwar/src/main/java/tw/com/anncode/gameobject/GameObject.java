package tw.com.anncode.gameobject;

import java.awt.*;

// 最少的要求
// 注意修飾子選擇
public abstract class GameObject {
    // 位置
    protected int x;
    protected int y;
    protected int oldX;
    protected int oldY;
    protected int fram;

    // 圖片
    // ■ image➔image[] 因應可傳入多圖形陣列物件(坦克多圖形)
    protected Image[] image;

    // 取得物件長寬
    protected int width;
    protected int height;

    protected boolean alive;

    public GameObject(Image[] image, int x, int y) {
        this.x = x;
        this.y = y;
        this.image = image;
        width = image[0].getWidth(null);
        height = image[0].getHeight(null);
        alive = true;

    }

    // 繪圖
    public abstract void draw(Graphics g);

    // ■ 新增ai方法：偵測是否 移動/停止/開火
    public abstract void ai();

    // 物件跟物件碰撞偵測 ---> Rectangle 交集測試
    // 取得物件寬度
    public Rectangle getRectangle() {
        // 每次位置不一樣，但寬高一樣
        return new Rectangle(x, y, width, height);
    }

    public int[] getCenterPos(Rectangle rect) {
        int[] pos = new int[2];
        pos[0] = this.x + (width - rect.width) / 2;
        pos[1] = this.y + (height - rect.height) / 2;

        return pos;

    }

    public boolean getAlive() {
        return alive;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
