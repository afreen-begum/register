package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Register {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FAVID")
	private int fav_id;

	@Column(name = "FIRSTNAME")
	private String firstname;
	@Column(name="LASTNAME")
	private String lastname;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "CONFIRMPASSWORD")
	private String confirmpassword;
	@Column(name = "EMAIL")
	private String email;
	@Lob
	@Column(name = "IMAGE")
	private byte[] image;



	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Register(String firstname, String lastname, String password, String confirmpassword, String email, byte[] image) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.email = email;
		this.image = image;
	}

	public Register() {
	}
}