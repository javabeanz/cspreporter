package org.owasp.csp.rest;

import static com.codahale.metrics.MetricRegistry.name;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Named;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;

import com.codahale.metrics.Counter;
import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;

@ApplicationPath("/resources")
public class CSPApplication extends Application {

	@Named("metrics")
	public MetricRegistry metrics = new MetricRegistry();

	public JmxReporter reporter = JmxReporter.forRegistry(metrics).build();

	@Named("evictions")
	public Counter evictions = metrics.counter(name(CSPRestReporter.class,
			"processReport"));

	public CSPApplication() {
		reporter.start();
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> clazz = new HashSet<>();
		clazz.add(CSPRestReporter.class);
		clazz.add(JacksonFeature.class);
		return clazz;
	}

}
