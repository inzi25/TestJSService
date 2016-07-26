package org.sgit.manageguest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sgit.manageguest.model.Guest;
import org.sgit.manageguest.service.GuestService;

@Path("/service")
public class ServiceResource {

	GuestService guestService = new GuestService();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insertTaskDetails(Guest guest) {

		return guestService.insertGuestService(guest);
	}

	// @PUT
	// @Consumes(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.APPLICATION_JSON)
	// public String updateTaskDetails(Tasks tasks) {
	//
	// return guestService.updateTask(tasks);
	// }
	//
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getTaskDetails() {

		return guestService.getService();
	}

}
