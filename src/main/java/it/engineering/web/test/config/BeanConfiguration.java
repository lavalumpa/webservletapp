package it.engineering.web.test.config;

import javax.persistence.EntityManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import it.engineering.web.test.persistance.MyEntityManagerFactory;

@ComponentScan(basePackages = {
		"it.engineering.web.test"
})
@Configuration
public class BeanConfiguration {

	@Bean
	public EntityManager entityManager() {
		return MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
	}
	
	@Bean
	public JdbcTemplate JdbcTemplate() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/eng_2022_g1_test_v2");
		dataSource.setUsername("root");
		dataSource.setPassword("1@mgr00t");
		return new JdbcTemplate(dataSource);
	}
}
