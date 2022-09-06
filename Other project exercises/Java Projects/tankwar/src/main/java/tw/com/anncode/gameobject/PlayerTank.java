package tw.com.anncode.gameobject;

import java.awt.Image;

import tw.com.anncode.App;

public class PlayerTank extends Tank implements SuperFire {

    public PlayerTank(Image[] image, int x, int y, Direction direction, boolean enemy) {
        super(image, x, y, direction, enemy);
        setSpeed(10);
        hp = 3;
    }

    @Override
    public void superFire() {
        if (!alive) {
            return;
        }

        Bullet bullet = new Bullet(App.gameClient.getBulletImg(), x, y, getDirection(), getEnemy());
        int[] pos = getCenterPos(bullet.getRectangle());

        for (Direction direction : Direction.values()) {
            bullet = new Bullet(App.gameClient.getBulletImg(), pos[0], pos[1], direction, getEnemy());
            App.gameClient.getGameObject().add(bullet);
        }
    }

}
