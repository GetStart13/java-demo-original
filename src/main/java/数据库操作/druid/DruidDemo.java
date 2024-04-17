package 数据库操作.druid;

import 数据库操作.entity.Student;
import 数据库操作.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 德鲁伊连接池测试样例
 */
public class DruidDemo {
    public static void main(String[] args) throws SQLException {
        //insert();
        select();
    }

    /**
     * 添加操作
     */
    private static void insert() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // 1. 获取连接
            connection = JDBCUtils.getConnection();
            // 2. 定义 SQL 语句，`?` 是占位符
            String sql = "insert into Student values(?,?,?,?)";
            // 3. 对 sql 进行预处理，构建 Statement 对象
            statement = connection.prepareStatement(sql);
            // 4. 按照数据库的列（column）索引进行赋值
            statement.setString(1, "小红");
            statement.setString(2, "数学");
            statement.setInt(3, 88);
            statement.setString(4, "pass");
            // 5. 执行 SQL 语句，count: 受影响行数
            int count = statement.executeUpdate();
            System.out.println(count);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally { // 关闭连接
            JDBCUtils.close(null, statement, connection);
        }
    }

    /**
     * 查询操作
     */
    private static void select() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from student";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            // 最多读取 10 行数据
            int limit = 10;
            int i = 0;
            // 遍历结果集的行数据
            while (resultSet.next() && i < limit) {
                ++i;
                // 根据列名获取对应的值
                String name = resultSet.getString("name");
                String course = resultSet.getString("course");
                int grade = resultSet.getInt("grade");
                String pass = resultSet.getString("is_passed");
                // 封装到对象中
                Student student = new Student();
                student.setName(name);
                student.setCourse(course);
                student.setGrade(grade);
                student.setIsPassed(pass);
                System.out.println(student);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(resultSet, statement, connection);
        }
    }
}
