package com.app.hpx.getting_started_with_spring_batch_basics.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.hpx.getting_started_with_spring_batch_basics.process.processor.SimpleListItemProcessor;
import com.app.hpx.getting_started_with_spring_batch_basics.process.reader.SimpleListItemReader;
import com.app.hpx.getting_started_with_spring_batch_basics.process.writer.SimpleListItemWriter;

@Configuration
public class SpringBatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private SimpleListItemWriter itemWriter;

	@Autowired
	private SimpleListItemReader itemReader;

	@Autowired
	private SimpleListItemProcessor itemProcessor;

	@Bean
	public Step firstStep() {
		return stepBuilderFactory.get("firstStep")
				.<String, String>chunk(2)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.faultTolerant()
				.build();
	}

	@Bean
	public Job firstJob() {
		return jobBuilderFactory.get("firstJob")
				.start(firstStep())
				.build();
	}
}