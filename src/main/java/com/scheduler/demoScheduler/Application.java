package com.scheduler.demoScheduler;

import com.scheduler.demoScheduler.reader.JdbcTempReader;
import com.scheduler.demoScheduler.reader.MovieRowMapper;
import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

@SpringBootApplication
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "30s")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		JdbcTempReader jdbcTempReader = new JdbcTempReader();
		MovieRowMapper movieRowMapper = new MovieRowMapper();
		jdbcTempReader.jdbcReader("SELECT * FROM dataset100k;", movieRowMapper);
	}



}