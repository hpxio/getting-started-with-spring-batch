package com.app.hpx.getting_started_with_spring_batch_basics.process.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class SimpleListItemProcessor implements ItemProcessor<String, String> {

	private static final Logger LOG = LoggerFactory.getLogger(SimpleListItemProcessor.class);


	@Override
	public String process(String s) throws Exception {
		LOG.info("!! Processor Called !!");
		String itemProcessed = s.toUpperCase();

		LOG.info("Processor processed - [{}]", itemProcessed);
		return itemProcessed;
	}
}
