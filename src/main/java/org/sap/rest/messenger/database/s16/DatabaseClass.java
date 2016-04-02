package org.sap.rest.messenger.database.s16;

import java.util.HashMap;
import java.util.Map;

import org.sap.rest.messenger.model.s14.Message;
import org.sap.rest.messenger.model.s14.Profile;

// Not Thread Safe, don't use this production, Fake Back end
public class DatabaseClass {

	// Similar to Storing Message and Profile as Entities into DB
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	
}
