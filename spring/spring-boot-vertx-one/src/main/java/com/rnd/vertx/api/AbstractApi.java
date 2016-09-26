package com.rnd.vertx.api;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rnd.vertx.Application;

import io.vertx.core.AbstractVerticle;


public abstract class AbstractApi extends AbstractVerticle {
	
	public Logger log = LoggerFactory.getLogger( this.getClass() );
	
	@Resource
	Application application;
	
	@PostConstruct
	public void doPostConstruct ( ) {
		application.deployVerticle ( this );
	}
	
	

}
