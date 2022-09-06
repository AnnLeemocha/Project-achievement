package lesson14;

import javax.swing.*;
import java.awt.*; // 不包括下一層
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Login extends JFrame {
    private int width = 300;
    private int height = 500;

    private String accountData;

    Login() {
        // // 給定視窗出現之位置(置中)&大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize.width);
        System.out.println(screenSize.height);

        int x = (screenSize.width - width) / 2;
        int y = (screenSize.height - height) / 2;
        int dx = +1000 / 2, dy = -200 / 2;
        this.setBounds(x + dx, y + dy, width, height);

        // 給定視窗標題名稱
        this.setTitle("登入介面DEMO");

        // 初始化？*************
        // 加入 Panel (設定其他組件)
        init();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // String path = "src/lesson14/account.txt";
        accountData = loadFile("src/lesson14/account.txt");
        if (accountData != null) {
            System.out.println("檔案讀取成功！");
        } else {
            System.out.println("檔案讀取失敗！");
        }
    }

    void init() {
        JPanel panel = new JPanel();
        int width = 300, height = 500;
        int x = 100, y = 50;

        panel.setBounds((width - x) / 2, (height - y), x, y);
        // panel.setBackground(Color.ORANGE);
        // panel.setBounds(new Rectangle(0, 0, x, y)); // 計算置中的位置
        // panel.setBorder(BorderFactory.createLineBorder(Color.black));

        this.setContentPane(panel); // *************

        // 1. 佈局 -> null 表示不使用版面管理，並使用絕對座標進行排版
        panel.setLayout(null);

        Font font1 = new Font(Font.SANS_SERIF, Font.PLAIN, 24);
        Font font2 = new Font(Font.MONOSPACED, Font.BOLD, 16);
        Font font3 = new Font(Font.SANS_SERIF, Font.PLAIN, 16);

        JLabel label1 = new JLabel("登入介面");
        label1.setFont(font1); // 設定字型
        // 24 pixel
        label1.setBounds((width - 24 * 4) / 2, 30, 24 * 4, 30);
        panel.add(label1);

        JLabel label2 = new JLabel("帳號：");
        label2.setFont(font3); // 設定字型
        // 24 pixel
        label2.setBounds((width - 24 * 4) / 2 - 50, 70 - 1, 24 * 3, 30);
        panel.add(label2);

        JLabel label3 = new JLabel("密碼：");
        label3.setFont(font3); // 設定字型
        // 24 pixel
        label3.setBounds((width - 24 * 4) / 2 - 50, 150 - 1, 24 * 3, 30);
        panel.add(label3);

        JTextField userName = new JTextField();
        userName.setColumns(10); // *************
        userName.setFont(font2);
        userName.setHorizontalAlignment(JTextField.CENTER); // 置中輸入
        userName.setToolTipText("請輸入姓名"); // 鼠標移過去所顯示的提示說明
        userName.setBounds((width - 200) / 2, 100, 200, 40);
        panel.add(userName);

        JPasswordField passWord = new JPasswordField();
        passWord.setColumns(10);
        passWord.setFont(font2);
        passWord.setHorizontalAlignment(JTextField.CENTER); // 置中輸入
        passWord.setToolTipText("請輸入密碼"); // 鼠標移過去所顯示的提示說明
        passWord.setBounds((width - 200) / 2, 180, 200, 40);
        panel.add(passWord);

        JButton button = new JButton("登入");
        button.setFont(font2);
        button.setBounds((width - 100) / 2, height - 120, 100, 50);

        // 實作監聽功能
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println(e.getSource()); // e = button 本身
                System.out.println("click!");
                // 取得(TextField)輸入的文字 ---> getText
                String name = userName.getText();
                String pass = new String(passWord.getPassword()); // <-- JPasswordField
                // System.out.println(name);
                // System.out.println(pass);
                String result = null;

                // account.txt -> check
                if (checkAccount(name, pass)) {
                    result = "登入成功！";
                } else {
                    result = "登入失敗~";
                    if (name.equals("") || pass.equals("")) {
                        result += "\n帳號或密碼不得為空！";
                        System.out.println("帳號或密碼不得為空！");
                    }
                }

                // 訊息類別 ---> JOptionPane
                JOptionPane.showMessageDialog(null, result);
            }

        });

        panel.add(button);

    }

    // 讀取檔案
    String loadFile(String path) {
        File file = new File(path);
        FileReader fileReader = null;

        if (file.exists()) {
            try {
                fileReader = new FileReader(path);
                char[] buffer = new char[(int) file.length()];
                fileReader.read(buffer);

                // char -> String
                String str = new String(buffer);

                return str;

            } catch (FileNotFoundException e) {
                System.out.println(e);
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
            }
        }
        return null;

    }

    // 檢查帳號密碼的函式
    boolean checkAccount(String userName, String password) {
        String[] datas = accountData.split("\n");

        for (String data : datas) {
            String[] account = data.split(",");
            if (account.length == 1) {
                continue;
            }
            String name = account[0];
            String pass = account[1];

            if (userName.equals(name) && password.equals(pass)) {
                return true;
            }
        }
        return false;
    }
}

public class Ch14_2 {
    public static void main(String[] args) {
        new Login();
    }
}
