package org.sgit.manageguest.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sgit.manageguest.model.Status;
import org.sgit.manageguest.service.StatusService;

@Path("/status")
public class StatusResource {

	StatusService statusService = new StatusService();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insertStatusDetails(Status status) {

		return statusService.insertStatus(status);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateCadenceDetails(Status status) {

		return statusService.updateStatus(status);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getStatusDetails() {

		return statusService.getStatus();
	}

}
