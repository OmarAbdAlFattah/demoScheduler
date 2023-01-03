package com.scheduler.demoScheduler.config;

import com.scheduler.demoScheduler.entities.MovieRow;
import com.scheduler.demoScheduler.reader.MovieRowMapper;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    @Autowired
    public JobBuilder jobBuilderFactory;

    @Autowired
    public StepBuilder stepBuilderFactory;

    @Autowired
    DataSource dataSource;

    @Bean
    public JdbcCursorItemReader<MovieRow> itemReader() {
        return new JdbcCursorItemReaderBuilder<MovieRow>()
                .dataSource(this.dataSource)
                .name("movieRow")
                .sql("SELECT * FROM dataset100k")
                .rowMapper(new MovieRowMapper())
                .build();

    }
}
