package org.koushik.javabrains.messenger.resources;

//import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Logger;
//import java.util.logging.SimpleFormatter;
//import java.util.logging.FileHandler;
//import java.util.logging.Level;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.messenger.model.Message;
import org.koushik.javabrains.messenger.service.MessageArgument;
import org.koushik.javabrains.messenger.service.MessageService;

//import com.mkyong.ws.HelloWorld;
//import com.mkyong.ws.HelloWorldImplService;	


@Path("/messages")
public class MessageResource {
	String test = "";
	MessageArgument messageArgument = new MessageArgument();
	/*Logger logger = Logger.getLogger("MyLog");
	fh = new FileHandler("C:/MyLogFile.log");  
    logger.addHandler(fh);
    SimpleFormatter formatter = new SimpleFormatter();  
    fh.setFormatter(formatter);  */
	//final static Logger logger = Logger.getLogger(classname.class);

	MessageService messageService = new MessageService();
//	@Path("/post")
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getArg(Message argument){
		//HERE WE RETURN THE MESSEGES
//		messageService.getAllMessages(argument);
		System.out.println(argument.getMessage());
//		System.out.println(headparam.getHeaderString("headparam1"));
//		logger.debug(argument.getMessage());
		return messageService.getAllMessages(argument.getMessage());
	}
	// For  POST
	/*public MessageArgument setArg(String test){
		return messageArgument.setArg(test	);
	}*/
//	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		return messageService.getAllMessages("");
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/query")
	public List<Message> getUsers(@Context UriInfo info) {
		//Message argument = null;
		String from = info.getQueryParameters().getFirst("name");
		System.out.println(from + " <-From");
		//argument.setMessage(from);
		System.out.println("messageService.getAllMessages(from): " + messageService.getAllMessages(from).get(0));
		return messageService.getAllMessages(from);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{urlParam}")
	public List<Message> getUrl(@PathParam("urlParam")String urlPar){
		
		return messageService.getAllMessages(urlPar);
	}
}
