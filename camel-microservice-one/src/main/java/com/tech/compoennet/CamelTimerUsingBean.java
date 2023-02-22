package com.tech.compoennet;

import java.util.Date;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelTimerUsingBean extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("timer:first-timer").bean("timeBean").to("log:first-timer");
	}

}

@Component
class TimeBean {
	public String getBeanMessage() {
		return "This time message is :" + new Date();
	}
}
