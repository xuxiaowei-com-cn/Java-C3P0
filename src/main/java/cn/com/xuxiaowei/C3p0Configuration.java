package cn.com.xuxiaowei;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.impl.C3P0Defaults;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * C3P0 示例
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
public class C3p0Configuration {

    public static void main(String[] args) {

        C3p0Configuration c3p0Configuration = new C3p0Configuration();

        c3p0Configuration.mysql();

        c3p0Configuration.oracle();

    }

    public void mysql() {

        // 创建连接池示例
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        // 设置连接池所需驱动
        dataSource.setDataSourceName(com.mysql.cj.jdbc.Driver.class.getName());

        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/c3p0?useSSL=false&serverTimezone=GMT%2B8");

        dataSource.setUser("root");

        dataSource.setPassword("root");

        // 设置连接池最大连接数，默认：15
        dataSource.setMaxPoolSize(C3P0Defaults.maxPoolSize());

        // 设置连接池的最小连接数，默认：3
        dataSource.setMinPoolSize(C3P0Defaults.minPoolSize());

        // 设置连接池的初始连接数，默认：3
        dataSource.setInitialPoolSize(C3P0Defaults.initialPoolSize());

        // 设置连接池的缓存 Statements 的最大数，默认：0
        dataSource.setMaxStatements(C3P0Defaults.maxStatements());

        try (Connection connection = dataSource.getConnection()) {

            System.out.println(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void oracle() {

        // 创建连接池示例
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        // 设置连接池所需驱动
        dataSource.setDataSourceName(oracle.jdbc.driver.OracleDriver.class.getName());

        dataSource.setJdbcUrl("jdbc:oracle:thin:@192.168.8.128:1521:ORCL");

        dataSource.setUser("scott");

        dataSource.setPassword("orcl");

        // 设置连接池最大连接数，默认：15
        dataSource.setMaxPoolSize(C3P0Defaults.maxPoolSize());

        // 设置连接池的最小连接数，默认：3
        dataSource.setMinPoolSize(C3P0Defaults.minPoolSize());

        // 设置连接池的初始连接数，默认：3
        dataSource.setInitialPoolSize(C3P0Defaults.initialPoolSize());

        // 设置连接池的缓存 Statements 的最大数，默认：0
        dataSource.setMaxStatements(C3P0Defaults.maxStatements());

        try (Connection connection = dataSource.getConnection()) {

            System.out.println(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
