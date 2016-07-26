package org.sgit.manageguest.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sgit.manageguest.model.Tasks;
import org.sgit.manageguest.service.TasksService;

@Path("/task")
public class TaskResource {

	TasksService tasksService = new TasksService();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insertTaskDetails(Tasks tasks) {

		return tasksService.insertTask(tasks);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateTaskDetails(Tasks tasks) {

		return tasksService.updateTask(tasks);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getTaskDetails() {

		return tasksService.getTask();
	}

}
