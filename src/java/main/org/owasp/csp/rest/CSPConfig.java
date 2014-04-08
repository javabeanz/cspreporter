package org.owasp.csp.rest;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class CSPConfig extends ResourceConfig {
	    public CSPConfig() {
	    	packages("org.owasp.csp");
	    	register(CSPRestReporter.class);
	    	register(JacksonFeature.class);
	    	register(MyObjectMapperProvider.class);
	    }
	}