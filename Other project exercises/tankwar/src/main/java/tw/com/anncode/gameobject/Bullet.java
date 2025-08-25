package tw.com.anncode.gameobject;

import java.awt.*;
import tw.com.anncode.App;
// import tw.com.anncode.GameClient;

// 與 Tank 行為相似，繼承Tank類別
public class Bullet extends Tank {

    private int damage;

    // 若父類有空建構式，可不寫建構式 ---> 但這裡嚴格依些賦與
    public Bullet(Image[] image, int x, int y, Direction direction, boolean enemy) {
        super(image, x, y, direction, enemy);
        this.setSpeed(10);
    }

    public int getDamage() {
        return damage;
    }

    // 覆載

    // 子彈有限制，不要一直飛 ...
    @Override
    public void draw(Graphics g) {
        if (!alive) {
            return;
        }

        move(); // 移動
        collosion(); // 碰撞

        g.drawImage(image[getDirection().ordinal()], x, y, null);
    }

    // 碰撞
    @Override
    public void collosion() {
        if (isCollosionBound()) {
            alive = false;
            return;
        }

        // 跟其物件偵測
        // 偵測其他物件(使用多型)
        for (GameObject object : App.gameClient.getGameObject()) {
            if (object == this) {
                continue;
            }

            if (object instanceof Tank) {

                // 向下轉型
                if (((Tank) object).getEnemy() == getEnemy()) {
                    continue;
                }

                // 讓子彈碰到敵方坦克時，敵方坦克也會消失
                if (getRectangle().intersects(object.getRectangle())) {
                    App.gameClient.getGameObject().add(
                            new Explosion(App.gameClient.getExplosionImg(), object.getX(), object.getY()));
                    ((Tank) object).getHurt(damage);
                    // object.alive = false;
                    // 避免貫穿彈
                    alive = false;
                    continue;
                }

            }

            // 實際偵測碰撞
            if (getRectangle().intersects(object.getRectangle())) {
                App.gameClient.getGameObject().add(
                        new Explosion(App.gameClient.getExplosionImg(), object.getX(), object.getY()));
                alive = false;
                return;
            }

        }
    }

}
