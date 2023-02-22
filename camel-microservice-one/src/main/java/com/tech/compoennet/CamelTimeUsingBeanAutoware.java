package com.tech.compoennet;

import java.util.Date;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.language.bean.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class CamelTimeUsingBeanAutoware extends RouteBuilder {

	@Autowired
	TimeBeanAutoware timeBeanAutoware;

	@Override
	public void configure() throws Exception {
		from("timer:first-timer").bean(timeBeanAutoware).to("log:first-timer");
	}

}

@Component
class TimeBeanAutoware {
	public String getBeanMessage() {
		return "This time message is :" + new Date();
	}
}