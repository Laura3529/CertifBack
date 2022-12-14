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

import fr.m2i.certif.model.Channel;
import fr.m2i.certif.model.Message;
import fr.m2i.certif.service.ChannelService;
import fr.m2i.certif.service.MessageService;

@RestController
@RequestMapping(path="/channel")
public class ChannelController {

	@Autowired
	ChannelService channelService;
	
	@Autowired
	MessageService messageService;
	
//	 lien avec les messages
	@GetMapping(path = "/listMessages/{id}", produces = {"application/json"})
	public List<Message> getMessagesChannel(@PathVariable("id") Long id){
		return channelService.getMessages(id);
	}
	
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<Channel> getChannels(){
		
		return channelService.getAll();
	}
	
	@GetMapping(path = "/find/{id}", produces = {"application/json"})
	public Optional<Channel> getChannel(@PathVariable("id") Long id) {

		return channelService.getById(id);
	}


	@PostMapping(path = "/post", 
			consumes = { "application/json" }
				)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void postChannel(@RequestBody Channel channel) {

		channelService.saveObject(channel);
	}
	
	

	@PutMapping(path = "/put/{id}", 
			produces = { "application/json" },
			consumes = { "application/json" } 
		)
	public void modifChannel(@PathVariable("id") Long id, @RequestBody Channel newChannel) {
			
		Channel channel = channelService.getById(id).get();
		channel.setName(newChannel.getName());
		channel.setCreatedAt(newChannel.getCreatedAt());
		channel.setUpdatedAt(newChannel.getUpdatedAt());
		channel.setDescription(newChannel.getDescription());		
		
		channelService.saveObject(channel);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void deleteChannel(@PathVariable("id") Long id) {

		channelService.deleteObject(id);
	}
	
}