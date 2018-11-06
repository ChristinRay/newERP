package com.moka;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;



@SpringBootApplication
@MapperScan("com.moka.dao")
public class NewErpApplication {
/*	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/newerp?useAffectedRows=true");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setValidationQuery("SELECT 1");
		dataSource.setTestWhileIdle(true);
		dataSource.setTimeBetweenEvictionRunsMillis(300000);
		dataSource.setNumTestsPerEvictionRun(50);
		dataSource.setMinEvictableIdleTimeMillis(3600000);
		return dataSource;
	}*/
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://47.101.60.119:3306/erp?useAffectedRows=true");
		dataSource.setUsername("root");
		dataSource.setPassword("Ch@123456");
		dataSource.setValidationQuery("SELECT 1");
		dataSource.setTestWhileIdle(true);
		dataSource.setTimeBetweenEvictionRunsMillis(300000);
		dataSource.setNumTestsPerEvictionRun(50);
		dataSource.setMinEvictableIdleTimeMillis(3600000);
		return dataSource;
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(getDataSource());
	}

	public static void main(String[] args) {
		SpringApplication.run(NewErpApplication.class, args);
	}
	
}
