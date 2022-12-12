package fr.m2i.certif.service;


import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import fr.m2i.certif.model.Channel;


@Service
public class ChannelService extends ObjectService<Channel> {
	
	@Override
	public void saveObject(Channel c) {

		LocalDateTime defaultDate = LocalDateTime.now();
		
		if(c.getCreatedAt() == null) {
			c.setCreatedAt(defaultDate);
		}
		
		if(c.getUpdatedAt() == null) {
			c.setUpdatedAt(defaultDate);
		}
		super.saveObject(c);
	}
}