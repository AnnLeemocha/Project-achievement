
import java.sql.*;

public class Java_sql {

    public static void main(String[] args) {

        DBConnect connection = new DBConnect();
        connection.getData();

        // connection.insertData();
    }
}

class DBConnect {
    // 宣告
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DBConnect() {
        try {
            // Class ���R�A forName() ��k��{�ʺA�[�����O
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cmdev?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                    "root", "a0952122496");
            st = con.createStatement();

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void getData() {
        try {
            String query = "select * from travel";
            rs = st.executeQuery(query);
            System.out.println("Records for Database");
            while (rs.next()) {
                int empno = rs.getInt("empno");
                String location = rs.getString("location");
                System.out.println("empno= " + empno + " location= " + location);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void insertData() {
        try {

            // // Execute a query
            // System.out.println("Inserting records into the table...");
            // String sql = "INSERT INTO cmdev.travel\r\n"
            // + "VALUES (7900, 'BOSTON', 1)\r\n"
            // + "ON DUPLICATE KEY UPDATE counter = counter + 1";
            // st.executeUpdate(sql);
            // System.out.println("Inserted records into the table...");

            // Execute a query
            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO travel VALUES (7369, 'CHICAGO')";
            st.executeUpdate(sql);
            System.out.println("Inserted records into the table...");

            // sql = "INSERT INTO Registration VALUES (101, 'Mahnaz', 'Fatma', 25)";
            // st.executeUpdate(sql);
            // sql = "INSERT INTO Registration VALUES (102, 'Zaid', 'Khan', 30)";
            // st.executeUpdate(sql);
            // sql = "INSERT INTO Registration VALUES(103, 'Sumit', 'Mittal', 28)";
            // st.executeUpdate(sql);
            // System.out.println("Inserted records into the table...");
            // ref : https://www.tutorialspoint.com/jdbc/jdbc-insert-records.htm
            /*
             * String query = "select * from travel";
             * // st.execute(query)
             * rs = st.executeQuery(query);
             * System.out.println("Records for Database");
             * while(rs.next()) {
             * int empno = rs.getInt("empno");
             * String location = rs.getString("location");
             * System.out.println("empno= "+empno+" location= "+location);
             * }
             * 
             */
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}