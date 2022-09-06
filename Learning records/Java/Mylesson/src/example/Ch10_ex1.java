package example;

import java.util.Scanner;

interface Shape {
   double getArea();
}

// 圓形
class Circle implements Shape {

   private double radius;

   Circle(double radius) {
      // super();
      this.radius = radius;
   }

   @Override
   public double getArea() {
      return Math.pow(radius, 2) * Math.PI;
   }

}

// 長方形
class Rectangle implements Shape {

   private double width, height;

   Rectangle(double height, double width) {
      this.height = height;
      this.width = width;
   }

   @Override
   public double getArea() {
      return width * height;
   }

}

// 梯形
class Tapzoid implements Shape {
   // 上底,下底,高
   private double upSide, downSide, high;

   Tapzoid(double upSide, double downSide, double high) {
      this.upSide = upSide;
      this.downSide = downSide;
      this.high = high;
   }

   @Override
   public double getArea() {
      return (upSide + downSide) * high * 0.5;
   }

}

public class Ch10_ex1 {
   /**
    * ■ 請完成ch10_ex1.java練習
    * ■ 實現迴圈重覆輸入
    * ■ 使用多型觀念取得面積
    */
   public static void main(String[] args) {

      // 向上轉型準備
      Shape shape = null;
      Scanner input = new Scanner(System.in);

      while (true) {
         System.out.println("============================");
         System.out.println("請選擇要計算哪個面積");
         System.out.println("(1)方形");
         System.out.println("(2)圓形");
         System.out.println("(3)梯形");
         System.out.println("(4)離開");
         System.out.print("請選擇：");

         int choice = input.nextInt();
         if (choice == 1) {
            System.out.println("請輸入長跟寬"); // 空格來輸入問題
            System.out.print("height：");
            double height = getNextDoublePositive(input);
            System.out.print("width：");
            double width = getNextDoublePositive(input);
            // 多型-向上轉型
            shape = new Rectangle(height, width);

         } else if (choice == 2) {
            System.out.println("請輸入半徑");
            double radius = getNextDoublePositive(input);
            System.out.print("radius：");
            // 多型-向上轉型
            shape = new Circle(radius);

         } else if (choice == 3) {
            System.out.println("請輸入上底/下底/高");
            System.out.print("upSide：");
            double upSide = getNextDoublePositive(input);
            System.out.print("downSide：");
            double downSide = getNextDoublePositive(input);
            System.out.print("high：");
            double high = getNextDoublePositive(input);
            // 多型-向上轉型
            shape = new Tapzoid(upSide, downSide, high);

         } else {
            break;
         }

         System.out.println("面積為:" + shape.getArea());
      }
      input.close();
   }

   // 輸入>0
   static double getNextDoublePositive(Scanner scanner) {
      double value = getNextDouble(scanner);
      while (value < 0) {
         System.out.println("請輸入 >0 的數值：");
         value = getNextDouble(scanner);
      }
      return value;
   }

   // 型態確認
   public static double getNextDouble(Scanner scanner) {
      while (!scanner.hasNextDouble()) {
         System.out.println("請輸入正確的數字型態(Double)：");
         scanner.next();
      }
      return scanner.nextDouble();
   }
}
