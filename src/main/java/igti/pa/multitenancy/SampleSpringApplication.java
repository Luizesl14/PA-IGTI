
package igti.pa.multitenancy;

import com.zaxxer.hikari.HikariDataSource;
import igti.pa.multitenancy.application.tenantconfig.routing.TenantAwareRoutingSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableTransactionManagement
public class SampleSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringApplication.class, args);
	}

	@Bean
	public DataSource dataSource() {

		AbstractRoutingDataSource dataSource = new TenantAwareRoutingSource();

		Map<Object,Object> targetDataSources = new HashMap<>();

		targetDataSources.put("Kalea", tenantOne());
		targetDataSources.put("Trinus", tenantTwo());
		targetDataSources.put("Crediblue", tenantTree());

		dataSource.setTargetDataSources(targetDataSources);

		dataSource.afterPropertiesSet();

		return dataSource;
	}

	public DataSource tenantOne() {

		HikariDataSource dataSource = new HikariDataSource();

		dataSource.setInitializationFailTimeout(0);
		dataSource.setMaximumPoolSize(5);
		dataSource.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
		dataSource.addDataSourceProperty("url", "jdbc:postgresql://localhost:5434/postgres");
		dataSource.addDataSourceProperty("user", "postgres");
		dataSource.addDataSourceProperty("password", "321");

		return dataSource;
	}

	public DataSource tenantTwo() {

		HikariDataSource dataSource = new HikariDataSource();

		dataSource.setInitializationFailTimeout(0);
		dataSource.setMaximumPoolSize(5);
		dataSource.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
		dataSource.addDataSourceProperty("url", "jdbc:postgresql://localhost:5431/postgres");
		dataSource.addDataSourceProperty("user", "postgres");
		dataSource.addDataSourceProperty("password", "123");

		return dataSource;
	}

	public DataSource tenantTree() {

		HikariDataSource dataSource = new HikariDataSource();

		dataSource.setInitializationFailTimeout(0);
		dataSource.setMaximumPoolSize(5);
		dataSource.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
		dataSource.addDataSourceProperty("url", "jdbc:postgresql://localhost:5431/postgres");
		dataSource.addDataSourceProperty("user", "postgres");
		dataSource.addDataSourceProperty("password", "postgres");

		return dataSource;
	}
}