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
            System.out.println("+-   id   -+" + "- username -+" + "-         email         -+"
                    + "- password -+" + "-   num   -+");
            while (resultSet.next()) {
                String one = resultSet.getString(1);
                String two = resultSet.getString(2);
                String three = resultSet.getString(3);
                String four = resultSet.getString(4);
                String five = resultSet.getString(5);
                System.out.print("| " + one + "        |");
                System.out.print(" " + two + addEmpty(two, 11));
                System.out.print(" " + three + addEmpty(three, 24));
                System.out.print(" " + four + addEmpty(four, 11));
                System.out.println(" " + five + addEmpty(five, 10));
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

    /**
     * 填补空格，更好看
     * str：传入字符串
     * amount：指定的字符串字符数量
     */
    private static String addEmpty(String str, int amount) {

        int length = 0;
        if (str != null) { // 如果参数不为空，获取长度
            length = str.length();
        }
        if (str != null && str.charAt(str.length() - 1) > 256) { // 如果是中文，对填补做出修改
            length += 2;
        }
        if (str == null) { // 如果为空，对填补做出修改
            length += 4;
        }
        StringBuilder string = new StringBuilder("                            ");
        return string.substring(length, amount) + "|";
    }
}
