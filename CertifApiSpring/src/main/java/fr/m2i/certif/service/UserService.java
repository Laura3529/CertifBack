package fr.m2i.certif.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.m2i.certif.model.User;
import fr.m2i.certif.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository ur;

	public List<User> getAll(){
		return ur.findAll();
	}
	
	public Optional<User> getUserById(Long id) { 
		Optional<User> user = ur.findById(id);
		return user;
	}

	

	public void saveUser(User user) {
		ur.save(user);
	}
	

	//Pas utilise pour le moment
	public void saveUser(String lastname, String firstname, String pseudo, String email, String password) {
		User user = new User();
		user.setLastname(lastname);
		user.setFirstname(firstname);
		user.setPseudo(pseudo);
		user.setEmail(email);
		user.setPassword(password);
		ur.save(user);
	}
	

	public void deleteUser(Long id) {
		ur.deleteById(id);
	}
	


}