package practise;

/**
 *  請建立一個設計圖A,裡面有Name,Size,Price,Quantity四項,初始值分別如下:
 * _  Name:A 大樓設計圖
 * _  Size:30
 * _  Price:300萬
 * _  Quantity:20
 */

// 建立類別Ａ
class A {
    // 屬性資料
    String name;
    int size;
    int price;
    int quantity;

    // 建構式 (設定初始值)
    public A() {
        name = "A大樓設計圖";
        size = 30;
        price = 3000000;
        quantity = 20;
    }

    public String getInfo() {
        return String.format("大樓名稱：%s%n空間大小：%d%n價格：%,d元%n數量：%d", name, size, price, quantity);
    }
}

/**
 *  接著請根據設計圖A建立二大樓 A1 及 A2 ,並修改裡面的設定值。
 * _  A1 Name:A1大樓; Price:350萬
 * _  A2  Name:A2大樓; Quantity:30
 *  請以類別與物件的角度建立程式,並輸出 A1、A2的四項資訊。
 */

public class Exercise_8_2號李旻恩 {

    // 主程式
    public static void main(String[] args) {
        // 宣告 建立實體物件 A1 ， A2 大樓
        A A1 = new A();
        A A2 = new A();

        // 輸出初始資訊
        // String format = "Name：%s \nSize：%d \nPrice：%,d \nQuantity：%d\n";
        System.out.println("----------------    初始資訊    ----------------");
        System.out.println(A1.getInfo());
        // System.out.printf(format, A1.name, A1.size, A1.price, A1.quantity);

        // 修改 A1 設定值
        A1.name = "A1大樓";
        A1.price = 3500000;
        // 修改 A2 設定值
        A2.name = "A2大樓";
        A2.quantity = 30;

        // 輸出資訊
        System.out.println("---------------- 修改後 A1 資訊 ----------------");
        System.out.println(A1.getInfo());
        // System.out.printf(format, A1.name, A1.size, A1.price, A1.quantity);
        System.out.println("---------------- 修改後 A2 資訊 ----------------");
        System.out.println(A2.getInfo());
        // System.out.printf(format, A2.name, A2.size, A2.price, A2.quantity);
    }
}
