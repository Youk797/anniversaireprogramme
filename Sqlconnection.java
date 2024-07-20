import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Sqlconnection implements Database {
    private static String url = "jdbc:mysql://localhost:3305/anniv";
    private static String user = "root";
    private static String password = "youk";
    private Connection connection;

    @Override
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Friend> getFriends() {
        List<Friend> friends = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM people")) {
            while (rs.next()) {
                Friend Friend = extractFriendFromResultSet(rs);
                friends.add(Friend);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return friends;
    }

    public Friend extractFriendFromResultSet(ResultSet rs) throws SQLException {
        return new Friend(
            rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getString("email"),
            rs.getString("date_of_birth")
        );
    }
}
