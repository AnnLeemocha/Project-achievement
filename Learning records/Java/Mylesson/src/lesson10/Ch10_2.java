package lesson10;

/**
 * 介面
 */

// 抽象的目的: 在父類宣告抽象類別與方法，強制把該方法的實作留給子類
// 介面的目的: (類似多父類別) 強制把介面中的抽象方法的實作留給子類
// [抽象類別 VS 介面-->介面非類別，不可以有任何完整的方法跟一般屬性]

// import lesson10.card.SoundCard;
// import lesson10.card.VideoCard;
// import lesson10.card.PCI;
// import lesson10.card.Adapter;
// import lesson10.card.Card;
import lesson10.card.*;

public class Ch10_2 {
    public static void main(String[] args) {
        System.out.println("====================");
        SoundCard soundCard = new SoundCard();
        soundCard.push();
        soundCard.pull();
        System.out.println("====================");

        VideoCard videoCard = new VideoCard();
        videoCard.push();
        videoCard.on();
        videoCard.off();
        videoCard.pull();
        System.out.println("====================");

        // Card (父類) ---> PCI (介面)
        // soundCard ： PCI
        // videoCard ： PCI , Adapter

        // 父類使用多型的用法
        Card[] cards2 = { soundCard, videoCard };
        for (Card card : cards2) {
            System.out.println(card);
            // System.out.println("---------------");
        }

        System.out.println("====================");

        // 介面也可以實現多型的用法
        PCI[] cards = { soundCard, videoCard };
        for (PCI pci : cards) {
            pci.push();
            pci.pull();

            if (pci instanceof VideoCard) {
                VideoCard card = (VideoCard) pci;
                card.on();
                card.off();
            }
            // 介面也可以有繼承關係
            if (pci instanceof Adapter) {
                VideoCard card = (VideoCard) pci;
                card.on();
                card.off();
            }
            System.out.println("---------------");
        }
    }

}
