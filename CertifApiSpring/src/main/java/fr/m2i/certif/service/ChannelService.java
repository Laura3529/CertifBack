package fr.m2i.certif.service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.m2i.certif.model.Channel;
import fr.m2i.certif.model.Message;


@Service
public class ChannelService extends ObjectService<Channel> {
	
	@Autowired
	MessageService messageService;
	//public JpaRepository<Message, Long> messageRepository;
	
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
	
	public List<Message> getMessages(Long id) {
		List<Message> messages = new ArrayList<Message>();
		List<Message> messagesChannel = new ArrayList<Message>();
		
		messages = messageService.getAll();
		for(Message m : messages) {
			if(id == m.getChannel().getId()) {
				messagesChannel.add(m);
			}
		}
		
		return messagesChannel;
	}
}