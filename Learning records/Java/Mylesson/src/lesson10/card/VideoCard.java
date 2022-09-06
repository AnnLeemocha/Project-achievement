package lesson10.card;

// 繼承後實作
// 雙介面 (介面可實作無限個)
public class VideoCard extends Card implements PCI, Adapter {

    private boolean on = false;

    public VideoCard() {
        // final 不可更改
        // WATTS=10.0;
        // System.out.println(WATTS);
        // 不同介面有相同屬性名稱要注意
        System.out.printf("PCI：%.1f\tWATTS：%.2f",
                PCI.VERSION, Adapter.WATTS);
    }

    @Override
    public void on() {
        System.out.println(Adapter.WATTS + "供電中...");
        on = true;
    }

    @Override
    public void off() {
        System.out.println("顯卡電源關閉");
        on = false;
    }

    @Override
    public void push() {
        on();
        System.out.println("顯示卡插入");
    }

    @Override
    public void pull() {
        if (on) {
            System.out.println("請先關閉電源");
            return;
        }
        System.out.println("正常拔出顯示卡");

    }

}
