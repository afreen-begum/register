package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//http://localhost:8080/customer/data
@CrossOrigin("*")
@RequestMapping("/music")
public class RegisterController {

	@GetMapping("/get")
	public ResponseEntity<?> getCustomerDetails() {
	    ResponseEntity<?> responseEntity = null;
	    try {
	        List<Register> user = userServiceImpl.getallUsers();
	        responseEntity = ResponseEntity.status(HttpStatus.OK).body(user);
	    } catch (Exception e) {
	        responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        e.printStackTrace();
	    }
	    return responseEntity;
	}

	
	@Autowired
	private RegisterServiceImpl userServiceImpl;
	private ResponseEntity responseEntity;

	@PostMapping("/register")
	public ResponseEntity<?> saveCustomer(@RequestBody Register user)
	        throws RegisterAlreadyExistsException{
	    try {
	        Register createdUser = userServiceImpl.saveuser(user);
	        responseEntity = new ResponseEntity<>(createdUser,
	                HttpStatus.CREATED);
	    } catch (RegisterAlreadyExistsException e) {
	        
	    } catch(Exception e) {
	        responseEntity =
	                new ResponseEntity<>("Some internal Error Occured.."
	        + e, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    
	    return responseEntity;
	}
	@PutMapping("update/name")
	//to update the track
	public ResponseEntity<?> updateUserByName ( @PathVariable String email, @RequestBody Register user)throws UserNotFoundException {
		//try {
		responseEntity = new ResponseEntity(userServiceImpl.updateUserByName(email, user), HttpStatus.OK);
		 //} catch (Exception e) {
		//responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		 //}
		return responseEntity;
	}


}
