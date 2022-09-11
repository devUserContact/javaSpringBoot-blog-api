package com.api.bluehappyface.DataSourceConfig;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "devEntityManagerFactory", transactionManagerRef = "devTransactionManager", basePackages = {
		"com.api.bluehappyface.Repo.DevEntity" })

public class DevDataSourceConfig {

	@Primary
	@Bean
	@ConfigurationProperties(prefix = "spring.dev-service.datasource")
	public DataSourceProperties devDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Primary
	@Bean
	public DataSource devDataSource(@Qualifier("devDataSourceProperties") DataSourceProperties dataSourceProperties) {
		return dataSourceProperties.initializeDataSourceBuilder().build();
	}

	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean devEntityManagerFactory(
			@Qualifier("devDataSource") DataSource hubDataSource, EntityManagerFactoryBuilder builder) {
		return builder.dataSource(hubDataSource).packages("com.api.bluehappyface.Models.DevEntity")
				.persistenceUnit("mysql")
				.build();
	}

	@Primary
	@Bean
	public PlatformTransactionManager devTransactionManager(@Qualifier("devEntityManager") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}
}
