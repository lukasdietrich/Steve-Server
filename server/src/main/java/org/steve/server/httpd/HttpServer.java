package org.steve.server.httpd;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class HttpServer {

	private Server http;
	
	public HttpServer(File base, int port, boolean list) throws Exception {
		this.http = new Server(port);
		this.http.setStopAtShutdown(true);
		
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		
		{
			context.setContextPath("/");
			context.addServlet(new ServletHolder(new StaticServlet(base)), "/*");
		}
		
		this.http.setHandler(context);
		this.http.start();
	}
	
	public void stop() throws Exception {
		this.http.stop();
	}
	
	private final class StaticServlet extends HttpServlet {
		private static final long serialVersionUID = -626814493967094412L;

		private File root;
		
		public StaticServlet(File rootDirectory) {
			this.root = rootDirectory.getAbsoluteFile();
		}

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession(true);
			boolean login = session.getAttribute("login") != null 
						 && !session.getAttribute("login").equals(Boolean.FALSE);
			
			String uri = req.getRequestURI().replace("/..", "");
			if(uri.endsWith("/"))
				uri = uri + "index.html";
			
			File resource = new File(root, uri);
			
			if(resource.exists()) {
				resp.setStatus(HttpServletResponse.SC_OK);
				resp.setContentType(MimeType.getInstance().getMimeForFile(resource.getName()));
				
				System.out.println("serving " + uri + " as " + resp.getContentType());
				
				InputStream in = new FileInputStream(resource);
				OutputStream out = resp.getOutputStream();
				byte[] buffer = new byte[512];
				int len;
				
				while((len = in.read(buffer)) > 0) {
					out.write(buffer, 0, len);
				}
				
				in.close();
				out.close();
			} else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		}
		
	}
	
}
