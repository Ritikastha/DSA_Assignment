package Database;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    public Connection connection;
    Statement statement;
    ResultSet resultSet;
    int val;

    public DatabaseConnection() {
        try {
            String username = "root";
            String password = "abcdef22440";
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DSA_Assignment", username, (String)password);
            if (this.connection != null) {
                System.out.println("Connected to Database");
            } else {
                System.out.println("Error Connecting Database");
            }

            this.statement = this.connection.createStatement();
        } catch (Exception var3) {
            System.out.println(var3);
            var3.printStackTrace();
        }

    }

    public int manipulate(PreparedStatement ps) {
        try {
            this.val = ps.executeUpdate();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return this.val;
    }

    public ResultSet retrieve(PreparedStatement ps) {
        try {
            this.resultSet = ps.executeQuery();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return this.resultSet;
    }

    public ResultSet retrieve(String query) {
        try {
            this.resultSet = this.statement.executeQuery(query);
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return this.resultSet;
    }

    public int manipulate(String query) {
        try {
            this.val = this.statement.executeUpdate(query);
            this.connection.close();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return this.val;
    }

    public static void main(String[] args) {
        new DatabaseConnection();
    }
}
