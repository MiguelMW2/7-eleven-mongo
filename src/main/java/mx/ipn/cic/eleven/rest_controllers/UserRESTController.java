package mx.ipn.cic.eleven.rest_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.ipn.cic.eleven.entities.UserEntity;
import mx.ipn.cic.eleven.services.UserService;

@Controller
@RequestMapping(path="/rest/user")
public class UserRESTController {

	@Autowired
	private UserService userService;

	@GetMapping(path="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserEntity>> allUsers() {
		ResponseEntity<List<UserEntity>> response;
		try {
			List<UserEntity> foundUsers = this.userService.allUsers();
			response = new ResponseEntity<List<UserEntity>>(foundUsers, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<List<UserEntity>>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return response;
	}

	@GetMapping(path="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> findById(@PathVariable(name="id") String id) {
		ResponseEntity<UserEntity> response;
		try {
			UserEntity found = this.userService.findById(id);
			response = new ResponseEntity<UserEntity>(found, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<UserEntity>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return response;
	}

	@PostMapping(path="/save", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> save(@RequestBody UserEntity user) {
		ResponseEntity<UserEntity> response;
		try {
			this.userService.register(user);
			response = new ResponseEntity<UserEntity>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			response = new ResponseEntity<UserEntity>(HttpStatus.NOT_ACCEPTABLE);
		}
		return response;
	}

	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable(name="id") String id) {
		ResponseEntity<Boolean> response;
		try {
			boolean deleted = this.userService.delete(id);
			response = new ResponseEntity<Boolean>(deleted, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<Boolean>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return response;
	}

	@PutMapping(path="/save/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> edit(
			@RequestBody UserEntity user,
			@PathVariable(name="id") String id) {
		user.setId(id);
		ResponseEntity<UserEntity> response;
		try {
			this.userService.register(user);
			response = new ResponseEntity<UserEntity>(user, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<UserEntity>(HttpStatus.NOT_MODIFIED);
		}
		return response;
	}
}