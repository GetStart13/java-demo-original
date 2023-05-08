package 数据库操作.druid;

import 数据库操作.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*插入数据*/
public class DruidDemo2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        /*添加操作*/
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.定义 SQL，? 是占位符
            String sql = "insert into Student values(?,?,?,?)";
            //3.获取Statement对象
            pstmt = conn.prepareStatement(sql);
            //4.赋值
            pstmt.setString(1, "小红");
            pstmt.setString(2, "数学");
            pstmt.setInt(3, 88);
            pstmt.setString(4, "pass");
            //5.执行SQL语句
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //释放资源
        finally {
            JDBCUtils.close(pstmt, conn);
        }
    }
}
