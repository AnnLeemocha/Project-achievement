package lesson14;

// import javax.swing.JButton;
// import javax.swing.JFrame; // 實體類別
// import javax.swing.JPanel;
// import javax.swing.border.Border;
import javax.swing.*;

// import java.awt.BorderLayout;
// import java.awt.Rectangle;
// import java.awt.Color;
// import java.awt.Dimension;
// import java.awt.Toolkit;
import java.awt.*;

class App extends JFrame {
    App() {
        // // 給定視窗出現之位置&大小
        // this.setBounds(900, 100, 300, 500);
        // // 給定視窗出現之位置(置中)&大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // System.out.println(screenSize.width);
        // System.out.println(screenSize.height);
        // this.setBounds((screenSize.width - 300) / 2, (screenSize.height - 500) / 2,
        // 300, 500);
        // 給定視窗出現之位置(置中再往右([+]上[-])&大小
        int x = 500, y = 500;
        int dx = +1400, dy = -200;
        this.setBounds((screenSize.width - x) / 2 + dx / 2, (screenSize.height - y) / 2 + dy / 2, 300, 500);

        // 給定視窗標題名稱
        this.setTitle("第一個App");

        // 初始化？
        init();

        // 加入Panel

        // 視窗關閉要自己設定才會停止運行釋放關閉，要不然會越跑越慢
        // JFrame -> public static final int EXIT_ON_CLOSE = 3;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 預設不可見，改成可見
        // 可見通常放最後，設定完再看
        this.setVisible(true);
        // 也可用 super ，用 this 要注意，有覆寫會取自己本身

    }

    void init() {
        JPanel panel = new JPanel();
        int x = 300, y = 500;

        // panel.setBounds(100, 100, x / 2, y / 2);
        // panel.setBackground(Color.ORANGE);
        panel.setBounds(new Rectangle(0, 0, x, y));
        panel.setBorder(BorderFactory.createLineBorder(Color.black));

        this.setContentPane(panel);

        // 1. 佈局 -> null 表示不使用版面管理，並使用絕對座標進行排版
        // panel.setLayout(null);
        // 2. 方位布局 -> North South East West Center
        // panel.setLayout(new BorderLayout()); // 無間距
        // panel.setLayout(new BorderLayout(20, 20)); // 水平與垂直間距
        // 3. 流程式版面配置 -> 由左而右，由上而下
        // panel.setLayout(new FlowLayout());
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 50));

        JButton button1 = new JButton("按鈕一");
        // button1.setBounds(0, 0, 120, 30);
        // panel.add(button1);
        // panel.add(button1, BorderLayout.NORTH);
        panel.add(button1);

        JButton button2 = new JButton("按鈕二");
        // button2.setBounds(100, 200, 120, 30);
        // panel.add(button2);
        // panel.add(button2, BorderLayout.EAST);
        panel.add(button2);

        JButton button3 = new JButton("按鈕三");
        // button3.setBounds(10, 10, 120, 30);
        // panel.add(button3);
        // panel.add(button3, BorderLayout.WEST);
        panel.add(button3);

        JButton button4 = new JButton("按鈕四");
        // button4.setBounds(10, 10, 120, 30);
        // panel.add(button4);
        // panel.add(button4, BorderLayout.CENTER);
        panel.add(button4);

        JButton button5 = new JButton("按鈕五");
        // button5.setBounds(10, 10, 120, 30);
        // panel.add(button5, BorderLayout.SOUTH);
        panel.add(button5);

    }
}

public class Ch14_1 {
    public static void main(String[] args) {
        new App();
    }
}
