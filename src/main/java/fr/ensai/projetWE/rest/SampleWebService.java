package fr.ensai.projetWE.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.ensai.projetWE.business.User;
import fr.ensai.projetWE.dao.UserDao;

@Path("/hello")
public class SampleWebService {
	UserDao userdao;
	
	public SampleWebService() {
		userdao = new UserDao();
	
		
	}
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello, how are you?";
	}

	@GET
	@Path("/users/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return userdao.getAll();
	
	}

	
	@GET
	@Path("/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam("id") String id1) {
		
		return userdao.findById(Long.parseLong(id1));
	
	}
	
	@POST
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User getUserById(User u) {
		
		return userdao.save(u);
	
	}


}
