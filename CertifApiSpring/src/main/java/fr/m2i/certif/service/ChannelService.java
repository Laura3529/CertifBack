package fr.m2i.certif.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.m2i.certif.model.Channel;
import fr.m2i.certif.repository.ChannelRepository;

@Service
public class ChannelService {

	@Autowired
	ChannelRepository cr;

	public List<Channel> getAll() {
		return cr.findAll();
	}
	
	public Optional<Channel> getChannelById(Long id) { 
		Optional<Channel> channel = cr.findById(id);
		return channel;
	}


	public void saveChannel(Channel channel) {
		cr.save(channel);
	}

	//Pas utilise pour le moment
		public void saveChannel(String name, LocalDateTime createdAt, LocalDateTime updatedAt, String description) {
			Channel channel = new Channel();
			channel.setName(name);
			channel.setCreatedAt(createdAt);
			channel.setUpdatedAt(updatedAt);
			channel.setDescription(description);
			
			cr.save(channel);
		}
	
	public void deleteChannel(Long id) {
		cr.deleteById(id);
	}
}