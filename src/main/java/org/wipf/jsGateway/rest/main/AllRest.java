package org.wipf.jsGateway.rest.main;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.wipf.jsGateway.logic.base.Gateway;
import org.wipf.jsGateway.logic.base.MainHome;

/**
 * @author wipf
 *
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class AllRest {

	@Inject
	Gateway gateway;

	@GET
	@Path("{path:.*}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getFallback(@PathParam("path") String sPath) throws IOException {

		return gateway.doPath(sPath);

		// return Response.ok("All " + sPath).build();
	}

	@GET
	@Path("up")
	@Produces(MediaType.TEXT_PLAIN)
	public Response up() {
		return Response.ok(1).build();
	}

	@GET
	@Path("ver")
	public Response getver() {
		return Response.ok("{\"ver\":\"" + MainHome.VERSION + "\"}").build();
	}

	@POST
	@Path("stop")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response stopAll() {
		MainHome.stopApp();
		return Response.ok().build();
	}

	@DELETE
	@Path("garbage")
	public void gc() {
		System.gc();
	}
}
