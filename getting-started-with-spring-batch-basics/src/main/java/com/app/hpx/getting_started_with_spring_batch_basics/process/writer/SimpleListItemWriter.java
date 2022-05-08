package com.app.hpx.getting_started_with_spring_batch_basics.process.writer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class SimpleListItemWriter implements ItemWriter<String> {

	private static final Logger LOG = LoggerFactory.getLogger(SimpleListItemWriter.class);

	@Override
	public void write(List<? extends String> list) throws Exception {
		LOG.info("!! Writer Called !!");
		for (String s : list) {
			LOG.info("Writer wrote -> [{}]", s);
		}
	}
}