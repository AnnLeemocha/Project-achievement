package tw.com.anncode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class GradeSystem extends JFrame implements ActionListener {
    private JTextField nameText;
    private JTextField chineseText;
    private JTextField mathText;
    private JTextField englishText;

    // JTextField[] textFields = { nameText, chineseText, mathText, englishText };
    // String[] subject = { "姓名", "國文", "數學", "英文" };

    private JButton addBtn;
    private JTextArea outputArea;
    private JButton saveBtn;
    private JButton loadBtn;
    private JButton clearBtn;
    private JCheckBox appendCbx;

    private Font font1 = new Font(Font.SANS_SERIF, Font.PLAIN, 16);
    private Font font2 = new Font(Font.MONOSPACED, Font.PLAIN, 20);
    private Font font3 = new Font(Font.MONOSPACED, Font.PLAIN, 16);

    private String fileName;
    private final String TITLE = "學生成績輸入系統";

    private final int WIDTH = 600;
    private final int HEIGHT = 600;

    GradeSystem() {
        // fileName = "Student.csv"; // 內 or 外部路徑
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize.width);
        System.out.println(screenSize.height);

        int x = (screenSize.width - WIDTH) / 2;
        int y = (screenSize.height - HEIGHT) / 2;

        this.setBounds(x, y, WIDTH, HEIGHT);
        // this.setTitle("學生成績輸入系統");

        // JFrame布局樣式，要先約定好布局型態，要不然為預設
        setLayout(null);
        // 左邊樣式布局
        initLeftPanel();
        // 右邊樣式布局
        initRightPanel(); // 直接放置在Frame上的按鈕一同寫入

        // 關閉
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 顯示 --- 搬到方法讓主程式決定
        this.setVisible(true);
    }

    public void run(boolean visible) {
        setVisible(visible);
    }

    public static void main(String[] args) {
        // 沒 main 會找 App.java

        GradeSystem system = new GradeSystem();

        system.run(true);
    }

    private void initLeftPanel() {
        JPanel panel = new JPanel();
        // Font font = new Font(Font.MONOSPACED, Font.PLAIN, 22);

        panel.setBounds(10, 10, (int) (WIDTH * 0.4), HEIGHT - 60);
        panel.setBackground(Color.ORANGE);

        // 設定邊框跟title
        Border line = BorderFactory.createLineBorder(Color.BLACK);
        panel.setBorder(BorderFactory.createTitledBorder(line, "輸入"));
        // FlowLayout 置中 置右 置左
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        add(panel);

        // 加入元件到panel
        panel.add(new JLabel("姓名"));
        nameText = getTextField("請輸入姓名", 14, font2);
        nameText.setText("Ann");
        panel.add(nameText);

        panel.add(new JLabel("國文"));
        chineseText = getTextField("請輸入姓名", 14, font2);
        chineseText.setText("99");
        panel.add(chineseText);

        panel.add(new JLabel("數學"));
        mathText = getTextField("請輸入姓名", 14, font2);
        mathText.setText("99");
        panel.add(mathText);

        panel.add(new JLabel("英文"));
        englishText = getTextField("請輸入姓名", 14, font2);
        englishText.setText("99");
        panel.add(englishText);

        // for (int i = 0; i < subject.length; i++) {
        // panel.add(new JLabel(subject[i]));
        // textFields[i] = new JTextField();
        // textFields[i].setColumns(14);
        // textFields[i].setFont(font2);
        // textFields[i].setToolTipText("請輸入" + subject[i]);
        // textFields[i].setHorizontalAlignment(JTextField.CENTER); // 置中輸入
        // panel.add(textFields[i]);
        // }

        addBtn = new JButton("新增");
        addBtn.setFont(font3);
        // 監聽
        addBtn.addActionListener(this); // 連至下面的覆載，達到共用的功能
        panel.add(addBtn);

    }

    private JTextField getTextField(String toolTipText, int column, Font font) {
        JTextField field = new JTextField();
        field.setFont(font);
        field.setColumns(column);
        field.setToolTipText(toolTipText);
        field.setHorizontalAlignment(JTextField.CENTER); // 置中輸入
        return field;

    }

    private void initRightPanel() {
        // P2
        JPanel panel = new JPanel();
        // Font font = new Font(Font.MONOSPACED, Font.PLAIN, 22);

        // System.out.println((int) (WIDTH * 0.4) + 10 + 5);
        // System.out.println((int) (WIDTH * 0.6) - 10 - 45);
        // System.out.println((int) (HEIGHT * 0.8) - 60);

        // panel.setBounds(255, 10, 305, 260);
        panel.setBounds((int) (WIDTH * 0.4) + 10 + 5, 10, (int) (WIDTH * 0.55) - 10, HEIGHT - 120);
        Border line = BorderFactory.createLineBorder(Color.BLACK);
        panel.setBorder(BorderFactory.createTitledBorder(line, "資料"));
        panel.setLayout(null);
        add(panel);

        outputArea = new JTextArea();
        outputArea.setBounds(20, 20, (int) (WIDTH * 0.5) - 22, HEIGHT - 170);
        // outputArea.setBounds((int) (WIDTH * 0.4) + 15, 10, (int) (WIDTH * 0.6) - 55,
        // (int) (HEIGHT * 0.8) - 60);
        outputArea.setBorder(line);
        outputArea.setFont(font3);
        // outputArea.setLineWrap(true);
        // panel.add(outputArea);

        // 增加 Scrol Bar (滾輪滑動)
        JScrollPane scrollPane = new JScrollPane(outputArea,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, // 垂直，一直存在
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); // 水平，需要時存在
        scrollPane.setBounds(20, 20, (int) (WIDTH * 0.5) - 22, HEIGHT - 170); // 承載於 outputArea ，與之相同
        // scrollPane.setBounds(10, 20, 330, 200);
        panel.add(scrollPane); // 承載於 outputArea ， 已在 scrollPane 中

        // P3
        panel = new JPanel();
        panel.setBounds((int) (WIDTH * 0.4) + 10 + 5, HEIGHT - 100, (int) (WIDTH * 0.55) - 10, 50);
        // panel.setBackground(Color.BLUE);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        add(panel);

        saveBtn = new JButton("儲存");
        saveBtn.setFont(font2);
        saveBtn.addActionListener(this);
        panel.add(saveBtn);

        loadBtn = new JButton("讀取");
        loadBtn.setFont(font2);
        loadBtn.addActionListener(this);
        panel.add(loadBtn);

        clearBtn = new JButton("清除");
        clearBtn.setFont(font2);
        clearBtn.addActionListener(this);
        panel.add(clearBtn);

        appendCbx = new JCheckBox("附加");
        appendCbx.setFont(font1);
        appendCbx.setSelected(true);
        // appendCbx.addActionListener(this);
        panel.add(appendCbx);
    }

    // 檢查是否是數字
    private boolean isNumber(String text) {
        try {
            Double.valueOf(text); // 可通過檢查是否正確就好
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 儲存檔案
    private void save(String filename, String text, boolean append) {
        FileWriter fileWriter = null;
        File file = new File(filename);

        try {
            // fileWriter = new FileWriter(FILE_NAME, true);
            fileWriter = new FileWriter(filename, append);
            // System.out.println(fileWriter);
            // 輸入檔頭 (於不附加狀態 或 於附加但檔案不存在 或 檔案為空)
            // if (!append || !file.exists()) {
            if (!append || file.length() == 0 || !file.exists()) {
                fileWriter.write("姓名,國文,數學,英文\n");
            }
            fileWriter.write(text);

            JOptionPane.showMessageDialog(null, "資料寫入成功！");
            // System.out.println("寫入成功！");

        } catch (IOException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "資料寫入失敗！");
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                    System.out.println("檔案關閉");
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }

    private void open() {
        FileDialog fd = new FileDialog(this, "選擇檔案", FileDialog.LOAD);
        fd.setDirectory("");
        fd.setFile("*.csv");
        // fd.setFile("*.csv");
        fd.setVisible(true);

        String filename = fd.getFile();
        if (filename == null) {
            JOptionPane.showMessageDialog(null, "讀取檔案失敗!");
        } else {
            // 全域
            fileName = fd.getDirectory() + fd.getFile();
            this.setTitle(TITLE + " 編修檔案:" + fd.getFile());
            // load(fileName);
        }

    }

    private void load(String filename) {
        File file = new File(filename);
        FileReader fileReader = null;
        BufferedReader br = null;

        if (file.exists()) {
            try {
                // 更優的方法
                fileReader = new FileReader(filename);
                br = new BufferedReader(fileReader);
                String line;
                StringBuilder sb = new StringBuilder();
                int count = 0;
                while ((line = br.readLine()) != null) {
                    if (++count == 1) {
                        continue;
                    }
                    sb.append(line).append("\n");
                }

                outputArea.setText(sb.toString());
                // char[] cbuf = new char[(int) file.length()];
                // fileReader.read(cbuf);
                // String str = new String(cbuf);
                // outputArea.setText(str);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("檔案不存在");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 多個判斷是可考慮用 if...elseif 和 return

        // e.getSource() == addBtn saveBtn loadBtn clearBtn (按了哪個按鈕)

        if (e.getSource() == addBtn) {
            System.out.println("Chick！");

            JTextField[] fields = { nameText, chineseText, mathText, englishText };

            // 檢查是否輸入為空
            for (JTextField field : fields) {
                if (field.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "資料輸入不得為空！");
                    // System.out.println("資料輸入不得為空！");
                    return;
                }
            }

            // 檢查輸入是否正確 (分數該輸入數值)
            for (int i = 0 + 1; i < fields.length; i++) {
                if (!isNumber(fields[i].getText())) {
                    JOptionPane.showMessageDialog(null, "資料輸入有錯！");
                    // System.out.println("資料輸入有錯！");
                    return;
                }
            }

            // // 清空後寫入的特性 (用串接)
            // outputArea.setText(outputArea.getText() + nameText.getText());

            // 通過以上檢查後，將資料輸出到 outputArea
            StringBuilder sb = new StringBuilder();
            for (JTextField field : fields) {
                // 加 ,
                sb.append(field.getText()).append(",");
            }
            // 移除最後的, & 加 \n
            sb.setLength(sb.length() - 1); // 清除字元數 (0~6) -> (0~5)
            sb.append("\n");
            // 清空後寫入的特性 (用串接)
            // outputArea.setText(sb.toString());
            // 續寫
            outputArea.setText(outputArea.getText() + sb.toString());
            return;
        }

        // 增加清除功能
        if (e.getSource() == clearBtn) {
            // Y/N 顯示提示詢問是否清空
            // ---> 上網搜尋 java messagedialog yes no (stack)
            int dialogResult = JOptionPane.showConfirmDialog(null, "是否確定清除所有內容？",
                    "警告", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                outputArea.setText("");
            }
            return;
        }

        // 增加儲存功能
        if (e.getSource() == saveBtn) {

            if (fileName == null) {
                open();
            }
            if (fileName == null) {
                JOptionPane.showMessageDialog(null, "請先開啟檔案！");
                return;
            }

            String text = outputArea.getText();
            if (text.equals("")) {
                JOptionPane.showMessageDialog(null, "目前資料為空，請先輸入資料！");
                // System.out.println("目前資料為空，請先輸入資料！");
                return;
            }

            // 判斷是否要附加資料在後
            save(fileName, text, appendCbx.isSelected());

            return;
        }

        // 增加讀取功能
        if (e.getSource() == loadBtn) {
            open();
            if (fileName != null) {
                load(fileName);
            }
            return;
        }

    }

    // @Override
    // public void actionPerformed(ActionEvent e) {
    // // 0 1 (按了哪個按鈕)
    // if (e.getSource() == addBtn) {
    // System.out.println("增加資料！");
    // // 加 , \n
    // JTextField[] fields = { nameText, chineseText, mathText, englishText };
    // boolean add = true; // 也可改用 return 跳出
    // // 檢查是否輸入為空
    // for (JTextField field : fields) {
    // if (field.getText().equals("")) {
    // JOptionPane.showMessageDialog(null, "資料輸入不得為空！");
    // // System.out.println("資料輸入不得為空！");
    // add = false;
    // break;
    // }
    // }
    // // 檢查輸入是否正確 (分數該輸入數值)
    // if (add) {
    // for (int i = 0 + 1; i < fields.length; i++) {
    // if (!isNumber(fields[i].getText())) {
    // JOptionPane.showMessageDialog(null, "資料輸入有錯！");
    // // System.out.println("資料輸入有錯！");
    // add = false;
    // break;
    // }
    // }
    // }
    // // // 清空後寫入的特性 (用串接)
    // // outputArea.setText(outputArea.getText() + nameText.getText());
    // // 將資料再加入
    // if (add) {
    // StringBuilder sb = new StringBuilder();
    // for (JTextField field : fields) {
    // sb.append(field.getText()).append(",");
    // }
    // // 移除最後的,
    // sb.setLength(sb.length() - 1);
    // sb.append("\n");
    // outputArea.setText(outputArea.getText() + sb.toString());
    // }
    // }
    // }
}
