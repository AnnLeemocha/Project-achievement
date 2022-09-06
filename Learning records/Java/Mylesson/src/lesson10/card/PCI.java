package lesson10.card;

/**
 * 介面
 */
public interface PCI {
    // 介面只屬性只能是常數
    public static final double VERSION = 3.0;
    // public int x; // (XX錯誤)

    // 介面之拔抽方法 (抽象方法)
    public abstract void push();

    public abstract void pull();

}
