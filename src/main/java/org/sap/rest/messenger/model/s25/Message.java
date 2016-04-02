package org.sap.rest.messenger.model.s25;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement //JaxB annotation
public class Message {

	private long id;
	private String message;
	private Date created;
	private String author;
	private Map<Long, Comment> comments = new HashMap<Long, Comment>();
	
	// Ensure that the model class have a no-argument constructor, for XML and JSON conversion
	public Message(){
		
	}
	
	public Message(long id, String message, String author) {
	
		this.id = id;
		this.message = message;
		this.created = new Date();
		this.author = author;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	// We don't want list of all the messages when we access a Comment.
	/*
	 * While converting from Class to JSON or XML, this property is ignored
	 */
	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}
	
	
}
