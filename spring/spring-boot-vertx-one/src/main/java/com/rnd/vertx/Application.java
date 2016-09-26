package com.rnd.vertx;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


import org.springframework.stereotype.Component;

import com.rnd.vertx.api.AbstractApi;

@Component
public class Application {
	
	@Resource
	VerticleOne verticleOne;
	
	private Vertx vertx;
	
	private Router router;

	
	@PostConstruct
	public void application () {
		System.out.println("Starting application...");
		vertx = getVertx ();
		vertx.deployVerticle(verticleOne);
	}


	private Vertx getVertx() {
		if ( vertx == null ) {
			vertx = Vertx.vertx();
		}
		return vertx;
	}
	
	public void deployVerticle ( AbstractApi verticle ) {
		System.out.println("Deploying verticle: " + verticle.getClass().getCanonicalName());
		getVertx().deployVerticle(verticle);
	}
}
