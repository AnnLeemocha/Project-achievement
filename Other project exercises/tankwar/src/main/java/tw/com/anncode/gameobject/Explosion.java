package tw.com.anncode.gameobject;

import java.awt.Graphics;
import java.awt.Image;

public class Explosion extends GameObject {

    public Explosion(Image[] image, int x, int y) {
        super(image, x, y);
        run();
    }

    //
    // 使用執行緒更新畫面
    public void run() {
        // 第二執行續
        // 顯示 Thread 的函式
        new Thread(() -> {
            while (alive) {
                try {
                    Thread.sleep(200);
                    if (++fram >= image.length) {
                        alive = false;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start(); // 說明開始
    }

    // ■ 進行動畫撥放
    @Override
    public void draw(Graphics g) {
        if (!alive) {
            return;
        }

        // 動畫?張
        g.drawImage(image[fram], x, y, null);
    }

    @Override
    public void ai() {

    }

}
