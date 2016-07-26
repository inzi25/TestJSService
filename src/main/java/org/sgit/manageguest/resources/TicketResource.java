package org.sgit.manageguest.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sgit.manageguest.model.Ticket;
import org.sgit.manageguest.service.TicketService;

@Path("/tickets")
public class TicketResource {

	TicketService ticketService = new TicketService();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insertTicketDetails(Ticket ticket) {

		return ticketService.insertTask(ticket);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateTicketDetails(Ticket ticket) {

		return ticketService.updateTicket(ticket);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ticket> getTicketDetails() {

		return ticketService.getTicketDetails();
	}

}
