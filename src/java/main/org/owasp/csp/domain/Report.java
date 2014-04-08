package org.owasp.csp.domain;

import org.codehaus.jackson.annotate.JsonProperty;


public class Report {

	@JsonProperty("document-uri")
	public String documentUri; 	
	
	public String referrer;
	
	@JsonProperty("blocked-uri")
	public String blockedUri;

	@JsonProperty("violated-directive")
	public String violatedDirective;
	
	@JsonProperty("original-policy")
	public String originalPolicy;
	
}
