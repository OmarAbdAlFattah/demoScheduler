package com.scheduler.demoScheduler.reader;

import com.scheduler.demoScheduler.Application;
import com.scheduler.demoScheduler.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcTempReader {

    @Autowired
    DataSource dataSource;

    Logger logger = LoggerFactory.getLogger(JobHandler.class);

    private static String queryGetAllData = "SELECT * FROM dataset100k;";

    public List jdbcReader(String query, MovieRowMapper movieRowMapper){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List movieReviews = jdbcTemplate.query(queryGetAllData,
                new MovieRowMapper());
        logger.info(movieReviews.toString());
        return movieReviews;
    }

//    @Bean
//    public JdbcCursorItemReader<MovieRowMapper> itemReader() {
//        return new JdbcCursorItemReaderBuilder<CustomerCredit>()
//                .dataSource(this.dataSource)
//                .name("creditReader")
//                .sql("select ID, NAME, CREDIT from CUSTOMER")
//                .rowMapper(new CustomerCreditRowMapper())
//                .build();
//
//    }
}
