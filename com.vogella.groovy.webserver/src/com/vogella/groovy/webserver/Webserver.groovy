package com.vogella.groovy.webserver
import groovy.servlet.*

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.*

@Grab('org.eclipse.jetty.aggregate:jetty-server:8.1.9.v20130131')
@Grab('org.eclipse.jetty.aggregate:jetty-servlet:8.1.9.v20130131')
@Grab('javax.servlet:javax.servlet-api:3.0.1')
import static org.eclipse.jetty.servlet.ServletContextHandler.*

class Webserver {

	static main(args) {

		def server = new Server(1234)
		def context = new ServletContextHandler(server, "/", SESSIONS)
		context.resourceBase = "."
		context.addServlet(GroovyServlet, "*.groovy")
		server.start()
	}
}
