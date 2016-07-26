package org.sgit.manageguest.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sgit.manageguest.model.UserLogin;
import org.sgit.manageguest.model.User;
import org.sgit.manageguest.service.UserService;

@Path("/users")
public class UserResource {

	UserService userService = new UserService();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insertUserDetails(User user) {

		return userService.insertUser(user);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateUserDetails(User user) {

		return userService.updateUser(user);
	}

	@Path("/changepassword")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updatePassword(UserLogin userLogin) {

		return userService.changePassword(userLogin);
	}

	@Path("/login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String checkLogin(UserLogin userLogin) {

		return userService.login(userLogin);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserDetails() {

		return userService.getUser();
	}

}
