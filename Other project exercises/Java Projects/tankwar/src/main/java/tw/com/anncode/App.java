package tw.com.anncode;

import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Hello world!
 */
public final class App extends JFrame {

    // 為妥協讓每個物件取到 screenWidth 和 screenHeight 設成靜態唯一 // 應有更好方法
    public static GameClient gameClient;

    private App() {
        // 設定 JFrame
        setTitle("坦克大戰");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 拉掉視窗縮放功能 (但最小化還在)
        setResizable(false);

        // 放上 JComponent
        // 已把區域改稱全域
        gameClient = new GameClient();
        // GameClient gameClient = new GameClient();
        // GameClient gameClient = new GameClient(1024, 768);
        add(gameClient);

        // pack() 方法查看JFrame包含的內容，並自動設置窗口的大小。
        // ______ 在這種情況下，它確保窗口足夠大以顯示JLabel。
        // 顯示與擺放元件
        pack(); // 擺上目前所有元件
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // 遊戲區域，再重新繪製一次
        gameClient.repaint();

        // ■ 按鍵偵測(進行坦克移動)
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("press ： " + e.getKeyChar());
                System.out.println("press ： " + e.getKeyCode());
                // 做移動但沒重畫則不會動
                // 但不能時我操作後才更新，會造成敵方不動
                // 所以使用執行緒更新畫面
                gameClient.keyPressed(e);

            }

            @Override
            public void keyReleased(KeyEvent e) {
                gameClient.keyReleased(e);

            }

        });

        gameClient.run();

    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        new App();
    }
}
