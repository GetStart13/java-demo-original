package 数据库操作.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * <p> 2024/4/17 </p>
 * 连接池工具类
 *
 * @author Fqq
 */
public class JDBCUtils {
    private JDBCUtils() {
    }

    // 定义数据源静态成员变量
    private static DataSource dataSource;

    private static void createDatasource() throws Exception {
        // 加载配置文件
        Properties properties = new Properties();
        properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("mysql-config.properties"));
        // 获取 DataSource 对象
        dataSource = DruidDataSourceFactory.createDataSource(properties);
    }

    // 获取连接
    public static Connection getConnection() throws Exception {
        if (dataSource == null) {
            createDatasource();
        }
        return dataSource.getConnection();
    }

    // 关闭连接
    public static void close(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    // 获取数据源
    public static DataSource getDatasource() {
        return dataSource;
    }
}
