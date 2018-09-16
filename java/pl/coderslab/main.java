package pl.coderslab;

import pl.coderslab.models.User;
import pl.coderslab.models.UserGroup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) {
        User user = new User("adam", "adam@gmail.com", "123kotek", new UserGroup(1, "Nazwa grupy"));
        try {
            Connection connection = getConnection();

//            user.saveToDb(connection);
//            System.out.println(user.getId());

            User user2 = User.loadUserById(connection, 3);
            System.out.println(user2);

//            User[] users = User.loadAllUsers(connection);
//            for(User userElement : users) {
//                System.out.println(userElement);
//            }
//            user2.setUsername("annanowak");
//            user2.setEmail("annanowak@gmail.com");
//            user2.setPassword("223kotek");
//            user2.saveToDb(connection);

            user2.delete(connection);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Warsztaty_2?useSSL=false" +
                            "&characterEncoding=utf8" +
                            "&useUnicode=true" +
                            "&useJDBCCompliantTimezoneShift=true" +
                            "&useLegacyDatetimeCode=false" +
                            "&serverTimezone=UTC",
                    "root", "coderslab");
    }


}
