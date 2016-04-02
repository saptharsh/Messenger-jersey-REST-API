package org.sap.rest.messenger.resources.s13;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sap.rest.messenger.model.s14.Message;
import org.sap.rest.messenger.service.s14.MessageService;

@Path("messages")
public class MessageResource {

	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	//JaxB does the string to XMl conversion, annotate Message class with JaxB annotations
	public List<Message> getMessages(){
		//return "Hello Boss!!";
		
		return messageService.getAllMessages();
	}
	
}
