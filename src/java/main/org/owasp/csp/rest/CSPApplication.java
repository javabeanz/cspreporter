package org.owasp.csp.rest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;

@ApplicationPath("/resources")
public class CSPApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> clazz = new HashSet<>();
		clazz.add(CSPRestReporter.class);
		clazz.add(JacksonFeature.class);
		return clazz;
	}

	@Override
	public Map<String, Object> getProperties() {
		Map<String, Object> map = new HashMap<>();
		map.put("com.sun.jersey.api.json.POJOMappingFeature<", "true");
		return map;
	}

}
