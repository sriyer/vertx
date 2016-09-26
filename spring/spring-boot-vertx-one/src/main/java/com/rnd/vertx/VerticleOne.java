package com.rnd.vertx;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.rnd.vertx.api.AbstractApi;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;

@Component
public class VerticleOne extends AbstractApi {

	@Override
	public void start() throws Exception {

		Router router = Router.router(vertx);

		router.get("/hello").handler(request -> {
			request.response().end("HelloWorld @" + new Date());
		});

		vertx.createHttpServer().requestHandler(router::accept).listen(8080);

	}
}
