package org.sap.rest.messenger.resources.s24;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sap.rest.messenger.model.s14.Message;
import org.sap.rest.messenger.resources.beans.s24.MessageFilterBean;
import org.sap.rest.messenger.service.s16.MessageService;

@Path("/advmessages24")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
		
		if(filterBean.getYear() > 0) {
			
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		
		if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		
		return messageService.getAllMessages();
	}
	
	
	@POST
	public Message addMessage(Message msg) {
		
		return messageService.addMessage(msg);
	}
	
	
	@PUT
	@Path("/{msgId}")
	public Message updateMessage(@PathParam("msgId") long id, Message msg) {
		
		msg.setId(id);
		return messageService.updateMessage(msg);
	}
	
	
	@DELETE
	@Path("/{delmsgId}")
	public void deleteMessage(@PathParam("delmsgId") long id) {
		
		messageService.removeMessage(id);
	}
	
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id){
		
		return messageService.getMessage(id);
	}
	
	
	@Path("/{messageId}/comments")
	public CommentResource getComments() {
		
		return new CommentResource();
	}
	
	
	
}


