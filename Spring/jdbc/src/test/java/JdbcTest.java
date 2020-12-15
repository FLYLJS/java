import java.sql.*;

public class JdbcTest {

    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssm?serverTimezone=UTC", "root", "123456");
        PreparedStatement preparedStatement = connection.prepareStatement("select *from user where id = ?");
        preparedStatement.setInt(1,3);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("username"));
        }
        resultSet.close();
        preparedStatement.close();
    }
}
