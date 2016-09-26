package com.rnd.vertx;

import org.springframework.stereotype.Component;

import com.rnd.vertx.api.AbstractApi;

import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

@Component
public class StaticVerticle extends AbstractApi {

    @Override
    public void start ( ) throws Exception {
	Router router = Router.router ( vertx );
	
	log.info ( "File cp class path resolveer {}", System.getProperty ( "vertx.disableFileCPResolving" ) );
	System.setProperty ( "vertx.disableFileCPResolving", "false" );
	StaticHandler handler = StaticHandler.create ( ).setWebRoot ( "webroot" );
	
	router.route ( ).handler ( handleIt -> {
	    log.info ( "got request .. sending to handler" );
	    handler.handle ( handleIt );
	}

	);

	vertx.createHttpServer ( ).requestHandler ( router::accept )
	        .listen ( 9090 );

    }

}
