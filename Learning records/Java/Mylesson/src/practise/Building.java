package practise;

/**
 *  請建立一個設計圖A,裡面有Name,Size,Price,Quantity四項,初始值分別如下:
 * _  Name:A 大樓設計圖
 * _  Size:30
 * _  Price:300萬
 * _  Quantity:20
 */

public class Building {
    // 屬性資料
    private String name;
    private int size;
    private int price;
    private int quantity;

    // 建構式 (初始值)
    public Building() {
        name = "A大樓設計圖";
        size = 30;
        price = 3000000;
        quantity = 20;
    }

    // 方法資料 set 系列 --- (名字，大小，價格，數量)
    public void setName(String newName) {
        name = newName;
    }

    public void setSize(int newSize) {
        if (newSize > 0) {
            size = newSize;
        }
    }

    public void setPrice(int newPrice) {
        if (newPrice > 0) {
            price = newPrice;
        }
    }

    public void setQuantity(int newQuantity) {
        if (newQuantity > 0) {
            quantity = newQuantity;
        }
    }

    // 方法資料 get 系列 --- (名字，大小，價格，數量)
    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getInfo() {
        return String.format("大樓名稱：%s%n空間大小：%d%n價格：%,d元%n數量：%d", name, size, price, quantity);
    }
}
