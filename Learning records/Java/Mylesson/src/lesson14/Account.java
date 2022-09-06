// package lesson14;

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.ArrayList;

// import javax.swing.*;
// import java.awt.*; // 不包括下一層
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// class Login extends JFrame {
// Login() {
// // // 給定視窗出現之位置(置中)&大小
// Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

// int width = 300, height = 500;
// int dx = +1000, dy = -200;
// this.setBounds((screenSize.width - width) / 2 + dx / 2, (screenSize.height -
// height) / 2 + dy / 2, width,
// height);

// // 給定視窗標題名稱
// this.setTitle("第一個App");

// // 初始化？*************
// // 加入 Panel (設定其他組件)
// init();

// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// this.setVisible(true);
// }

// void init() {
// JPanel panel = new JPanel();
// int width = 300, height = 500;
// int x = 100, y = 50;

// panel.setBounds((width - x) / 2, (height - y), x, y);
// // panel.setBackground(Color.ORANGE);
// // panel.setBounds(new Rectangle(0, 0, x, y)); // 計算置中的位置
// // panel.setBorder(BorderFactory.createLineBorder(Color.black));

// this.setContentPane(panel); // *************

// // 1. 佈局 -> null 表示不使用版面管理，並使用絕對座標進行排版
// panel.setLayout(null);

// Font font1 = new Font(Font.SANS_SERIF, Font.PLAIN, 24);
// Font font2 = new Font(Font.MONOSPACED, Font.BOLD, 16);
// Font font3 = new Font(Font.SANS_SERIF, Font.PLAIN, 16);

// JLabel label1 = new JLabel("登入介面");
// label1.setFont(font1); // 設定字型
// // 24 pixel
// label1.setBounds((width - 24 * 4) / 2, 30, 24 * 4, 30);
// panel.add(label1);

// JLabel label2 = new JLabel("帳號：");
// label2.setFont(font3); // 設定字型
// // 24 pixel
// label2.setBounds((width - 24 * 4) / 2 - 50, 70 - 1, 24 * 3, 30);
// panel.add(label2);

// JLabel label3 = new JLabel("密碼：");
// label3.setFont(font3); // 設定字型
// // 24 pixel
// label3.setBounds((width - 24 * 4) / 2 - 50, 150 - 1, 24 * 3, 30);
// panel.add(label3);

// JTextField userName = new JTextField();
// userName.setColumns(10); // *************
// userName.setFont(font2);
// userName.setHorizontalAlignment(JTextField.CENTER); // 置中輸入
// userName.setToolTipText("請輸入姓名"); // 鼠標移過去所顯示的提示說明
// userName.setBounds((width - 200) / 2, 100, 200, 40);
// panel.add(userName);

// JPasswordField passWord = new JPasswordField();
// passWord.setColumns(10);
// passWord.setFont(font2);
// passWord.setHorizontalAlignment(JTextField.CENTER); // 置中輸入
// passWord.setToolTipText("請輸入密碼"); // 鼠標移過去所顯示的提示說明
// passWord.setBounds((width - 200) / 2, 180, 200, 40);
// panel.add(passWord);

// JButton button = new JButton("登入");
// button.setFont(font2);
// button.setBounds((width - 100) / 2, height - 120, 100, 50);

// // 實作監聽功能
// button.addActionListener(new ActionListener() {

// @Override
// public void actionPerformed(ActionEvent e) {
// // System.out.println(e.getSource()); // e = button 本身
// System.out.println("click!");
// // 取得(TextField)輸入的文字 ---> getText
// String name = userName.getText();
// String pass = new String(passWord.getPassword()); // <-- JPasswordField
// // System.out.println(name);
// // System.out.println(pass);
// String result = null;

// ArrayList<DataList> check = new ArrayList<DataList>();
// readCheckList(check);

// for (DataList c : check) {
// boolean account = (name.equals(c.name) && pass.equals(c.pass));
// if (account == true) {
// break;
// }
// }
// if (name.equals("Ann") && pass.equals("123")) {
// result = "登入成功！";
// // System.out.println("登入成功！");
// // JOptionPane.showMessageDialog(null, "登入中...");
// } else if (name.equals("") || pass.equals("")) {
// System.out.println("登入失敗！");
// result = "帳號或密碼不得為空！";
// // System.out.println("帳號或密碼不得為空！");
// } else {
// result = "登入失敗~";
// // System.out.println("登入失敗！");
// }
// // 訊息類別 ---> JOptionPane
// JOptionPane.showMessageDialog(null, result);
// }

// });

// panel.add(button);

// }

// class DataList {
// String name;
// String pass;

// }

// void readCheckList(ArrayList<DataList> check) {
// String path = "src/lesson14/account.txt";
// File file = new File(path);
// FileReader fileReader = null;
// String[] namePass = { null, null };

// if (file.exists()) {

// try {
// fileReader = new FileReader(path);
// char[] buffer = new char[(int) file.length()];

// fileReader.read(buffer);
// // char -> String
// String str = new String(buffer);

// // return str;

// String[] datas = str.split("\n");
// for (String data : datas) {
// namePass = data.split(",");
// if (namePass.length == 1) {
// continue;
// }
// DataList list = new DataList();
// list.name = namePass[0];
// list.pass = namePass[1];
// check.add(list);
// // String name = namePass[0];
// // String pass = namePass[1];
// }

// } catch (FileNotFoundException e) {
// System.out.println(e);
// } catch (IOException e) {
// System.out.println(e);
// } finally {
// if (fileReader != null) {
// try {
// fileReader.close();
// } catch (IOException e) {
// System.out.println(e);
// }
// }
// }

// }

// }
// }

// public class Account {
// public static void main(String[] args) {

// }
// }
