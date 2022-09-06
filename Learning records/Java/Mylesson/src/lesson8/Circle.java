package lesson8;

/**
 * ■ 設計圓的類別
 * SimpleCircle()
 * SimpleCircle(double newRadius)
 * getArea():double
 */
/**
 * ■ 類別關鍵字為class
 * ■ 類別名稱第一個字母應為大寫
 * ■ 至少都會有一個空的建構式
 * - ■ 建構式為產生實體時第一個呼叫的方法(函式)
 * - ■ 自動產生(如果沒有其他建構式)
 * - ■ 建構式不能有回傳值
 */
/**
 * 類別的屬性
 * ■ 作用區域為整個類別
 * ■ 全域變數
 */
/**
 * 類別的方法
 * ■ 方法內的變數
 * ■ 作用區域為該方法內
 * ■ 區域變數
 * ■ 產生實體
 * - ■ 類別名稱 物件名稱=new 類別名稱()
 * ■ 類別還沒變成實體物件時需設定為null
 * ■ 宣告成實體物件使用new 運算子
 */
// public 代表 class 名稱與檔名一定要一致，字首一定要大寫(區別用)
public class Circle {
    // ===================================================================
    // 類別的成員屬性區
    // 作用區域為整個類別，全域變數 (radius)
    // 修飾子全公開 (對外)
    // public double radius;
    // 修飾子 package (default) 的公開
    /**
     * Circle 類別的成員屬性區
     */
    double radius; // 不賦值，預設為 0.0

    // ===================================================================
    // 類別的成員方法區
    // 必須要有建構式 (空，可多載，但不能有回傳值) ---> 給個位置
    // 預設建構式(空建構式) ---> 【拿掉將會發生引用錯誤 (多載會覆蓋空建構式)】
    /**
     * Circle 類別的成員方法區
     */
    // Circle() {
    // // 可做任何的預設值的概念，更改全域變數原本的預設值，建立自己的預設值
    // radius = 0.5;
    // }

    // 更改修飾子
    public Circle() { // 除 package8 外也可以用，但最好盡可能不公開
        // 可做任何的預設值的概念
        radius = 0.5;
    }

    // 建構式2(多載) ---> 【建構式都拿掉， 只會保留空的建構式(類別自動產生)，但隱藏看不到】
    // 方法內的變數，離開即釋放，區域變數 (newRadius)
    // 修改全域變數

    Circle(double newRadius) {
        radius = newRadius;
    }

    // -----------------------------------------------------------------
    // 計算圓面積
    public double getArea() {
        return radius * radius * Math.PI;
    }

    // 計算圓周長
    public double getPerimeter() {
        return radius * 2 * Math.PI;
    }

    // 取得半徑的方法
    public double getRadius() {
        return radius;
    }

    // 設定半徑的方法
    // 算是給予其他 package 權限，可加上限制
    /**
     * 半徑設定
     * (範圍限定 radius >0 & <=10000)
     * 
     * @param newRadius
     */
    public void setRadius(double newRadius) {
        if (newRadius > 0 && newRadius <= 10000) {
            radius = newRadius;
        } else {
            System.out.println("半徑設定錯誤！ (>0 & <=10000)");
        }
    }

}
