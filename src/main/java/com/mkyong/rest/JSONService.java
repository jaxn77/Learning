package com.mkyong.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mkyong.Products;
import com.mkyong.Track;

@Path("/json/metallica")
public class JSONService {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getTrackInJSON() {

		Track track = new Track();
		List <Products> products = new ArrayList<Products>();
		products.add(new Products("1","Mobile lumia 720","14000","4"));
		products.add(new Products("2","Xperia U","17000","3"));
		products.add(new Products("3","One plus one","20000","4.5"));
		
		track.setGross("Net + TAX");
		track.setOrderno("21");
		track.setProducts(products);

		return track;

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Track track) {

		String result = "Track saved : "+track;
		return Response.status(201).entity(result).build();
		
	}
	
}