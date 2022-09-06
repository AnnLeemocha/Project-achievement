package lesson8;

public class TVDemo2 {
    public static void main(String[] args) {
        // TV tv = new TV(10, 3);
        TV_OPT tv = new TV_OPT(10, 3);
        System.out.println(tv);
        System.out.println(tv.getInfo());
        System.out.println("--------------------------");

        tv.turnOff();
        tv.volumeDown();
        System.out.println(tv.getInfo());
        System.out.println("--------------------------");
        tv.turnOn();
        tv.volumeDown();
        System.out.println(tv.getInfo());

        // 修飾子 ---> package
        tv.setBrand("YYYY");
        System.out.println(tv.getInfo());

        // 修飾子 ---> private
        // System.out.println(tv.brand);
        System.out.println(tv.getBrand());

        System.out.printf("品牌：%s \t開關：%b \t頻道：%d \t音量：%d\n",
                tv.getBrand(), tv.getOn(), tv.getChannel(), tv.getVolumeLevel());
    }
}
