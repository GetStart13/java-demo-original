package 数据库操作.druid;

import 数据库操作.utils.JDBCUtils;

import java.sql.*;
/*遍历结果集*/
public class DruidDemo3 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select *from student";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();//结果集

            Student stu = new Student();
            while (rs.next()) {//操作结果集里的单条数据
                String name = rs.getString("name");
                String course = rs.getString("course");
                int grade = rs.getInt("grade");
                String pf = rs.getString("pf");
                stu.setName(name);
                stu.setCourse(course);
                stu.setGrade(grade);
                stu.setPf(pf);
                System.out.println(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(stmt, conn);
        }
    }
}
