package tw.com.anncode.gameobject;

import java.awt.*;
import javax.swing.*;

// ■ 宣告Tools類別 (工具類別)
public class Tools {

    // ■ 靜態讀取圖形方法
    public static Image getImage(String fileName) {
        return new ImageIcon("assets/images/" + fileName).getImage();
    }

}
