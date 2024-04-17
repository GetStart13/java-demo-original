package 数据库操作.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid 演示
 */
public class GetConnectionByDruid {
    public static void main(String[] args) throws Exception {
        // 1. 导入 jar 包
        // 2. 定义配置文件
        // 3. 加载配置文件
        Properties properties = new Properties();
        InputStream configStream = GetConnectionByDruid.class.getClassLoader().getResourceAsStream("mysql-config.properties");
        properties.load(configStream);
        // 4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        // 5.获取连接
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("MySQL connected: " + connection);
        }
    }
}
