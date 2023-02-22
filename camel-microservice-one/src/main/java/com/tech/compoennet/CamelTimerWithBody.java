package com.tech.compoennet;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelTimerWithBody extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("timer:first-timer")
		.transform().constant("From first timer with body")
		.to("log:first-timer");		
	}
	
}
