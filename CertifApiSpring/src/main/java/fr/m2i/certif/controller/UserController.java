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

import fr.m2i.certif.model.User;
import fr.m2i.certif.service.UserService;

@RestController
@RequestMapping(path="/user")
public class UserController {

	@Autowired
	UserService userService;

	//GET List
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<User> getUsers(){

		return userService.getAll();
	}


	//GET By Id
	@GetMapping(path = "/find/{id}", produces = {"application/json"})
		public Optional<User> getUser(@PathVariable("id") Long id) {

		return userService.getById(id);
	}

	
	//POST create
	@PostMapping(path = "/post", 
			consumes = { "application/json" } 
	)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void postUser(@RequestBody User user) {

		userService.saveObject(user);
	}
	
	
	//PUT update
	@PutMapping(path = "/put/{id}", 
			produces = { "application/json" },
			consumes = { "application/json" } 
	)
	public void modifUser(@PathVariable("id") Long id, @RequestBody User newUser) {
		
		User user = userService.getById(id).get();
		user.setLastname(newUser.getLastname());
		user.setFirstname(newUser.getFirstname());
		user.setPseudo(newUser.getPseudo());
		user.setEmail(newUser.getEmail());		
		
		userService.saveObject(user);
	}
	
	
	//DELETE By Id
	@DeleteMapping(path = "/delete/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void deleteUser(@PathVariable("id") Long id) {

		userService.deleteObject(id);
		System.out.println("user effacé");

	}

}