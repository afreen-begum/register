package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl{
	@Autowired
	private RegisterRepository repo;

	public Register saveuser(Register user) throws RegisterAlreadyExistsException {

		Register createduser=null;
		//optional check whether the value is null or not --> it return true or false --> so check in if condition ispresent()
//		Optional<Register> optional=repo.findByemail(customer.getEmail());
//		if(optional.isPresent()) {
//			throw new RegisterAlreadyExistsException();
//		}
//		else {
			createduser=repo.save(user);
//		}
		return createduser;
	}

	public List<Register> getallUsers() {
		// TODO Auto-generated method stub
		List<Register> custlist=new ArrayList<>();
		//foreach --> lamda expression we used
		repo.findAll().forEach(custlist::add);
		return custlist;
	}
	public Register updateUserByName(String name, Register user) throws UserNotFoundException {
		Register upd = new Register;
		if (!upd.findByName(name).isPresent()){

			throw new UserNotFoundException("User Not Found");
		}
		Register update =upd.findByName(name).get();
		update.setFirstname(user.getFirstname());
		update.setLastname(user.getLastname());
		update.setPassword(user.getPassword());
		update.setEmail(user.getEmail());

		update=repo.save(user);
		return update;


	}

}
