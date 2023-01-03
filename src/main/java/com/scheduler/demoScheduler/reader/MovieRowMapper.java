package com.scheduler.demoScheduler.reader;

import com.scheduler.demoScheduler.entities.MovieRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MovieRowMapper implements org.springframework.jdbc.core.RowMapper<MovieRow> {
    @Autowired
    JdbcTempReader jdbcTempReader;

    public static final String USER_ID = "user_id";
    public static final String ITEM_ID = "item_id";
    public static final String RATING = "rating";
    public static final String TIMESTAMP = "timestamp";


    public MovieRow mapRow(ResultSet rs, int rowNum) throws SQLException {
        MovieRow movieRow = new MovieRow();

        movieRow.setUser_id(rs.getInt(USER_ID));
        movieRow.setItem_id(rs.getInt(ITEM_ID));
        movieRow.setRating(rs.getInt(RATING));
        movieRow.setTimestamp(rs.getInt(TIMESTAMP));

        return movieRow;
    }
}
