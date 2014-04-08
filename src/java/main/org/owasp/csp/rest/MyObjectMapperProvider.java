package org.owasp.csp.rest;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

@Provider
public class MyObjectMapperProvider implements ContextResolver<ObjectMapper> {
 
    final ObjectMapper defaultObjectMapper;
 
    public MyObjectMapperProvider() {
        defaultObjectMapper = createDefaultMapper();
    }
 
    @Override
    public ObjectMapper getContext(Class<?> type) {
            return defaultObjectMapper;
    }
 
    private static ObjectMapper createDefaultMapper() {
        final ObjectMapper result = new ObjectMapper();
        result.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
        return result;
    }
 
}