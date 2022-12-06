package fr.m2i.certif.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.m2i.certif.model.Message;
import fr.m2i.certif.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	MessageRepository mr;
	
	public List<Message> getAll(){
		return mr.findAll();
	}

	public Optional<Message> getMessageById(Long id) { 
		Optional<Message> message = mr.findById(id);
		return message;
	}
	
	public void saveMessage(Message message) {
		mr.save(message);
	}
	
	public void saveUser(String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
		Message message = new Message();
		message.setContent(content);
		message.setCreatedAt(createdAt);
		message.setUpdatedAt(updatedAt);

		mr.save(message);
	}
	
	public void deleteMessage(Long id) {
		mr.deleteById(id);
	}
}