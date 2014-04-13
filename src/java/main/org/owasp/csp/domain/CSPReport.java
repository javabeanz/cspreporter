package org.owasp.csp.domain;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class CSPReport implements Serializable {

	@JsonProperty("csp-report")
	public Report report = new Report();

	public CSPReport() {
	}

	public CSPReport(Report report) {
		this.report = report;
	}
}
