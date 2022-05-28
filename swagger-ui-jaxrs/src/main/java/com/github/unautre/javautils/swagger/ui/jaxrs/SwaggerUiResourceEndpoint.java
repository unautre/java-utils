package com.github.unautre.javautils.swagger.ui.jaxrs;

import java.io.InputStream;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/swagger-ui")
public class SwaggerUiResourceEndpoint {
	
	private static final String INTERNAL_PATH = "/META-INF/resources/webjars/swagger-ui/4.11.1";

	@Path("{path: .*}")
	public Response getFile(@PathParam("path") String path) {
		final InputStream stream = SwaggerUiResourceEndpoint.class.getResourceAsStream(INTERNAL_PATH + path);
		
		return stream != null ?
				Response.ok(stream).build() :
				Response.status(Status.NOT_FOUND).build();
	}
}