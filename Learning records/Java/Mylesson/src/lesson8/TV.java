package lesson8;

// 可以有無限多個類別，但 public 只能有一個
class IC {
    // 外部類別:只能在同一個package內進行取用
}

public class TV {
    // class CPU { // 【不常用】
    // // 內部類別:無存取限制
    // // EX.
    // CPU() {
    // channel = 10;
    // volumeLevel = 7;
    // }
    // }

    // 如果有程式進入點main()方法也只能有一個
    // public static void main(String[] args) {
    // TV tv=new TV();
    // System.out.println(tv);
    // }

    /**
     * 常數設定 (使用final不可變) [命名規範大寫字母，_區隔]
     */
    final int MAX_CHANNEL = 120;
    final int MAX_VOLUME = 10;

    /**
     * 類別的成員屬性
     */
    int channel;
    int volumeLevel;
    boolean on;
    private String brand; // 品牌

    /**
     * 類別的成員方法
     * 建構式
     */
    // 建構式 (空)
    public TV() {
        channel = 1;
        volumeLevel = 1;
        brand = "Sony";
        // on=false;
    }

    // 建構式 (多載)
    public TV(int newChannel, int newVolumeLevel) { // , boolean newOn) {
        // 多載的預設值(初始值)宣告
        // this(); 代表本身類別，呼叫空建構式，必須放在第一行 [this(10,3)<--自己呼叫自己]
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
        // 未開機處理 方法一
        if (!on) {
            System.out.println("電視未開機！");
            return;
        }
        // 未開機處理 方法二
        if (on && newChannel >= 1 && newChannel <= MAX_CHANNEL) {
            channel = newChannel;
        } else {
            System.out.println("頻道輸入錯誤！");
        }
    }

    public void setVolume(int newVolumeLevel) {
        if (on && newVolumeLevel >= 1 && newVolumeLevel <= MAX_VOLUME) {
            volumeLevel = newVolumeLevel;
        } else {
            System.out.println("音量輸入錯誤！");
        }
    }

    // 新增設定品牌的方法➔
    // this ---> 區隔外部變數傳入同名的參數名稱，來簡化變數名稱。
    void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 類別的成員方法 (功能：++/-- 系列 (調整))
     */
    public void channelUp() {
        // 未開機處理 方法一 (若判斷式越來越多，這是好辦法)
        if (!on) {
            System.out.println("電視未開機！");
            return;
        }
        channel++;
        if (channel > MAX_CHANNEL) {
            channel = MAX_CHANNEL;
        }

    }

    public void channelDown() {
        // 未開機處理 方法二
        if (on && channel > 1) {
            channel--;
        }
        // channel--;
        // if (channel < 1) {
        // channel = 1;
        // }
    }

    public void volumeUp() {
        // 未開機處理 方法三
        if (isOff()) {
            return;
        }
        if (volumeLevel < MAX_VOLUME) {
            volumeLevel++;
        }
    }

    public void volumeDown() {
        // 未開機處理 方法四
        if (!isOff() && volumeLevel > 1) {
            volumeLevel--;
        }
    }

    /**
     * 類別的成員方法 (再不同 package 顯示全域變數)
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

    public boolean isOn() {
        return on;
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
