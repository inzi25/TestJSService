package org.sgit.manageguest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sgit.manageguest.model.Hotel;
import org.sgit.manageguest.service.HotelService;

@Path("/hotels")
public class HotelResource {

	HotelService hotelservice = new HotelService();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insertHotelDetails(Hotel hotel) {

		return hotelservice.insertHotel(hotel);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateHotelDetails(Hotel hotel) {

		return hotelservice.updateHotel(hotel);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getHotelDetails() {

		return hotelservice.getHotels();
	}

}
