package com.tech.compoennet;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelTimerWithOutBody extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("timer:first-timer").to("log:first-timer");
	}

}
