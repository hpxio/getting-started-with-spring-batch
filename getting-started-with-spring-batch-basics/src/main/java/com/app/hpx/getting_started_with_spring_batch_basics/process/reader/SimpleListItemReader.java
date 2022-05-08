package com.app.hpx.getting_started_with_spring_batch_basics.process.reader;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class SimpleListItemReader implements ItemReader<String> {

	private static final Logger LOG = LoggerFactory.getLogger(SimpleListItemReader.class);

	private int counter;
	private final int max;

	private final List<String> nameList;

	public SimpleListItemReader() {
		this.nameList = initializeDate();

		counter = 0;
		max = nameList.size() - 1;
	}

	private List<String> initializeDate() {
		List<String> randomNameList = new ArrayList<>();

		randomNameList.add("John");
		randomNameList.add("Ramon");
		randomNameList.add("Damian");
		randomNameList.add("Salah");
		randomNameList.add("Kevin");
		randomNameList.add("Dale");
		randomNameList.add("Nigel");

		return randomNameList;
	}

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		LOG.info("!! Reader Called !!");
		if (counter > max) {
			return null;
		} else {
			String itemRead = nameList.get(counter++);
			LOG.info(" Item read -> [{}]", itemRead);
			return itemRead;
		}
	}
}
