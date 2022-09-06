package lesson8;

public class TVDemo {
    public static void main(String[] args) {
        TV tv1 = new TV();
        TV tv2 = new TV(10, 3);
        TV tv3 = null;
        System.out.println(tv1);
        System.out.println("--------------------------");

        System.out.println("開關機狀態： " + tv1.on);
        System.out.println("選擇頻道： " + tv1.channel);
        tv1.channelUp(); // 進行開機判斷處理
        System.out.println("開關機狀態： " + tv1.on);
        System.out.println("選擇下一頻道： " + tv1.channel);
        tv1.turnOn();
        System.out.println("開關機狀態： " + tv1.on);
        System.out.println("--------------------------");

        tv1.setChannel(119);
        System.out.println("選擇頻道： " + tv1.channel);
        tv1.channelUp();
        System.out.println("選擇下一頻道： " + tv1.channel);
        tv1.channelUp();
        System.out.println("超過最大頻道： " + tv1.channel);
        System.out.println("--------------------------");

        tv1.setChannel(2);
        System.out.println("選擇頻道： " + tv1.channel);
        tv1.channelDown();
        System.out.println("選擇上一頻道： " + tv1.channel);
        tv1.channelDown();
        System.out.println("超過最小頻道： " + tv1.channel);
        System.out.println("--------------------------");

        tv1.setVolume(7);
        System.out.println("音量測試： " + tv1.volumeLevel);

        System.out.println("=======================================");
        // 新增物件
        tv2.turnOn();
        tv2.setChannel(100);
        tv2.setVolume(3);
        System.out.printf("第 %d 頻道 ， 音量：%d\n",
                tv2.channel, tv2.volumeLevel);
        tv2.channelUp();
        tv2.volumeUp();
        System.out.printf("第 %d 頻道 ， 音量：%d\n",
                tv2.channel, tv2.volumeLevel);
        System.out.println("--------------------------");

        System.out.println(tv3);
        System.out.println("--------------------------");

    }
}
