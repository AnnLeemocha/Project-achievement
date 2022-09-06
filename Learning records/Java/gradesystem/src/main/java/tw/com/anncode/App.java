package tw.com.anncode;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        // System.out.println("中文測試...");

        GradeSystem system = new GradeSystem();

        system.run(true);

        try {
            String chinse = "a"; // "13.5"
            double score = (Double.valueOf(chinse));
            System.out.println(score);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
}
