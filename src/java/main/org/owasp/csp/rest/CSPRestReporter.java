package org.owasp.csp.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.mongojack.DBCursor;
import org.mongojack.JacksonDBCollection;
import org.owasp.csp.domain.CSPReport;

import com.mongodb.DBCollection;

@Path("/reporter")
public class CSPRestReporter {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CSPReport processReport(CSPReport report) {
		CSPApplication.counter.inc();
		DBCollection coll = CSPApplication.db.getCollection("testCollection");
		JacksonDBCollection<CSPReport, String> jsoncoll = JacksonDBCollection
				.wrap(coll, CSPReport.class, String.class);
		jsoncoll.insert(report);
		System.out.println("inserted report that violates : "
				+ report.report.violatedDirective);
		return report;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHello() {
		return "CSP Reporter service alive";
	}

	@GET
	@Path("/report")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CSPReport> report() {
		DBCollection coll = CSPApplication.db.getCollection("testCollection");
		JacksonDBCollection<CSPReport, String> jsoncoll = JacksonDBCollection
				.wrap(coll, CSPReport.class, String.class);
		DBCursor<CSPReport> cursor = jsoncoll.find();
		List<CSPReport> reports = new ArrayList<>();
		while (cursor.hasNext()) {
			CSPReport o = cursor.next();
			reports.add(o);
			// System.out.println(o);
		}
		return reports;
	}
}
