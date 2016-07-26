package org.sgit.manageguest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sgit.manageguest.model.SchedulingTasks;
import org.sgit.manageguest.service.SchedulingTasksService;

@Path("/schedulingTasks")
public class SchedulingTaskResource {

	SchedulingTasksService SchedulingTasksService = new SchedulingTasksService();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insertCadenceDetails(SchedulingTasks schedulingTask) {

		return SchedulingTasksService.insertSchedulingTasks(schedulingTask);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateCadenceDetails(SchedulingTasks schedulingTask) {

		return SchedulingTasksService.updateSchedulingTasks(schedulingTask);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getCadenceDetails() {

		return SchedulingTasksService.getSchedulingTasks();
	}

}
