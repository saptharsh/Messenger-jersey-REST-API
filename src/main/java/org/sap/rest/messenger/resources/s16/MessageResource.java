package org.sap.rest.messenger.resources.s16;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.sap.rest.messenger.model.s14.Message;
import org.sap.rest.messenger.service.s16.MessageService;

@Path("/advmessages")
/*
 * Instead of having @Consumes and @Produces on every message, we can annotate it for the whole class
 */
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService = new MessageService();
	
	/*
	 * We add @QueryParam to get the URL Queries.
	 * http://localhost:8080/messenger/webapi/advmessages?year=2015
	 * http://localhost:8080/messenger/webapi/advmessages?start=0&size=2
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@QueryParam("year") int year,
									 @QueryParam("start") int start,
									 @QueryParam("size") int size) {
		
		if(year > 0) {
			
			return messageService.getAllMessagesForYear(year);
		}
		
		if (start >= 0 && size > 0) {
			
			return messageService.getAllMessagesPaginated(start, size);
		}
		
		return messageService.getAllMessages();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message msg) {
		
		return messageService.addMessage(msg);
	}
	
	
	@PUT
	@Path("/{msgId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("msgId") long id, Message msg) {
		
		msg.setId(id);
		return messageService.updateMessage(msg);
	}
	
	
	@DELETE
	@Path("/{delmsgId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("delmsgId") long id) {
		
		messageService.removeMessage(id);
	}
	
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long id){
		
		return messageService.getMessage(id);
	}
	
}
