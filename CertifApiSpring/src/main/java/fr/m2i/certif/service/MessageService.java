package fr.m2i.certif.service;


import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import fr.m2i.certif.model.Message;

@Service
public class MessageService extends ObjectService<Message> {

	@Override
	public void saveObject(Message m) {

		LocalDateTime defaultDate = LocalDateTime.now();
		
		if(m.getCreatedAt() == null) {
			m.setCreatedAt(defaultDate);
		}
		
		if(m.getUpdatedAt() == null) {
			m.setUpdatedAt(defaultDate);
		}
		super.saveObject(m);
	}
	
	
}