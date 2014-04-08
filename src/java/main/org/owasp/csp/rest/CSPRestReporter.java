package org.owasp.csp.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.owasp.csp.domain.CSPReport;
import org.owasp.csp.domain.Report;

@Path("/reporter")
public class CSPRestReporter {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CSPReport sayPlainTextHello(CSPReport report) {
		  return report;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public CSPReport sayPlainTextHelloget() {
	  Report report = new Report();
	  report.blockedUri = "http://blocked";
		//return "{\"result\": \"Hello world\"}";
		return new CSPReport(report);
	}

}
