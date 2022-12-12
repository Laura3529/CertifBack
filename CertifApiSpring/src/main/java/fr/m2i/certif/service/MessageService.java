package fr.m2i.certif.service;


import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import fr.m2i.certif.model.Message;

@Service
public class MessageService extends ObjectService<Message> {

	@Override
	public void saveObject(Message t) {

		LocalDateTime defaultDate = LocalDateTime.now();
		
		if(t.getCreatedAt() == null) {
			t.setCreatedAt(defaultDate);
		}
		
		if(t.getUpdatedAt() == null) {
			t.setUpdatedAt(defaultDate);
		}
		super.saveObject(t);
	}
	
	
}