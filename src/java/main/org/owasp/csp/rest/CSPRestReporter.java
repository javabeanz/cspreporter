package org.owasp.csp.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.owasp.csp.domain.CSPReport;

import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;

@Path("/reporter")
public class CSPRestReporter {

	@Inject
	public MetricRegistry metrics;

	@Inject
	public Counter evictions;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CSPReport processReport(CSPReport report) {
		evictions.inc();
		System.out.println(this);
		return report;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHello() {
		return "CSP Reporter service alive";
	}

}
