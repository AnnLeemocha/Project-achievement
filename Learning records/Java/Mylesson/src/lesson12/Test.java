package lesson12;

public class Test {
    public static void main(String[] args) {
        int result = 0;
        int x = 0;
        int y = 1;

        if (x == y) {
            result = 0;
        } else if (x > y) {
            result = 1;
        } else {
            result = -1;
        }

        System.out.println(result);

        // 三元運算子
        result = (x == y) ? 0 : (x > y) ? 1 : -1;
        System.out.println(result);
    }
}
