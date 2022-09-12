package com.api.bluehappyface.DataSourceConfig;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "artEntityManagerFactory", transactionManagerRef = "artTransactionManager", basePackages = {
		"com.api.bluehappyface.Repo.ArtRepo" })

public class ArtDataSourceConfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.art")
	public DataSourceProperties artDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	public DataSource artDataSource(@Qualifier("artDataSourceProperties") DataSourceProperties dataSourceProperties) {
		return dataSourceProperties.initializeDataSourceBuilder().build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean artEntityManagerFactory(
			@Qualifier("artDataSource") DataSource hubDataSource, EntityManagerFactoryBuilder builder) {
		return builder.dataSource(hubDataSource).packages("com.api.bluehappyface.Models.ArtEntity")
				.persistenceUnit("mysql")
				.build();
	}

	@Bean
	public PlatformTransactionManager artTransactionManager(
			@Qualifier("artEntityManagerFactory") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}
}
