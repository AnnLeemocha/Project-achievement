package example;

import example.example.BMI;

public class Ch8_ex2_BMIDemo {
    public static void main(String[] args) {
        BMI bmi = new BMI("Jerry", 35, 58, 165);

        System.out.println("BMI：" + bmi.getBMI());
        System.out.println(bmi.getStatus());

        System.out.println("-------------------------------------------------------");
        bmi = new BMI("Mary", 48, 155); // 預設 20 歲

        System.out.println("BMI：" + bmi.getBMI());
        System.out.println(bmi.getStatus());
    }
}
