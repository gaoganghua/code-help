package com.code.help.table_to_bean.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = "tabletobean/application-datasource.yml")
public class DataSourceConfig {
    @Value("${hikari.drivername}")
    private String driverName;

    @Value("${hikari.username}")
    private String userName;

    @Value("${hikari.password}")
    private String password;

    @Value("${hikari.url}")
    private String url;

    @Bean
    public DataSource dataSource(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driverName);
        config.setUsername(userName);
        config.setPassword(password);
        config.setJdbcUrl(url);

        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }
}
