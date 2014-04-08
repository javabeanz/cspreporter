package org.owasp.csp.rest;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class MyApplicationBinder extends AbstractBinder {
	@Override
	protected void configure() {
		bind(CSPRestReporter.class).to(CSPApplication.class);
	}
}