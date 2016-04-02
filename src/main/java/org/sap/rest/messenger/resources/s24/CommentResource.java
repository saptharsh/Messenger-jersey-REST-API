package org.sap.rest.messenger.resources.s24;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sap.rest.messenger.model.s25.Comment;
import org.sap.rest.messenger.service.s25.CommentService;

/*
 * http://localhost:8080/messenger/webapi/advmessages24/2/comments
 */
// This is Optional annotation, saying that its a Sub Resource
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

	private CommentService commentService = new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
		
		return commentService.getAllComments(messageId);
	}
	
	@POST
	public Comment addMessage(@PathParam("messageId") long messageId, Comment comment) {
		
		return commentService.addComment(messageId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateMessage(@PathParam("messageId") long messageId, 
								 @PathParam("commentId") long commentId, Comment comment) {
		
		comment.setId(commentId);
		return commentService.updateComment(messageId, comment);
	}
	
	@DELETE
	@Path("/commentId")
	public void deleteComment(@PathParam("messageId") long messageId, 
						 	  @PathParam("commentId") long commentId) {
		
		commentService.removeComment(messageId, commentId);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getMessage(@PathParam("messageId") long messageId, 
							  @PathParam("commentId") long commentId) {
		
		return commentService.getComment(messageId, commentId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Initial Resource Testing
	 */
	/*
	@GET
	public String test() {
		
		return "test";
	}
	
	@GET
	@Path("/{commentId}")
	public String test2(@PathParam("commentId") long comId, @PathParam("messageId") long msgId) {
		
		return "on comment ID, the ID is: "+ comId + ". For the message: "+ msgId;
	}
	*/
}
