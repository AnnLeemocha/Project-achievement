package example.example;

import java.util.Scanner;

public class Student {

    private String name;
    private double weight;
    private double height;
    private double bmi;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, double weight, double height) {
        this.name = name;
        this.weight = getPositive(weight); // kg
        this.height = getPositive(height); // cm
    }

    // setter --------------------------------
    // public void setBMI(double bmi) {

    public void setBMI() {
        // 尚未輸入無法執行，也可使用 try
        if (weight == 0 || height == 0) {
            System.out.println("身高體重尚未輸入！");
            return;
        }

        // BMI值計算公式: BMI = 體重(公斤) / 身高^2(公尺^2)
        this.bmi = weight / Math.pow(height / 100, 2);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = getPositive(weight);
    }

    public void setHeight(double height) {
        this.height = getPositive(height);
    }

    // getter --------------------------------
    public double getBmi() {
        if (weight == 0 || height == 0) {
            System.out.println("身高體重尚未輸入！");
        }
        return this.bmi;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    @Override
    // try to ues StringBuilder
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(name).append("\t");
        stringBuilder.append(height).append("\t");
        stringBuilder.append(weight).append("\t");
        stringBuilder.append(bmi).append("\n");
        return stringBuilder.toString();
    }

    // methods --------------------------------

    // from Tool
    public static double getNextDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("請輸入數值：");
            scanner.next(); // 吃掉換行
        }
        return scanner.nextDouble();
    }

    // >0

    public static double getPositive(double value) {
        while (!(value > 0)) {
            System.out.print("請輸入大於0的數值：");
            return 0;
        }
        return value;
    }

}
