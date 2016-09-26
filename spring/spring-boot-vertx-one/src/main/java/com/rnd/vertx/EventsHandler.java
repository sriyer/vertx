package com.rnd.vertx;

import org.springframework.stereotype.Component;

import com.rnd.vertx.api.AbstractApi;

import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.sockjs.BridgeOptions;
import io.vertx.ext.web.handler.sockjs.PermittedOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;

@Component
public class EventsHandler extends AbstractApi {

    @Override
    public void start ( ) throws Exception {

	Router r = Router.router ( vertx );
	BridgeOptions options = new BridgeOptions ( );
	options.addInboundPermitted (
	        new PermittedOptions ( ).setAddress ( "ui-queue" ) )
	        .addOutboundPermitted (
	                new PermittedOptions ( ).setAddress ( "ui-queue" ) );
	SockJSHandler handler = SockJSHandler.create ( vertx );
	handler.bridge ( options );

	r.route ( "/events/*" ).handler ( handler );

	vertx.createHttpServer ( ).requestHandler ( r::accept ).listen ( 7070 );

    }

}
