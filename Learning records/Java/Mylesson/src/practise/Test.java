package practise;

public class Test {
    public static void main(String[] args) {
        System.out.println((byte) 557);
        System.out.println(3 + 4 + "str" + 3 + 4);
        System.out.println(13 ^ 25);
        System.out.println(10E2);
        System.out.println(0xB0C);
        // long a = 3876543210L;
        char b = 50000;
        System.out.println(b);
        for (int index = 0; index < 7; index++) {
            if (index % 7 == 0) {
                continue;
            }
            System.out.println(index);
            System.out.println((byte) 128);
        }

        int answer = (int) (Math.random() * (20) + (-5));
        java.util.Random random = new java.util.Random();
        answer = random.nextInt(20 + 1) - Math.abs(-5);

        while (answer != -5) {
            answer = random.nextInt(20 + 1) - Math.abs(-5);
            // answer = (int) (Math.random() * (20 + 1) + (-5));
            System.out.println(answer);

        }

        String s1 = "AAAAA";
        String s2 = "AAAAA";
        s2 = "BBBBB";
        System.out.println(s1);
        System.out.println(s2);
    }
}
