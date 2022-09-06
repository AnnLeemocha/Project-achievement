package practise;

/**
 *  接著請根據設計圖A建立二大樓 A1 及 A2 ,並修改裡面的設定值。
 * _  A1 Name:A1大樓; Price:350萬
 * _  A2  Name:A2大樓; Quantity:30
 *  請以類別與物件的角度建立程式,並輸出 A1、A2的四項資訊。
 */

public class BuildingDemo {
    public static void main(String[] args) {
        // 宣告 建立實體物件 A1 ， A2 大樓
        Building A1 = new Building();
        Building A2 = new Building();

        // 輸出初始資訊
        System.out.printf("------------- 初始資訊 -------------\n");
        System.out.println(A1.getInfo());
        // String format = "Name：%s \nSize：%d \nPrice：%,d \nQuantity：%d\n";
        // System.out.printf(format, A1.getName(),
        // A1.getSize(), A1.getPrice(), A1.getQuantity());

        // 修改 A1 設定值
        A1.setName("A1大樓");
        A1.setPrice(3500000);
        // 修改 A2 設定值
        A2.setName("A2大樓");
        A2.setQuantity(30);

        // 輸出資訊
        System.out.printf("------------- 修改後 A1 資訊 -------------\n");
        System.out.println(A1.getInfo());
        // System.out.printf(format, A1.getName(),
        // A1.getSize(), A1.getPrice(), A1.getQuantity());
        System.out.printf("------------- 修改後 A2 資訊 -------------\n");
        System.out.println(A2.getInfo());
        // System.out.printf(format, A2.getName(),
        // A2.getSize(), A2.getPrice(), A2.getQuantity());
    }
}
