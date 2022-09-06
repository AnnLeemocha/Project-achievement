package lesson10.card;

public interface Adapter {
    // public static final double WATTS=5.0;
    // 簡寫，會自動加上
    double WATTS = 5.0;
    double VERSION = 3.2;

    // public abstract void on();
    // 簡寫，會自動加上
    void on();

    void off();
}
