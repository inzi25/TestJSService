package org.sgit.manageguest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sgit.manageguest.model.Department;
import org.sgit.manageguest.service.DepartmentService;

@Path("/departments")
public class DepartmentResource {

	DepartmentService departmentService = new DepartmentService();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insertDepartmentsDetails(Department department) {

		return departmentService.insertDepartment(department);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateDepartmentDetails(Department department) {

		return departmentService.updateDepartment(department);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getDepartmentDetails() {

		return departmentService.getDepartment();
	}

}
