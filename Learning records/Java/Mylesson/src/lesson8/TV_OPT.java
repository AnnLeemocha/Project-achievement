package lesson8;

public class TV_OPT {

    /**
     * 常數設定 (使用final不可變) [命名規範大寫字母，_區隔]
     */
    final int MAX_CHANNEL = 120;
    final int MAX_VOLUME = 10;

    /**
     * 類別的成員屬性
     */
    private int channel;
    private int volumeLevel;
    private boolean on;
    private String brand; // 品牌

    // 記錄電視產生的計數
    // 無法真正計數，只能算自己的
    // private int count;
    // public int count;
    // 加上 static 成為整個類別中的唯一，所有用此類別建立的實體物件一起共用
    public static int count;
    // 私有要用私有的取法(用公開的方法取)
    private static int countNo;

    /**
     * 類別的成員方法
     * 建構式
     */
    // 建構式 (空)
    public TV_OPT() {
        channel = 1;
        volumeLevel = 1;
        brand = "Sony";
        // on=false;
        // 若多載無this();則在引用多載時不會計數
        count++;
        countNo++;
    }

    // 建構式 (多載)
    public TV_OPT(int newChannel, int newVolumeLevel) { // , boolean newOn) {
        this();
        turnOn(); // = this.turnOn();
        setChannel(newChannel);
        setVolume(newVolumeLevel);
    }

    /**
     * 類別的成員方法 (功能：開關機)
     */
    public void turnOn() {
        on = true;
        System.out.println("電視已開機！");
    }

    public void turnOff() {
        on = false;
    }

    /**
     * 類別的成員方法 (功能：set 系列 (檢測))
     */
    public void setChannel(int newChannel) {
        if (!isOff() && newChannel >= 1 && newChannel <= MAX_CHANNEL) {
            channel = newChannel;
        } else {
            System.out.println("頻道輸入錯誤！");
        }
    }

    public void setVolume(int newVolumeLevel) {
        if (!isOff() && newVolumeLevel >= 1 && newVolumeLevel <= MAX_VOLUME) {
            volumeLevel = newVolumeLevel;
        } else {
            System.out.println("音量輸入錯誤！");
        }
    }

    void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 類別的成員方法 (功能：++/-- 系列 (調整))
     */
    public void channelUp() {
        if (!isOff() && ++channel > MAX_CHANNEL) {
            channel = MAX_CHANNEL;
        }

    }

    public void channelDown() {
        if (!isOff() && --channel < 1) {
            channel = 1;
        }
    }

    public void volumeUp() {
        if (!isOff() && ++volumeLevel > MAX_VOLUME) {
            volumeLevel = MAX_VOLUME;
        }
    }

    public void volumeDown() {
        if (!isOff() && --volumeLevel < 1) {
            volumeLevel = 1;
        }
    }

    /**
     * 類別的成員方法 (功能：get 系列 (檢測))
     * ---> 在 private & package 時，顯示全域變數
     */
    public String getInfo() {
        return String.format("品牌：%s \t開關：%b \t頻道：%d \t音量：%d",
                brand, on, channel, volumeLevel);
    }

    public int getChannel() {
        return channel;
    }

    public int getVolumeLevel() {
        return volumeLevel;
    }

    public boolean getOn() {
        return on;
    }

    public String getBrand() {
        return brand;
    }

    public static int getCounter() {
        return countNo;
    }

    /**
     * 優化函式
     */
    public boolean isOff() {
        if (!on) {
            System.out.println("電視未開機！");
            return !on;
        }
        return !on;
    }
}
