import java.sql.*;

public class StudentJDBC {
    public static void main(String[] args) {

        try {
            // 1. Load Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 2. Connect to Oracle
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "system",
                "manager"
            );

            System.out.println("Connected Successfully!");

            // 3. Create Statement
            Statement stmt = con.createStatement();

            // -----------------------------------------
            // 🔹 CREATE TABLE
            // -----------------------------------------
            try {
                stmt.executeUpdate(
                    "CREATE TABLE student (" +
                    "id NUMBER PRIMARY KEY, " +
                    "name VARCHAR2(50), " +
                    "course VARCHAR2(50))"
                );
                System.out.println("Table Created!");
            } catch (Exception e) {
                System.out.println("Table already exists!");
            }

            // -----------------------------------------
            // 🔹 INSERT DATA
            // -----------------------------------------
            stmt.executeUpdate("INSERT INTO student VALUES (1, 'Appu', 'MCA')");
            stmt.executeUpdate("INSERT INTO student VALUES (2, 'Anu', 'BCA')");
            stmt.executeUpdate("INSERT INTO student VALUES (3, 'Rahul', 'MBA')");

            System.out.println("Data Inserted!");

            // -----------------------------------------
            // 🔹 UPDATE DATA
            // -----------------------------------------
            stmt.executeUpdate(
                "UPDATE student SET course='MCA' WHERE id=2"
            );

            System.out.println("Data Updated!");

            // -----------------------------------------
            // 🔹 DISPLAY DATA
            // -----------------------------------------
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            System.out.println("\n--- STUDENT TABLE ---");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("course")
                );
            }

            // 4. Close Connection
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}