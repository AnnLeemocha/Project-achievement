package lesson13;

// import java.util.Arrays;

public class Student implements Comparable<Student> {
    private String name;
    private double[] scores;

    public Student(String name) {
        this.name = name;
    }

    // public void setScore(double[] scores) {
    // this.scores = scores;
    // }

    public double[] getScores() {
        return scores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScores(double[] scores) {
        this.scores = scores;
    }

    // // 測試用
    // public static void main(String[] args) {
    // Student s = new Student("Jerry");
    // double[] score = { 100, 66, 77 };
    // s.setScores(score);
    // System.out.println(s.toString());
    // }

    // @Override
    // public String toString() {
    // return "Student{" +
    // "name=" + name + // "\t" +
    // ", scores=" + Arrays.toString(scores) +
    // "}";
    // }
    @Override
    // 改輸出格式 Jerry,100,77,88
    // 改用 StringBuilder
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(name).append(","); // Jerry,
        for (int i = 0; i < scores.length; i++) {
            if (i == scores.length - 1) {
                stringBuilder.append(scores[i]).append("\n"); // 最後記得加換行，要不然續寫會連在後面
            } else {
                stringBuilder.append(scores[i]).append(",");
            }

        }

        return stringBuilder.toString(); // StringBuilder 的 toString()
        // return String.format("%s,%.2f,%.2f,%.2f",
        // name,scores[0],scores[1],scores[2]);
    }

    // 一般方法 (每個子類都會產生一舫方法)
    public double getAvg2() {
        double total = 0;
        for (double score : getScores()) {
            total += score;
        }
        return total / scores.length;
    }

    // 靜態方法 (類別方法，類別唯一，只在父類產生，子類共用)
    public static double getAvg(Student student) {
        double total = 0;
        double[] scores = student.getScores();
        for (double score : student.getScores()) {
            total += score;
        }

        return total / scores.length;
    }

    // 錯誤 -> public class Student implements Comparable<Student>
    // @Override
    // public int compareTo(Object o) {
    // return 0;
    // }

    // 排序-反(升1<->-1)序 (針對平均分) --> 75,66,66,100 ==> 66,66,75,100
    // 回傳 0 ==> 兩值相等(不動)
    // 回傳 1 ==> this較大(位置交換)
    // 回傳 -1 ==> this比較小(不動)
    // a.compareTo(b) --> a,b比較 (this=a)
    @Override
    public int compareTo(Student o) {
        if (getAvg(this) == getAvg(o)) {
            return 0;
        }
        if (getAvg(this) > getAvg(o)) {
            return -1;
        }
        if (getAvg(this) < getAvg(o)) {
            return 1;
        }

        return 0;

        // // 三元寫法
        // return (getAvg(this) == getAvg(o)) ? 0 : (getAvg(this) > getAvg(o)) ? 1 : -1;
    }
    // 介面： comparable
    // 抽象方法實作： compareto
    // 使用方式： collections.sort()

}
