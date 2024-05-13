package test_temp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class TempDemo1 {

    public static void main(String[] args) {
        // 1、获取数据库驱动
        String driver = "jdbc:mysql://localhost:3306/test";
        // 2、定义 sql 语句
        String sql = "select * from student right outer join sys_user on student.grade = sys_user.num";
        String sql1 =
            "select * from student left join sys_user on student.grade = sys_user.num where sys_user.username is not null";
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
            ResultSet resultSet1 = connection.createStatement().executeQuery(sql1);

            HashSet<Integer> set = new HashSet<>();
            while (resultSet1.next()) {
                String id = resultSet1.getString("id");
                set.add(Integer.parseInt(id));
            }
            System.out.println("set size: " + set.size());
            int columnCount = resultSet.getMetaData().getColumnCount();
            int index = 0;
            while (resultSet.next()) {
                ++index;
                String idString = resultSet.getString("id");
                if (idString == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 1; i <= columnCount; i++) {
                        String string = resultSet.getString(i);
                        stringBuilder.append(string).append(" - ");
                    }
                    System.out.println(stringBuilder);
                    continue;
                }
                int id = Integer.parseInt(idString);
                if (!set.contains(id)) {
                    System.out.println("not contains id: " + id);
                }
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
