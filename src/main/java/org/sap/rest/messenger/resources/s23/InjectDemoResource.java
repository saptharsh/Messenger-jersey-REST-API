package org.sap.rest.messenger.resources.s23;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

// End Point
@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
											@HeaderParam("headerName") String header,
											@CookieParam("name") String cookie) {
		
		return "Matric Param's value: "+ matrixParam + 
			   ". Header param's value: " + header +
			   ". Cookie: "+ cookie;
	}
	
	/*
	 * Video 24
	 */
	@GET
	@Path("contextDemo")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		
		// UriInfo is a Special Class which gives us lot of options. From JAX-RS
		/*
		 * getAbsolutePath() => returns URI type, hence convert to String
		 */
		String path = uriInfo.getAbsolutePath().toString();
		
		// HttpHeaders is another Special Class from JAX-RS
		/*
		 * getCookies() => returns Map type, hence convert to String
		 */
		String cookie = headers.getCookies().toString();
		
		/*
		 * Both 
		 */
		return "Path: "+path + ", Cookie: "+ cookie;
		
	}
	
	
	
}




