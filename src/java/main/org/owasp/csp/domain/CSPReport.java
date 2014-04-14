package org.owasp.csp.domain;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.mongojack.ObjectId;

public class CSPReport implements Serializable {

	@ObjectId
	public String _id;

	@JsonProperty("csp-report")
	public Report report = new Report();

	public CSPReport() {
	}

	public CSPReport(Report report) {
		this.report = report;
	}
}
