package lesson2;

public class Ch2_2 {
    public static void main(String[] args) throws Exception {
        float pi = 3.1415926f;
        float radius = 5.5f;
        // radius*radius*pi
        double area = radius * radius * pi;

        System.out.println("半徑：" + radius);
        System.out.println("圓周率：" + pi);
        System.out.println("圓面積：" + area);
        System.out.println("圓周長：" + (radius * 2 * pi));

    }
}
