package com.haoyin.image.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;



@Configuration
public class TransactionConfig {
	@Autowired
	private DataSource dataSource; 
	
	@Bean
	public TransactionTemplate transactionTemplate(PlatformTransactionManager platformTransactionManager){
		 TransactionTemplate        template= new TransactionTemplate();
		 template.setTransactionManager(platformTransactionManager);
		return template;
	}
	@Bean
	public PlatformTransactionManager platformTransactionManager(){
		return new DataSourceTransactionManager(dataSource);
	}
	
}
