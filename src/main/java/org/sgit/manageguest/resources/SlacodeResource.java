package org.sgit.manageguest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sgit.manageguest.model.Slacode;
import org.sgit.manageguest.service.SlacodeService;

@Path("/slacode")
public class SlacodeResource {

	SlacodeService slacodeService = new SlacodeService();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insertSlacodeDetails(Slacode slacode) {

		return slacodeService.insertSlacode(slacode);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateSlacodeDetails(Slacode slacode) {

		return slacodeService.updateSlacode(slacode);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getSlacodeDetails() {

		return slacodeService.getSlacode();
	}

}
