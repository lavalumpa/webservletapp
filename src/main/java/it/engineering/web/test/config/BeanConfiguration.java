package it.engineering.web.test.config;

import javax.persistence.EntityManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
}
