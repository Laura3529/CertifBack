package fr.m2i.certif.model;

import java.io.Serializable;

import lombok.Data;


@Data
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	private Long id;
	private String lastname;
	private String firstname;
	private String pseudo;
	private String email;
	private String password;
	
	

	public String toString() {
		return this.id + " : " + this.lastname + " " + this.firstname + " " + this.pseudo + " " + this.email + " " + this.password;
	}
}
