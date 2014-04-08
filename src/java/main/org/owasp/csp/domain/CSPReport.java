package org.owasp.csp.domain;

import org.codehaus.jackson.annotate.JsonProperty;


public class CSPReport {
	
	@JsonProperty("csp-report")
	public Report report = new Report();
	
	public CSPReport() {
	}
	
	public CSPReport(Report report) {
		this.report = report;
	}
}
