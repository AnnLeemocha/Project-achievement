package lesson10.card;

/**
 * 使用宣告 implements (介面後一定要實作)
 */
// public class SoundCard extends Card implements PCI,HDMI,DVI,D_SUB {
public class SoundCard extends Card implements PCI {

    public SoundCard() {
        // 輸出版本
        // System.out.println(VERSION);
        System.out.println(PCI.VERSION);
    }

    @Override
    public void push() {
        // TODO Auto-generated method stub
        System.out.println("音效卡安裝完成.");
    }

    @Override
    public void pull() {
        System.out.println("拔出音效卡.");
    }

}
