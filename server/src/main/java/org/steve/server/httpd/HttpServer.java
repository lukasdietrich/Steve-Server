package org.steve.server.httpd;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.Resource;

public class HttpServer {

	private Server http;
	
	public HttpServer(File base, int port, boolean list) throws Exception {
		this.http = new Server(port);
		this.http.setStopAtShutdown(true);
		
		final HandlerCollection handler = new HandlerCollection();
		
		handler.addHandler(new WrappedHandler("/~", new DefaultHandler() {

			@Override
			public void handle(String arg0, Request arg1, HttpServletRequest arg2, HttpServletResponse arg3) throws IOException, ServletException {
				if(arg0.equals("/auth")) {
					arg3.setStatus(200);
					arg3.setContentType("text");
					arg3.getWriter().print("Hi");
					arg3.getWriter().close();
				}
			}
			
		}));
		
		handler.addHandler(new HttpHandler("/", base, list));
		
		this.http.setHandler(handler);
		this.http.start();
	}
	
	public void stop() throws Exception {
		this.http.stop();
	}
	
	private final class HttpHandler extends WrappedHandler {
		
		public HttpHandler(String context, File rootDirectory, boolean listDirectories) {
			super(context);
			
			ResourceHandler handler = new ResourceHandler();
			handler.setDirectoriesListed(listDirectories);
			handler.setBaseResource(Resource.newResource(rootDirectory));
			handler.setCacheControl("max-age=0,public");
			
			super.setHandler(handler);
		}
		
	}
	
	private class WrappedHandler extends ContextHandler {
		
		protected WrappedHandler(String context, Handler h) {
			this(context);
			this.setHandler(h);
		}
		
		protected WrappedHandler(String context) {
			super(context);
		}
		
	}
	
}
