package fr.m2i.certif.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.m2i.certif.model.Message;
import fr.m2i.certif.service.MessageService;

@RestController
@RequestMapping(path="/message")
public class MessageController {

	@Autowired
	MessageService messageService;
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<Message> getMessages(){
		
		return messageService.getAll();
	}
	
	@GetMapping(path = "/find/{id}", produces = {"application/json"})
	public Optional<Message> getMessage(@PathVariable("id") Long id) {

	return messageService.getById(id);
	}

	@PostMapping(path = "/post", 
			consumes = { "application/json" } 
	)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void postMessage(@RequestBody Message message) {

		messageService.saveObject(message);
	}
	
	@PutMapping(path = "/put/{id}", 
			produces = { "application/json" },
			consumes = { "application/json" } 
	)
	public void modifMessage(@PathVariable("id") Long id, @RequestBody Message newMessage) {
		
		Message message = messageService.getById(id).get();
		message.setContent(newMessage.getContent());
		message.setCreatedAt(newMessage.getCreatedAt());
		message.setUpdatedAt(newMessage.getUpdatedAt());		
		
		messageService.saveObject(message);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void deleteMessage(@PathVariable("id") Long id) {

		messageService.deleteObject(id);
		System.out.println("message effacé");

	}
	
}