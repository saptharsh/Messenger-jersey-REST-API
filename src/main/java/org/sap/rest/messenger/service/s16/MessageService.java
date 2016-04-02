package org.sap.rest.messenger.service.s16;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.sap.rest.messenger.database.s16.DatabaseClass;
import org.sap.rest.messenger.model.s14.Message;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	// Constructor
	public MessageService() {
		
		// Adding to the Maps in Database Class
		messages.put(1L, new Message(1, "First Message", "Sappy"));
		messages.put(2L, new Message(2, "Second Message", "hegde"));
		messages.put(3L, new Message(3, "Third Message", "sap hegde"));
	}
	
	public List<Message> getAllMessages() {
		
		return new ArrayList<Message>(messages.values());
	}
	
	/*
	 * Video 22
	 */
	public List<Message> getAllMessagesForYear(int year) {
		
		// Interface					 // Instantiating a Class
		List<Message> messagesFromYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		
		for (Message message : messages.values()) {
			
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesFromYear.add(message);
			}
		}
		
		return messagesFromYear;
	}
	
	/*
	 * Video 22
	 */
	public List<Message> getAllMessagesPaginated(int start, int size) {
		
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		
		// Validation
		if (start + size > list.size()) return new ArrayList<Message>();
		
		return list.subList(start, start + size);
	}
	
	
	
	public Message getMessage(long id) {
		
		return messages.get(id);
	}
	
	public Message addMessage(Message msg) {
		
		msg.setId(messages.size() + 1);
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message updateMessage(Message msg) {
		
		if(msg.getId() <= 0) {
			return null;
		}
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message removeMessage(long id) {
		
		return messages.remove(id);
	}
}











