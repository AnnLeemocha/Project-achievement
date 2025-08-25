package tw.com.anncode.gameobject;

// import javax.swing.ImageIcon;
import java.awt.*;
import java.util.Random;

import tw.com.anncode.App;

public class Tank extends GameObject {
    // // 位置 & 方向 ===================> 已優化
    // private int x;
    // private int y;
    // private int oldX;
    // private int oldY;

    private Direction direction;
    private int speed;
    private boolean[] dirs;
    private boolean enemy;

    protected boolean isCollosion;
    protected int hp;

    // public static void main(String[] args) {
    // System.out.println(Direction.DOWN.ordinal());
    // }

    // public Tank(int x, int y, Direction direction, boolean enemy) {
    public Tank(Image[] image, int x, int y, Direction direction, boolean enemy) {
        super(image, x, y);
        // this.x = x; // ===================> 已優化
        // this.y = y;
        this.direction = direction;
        this.enemy = enemy;
        this.speed = 5;
        dirs = new boolean[4];
        hp = 1;
    }

    public boolean[] getDirs() {
        return dirs;
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

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean getEnemy() {
        return this.enemy;
    }

    public void setEnemy(boolean enemy) {
        this.enemy = enemy;
    }

    public int getHp() {
        return hp;
    }

    // 傷害指數
    public void getHurt(int damage) {
        if (--hp <= 0) {
            hp = 0;
            alive = false;
        }
    }

    // 開火射擊
    public void fire() {
        if (!alive) {
            return;
        }
        Bullet bullet = new Bullet(App.gameClient.getBulletImg(), 0, 0, direction, enemy);
        int[] pos = getCenterPos(bullet.getRectangle());
        bullet.setX(pos[0]);
        bullet.setY(pos[1]);

        App.gameClient.getGameObject().add(bullet); // 實際給位置
    }

    // 偵測邊界獨立成函式，回傳是否有碰撞
    public boolean isCollosionBound() {
        // 偵測遊戲邊界
        if (x < 0) {
            x = 0;
            return true;
        } else if (x > App.gameClient.getScreenWidth() - width) {
            x = App.gameClient.getScreenWidth() - width;
            return true;
        }
        if (y < 0) {
            y = 0;
            return true;
        } else if (y > App.gameClient.getScreenHeight() - height) {
            y = App.gameClient.getScreenHeight() - height;
            return true;
        }

        return false;

        // System.out.println(getRectangle().getX());
        // System.out.println(getRectangle().getY());
    }

    // 偵測敵方/牆面/子彈
    public void collosion() {

        if (isCollosionBound()) {
            x = oldX;
            y = oldY;
            isCollosion = true;
            return;
        }

        // 利用多型偵測其他物件 gameObject = {playerTank, enemyTanks, walls}
        for (GameObject object : App.gameClient.getGameObject()) {
            if (object == this) {
                continue;
            }

            // 敵方才偵測
            if (object instanceof Tank) {
                // 向下轉型
                if (((Tank) object).enemy == enemy) { // 皆敵 OR 皆我
                    continue;
                }
            }

            // 不是自己，要不然不能動
            // if (object != this) {
            // 先不用多型判斷物件是誰
            if (getRectangle().intersects(object.getRectangle())) {
                x = oldX;
                y = oldY;
                isCollosion = true;
                return;
            }

            // // 自己 VS 敵方 (Tank)
            // // 敵方坦克，物件矩形有交集(intersects)的
            // if (object instanceof Tank &&
            // getRectangle().intersects(object.getRectangle())) {
            // System.out.println("Enemy!");
            // // ■ 紀錄移動前位置 // ■ 碰撞後更新成上一次位置
            // x = oldX;
            // y = oldY;
            // return;
            // }
            // // 自己 VS 牆面
            // if (object instanceof Wall &&
            // getRectangle().intersects(object.getRectangle())) {
            // System.out.println("Wall");
            // x = oldX;
            // y = oldY;
            // return;
            // }
            // }
        }
    }

    // 物件間距調整
    @Override
    public Rectangle getRectangle() {
        int padding = 5;
        return new Rectangle(x + padding, y + padding, width - 2 * padding, height - 2 * padding);
    }

    // 增加敵我識別
    // 八個方向移動沒問題但停不下來! 增加停止方法
    public boolean isStop() {
        // 只要一個方向不是 false 就是在正確移動情況
        for (boolean dir : dirs) {
            if (dir) {
                return false;
            }
        }
        return true;
    }

    // ===================> 已優化
    // public Image getImage() {
    // String name = enemy ? "etank" : "itank";
    // if (direction == Direction.UP) {
    // return new ImageIcon("assets/images/" + name + "U.png").getImage();
    // }
    // if (direction == Direction.DOWN) {
    // return new ImageIcon("assets/images/" + name + "D.png").getImage();
    // }
    // if (direction == Direction.LEFT) {
    // return new ImageIcon("assets/images/" + name + "L.png").getImage();
    // }
    // if (direction == Direction.RIGHT) {
    // return new ImageIcon("assets/images/" + name + "R.png").getImage();
    // }
    // if (direction == Direction.UP_RIGHT) {
    // return new ImageIcon("assets/images/" + name + "RU.png").getImage();
    // }
    // if (direction == Direction.UP_LEFT) {
    // return new ImageIcon("assets/images/" + name + "LU.png").getImage();
    // }
    // if (direction == Direction.DOWN_RIGHT) {
    // return new ImageIcon("assets/images/" + name + "RD.png").getImage();
    // }
    // if (direction == Direction.DOWN_LEFT) {
    // return new ImageIcon("assets/images/" + name + "LD.png").getImage();
    // }
    // return null;
    // }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void move() {
        oldX = x;
        oldY = y;
        switch (direction) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case UP_LEFT:
                x -= speed;
                y -= speed;
                break;
            case UP_RIGHT:
                x += speed;
                y -= speed;
                break;
            case DOWN_LEFT:
                x -= speed;
                y += speed;
                break;
            case DOWN_RIGHT:
                x += speed;
                y += speed;
                break;

            // default:
            // break;
        }
    }

    private void determineDirection() {
        // 上下左右(0,1,2,3) 複數鍵
        // 便免上下，左右一起按

        // 上左
        if (dirs[0] && !dirs[1] && dirs[2] && !dirs[3]) {
            direction = Direction.UP_LEFT;
            // 上右
        } else if (dirs[0] && !dirs[1] && !dirs[2] && dirs[3]) {
            direction = Direction.UP_RIGHT;
            // 下左
        } else if (!dirs[0] && dirs[1] && dirs[2] && !dirs[3]) {
            direction = Direction.DOWN_LEFT;
            // 下右
        } else if (!dirs[0] && dirs[1] && !dirs[2] && dirs[3]) {
            direction = Direction.DOWN_RIGHT;
            // 上
        } else if (dirs[0] && !dirs[1] && !dirs[2] && !dirs[3]) {
            direction = Direction.UP;
            // 下
        } else if (!dirs[0] && dirs[1] && !dirs[2] && !dirs[3]) {
            direction = Direction.DOWN;
            // 左
        } else if (!dirs[0] && !dirs[1] && dirs[2] && !dirs[3]) {
            direction = Direction.LEFT;
            // 右
        } else if (!dirs[0] && !dirs[1] && !dirs[2] && dirs[3]) {
            direction = Direction.RIGHT;
        }
    }

    // 整合繪圖
    @Override
    public void draw(Graphics g) {
        if (!alive) {
            return;
        }

        ai();

        if (!isStop()) {
            determineDirection(); // 按鍵
            move(); // 移動
            collosion(); // 碰撞

            // 還可以加特效
        }

        // 無時無刻讀取圖形並移動 --> 可優化到父類
        // ■ 不每次重複讀取遊戲圖片
        g.drawImage(image[direction.ordinal()], x, y, null);
        // direction --> UP, DOWN, LEFT, RIGHT, UP_LEFT, DOWN_LEFT, UP_RIGHT, DOWN_RIGHT
        // direction.ordinal() --> 0,1,2,3,4,5,6,7
        // 已依照順序給予，按造方向位置取圖形
        // g.drawImage(getImage(), x, y, null); // ===================> 已優化

    }

    @Override
    public void ai() {
        if (!enemy) {
            return;
        }

        if (isCollosion) {
            getNewDirection();
            isCollosion = false;
            return;
        }

        // 使用亂數套件
        Random rand = new Random();

        // 1/20機率進行移動偵測
        if (rand.nextInt(20) == 1) {
            dirs[rand.nextInt(4)] = true;

            // 1/2機率停止
            if (rand.nextInt(2) == 1) {
                return;
            }

        }

        // 1/50機率開火
        if (rand.nextInt(50) == 1) {
            fire();
        }

    }

    public void getNewDirection() {

        dirs = new boolean[4];

        Random rand = new Random();
        int dir = rand.nextInt(Direction.values().length);

        if (dir <= Direction.RIGHT.ordinal()) {
            dirs[dir] = true;
        } else {
            // 斜的方向需另外設定
            if (dir == Direction.UP_LEFT.ordinal()) {
                dirs[0] = true;
                dirs[2] = true;
            } else if (dir == Direction.UP_RIGHT.ordinal()) {
                dirs[0] = true;
                dirs[3] = true;
            } else if (dir == Direction.DOWN_LEFT.ordinal()) {
                dirs[1] = true;
                dirs[2] = true;
            } else {
                dirs[1] = true;
                dirs[3] = true;
            }

        }

    }

    // @Override
    // public String toString()
    // return "{" +
    // " x=
    // ", y='" + getY() + "'" +
    // ", direction='" + getDirection() + "'" +
    // "}";
    // }
}
