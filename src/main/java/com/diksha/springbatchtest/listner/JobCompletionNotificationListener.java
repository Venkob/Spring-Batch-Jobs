package com.diksha.springbatchtest.listner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.diksha.springbatchtest.data.Person;

@Component
@Slf4j
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private final JdbcTemplate jdbcTemplate;

	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB FINISHED! Time to verify the results");

			List<Person> results = jdbcTemplate.query("SELECT first_name, last_name FROM people",
					new RowMapper<Person>() {
						@Override
						public Person mapRow(ResultSet rs, int row) throws SQLException {
							return new Person(rs.getString(1), rs.getString(2));
						}
					});

			for (Person person : results) {
				log.info("Found <" + person + "> in the database.");
			}

		}
	}
}
