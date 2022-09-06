package tw.com.anncode.gameobject;

// class -> enum
public enum Direction {
    // 方向 (八方位)
    // public static int UP = 0;
    // public static int DOWN = 0;
    // public static int LEFT = 0;
    // public static int RIGHT = 0;
    // private int direction;
    // 常量太多用 enum 可以將常量組織起來，統一進行管理。
    // enum direction {UP,DOWN,LEFT,RIGHT}
    // UP=0, DOWN=1, LEFT=2, RIGHT=3

    UP, DOWN, LEFT, RIGHT,
    UP_LEFT, DOWN_LEFT, UP_RIGHT, DOWN_RIGHT
}
