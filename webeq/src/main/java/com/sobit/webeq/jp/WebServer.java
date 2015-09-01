package com.sobit.webeq.jp;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.NCSARequestLog;
import org.eclipse.jetty.server.RequestLog;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.RequestLogHandler;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.webapp.WebAppContext;

public class WebServer {

	private static final String LOG_PATH = "logs/access/yyyy_mm_dd.request.log";
    private static final String PATH_TO_WEBAPP = "webapp";
	
    private Server server;
    private final int port;
	private WebAppContext webappContext;
	
    
    public WebServer(int aPort)
    {
		port = aPort;
    }
    
    public void start() throws Exception
    {
        server = new Server(port);

        server.setHandler(createHandlers());        
        server.setStopAtShutdown(true);
        
		System.setProperty("org.apache.jasper.compiler.disablejsr199", "true");
		
		File jstlTaglibsFile = new File("lib/jstl-1.2.jar");
		File springFormTaglibsFile = new File("lib/spring-webmvc-4.0.6.RELEASE.jar");
		
		List<URL> urlTaglibList = new ArrayList<URL>();
		if(jstlTaglibsFile.exists())
			urlTaglibList.add(jstlTaglibsFile.toURI().toURL());
		if(springFormTaglibsFile.exists())
			urlTaglibList.add(springFormTaglibsFile.toURI().toURL());
		
		//костыль для запуска проекта из под IDE и как жарник
		if(!urlTaglibList.isEmpty())
		{
			ClassLoader currentClassLoader = Thread.currentThread().getContextClassLoader();
			URLClassLoader newClassLoader = new URLClassLoader(urlTaglibList.toArray(new URL[0]), currentClassLoader);
			Thread.currentThread().setContextClassLoader(newClassLoader);
		}
		
		Logger LOG = Log.getLogger(getClass());
		System.out.println("Logger class: " + LOG.getClass());
		
        server.start();
    }
    
    public void join() throws InterruptedException
    {
        server.join();
    }
    
    public void stop() throws Exception
    {        
        server.stop();
    }
    
    private HandlerCollection createHandlers()
    {                
		webappContext = new WebAppContext();
        webappContext.setContextPath("/");
        webappContext.setWar(PATH_TO_WEBAPP);
        
        RequestLogHandler logHandler = new RequestLogHandler();
        logHandler.setRequestLog(createRequestLog());
        
        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[] {logHandler, webappContext});
        
        return handlers;
    }
    
    private RequestLog createRequestLog()
    {
        NCSARequestLog log = new NCSARequestLog();
        
    	File logPath = new File(LOG_PATH);
        logPath.getParentFile().mkdirs();
                
        log.setFilename(logPath.getPath());
        log.setRetainDays(10);
        log.setExtended(false);
        log.setAppend(true);
        log.setLogTimeZone("GMT");
        log.setLogLatency(true);
        return log;
    }
}
