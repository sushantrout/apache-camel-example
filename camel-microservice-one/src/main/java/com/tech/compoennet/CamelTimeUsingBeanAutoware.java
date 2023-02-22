package com.tech.compoennet;

import java.util.Date;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

public class CamelTimeUsingBeanAutoware extends RouteBuilder {

	@Autowired
	TimeBeanAutoware timeBeanAutoware;
	
	@Autowired
	private CommonLoggingService commonLoggingService;

	@Override
	public void configure() throws Exception {
		from("timer:first-timer")
			.bean(timeBeanAutoware)
			.log("${body}")
			.to("log:first-timer")
			.bean(commonLoggingService)
			.log("${body}");
	}

}

@Component
class TimeBeanAutoware {
	public String getBeanMessage() {
		return "This time message is (Autowired):" + new Date();
	}
}

@Component
@Slf4j
class CommonLoggingService {
	public void process(String message) {
		log.error("This message from logger (Autowired):", message);
	}
}