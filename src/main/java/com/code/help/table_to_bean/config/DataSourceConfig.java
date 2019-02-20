package com.code.help.table_to_bean.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = {"tabletobean/application-datasource.yml","application.properties"})
public class DataSourceConfig {
    @Value("${hikari.drivername}")
    private String driverName;

    @Value("${hikari.username}")
    private String userName;

    @Value("${hikari.password}")
    private String password;

    @Value("${hikari.url}")
    private String url;

    @Value("${local.test.pro}")
    private String localTest;

    @Bean
    public DataSource dataSource(){
        if(!"table_bean".equals(localTest)){
            return null;
        }
        if(StringUtils.isEmpty(driverName) || StringUtils.isEmpty(userName) || StringUtils.isEmpty(password) || StringUtils.isEmpty(url)){
            return null;
        }
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driverName);
        config.setUsername(userName);
        config.setPassword(password);
        config.setJdbcUrl(url);

        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }
}
