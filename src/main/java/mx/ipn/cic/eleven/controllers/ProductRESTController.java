package mx.ipn.cic.eleven.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.ipn.cic.eleven.entities.ProductEntity;
import mx.ipn.cic.eleven.services.ProductService;

@RestController
@RequestMapping(path="/rest/product")
public class ProductRESTController {

	@Autowired
	private ProductService productService;

	@GetMapping(path="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductEntity>> allUsers() {
		ResponseEntity<List<ProductEntity>> response;
		try {
			List<ProductEntity> foundUsers = this.productService.allProducts();
			response = new ResponseEntity<List<ProductEntity>>(foundUsers, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<List<ProductEntity>>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return response;
	}

	@GetMapping(path="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductEntity> findById(@PathVariable(name="id") String id) {
		ResponseEntity<ProductEntity> response;
		try {
			ProductEntity found = this.productService.findById(id);
			response = new ResponseEntity<ProductEntity>(found, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<ProductEntity>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return response;
	}

	@GetMapping(path="/search/{name}/{upc}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductEntity>> search(
			@PathVariable(name="name") String name,
			@PathVariable(name="upc") String upc
			/*RequestBody*/
	) {
		ResponseEntity<List<ProductEntity>> response;
		try {
			List<ProductEntity> foundProducts = this.productService.search(name, upc);
			response = new ResponseEntity<List<ProductEntity>>(foundProducts, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<List<ProductEntity>>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return response;
	}

	@PostMapping(path="/save", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductEntity> save(@RequestBody ProductEntity product) {
		ResponseEntity<ProductEntity> response;
		try {
			this.productService.save(product);
			response = new ResponseEntity<ProductEntity>(product, HttpStatus.CREATED);
		} catch (Exception e) {
			response = new ResponseEntity<ProductEntity>(HttpStatus.NOT_ACCEPTABLE);
		}
		return response;
	}

	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable(name="id") String id) {
		ResponseEntity<Boolean> response;
		try {
			boolean deleted = this.productService.delete(id);
			response = new ResponseEntity<Boolean>(deleted, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<Boolean>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return response;
	}

	@PutMapping(path="/save/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductEntity> edit(
			@RequestBody ProductEntity product,
			@PathVariable(name="id") String id) {
		product.setId(id);
		ResponseEntity<ProductEntity> response;
		try {
			this.productService.save(product);
			response = new ResponseEntity<ProductEntity>(product, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<ProductEntity>(HttpStatus.NOT_MODIFIED);
		}
		return response;
	}
}
