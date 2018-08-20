package mx.ipn.cic.eleven.repositories;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.ipn.cic.eleven.entities.UserEntity;

@Service
public class UserRestService {

	public List<UserEntity> findAll() {
		UserEntity[] users = null;
		try {
			String strUri = "http://localhost:8080/rest/user/all";
			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(strUri);
			RequestEntity<Object> requestEntity = new RequestEntity<Object>(HttpMethod.GET, uri);
			ResponseEntity<UserEntity[]> response = restTemplate.exchange(requestEntity, UserEntity[].class);
			users = response.getBody();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return Arrays.asList(users);
	}

	public UserEntity findById(Integer id) {
		UserEntity user = null;
		try {
			String strUri = "http://localhost:8080/rest/user/" + id;
			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(strUri);
			RequestEntity<UserEntity> requestEntity = new RequestEntity<UserEntity>(HttpMethod.GET, uri);
			ResponseEntity<UserEntity> response = restTemplate.exchange(requestEntity, UserEntity.class);
			user = response.getBody();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return user;
	}

	public UserEntity save(UserEntity user) {
		try {
			String strUri = "http://localhost:8080/rest/user/save";
			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(strUri);
			RequestEntity<UserEntity> requestEntity = new RequestEntity<UserEntity>(user, HttpMethod.POST, uri);
			ResponseEntity<UserEntity> response = restTemplate.exchange(requestEntity, UserEntity.class);
			user = response.getBody();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return user;
	}

	public UserEntity update(UserEntity user) {
		try {
			String strUri = "http://localhost:8080/rest/user/save" + user.getId();
			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(strUri);
			RequestEntity<UserEntity> requestEntity = new RequestEntity<UserEntity>(user, HttpMethod.PUT, uri);
			ResponseEntity<UserEntity> response = restTemplate.exchange(requestEntity, UserEntity.class);
			user = response.getBody();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return user;
	}

	public void delete(Integer id) {
		try {
			String strUri = "http://localhost:8080/rest/user/delete" + id;
			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(strUri);
			RequestEntity<Object> requestEntity = new RequestEntity<Object>(HttpMethod.DELETE, uri);
			ResponseEntity<Boolean> response = restTemplate.exchange(requestEntity, Boolean.class);
			if(response.getBody()) {
				
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
