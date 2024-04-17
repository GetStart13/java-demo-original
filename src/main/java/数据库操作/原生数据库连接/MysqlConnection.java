package 数据库操作.原生数据库连接;


import java.sql.*;

/**
 * 原生 jdbc 连接 MySQL
 */
public class MysqlConnection {
    public static void main(String[] args) {
        // 1、获取数据库驱动
        String driver = "jdbc:mysql://localhost:3306/test";
        // 2、定义 sql 语句
        String sql = "select * from sys_user";
        // 3、获取数据库连接
        Connection connection = null;
        // 4、创建执行者
        Statement statement = null;
        // 5、执行 sql 语句   ------>>> 执行完后需要关闭数据库连接
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(driver, "root", "123456");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String one = resultSet.getString(1);
                String two = resultSet.getString(2);
                String three = resultSet.getString(3);
                String four = resultSet.getString(4);
                String five = resultSet.getString(5);
                System.out.printf("column1: %s, column2: %s, column3: %s, column4: %s, column5: %s%n",
                    one, two, three, four, five);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 6、关闭数据库连接，最后执行的最先关闭
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    resultSet = null;
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    statement = null;
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    connection = null;
                }
            }
        }

    }
}
