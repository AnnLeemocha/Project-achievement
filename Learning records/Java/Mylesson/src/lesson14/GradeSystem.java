package lesson14;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class StudentForm extends JFrame implements ActionListener {

    private JTextField nameText;
    private JTextField chineseText;
    private JTextField mathText;
    private JTextField englishText;

    JTextField[] textFields = { nameText, chineseText, mathText, englishText };
    String[] subject = { "姓名", "國文", "數學", "英文" };

    private JButton addBtn;
    private JTextArea outputArea;
    private JButton saveBtn;

    private final int WIDTH = 600;
    private final int HEIGHT = 400;

    StudentForm() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize.width);
        System.out.println(screenSize.height);

        int x = (screenSize.width - WIDTH) / 2;
        int y = (screenSize.height - HEIGHT) / 2;

        this.setBounds(x, y, WIDTH, HEIGHT);
        this.setTitle("學生成績輸入系統");
        // JFrame布局樣式，要先約定好布局型態，要不然為預設
        setLayout(null);
        // 左邊樣式布局
        initLeftPanel();
        // 右邊樣式布局
        initRightPanel();

        // 直接放置在Frame上的按鈕
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 22);
        saveBtn = new JButton("輸出");
        saveBtn.setFont(font);
        // panel.setBounds(255, 10, 305, 260);
        saveBtn.setBounds((305 - 100) / 2 + 255, 250 + 28, 100, 50);
        this.add(saveBtn);

        // 關閉
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 顯示
        this.setVisible(true);
    }

    void initLeftPanel() {
        JPanel panel = new JPanel();
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 22);

        panel.setBounds(10, 10, (int) (WIDTH * 0.4), HEIGHT - 60);
        panel.setBackground(Color.ORANGE);
        // 設定邊框跟title
        Border line = BorderFactory.createLineBorder(Color.BLACK);
        panel.setBorder(BorderFactory.createTitledBorder(line, "輸入"));
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));
        add(panel);

        // 加入元件到panel
        // for (String string : subject) {
        for (int i = 0; i < subject.length; i++) {
            panel.add(new JLabel(subject[i]));
            textFields[i] = new JTextField();
            textFields[i].setColumns(10);
            textFields[i].setFont(font);
            textFields[i].setToolTipText("請輸入" + subject[i]);
            panel.add(textFields[i]);
        }

        addBtn = new JButton("新增");
        addBtn.setFont(font);
        // addBtn.setBounds(30, 10, 100, 50);
        panel.add(addBtn);

    }

    void initRightPanel() {
        JPanel panel = new JPanel();
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 22);

        // System.out.println((int) (WIDTH * 0.4) + 10 + 5);
        // System.out.println((int) (WIDTH * 0.6) - 10 - 45);
        // System.out.println((int) (HEIGHT * 0.8) - 60);

        panel.setBounds(255, 10, 305, 260);
        // panel.setBounds((int) (WIDTH * 0.4) + 10 + 5, 10, (int) (WIDTH * 0.6) - 10 -
        // 45, (int) (HEIGHT * 0.8) - 60);
        Border line = BorderFactory.createLineBorder(Color.BLACK);
        panel.setBorder(BorderFactory.createTitledBorder(line, "資料"));
        panel.setLayout(null);
        add(panel);

        outputArea = new JTextArea();
        outputArea.setBounds(10, 20, 285, 220);
        // outputArea.setBounds((int) (WIDTH * 0.4) + 15, 10, (int) (WIDTH * 0.6) - 55,
        // (int) (HEIGHT * 0.8) - 60);
        outputArea.setBorder(line);
        outputArea.setFont(font);
        panel.add(outputArea);
    }

    // 綁定方法 (監聽)
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addBtn) {
            boolean add = true;
            for (JTextField textField : textFields) {
                if (textField.equals("")) {
                    JOptionPane.showMessageDialog(null, "資料輸入有誤！");
                    add = false;
                    break;
                }
            }

            // if (add) {
            // for (JTextField textField : textFields) {

            // }
            // }
        }

    }

    // Apache Maven，是一個軟體（特別是Java軟體）專案管理及自動構建工具，由Apache軟體基金會所提供。
    // 基於專案物件模型（縮寫：POM）概念，Maven利用一個中央資訊片斷能管理一個專案的構建、報告和文件等步驟。
    // Create Java Project >> Maven >> archetype-quickstart-jdk8 >> 2.8.0 >> (專屬名)
    // 最好是網域名稱 (與網址反向打 tw.com.anncode) >> 專案名稱 (gradesystem) | (成功) >> Enter >> Y
    // 設定環境變數 JAVA_HOME --> 連至 JAVA 安裝位置 (C:\Program Files\Java\jdk-18.0.1.1)

}

public class GradeSystem {
    public static void main(String[] args) {
        new StudentForm();

    }
}
