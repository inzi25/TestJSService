package org.sgit.manageguest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sgit.manageguest.model.Subtasks;
import org.sgit.manageguest.service.SubtasksService;

@Path("/subtask")
public class SubTaskResource {

	SubtasksService subtasksService = new SubtasksService();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insertSubTaskDetails(Subtasks subtasks) {

		return subtasksService.insertSubtask(subtasks);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateSubTaskDetails(Subtasks subtasks) {

		return subtasksService.updateSubtask(subtasks);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getSubTaskDetails() {

		return subtasksService.getSubTask();
	}

}
