package cn.infit.ll.interceptor;

import org.apache.log4j.jdbc.JDBCAppender;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class LogJDBCAppender extends JDBCAppender {

    @Override
    protected Connection getConnection() throws SQLException {
        if (!DriverManager.getDrivers().hasMoreElements()) setDriver("sun.jdbd.odbc.JdbcOdbcDriver");
        try {
            connection.isClosed();
        } catch (Exception e) {
            System.out.println(new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + "Log4j连接失效，将重新获取连接");
            connection = null;
        }
        if (connection == null) {
            connection = DriverManager.getConnection(databaseURL, databaseUser, databasePassword);
        }
        return connection;
    }
}
