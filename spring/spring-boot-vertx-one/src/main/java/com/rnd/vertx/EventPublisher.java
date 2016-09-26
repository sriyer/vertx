package com.rnd.vertx;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.rnd.vertx.api.AbstractApi;

@Component
public class EventPublisher extends AbstractApi {

	public void start() throws Exception {
		vertx.setPeriodic(2000, handler -> {
			//log.info("sending a new event ..");
			vertx.eventBus().publish("ui-queue", "this is a new message @ " + new Date());
		});
	}

}
