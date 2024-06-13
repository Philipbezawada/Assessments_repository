package com.techm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    // Method to configure DataSource
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/sys");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    // Method to configure JdbcTemplate
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    // Method to configure EmployeeManager
    @Bean
    public EmployeeManager employeeManager(JdbcTemplate jdbcTemplate) {
        return new EmployeeManager(jdbcTemplate);
    }
}
