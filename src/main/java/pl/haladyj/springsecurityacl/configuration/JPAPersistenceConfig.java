package pl.haladyj.springsecurityacl.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.haladyj.springsecurityacl.dao")
@PropertySource("classpath:pl.haladyj.springsecurityacl.datasource.properties")
@EntityScan(basePackages={ "pl.haladyj.springsecurityacl.entity" })
public class JPAPersistenceConfig {
}
