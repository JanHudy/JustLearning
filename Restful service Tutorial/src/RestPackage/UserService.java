package RestPackage;

import java.util.List; 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Path("/UserService")
public class UserService {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHelloPlain() {
		String resource = "Hello";
		return resource;
	}	
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayHello() {
		String resource ="<?xml version=\"1.0\"?>" +
		"<hello> Hello </hello>";
		
		return resource;
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHelloHTML() {
		String resource = "<html> " + "<title>" + "Hello" + "</title>"
		+ "<body><h1>" + "Hello" + "</body></h1>" + "</html> ";
		return resource;
	}
	 
	
	UserDao userDao = new UserDao();
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUsers(){
		return userDao.getAllUsers();
	}
	
}
