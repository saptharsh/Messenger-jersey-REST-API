package org.sap.rest.messenger.service.s14;

import java.util.ArrayList;
import java.util.List;

import org.sap.rest.messenger.model.s14.Message;

public class MessageService {

	// Usually we return from the database
	public List<Message> getAllMessages(){
		
		Message m1 = new Message(1L, "Whatsapp Mumbai", "Being Indian");
		Message m2 = new Message(2L, "Namma Bengaluru", "Being Kannadiga");
		
		List<Message> list = new ArrayList<Message>();
		list.add(m1);
		list.add(m2);
		
		return list; 
	}
	
}
