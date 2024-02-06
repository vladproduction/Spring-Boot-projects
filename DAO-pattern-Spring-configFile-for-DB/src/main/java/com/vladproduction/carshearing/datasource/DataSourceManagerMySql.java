package com.vladproduction.carshearing.datasource;

import com.vladproduction.carshearing.utils.ConfigUtils;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DataSourceManagerMySql implements DataSourceManager {
    @Override
    public Connection getConnection() throws SQLException {
        String url = ConfigUtils.getConfigProperty("DB.url");
        String login = ConfigUtils.getConfigProperty("DB.login");
        String password = ConfigUtils.getConfigProperty("DB.password");
        return DriverManager.getConnection(url,login,password);
    }
}
