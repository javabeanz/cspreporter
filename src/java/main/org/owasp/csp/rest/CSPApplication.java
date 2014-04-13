package org.owasp.csp.rest;

import static com.codahale.metrics.MetricRegistry.name;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;

import com.codahale.metrics.Counter;
import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;
import com.mongodb.DB;
import com.mongodb.Mongo;

import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.mongo.tests.MongodForTestsFactory;

@ApplicationPath("/resources")
public class CSPApplication extends Application {

	public static MetricRegistry metrics = new MetricRegistry();

	public JmxReporter reporter = JmxReporter.forRegistry(metrics).build();

	public static DB db;

	public static Counter counter = metrics.counter(name(CSPRestReporter.class,
			"processReport"));

	private static MongodForTestsFactory testsFactory;

	public CSPApplication() throws IOException {
		reporter.start();
		testsFactory = MongodForTestsFactory.with(Version.Main.PRODUCTION);
		final Mongo mongo = testsFactory.newMongo();
		db = testsFactory.newDB(mongo);
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> clazz = new HashSet<>();
		clazz.add(CSPRestReporter.class);
		clazz.add(JacksonFeature.class);
		return clazz;
	}

}
