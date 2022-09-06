package lesson7;

/**
 * StringBuffer ==> 一模一樣，多執行緒
 * StringBuilder ==> 一模一樣，單執行緒
 */
public class Ch7_6 {
    public static void main(String[] args) {
        String name = "Jerry";
        System.out.println(name.length());
        System.out.println(name.length());
        // System.out.println(name.capacity()); // (並無此方法)
        System.out.println("------------------------------");

        // 建構一個字串緩衝區，初始大小為16個字元
        StringBuffer sb = new StringBuffer(); // 初始
        System.out.println(sb.length()); // 字串長度
        System.out.println(sb.capacity()); // 容量 (初始大小為16個字元)
        System.out.println(sb);
        System.out.println("------------------------------");

        // 建構一個字串緩衝區，並初始其大小
        sb = new StringBuffer(10);// 自訂容量大小
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        sb.append(1234567890);
        // sb.append(123456789011); // 超過容量會報錯
        System.out.println(sb);
        System.out.println("------------------------------");

        // 建構一個字串緩衝區，並傳入字串為初始值
        // StringBuffer (多執行緒) ; StringBuilder (單執行緒) ---> 但功能相同
        // StringBuffer sb1 = new StringBuffer("Jerry");
        StringBuilder sb1 = new StringBuilder("Jerry"); // 證明相同
        System.out.println(sb1.length());
        System.out.println(sb1.capacity());
        System.out.println(sb1);
        System.out.println("------------------------------");

        // append方法 (加入值到StringBuffer ---> 多載，可加各種型態)
        sb1.append("\t").append(38).append("\t").append("str");
        System.out.println(sb1.length());
        System.out.println(sb1.capacity());
        System.out.println(sb1);
        System.out.println("------------------------------");

        // 輸出型態 用字串輸出
        String result = sb1.toString();
        System.out.println(sb1);
        System.out.println(result);
        System.out.println("------------------------------");

        // 刪除前 0~5 (不包含 5 的字元)
        sb1.delete(0, 5);
        System.out.println(sb1.toString());
        System.out.println("------------------------------");

        // 添加...在0的位置
        sb1.insert(0, "Mary");
        System.out.println(sb1.toString());
        System.out.println("------------------------------");

        // 取代 0~4 (不包含4) 為 ...
        sb1.replace(0, 4, "Mario");
        System.out.println(sb1.toString());
        System.out.println("------------------------------");

    }
}
