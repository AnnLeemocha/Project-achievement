package tw.com.anncode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
// import java.util.Iterator;
// import java.util.ArrayList;
// import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import tw.com.anncode.gameobject.*;

// ■ 主遊戲邏輯跟圖形顯示
// 1.GameClient繼承JComponent類別(擁有繪製功能)
public class GameClient extends JComponent {

    private int screenWidth;
    private int screenHeight;

    // 玩家坦克
    private PlayerTank playerTank;
    // private Tank playerTank;

    // // 敵方坦克
    // private List<Tank> enemyTanks = new ArrayList<>();

    // // 牆
    // private List<Wall> walls = new ArrayList<>();

    // 使用父類別進行集合類型宣告
    private CopyOnWriteArrayList<GameObject> gameObjects = new CopyOnWriteArrayList<GameObject>();
    // private ArrayList<GameObject> gameObjects = new ArrayList<>();

    public Image[] bulletImg;
    public Image[] brickImg;
    public Image[] iTankImg;
    public Image[] eTankImg;
    public Image[] explosionImg;

    GameClient() {
        this(800, 600); // 呼叫多載
        // this.setPreferredSize(new Dimension(800, 600));
    }

    // 保留空建構式
    public GameClient(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        init();
    }

    // 讀取圖形
    // ■ init()方法調整讀取圖形方法
    // ■ 統一外部讀取後傳入
    void init() {

        brickImg = new Image[] { new ImageIcon("assets/images/brick.png").getImage() };
        // Image[] brickImg = { Tools.getImage("brick.png") };
        // 根據 Direction 順序：
        // UP, DOWN, LEFT, RIGHT, UP_LEFT, DOWN_LEFT, UP_RIGHT, DOWN_RIGHT
        String[] sub = { "U.png", "D.png", "L.png", "R.png", "LU.png", "LD.png", "RU.png", "RD.png" };
        iTankImg = new Image[sub.length]; // 八方位 (圖)
        eTankImg = new Image[sub.length]; // 八方位 (圖)
        // Image[] iTankImg = new Image[sub.length]; // 八方位 (圖)
        // Image[] eTankImg = new Image[sub.length]; // 八方位 (圖)
        bulletImg = new Image[sub.length]; // 八方位 (圖)
        // Image[] bulletImg = new Image[sub.length]; // 八方位 (圖)
        explosionImg = new Image[11];

        for (int i = 0; i < explosionImg.length; i++) {
            explosionImg[i] = Tools.getImage(i + ".png");
        }

        // new Bullet(image, x, y, direction, enemy)
        for (int i = 0; i < iTankImg.length; i++) {
            // 給錯路徑不報錯，即null不顯示圖 (自己檢查)
            iTankImg[i] = Tools.getImage("itank" + sub[i]);
            eTankImg[i] = Tools.getImage("etank" + sub[i]);
            bulletImg[i] = Tools.getImage("missile" + sub[i]);
        }

        // 預設位置
        playerTank = new PlayerTank(iTankImg, 400, 500, Direction.UP, false);
        // playerTank = new Tank(iTankImg, 400, 500, Direction.UP, false);
        playerTank.setSpeed(10);
        gameObjects.add(playerTank);
        // 子彈 Direction.DOWN, true));

        // 敵方
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                gameObjects.add(new Tank(eTankImg, 220 + j * 60, 50 + i * 60, Direction.DOWN, true));
                // enemyTanks.add(new Tank(eTankImg, 220 + j * 60, 50 + i * 60, Direction.DOWN,
                // true));
            }
        }
        // gameObjects.addAll(enemyTanks);

        // 牆
        gameObjects.add(new Wall(brickImg, 80, 10, false, 10));
        gameObjects.add(new Wall(brickImg, 190, 10, true, 15));
        gameObjects.add(new Wall(brickImg, 720, 10, false, 10));
        // walls.add(new Wall(brickImg, 80, 10, false, 10));
        // walls.add(new Wall(brickImg, 190, 10, true, 15));
        // walls.add(new Wall(brickImg, 720, 10, false, 10));
        // Image wallImg = new ImageIcon("assets/images/brick.png").getImage();
        // walls.add(new Wall(wallImg, 80, 10, false, 10));
        // walls.add(new Wall(wallImg, 190, 10, true, 15));
        // walls.add(new Wall(wallImg, 720, 10, false, 10));
        // gameObjects.addAll(walls);

        initGame();
    }

    public void geneWall(int nums) {
        Random random = new Random();

        for (int i = 0; i < nums; i++) {
            int x = random.nextInt(screenWidth - brickImg[0].getWidth(null));
            int y = random.nextInt(screenHeight - brickImg[0].getHeight(null));

            gameObjects.add(new Wall(brickImg, x, y, false, 1));
        }
    }

    public Image[] getExplosionImg() {
        return explosionImg;
    }

    // public ArrayList<GameObject> getGameObject() {
    // return this.gameObjects;
    // }

    public CopyOnWriteArrayList<GameObject> getGameObject() {
        return this.gameObjects;
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    // public void setScreenWidth(int screenWidth) {
    // this.screenWidth = screenWidth;
    // }

    public int getScreenHeight() {
        return this.screenHeight;
    }

    // public void setScreenHeight(int screenHeight) {
    // this.screenHeight = screenHeight;
    // }

    public Image[] getBulletImg() {
        return bulletImg;
    }

    public void keyPressed(KeyEvent e) {
        boolean[] dirs = playerTank.getDirs(); // 傳址
        // (0,0) 在左上
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                dirs[0] = true;
                // System.out.println("up!");
                // playerTank.setDirection(Direction.UP);
                // // 遞減
                // playerTank.setY(playerTank.getY() - 5);
                break;
            case KeyEvent.VK_DOWN:
                dirs[1] = true;
                // System.out.println("down!");
                // playerTank.setDirection(Direction.DOWN);
                // // 遞增
                // playerTank.setY(playerTank.getY() + 5);
                break;
            case KeyEvent.VK_LEFT:
                dirs[2] = true;
                // System.out.println("left!");
                // playerTank.setDirection(Direction.LEFT);
                // // 遞減
                // playerTank.setX(playerTank.getX() - 5);
                break;
            case KeyEvent.VK_RIGHT:
                dirs[3] = true;
                // System.out.println("right!");
                // playerTank.setDirection(Direction.RIGHT);
                // // 遞增
                // playerTank.setX(playerTank.getX() + 5);
                break;
            case KeyEvent.VK_SPACE:
                playerTank.fire();
                break;
            case KeyEvent.VK_CONTROL:
                playerTank.superFire();
                break;
            case KeyEvent.VK_Z:
                initGame();
                break;
            default:
                break;
        }
        // 移去 draw
        // playerTank.move();
    }

    // 釋放
    public void keyReleased(KeyEvent e) {
        boolean[] dirs = playerTank.getDirs(); // 傳址
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                dirs[0] = false;
                break;
            case KeyEvent.VK_DOWN:
                dirs[1] = false;
                break;
            case KeyEvent.VK_LEFT:
                dirs[2] = false;
                break;
            case KeyEvent.VK_RIGHT:
                dirs[3] = false;
                break;
            default:
                break;
        }
        // 移去 draw
        // playerTank.move();
    }

    // 使用執行緒更新畫面
    public void run() {
        // 第二執行續
        // 顯示 Thread 的函式
        new Thread(() -> {
            while (true) {
                repaint();
                // 更新率 -> 可優化 -> 根據電腦速度決定
                try {
                    Thread.sleep(50);
                    System.out.println(gameObjects.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start(); // 說明開始
    }

    // @Override
    // public String toString() {
    // return "{" +
    // " screenWidth='" + getScreenWidth() + "'" +
    // ", screenHeight='" + getScreenHeight() + "'" +
    // "}";
    // }

    @Override
    protected void paintComponent(Graphics g) {
        // 刷新背景
        g.setColor(Color.BLACK);
        // 填滿矩形
        g.fillRect(0, 0, screenWidth, screenHeight);

        // 多型
        // 優點:統一控管遊戲物件
        for (GameObject object : gameObjects) {
            object.draw(g);
        }

        // GameClient 回收資源，安全移除
        for (GameObject object : gameObjects) {
            if (!object.getAlive()) {
                gameObjects.remove(object);
            }
        }

        // 另一個方法：
        // // 使用迭代器進行移除 (動態時時移除)
        // // GameClient回收資源，安全移除
        // Iterator<GameObject> iterator = gameObjects.iterator();
        // while (iterator.hasNext()) {
        // if (!(iterator.next().getAlive())) {
        // iterator.remove();
        // }
        // }

        // ■ 檢查遊戲是否勝利
        checkGameStatus();

        // for (GameObject object : gameObjects) {
        // if (!object.alive) {

        // }
        // }

        // ===================> 已優化
        // // 放上元件(?) [不可顛倒，背景會蓋住元件]
        // // g.drawImage(new ImageIcon("assets/images/itankU.png").getImage(),
        // // 400, 400, null);
        // // playerTank 抓圖
        // // g.drawImage(playerTank.getImage(), playerTank.getX(), playerTank.getY(),
        // // null);
        // // 繪製玩家
        // playerTank.draw(g);

        // // 繪製敵方
        // for (Tank enemy : enemyTanks) {
        // enemy.draw(g);
        // }

        // // 繪製牆
        // for (Wall wall : walls) {
        // wall.draw(g);
        // }

    }

    // 關卡重製
    void initGame() {
        // gameObjects.clear();
        // GameClient 回收資源，安全移除
        for (GameObject object : gameObjects) {
            gameObjects.remove(object);
        }
        playerTank = new PlayerTank(iTankImg, 400, 500, Direction.UP, false);
        playerTank.setSpeed(10);
        gameObjects.add(playerTank);
        // 子彈 Direction.DOWN, true));

        // 敵方
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                gameObjects.add(new Tank(eTankImg, 220 + j * 60, 50 + i * 60, Direction.DOWN, true));
                // enemyTanks.add(new Tank(eTankImg, 220 + j * 60, 50 + i * 60, Direction.DOWN,
                // true));
            }
        }
        // 牆
        gameObjects.add(new Wall(brickImg, 80, 10, false, 10));
        gameObjects.add(new Wall(brickImg, 190, 10, true, 15));
        gameObjects.add(new Wall(brickImg, 720, 10, false, 10));

    }

    public void checkGameStatus() {

        boolean gameOver = true;

        for (GameObject object : gameObjects) {
            if (object instanceof Tank && ((Tank) object).getEnemy()) {
                gameOver = false;
                break;
            }
        }

        if (gameOver) {
            initGame();
            // for (int i = 0; i < bulletImg.length; i++) {
            // for (int j = 0; j < bulletImg.length; j++) {

        }
        // }
        // }
    }

}
